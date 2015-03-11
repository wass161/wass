package app.web;

import app.logic.ItemCosts;
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
 * Date: 11.03.15
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
public class ItemsServlet extends HttpServlet{

    private int id;

    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=utf-8");
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            this.id = id;
            List<ItemCosts> itemCosts =  ManagementSystem.getInstance().getItemsByIdGroups(id);
            req.setAttribute("itemCosts",itemCosts);
        } catch (Exception e) {
        }
        req.getRequestDispatcher("/items.jsp").forward(req, res);
    }

    protected void processPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        String nameAddItem = req.getParameter("newItemName");
        String cashAddItem = req.getParameter("newItemCash");
        try {
            ManagementSystem.getInstance().addItem(nameAddItem, Integer.parseInt(cashAddItem), this.id);
        } catch (Exception e) {
        }
        doGet(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
