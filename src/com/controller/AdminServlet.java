package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Login;
import com.service.InfinityService;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("Admin servlet mai aaya");
		String action = request.getParameter("action");
		String select;
		int custID =  (Integer) request.getSession(false).getAttribute("custID");
		int rowsAffected;
		System.out.println("Admin Servlet mai ID hai : " + custID);
		
		if("Discontinue".equals(action)){
			System.out.println("ID: " + request.getSession(false).getAttribute("custID"));
			InfinityService service = new InfinityService();
			rowsAffected = service.sendDeleteRequest(custID);
			if(rowsAffected >= 1){
			HttpSession session = request.getSession();
			session.setAttribute("result", "The delete request was sent successfully");
			request.getRequestDispatcher("/Views/Customer/customerDashboard.jsp").forward(request, response);
			}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("result", "Error sending delete request");
			request.getRequestDispatcher("/Views/Customer/customerDashboard.jsp").forward(request, response);
		}
		
		}
		
		
		
	}

}
