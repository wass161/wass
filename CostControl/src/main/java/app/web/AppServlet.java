package app.web;


import app.logic.ManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        res.setCharacterEncoding("UTF-8");
        try {
            List groupsList = ManagementSystem.getInstance().getGroups();

            req.setAttribute("groupsList", groupsList);
            req.getRequestDispatcher("/index.jsp").forward(req, res);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void processPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String nameAddGroup = req.getParameter("newGroup");
        String[] delGroupsId = req.getParameterValues("delId");

        //добавление группы
        if (!(nameAddGroup == null)) {
            try {
                ManagementSystem.getInstance().addGroup(nameAddGroup);
            } catch (Exception e) {
            }
        }

        //удаление отмеченных групп
        if (!(delGroupsId == null)){
            for(String id : delGroupsId){
                try {
                    ManagementSystem.getInstance().delGroup(Integer.parseInt(id));
                } catch (Exception e) {
                }
            }
        }

        doGet(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(request, response);
        try {
            processPost(request, response);
        } catch (Exception e) {
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
