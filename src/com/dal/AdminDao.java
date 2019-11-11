package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.bean.*;
import com.utilities.DbCon;


public class AdminDao {
private static String tableRetailer="NEW_NEON_RETAILER";
private static String tableOp="NEW_NEON_OPERATOR";
private static String table="NEW_NEON_CUSTOMER";
private static Logger log = Logger.getLogger(RegistrationDao.class.getName());
private static String tableDebt = "NEW_NEON_CUST_DEBT";

	public ArrayList<Customer> getAll()
	{
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Connection con = DbCon.getConnection();
		
		try
		{
			String qry="SELECT * FROM " + table;
			PreparedStatement st = con.prepareStatement(qry);
						
			ResultSet rs = st.executeQuery(qry);
			
			while(rs.next())
			{
				Customer cus = new Customer();
				cus.setCustomerId(rs.getInt("CUSTOMER_ID"));
				cus.setFirstName(rs.getString("FIRSTNAME"));
				cus.setLastName(rs.getString("LASTNAME"));
				cus.setEmail(rs.getString("EMAIL"));
				cus.setPhone(rs.getString("PHONE"));
				java.util.Date date = rs.getTimestamp("CREATION_DATE");
				cus.setCreationDate(date);
				cus.setOperatorId(rs.getInt("OPERATOR_ID"));
				cus.setRetailerId(rs.getInt("RETAILER_ID"));
				cus.setAddress1(rs.getString("ADDRESS1"));
				cus.setAddress2(rs.getString("ADDRESS2"));
				cus.setCity(rs.getString("CITY"));
				cus.setState(rs.getString("STATE_PROVINCE"));
				cus.setZip(rs.getInt("ZIP_CODE"));
				cus.setPassword(rs.getString("CUST_PASSWORD"));
				customers.add(cus);			
				
			}
			System.out.println(customers);
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return customers;
	}
	
	
	
	public int update(int id, Customer cus) {
		int count = 0;
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "UPDATE " + table + " SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONE = ?,"
					+ " OPERATOR_ID = ?, RETAILER_ID = ?, ADDRESS1 = ?, ADDRESS2 =?,"
					+ " CITY = ?, STATE_PROVINCE = ?, ZIP_CODE = ?, CUST_PASSWORD = ? WHERE CUSTOMER_ID = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			System.out.println(cus);
			st.setString(1, cus.getFirstName());
			st.setString(2, cus.getLastName());
			st.setString(3, cus.getEmail());
			st.setString(4, cus.getPhone());
			
			st.setInt(5, cus.getOperatorId());
			st.setInt(6, cus.getRetailerId());
			st.setString(7, cus.getAddress1());
			st.setString(8, cus.getAddress2());
			st.setString(9, cus.getCity());
			st.setString(10, cus.getState());
			st.setInt(11, cus.getZip());
			st.setString(12, cus.getPassword());
			st.setInt(13, id);
			
			count = st.executeUpdate();
			System.out.println(count+" records impacted");
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return count;
		
	}
	
	public void updateToLogin(Customer customer){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

		try
		{
			String qry = "SELECT CUSTOMER_ID FROM " + table + " WHERE email = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,customer.getEmail());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
			}
			
			String qry2 = "UPDATE NEW_NEON_USER_LOGIN SET USERNAME = ?, USER_PASSWORD = ? WHERE USER_TYPE = ? AND USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(qry2);
			ps.setString(1, customer.getEmail());
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
	
	public Customer getById(int customerId) {
		Connection con = DbCon.getConnection();
		Customer c = null;
		try {
			String qry = "SELECT * FROM NEW_NEON_CUSTOMER WHERE CUSTOMER_ID = ?";
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setInt(1, customerId);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				c = new Customer();
				c.setCustomerId(rs.getInt("CUSTOMER_ID"));
				c.setFirstName(rs.getString("FIRSTNAME"));
				c.setLastName(rs.getString("LASTNAME"));
				c.setEmail(rs.getString("EMAIL"));
				c.setPhone(rs.getString("PHONE"));
				c.setAddress1(rs.getString("ADDRESS1"));
				c.setAddress2(rs.getString("ADDRESS2"));
				c.setCity(rs.getString("CITY"));
				c.setState(rs.getString("STATE_PROVINCE"));
				c.setZip(rs.getInt("ZIP_CODE"));
				c.setPassword(rs.getString("CUST_PASSWORD"));
				c.setRetailerId(rs.getInt("RETAILER_ID"));
				c.setOperatorId(rs.getInt("OPERATOR_ID"));									
			}
		}
		catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		return c;
	}
	
	

	public ArrayList<Operator> getAllOp()
	{
		ArrayList<Operator> operators = new ArrayList<Operator>();
		
		Connection con = DbCon.getConnection();
		
		try
		{
			String qry="SELECT * FROM NEW_NEON_OPERATOR";
			PreparedStatement st = con.prepareStatement(qry);
						
			ResultSet rs = st.executeQuery(qry);
			
			while(rs.next())
			{
				Operator op = new Operator();
				op.setOperatorId(rs.getInt("OPERATOR_ID"));
				op.setFirstName(rs.getString("FIRSTNAME"));
				op.setLastName(rs.getString("LASTNAME"));
				op.setEmail(rs.getString("EMAIL"));
				op.setPhone(rs.getString("PHONE"));
				op.setShiftStart(rs.getString("SHIFT_START_TIME"));
				op.setShiftEnd(rs.getString("SHIFT_END_TIME"));
				op.setManagedCustomers(rs.getInt("MAX_MANAGEDCUSTOMERS"));
				java.util.Date date = rs.getTimestamp("CREATION_DATE");
				op.setCreationDate(date);
				op.setActiveCustomers(rs.getInt("TOTAL_ACTIVECUSTOMERS"));
				op.setPassword(rs.getString("OPERATOR_PASSWORD"));
				operators.add(op);			
			}
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return operators;
	}
	
	public ArrayList<Retailer> getRetailers()
	{
	ArrayList<Retailer> retailers = new ArrayList<Retailer>();

	    Connection con = DbCon.getConnection();

	    try
	    {
	        String qry="SELECT * FROM NEW_NEON_RETAILER";
	        PreparedStatement st = con.prepareStatement(qry);

	        ResultSet rs = st.executeQuery(qry);

	        while(rs.next())
	        {
	            Retailer rt = new Retailer();
	            rt.setRetailerId(rs.getInt("RETAILER_ID"));
	            rt.setRetailName(rs.getString("RETAILER_NAME"));
	            rt.setRetailContact1(rs.getString("RETAILER_CONTACT1"));
	            rt.setRetailContact2(rs.getString("RETAILER_CONTACT2"));
	            rt.setBoxLimit(rs.getInt("RETAILER_BOX_LIMIT"));
	            rt.setCreditLimit(rs.getInt("RETAILER_CREDIT_LIMIT"));
	            rt.setRetailCommission(rs.getInt("RETAILER_COMMISSION"));
	            rt.setRetailServiceCharge(rs.getInt("RETAILER_SERVICE_CHARGE"));
	            rt.setRetailInventId(rs.getInt("RETAILER_INVENTORY_ID"));
	            Timestamp date1 = rs.getTimestamp("RETAILER_CREATION_DATE");
	            Date date = date1;
	            rt.setRetailCreationDate(date);
	            rt.setInventCost(rs.getInt("RETAILER_INVENTORY_COST"));
	            rt.setRetailAddress1(rs.getString("ADDRESS1"));
	            rt.setRetailAddress2(rs.getString("ADDRESS2"));
	            rt.setRetailCity(rs.getString("CITY"));
	            rt.setRetailState(rs.getString("STATE_PROVINCE"));
	            rt.setRetailZip(rs.getInt("ZIP_CODE"));
	            retailers.add(rt);          
	        }
	    }
	    catch(Exception e)
	    {
	        log.log(Level.SEVERE, e.getMessage(), e);
	    }
	    finally
	    {
	        DbCon.close();
	    }

	    return retailers;
	}
	
	public int updateOp(int id, Operator op) {
		int count = 0;
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "UPDATE " + tableOp + " SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONE = ?,"
					+ " SHIFT_START_TIME = ?, SHIFT_END_TIME = ?, MAX_MANAGEDCUSTOMERS = ?,"
					+ " TOTAL_ACTIVECUSTOMERS = ?, OPERATOR_PASSWORD = ? WHERE OPERATOR_ID = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, op.getFirstName());
			st.setString(2, op.getLastName());
			st.setString(3, op.getEmail());
			st.setString(4, op.getPhone());
			st.setString(5, op.getShiftStart());
			st.setString(6, op.getShiftEnd());
			st.setInt(7, op.getManagedCustomers());
			st.setInt(8, op.getActiveCustomers());
			st.setString(9, op.getPassword());
			st.setInt(10, op.getOperatorId());
			
			count = st.executeUpdate();
			System.out.println(count+" records impacted");
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return count;
		
	}
	
	public int deleteOp(int id) {
		int count = 0;
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "DELETE FROM " + tableOp + " WHERE OPERATOR_ID = ?";
						
			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1, id);
			
			count = st.executeUpdate();
			System.out.println(count+" records impacted");
			
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return count;
	}
	
	public Operator getByOpId(int operatorId) {
		Connection con = DbCon.getConnection();
		Operator op = null;
		try {
			String qry = "SELECT * FROM " + tableOp + " WHERE OPERATOR_ID = ?";
			PreparedStatement st = con.prepareStatement(qry);
			
			st.setInt(1, operatorId);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				op = new Operator();
				op.setOperatorId(operatorId);
				op.setFirstName(rs.getString("OPERATOR_ID"));
				op.setLastName(rs.getString("FIRSTNAME"));
				op.setEmail(rs.getString("EMAIL"));
				op.setPhone(rs.getString("PHONE"));
				op.setShiftStart(rs.getString("SHIFT_START_TIME"));
				op.setShiftEnd(rs.getString("SHIFT_END_TIME"));
				op.setManagedCustomers(rs.getInt("MAX_MANAGEDCUSTOMERS"));
				op.setActiveCustomers(rs.getInt("TOTAL_ACTIVECUSTOMERS"));
				op.setPassword(rs.getString("OPERATOR_PASSWORD"));		
			}
		}
		catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return op;
	}
	
	
	public int sendDeleteRequest(int customerID){
		
		System.out.println("ID in sendDelete" + customerID);
			int rowsAffected = 0;
			String updateQuery = " update NEW_NEON_CUST_DEBT set DELETE_REQ = 'Y' where CUSTOMER_ID = ?";
			Connection conn = DbCon.getConnection();
			PreparedStatement st;
		       System.out.println("Dao mai aaya");
		       try{
		   			conn = DbCon.getConnection();
		   			st = conn.prepareStatement(updateQuery);
		   			
		   			st.setInt(1,customerID);
		    	    
		    	    
		   			rowsAffected = st.executeUpdate();
		   			System.out.println(rowsAffected);
		    	    System.out.println("record affected" + rowsAffected);
		   			
		   		} catch(Exception e)
				{
					log.log(Level.SEVERE, e.getMessage(), e);
				}
				finally
				{
					
			 	
					DbCon.close();
				}
				
				
		   		return rowsAffected;
		}
	public void insertOperator(Operator operator){
		Connection con = DbCon.getConnection();
		try{
			//SEND TO NEW_NEON_CUSTOMERS
			String qry = "INSERT INTO " +tableOp+ " (FIRSTNAME, LASTNAME, EMAIL, PHONE, SHIFT_START_TIME, SHIFT_END_TIME,"
					+ "MAX_MANAGEDCUSTOMERS, CREATION_DATE, TOTAL_ACTIVECUSTOMERS, OPERATOR_PASSWORD) VALUES(?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, operator.getFirstName());
			st.setString(2, operator.getLastName());
			st.setString(3, operator.getEmail());
			st.setString(4, operator.getPhone());
			st.setString(5, operator.getShiftStart());
			st.setString(6, operator.getShiftEnd());
			st.setInt(7, operator.getManagedCustomers());
			java.util.Date date = new Date();
			date = new java.sql.Timestamp(date.getTime());
			st.setObject(8, date);
			st.setInt(9, operator.getActiveCustomers());
			st.setString(10, operator.getPassword());
			st.executeUpdate();
						
		}
		catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
		finally {
			DbCon.close();
		}
		
		
	}
	
	
	public ArrayList<Customer> getByDeleteRequest() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Connection con = DbCon.getConnection();
		//Customer c = null;
		char delReq = 'Y';
		try {

			
			String qry = "select NEW_NEON_CUSTOMER.CUSTOMER_ID, NEW_NEON_CUSTOMER.FIRSTNAME, NEW_NEON_CUSTOMER.LASTNAME,"
					+ " NEW_NEON_CUSTOMER.EMAIL,NEW_NEON_CUSTOMER.PHONE, NEW_NEON_CUSTOMER.ADDRESS1, NEW_NEON_CUSTOMER.ADDRESS2,"
					+ " NEW_NEON_CUSTOMER.CITY, NEW_NEON_CUSTOMER.STATE_PROVINCE, NEW_NEON_CUSTOMER.ZIP_CODE, NEW_NEON_CUSTOMER.CUST_PASSWORD, "
					+ " NEW_NEON_CUSTOMER.RETAILER_ID, NEW_NEON_CUSTOMER.OPERATOR_ID, NEW_NEON_CUST_DEBT.CUSTOMER_DEBT, NEW_NEON_CUST_DEBT.DELETE_REQ from "
					+ "NEW_NEON_CUSTOMER join NEW_NEON_CUST_DEBT on NEW_NEON_CUSTOMER.CUSTOMER_ID = NEW_NEON_CUST_DEBT.CUSTOMER_ID "
					+ "where NEW_NEON_CUST_DEBT.DELETE_REQ = 'Y'";
			
			PreparedStatement st = con.prepareStatement(qry);
			
			//st.setString(1,String.valueOf(delReq));
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setCustomerId(rs.getInt("CUSTOMER_ID"));
				c.setFirstName(rs.getString("FIRSTNAME"));
				c.setLastName(rs.getString("LASTNAME"));
				c.setEmail(rs.getString("EMAIL"));
				c.setPhone(rs.getString("PHONE"));
				c.setAddress1(rs.getString("ADDRESS1"));
				c.setAddress2(rs.getString("ADDRESS2"));
				c.setCity(rs.getString("CITY"));
				c.setState(rs.getString("STATE_PROVINCE"));
				c.setZip(rs.getInt("ZIP_CODE"));
				c.setPassword(rs.getString("CUST_PASSWORD"));
				c.setRetailerId(rs.getInt("RETAILER_ID"));
				c.setOperatorId(rs.getInt("OPERATOR_ID"));	
				c.setDeleteRequest(rs.getString("DELETE_REQ").charAt(0));
			    c.setCustDebt(rs.getInt("CUSTOMER_DEBT"));
			    customers.add(c);
			}
		}
		catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		return customers;
	}
	
	public int checkDebtAmount(int id){
		
		String query = "Select CUSTOMER_DEBT from NEW_NEON_CUST_DEBT where CUSTOMER_ID = ? ";
		Connection conn = DbCon.getConnection();
		PreparedStatement st;
		int debtAmount=0;
		try{
			st = conn.prepareStatement(query);
   			
   			st.setInt(1,id);
    	    
   			ResultSet rs = st.executeQuery();
   			while(rs.next()){
   				debtAmount = rs.getInt("CUSTOMER_DEBT");
   			}
    	    
   			
		}catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return debtAmount;
	}
	
	public int deleteCust(int id){
		
		String deleteQuery = "Delete from NEW_NEON_CUSTOMER where CUSTOMER_ID= ? ";
		PreparedStatement st;
		Connection conn = DbCon.getConnection();
		int rowsAffected=0;
		try{
			st = conn.prepareStatement(deleteQuery);
			st.setInt(1, id);
			rowsAffected = st.executeUpdate();
			
		}catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally
		{
			DbCon.close();
		}
		
		return rowsAffected;
	}
	
	public int insertRetailer (Retailer retailer){
		int result = 0;
		Connection con = DbCon.getConnection();
		try{
		//SEND TO NEW_NEON_RETAILER
		System.out.println("TRING TO INSERT...");
		String qry = "INSERT INTO "+tableRetailer+ " (RETAILER_NAME,RETAILER_CONTACT1,RETAILER_CONTACT2,"
		+ "RETAILER_BOX_LIMIT,RETAILER_CREDIT_LIMIT,RETAILER_COMMISSION,"
		+ "RETAILER_SERVICE_CHARGE,"
		+ "RETAILER_INVENTORY_COST,ADDRESS1, ADDRESS2, CITY, STATE_PROVINCE,"
		+ "ZIP_CODE, RETAILER_CREATION_DATE)"
		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		        PreparedStatement st = con.prepareStatement(qry);
		        st.setString(1, retailer.getRetailName());
		        st.setString(2, retailer.getRetailContact1());
		        st.setString(3, retailer.getRetailContact2());

		        java.util.Date date = new Date();
		        date = new java.sql.Timestamp(date.getTime());
		        st.setObject(14, date);
		        System.out.println("TRING TO INSERT up to box limit...");

		        st.setInt(4, retailer.getBoxLimit());
		        st.setInt(5, retailer.getCreditLimit());
		        st.setInt(6, retailer.getRetailCommission());
		        st.setInt(7, retailer.getRetailServiceCharge());
		// st.setInt(8, retailer.getRetailInventId());
		st.setInt(8, retailer.getInventCost());
		st.setString(9, retailer.getRetailAddress1());
		st.setString(10, retailer.getRetailAddress2());
		st.setString(11, retailer.getRetailCity());
		st.setString(12, retailer.getRetailState());
		st.setInt(13, retailer.getRetailZip());
		// st.setInt(16, 123);

		        System.out.println("TRING TO EXECUTE UPDATE..");

		        result = st.executeUpdate();

		    }
		    catch (Exception ex) 
		       {
		          log.log(Level.SEVERE, ex.getMessage(), ex);
		        } 
		    finally {
		        DbCon.close();
		    }
		    return result;
		}
		public ArrayList<Retailer> getAllRetailer()
		{
		    ArrayList<Retailer> retailers = new ArrayList<Retailer>();

		    Connection con = DbCon.getConnection();

		    try
		    {
		        String qry="SELECT * FROM " + tableRetailer;
		        PreparedStatement st = con.prepareStatement(qry);

		        ResultSet rs = st.executeQuery(qry);

		        while(rs.next())
		        {
		            Retailer retailer = new Retailer();
		            retailer.setRetailerId(rs.getInt("RETAILER_ID"));
		            retailer.setRetailName(rs.getString("RETAILER_NAME"));


		            retailer.setRetailContact1(rs.getString("RETAILER_CONTACT1"));
		            retailer.setRetailContact2(rs.getString("RETAILER_CONTACT2"));
		// java.util.Date date = rs.getTimestamp(RETAILER_CREATION_DATE);
		java.sql.Date date1 = new java.sql.Date(rs.getTimestamp("RETAILER_CREATION_DATE").getTime());
		retailer.setRetailCreationDate(date1);
		retailer.setBoxLimit(rs.getInt("RETAILER_BOX_LIMIT"));
		retailer.setCreditLimit(rs.getInt("RETAILER_CREDIT_LIMIT"));
		retailer.setRetailCommission(rs.getInt("RETAILER_COMMISSION"));
		retailer.setRetailServiceCharge(rs.getInt("RETAILER_SERVICE_CHARGE"));
		retailer.setRetailInventId(rs.getInt("RETAILER_INVENTORY_ID"));
		retailer.setInventCost(rs.getInt("RETAILER_INVENTORY_COST"));
		retailer.setRetailAddress1(rs.getString("ADDRESS1"));
		retailer.setRetailAddress2(rs.getString("ADDRESS2"));
		retailer.setRetailCity(rs.getString("CITY"));
		retailer.setRetailState(rs.getString("STATE_PROVINCE"));
		retailer.setRetailZip(rs.getInt("ZIP_CODE"));

		            retailers.add(retailer);            

		        }
		        System.out.println(retailers);
		    }
		    catch(Exception e)
		    {
		        log.log(Level.SEVERE, e.getMessage(), e);
		    }
		    finally
		    {
		        DbCon.close();
		    }

		    return retailers;
		}
		
		public int deleteRetailerById(int id){
			int result = 0;
			Connection con = DbCon.getConnection();
			
			try{
				// Prepare Query
				String qry = String.format("DELETE FROM %s WHERE retailer_id = ?", tableRetailer);
				PreparedStatement pst = con.prepareStatement(qry);
				pst.setInt(1, id);
				
				// ExecuteUpdate
				result = pst.executeUpdate();
				
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DbCon.close();
			}
			
			
			return result;
		}
}
