package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect 
{
	public static Connection conn =null;
	public static Connection create_connection()
	{	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ", "hr", "root");
			if(conn!=null)
			System.out.println("Connection Created");			
		} catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Not created");
			e.printStackTrace();
		}		
		return conn;
	}
}
