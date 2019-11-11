package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
	  static Connection conn;
      static String username = "batch112019";
      static String password = "batch112019";
      static String url = "jdbc:oracle:thin:@10.101.121.96:1521:xe";
      
      public static Connection getConnection(){
     	 try{
  			Class.forName("oracle.jdbc.OracleDriver");
  			conn = DriverManager.getConnection(url, username, password);
  			
  			
      }catch(SQLException e){
			e.printStackTrace();
		}
	 catch(ClassNotFoundException e){
			e.printStackTrace();
		}
      
     	 return conn;
      }
     	 public static void close() {
         	 try {
 				if (conn != null && !conn.isClosed()) {
 				     try {
 				        conn.close();
 				     } catch (Exception e) {
 				     }

 				     conn = null;
 				  }
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
          }
}
