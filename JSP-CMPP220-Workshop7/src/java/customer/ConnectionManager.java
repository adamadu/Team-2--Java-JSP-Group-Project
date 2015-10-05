/*
Author: Geetha
Date: Sep 29, 2015
File: File to get database connection
*/
package customer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instance = null;
	
	private final String USERNAME ="root";
	
	private final String PASSWORD = "";
	
	private final String DBURL = "jdbc:mysql://localhost:3306/travelexperts";
	
	private Connection conn = null;
	
	public ConnectionManager() {}
	
	public static ConnectionManager getInstance()
	{
		if(instance == null)
		{
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private boolean openConnection()
	{
		try {
			conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			System.out.println("Get Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public Connection getConnection()
	{
		if(conn == null)
		{
			if(openConnection())
			{
				System.out.println("Connection opened");
				return conn;
			}
			else
				return null;
		}
		return conn;
	}
	
        //Method to close database connection
	public void close()
	{
		System.out.println("Connection closed");
		try{
			conn.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}
