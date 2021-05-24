package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends HttpServlet{
    
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //just like demo
        //response.sendRedirect("static/index.html");
        
        ((HttpServletResponse) request).sendRedirect("static/index.html"); 
    }
}
