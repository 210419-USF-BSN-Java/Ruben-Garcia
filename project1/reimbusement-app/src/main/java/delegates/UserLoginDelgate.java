package delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginDelgate implements Delegatable {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("i got to the userlogin delegate");
		String path = (String) request.getAttribute("path");
		
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
			case "GET": 
				System.out.println("got to case get for userlogindelegate");
				request.getRequestDispatcher("../src/index.html").forward(request, response);
			case "Post":
				//post method
			default: 
				System.out.println("I got to default statement of userlogin delegate");
			}
		}else {
			System.out.println("issue");
		}
	}

}
