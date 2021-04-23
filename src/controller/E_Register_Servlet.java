package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Employee;
import service.E_Register_Service;

@WebServlet("/E_Register_Servlet")
public class E_Register_Servlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		boolean result;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String emp_id = request.getParameter("emp_id");
		String f_name = request.getParameter("f_name");
		String m_name = request.getParameter("m_name");
		String l_name = request.getParameter("l_name");
		String email = request.getParameter("email");
		String com_name = request.getParameter("com_name");
		String e_password = request.getParameter("e_password");
		Employee employee =new Employee(emp_id,f_name,m_name,l_name,email,com_name,e_password);
		try 
		{
			E_Register_Service e_register_service = new E_Register_Service();
			result = e_register_service.register(employee);
			RequestDispatcher dispatcher;
			if(result)
			{
				dispatcher = request.getRequestDispatcher("E_Reg_Suc.html");
				dispatcher.forward(request, response);
			}
			else
			{
				dispatcher = request.getRequestDispatcher("E_Reg_Fail.html");
				dispatcher.forward(request, response);
			}			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
