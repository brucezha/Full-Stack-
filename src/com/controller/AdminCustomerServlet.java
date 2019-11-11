package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.*;
import com.service.*;
import java.util.*;

//Updated By Laukik
/**
 * Servlet implementation class AdminCustomerServlet
 */
public class AdminCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminCustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InfinityService service = new InfinityService();
		ArrayList<Customer> customers = service.getAll();
		HttpSession session = request.getSession();
		session.setAttribute("customers", customers);
		System.out.println(customers);
		
		ArrayList<Operator> operators = service.getAllOp();
		//HttpSession session = request.getSession();
		session.setAttribute("operators", operators);
		System.out.println(customers);
		
		ArrayList<Retailer> retailers = service.getRetailers();
		//HttpSession session = request.getSession();
		session.setAttribute("retailers", retailers);
		System.out.println(customers);
		
		request.getRequestDispatcher("../Views/Admin/AdminCustomerMgmt.jsp").forward(request, response);
		System.out.println("hi");
		
	
		}
		
		
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String selected;
		int rowsAffected;
		String action = request.getParameter("action");
		System.out.println("Action hai: " + action);
		
//		if(request.getParameter("action")!=null){
//			System.out.println(" AdminCustomer mai aaya");
//			selected = request.getParameter("action");
		
		if("filter".equals(action)){
			InfinityService service1 = new InfinityService();
			ArrayList<Customer> customers1 = service1.getByDeleteRequest();
			System.out.println("Delete request in admin: " + customers1.get(0).getFirstName());
			HttpSession session1 = request.getSession();
			session1.setAttribute("customers", customers1);
			request.getRequestDispatcher("../Views/Admin/AdminCustomerMgmt.jsp").forward(request, response);
		}else if("getAll".equals(action)){
			InfinityService service1 = new InfinityService();
			ArrayList<Customer> customers1 = service1.getAll();
			HttpSession session1 = request.getSession();
			session1.setAttribute("customers", customers1);
			System.out.println(customers1);
			request.getRequestDispatcher("../Views/Admin/AdminCustomerMgmt.jsp").forward(request, response);
		}else{InfinityService service1 = new InfinityService();
			ArrayList<Customer> customers1 = service1.getAll();
			HttpSession session1 = request.getSession();
			session1.setAttribute("customers", customers1);
			System.out.println(customers1);
			request.getRequestDispatcher("../Views/Admin/AdminCustomerMgmt.jsp").forward(request, response);
		}
	}

}
