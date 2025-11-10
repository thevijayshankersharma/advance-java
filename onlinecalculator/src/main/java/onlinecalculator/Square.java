package onlinecalculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Square extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sq = Integer.parseInt(req.getParameter("sq"));
		PrintWriter pw = resp.getWriter();
		
		pw.println("<h1>The square of sum is " + sq*sq + "</h1>");
		
		pw.println("<h1>The sum of two number is " + sq + "</h1>"
				+ "<h1>Click the below button to get square of sum</h1>"
				+ "<button>Square</button>");
		
		pw.println("<h1 id='head'>The square of sum is " + sq*sq + "</h1>");
	}

}
