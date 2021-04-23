package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.User;
import util.Connect;

public class S_Register_Service 
{

	public boolean register(User user) 
	{
		int status =0;
		boolean flag = false;
		try 
		{
			Connection con=Connect.create_connection();
			if(con!=null)
			{
				String sql="insert into user_table (User_id,F_name , M_name , L_name , Email_id , Password) values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getUser_id());
				ps.setString(2, user.getF_name());
				ps.setString(3, user.getM_name());
				ps.setString(4, user.getL_name());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getPassword());
				status = ps.executeUpdate();	
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
