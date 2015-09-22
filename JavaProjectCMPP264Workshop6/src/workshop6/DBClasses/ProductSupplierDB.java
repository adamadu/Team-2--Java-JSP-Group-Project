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
    
    //Function to get all the productssuppliers that are related to a specific package id
    public static List<ProductSupplier> getProductSuppliersForPackage(int packageid)
    {
         //List that will store all the productsSuppliers
        List<ProductSupplier> productSuppliers = new ArrayList<>();
        
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT ProductSupplierId FROM packages_products_suppliers WHERE PackageId=" + packageid); 
        ) {
            while (result.next())
            {
                //Make new product from each entry in the database
                ProductSupplier productSupplier = new ProductSupplier();
                //Set the props
                productSupplier.setProductSupplierId(result.getInt("ProductSupplierId"));
                productSupplier.setProductId(getProductIdForProductSupplierId(result.getInt("ProductSupplierId")));
                productSupplier.setSupplierId(getSupplierIdForProductSupplierId(result.getInt("ProductSupplierId")));
                //Add the product to the products list
                productSuppliers.add(productSupplier);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error while trying to fetch all productsuppliers for a package. Message: " + e.getMessage());
        }
        
        return productSuppliers;
    }
    
    //Fucntion to get the the product id for a specific productsupplier id
    public static int getProductIdForProductSupplierId(int productSupplierId)
    {
        //List that will store all the productsSuppliers 
        int productId = -1;
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT ProductId FROM products_suppliers WHERE ProductSupplierId=" + productSupplierId); 
        ) {
            if (result.next())
            {
                productId = result.getInt("ProductId");
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error while trying to fetch product id for a specific productsupplier id. Message: " + e.getMessage());
        }
        return productId;
    }
    
    //Function to get the supplier id for a specific productsupplier id
    public static int getSupplierIdForProductSupplierId(int productSupplierId)
    {
        //List that will store all the productsSuppliers 
        int supplierId = -1;
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT SupplierId FROM products_suppliers WHERE ProductSupplierId=" + productSupplierId); 
        ) {
            if (result.next())
            {
                supplierId = result.getInt("SupplierId");
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error in function getSupplierIdForProductSupplierId. Message: " + e.getMessage());
        }
        return supplierId;
    }
    
    //Function to get all the suppliers for a specific product id
    public static List<Supplier> getSuppliersForProduct(int productid)
    {
         //List that will store all the productsSuppliers
        List<Supplier> suppliers = new ArrayList<>();
        
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT SupplierId FROM products_suppliers WHERE ProductId=" + productid); 
        ) {
            while (result.next())
            {
                //Make new product from each entry in the database
                Supplier supplier = new Supplier();
                //Set the props
                supplier = SupplierDB.getSupplierById(result.getInt("SupplierId"));
                //Add the product to the products list
                suppliers.add(supplier);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error in fucntion getSuppliersForProduct. Message: " + e.getMessage());
        }
        
        return suppliers;
    }
    
    //Function to get the related productsupplier for a speicifc product id and supplier id
    public static ProductSupplier getProductSupplierFromProductIdAndSupplierId(int prodId, int supId)
    {
        ProductSupplier productSupplier = null;
        
        try ( //self-closing try
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT ProductSupplierId FROM products_suppliers WHERE ProductId=" + prodId + " AND SupplierId=" + supId); 
        ) {
            if (result.next())
            {
                //Make new productsupplier if the productid and supplierid was found
                productSupplier = new ProductSupplier();
                //Set the props
                productSupplier.setProductSupplierId(result.getInt("ProductSupplierId"));
                productSupplier.setProductId(prodId);
                productSupplier.setSupplierId(supId);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("There was an error in fuction getProductSupplierFromProductIdAndSupplierId. Message: " + e.getMessage());
        }
        return productSupplier;
    }
}
