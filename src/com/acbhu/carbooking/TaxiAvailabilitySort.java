package com.acbhu.carbooking;

import java.util.Comparator;

public class TaxiAvailabilitySort implements Comparator<TaxiAvailability>{

	@Override
	public int compare(TaxiAvailability o1, TaxiAvailability o2) {
		return o1.getTotalEarnings()-o2.getTotalEarnings();
	}

}
