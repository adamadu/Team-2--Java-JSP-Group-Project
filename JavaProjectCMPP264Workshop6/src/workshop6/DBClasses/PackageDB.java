package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import workshop6.Entity.Package;


public class PackageDB {
	
	private static ResultSet rs;
	private static Statement stmt;
	private static Connection conn;
	private static Package pkg;
	
	
	//Method to get all Package ID
        public static Vector<String> getPackageIDs()
        {
                Vector<String> pkgid = new Vector<String>();
                try
                {
                        conn = DatabaseConnection.getConnection();
                        stmt =conn.createStatement();
                        rs = stmt.executeQuery("SELECT packageId from Packages");
                        while(rs.next())
                        {
                                pkgid.add(rs.getString("packageId"));
                        }
                        conn.close();
                }
                catch(SQLException ex)
                {
                System.out.println("Error occured while retrieving packageids: " + ex.getMessage());
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
                        rs = stmt.executeQuery("SELECT * FROM Packages where packageId = " + packageId);
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
                }
                catch(SQLException ex)
                {
                System.out.println("Error occured while retrieving package details: " + ex.getMessage());
                }
                catch(Exception e){
                        e.printStackTrace();
                }
                return pkg;
        }

        //Method to add package details
        public static boolean addPackage(Package pkg)
        {
                try
                {
                        conn = DatabaseConnection.getConnection();
                        stmt =conn.createStatement();
                        //System.out.println("PackageId : " + pkg.getPackageId());
                        String addPkg = "INSERT INTO Packages"
                                        + "( PkgName"
                                        + ", PkgStartDate"
                                        + ", PkgEndDate"
                                        + ", PkgDesc"
                                        + ", PkgBasePrice"
                                        + ", PkgAgencyCommission"
                                        + ") VALUES"
                                        + "( '" + pkg.getPkgName() + "'" 
                                        + ", '" + dateToString(pkg.getPkgStartDate()) + "'"
                                        + ", '" + dateToString(pkg.getPkgEndDate()) + "'"
                                        + ", '" + pkg.getPkgDesc() + "'"
                                        + ", " + pkg.getPkgBasePrice()
                                        + ", " + pkg.getPkgAgencyCommission() 
                                        + ")";
                                         	
                       // System.out.println("addPackage: " + addPkg);
                        int numRows = stmt.executeUpdate(addPkg);
                        conn.close();
                        if (numRows == 0)
                        {
                                System.out.println("Package not inserted");
                                return false;
                        }
                        else
                            return true;
                }
                catch(SQLException e)
                {
                        e.printStackTrace();
                        return false;
                }
        }

        //Method to convert Date to StringDate
        public static String dateToString(Date pDate)
        {
        	String dateStr;
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	dateStr = sdf.format(pDate );
        	return dateStr;
        } 
        
        //Method to update Package
        public static boolean updatePackage(Package pkg)
        {
            try
            {
                conn = DatabaseConnection.getConnection();
                stmt = conn.createStatement();                                
                String updatePackage = "UPDATE Packages SET"
                                    + " PkgName = '" + pkg.getPkgName() + "'"
                                    + " ,PkgStartDate = '" + pkg.getPkgStartDate() + "'"
                                    + " ,PkgEndDate = '" + pkg.getPkgEndDate() + "'"
                                    + " ,PkgDesc = '" + pkg.getPkgDesc() + "'"
                                    + " ,PkgBasePrice = " + pkg.getPkgBasePrice()
                                    + " ,PkgAgencyCommission = " + pkg.getPkgAgencyCommission()
                                    + " WHERE packageId='" + pkg.getPackageId();

                int numRows = stmt.executeUpdate(updatePackage);
                conn.close();
                if (numRows == 0)
                {
                        System.out.println("Update package failed");
                        return false;
                }
                else
                {
                        System.out.println("updated " + numRows + " row(s) in Package");
                        return true;
                }
                
            }
            catch(SQLException ex)
            {
                System.out.println("Error occured while updating package: " + ex.getMessage());
                return false;
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
                return false;
            }
        }
                
}
