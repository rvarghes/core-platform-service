package com.kcdata.abe.data.dao;

import java.util.Comparator;

import com.kcdata.abe.data.dto.TripFlight;

public class TripFlightTotalPriceComparator implements Comparator<TripFlight> {
	
	
	public int compare(TripFlight tripFlight1, TripFlight tripFlight2) {
		double price1 = tripFlight1.getPrice().getBasePrice() + tripFlight1.getPrice().getTotalTax();
		double price2 = tripFlight2.getPrice().getBasePrice() + tripFlight2.getPrice().getTotalTax();
		if(price1 < price2) {
			return 1;
		}
		return 0;
	}

}
