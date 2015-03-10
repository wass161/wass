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
            instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/ConstControlDS");
            con = dataSource.getConnection();
        }
        return instance;
    }

    public List<Groups> getGroups() throws SQLException{
        List<Groups> listGroups = new ArrayList<Groups>();
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

}
