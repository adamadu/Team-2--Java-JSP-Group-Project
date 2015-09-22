/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adam
 * Date Modified: Sept 22 2015
 * Purpose: This class handles all database functions relating to the packages_products_suppliers table.
 */
public class PackagesProductsSuppliersDB {
    
    //Function to delete a specific product suppliers information relating to a package
    public static int deletePackagesProductsSuppliers(int packageId, int productSupplierId)
    {
        int result = -1;
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
        ) {
            result = statement.executeUpdate("DELETE FROM packages_products_suppliers WHERE PackageId=" + packageId + " AND ProductSupplierId=" + productSupplierId);  
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error when deleting package_product_suppler" + e.getMessage());
        }
        return result;
    }
    
    //Function to insert a new packages_products_suppliers entry into the database
    public static int insertNewPackagesProductsSuppliersEntry(int packageId, int productSupplierId)
    {
        int result = -1;
        try (
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
        ) {
            result = statement.executeUpdate("INSERT INTO packages_products_suppliers VALUES ('" + packageId + "', '" + productSupplierId + "')");
        }
        catch (SQLException e)
        {
            System.out.println("There was an erro when inserting new entry into packages_products_suppliers " + e.getMessage());
        }
        return result;
    }
}
