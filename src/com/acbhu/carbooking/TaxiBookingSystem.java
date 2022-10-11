package com.acbhu.carbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaxiBookingSystem {

	//public static List<TripTime> trips= Arrays.asList(new TripTime(0,0));
	public static List<BookingDetails> reservation = new ArrayList<BookingDetails>();
	static List<Integer> freeTime = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24);
	public static List<TaxiAvailability> taxiAvailability =  //new ArrayList<TaxiAvailability>(BookingConstants.TOTAL_NUMBER_OF_TAXI);
			Arrays.asList(new TaxiAvailability(1, new ArrayList<>(freeTime), 0, new ArrayList<Integer>()),
					new TaxiAvailability(2, new ArrayList<>(freeTime), 0, new ArrayList<Integer>()),
					new TaxiAvailability(3, new ArrayList<>(freeTime), 0, new ArrayList<Integer>()),
					new TaxiAvailability(4, new ArrayList<>(freeTime), 0, new ArrayList<Integer>()));
	
	List<String> locations = Arrays.asList("A","B","C","D","E","F"); 
	
	public void bookTaxi(BookingDetails details) {		
		int travelTime = findTravelTime(details.getPickUpPoint(), details.getDropPoint());
		int amount = findAmount(travelTime);
		int taxi = checkTaxiAvailability(details.getPickUpTime(), details.getPickUpPoint(), details.getDropPoint(), travelTime);
		if(taxi != 0 &&  travelTime !=0 && amount !=0) {
			details.setAmount(amount);
			details.setDropTime(details.getPickUpTime()+travelTime);
			details.setTaxiNo(taxi);
			for(TaxiAvailability car : taxiAvailability) {
				if(car.getTaxiNo() == taxi) {
					car.setTotalEarnings(car.getTotalEarnings()+amount);
				}
			}
			reservation.add(details); 
			System.out.println("Taxi booked : Taxi-"+taxi +". TotalTravalTime-"+travelTime +". Amount"+amount);
		}
		else if (taxi==0)
			System.out.println("Taxi is not available for booking");
		else if (travelTime==0)
			System.out.println("Enter proper location. Available locations -"+locations);
	}

	private int checkTaxiAvailability(int startTime, String pickUpPoint, String dropPoint, int travelTime) {
		Collections.sort(taxiAvailability, new TaxiAvailabilitySort());
		List<Integer> availTaxi = new ArrayList<Integer>();
		List<Integer> travelHRs = new ArrayList<Integer>();
		for (int i=startTime+1; i<=startTime+travelTime; i++)
			travelHRs.add(i);
		for (TaxiAvailability taxi : taxiAvailability) {
			//Collections.sort(taxi.getTripTiming(), new TaxiAvailability());
			if (taxi.getFreeTime().containsAll(travelHRs) && (taxi.getCurrentLocation().contains(pickUpPoint)
					|| findTravelTime(taxi.getCurrentLocation(),pickUpPoint) <=startTime )) { //check and add available location point also here
				availTaxi.add(taxi.getTaxiNo());
			}
		}
		for (TaxiAvailability taxi : taxiAvailability) {
			if(!availTaxi.isEmpty())
				if(availTaxi.get(0).equals(taxi.getTaxiNo())){
					taxi.setCurrentLocation(dropPoint);
					for (int i=0; i<travelHRs.size() ;i++) //(int hr : travelHRs) \n if (taxi.getFreeTime().contains(travelHRs.get(i)))
						taxi.getFreeTime().remove(Integer.valueOf(travelHRs.get(i)));
				}
		}
		System.out.println("Travel hrs - "+travelHRs);
		if(!availTaxi.isEmpty())
			return availTaxi.get(0);
		else
			return 0;
	}
	
	private int findTravelTime(String pickUpPoint, String dropPoint) {
		if (locations.contains(pickUpPoint) && locations.contains(dropPoint)) {
			return Math.abs(findNumberforLocatinos(dropPoint) - findNumberforLocatinos(pickUpPoint));
		}
		else 
			return 0;
	}
	
	private int findAmount(int dis) {
		dis = dis*BookingConstants.DISTANCE_BTW_LOCATIONS;
		if(dis<=5)
			return 100;
		else if (dis>5)
			return ((dis-5)*BookingConstants.FARE_PER_KM)+BookingConstants.MIN_FARE_UNTIL_5KM;
		else 
			return 0;
	}
	
	private int findNumberforLocatinos(String point) {
		if(point.equals("A"))
			return 1;
		else if(point.equals("B"))
			return 2;
		else if(point.equals("C"))
			return 3;
		else if(point.equals("D"))
			return 4;
		else if(point.equals("E"))
			return 5;
		else if(point.equals("F"))
			return 6;
		else
			return 0;
	}
	
	public void printTaxiTrips() {
		for (TaxiAvailability taxi : taxiAvailability) {
			System.out.println("Taxi - "+taxi.getTaxiNo()+"\t Total Earnings: Rs."+taxi.getTotalEarnings());
			System.out.println("BookingID \t CustomerID \t From \t To \t PickUpPoint,time \t DropPoint \t Amount");
			for (BookingDetails booking : reservation)
				if (booking.getTaxiNo() == taxi.getTaxiNo())
					System.out.println(booking.getBookingID()+"\t"+booking.getCustomerID()+"\t"+booking.getPickUpPoint()+"\t"
				+booking.getPickUpTime()+"\t"+booking.getDropPoint()+"\t"+booking.getAmount());
			System.out.println("--------------------------------------------------------------------------------------------------------------------");
			System.out.println("Taxi free time - "+taxi.getFreeTime());
			System.out.println();
		}
	}
}
