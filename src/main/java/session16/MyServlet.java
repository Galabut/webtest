package session16;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Galabut on 23.12.2014.
 */

@WebServlet("/serv")
public class MyServlet extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        Map<String, String[]> parametrMap = request.getParameterMap();
        String[] name = parametrMap.get("name");
        String[] passwords = parametrMap.get("password");
        response.getWriter().print("Hello, " + name[0]);
        //response.getWriter().print("Hello, " + passwords[0]);
    }
}