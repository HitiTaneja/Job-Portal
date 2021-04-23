package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modal.User;
import util.Connect;

public class S_Login_Service 
{
	public User authenticate_User(String user_id, String password) 
	{
		User user =null;
		if(user_id != null && password != null)
		{
			Connection connect = Connect.create_connection();
			if(connect!=null)
			{
				try
				{
					String sql ="Select * from user_table where User_id=? and Password=?";
		        	PreparedStatement ps=connect.prepareStatement(sql);
		        	ps.setString(1, user_id);
		        	ps.setString(2, password);
		        	ResultSet rs= ps.executeQuery();
		        	if(rs.next())
		        	{
		        		user=new User();		 
		        		user.setUser_id(rs.getString(1));
		        		user.setF_name(rs.getString(2));
		        		user.setM_name(rs.getString(3));
		        		user.setL_name(rs.getString(4));
		        		user.setEmail(rs.getString(5));
		        		user.setPassword(rs.getString(6));		       
		        		return user;
		        	}				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}
		return user;
	}
}
