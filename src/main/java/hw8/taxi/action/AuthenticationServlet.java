package hw8.taxi.action;


import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthenticationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Оператор вводит логин и пароль.
 * Если пароль с логином не совпадает то повторить ввод. Передача осуществляется методом POST.
 * Колличество попыток ввода задается в properties файле. После последней неудачной попытки пользователь блокируется.
 * Время действия пароля задается в сервисе
 * После истечения действия пароля, пользователь должен поменять пароль. Предыдущий вводить нельзя
 */
@WebServlet("/auth")
public class AuthenticationServlet extends HttpServlet {
    private AuthenticationService authenticationService;
    private ApplicationContext context =  new ClassPathXmlApplicationContext("hw8/context-taxi.xml");

    @Autowired
    private OperatorDao dao;

    public AuthenticationServlet() {
        authenticationService = context.getBean("AuthenticationServiceImpl", AuthenticationService.class);
        dao=context.getBean("OperatorDaoImpl",OperatorDao.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale.setDefault(Locale.ENGLISH);
        if (context != null) {
            Map<String, String[]> parameterMap = req.getParameterMap();
            String userName = parameterMap.get("login")[0];
            String userPwd = parameterMap.get("password")[0];
            boolean authenticationCheck;
            boolean passwordCheck = false;
            String message;
            try {
                 authenticationCheck = authenticationService.authenticate(userName, userPwd);
                if (authenticationCheck) {
                    passwordCheck = authenticationService.passwordTermsOfValidation(userName);
                }
                if (passwordCheck) {
                    req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
                } else {
                    req.setAttribute("expiration", "Your password has expired! You need to enter a new one!");
                    //AuthenticationServiceImpl.usersMap.remove(userName);
                    Operator operatorToRemove = authenticationService.findOperator(userName);
                    dao.delete(operatorToRemove);
                    req.getRequestDispatcher("/Register.jsp").forward(req, resp);
                }
            } catch (AuthenticationException e) {
                message = e.getMessage();
                req.setAttribute("error", message);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } else {
            resp.getWriter().print("Error: Context not found!");
        }

    }
}

