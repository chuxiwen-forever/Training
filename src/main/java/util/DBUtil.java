package util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        ResourceBundle resource = ResourceBundle.getBundle("db");
        driver = resource.getString("driver");
        url = resource.getString("url");
        username = resource.getString("username");
        password = resource.getString("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username ,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn,Statement statement ,ResultSet set){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (set != null){
            try {
                set.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection conn,Statement statement){
        close(conn, statement,null);
    }

    public static void close(Connection conn){
        close(conn,null);
    }
}
