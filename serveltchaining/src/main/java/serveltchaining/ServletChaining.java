package serveltchaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletChaining extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eid = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		double sal= Double.parseDouble(req.getParameter("sal"));
		String deg = req.getParameter("deg");
		String gen = req.getParameter("gen");
		String addr = req.getParameter("addr");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		Connection con =  null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details","root","root");
			
			ps = con.prepareStatement("Insert into student values (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, eid);
			ps.setString(2, name);
            ps.setDouble(3, sal);
            ps.setString(4, deg);
            ps.setString(5, gen);
            ps.setString(6, addr);
            ps.setString(7, email);
            ps.setString(8, pass);

            ps.executeUpdate();
            
            PrintWriter pw =  resp.getWriter();
            
            pw.println("<html><body>");
            pw.println("<h2>Account created successfully!</h2>");
            pw.println("<p>Welcome, " + name + "</p>");
            pw.println("<a href='login.html'>Click here to login</a>");
            pw.println("</body></html>");
            
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}

	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs= null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "root");
            
            String email = req.getParameter("email");
    		String pass = req.getParameter("pass");
    		
    		

            ps = con.prepareStatement("select pass from student where email=?");
            
            ps.setString(1, email);
            
            rs = ps.executeQuery();
            
            rs.next();
            if(rs.getString("pass").equals(pass) ) {
            	RequestDispatcher rd = req.getRequestDispatcher("home.html");
            	rd.forward(req, resp);
            } else {
            	PrintWriter pw =  resp.getWriter();
                
                pw.println("<html><body>");
                pw.println("<h2>Email or password is wrong!!</h2>");
                pw.println("</body></html>");
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
