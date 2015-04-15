package controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 9/8/13
 */
@WebServlet("/ajax")
public class AjaxHello extends HttpServlet {
//    private WebApplicationContext context;

    @Override
    public void init() {
//        context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "{\"name\":\"alex\",\"nickname\":\"al1\"}";
        response.setContentType("application/json");
//            PrintWriter out = response.getWriter();

        JSONArray jsonArray= new JSONArray();

        ArrayList<String>names=new ArrayList<>();
        names.add("Alex1");
        names.add("Alex2");
        names.add("Alex3");
        names.add("Alex4");
        names.add("Alex5");

        ArrayList<String>nicknames =new ArrayList<>();
        nicknames.add("al2");
        nicknames.add("al3");
        nicknames.add("al4");
        nicknames.add("al5");
        nicknames.add("al6");
        try {
            for (int i = 0; i <names.size() ; i++) {
                jsonArray.put(i,names.get(i));
            }
            for (int i = 0; i <nicknames.size() ; i++) {
                jsonArray.put(i,nicknames.get(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
//            System.out.println(jsonObj.get("message"));
//            JSONObject obj = new JSONObject();
//            obj.put("message", "hello from server");
        response.getWriter().print(jsonArray.toString());
    }
}
