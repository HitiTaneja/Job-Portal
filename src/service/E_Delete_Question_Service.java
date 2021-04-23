package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.Connect;

public class E_Delete_Question_Service 
{
	public boolean delete_question(String quesdel)
	{
		int status=0;
		boolean flag=false;
		try 
		{
			Connection con=Connect.create_connection();
			if(con!=null)
			{
				String sql ="delete from online_test where question=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, quesdel);
				status=ps.executeUpdate();
				if(status==1)
					flag=true;
			}			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return flag;
		
	}
}