package com.controller;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;

import com.service.InfinityService;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usr = request.getParameter("email");
		System.out.println(usr);
		if (usr != null) {
			 
					InfinityService ls = new InfinityService();
					System.out.println(ls);
					 if (ls.checkEmail(usr) !=null) {
						 
						 out.println("<html><body onload=\"alert('Wrong')\"></body></html>");
					 } 
					 else {
						 System.out.println("Fine");
						 //INSERT STATEMENT GOES HERE
						 
						 
					 }
			}
		
//			HttpSession session = request.getSession();
//			session.setAttribute("s", s);
//			request.getRequestDispatcher("./PokélfPages/SelectedPokélf.jsp").forward(request, response);
//		} else {
//			// no ID, do a getAll()
//			request.getRequestDispatcher("/Pokélf/List").forward(request, response);
//		}
		// change to forward login page route
//		request.getRequestDispatcher("${pageContext.request.contextPath}/Views/login.jsp").forward(request, response);
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
		String password = request.getParameter("password");
//		String password2 = request.getParameter("password2");
		String streetAddress1 = request.getParameter("streetAddress1");
		String streetAddress2 = request.getParameter("streetAddress2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipCode = Integer.parseInt(request.getParameter("zip"));
		String phone = request.getParameter("phone");
		
//		
		System.out.println(email);
		if (email != null) {
					
					InfinityService ls = new InfinityService();
					out.println(ls);
					 if (ls.checkEmail(email) !=null) {
						 
						 PrintWriter out = response.getWriter();
						 out.println( "<html>" + "<head><title></title><body><script>alert('register failed')</script></body></head>");
					 } 
					 else {
						 System.out.println("Proceed with registration. Email does not exist in db.");
						 //INSERT STATEMENT GOES HERE
													//new instance of Customer
						 Customer customer = new Customer();
						 customer.setFirstName(firstName);
						 customer.setLastName(lastName);
						 customer.setEmail(email);
						 customer.setPassword(password);
						 customer.setAddress1(streetAddress1);
						 customer.setAddress2(streetAddress2);
						 customer.setCity(city);
						 customer.setState(state);
						 customer.setZip(zipCode);
						 customer.setPhone(phone);
						 // call service to insert
						 ls.insertCustomer(customer);
				
						 System.out.println("Customer inserted successfully into NEW_NEON_CUSTOMERS");
						 //<!--  THIS IS THE CUSTOMER REGISTER OUTSIDE OF DASHBOARDS -->
						 
							request.getRequestDispatcher("/Views/Customer/customerDashboard.jsp").forward(request, response);
						 
						 
						 if(ls.checkEmail(email) != null) {
							 ls.insertIntoLogin(customer);
							 System.out.println("Inserted into Login");
						 } else {
							 System.out.println("FAILED");

						 }
					 }
			}
		
		

//		request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
	}
	
	

}
