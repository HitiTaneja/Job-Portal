package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.Online_Test_Questions;
import util.Connect;

public class S_Beginner_C_Service {
	Connection connection = Connect.create_connection();
	PreparedStatement ps = null;

	public List<Online_Test_Questions> fetch() {
		List<Online_Test_Questions> list = new ArrayList<Online_Test_Questions>();
		if (connection != null) {
			try {
				String sql = "Select question,option_a,option_b,option_c,option_d,correct_answer from online_test";
			PreparedStatement ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = ps.executeQuery();
				Online_Test_Questions otq;
				if (!rs.isBeforeFirst() ) {    
				    System.out.println("No data"); 
				} 
				while (rs.next()==true) 
				{
					otq = new Online_Test_Questions();
					otq.setQuestion(rs.getString("question"));
					otq.setOption_a(rs.getString("option_a"));
					otq.setOption_b(rs.getString("option_b"));
					otq.setOption_c(rs.getString("option_c"));
					otq.setOption_d(rs.getString("option_d"));
					otq.setCorrect_answer(rs.getString("correct_answer"));
					list.add(otq);
					
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean update_result(String user_answer, String user_id) 
	{
		int status = 0;
		boolean flag = false;
		try {
			if (connection != null) {
				String sql = "update online_test set result=? where userid=?";
				ps = connection.prepareStatement(sql);
				ps.setString(1, user_answer);
				ps.setString(2, user_id);
				status = ps.executeUpdate();
				if (status != 0)
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public int check_result() {
		ResultSet rs;
		int count = 0;
		try {
			if (connection != null) {
				String sql = "select correct_answer,user_answer from online_test";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getString("correct_answer").equals(rs.getString("user_answer")))
						count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean result_update(int result, String user_id) {
		boolean flag = false;
		try 
		{
			if(connection!=null)
			{
				int status=0;
				String sql="update user_table set result=? where user_id=?";
				ps = connection.prepareStatement(sql);
				ps.setInt(1, result);
				ps.setString(2, user_id);
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
