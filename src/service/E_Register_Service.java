package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modal.Employee;
import util.Connect;

public class E_Register_Service
{

	public boolean register(Employee employee)
	{
		int status =0;
		boolean flag = false;
		try
		{
			Connection con =Connect.create_connection();
			if(con!=null)
			{
				String sql ="insert into emp_table(emp_id,f_name,m_name,l_name,email,com_name,e_password) values (?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, employee.getEmp_id());
				ps.setString(2, employee.getF_name());
				ps.setString(3, employee.getM_name());
				ps.setString(4, employee.getL_name());
				ps.setString(5, employee.getEmail());
				ps.setString(6, employee.getCom_name());
				ps.setString(7, employee.getE_password());
				status=ps.executeUpdate();
				if(status==1)
					flag =true;
			}			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return flag;
	}
}
