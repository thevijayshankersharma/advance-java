package jdbc_steps;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClosingCostlyResources {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root", "root");
            st = con.createStatement();
            rSet = st.executeQuery("select * from emp");
            while (rSet.next()) {
                System.out.println(rSet.getInt(1) + "\t" + rSet.getString(2) + "\t" + rSet.getDouble(3));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rSet != null) {
                try {
                    rSet.close();
                    System.out.println("resultset closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                    System.out.println("statement is closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                    System.out.println("connection is closed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
