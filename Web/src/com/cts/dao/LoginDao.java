package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public boolean LogindetailsAuthentication(String username,String Password) {
		boolean loginstatus=false;
		try{  
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sbi","root","root");  
			//here sbi is database name, root is username and password  
			PreparedStatement psmt=con.prepareStatement("select username,password from login where username=? and password=?  ");  
			psmt.setString(1, username);
			psmt.setString(2, Password);
			ResultSet rs=psmt.executeQuery();
		    while(rs.next()) {
		    	loginstatus=true;}
			//stmt.executeUpdate("insert into login(username,password) values(uname,password)");  
			psmt.close();
			con.close();
		
			}catch(Exception e){ System.out.println(e);}
			return loginstatus;  
					
	}

}
