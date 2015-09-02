package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import workshop6.Entity.Package;
import workshop6.Entity.ProductSupplier;

import workshop6.DBClasses.DatabaseConnection;

public class PackageDB {
	
	private static ResultSet rs;
	private static Statement stmt;
	private static Connection conn;
	private static Package pkg;
	private static List<ProductSupplier> productSupplier;
	
	//Method to get all Package ID
		public static Vector<String> getPackageIDs()
		{
			Vector<String> pkgid = new Vector<String>();
			try
			{
				conn = DatabaseConnection.getConnection();
				stmt =conn.createStatement();
				rs = stmt.executeQuery("select packageId from Packages");
				while(rs.next())
				{
					pkgid.add(rs.getString("packageId"));
				}
				conn.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return pkgid;
		}
		
		//Method to get the package details for the particular package
		public static Package getPackage(String packageId)
		{
			try{
				conn = DatabaseConnection.getConnection();
				stmt =conn.createStatement();
				rs = stmt.executeQuery("select * from Packages where packageId = " + packageId);
				if(rs.next())
				{
					//Agent agent = new Agent();
					pkg = new Package();
					pkg.setPackageId(rs.getInt(1));
					pkg.setPkgName(rs.getString(2));
					pkg.setPkgStartDate(rs.getDate(3));
					pkg.setPkgEndDate(rs.getDate(4));
					pkg.setPkgDesc(rs.getString(5));
					pkg.setPkgBasePrice(rs.getDouble(6));
					pkg.setPkgAgencyCommission(rs.getDouble(7));
				}
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return pkg;
		}

		/*public static List<ProductSupplier> getProductSupplier(String packageId)
		{
			List<ProductSupplier> productSupplier = new List<ProductSupplier>();
			
			String qrySelect = "SELECT ps.ProductSupplierId, ps.ProductId, p.ProdName, ps.SupplierId, s.SupName " +
	                "FROM Packages_Products_Suppliers pps, Products_Suppliers ps, Products p, Suppliers s " +
	                "WHERE pps.ProductSupplierId = ps.ProductSupplierId AND ps.ProductId = p.ProductId " + 
	                "AND ps.SupplierId = s.SupplierId AND pps.PackageId = " + packageId;
			
			return productSupplier;
		}*/
}
