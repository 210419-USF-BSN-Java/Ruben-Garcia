package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerDelegate implements Delegatable {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
			case "GET": 
				//get method
			case "Post":
				//post method
			default: 
				response.sendError(400, "Request not supported");
			}
		}else {
			System.out.println("issue");
		}
	}

}
