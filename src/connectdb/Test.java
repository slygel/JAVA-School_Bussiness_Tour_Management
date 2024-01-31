package connectdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtil.getConnection();
            
            Statement st = connection.createStatement();
            
            String sql = "SELECT * FROM tbl_tour";
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
            
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
