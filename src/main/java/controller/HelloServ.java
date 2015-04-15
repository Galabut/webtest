package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 09.06.13
 */

public class HelloServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        request.setAttribute("name", "Al1");
        request.getRequestDispatcher("/indexCat.jsp").forward(request, response);
    }
}
