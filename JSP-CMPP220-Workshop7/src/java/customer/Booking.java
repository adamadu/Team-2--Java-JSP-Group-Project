/*
Author: Geetha
Date: October 5, 2015
File: Plain Old java objects for BookingDetails
*/
package customer;

public class Booking {
	
	private int bookingId;
	private String bookingNo;
	private int packageId;
	private int travelerCount;
	private String tripTypeId;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public int getTravelerCount() {
		return travelerCount;
	}
	public void setTravelerCount(int travelerCount) {
		this.travelerCount = travelerCount;
	}
	public String getTripTypeId() {
		return tripTypeId;
	}
	public void setTripTypeId(String tripTypeId) {
		this.tripTypeId = tripTypeId;
	}
	
}
