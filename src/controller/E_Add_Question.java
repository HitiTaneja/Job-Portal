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
import modal.Online_Test_Questions;
import service.E_Add_Questions_Service;

@WebServlet("/E_Add_Question")
public class E_Add_Question extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		Employee employee = (Employee)session.getAttribute("employee");
		
		if(employee==null)
		{
			response.sendRedirect("S_Sign_In.jsp");
		}
		else
		{
			String question = request.getParameter("question");
			String option_a = request.getParameter("option_a");
			String option_b = request.getParameter("option_b");
			String option_c = request.getParameter("option_c");
			String option_d = request.getParameter("option_d");
			String answer = request.getParameter("correct_answer");
			
			Online_Test_Questions otq = new Online_Test_Questions(question, option_a, option_b, option_c, option_d, answer);
			try 
			{
				System.out.println("Here3");
				E_Add_Questions_Service questions_Service = new E_Add_Questions_Service();
				boolean result= questions_Service.add_question(otq);
				System.out.println("here2"+result);
				RequestDispatcher dispatcher;
				if(result==true)
				{
					dispatcher = request.getRequestDispatcher("E_Add_Ques_Suc.html");
					dispatcher.forward(request, response);
				}
				else
				{
					dispatcher = request.getRequestDispatcher("E_Add_Ques_Fail.html");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
