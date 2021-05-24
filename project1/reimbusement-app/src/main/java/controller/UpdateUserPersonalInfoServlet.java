package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/UpdateUserInfo")
public class UpdateUserPersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*
		PrintWriter out = response.getWriter(); 
		//set userid attribute to new object user created from form data; service method requires userid 
		//TODO 
		//get user session data for reimbursement post from front end; mix object from employeeinit to the reimbursement object
		ObjectMapper objectMapper = new ObjectMapper();
		String requestData = request.getReader().lines().collect(Collectors.joining()); //from stack overflow lol: https://stackoverflow.com/questions/1548782/retrieving-json-object-literal-from-httpservletrequest
		System.out.println(requestData);
		try {
			//TODO  
			User newUserObject = objectMapper.readValue(requestData, Reimbursement.class); 
			//pass mapped object to the submit reimbursement service
			//having issues where values not specificed are given values e.g., I was dependent on the dao to give default values for null values in object
			EmployeeServices es = new EmployeeServices(); 
			Status es = es.update(user);
			Reimbursement createdItem = es.submitReimbursementRequest(reim); 
			System.out.println(reim); 
			System.out.println(createdItem); 
		}catch(IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
