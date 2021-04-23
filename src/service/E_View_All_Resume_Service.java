package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modal.Post_Resume;
import util.Connect;

public class E_View_All_Resume_Service 
{
	public List<Post_Resume> fetch()
	{
		List<Post_Resume> list = new ArrayList<Post_Resume>();
		try 
		{
			Connection con =Connect.create_connection();
			if(con!=null)
			{
				String sql ="select * from post_resume";
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					Post_Resume pr= new Post_Resume();
					pr.setUser_id(rs.getString("user_id"));
					pr.setName(rs.getString("name"));
					pr.setAddress(rs.getString("address"));
					pr.setEmail_id(rs.getString("email_id"));
					pr.setWork_exp(rs.getInt("work_exp"));
					pr.setT_marks(rs.getInt("t_marks"));
					pr.setTw_marks(rs.getInt("tw_marks"));
					pr.setG_marks(rs.getInt("g_marks"));
					pr.setP_marks(rs.getInt("p_marks"));
					pr.setSkill(rs.getString("skill"));
					pr.setPro_1(rs.getString("pro1"));
					pr.setPro_2(rs.getString("pro2"));
					pr.setReferences(rs.getString("ref"));
					list.add(pr);
				}				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;		
	}

}
