package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.User;
import service.S_Beginner_C_Service;

@WebServlet("/S_Beginner_C_Servlet")
public class S_Beginner_C_Servlet extends HttpServlet 
{
 	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{
 		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("S_Login.html");
		}
		else
		{
			String result= request.getParameter("ac");
			int actual_result=Integer.parseInt(result);
			S_Beginner_C_Service ser = new S_Beginner_C_Service();
			boolean res= ser.result_update(actual_result, user.getUser_id());
			RequestDispatcher dispatcher;
			if(res==true)
			{
				dispatcher = request.getRequestDispatcher("S_Res_Suc.html");
				dispatcher.forward(request, response);
			}
			else
			{
				dispatcher = request.getRequestDispatcher("S_Res_Fail.html");
				dispatcher.forward(request, response);
			}
			
			
		}
	}
}