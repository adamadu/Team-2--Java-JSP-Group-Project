/*
Author : Geetha Muniswamy
Date: September 29, 2015
File: Database functions based on Customer
*/
package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbManager {
	
	private static Connection conn = ConnectionManager.getInstance().getConnection();
	private static Customer cust;
        
        //Method to check user credential
	public static boolean getUserCredential(Customer cust) 
	{
		System.out.println("Inside getUserCredential");
		boolean checkUser = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			//Connection conn = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * from customers where UserName=? AND Password=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cust.getUserName());
			stmt.setString(2, cust.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next() && rs.getString("UserName").equals(cust.getUserName()) && 
							rs.getString("Password").equals(cust.getPassword())) 
			{
				System.out.println("Customer name : " + rs.getString("CustFirstName"));
				cust.setCustomerId(rs.getInt("CustomerId"));
				checkUser = true;
				
			}		
			//ConnectionManager.getInstance().close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkUser;
	}
	
        //Method to get the details of customer
	public static Customer getCustomer(int customerId)
	{
		try{
			System.out.println("Inside getCustomer");
			Class.forName("com.mysql.jdbc.Driver");
			String getCust = "SELECT * from customers where CustomerId=?";
			PreparedStatement stmt = conn.prepareStatement(getCust);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			Customer cust = null;
			if(rs.next())
			{
				cust = new Customer();
				cust.setCustFirstName(rs.getString("CustFirstName"));
				cust.setCustLastName(rs.getString("CustLastName"));
				cust.setCustAddress(rs.getString("CustAddress"));
				cust.setCustCity(rs.getString("CustCity"));
				cust.setCustProv(rs.getString("CustProv"));
				cust.setCustPostal(rs.getString("CustPostal"));
				cust.setCustCountry(rs.getString("CustCountry"));
				cust.setCustHomePhone(rs.getString("CustHomePhone"));
				cust.setCustBusPhone(rs.getString("CustBusPhone"));
				cust.setCustEmail(rs.getString("CustEmail"));
				cust.setAgentId(rs.getInt("AgentId"));
				cust.setUserName(rs.getString("UserName"));
				cust.setPassword(rs.getString("Password"));
				return cust;
				
			}
			ConnectionManager.getInstance().close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}
	
        //Method to update the customer details
	public static boolean updateCustomer(Customer cust) throws ClassNotFoundException, SQLException
	{
		System.out.println("Inside updateCustomer");
		Class.forName("com.mysql.jdbc.Driver");
		String updateCust = "UPDATE customers SET " 
                                        + "CustFirstName = ? ," 
                                        + "CustLastName = ? , " 
                                        + "CustAddress = ? ," 
                                        + "CustCity = ? ," 
                                        + "CustProv = ? ,"
                                        + "CustPostal = ? ,"
                                        + "CustCountry = ? ,"
                                        + "CustHomePhone = ? ,"
                                        + "CustBusPhone = ? ,"
                                        + "CustEmail = ? ,"
                                        + "AgentId = ? ,"
                                        + "UserName = ? ,"
                                        + "Password = ? "
                                        + "WHERE CustomerId = ?";
		PreparedStatement stmt = conn.prepareStatement(updateCust);
		stmt.setString(1, cust.getCustFirstName());
		stmt.setString(2, cust.getCustLastName());
		stmt.setString(3, cust.getCustAddress());
		stmt.setString(4, cust.getCustCity());
		stmt.setString(5, cust.getCustProv());
		stmt.setString(6, cust.getCustPostal());
		stmt.setString(7, cust.getCustCountry());
		stmt.setString(8, cust.getCustHomePhone());
		stmt.setString(9, cust.getCustBusPhone());
		stmt.setString(10, cust.getCustEmail());
		stmt.setInt(11, cust.getAgentId());
		stmt.setString(12, cust.getUserName());
		stmt.setString(13, cust.getPassword());
		stmt.setInt(14, cust.getCustomerId());
		
		int rows = stmt.executeUpdate();
		
		ConnectionManager.getInstance().close();
		
		if(rows > 0){
			return true;
		}
		else{
			return false;
		}
		
	}
}