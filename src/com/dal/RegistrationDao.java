package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bean.*;
import com.utilities.DbCon;

public class RegistrationDao {
	private static String table = "NEW_NEON_CUSTOMER";
	 private static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	
	
	public Customer checkUser(String email) {
		
		Connection con = DbCon.getConnection();
		Customer s = null;
		try
		{
			String qry = "SELECT EMAIL FROM "+table+ " "+
					"WHERE EMAIL = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				s = new Customer();
				s.setEmail(email);
			}
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		return s;
	}

	public void insertCustomer(Customer customer) {
		// query
		Connection con = DbCon.getConnection();
		int rowsAffected=0;
		try{
			//SEND TO NEW_NEON_CUSTOMERS
			String qry = "INSERT INTO " +table+ " (FIRSTNAME, LASTNAME, EMAIL, PHONE, CREATION_DATE, ADDRESS1, ADDRESS2, CITY, STATE_PROVINCE, ZIP_CODE, CUST_PASSWORD) VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getEmail());
			st.setString(4, customer.getPhone());
			
			java.util.Date date = new Date();
			date = new java.sql.Timestamp(date.getTime());
			st.setObject(5, date);
			st.setString(6, customer.getAddress1());
			st.setString(7, customer.getAddress2());
			st.setString(8, customer.getCity());
			st.setString(9, customer.getState());
			st.setInt(10, customer.getZip());
			st.setString(11, customer.getPassword());
			rowsAffected = st.executeUpdate();
						
		}
		catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
		finally {
			DbCon.close();
		}
		
		
	
	}
	public void  insertToLogin(Customer customer){
		//query to see if the email exists in the db
		
		Connection con = DbCon.getConnection();
       
//		String qry2 = "INSERT INTO NEW_NEON_USER_LOGIN (USERNAME, USER_PASSWORD, USER_TYPE, USER_ID)VALUES(?,?,?,?)";  
//		String qryID = "SELECT CUSTOMER_ID FROM NEW_NEON_CUSTOMER WHERE email = '?'";
		try
		{
			String qry = "SELECT CUSTOMER_ID FROM NEW_NEON_CUSTOMER WHERE EMAIL = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,customer.getEmail());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				
			}
			
			String qry2 = "INSERT INTO NEW_NEON_USER_LOGIN (USERNAME, USER_PASSWORD, USER_TYPE, USER_ID) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry2);
			ps.setString(1,customer.getEmail());
			ps.setString(2, customer.getPassword());
			ps.setString(3, "Customer");
			ps.setInt(4, customer.getCustomerId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally {
			DbCon.close();
		}
		
		
	}
	
	public Operator checkOpEmail(String email) {
		
		Connection con = DbCon.getConnection();
		Operator s = null;
		try
		{
			String qry = "SELECT EMAIL FROM NEW_NEON_OPERATOR "+
					"WHERE EMAIL = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,email);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				s = new Operator();
				s.setEmail(email);
			}
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		return s;
	}
	
	public void insertOpToLogin(Operator operator){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

//		String qry2 = "INSERT INTO NEW_NEON_USER_LOGIN (USERNAME, USER_PASSWORD, USER_TYPE, USER_ID)VALUES(?,?,?,?)";  
//		String qryID = "SELECT CUSTOMER_ID FROM NEW_NEON_CUSTOMER WHERE email = '?'";
		try
		{
			String qry = "SELECT OPERATOR_ID FROM NEW_NEON_OPERATOR WHERE email = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,operator.getEmail());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				operator.setOperatorId(rs.getInt("OPERATOR_ID"));
			}
			
			String qry2 = "INSERT INTO NEW_NEON_USER_LOGIN (USERNAME, USER_PASSWORD, USER_TYPE, USER_ID) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry2);
			ps.setString(1,operator.getEmail());
			ps.setString(2, operator.getPassword());
			ps.setString(3, "Operator");
			ps.setInt(4, operator.getOperatorId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally {
			DbCon.close();
		}
		
	}
}