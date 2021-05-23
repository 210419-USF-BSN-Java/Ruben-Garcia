package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Reimbursement;
import service.ManagerService;

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
