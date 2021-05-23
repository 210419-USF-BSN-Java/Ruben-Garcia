package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import model.Reimbursement;
import model.User;
import service.EmployeeServices;
import service.ManagerService;
import service.UserLoginService;

@WebServlet(value="/getAllPendingRequests") 
public class ManagerShowPendingRequestServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ManagerService ms = new ManagerService(); 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Reimbursement> pendingRequest = ms.viewAllPendingRequest();
		ObjectMapper obj = new ObjectMapper();
		String jsonFormat = obj.writeValueAsString(pendingRequest); 
		PrintWriter out = response.getWriter(); 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonFormat);
		out.flush();
	}
}
