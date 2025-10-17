package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
	public static void main(String[] args) {
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");
            System.out.println("Connection established");
            
            Statement st = con.createStatement();
            
//          Deleting single row
//          int rows = st.executeUpdate("delete from emp where eid=101");
            
//          Deleting multiple rows
            int rows = st.executeUpdate("delete from emp where esal>25000");
            System.out.println(rows + " records Deleted successfully");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
