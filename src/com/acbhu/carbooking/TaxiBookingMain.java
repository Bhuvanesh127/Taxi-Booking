package com.acbhu.carbooking;

public class TaxiBookingMain {

	public static void main(String[] args) {
		TaxiBookingSystem booker = new TaxiBookingSystem();
		
		booker.bookTaxi(new BookingDetails(1, "A", "B", 9));
		booker.bookTaxi(new BookingDetails(2, "B", "D", 9));
		booker.bookTaxi(new BookingDetails(3, "A", "B", 9));
		booker.bookTaxi(new BookingDetails(4, "A", "B", 9));
		booker.bookTaxi(new BookingDetails(5, "A", "B", 9));
		booker.bookTaxi(new BookingDetails(1, "A", "B", 9));
		booker.bookTaxi(new BookingDetails(1, "B", "C", 10));
		booker.bookTaxi(new BookingDetails(6, "B", "C", 10));
		booker.bookTaxi(new BookingDetails(2, "B", "C", 10));
		booker.bookTaxi(new BookingDetails(1, "B", "C", 10));
		booker.bookTaxi(new BookingDetails(1, "B", "C", 10));
		booker.bookTaxi(new BookingDetails(1, "D", "F", 16));
		booker.bookTaxi(new BookingDetails(1, "C", "E", 19));
		booker.printTaxiTrips();
	}

}
