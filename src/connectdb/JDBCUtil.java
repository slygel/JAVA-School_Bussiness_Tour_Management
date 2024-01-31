package connectdb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class JDBCUtil {
    
    private static String url = "jdbc:mysql://localhost:3306/bussiness_tour_management";
    private static String username = "root";
    private static String password = "1504";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
