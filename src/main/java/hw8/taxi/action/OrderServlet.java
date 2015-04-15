package hw8.taxi.action;

import hw8.taxi.dao.OrderDao;
import hw8.taxi.domain.Order;
import hw8.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Galabut on 07.02.2015.
 */
@WebServlet ("/Order")
public class OrderServlet extends HttpServlet {
    private OrderService orderService;
    private ApplicationContext context =  new ClassPathXmlApplicationContext("hw8/context-taxi.xml");

    @Autowired
    private OrderDao dao;

    public OrderServlet() {
        orderService = context.getBean("OrderServiceImpl", OrderService.class);
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
