package com.cts.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.dao.Addemployeedao;
import com.cts.utill.Contants;

public class EmpFrontControler extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getParameter(Contants.ACTION);
		
		if(action.equalsIgnoreCase(Contants.ADDEMP)) {
			request.getRequestDispatcher("/addemployee.jsp").forward(request, response); 	
		}
		else if(action.equalsIgnoreCase(Contants.LIST)) {
			
			Addemployeedao addemployeedao=new Addemployeedao();
			request.setAttribute("employelist", addemployeedao.getAllEmployess());
			request.getRequestDispatcher("/list.jsp").forward(request, response); 
		}
		else if(action.equalsIgnoreCase(Contants.DELETEACTION)) {
			String id=request.getParameter(Contants.ID);
			int empid=Integer.parseInt(id);
			System.out.println("delete id is " +id);
			Addemployeedao addemployeedao=new Addemployeedao();
			//delete
			addemployeedao.deleteemployee(empid);
			//select
			request.setAttribute("employelist", addemployeedao.getAllEmployess());
			request.getRequestDispatcher("/list.jsp").forward(request, response); 
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		Long mb=Long.parseLong(mobile);
		String address=request.getParameter("address");
		
		Addemployeedao addemployeedao=new Addemployeedao();
		addemployeedao.addEmployee(id, name, mb, address);
		
		System.out.println("new Employee added successfully");
		request.getRequestDispatcher("/Employee.jsp").forward(request, response);
	}
}
