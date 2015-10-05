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
	
	private static final String USERNAME ="root";
	
	private static final String PASSWORD = "";
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/travelexperts";
	
	private static Connection conn = null;
	

    
    //Function to test for the mySQL JBDC Driver
    private static void testForConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error Cannot find MYSQL JDBC driver");
            System.exit(0);
        }
    }
    
    //Function to connect the the database and return the connection object
    public static Connection getConnection()
    {
        testForConnection();
        try {
            conn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            
        } catch (SQLException ex) {
            System.out.println(">>>>>>>>>Error connecting to database. Check Databse Connection<<<<<<<<<<<<<<<<<");
            System.exit(0);
        }
        return conn;
    }
	
}
