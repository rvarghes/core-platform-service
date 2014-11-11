/*
 * TripFlightDepartureDateComparator.java
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
import java.util.Date;

import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.util.DateUtils;

/**
 * Comparator class to compare flights based on Flight departure date
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class TripFlightDepartureDateComparator implements Comparator<TripFlight>  {
	
	private Date departureDate;
	
	/**
	 * Default constructor
	 */
	@SuppressWarnings("unused")
	private TripFlightDepartureDateComparator() {		
	}
	
	/**
	 * Overloaded constructor
	 * 
	 * @param departureDate
	 */
	public TripFlightDepartureDateComparator(Date departureDate) {
		this.departureDate = departureDate;
	}
	
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
		if(DateUtils.dateDifferenceInDays(this.departureDate, object1.getOutboundFlight().getDepartureTime()) == 0) {
			return -1;
		}
		if(DateUtils.dateDifferenceInDays(this.departureDate, object2.getOutboundFlight().getDepartureTime()) == 0) {
			return 1;
		}
		return object1.getOutboundFlight().getDepartureTime().compareTo(object2.getOutboundFlight().getDepartureTime());
	}
}
