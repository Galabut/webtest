package hw8.taxi.action;

import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Galabut on 06.02.2015.
 */
@WebServlet ("/RegisterClient")
public class ClientRegisterServlet extends HttpServlet {
    private ApplicationContext context =  new ClassPathXmlApplicationContext("hw8/context-taxi.xml");
    private ClientService clientService;

    public ClientRegisterServlet() {
        clientService = context.getBean("ClientServiceImpl", ClientService.class);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        String phone=req.getParameter("phone");
        String adress=req.getParameter("adress");
        try {
            boolean create=clientService.createClient(name,surname,phone,adress);
            req.setAttribute("success","You have successfully created a new client");
            req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
        } catch (ClientException e) {
            req.setAttribute("error","Such client already exists. Try again");
            req.getRequestDispatcher("registerClient.jsp").forward(req, resp);
        }
    }
}