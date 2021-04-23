package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Employee;
import service.E_Login_Service;

@WebServlet("/E_Login_Servlet")
public class E_Login_Servlet extends HttpServlet 
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		String empId = request.getParameter("empId");
		String password = request.getParameter("password");
		E_Login_Service login_Service = new E_Login_Service();
		Employee employee = login_Service.authenticate_Login(empId,password);
		if(employee!=null)
		{
			request.getSession().setAttribute("employee",employee);
			response.sendRedirect("E_Inbox_Servlet");
		}
		else
		{
			response.sendRedirect("E_Error.html");
		}
	}
}