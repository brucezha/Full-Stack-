package com.service;

import com.dal.*;
import com.bean.*;
import java.util.*;

public class InfinityService {
	public static RegistrationDao rdao = new RegistrationDao();
	public static LoginDao dao = new LoginDao();
	public static AdminDao adao = new AdminDao();

	// login
	public boolean validate(Login login) {
		return dao.validate(login);
	}

	public Customer getCustomerDetails(Login login) {
		return dao.getCustDetails(login);
	}

	public Admin getAdminDetails(Login login) {
		return dao.getAdminDetails(login);
	}

	public Operator getOperDetails(Login login) {
		return dao.getOperDetails(login);
	}

	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		rdao.insertCustomer(customer);
		return;
	}

	// checkEmail

	public Customer checkEmail(String email) {
		return rdao.checkUser(email);
	}

	public Operator checkOpEmail(String email) {
		return rdao.checkOpEmail(email);
	}

	public void insertIntoLogin(Customer customer) {
		rdao.insertToLogin(customer);
		return;
	}

	public void insertOpIntoLogin(Operator operator) {
		rdao.insertOpToLogin(operator);
		return;
	}

	// admin
	public ArrayList<Customer> getAll() {
		return adao.getAll();
	}

	public int update(int id, Customer cus) {
		return adao.update(id, cus);
	}

	public Customer getById(int customerId) {
		return adao.getById(customerId);
	}

	public ArrayList<Customer> getByDeleteRequest() {
		return adao.getByDeleteRequest();
	}

	public ArrayList<Operator> getAllOp() {
		return adao.getAllOp();
	}

	public int updateOp(int id, Operator op) {
		return adao.updateOp(id, op);
	}

	public int deleteCust(int id) {
		return adao.deleteCust(id);
	}

	public int checkDebtAmount(int id) {
		return adao.checkDebtAmount(id);
	}

	public Operator getByOpId(int operatorId) {
		return adao.getByOpId(operatorId);
	}

	public int deleteOp(int operatorId) {
		return adao.deleteOp(operatorId);
	}

	public int sendDeleteRequest(int customerID) {
		return adao.sendDeleteRequest(customerID);
	}

	public void insertOperator(Operator operator) {
		// TODO Auto-generated method stub
		adao.insertOperator(operator);
		return;
	}
	// Retailers

	public ArrayList<Retailer> getRetailers() {
		return adao.getRetailers();
	}

	public int insertRetailer(Retailer retailer) {
		return adao.insertRetailer(retailer);

	}

	public ArrayList<Retailer> getAllRetailer() {
		return adao.getAllRetailer();
	}
	
	public int deleteRetailerById(int id){
		return adao.deleteRetailerById(id);
	}
	
	public Retailer getRetailerById(int id){
		return adao.getRetailerById(id);
	}
	
	public int updateRetailerById(int id, Retailer retailer){
		return adao.updateRetailerById(id, retailer);
	}

}
