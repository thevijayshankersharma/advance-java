package insertintodb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InsertingData extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Service() is called");
        
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double sal = Double.parseDouble(req.getParameter("sal"));
        String gender = req.getParameter("gender");

        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps","root","root");
            ps = con.prepareStatement("insert into emp values (?,?,?,?)");
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, sal);
            ps.setString(4, gender);

            ps.executeUpdate();
            
            System.out.println("Record has been added to database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
