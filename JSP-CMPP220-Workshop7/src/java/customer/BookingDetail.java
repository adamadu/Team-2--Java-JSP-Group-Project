package customer;

import java.util.Date;

public class BookingDetail {
	
	private int bookingDetailId;
	private int itineraryNo;
	private Date tripStart;
	private Date tripEnd;
	private String description;
	private String destination;
	private double basePrice;
	
	public int getBookingDetailId() {
		return bookingDetailId;
	}
	public void setBookingDetailId(int bookingDetailId) {
		this.bookingDetailId = bookingDetailId;
	}
	public int getItineraryNo() {
		return itineraryNo;
	}
	public void setItineraryNo(int itineraryNo) {
		this.itineraryNo = itineraryNo;
	}
	public Date getTripStart() {
		return tripStart;
	}
	public void setTripStart(Date tripStart) {
		this.tripStart = tripStart;
	}
	public Date getTripEnd() {
		return tripEnd;
	}
	public void setTripEnd(Date tripEnd) {
		this.tripEnd = tripEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

}
