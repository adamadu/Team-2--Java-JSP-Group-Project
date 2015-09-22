/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import workshop6.Entity.Product;

/**
 *
 * @author Adam
 */
public class PackagesProductsSuppliersDB {
    
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
    
}
