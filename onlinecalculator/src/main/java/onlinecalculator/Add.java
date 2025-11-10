package onlinecalculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int sum = num1 + num2;
		
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<h1>The sum of two number is " + sum + "</h1>"
				+ "<h1>Click the below button to get square of sum</h1>"
				+ "<form action='sqr'>"
				+ "<input type='hidden' name='sq' value="+sum+ ">"
				+ "<button>Square</button> </form>");
	}
	
}
