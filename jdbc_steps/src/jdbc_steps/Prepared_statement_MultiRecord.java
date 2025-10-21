package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prepared_statement_MultiRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=root");
            System.out.println("Connection established");

            PreparedStatement ps = con.prepareStatement("insert into emp values (?, ?, ?)");

            System.out.print("How many records do you want to insert? ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("\nRecord " + i + ":");

                System.out.print("Enter the eid: ");
                int id = sc.nextInt();

                System.out.print("Enter the ename: ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Enter the esal: ");
                double sal = sc.nextDouble();

                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, sal);
                ps.execute();
            }

            System.out.println("\nData added successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
