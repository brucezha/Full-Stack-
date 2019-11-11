package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.bean.Login;
import com.bean.Operator;
import com.bean.Retailer;
import com.service.InfinityService;


/**
* Servlet implementation class AdminCustomerRegisterServlet
*/
public class AdminCustomerRegisterServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
 * Default constructor. 
 */
public AdminCustomerRegisterServlet() {
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
// response.getWriter().append(Served at:).append(request.getContextPath());
	
	 System.out.println("Inside admin Customer");
	 
	// System.out.println("First name in admin cust servlet: " + customerBean.getFirstName());
	 
	 InfinityService service = new InfinityService();
String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String streetAddress1 = request.getParameter("streetAddress1");
String streetAddress2 = request.getParameter("streetAddress2");
String city = request.getParameter("city");
String state = request.getParameter("state");
String zip = request.getParameter("zip");
String date_input = request.getParameter("example-date-input");
//String exampleSelect1 = request.getParameter("exampleSelect1");
//String exampleSelect2 = request.getParameter("exampleSelect2");
String defaultPassword = "abc@123";
String operName = request.getParameter("operators");
String retailerName = request.getParameter("retailers");
System.out.println("Operator name: " + operName + "Retailer name: "  + retailerName);

int operId=0;
int retailerId=0;

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


// Login customer = new Login();
//

// customer.setUserName(request.getParameter(firstName));
// customer.setPassWord(request.getParameter(lastName));
// customer.setUserType(request.getParameter(userType));

Customer customerBean = new Customer();
// customerBean.setCustomerId(Integer.parseInt(request.getParameter(customer_id)));
customerBean.setFirstName(firstName);
customerBean.setLastName(lastName);
customerBean.setEmail(email);
customerBean.setPhone(phone);
// java.sql.Date creationDate = new java.sql.Date(customerBean.getCreationDate().getTime());
customerBean.setOperatorId(operId);
customerBean.setRetailerId(retailerId);
customerBean.setAddress1(streetAddress1);
customerBean.setAddress2(streetAddress2);
customerBean.setCity(city);
customerBean.setState(state);

customerBean.setZip(Integer.parseInt(request.getParameter("zip")));
customerBean.setPassword(defaultPassword);

    System.out.println("First name in admin cust servlet: " + customerBean.getFirstName());

    String action = request.getParameter("action");
//    int rowsAffected=0;
//    int rowsAffected1 =0;
    // try catch with Infinity Service
// InfinityService fs = new InfinityService();

    
    try {           
        if (action.equals("submit")) {
            InfinityService fs = new InfinityService();

           fs.insertCustomer(customerBean);
            //String email = customerBean.getEmail();
           
            fs.insertIntoLogin(customerBean);
             
            
            System.out.println("WE INSERTED CUSTOMER THRU ADMIN!!!!");
            HttpSession session = request.getSession();
            session.setAttribute("success", "Added successfully!");
        	request.getRequestDispatcher("/admin/customer").forward(request, response);

        }
        else {
            System.out.println("Error");
        }
    }
    catch(Exception e) {
        PrintWriter pw = response.getWriter();
        pw.println(e);
    }
    // call service.insert"" [logintable"username/password/type" + /customer"everything"]
}
}