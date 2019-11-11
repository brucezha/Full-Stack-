package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Retailer;
import com.service.InfinityService;

/**
 * Servlet implementation class AdminRetailerServlet
 */
public class AdminRetailerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminRetailerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try{
			InfinityService service = new InfinityService();
			ArrayList<Retailer> retailers = service.getAllRetailer();
			for(Retailer r : retailers){
				System.out.println(r);
			}
			HttpSession session = request.getSession();
			session.setAttribute("retailers", retailers);
			request.getRequestDispatcher("/Views/Admin/temp_retailer_admin.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
//		request.getRequestDispatcher("/Views/Admin/temp_retailer_admin.jsp").forward(request, response);
		
//		String action = request.getParameter("action");
//		if(action.equalsIgnoreCase("delete")){
//			try{
//				InfinityService service = new InfinityService();
//				int retailerId = Integer.parseInt(request.getParameter("id"));
//				System.out.println("RetailerId: " + retailerId);
////				int result = service.deleteRetailer(retailerId);
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Logger log = Logger.getLogger(AdminRetailerServlet.class.getName());
		String action = request.getParameter("action");
		System.out.println("ActionName: " + action);
		if ("Register Retailer".equals(action)){
////			response.getWriter().append("Served at: ").append(request.getContextPath());
			String Name = request.getParameter("Name");
			String Contact1 = request.getParameter("Contact1");
			String Contact2 = request.getParameter("Contact2");
			int SetTopBoxLimit = Integer.parseInt(request.getParameter("SetTopBoxLimit"));
			int CreditLimit = Integer.parseInt(request.getParameter("CreditLimit"));
			int CommissiononSale = Integer.parseInt(request.getParameter("Commission%onSale"));
			int ServiceCharge = Integer.parseInt(request.getParameter("ServiceCharge"));
			int InventoryCost = Integer.parseInt(request.getParameter("InventoryCost"));
			String Address1 = request.getParameter("Address1");
			String Address2 = request.getParameter("Address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int Zipcode = Integer.parseInt(request.getParameter("Pincode/Zipcode"));
//			
			System.out.printf("Name: %s, contact1: %s, contact2: %s, settopboxlimit: %d, creditlimit: %d, commisionSale: %d,"
							+ "ServiceCharge: %d, inventorycost: %d, address1: %s, address2: %s, city: %s, state: %s, zipcode: %d\n",
							Name, Contact1, Contact2, SetTopBoxLimit, CreditLimit, CommissiononSale, ServiceCharge, InventoryCost,
							Address1, Address2, city, state, Zipcode);
//			
//			
			Retailer retailer = new Retailer();
//			
			 retailer.setRetailName(Name);
			 retailer.setRetailContact1(Contact1);
			 retailer.setRetailContact2(Contact2);
			 retailer.setBoxLimit(SetTopBoxLimit);
			 retailer.setCreditLimit(CreditLimit);
			 retailer.setRetailCommission(CommissiononSale);
			 retailer.setRetailServiceCharge(ServiceCharge);
			 retailer.setInventCost(InventoryCost);
			 retailer.setRetailAddress1(Address1);
			 retailer.setRetailAddress2(Address2);
			 retailer.setRetailCity(city);
			 retailer.setRetailState(state);
			 retailer.setRetailZip(Zipcode);		
			 
			 System.out.println(retailer);
			try {
				InfinityService service = new InfinityService();
				service.insertRetailer(retailer);
				 
				 // call service to insert
		
				System.out.println("Retailer inserted successfully into NEW_NEON_RETAILER");
				
				request.getRequestDispatcher("../Views/Admin/temp_retailer_admin.jsp").forward(request, response);
//				request.getRequestDispatcher("/admin/retailer").forward(request, response);
				
			} catch (Exception ex) {
				// TODO: handle exception
				log.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
	}

}