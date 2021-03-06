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

@WebServlet(value="/getEmployeeInfo") 
public class EmployeeViewInitServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserLoginService ul = new UserLoginService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			HttpSession session = request.getSession(false); 
			String username = (String)session.getAttribute("username");
			EmployeeServices es = new EmployeeServices();
			User user = es.viewEmployeeInfo(username);
			int userid = user.getId();
			int userRoleId = user.getUserRoleId(); 
			session.setAttribute("userObject", user);
			session.setAttribute("userId", userid);
			session.setAttribute("roleId", userRoleId);
			ObjectMapper obj = new ObjectMapper();
			String jsonFormat = obj.writeValueAsString(user);; //trying something different, via session to get user details for app access
			PrintWriter out = response.getWriter(); 
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonFormat);
			out.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
