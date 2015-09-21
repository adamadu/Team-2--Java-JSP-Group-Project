package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshop6.Entity.ProductSupplier;
import workshop6.Entity.Supplier;


/**
 * @author Adam
 * Date: Sept 02 2015
 * Purpose: This class talks with the database about anything to do with ProductSupplier
 */
public class ProductSupplierDB 
{
    //Function get all product Suppliers from the database
    public static List<ProductSupplier> getAllProductSupplier()
    {
        //List that will store all the productsSuppliers
        List<ProductSupplier> productsSuppliers = new ArrayList<>();
        
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM products_suppliers"); 
        ) {
            while (result.next())
            {
                //Make new product from each entry in the database
                ProductSupplier productSupplier = new ProductSupplier();
                //Set the props
                productSupplier.setProductSupplierId(result.getInt("ProductSupplierId"));
                productSupplier.setProductId(result.getInt("ProductId"));
                productSupplier.setSupplierId(result.getInt("SupplierId"));
                
                //Add the product to the products list
                productsSuppliers.add(productSupplier);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error while trying to fetch all products_suppliers. Message: " + e.getMessage());
        }
        
        return productsSuppliers;
    }
    
    //Function to get all the suppliers that are related to a specific product id
    public static List<Supplier> getAllSuppliersforProductId(int productId)
    {
        //List that will store all the productsSuppliers
        List<Supplier> suppliers = new ArrayList<>();
        
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT SupplierId FROM products_suppliers WHERE ProductId=" + productId); 
        ) {
            while (result.next())
            {
                //Make new product from each entry in the database
                Supplier supplier;
                //Set the props
                supplier = SupplierDB.getSupplierById(result.getInt("SupplierId"));
                
                //Add the product to the products list
                suppliers.add(supplier);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error while trying to fetch all suppliers for product id. Message: " + e.getMessage());
        }
        
        return suppliers;
    }
}
