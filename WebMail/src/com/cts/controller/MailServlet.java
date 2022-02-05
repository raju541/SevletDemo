package com.cts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.MailDao;

public class MailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String username=req.getParameter("username");
	String password=req.getParameter("password");
	
	System.out.println(username);
	System.out.println(password);
	
	MailDao maildao=new MailDao();
	maildao.insertlogindetails(username, password);
	
		super.doGet(req, resp);
	}

}
