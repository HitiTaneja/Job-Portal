package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.Post_Resume;
import modal.User;
import service.S_Edit_Resume;

@WebServlet("/S_Edit_Resume_Servlet")
public class S_Edit_Resume_Servlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user==null)
		{
			response.sendRedirect("S_Login.html");
		}
		else 
		{
			System.out.println("Here");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email_id = request.getParameter("email_id");
			String work_exp = request.getParameter("work_exp");
			String t_marks = request.getParameter("t_marks");
			String tw_marks = request.getParameter("tw_marks");
			String g_marks = request.getParameter("g_marks");
			String p_marks = request.getParameter("p_marks");
			String skill = request.getParameter("skill");
			String pro1 = request.getParameter("pro1");
			String pro2 = request.getParameter("pro2");
			String ref = request.getParameter("ref");
			String user_id = request.getParameter("user_id");
			Post_Resume pr = new Post_Resume(name, address, email_id, Integer.parseInt(work_exp), Integer.parseInt(t_marks),
					Integer.parseInt(tw_marks),Integer.parseInt(g_marks),Integer.parseInt(p_marks), skill, pro1, pro2, ref,user_id);
			try 
			{
				S_Edit_Resume er= new S_Edit_Resume();
				boolean result =er.update_result(pr);
				System.out.println("result "+result);
				RequestDispatcher dispatcher;
				if(result==true)
				{
					dispatcher=request.getRequestDispatcher("S_Edit_Res_Suc.html");
					dispatcher.include(request, response);
				}
				else 
				{
					dispatcher=request.getRequestDispatcher("S_Edit_Res_Fail.html");
					dispatcher.include(request, response);
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}	
}