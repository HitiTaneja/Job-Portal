package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modal.Post_Resume;
import util.Connect;

public class S_Edit_Resume
{
	public boolean update_result(Post_Resume pr)
	{
		boolean flag=false;
		int status=0;
		Connection connect = Connect.create_connection();
		if(connect!=null)
		{
			try 
			{
				System.out.println("Here2");
				String sql ="update post_resume set name =?, address=? , email_id=? , work_exp=? , t_marks=? , tw_marks=? , g_marks=? "
						+ ", p_marks=? , skill=? , pro1=? , pro2=? , ref=? where user_id=?";
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setString(1, pr.getName());
				ps.setString(2, pr.getAddress());
				ps.setString(3, pr.getEmail_id());
				ps.setInt(4, pr.getWork_exp());
				ps.setInt(5, pr.getT_marks());
				ps.setInt(6, pr.getTw_marks());
				ps.setInt(7, pr.getG_marks());
				ps.setInt(8, pr.getP_marks());
				ps.setString(9, pr.getSkill());
				ps.setString(10, pr.getPro_1());
				ps.setString(11, pr.getPro_2());
				ps.setString(12, pr.getReferences());
				ps.setString(13, pr.getUser_id());
				status = ps.executeUpdate();
				System.out.println("Status "+status);
				if(status == 1)
					flag = true;		
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return flag;		
	}
}