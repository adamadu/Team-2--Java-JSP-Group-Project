/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop6.Entity.Customer;

/**
 *
 * @author 689508
 */
public class CustomerDB {
    
    public static Vector<Customer> GetCustomersByAgentId(String agentId){
        Vector<Customer> customers = new Vector<Customer>();
        //connect to database
        try (
                        Connection conn = DatabaseConnection.getConnection();
            
            //select statement
                        PreparedStatement preStatement =
                                        conn.prepareStatement("SELECT * FROM customers WHERE AgentId = ?");)
        
            {
					ResultSet rset;
					
					//set the parameter in the statement with the agencyId
					preStatement.setString(1, agentId);
					//get the result set
					rset = preStatement.executeQuery();
					while (rset.next()) {
                                                Customer customer = new Customer();
						customer.setCustomerId(rset.getInt(1));
						customer.setCustFirstName(rset.getString(2));
						customer.setCustLastName(rset.getString(3));
						customer.setCustAddress(rset.getString(4));
						customer.setCustCity(rset.getString(6));
						customer.setCustProv(rset.getString(5));
						customer.setCustPostal(rset.getString(7));
                                                customer.setCustCountry(rset.getString(8));
						customer.setCustHomePhone(rset.getString(9));
                                                customer.setCustBusPhone(rset.getString(10));
                                                customer.setCustEmail(rset.getString(11));
                                                customer.setAgentId(rset.getInt(12));
                                                customer.setUserName(rset.getString(13));
                                                customer.setPassword(rset.getString(14));
                                                customers.add(customer);
					}
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            return customers;            
    }
    
}
