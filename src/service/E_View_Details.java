package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.Connect;

public class E_View_Details 
{
	public ResultSet get_details_by_id(String emp_id)
	{
		ResultSet rs = null;
		try
		{
			Connection connection = Connect.create_connection();
			if(connection!=null)
			{
				String sql="Select * from emp_table where emp_id=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.CONCUR_UPDATABLE);
				preparedStatement.setString(1, emp_id);
				rs = preparedStatement.executeQuery();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return rs;		
	}

}
