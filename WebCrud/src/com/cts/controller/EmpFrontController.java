package com.cts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.AddEmpDao;
import com.cts.pojo.EmpPojo;
import com.cts.util.Constrants;

public class EmpFrontController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter(Constrants.ACTION);
		
		if(action.equalsIgnoreCase(Constrants.ADDEMP)) {
		RequestDispatcher rd=req.getRequestDispatcher("/addemployee.jsp");
		rd.forward(req, resp);
		}
		else if(action.equalsIgnoreCase(Constrants.LIST)) {
			AddEmpDao addempdao=new AddEmpDao();
			List<EmpPojo> list=addempdao.getAllLists();
			req.setAttribute("list",list);
			RequestDispatcher rd=req.getRequestDispatcher("/list.jsp");
			rd.forward(req, resp);
		}
		else if(action.equalsIgnoreCase(Constrants.DELETEACTION)) {
			String id=req.getParameter(Constrants.ID);
			System.out.println("delete id is " +id);
			AddEmpDao addempdao=new AddEmpDao();
			addempdao.deleteemployee(id);
			List<EmpPojo> list=addempdao.getAllLists();
			req.setAttribute("list",list);
			RequestDispatcher rd=req.getRequestDispatcher("/list.jsp");
			rd.forward(req, resp);
		}

	}	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		long ph=Long.parseLong(phone);
		String salary=req.getParameter("salary");
		long sal=Long.parseLong(salary);
		System.out.println(id);
		System.out.println(name);
		System.out.println(address);
		System.out.println(phone);
		System.out.println(salary);
		
		AddEmpDao addempdao=new AddEmpDao();
		addempdao.insertdetails(id, name, address, ph, sal);
		
		  if(id!=""&&name!=""&&address!=""&&phone!=""&&salary!="") {
		  System.out.println("New User added Successfully");
		  RequestDispatcher  rd=req.getRequestDispatcher("/addempsuccess.jsp");
		  rd.forward(req,resp); }
		 
		else {
			System.out.println("Please enter all the fields!...");
			RequestDispatcher rd=req.getRequestDispatcher("/addempfailure.jsp");
			rd.forward(req,resp);
			
		}super.doGet(req,resp);	
	}

}
