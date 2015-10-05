/*
Author: Geetha
Date: Sep 29, 2015
File: Database operation on Customer
*/
package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
	
	private static Connection conn;
	private static Customer cust;

	//Method to check user credential
	public static boolean getUserCredential(Customer cust) 
	{
		System.out.println("Inside getUserCredential");
		boolean checkUser = false;
		
		try {
			Connection conn = ConnectionManager.getConnection();
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
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkUser;
	}
	
	//Method to cust customer details
	public static Customer getCustomer(int customerId)
	{
		try{
			Connection conn = ConnectionManager.getConnection();
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
			
			conn.close();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cust;
	}
	
	//Method to update Customer
	public static boolean updateCustomer(Customer updateCustomer)
	{
		
		try
		{
			Connection conn = ConnectionManager.getConnection();
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
			stmt.setString(1, updateCustomer.getCustFirstName());
			stmt.setString(2, updateCustomer.getCustLastName());
			stmt.setString(3, updateCustomer.getCustAddress());
			stmt.setString(4, updateCustomer.getCustCity());
			stmt.setString(5, updateCustomer.getCustProv());
			stmt.setString(6, updateCustomer.getCustPostal());
			stmt.setString(7, updateCustomer.getCustCountry());
			stmt.setString(8, updateCustomer.getCustHomePhone());
			stmt.setString(9, updateCustomer.getCustBusPhone());
			stmt.setString(10, updateCustomer.getCustEmail());
			stmt.setInt(11, updateCustomer.getAgentId());
			stmt.setString(12, updateCustomer.getUserName());
			stmt.setString(13, updateCustomer.getPassword());
			stmt.setInt(14, updateCustomer.getCustomerId());
			
			int rows = stmt.executeUpdate();
			conn.close();
			
			if(rows > 0){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	//Method to get the list of booking details of registered customer
	public static List<BookingDetail> getBookingDetails(int customerId)
	{
		List<BookingDetail> bkdtlList = new ArrayList<>();
		try
		{
			Connection conn = ConnectionManager.getConnection();
			String getBookingDetails = "SELECT * FROM bookings WHERE customerId=?";
			PreparedStatement stmt = conn.prepareStatement(getBookingDetails);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				BookingDetail bkdtl = new BookingDetail();
				bkdtl.setBookingId(rs.getInt("BookingId"));
				bkdtl.setBookingNo(rs.getString("BookingNo"));
				bkdtl.setPackageId(rs.getInt("PackageId"));
				bkdtl.setTravelerCount(rs.getInt("TravelerCount"));
				bkdtlList.add(bkdtl);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return bkdtlList;
	}

	//Method to get the package details
	public static Package getPackageDetails(int packageId)
	{
		Package pkg = null;
		try
		{
			Connection conn = ConnectionManager.getConnection();
			String getPackageDetail = "SELECT * FROM packages WHERE packageId=?";
			PreparedStatement stmt = conn.prepareStatement(getPackageDetail);
			stmt.setInt(1, packageId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				pkg = new Package();
				pkg.setPkgName(rs.getString("PkgName"));
				pkg.setPkgDesc(rs.getString("PkgDesc"));
				pkg.setPkgStartDate(rs.getDate("PkgStartDate"));
				pkg.setPkgEndDate(rs.getDate("pkgEndDate"));
				pkg.setPkgBasePrice(rs.getDouble("pkgBasePrice"));
				pkg.setPkgAgencyCommission(rs.getDouble("pkgAgencyCommission"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return pkg;
	}
	
}