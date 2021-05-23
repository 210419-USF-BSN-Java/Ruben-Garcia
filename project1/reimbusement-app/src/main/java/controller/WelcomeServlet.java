package controller;

import javax.servlet.annotation.WebServlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/homepage") 
public class WelcomeServlet extends HttpServlet{
	//not working like in servletdemo
	//help
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        //response.sendRedirect("static/index.html");
        
        request.getRequestDispatcher("static/index.html").forward(request, response);
    }
}
