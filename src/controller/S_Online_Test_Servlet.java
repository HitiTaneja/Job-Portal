package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.User;
@WebServlet("/S_Online_Test_Servlet")
public class S_Online_Test_Servlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			String language = request.getParameter("language");
			String level = request.getParameter("level");
			if(level.equals("Select")&&language.equals("Select"))			
				response.sendRedirect("S_Online_Test.jsp");
			if(level.equals("Beginner")&&language.equals("C"))
				response.sendRedirect("S_Beginner_Test.jsp");
		}
		
	}

}
