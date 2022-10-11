package com.acbhu.carbooking;

public class BookingDetails {
	
	private int taxiNo;
	//private int totalEarning;
	private int customerID;
	private int bookingID=0;
	private String pickUpPoint;
	private String dropPoint;
	private int pickUpTime;
	private int dropTime;
	private int amount;
	private static int count = 0;
	
	public BookingDetails(int customerID, String pickUpPoint, String dropPoint, int pickUpTime) {
		super();
		this.customerID = customerID;
		this.pickUpPoint = pickUpPoint;
		this.dropPoint = dropPoint;
		this.pickUpTime = pickUpTime;
		this.bookingID = ++count;
	}
	
	public int getTaxiNo() {
		return taxiNo;
	}
	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}
//	public int getTotalEarning() {
//		return totalEarning;
//	}
//	public void setTotalEarning(int totalEarning) {
//		this.totalEarning = totalEarning;
//	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public String getPickUpPoint() {
		return pickUpPoint;
	}
	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	public int getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(int pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public int getDropTime() {
		return dropTime;
	}
	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
