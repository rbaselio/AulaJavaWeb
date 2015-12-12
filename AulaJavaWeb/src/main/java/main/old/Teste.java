package main.old;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet")
public class Teste extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5916153384402560649L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter whiter = response.getWriter();
		
		request.getPathInfo();
		
		if(request.getSession(false).getAttribute("session") != null){
			whiter.append(request.getSession(false).getAttribute("session").toString());			
		}
		
		
		whiter.println();
		
	}
    

	

}
