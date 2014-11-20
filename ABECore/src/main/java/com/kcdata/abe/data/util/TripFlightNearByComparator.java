/*
 * TripFlightNearByComparator.java
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
 * Comparator class to compare flights based on Flight departure date
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class TripFlightNearByComparator implements Comparator<TripFlight> {

	private String gateway;
	private String destination;
	
	/**
	 * Default constructor
	 */
	@SuppressWarnings("unused")
	private TripFlightNearByComparator() {		
	}
	
	/**
	 * Over loaded constructor
	 * 
	 * @param gateway
	 * @param destination
	 */
	public TripFlightNearByComparator(String gateway, String destination) {
		this.gateway = gateway;
		this.destination = destination;
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
		if(this.gateway.equals(object1.getOutboundFlight().getGateway()) && this.destination.equals(object1.getOutboundFlight().getDestination())) {
			return -1;
		}
		if(this.gateway.equals(object2.getOutboundFlight().getGateway()) && this.destination.equals(object2.getOutboundFlight().getDestination())) {
			return 1;
		}
		return 0;
	}	
	
}
