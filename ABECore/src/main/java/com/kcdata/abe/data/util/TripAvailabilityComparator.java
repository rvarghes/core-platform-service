package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.cache.data.dto.TripFlight;

public class TripAvailabilityComparator implements Comparator<TripFlight> {

	/**
	 * Method to compare two tripflight objects based on their availability
	 *
	 * @param object1
	 * @param object2
	 * @return
	 */
	
	public int compare(TripFlight object1, TripFlight object2) {
		if(object1.getStatus().isAvaiable() && (object2.getStatus().isNotAvailable())) {
			return -1;
		} 
		if(object2.getStatus().isAvaiable() && (object1.getStatus().isNotAvailable())) {
			return 1;
		}
		return 0;
	}

}
