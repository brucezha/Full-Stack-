package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.*;
import com.service.*;

//Updated by Laukik 
/**
 * Servlet implementation class AdminEditCustomerServlet
 */
public class AdminEditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminEditCustomerServlet() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		
		if (idString != null) {
			Integer id=Integer.parseInt(idString);
			
			InfinityService service = new InfinityService();
			Customer cus  = service.getById(id);		
			HttpSession session = request.getSession();
			session.setAttribute("customer", cus);
			request.getRequestDispatcher("/Views/Admin/AdminEditCustomerMgmt.jsp").forward(request, response);
		} else {
			// no ID, do a getAll()
			System.out.println("Fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		int id = 0;
		if (action.equals("delete")) {
			 id = Integer.parseInt(request.getParameter("id"));
		} else {
			id = Integer.parseInt(request.getParameter("customerId"));
		}
		
		InfinityService service = new InfinityService();
		Customer cus  = service.getById(id);
			
		System.out.println("First name in adminCUst servlet: " + cus.getFirstName());
		System.out.println("Operator ID in admin edit : " + cus.getOperatorId());
					

		
		
		int recordCount = 0;
		int debtAmt;
		//InfinityService service  = new InfinityService();
		
		if (action.equals("edit")) {
			
			ArrayList<Operator> operators = service.getAllOp();
	        HttpSession session = request.getSession();
	        session.setAttribute("operators", operators);

	        ArrayList<Retailer> retailers = service.getRetailers();
	        session.setAttribute("retailers", retailers);
			
			System.out.println("Update");
			//HttpSession session = request.getSession();
     		session.setAttribute("customer", cus);
 			request.getRequestDispatcher("/Views/Admin/AdminEditCustomerMgmt.jsp").forward(request, response);
		}
		
		if(action.equals("update")){
			int operId=0;
			int retailerId=0;
			String operName = request.getParameter("operators");
			String retailerName = request.getParameter("retailers");
			System.out.println("Operator name: " + operName + "Retailer name: "  + retailerName);
			ArrayList<Operator> operators = service.getAllOp();
			for(int i=0; i<operators.size();i++ ){
				if(operators.get(i).getFirstName().equalsIgnoreCase(operName)){
					operId = operators.get(i).getOperatorId();
				}
			}
			System.out.println("Operator ID: " + operId);
			
			ArrayList<Retailer> retailers = service.getRetailers();
			for(int i=0; i<retailers.size();i++ ){
				if(retailers.get(i).getRetailName().equalsIgnoreCase(retailerName)){
					retailerId = retailers.get(i).getRetailerId();
				}
			}
			System.out.println("Retailer ID: " + retailerId);
			
			
			cus.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			cus.setFirstName(request.getParameter("firstName"));
			cus.setLastName(request.getParameter("lastName"));
			cus.setEmail(request.getParameter("email"));
			cus.setPhone(request.getParameter("phone"));
			cus.setOperatorId(operId);
			cus.setRetailerId(retailerId);
			cus.setAddress1(request.getParameter("streetAddress1"));
			cus.setAddress2(request.getParameter("streetAddress2"));
			cus.setCity(request.getParameter("city"));
			cus.setState(request.getParameter("state"));
			cus.setZip(Integer.parseInt(request.getParameter("zip")));
			cus.setPassword(request.getParameter("password"));
			
			recordCount = service.update(id, cus);
			
			if(recordCount >=1){
				HttpSession session = request.getSession();
				session.setAttribute("message",  "Customer "+cus.getFirstName() + "was updated successfully!");
				request.getRequestDispatcher("/admin/customer").forward(request, response);
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("message",  "Error updating customer");
				request.getRequestDispatcher("/Views/Admin/AdminEditCustomerMgmt.jsp").forward(request, response);
			}
			
		}
		
//		if (recordCount == 1) {
//			System.out.println("updated!");
//			HttpSession session = request.getSession();
//			if (action.equals("update")) {
//				session.setAttribute("message",  "updated!");
//			}
//			request.getRequestDispatcher("/admin/customer").forward(request, response);
//		} else {
//			HttpSession session = request.getSession();
//			if (action.equals("add")) {
//				session.setAttribute("error", "Failed adding !");
//			} 
//			
//			System.out.println("Error");
//		}
//	}
		
		if(action.equals("delete")){
			System.out.println("Delete mai aaya");
			debtAmt = service.checkDebtAmount(id);
			
			System.out.println("debt amount for ID: " + id +" is " + debtAmt);
			
			if(debtAmt == 0)
			{
				recordCount = service.deleteCust(id);
				
				if(recordCount >= 1){
					HttpSession session1 = request.getSession();
					session1.setAttribute("result", "The Customer "+cus.getFirstName() + " was deleted successfully!!");
					request.getRequestDispatcher("/admin/customer").forward(request, response);
				}else{
					HttpSession session1 = request.getSession();
					session1.setAttribute("result", "There was an error deleting "+cus.getFirstName() );
					request.getRequestDispatcher("/Views/Admin/AdminEditCustomerMgmt.jsp").forward(request, response);
				}
			}else{
				HttpSession session1 = request.getSession();
				session1.setAttribute("result", "Debt Balance for "+cus.getFirstName()+" needs to be settled first!" );
				request.getRequestDispatcher("/Views/Admin/AdminEditCustomerMgmt.jsp").forward(request, response);
			}
			

		}
	}
	
	

}
