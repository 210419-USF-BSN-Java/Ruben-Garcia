package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegates.EmployeeDelegate;
import delegates.ManagerDelegate;
import delegates.ReimbursementsDelegate;
import delegates.UserLoginDelgate;

public class RequestHelper {
	EmployeeDelegate em = new EmployeeDelegate(); 
	ManagerDelegate mn = new ManagerDelegate();
	UserLoginDelgate ul = new UserLoginDelgate(); 
	ReimbursementsDelegate rm = new ReimbursementsDelegate(); 
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		
		uriString.replace(0, request.getContextPath().length() +1, "");
		
		if (uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
		}
		
		switch(uriString.toString()) {
		case "manager":
			mn.process(request,response);
			break; 
		case "employee":
			em.process(request, response);
			break; 
		case "login":
			ul.process(request, response);
			break; 	
		case "reimbursements":
			rm.process(request, response);
			break; 	
		default: 
			response.sendError(404, "path not supported");
		}
	}
}
