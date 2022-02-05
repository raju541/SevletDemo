package com.cts.controller;

import java.io.Console;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.RegistrationDao;

public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String userid=req.getParameter("userid");
		String password=req.getParameter("password");
		String phone=req.getParameter("phone");
		System.out.println(name);
		System.out.println(userid);
		System.out.println(password);
		System.out.println(phone);
		
		RegistrationDao regdao=new RegistrationDao();
		regdao.insertregistrationdetails(name, userid, password, phone);
		if(name!=null&&userid!=null&&password!=null&&phone!=null) {  
	        
			System.out.println("Please enter all the fields");
			RequestDispatcher rd=req.getRequestDispatcher("/regifailure.jsp");  
		    rd.forward(req, resp);
		}
		else {
	
			System.out.println("New user added successfully");
			RequestDispatcher rd=req.getRequestDispatcher("/regisuccess.jsp");  
			rd.forward(req, resp);
		}
		super.doGet(req, resp);
	}
}
