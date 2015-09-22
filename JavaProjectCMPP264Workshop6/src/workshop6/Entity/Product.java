
package workshop6.Entity;

/**
 * @author Adam
 * Date: Sept 01 2015
 * Purpose: Product entity class for instantiating a new Product object
 */
public class Product 
{
    
    private int ProductId;
    private String ProdName;
    
    
    public int getProductId() 
    {
        return ProductId;
    }
    
    public String getProdName() 
    {
        return ProdName;
    }
    
    public void setProductId(int id)
    {
        this.ProductId = id;
    }
    
    public void setProdName(String name) 
    {
        this.ProdName = name;          
    }
    
    @Override
    public String toString()
    {
        return ProdName;
    }
}
