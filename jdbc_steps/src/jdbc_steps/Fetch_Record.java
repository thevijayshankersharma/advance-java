package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetch_Record {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=root");

        Statement statement = connection.createStatement();
        ResultSet rSet = statement.executeQuery("select * from emp;");

        System.out.println("Eid \tEname \t\tEsal");
        while (rSet.next()) {
            System.out.println(rSet.getInt(1) + "\t" + rSet.getString(2) + "\t\t" + rSet.getDouble(3));
        }
        System.out.println("***************************************************");

        Statement statement2 = connection.createStatement();
        ResultSet rSet2 = statement2.executeQuery("select * from emp where esal > 100000");

        while (rSet2.next()) {
            System.out.println(rSet2.getInt(1) + "\t" + rSet2.getString(2) + "\t\t" + rSet2.getDouble(3));
        }
    }
}
