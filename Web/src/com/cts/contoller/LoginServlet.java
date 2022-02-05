package com.cts.contoller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.LoginDao;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String uname=req.getParameter("uname");
	String password=req.getParameter("pwd");
	System.out.println(uname);
	System.out.println(password);
	
	LoginDao logindao=new LoginDao();
	boolean loginstatus=logindao.LogindetailsAuthentication(uname, password);
	if(loginstatus) {
		RequestDispatcher rd=req.getRequestDispatcher("/Employee.jsp");  
        rd.forward(req, resp);  
		System.out.println("you are successfully loggedin");
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("/failure.jsp");  
        rd.forward(req, resp); 
		System.out.println("please try with correct login details");
	}
		
	}

}
