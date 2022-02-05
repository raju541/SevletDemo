package com.cts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.ListDao;
import com.cts.pojo.ListPojo;
import com.cts.util.Constants;

public class ListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter(Constants.ACTION);
		
		if(action.equalsIgnoreCase(Constants.LIST)) {
			
			ListDao listdao=new ListDao();
			//List<ListPojo> l=listdao.getalllists();
			req.setAttribute("list",listdao.getalllists());
			RequestDispatcher rd=req.getRequestDispatcher("/list.jsp");
			rd.forward(req, resp);	
		}
		else if(action.equalsIgnoreCase(Constants.DELETEACTION)) {
			String id=req.getParameter(Constants.ID);
			System.out.println("Delete id is " +id);
			ListDao listdao=new ListDao();
			listdao.deletelist(id);
			req.setAttribute("list",listdao.getalllists());
			RequestDispatcher rd=req.getRequestDispatcher("/list.jsp");
			rd.forward(req, resp);
		}
	}

}
