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
import service.S_Post_Resume_Service;

@WebServlet("/S_Post_Resume_Servlet")
public class S_Post_Resume_Servlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		boolean result;
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user == null)
		{
			response.sendRedirect("S_Login.html");
		} 
		else 
		{
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email_id = request.getParameter("email_id");
			String work_exp = request.getParameter("work_exp");
			String t_marks = request.getParameter("t_marks");
			String tw_marks = request.getParameter("tw_marks");
			String g_marks = request.getParameter("g_marks");
			String p_marks = request.getParameter("p_marks");
			String skill = request.getParameter("skill");
			String pro_1 = request.getParameter("pro_1");
			String pro_2 = request.getParameter("pro_2");
			String references = request.getParameter("references");
			String user_id=request.getParameter("user_id");
			Post_Resume post_Resume = new Post_Resume(name,address,email_id,Integer.parseInt(work_exp),
					Integer.parseInt(t_marks),Integer.parseInt(tw_marks),Integer.parseInt(g_marks),Integer.parseInt(p_marks)
					,skill,pro_1,pro_2,references,user_id);
			try 
			{
				S_Post_Resume_Service postresumeservice = new S_Post_Resume_Service();
				result = postresumeservice.post(post_Resume);
				System.out.println("Result"+result);
				RequestDispatcher dispatcher;
				if(result)
				{
					dispatcher = request.getRequestDispatcher("S_Post_Res_Suc.html");
					dispatcher.forward(request, response);
				}
				else
				{
					dispatcher = request.getRequestDispatcher("S_Post_Res_Fail.html");
					dispatcher.forward(request, response);
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			
		}
	}
}