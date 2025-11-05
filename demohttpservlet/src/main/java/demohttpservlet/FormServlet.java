package demohttpservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eid = Integer.parseInt(req.getParameter("eid"));
		String name = req.getParameter("name");
		double sal = Double.parseDouble(req.getParameter("sal"));

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            ps = con.prepareStatement("insert into emp values (?,?,?)");
            
            ps.setInt(1,eid);
            ps.setString(2, name);
            ps.setDouble(3, sal);

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
