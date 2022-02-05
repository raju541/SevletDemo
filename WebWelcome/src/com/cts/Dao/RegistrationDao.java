package com.cts.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistrationDao {
	
public void insertregistrationdetails(String name,String userid,String password,String phone) {

		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/welcome","root","root");  
			PreparedStatement psmt=con.prepareStatement("insert into registration values(?,?,?,?)");  
			psmt.setString(1, name);
			psmt.setString(2, userid);
			psmt.setString(3, password);
			psmt.setString(4, phone);
			psmt.execute();    
			psmt.close();
			con.close();
			
			}
			catch(Exception e){
				System.out.println(e);
				}
		}
}
