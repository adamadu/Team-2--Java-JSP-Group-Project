
package packages;

import customer.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DaryaO.
 */
public class PackageDB {
    
    public static List<Package> listPackages() throws SQLException{
        
        List<Package> packages = new ArrayList<Package>();
        try(
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from packages");
            ResultSet rs = st.executeQuery();
                )
        {
            while(rs.next())
            {
            Package pkg = new Package();
            pkg.setPkgAgencyCommission(rs.getDouble("PkgAgencyCommission"));
            pkg.setPkgBasePrice(rs.getDouble("PkgBasePrice"));
            pkg.setPkgDesc(rs.getString("PkgDesc"));
            pkg.setPkgEndDate(rs.getDate("PkgEndDate"));
            pkg.setPkgName(rs.getString("PkgName"));
            pkg.setPkgStartDate(rs.getDate("PkgStartDate"));
            pkg.setPkgId(rs.getInt("PackageId"));    
            packages.add(pkg);
            }
        }
        return packages;
    }
}
