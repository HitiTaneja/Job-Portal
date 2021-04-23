package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Connect;

public class S_View_Resume_Service
{
	public ResultSet get_resume_id(String user_id)
	{
		ResultSet rs = null;
		try
		{
			Connection connection = Connect.create_connection();
			if(connection!=null)
			{
				String sql = "select * from post_resume where user_id=?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.CONCUR_UPDATABLE);
				preparedStatement.setString(1, user_id);
				rs = preparedStatement.executeQuery();
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rs;		
	}
}