package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.service.OperatorService;

/**
 * Servlet implementation class OperatorEditCustomerServlet
 */
public class OperatorEditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorEditCustomerServlet() {
        super();
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
			OperatorService service = new OperatorService();
			Customer cus  = service.getById(id);		
			HttpSession session = request.getSession();
			session.setAttribute("customer", cus);
			request.getRequestDispatcher("/Views/Operator/OperatorEdit.jsp").forward(request, response);
		} else {
			// no ID, do a getAll()
			System.out.println("Fail to get a valid id");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer cus = new Customer();
		cus.setFirstName(request.getParameter("firstName"));
		cus.setLastName(request.getParameter("lastName"));
		cus.setEmail(request.getParameter("email"));
		cus.setPhone(request.getParameter("phone"));
//		cus.setOperatorId(Integer.parseInt(request.getParameter("operatorId")));
//		cus.setRetailerId(Integer.parseInt(request.getParameter("retailerId")));
		cus.setAddress1(request.getParameter("streetAddress1"));
		cus.setAddress2(request.getParameter("streetAddress2"));
		cus.setCity(request.getParameter("city"));
		cus.setState(request.getParameter("state"));
		cus.setZip(Integer.parseInt(request.getParameter("zip")));
		cus.setPassword(request.getParameter("password"));
		
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("customerId"));
		int opId = 1; //change this later
		
		int recordCount = 0;
		OperatorService c  = new OperatorService();
		if (action.equals("update")) {
			recordCount = c.update(id, cus, opId);
		}
		
		if (recordCount == 1) {
			System.out.println("updated!");
			HttpSession session = request.getSession();
			if (action.equals("update")) {
				session.setAttribute("message",  "updated!");
			}
			c.updateLogin(cus);
			request.getRequestDispatcher("/operator/customer").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			if (action.equals("add")) {
				session.setAttribute("error", "Failed adding !");
			} 
			System.out.println("Error");
		}
	}

}
