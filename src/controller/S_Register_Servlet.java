package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.User;
import service.S_Register_Service;

@WebServlet("/S_Register_Servlet")
public class S_Register_Servlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean result;
		response.setContentType("text/html");
		String User_id = request.getParameter("user_id");
		String F_name = request.getParameter("f_name");
		String M_name = request.getParameter("m_name");
		String L_name = request.getParameter("l_name");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		User user = new User(User_id,F_name,M_name,L_name,Email,Password);
		try 
		{
			S_Register_Service s_Register_Service = new S_Register_Service();
			result = s_Register_Service.register(user);
			RequestDispatcher reqdis;
			if(result)
			{
				reqdis=request.getRequestDispatcher("S_Reg_Suc.html");
				reqdis.forward(request, response);
			}
			else
			{
				reqdis=request.getRequestDispatcher("S_Reg_Fail.html");
				reqdis.forward(request, response);				
			}
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
