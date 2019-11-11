package com.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bean.Customer;
import com.bean.Operator;
import com.utilities.DbCon;

public class OperatorDao {
	private static String tableCus = "NEW_NEON_CUSTOMER";
	private static String tableOp = "NEW_NEON_OPERATOR";
	private static PreparedStatement st;
	private static ResultSet rs;
	private static Logger log = Logger.getLogger(RegistrationDao.class.getName());

	//get all customers from customer table
	public ArrayList<Customer> getAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		Connection con = DbCon.getConnection();

		try {
			String qry = "SELECT * FROM " + tableCus;
			st = con.prepareStatement(qry);

			rs = st.executeQuery(qry);

			while (rs.next()) {
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
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
		return customers;
	}

	// get a customer from customer table using customer Id
	public Customer getById(int customerId) {
		Connection con = DbCon.getConnection();
		Customer c = null;
		try {
			String qry = "SELECT * FROM NEW_NEON_CUSTOMER WHERE CUSTOMER_ID = ?";
			PreparedStatement st = con.prepareStatement(qry);

			st.setInt(1, customerId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
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
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
		return c;
	}
	
	
	//update selected customer from customer table using the id of the customer
	public int update(int id, Customer cus, int OpId) {
		int count = 0;
		Connection con = DbCon.getConnection();

		try {
			String qry = "UPDATE " + tableCus + " SET FIRSTNAME = ?, LASTNAME = ?, EMAIL = ?, PHONE = ?,"
					+ " OPERATOR_ID = ?, RETAILER_ID = ?, ADDRESS1 = ?, ADDRESS2 =?,"
					+ " CITY = ?, STATE_PROVINCE = ?, ZIP_CODE = ?, CUST_PASSWORD = ? WHERE CUSTOMER_ID = ?";

			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, cus.getFirstName());
			st.setString(2, cus.getLastName());
			st.setString(3, cus.getEmail());
			st.setString(4, cus.getPhone());
			st.setInt(5, OpId);
			st.setInt(6, cus.getRetailerId());
			st.setString(7, cus.getAddress1());
			st.setString(8, cus.getAddress2());
			st.setString(9, cus.getCity());
			st.setString(10, cus.getState());
			st.setInt(11, cus.getZip());
			st.setString(12, cus.getPassword());
			st.setInt(13, id);
			count = st.executeUpdate();
			System.out.println(count + " records impacted");
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}

		return count;

	}

	// add a new customer into customer table and set the operator id
	public int insert(Customer cus, int operatorId) {

		int code = 0;
		
		Connection con = DbCon.getConnection();
		
		try
		{
			String qry = "INSERT INTO "+ tableCus +" (FIRSTNAME, LASTNAME, EMAIL, PHONE, CREATION_DATE, OPERATOR_ID, RETAILER_ID, ADDRESS1, ADDRESS2, CITY, STATE_PROVINCE, ZIP_CODE, CUST_PASSWORD) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1, cus.getFirstName());
			st.setString(2, cus.getLastName());
			st.setString(3, cus.getEmail());
			st.setString(4, cus.getPhone());
			
			java.util.Date date = new java.util.Date();
			java.sql.Date date1 = new java.sql.Date(date.getTime());
			Timestamp current = new java.sql.Timestamp(date1.getTime());
			st.setTimestamp(5, current);
			st.setInt(6, operatorId);
			st.setInt(7, cus.getRetailerId());
			st.setString(8, cus.getAddress1());
			st.setString(9, cus.getAddress2());
			st.setString(10, cus.getCity());
			st.setString(11, cus.getState());
			st.setInt(12, cus.getZip());
			st.setString(13, cus.getPassword());
			
			code = st.executeUpdate();
		}
		catch(Exception e)
		{
			log.log(Level.SEVERE, e.getMessage(), e);		}
		finally
		{
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}	
		return code;
	}
	
	//check if customer exists in the customer table
	public Customer checkUser(String email) {
		
		Connection con = DbCon.getConnection();
		Customer s = null;
		try
		{
			String qry = "SELECT EMAIL FROM "+ tableCus + " "+
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
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
		return s;
	}

	//insert the created customer into login table
	public void insertToLogin(Customer customer){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

		try
		{
			String qry = "SELECT CUSTOMER_ID FROM " + tableCus + " WHERE email = ?";
			
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
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
	}
	
	
	public void updateToLogin(Customer customer){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

		try
		{
			String qry = "SELECT CUSTOMER_ID FROM " + tableCus + " WHERE email = ?";
			
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
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
	}
	
	public void updateOpToLogin(Operator operator){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

		try
		{
			String qry = "SELECT OPERATOR_ID FROM " + tableOp + " WHERE email = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,operator.getEmail());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				operator.setOperatorId(rs.getInt("OPERATOR_ID"));
			}
			
			String qry2 = "UPDATE NEW_NEON_USER_LOGIN SET USERNAME = ?, USER_PASSWORD = ? WHERE USER_TYPE = ? AND USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(qry2);
			ps.setString(1, operator.getEmail());
			ps.setString(2, operator.getPassword());
			ps.setString(3, "Operator");
			ps.setInt(4, operator.getOperatorId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
	}
	
	public void deleteOpFromLogin(Operator operator){
		//query to see if the email exists in the db
		Connection con = DbCon.getConnection();

		try
		{
			String qry = "SELECT OPERATOR_ID FROM " + tableOp + " WHERE email = ?";
			
			PreparedStatement st = con.prepareStatement(qry);
			st.setString(1,operator.getEmail());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				operator.setOperatorId(rs.getInt("OPERATOR_ID"));
			}
			
			String qry2 = "DELETE FROM NEW_NEON_USER_LOGIN WHERE USER_TYPE = ? AND USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(qry2);
			ps.setString(1, "Operator");
			ps.setInt(2, operator.getOperatorId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			 log.log(Level.SEVERE, e.getMessage(), e);
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
				}
				st = null;
			}
			DbCon.close();
		}
	}
}
