<<<<<<< HEAD

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
=======
package workshop6.Entity;

public class ProductSupplier {
	
	private int productId;
	private int supplierId;
	private int productSupplierId;
	private String prodName;
	private String supName;
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}
	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * @return the productSupplierId
	 */
	public int getProductSupplierId() {
		return productSupplierId;
	}
	/**
	 * @param productSupplierId the productSupplierId to set
	 */
	public void setProductSupplierId(int productSupplierId) {
		this.productSupplierId = productSupplierId;
	}
	/**
	 * @return the prodName
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName the prodName to set
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/**
	 * @return the supName
	 */
	public String getSupName() {
		return supName;
	}
	/**
	 * @param supName the supName to set
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}
	

>>>>>>> origin/master
}
