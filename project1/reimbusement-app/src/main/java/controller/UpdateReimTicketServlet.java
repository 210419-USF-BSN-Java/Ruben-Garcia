package controller;
import service.ManagerService;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Reimbursement;

@WebServlet(value="/reimbursement_resolve")
public class UpdateReimTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	ManagerService es = new ManagerService();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			System.out.println("service method was called: " + request.getMethod() + " to " + request.getRequestURI());
			HttpSession session = request.getSession(); 
			String manager_username = (String)session.getAttribute("username"); 
			ObjectMapper mapper = new ObjectMapper();
			String requestData = request.getReader().lines().collect(Collectors.joining());
			System.out.println(requestData);
			Reimbursement updatereim = mapper.readValue(requestData,Reimbursement.class);
			int reimb_id = updatereim.getReimb_id();
			int inputStatus = updatereim.getReimb_status_id();
			es.resolveReimb(inputStatus, manager_username, reimb_id);
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
