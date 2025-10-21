package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=root");
            System.out.println("Connection established");
            
            Statement st = con.createStatement();
            
//          Updating single row
//          int rows = st.executeUpdate("update emp set ename='Parker' where eid=101");
            
//          Updating multiple rows
            int rows = st.executeUpdate("update emp set esal=esal+1000 where esal>25000");
            System.out.println(rows + "rows updated successfully");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
