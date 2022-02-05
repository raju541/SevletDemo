package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MailDao {
	
	public void insertlogindetails(String username,String password) {
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/email","root","root");  
			PreparedStatement psmt=con.prepareStatement("insert into mail values(?,?)");  
			psmt.setString(1, username);
			psmt.setString(2, password);
			ResultSet rs=psmt.executeQuery();
			psmt.execute();  
			psmt.close();
			con.close();
			
			}
			catch(Exception e){
				System.out.println(e);
				}
	}
}
