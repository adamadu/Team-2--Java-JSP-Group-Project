/*
 * Author: Geetha
 * Date: Sep 1, 2015
 * File: Entity class for Package
 */
package workshop6.Entity;

import java.util.Date;

public class Package {

	private int packageId;
	private String pkgName;
	private Date pkgStartDate;
	private Date pkgEndDate;
	private String pkgDesc;
	private double pkgBasePrice;
	private double pkgAgencyCommission;
	
	public Package(){}
	/**
	 * @return the packageId
	 */
	public int getPackageId() {
		return packageId;
	}
	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	/**
	 * @return the pkgName
	 */
	public String getPkgName() {
		return pkgName;
	}
	/**
	 * @param pkgName the pkgName to set
	 */
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	/**
	 * @return the pkgStartDate
	 */
	public Date getPkgStartDate() {
		return pkgStartDate;
	}
	/**
	 * @param pkgStartDate the pkgStartDate to set
	 */
	public void setPkgStartDate(Date pkgStartDate) {
		this.pkgStartDate = pkgStartDate;
	}
	/**
	 * @return the pkgEndDate
	 */
	public Date getPkgEndDate() {
		return pkgEndDate;
	}
	/**
	 * @param pkgEndDate the pkgEndDate to set
	 */
	public void setPkgEndDate(Date pkgEndDate) {
		this.pkgEndDate = pkgEndDate;
	}
	/**
	 * @return the pkgDesc
	 */
	public String getPkgDesc() {
		return pkgDesc;
	}
	/**
	 * @param pkgDesc the pkgDesc to set
	 */
	public void setPkgDesc(String pkgDesc) {
		this.pkgDesc = pkgDesc;
	}
	/**
	 * @return the pkgBasePrice
	 */
	public double getPkgBasePrice() {
		return pkgBasePrice;
	}
	/**
	 * @param pkgBasePrice the pkgBasePrice to set
	 */
	public void setPkgBasePrice(double pkgBasePrice) {
		this.pkgBasePrice = pkgBasePrice;
	}
	/**
	 * @return the pkgAgencyCommission
	 */
	public double getPkgAgencyCommission() {
		return pkgAgencyCommission;
	}
	/**
	 * @param pkgAgencyCommission the pkgAgencyCommission to set
	 */
	public void setPkgAgencyCommission(double pkgAgencyCommission) {
		this.pkgAgencyCommission = pkgAgencyCommission;
	}
	
}
