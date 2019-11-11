package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.InfinityService;
import com.service.OperatorService;
import com.bean.*;
/**
 * Servlet implementation class AdminEditOperatorServlet
 */
public class AdminEditOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminEditOperatorServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		String action = request.getParameter("action");
		if (idString != null) {
			Integer id=Integer.parseInt(idString);	
			InfinityService service = new InfinityService();
			Operator op  = service.getByOpId(id);		
			HttpSession session = request.getSession();
			session.setAttribute("operator", op);
			
			OperatorService os = new OperatorService();

			if (action == null) {
				
				request.getRequestDispatcher("/Views/Admin/AdminEditOperatorMgmt.jsp").forward(request, response);
			}
			
			else if (action.equalsIgnoreCase("delete")) {
				InfinityService c  = new InfinityService();
				c.deleteOp(id);
				os.deleteOpLogin(op);
				System.out.println("reached delete");

				request.getRequestDispatcher("/admin/operator").forward(request, response);
			}
			

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
		Operator o = new Operator();
		o.setOperatorId(Integer.parseInt(request.getParameter("operatorId")));
		o.setFirstName(request.getParameter("firstName"));
		o.setLastName(request.getParameter("lastName"));
		o.setEmail(request.getParameter("email"));
		o.setPassword(request.getParameter("password"));
		o.setPhone(request.getParameter("phone"));
		o.setShiftStart(request.getParameter("shiftStart"));
		o.setShiftEnd(request.getParameter("shiftEnd"));
		
		o.setManagedCustomers(Integer.parseInt(request.getParameter("managedCustomers")));
		o.setActiveCustomers(Integer.parseInt(request.getParameter("activeCustomers")));
		
		String action = request.getParameter("action");

		System.out.println(action);
		int id = Integer.parseInt(request.getParameter("operatorId"));
		OperatorService os = new OperatorService();

		int recordCount = 0;
		InfinityService c  = new InfinityService();
		if (action.equals("update")) {
			recordCount = c.updateOp(id, o);
		} else if (action.equals("delete")) {
			System.out.print(recordCount);		
			}
		if (recordCount == 1) {
			HttpSession session = request.getSession();
			if (action.equals("update")) {
				os.updateOpLogin(o);
				System.out.println("up");
				session.setAttribute("message",  "updated!");
			} else if (action.equalsIgnoreCase("delete")) {
				System.out.println("delete");
				
				
				session.setAttribute("message", "deleted");
			}
			request.getRequestDispatcher("/admin/operator").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			if (action.equals("add")) {
				session.setAttribute("error", "Failed adding !");
			} 
			//request.getRequestDispatcher("./Views/Admin/AdminEditCustomer.jsp").forward(request, response);
			System.out.println("Error");
	}
		}

}
