/*
 * TripFlightStopsComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 30, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.TripFlight;

/**
 * Comparator class for Flight based on Stops
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class TripFlightStopsComparator implements Comparator<TripFlight> {

	/**
	 * Method to compare two tripflight objects
	 *
	 * @param object1
	 * @param object2
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public int compare(TripFlight object1, TripFlight object2) {
		int compareValue = object1.getOutboundFlight().getNoOfStops().compareTo(object2.getOutboundFlight().getNoOfStops());
		if(compareValue == 0 && !object1.getTripType().isOnewayTrip()) {
			compareValue = object1.getInboundFlight().getNoOfStops().compareTo(object2.getInboundFlight().getNoOfStops());
		}
		return compareValue;
	}

}
