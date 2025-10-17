package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class TableCreation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver class is loaded and registered");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
            System.out.println("Connection established");
            
            Statement stmt = con.createStatement();
            System.out.println("statement created");
            
            boolean b = stmt.execute("create table demo.emp (eid int, ename varchar(40), esal double)");
            System.out.println("Table created successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
