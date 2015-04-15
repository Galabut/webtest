package hw8.taxi.action;

import hw8.taxi.dao.ClientDaoImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Galabut on 23.01.2015.
 */
@WebServlet("/Client")
public class ClientServlet extends HttpServlet {
    private ClientService clientService;
    private ApplicationContext context = new ClassPathXmlApplicationContext("hw8/context-taxi.xml");

    public ClientServlet() {
        clientService = context.getBean("ClientServiceImpl", ClientService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choice = req.getParameter("Clientreport");
        System.out.println(choice);
        switch (choice) {
            case "Register New Client": {
                req.getRequestDispatcher("/registerClient.jsp").forward(req, resp);
            }
            break;
            case "Show Clients by Portion": {
                String portion = req.getParameter("portion");
                System.out.println(portion);
                Integer portionInt = Integer.parseInt(portion);
                List<Client> clients = clientService.showClientsByPortion(portionInt);
                req.setAttribute("portion", clients);
                req.getRequestDispatcher("/clients.jsp").forward(req, resp);
            }
            break;
            case "Show Clients by SUM": {
                String sum = req.getParameter("sum");
                Integer sumInt = Integer.parseInt(sum);
                List<Client> clients = clientService.showClientsGtSum(sumInt);
                req.setAttribute("sum", clients);
                req.getRequestDispatcher("/clients.jsp").forward(req, resp);
            }
            break;
            case "Show Clients of Last Month": {
                List<Client> clients = clientService.showClientsLastMonth();
                req.setAttribute("month", clients);
                req.getRequestDispatcher("/clients.jsp").forward(req, resp);
            }
            break;
            default: {
                req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
            }
        }

    }
}
