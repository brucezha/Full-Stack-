package com.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bean.Admin;
import com.bean.Customer;
import com.bean.Login;
import com.bean.Operator;
import com.utilities.DbCon;

//Updated by Laukik
public class LoginDao {
//Enter table name
	public static String table = "";
	
	
	static Connection conn;
    static PreparedStatement st;
	static ResultSet rs;
	private static Logger log = Logger.getLogger(LoginDao.class.getName());
	 
	public boolean validate(Login login){
		   String username = login.getUserName();   
	       String password = login.getPassWord();
	       boolean bool = false;
	      
	       System.out.println(username);
	       System.out.println(password);
	       
	       String searchQuery = "select * from NEW_NEON_USER_LOGIN where USERNAME= ? AND USER_PASSWORD= ?";
	                     
	       System.out.println("Dao mai aaya");
	       try{
	    	   conn = DbCon.getConnection();
	    	   st = conn.prepareStatement(searchQuery);
	    	   st.setString(1,username);
	    	   st.setString(2,password);
	    	   
	    	   rs = st.executeQuery();
	    	   
	    	   if(rs.next()){
	    		   bool = true;
	    		   login.setUserId(rs.getInt(1));
	    		   login.setUserName(rs.getString(2));
	    		   login.setPassWord(rs.getString(3));
	    		   login.setUserType(rs.getString(4));
	    	   }
	       } catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
	       finally 
	       {
	          if (rs != null)	{
	             try {
	                rs.close();
	             } catch (Exception e) {}
	                rs = null;
	             }
	 	
	          if (st != null) {
	             try {
	            	 st.close();
	             } catch (Exception e) {}
	             st = null;
	             }
	 	
	         try {
				conn.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				 log.log(Level.SEVERE, ex.getMessage(), ex);
			}
	       }
	       System.out.println("Boolean in login DAO: " + bool);
	       return bool;
}
	
	//Updated by Laukik
	
	public  Customer getCustDetails(Login login){
		int userId = login.getUserId();
		System.out.println("UserID: " + userId);
	
	
		String searchQuery = "Select * from NEW_NEON_CUSTOMER where CUSTOMER_ID = ?";
		Customer cust = new Customer();
		try{
	    	   conn = DbCon.getConnection();
	    	   st = conn.prepareStatement(searchQuery);
	    	   st.setInt(1, userId);
	    	   
	    	   rs = st.executeQuery();
	    	   
	    	   if(rs.next()){
	    		   System.out.println("Hua execute");
	    		   cust.setCustomerId(rs.getInt("CUSTOMER_ID"));
	    		   System.out.println("Customer ID:" + rs.getInt("CUSTOMER_ID"));
	    		   cust.setFirstName(rs.getString("FIRSTNAME"));
	    		   cust.setLastName(rs.getString("LASTNAME"));
	    		   cust.setEmail(rs.getString("EMAIL"));
	    		   cust.setPhone(rs.getString("PHONE"));
	    		   cust.setCreationDate(rs.getDate("CREATION_DATE"));
	    		   
	    		   cust.setOperatorId(rs.getInt("OPERATOR_ID"));
	    		   cust.setRetailerId(rs.getInt("RETAILER_ID"));
	    		   cust.setAddress1(rs.getString("ADDRESS1"));
	    		   cust.setAddress2(rs.getString("ADDRESS2"));
	    		   cust.setCity(rs.getString("CITY"));
	    		   cust.setCountry(rs.getString("STATE_PROVINCE"));
	    		   cust.setState(rs.getString("ZIP_CODE"));
	    		   cust.setZip(rs.getInt("CUST_PASSWORD"));
	    		   
	    		   
	    		   

	    	   }
	       } catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
	       finally 
	       {
	          if (rs != null)	{
	             try {
	                rs.close();
	             } catch (Exception e) {}
	                rs = null;
	             }
	 	
	          if (st != null) {
	             try {
	            	 st.close();
	             } catch (Exception e) {}
	             st = null;
	             }
	 	
	         try {
				conn.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				 log.log(Level.SEVERE, ex.getMessage(), ex);
			}
	       }
	       
	       return cust;
		
	}
	
