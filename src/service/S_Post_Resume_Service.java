package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modal.Post_Resume;
import util.Connect;

public class S_Post_Resume_Service
{
	public boolean post(Post_Resume post_Resume)
	{
		int status=0;
		boolean flag=false;
		try 
		{
			Connection conn = Connect.create_connection();
			if(conn!=null)
			{
				String sql = "insert into post_resume values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,post_Resume.getName());
				ps.setString(2, post_Resume.getAddress());
				ps.setString(3, post_Resume.getEmail_id());
				ps.setInt(4, post_Resume.getWork_exp());
				ps.setInt(5, post_Resume.getT_marks());
				ps.setInt(6, post_Resume.getTw_marks());
				ps.setInt(7, post_Resume.getG_marks());
				ps.setInt(8,post_Resume.getP_marks());
				ps.setString(9, post_Resume.getSkill());
				ps.setString(10, post_Resume.getPro_1());
				ps.setString(11, post_Resume.getPro_2());
				ps.setString(12, post_Resume.getReferences());
				ps.setString(13, post_Resume.getUser_id());
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
