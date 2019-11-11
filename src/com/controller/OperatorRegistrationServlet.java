package com.controller;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Operator;
import com.service.InfinityService;

/**
 * Servlet implementation class OperatorRegistrationServlet
 */
public class OperatorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usr = request.getParameter("email");
		if (usr != null) {
			 
					InfinityService ls = new InfinityService();
					System.out.println(ls);
					 if (ls.checkEmail(usr) !=null) {
						 
						 out.println("<html><body onload=\"alert('Wrong')\"></body></html>");
						 System.out.println("Duplicate");
					 } 
					 else {
						 System.out.println("Fine");
						 //INSERT STATEMENT GOES HERE						 
					 }
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String shiftStart = request.getParameter("shiftStart");
		System.out.println(shiftStart);
		
		String shiftEnd = request.getParameter("shiftEnd");
		int maxCount = Integer.parseInt(request.getParameter("maxCount"));
		String password = "1234"; 
		System.out.println("reached parameters");
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
//			System.out.println(request.getParameter("creationDate"));
		Date date = new Date();

//		    Date parsedDate = (Date) dateFormat.parse(request.getParameter("creationDate"));
		Timestamp creationDate = new java.sql.Timestamp(date.getTime());



System.out.println(email);
if (email != null) {
				
				InfinityService ls = new InfinityService();
				out.println(ls);
				 if (ls.checkOpEmail(email) !=null) {
					 
					 PrintWriter out = response.getWriter();
					 out.println( "<html>" + "<head><title></title><body><script>alert('register failed')</script></body></head>");
				 } 
				 else {
					 System.out.println("Proceed with registration. Email does not exist in db.");
					 //INSERT STATEMENT GOES HERE
												//new instance of Customer
					 Operator operator  = new Operator();
					 operator.setFirstName(firstName);
					 operator.setLastName(lastName);
					 operator.setEmail(email);
					 operator.setPhone(phone);
					 operator.setShiftStart(shiftStart);
					 operator.setShiftEnd(shiftEnd);
					 operator.setManagedCustomers(maxCount); 
					 operator.setPassword(password);
					 operator.setCreationDate(creationDate);
					 
					 // call service to insert
					 ls.insertOperator(operator);
			
					 System.out.println("operator inserted successfully into NEW_NEON_Operator");
					 request.getRequestDispatcher("/admin/operator").forward(request, response);
					 System.out.println(ls.checkEmail(email));
					 if(ls.checkOpEmail(email) != null) {
						 
						 ls.insertOpIntoLogin(operator);
					 } else {
						 System.out.println("FAILED");

					 }

				 }
}

	}

}
