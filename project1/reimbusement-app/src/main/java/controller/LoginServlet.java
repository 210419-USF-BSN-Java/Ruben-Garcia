package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import service.EmployeeServices;
import service.UserLoginService;

@WebServlet(value="/login") 
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserLoginService ul = new UserLoginService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		//only two possible choices, 1 is a manager role while 2 is an employee
		
		if(ul.validateAuth(username, password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			//queries the user's information by the username inserted in the condition that they actually login
			/*
			EmployeeServices es = new EmployeeServices();
			User javaUserObject = es.viewEmployeeInfo(username); 
			ObjectMapper obj = new ObjectMapper();
			String jsonFormat = obj.writeValueAsString(javaUserObject);
			System.out.println(jsonFormat); //trying something different, via session to get user details for app access
			session.setAttribute("user", jsonFormat);
			*/
			if(ul.getRoleId(username) == 1) {
				response.sendRedirect(request.getContextPath() +"/static/manager_view.html");
			}
			if(ul.getRoleId(username) == 2) {
				response.sendRedirect(request.getContextPath() + "/static/employee_view.html");
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}
}
