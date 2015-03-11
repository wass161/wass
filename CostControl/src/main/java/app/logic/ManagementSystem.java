package app.logic;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vbrovkin
 * Date: 18.02.15
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class ManagementSystem {
    private static Connection con = null;
    private static ManagementSystem instance;
    private static DataSource dataSource;

    private ManagementSystem() throws ClassNotFoundException, SQLException {
    }

    public static synchronized ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
            Context ctx = new InitialContext();
            instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/CostControlDS");
            con = dataSource.getConnection();
        }

        return instance;
    }

    /**
     * Метод получения списка групп из БД
      * @return listGroup
     * @throws SQLException
     */
    public List<Groups> getGroups() throws SQLException{
        List<Groups> listGroups = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, fd from groups");

            while(rs.next()){
                Groups groups = new Groups();
                groups.setId(rs.getInt(1));
                groups.setName(rs.getString(2));
                groups.setFd(rs.getDate(3));

                listGroups.add(groups);
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
        }
        return listGroups;
    }

    /**
     * Метод получения пунктов растрат по id группы
     * @param id
     * @return
     * @throws SQLException
     */
    public List<ItemCosts> getItemsByIdGroups(int id) throws SQLException{
        List<ItemCosts> listItems = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, cash, fd from items where id_group=" + id);

            while(rs.next()){
                ItemCosts item = new ItemCosts();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setCash(rs.getInt(3));
                item.setFd(rs.getDate(4));
                listItems.add(item);
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
        }
        return listItems;
    }

    /**
     * Метод добавление новой группы расходов
     * @param name имя группы
     * @throws SQLException
     */
    public void addGroup(String name) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("insert into groups(name, fd) values ('" + name + "', now())");

        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
        }
    }

    public void addItem(String name, int cash, int group_id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("insert into groups(name, fd) values ('" + name + "', now())");

        } finally {
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
        }
    }


}
