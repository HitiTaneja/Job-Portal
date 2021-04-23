package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modal.Employee;
import util.Connect;

public class E_Login_Service
{
	public Employee authenticate_Login(String empId, String password) 
	{
		Employee employee =null;	
		if(empId!=null && password!=null)
		{
			Connection conn = Connect.create_connection();
			if(conn!=null)
			{
				try 
				{
					String sql="select * from emp_table where emp_id=? and e_password=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, empId);
					ps.setString(2, password);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
						employee= new Employee();
						employee.setEmp_id(rs.getString(1));
						employee.setF_name(rs.getString(2));
						employee.setM_name(rs.getString(3));
						employee.setL_name(rs.getString(4));
						employee.setEmail(rs.getString(5));
						employee.setCom_name(rs.getString(6));
						employee.setE_password(rs.getString(7));
						return employee;
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}		
		return employee;
	}
}