package hw8.taxi.action;

import hw8.taxi.dao.OperatorDao;
import hw8.taxi.domain.Operator;
import hw8.taxi.exception.AuthorizationException;
import hw8.taxi.service.AuthenticationService;
import hw8.taxi.service.AuthenticationServiceImpl;
import hw8.taxi.service.AuthorizationService;
import hw8.taxi.service.AuthorizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Galabut on 22.01.2015.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private AuthorizationService authorizationService;
    private ApplicationContext context =  new ClassPathXmlApplicationContext("hw8/context-taxi.xml");

    @Autowired
    private OperatorDao dao;

    public RegisterServlet() {
        authorizationService = context.getBean("AuthorizationServiceImpl", AuthorizationService.class);
        dao=context.getBean("OperatorDaoImpl",OperatorDao.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userNameReg = parameterMap.get("login")[0];
        String userPwdReg = parameterMap.get("password")[0];
        String userId = parameterMap.get("id")[0];
        String newUserPwdReg = parameterMap.get("password")[1];

        try {
            boolean operatorToAdd = authorizationService.register(userNameReg, userId, userPwdReg);
            if (userPwdReg.equals(newUserPwdReg)) {
                req.setAttribute("greetingNEW", "You have registered successfully!");
                req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
            } else if (!userPwdReg.equals(newUserPwdReg)) {
                req.setAttribute("error", "Your passwords are not the same! Try again");
                req.getRequestDispatcher("/Register.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("/Register.jsp").forward(req, resp);
        }
    }
}