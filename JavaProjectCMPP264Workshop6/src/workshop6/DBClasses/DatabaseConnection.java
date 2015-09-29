package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adam
 * Date: Aug 28 -2015 
 * Purpose: This class is used to test and get the data base connection 
 */
public class DatabaseConnection 
{
      //Constant variables used to connecting the the database
    private static final String MYSQL_HOST = "localhost:3306";
    private static final String MYSQL_DB   = "travelexperts";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASS = "";
    
    private static Connection conn;
    
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
    
    //Function to connect the the datavase and return the connection object
    public static Connection getConnection()
    {
        testForConnection();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+ MYSQL_HOST +"/" + MYSQL_DB, MYSQL_USER, MYSQL_PASS);
            
        } catch (SQLException ex) {
            System.out.println(">>>>>>>>>Error connecting to database. Check Databse Connection<<<<<<<<<<<<<<<<<");
            System.exit(0);
            //throw new SQLException("ERROR: Driver Mannger cannot get MYSQL Connection. Message:" + ex.getMessage());
        }
        return conn;
    }
}
