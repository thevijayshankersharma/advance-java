package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch_Record_2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");

        PreparedStatement pStatement = connection.prepareStatement("select * from emp where esal > ?");

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the salary:");
        double sal = scanner.nextDouble();
        pStatement.setDouble(1, sal);
        
        ResultSet rSet = pStatement.executeQuery();
        while (rSet.next()) {
            System.out.println(rSet.getInt(1) + "\t" + rSet.getString(2) + "\t\t" + rSet.getDouble(3));
        }
        */

        System.out.println("*****************************");
        
        PreparedStatement ps2 = connection.prepareStatement("select ename from emp where esal >= 10000 and esal < 200000");
        ResultSet rs2 = ps2.executeQuery();

        while (rs2.next()) {
            System.out.println(rs2.getString(1));
        }
    }
}
