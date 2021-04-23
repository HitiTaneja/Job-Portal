package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.User;
import util.Connect;

public class E_View_All_Result_Service 
{
	public List<User> fetch()
	{
		List<User> list = new ArrayList<User>();
		try 
		{
			Connection con =Connect.create_connection();
			if(con!=null)
			{
				String sql ="select * from user_table";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					User user= new User();
					user.setUser_id(rs.getString("user_id"));
					user.setF_name(rs.getString("f_name"));
					user.setM_name(rs.getString("m_name"));
					user.setL_name(rs.getString("l_name"));
					user.setResult(rs.getInt("result"));
					list.add(user);
				}				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;		
	}

}
