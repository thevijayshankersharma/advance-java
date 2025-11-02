package firstservletproject;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service is called");
		
		String fN = req.getParameter("fn");
		String lN = req.getParameter("ln");
		int age = Integer.parseInt(req.getParameter("ag"));
		
		System.out.println("First Name: "+fN + "\nLast Name: "+lN +"\nAge: "+age);
	}
	
}
