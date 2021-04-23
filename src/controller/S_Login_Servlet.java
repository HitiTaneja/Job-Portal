package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.User;
import service.S_Login_Service;

@WebServlet("/S_Login_Servelet")
public class S_Login_Servlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String user_id =request.getParameter("userId");
		String password =request.getParameter("password");
		S_Login_Service login_Service = new S_Login_Service();
		User user = login_Service.authenticate_User(user_id, password);
		if(user!= null)
		{
			request.getSession().setAttribute("user", user);
			response.sendRedirect("S_Inbox_Servlet");
		}
		else
		{
			response.sendRedirect("S_Error.html");
		}
	}
}
