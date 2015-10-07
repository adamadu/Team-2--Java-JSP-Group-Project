/*
Author: Geetha
Date: October 5, 2015
File: Plain Old java objects for Package
*/
package packages;

import java.util.Date;

public class Package {
	
    public Package(){}
    
	private String pkgName;
	private Date pkgStartDate;
	private Date pkgEndDate;
	private String pkgDesc;
	private double pkgBasePrice;
	private double pkgAgencyCommission;
        private int packageId;
        
        public int getPkgId()
        {
            return packageId;
        }
        
        public void setPkgId(int pkgId){
            this.packageId = pkgId;
        }
	
	public String getPkgName() {
		return pkgName;
	}
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	public Date getPkgStartDate() {
		return pkgStartDate;
	}
	public void setPkgStartDate(Date pkgStartDate) {
		this.pkgStartDate = pkgStartDate;
	}
	public Date getPkgEndDate() {
		return pkgEndDate;
	}
	public void setPkgEndDate(Date pkgEndDate) {
		this.pkgEndDate = pkgEndDate;
	}
	public String getPkgDesc() {
		return pkgDesc;
	}
	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
	}
	public double getPkgBasePrice() {
		return pkgBasePrice;
	}
	public void setPkgBasePrice(double pkgBasePrice) {
		this.pkgBasePrice = pkgBasePrice;
	}
	public double getPkgAgencyCommission() {
		return pkgAgencyCommission;
	}
	public void setPkgAgencyCommission(double pkgAgencyCommission) {
		this.pkgAgencyCommission = pkgAgencyCommission;
	}
	
}
