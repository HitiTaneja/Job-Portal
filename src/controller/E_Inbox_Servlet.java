package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/E_Inbox_Servlet")
public class E_Inbox_Servlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher;
		if(session!=null)
		{
			dispatcher = request.getRequestDispatcher("E_Indox.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect("E_Sign_In.html");
		}
	}
}
