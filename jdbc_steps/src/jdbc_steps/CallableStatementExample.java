package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class CallableStatementExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");
        CallableStatement cst = con.prepareCall("insert into emp values(?, ?, ?);");
        
        cst.setInt(1, 111);
        cst.setString(2, "Minato");
        cst.setDouble(3, 50000);
        
        cst.execute();
        
        System.out.println("Inserted...");
    }
}
