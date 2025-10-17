package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertRecord {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=root");
            System.out.println("Connection established");
            
            Statement st = con.createStatement();
            System.out.println("Statement created");
            
            int rows = st.executeUpdate("insert into emp values (101,'Peter', 20000), (102, 'Tony', 30000), (103, 'Steave', 25000), (104, 'Bruce', 28000), (105, 'Natasha', 32000)");
            System.out.println(rows + " records inserted successfully...");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
