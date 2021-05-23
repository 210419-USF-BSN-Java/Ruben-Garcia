package controller;
import service.ManagerService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/reimbursement_submit")
public class UpdateReimTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	ManagerService es = new ManagerService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
		HttpSession session = request.getSession(); 
		String manager_username = (String)session.getAttribute("username"); 
		//get values from post body
		String inputStatus = request.getParameter("request-decision"); //must form id to that specific input
		String reimb_id_string = request.getParameter("reimb-id"); //text input type with number, converts to number eventually
		int reimb_id = Integer.parseInt(reimb_id_string); 
		int success = es.resolveReimb(inputStatus, manager_username, reimb_id);
		if(success>0) {
			System.out.println("service method was called" + request.getMethod() + " to " + request.getRequestURI() + " was successful");
		}else {
			System.out.println("service method was called" + request.getMethod() + " to " + request.getRequestURI() + " failed");
		}
	
	}
}
