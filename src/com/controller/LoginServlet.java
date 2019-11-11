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

import com.bean.Admin;
import com.bean.Customer;
import com.bean.Login;
import com.bean.Operator;
import com.bean.Retailer;
import com.dal.LoginDao;
import com.service.InfinityService;

/**
 * Servlet implementation class LoginServlet
 * Updated by Laukik
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(LoginServlet.class.getName());
		try {
			InfinityService service = new InfinityService();
			Login login = new Login();
			if (login.getUserType().equals("Customer")) {
				Customer cust = new Customer();
				cust = service.getCustomerDetails(login);
				int custID = cust.getCustomerId();
				System.out.println(login.getUserType());
				HttpSession session = request.getSession();
				session.setAttribute("login", login);
				session.setAttribute("cust", cust);
				session.setAttribute("custID", custID);
				request.getRequestDispatcher("/Views/Customer/customerDashboard.jsp").forward(request, response);
				
			}
		}catch(Exception ex){
			log.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		Logger log = Logger.getLogger(LoginServlet.class.getName());
		System.out.println(username);
		
		
			try{
				InfinityService service = new InfinityService();
				Login login = new Login();
				login.setUserName(username);
				login.setPassWord(password);
				boolean bool;
			
				bool = service.validate(login);
				System.out.println("In login servlet : " + login.getUserName());
				System.out.println("In login servlet : " + login.getUserType());
				if(bool){
					
					if(login.getUserType().equals("Customer")){
						
						Customer cust = new Customer();
						//cust = service.getCustomerDetails(login);
						
						int custID = login.getUserId();
						cust = service.getById(custID);
						HttpSession session = request.getSession();
						session.setAttribute("login", login);
						session.setAttribute("cust", cust);
						session.setAttribute("custID", custID);
						request.getRequestDispatcher("/Views/Customer/customerDashboard.jsp").forward(request, response);
						
					}else if(login.getUserType().equals("Admin")){
						
						Admin admin = new Admin();
						admin = service.getAdminDetails(login);
						System.out.println(login.getUserType());
						HttpSession session = request.getSession();
						session.setAttribute("login", login);
						session.setAttribute("admin", admin);
						request.getRequestDispatcher("/Views/Admin/admin.jsp").forward(request, response);
						
					}else if(login.getUserType().equals("Operator")){
						
						Operator oper = new Operator();
						oper = service.getOperDetails(login);
						System.out.println(login.getUserType());
						HttpSession session = request.getSession();
						session.setAttribute("login", login);
						session.setAttribute("oper", oper);
						request.getRequestDispatcher("/Views/Operator/operatorDashboard.jsp").forward(request, response);
						
					}else{
						HttpSession session = request.getSession();
						session.setAttribute("login", "Error! User not validated.");
						request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
					}
				}else
				{
					HttpSession session = request.getSession();
					session.setAttribute("login", "Error! User not validated.");
					request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
				}
				

			}catch(Exception ex){
				log.log(Level.SEVERE, ex.getMessage(), ex);
			}
		}
		
	

}
