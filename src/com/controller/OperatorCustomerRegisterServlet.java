package com.controller;

import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.service.OperatorService;

/**
 * Servlet implementation class OperatorCustomerRegisterServlet
 */
public class OperatorCustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperatorCustomerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("email");
		System.out.println(usr);
		if (usr != null) {

			OperatorService os = new OperatorService();
			System.out.println(os);
			if (os.checkEmail(usr) != null) {

				out.println("<html><body onload=\"alert('Wrong')\"></body></html>");
			} else {
				System.out.println("Fine");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String streetAddress1 = request.getParameter("streetAddress1");
		String streetAddress2 = request.getParameter("streetAddress2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipCode = Integer.parseInt(request.getParameter("zip"));
		String phone = request.getParameter("phone");
		int operatorId = 1;
		
		System.out.println(email);
		if (email != null) {
			
			
			OperatorService os = new OperatorService();
			if (os.checkEmail(email) != null) {

				PrintWriter out = response.getWriter();
				out.println("<html>"
						+ "<head><title></title><body><script>alert('register failed')</script></body></head>");
			} else {
				System.out.println("Proceed with registration. Email does not exist in db.");
				// INSERT STATEMENT GOES HERE
				// new instance of Customer
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
//				customer.setOperatorId(1);

				os.insert(customer, operatorId);

				System.out.println("Customer inserted successfully into NEW_NEON_CUSTOMERS");
				System.out.println(os.checkEmail(email))	;
				
				request.getRequestDispatcher("/operator/customer").forward(request, response);
				if (os.checkEmail(email) != null) {
					
					os.insertIntoLogin(customer);
					
				} else {
					System.out.println("FAILED");

				}
			}
		}
	}

}