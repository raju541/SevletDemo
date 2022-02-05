package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cts.pojo.EmpPojo;
import com.cts.utill.Contants;
import com.cts.utill.DbUtil;

public class Addemployeedao {
	
	public void addEmployee(String id,String name,long mobile,String address) {
		
		try{  
			Connection con=DbUtil.getConnection(); 
			PreparedStatement psmt=con.prepareStatement(Contants.INSERT);  
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setLong(3, mobile);
			psmt.setString(4, address);
			psmt.execute();
			psmt.close();
			con.close();
			}catch(Exception e){ System.out.println(e);}			
	}	
	
	public List getAllEmployess() {
		
		List<EmpPojo> list=new ArrayList<EmpPojo>();
		try {
			Connection con=DbUtil.getConnection(); 
			PreparedStatement psmt=con.prepareStatement(Contants.SELECT); 
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
			EmpPojo emppojo=new EmpPojo();
			emppojo.setId(rs.getInt(1));
			emppojo.setName(rs.getString(2));
			emppojo.setMobile(rs.getLong(3));
			emppojo.setAddress(rs.getString(4));
			list.add(emppojo);
			}
			psmt.close();
			con.close();
		} catch (Exception e) {e.printStackTrace();}
		return list;  	
	}

	public void deleteemployee(int empid) {
		
		List<EmpPojo> list=new ArrayList<EmpPojo>();
		try {
			Connection con=DbUtil.getConnection(); 
			PreparedStatement psmt=con.prepareStatement(Contants.DELETE); 
			psmt.setInt(1, empid);
			psmt.execute();
			psmt.close();
			con.close();	
		} catch (Exception e) {e.printStackTrace();}	
	}
}