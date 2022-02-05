package com.cts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cts.pojo.EmpPojo;
import com.cts.util.Constrants;
import com.cts.util.DbUtil;

public class AddEmpDao {
	
		public void insertdetails(String id,String name,String address,Long phone,Long salary) {
			
			try {
				Connection con=DbUtil.getConnection();
				PreparedStatement psmt=con.prepareStatement(Constrants.INSERT);
				psmt.setString(1, id);
				psmt.setString(2, name);
				psmt.setString(3, address);
				psmt.setLong(4, phone);
				psmt.setLong(5, salary);
				psmt.execute();
				psmt.close();
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

		public List getAllLists() {
	
			List<EmpPojo> list=new ArrayList<EmpPojo>();
			try {
				Connection con=DbUtil.getConnection();
				PreparedStatement psmt=con.prepareStatement(Constrants.SELECT);
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					EmpPojo emppojo=new EmpPojo();
					emppojo.setId(rs.getString(1));
					emppojo.setName(rs.getString(2));
					emppojo.setAddress(rs.getString(3));
					emppojo.setPhone(rs.getString(4));
					emppojo.setSalary(rs.getString(5));
					list.add(emppojo);
				}
				psmt.close();
				con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return list;
		}
			public void deleteemployee(String id) {
				List<EmpPojo> list=new ArrayList<EmpPojo>();
				try {
					Connection con=DbUtil.getConnection();
					PreparedStatement psmt=con.prepareStatement(Constrants.DELETE);
					psmt.setString(1, id);
					psmt.execute();
					psmt.close();
					con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			}
}
