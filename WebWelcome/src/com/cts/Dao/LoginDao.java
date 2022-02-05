package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public boolean logindetailsAuthentication(String userid,String password) {
		boolean loginstatus=false;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/welcome","root","root");  
			PreparedStatement psmt=con.prepareStatement("select userid,password from registration where userid=? and password=?");  
			psmt.setString(1, userid);
			psmt.setString(2, password);
			ResultSet rs=psmt.executeQuery();
		    while(rs.next()) {
		    	loginstatus=true;}  
			psmt.close();
			con.close();
			
			}
			catch(Exception e){
				System.out.println(e);
				}
		return loginstatus;
	}
}
