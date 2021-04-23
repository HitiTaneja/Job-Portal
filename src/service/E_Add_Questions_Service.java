package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.Online_Test_Questions;
import util.Connect;

public class E_Add_Questions_Service
{
	public boolean add_question(Online_Test_Questions otq)
	{
		boolean flag=false;
		int status=0;
		try 
		{
			Connection con =Connect.create_connection();
			if(con!=null)
			{
				String sql ="insert into online_test (question,option_a,option_b,option_c,option_d,correct_answer) values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, otq.getQuestion());
				ps.setString(2, otq.getOption_a());
				ps.setString(3, otq.getOption_b());
				ps.setString(4, otq.getOption_c());
				ps.setString(5, otq.getOption_d());
				ps.setString(6, otq.getCorrect_answer());
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