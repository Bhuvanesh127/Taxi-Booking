package com.acbhu.carbooking;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxiAvailability implements Comparator<TripTime>{
	
	private int taxiNo;
	//private List<TripTime> tripTiming;
	private List<Integer> freeTime;
	private int totalEarnings;
	private List<Integer> bookingID;
	private String currentLocation;
	private Map<Integer, String> availableLocationAtGivenTime;
	
	public TaxiAvailability(int taxiNo, List<Integer> freeTime, int totalEarnings, List<Integer> bookingID) {
		super();
		this.taxiNo = taxiNo;
		this.freeTime = freeTime;
		this.totalEarnings = totalEarnings;
		this.bookingID = bookingID;
		this.currentLocation = "A";
		this.availableLocationAtGivenTime = Stream.of(new Object[][] {
			{1,""}, {2,""},{3,""}, {4,""},{5,""}, {6,""},{7,""}, {8,""},{9,""}, {10,""},{11,""}, {12,""},
			{13,""}, {14,""},{15,""}, {16,""},{17,""}, {18,""},{19,""}, {20,""},{21,""}, {22,""},{23,""}, {24,""},
		}).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
	}

	public TaxiAvailability() {
		// TODO Auto-generated constructor stub
	}

	public int getTaxiNo() {
		return taxiNo;
	}
	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}
	
//	public List<TripTime> getTripTiming() {
//		return tripTiming;
//	}
//	public void setTripTiming(List<TripTime> tripTiming) {
//		this.tripTiming = tripTiming;
//	}
	public int getTotalEarnings() {
		return totalEarnings;
	}
	public void setTotalEarnings(int totalEarnings) {
		this.totalEarnings = totalEarnings;
	}
	
	@Override
	public int compare(TripTime o1, TripTime o2) {
		return o1.getStartTime()-o2.getStartTime();
	}



	public List<Integer> getBookingID() {
		return bookingID;
	}

	public void setBookingID(List<Integer> bookingID) {
		this.bookingID = bookingID;
	}

	public List<Integer> getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(List<Integer> freeTime) {
		this.freeTime = freeTime;
	}

	public Map<Integer, String> getAvailableLocationAtGivenTime() {
		return availableLocationAtGivenTime;
	}

	public void setAvailableLocationAtGivenTime(Map<Integer, String> availableLocationAtGivenTime) {
		this.availableLocationAtGivenTime = availableLocationAtGivenTime;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	
}
