package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prepared_Statement {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=root");
            System.out.println("Connection established");

            PreparedStatement ps = con.prepareStatement("insert into emp values (?, ?, ?)");
            
            ps.setInt(1, 108);
            ps.setString(2, "Bruce");
            ps.setDouble(3, 300000);
//          ps.execute();

            ps.setInt(1, 109);
            ps.setString(2, "Natasha");
            ps.setDouble(3, 300000);
//          ps.execute();

            ps.setInt(1, 110);
            ps.setString(2, "Parker");
            ps.setDouble(3, 300000);
            ps.execute();

            System.out.println("Records inserted successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
