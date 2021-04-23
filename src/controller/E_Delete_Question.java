package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modal.Employee;
import service.E_Delete_Question_Service;


@WebServlet("/E_Delete_Question")
public class E_Delete_Question extends HttpServlet 
{	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession(false);
		Employee employee = (Employee)session.getAttribute("employee");
		if(employee==null)
		{			
			response.sendRedirect("S_Sign_In.jsp");
		}
		else
		{			
			try 
			{
				String quesdel = request.getParameter("quesdel");
				E_Delete_Question_Service question = new E_Delete_Question_Service();
				boolean result= question.delete_question(quesdel);
				RequestDispatcher dispatcher;
				if(result==true)
				{
					dispatcher = request.getRequestDispatcher("E_Del_Ques_Suc.html");
					dispatcher.forward(request, response);
				}
				else
				{
					dispatcher = request.getRequestDispatcher("E_Del_Ques_Fail.html");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
