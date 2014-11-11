/*
 * TripFlightTypeComparator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 27, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.util.Comparator;

import com.kcdata.abe.data.dto.TripFlight;

/**
 * Comparator class to compare flights based on FlightType
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class TripFlightTypeComparator implements Comparator<TripFlight> {

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
		if(object1.getFlightType().isCharter() && (!object2.getFlightType().isCharter())) {
			return -1;
		} 
		if((!object1.getFlightType().isCharter()) && object2.getFlightType().isCharter()) {
			return 1;
		}
		return 0;
	}

}
