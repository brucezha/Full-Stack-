package com.service;

import java.util.ArrayList;

import com.bean.Customer;
import com.bean.Operator;
import com.dal.*;

public class OperatorService {
	public static OperatorDao dao = new OperatorDao();
	
	//get all
	public ArrayList<Customer> getAll() {
		return dao.getAll();
	}
	
	//get customer by id
	public Customer getById(int CustomerId) {
		return dao.getById(CustomerId);
	}
	
	//update
	public int update(int CustomerId, Customer cus, int opId) {
		return dao.update(CustomerId, cus, opId);
	}
	
	//add a new customer
	public int insert(Customer cus, int OperatorId) {
		return dao.insert(cus, OperatorId);
	}
	
	//check if customer exists in the customer table using its email
	public Customer checkEmail(String email) {
		return dao.checkUser(email);
	}
	
	//insert the customer object into login table
	public void insertIntoLogin(Customer customer){
		dao.insertToLogin(customer);
		return;
	}
	
	//update the logintable when update
	public void updateLogin(Customer customer) {
		dao.updateToLogin(customer);
		return;
	}
	
	//update the login table of operator when update
	public void updateOpLogin(Operator operator) {
		dao.updateOpToLogin(operator);
		return;
	}
	
	//delete the login table of operator when update
		public void deleteOpLogin(Operator operator) {
			dao.deleteOpFromLogin(operator);;
			return;
		}
}
