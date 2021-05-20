package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserLoginService;

@WebServlet(value="/login") 
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserLoginService ul = new UserLoginService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		String user = request.getParameter("username");
		String password = request.getParameter("password"); 
		//only two possible choices, 1 is a manager role while 2 is an employee
		if(ul.validateAuth(user, password)) {
			if(ul.getRoleId(user) == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("manager_view.html");
				rd.forward(request, response);
			}
			if(ul.getRoleId(user) == 2) {
				RequestDispatcher rd = request.getRequestDispatcher("employee_view.html");
				rd.forward(request, response);
			}
		}else {
			out.print("<div>Sorry, wrong username or password</div>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		out.close();
	}
}