	//Updated by Laukik
	
	
	public  Admin getAdminDetails(Login login){
		int userId = login.getUserId();
		System.out.println("UserID: " + userId);
		System.out.println("Admin DAO mai ayaa");
		String searchQuery = "Select * from NEW_NEON_ADMIN_INFO where ADMIN_ID = ?";
		Admin admin = new Admin();
		try{
	    	   conn = DbCon.getConnection();
	    	   st = conn.prepareStatement(searchQuery);
	    	   st.setInt(1, userId);
	    	   
	    	   rs = st.executeQuery();
	    	   
	    	   if(rs.next()){
	    		   System.out.println("Hua execute");
	    		   admin.setAdminId(rs.getInt("ADMIN_ID"));
	    		  // System.out.println("Customer ID:" + rs.getInt("CUSTOMER_ID"));
	    		   admin.setFirstName(rs.getString("FIRST_NAME"));
	    		   admin.setLastName(rs.getString("LAST_NAME"));
	    		   admin.setEmail(rs.getString("EMAIL"));
	    		   admin.setBirthDate(rs.getDate("DATE_OF_BIRTH"));
	    		   admin.setUsername(rs.getString("ADMIN_USERNAME"));
	    		   admin.setPassword(rs.getString("ADMIN_PASSWORD"));
	    		   admin.setStoreId(rs.getInt("STORE_ID"));
	    		  
	    		   
	    		   
	    		   

	    	   }
	       } catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
	       finally 
	       {
	          if (rs != null)	{
	             try {
	                rs.close();
	             } catch (Exception e) {}
	                rs = null;
	             }
	 	
	          if (st != null) {
	             try {
	            	 st.close();
	             } catch (Exception e) {}
	             st = null;
	             }
	 	
	         try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	       
	       return admin;
		
	}
	
	
	public  Operator getOperDetails(Login login){
		int userId = login.getUserId();
		System.out.println("UserID: " + userId);
		//String userType = login.getUserType();
		System.out.println(" Operator Dao mai aaya");
		String searchQuery = "Select * from NEW_NEON_OPERATOR where OPERATOR_ID = ?";
		Operator oper = new Operator();
		
		try{
	    	   conn = DbCon.getConnection();
	    	   st = conn.prepareStatement(searchQuery);
	    	   st.setInt(1, userId);
	    	   
	    	   rs = st.executeQuery();
	    	   
	    	   if(rs.next()){
	    		   System.out.println("Hua execute");
	    		   oper.setOperatorId(rs.getInt("OPERATOR_ID"));
	    		  // System.out.println("Customer ID:" + rs.getInt("CUSTOMER_ID"));
	    		   oper.setFirstName(rs.getString("FIRST_NAME"));
	    		   oper.setLastName(rs.getString("LAST_NAME"));
	    		   oper.setEmail(rs.getString("EMAIL"));
	    		   oper.setShiftStart(rs.getString("SHIFT_START_TIME"));
	    		   oper.setShiftEnd(rs.getString("SHIFT_END_TIME"));
	    		   oper.setPhone(rs.getString("PHONE"));
	    		   oper.setCreationDate(rs.getDate("CREATION_DATE"));
	    		   oper.setActiveCustomers(rs.getInt("TOTAL_ACTIVECUSTOMERS"));
	    		   oper.setManagedCustomers(rs.getInt("MAX_MANAGEDCUSTOMERS"));
	    		   
	    		   
	    		   

	    	   }
	       } catch (Exception ex) 
	       {
	          log.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
	       finally 
	       {
	          if (rs != null)	{
	             try {
	                rs.close();
	             } catch (Exception e) {}
	                rs = null;
	             }
	 	
	          if (st != null) {
	             try {
	            	 st.close();
	             } catch (Exception e) {}
	             st = null;
	             }
	 	
	         try {
				conn.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				 log.log(Level.SEVERE, ex.getMessage(), ex);
			}
	       }
	       
	       return oper;
		
	}
}
