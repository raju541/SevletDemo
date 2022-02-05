package com.cts.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cts.pojo.ListPojo;
import com.cts.util.Constants;
import com.cts.util.DButil;

public class ListDao {

		public List getalllists() {
				
			List<ListPojo> list=new ArrayList<ListPojo>();
			try {
				Connection con=DButil.getConnection();
				PreparedStatement psmt=con.prepareStatement(Constants.SELECT);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					ListPojo listpojo=new ListPojo();
					listpojo.setId(rs.getString(1));
					listpojo.setName(rs.getString(2));
					listpojo.setAddress(rs.getString(3));
					listpojo.setPhone(rs.getLong(4));
					listpojo.setSalary(rs.getLong(5));
					list.add(listpojo);
				}
				psmt.close();
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return list;
		}
		
		public void deletelist(String id) {
			
			List<ListPojo> list=new ArrayList<ListPojo>();
			try {
				Connection con=DButil.getConnection();
				PreparedStatement psmt=con.prepareStatement(Constants.DELETE);
				psmt.setString(1,id);
				psmt.execute();
				psmt.close();
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}	
		}		
}
