package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("loaded.......");

            // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");
            Statement st = con.createStatement();

            boolean b = st.execute("insert into emp values (101,'Peter', 20000)");

            // executeUpdate() returns the number of rows affected by the SQL statement
            int rows = st.executeUpdate("insert into emp values (102,'Tony', 30000), (103, 'Steave',25000)");

            /*
             * executeUpdate() is used only for DML queries like INSERT, UPDATE, DELETE.
             * If used with other query types, it will throw an SQLException.
             */

            // System.out.println(b);
            System.out.println(rows);
            System.out.println("Records inserted successfully...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
