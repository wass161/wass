package app.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 17.02.15
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 */
public class AppServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse res){
        res.setContentType("text/html;charset=utf-8");
        try {
           List groups = new ArrayList();
           testJSP test = new testJSP();
            test.setName("mimimi");
            test.setId(1);

            groups.add(test);


            req.setAttribute("groups", groups);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
