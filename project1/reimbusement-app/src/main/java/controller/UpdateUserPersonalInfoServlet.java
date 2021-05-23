package controller;
import service.EmployeeServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(value="/reimbursement_submit")
public class UpdateUserPersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	EmployeeServices es = new EmployeeServices();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
		PrintWriter out = response.getWriter(); 
		//TODO 
		//get user session data for reimbursement post from front end; mix object from employeeinit to the reimbursement object
		ObjectMapper objectMapper = new ObjectMapper();
		String requestData = request.getReader().lines().collect(Collectors.joining()); //from stack overflow lol: https://stackoverflow.com/questions/1548782/retrieving-json-object-literal-from-httpservletrequest
		System.out.println(requestData);
		try {
			Reimbursement reim = objectMapper.readValue(requestData, Reimbursement.class); 
			//pass mapped object to the submit reimbursement service
			//having issues where values not specificed are given values e.g., I was dependent on the dao to give default values for null values in object
			EmployeeServices es = new EmployeeServices(); 
			Reimbursement createdItem = es.submitReimbursementRequest(reim); 
			System.out.println(reim); 
			System.out.println(createdItem); 
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
