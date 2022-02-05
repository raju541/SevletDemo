package com.cts.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.Dao.LoginDao;

public class LoginServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String userid=req.getParameter("userid");
	String password=req.getParameter("password");
	System.out.println(userid);
	System.out.println(password);
	
	
	LoginDao logindao=new LoginDao();
	boolean loginstatus=logindao.logindetailsAuthentication(userid, password);
	
	if(loginstatus) {  
		
		System.out.println("You are successfully logged in");
		RequestDispatcher rd=req.getRequestDispatcher("/loginsuccess.jsp");  
	    rd.forward(req, resp);
	}
	else {
		 
		System.out.println("Please try with correct login details !...");
		RequestDispatcher rd=req.getRequestDispatcher("/loginfailure.jsp");  
		rd.forward(req, resp);
    }
	
    super.doGet(req, resp);
	}
}
