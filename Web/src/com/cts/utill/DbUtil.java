package com.cts.utill;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbi","root","root"); 
		} 
		catch (Exception e) {
			e.printStackTrace();}  
		
		return con;
		}
	

}
