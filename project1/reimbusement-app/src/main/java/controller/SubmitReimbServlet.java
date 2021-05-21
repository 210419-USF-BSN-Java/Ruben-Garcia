package controller;
import service.EmployeeServices;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/reimbursement_submit")
public class SubmitReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	EmployeeServices es = new EmployeeServices();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
		PrintWriter out = response.getWriter(); 
		
		
	}
}
