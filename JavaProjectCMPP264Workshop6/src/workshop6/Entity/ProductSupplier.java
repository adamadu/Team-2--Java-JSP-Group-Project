package workshop6.Entity;

/**
 * @author Adam
 * Date: Sept 02 2015
 * Purpose: Supplier entity class for instantiating a new ProductSupplier object
 */
public class ProductSupplier {
    private int ProductSupplierId, ProductId, SupplierId;
    
    public int getProductSupplierId()
    {
        return ProductSupplierId;
    }
    public int getProductId()
    {
        return ProductId;
    }
    public int getSupplierId()
    {
        return SupplierId;
    }
    
    public void setProductSupplierId(int id)
    {
        ProductSupplierId = id;
    }
    public void setProductId(int id)
    {
        ProductId = id;
    }
    public void setSupplierId(int id)
    {
        SupplierId = id;
    }
}