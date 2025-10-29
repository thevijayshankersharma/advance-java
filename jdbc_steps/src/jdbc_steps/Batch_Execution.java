package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch_Execution {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pS = null;

        String q1 = "update emp set esal = ? where eid = ?";
        String q2 = "delete from emp where esal < ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");

            pS = con.prepareStatement(q1);
            pS.setDouble(1, 35000);
            pS.setInt(2, 101);
            pS.addBatch();

            pS.setDouble(1, 40000);
            pS.setInt(2, 102);
            pS.addBatch();

            pS = con.prepareStatement(q2);
            pS.setDouble(1, 25000);
            pS.addBatch();


            System.out.println("Batch execution completed.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pS != null) pS.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
