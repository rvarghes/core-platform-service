/*
 * ItinerarySearchResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 26, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryResult;
import com.kcdata.abe.framework.response.ABEResponse;

public class ItinerarySearchResponse extends ABEResponse {

	
	/**
	 * Auto generated serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 4709147222666283024L;

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	private List<ItineraryResult> itineraries; 
	/**
	 * @return the itineraries
	 */
	public List<ItineraryResult> getItineraries() {
		return itineraries;
	}

	/**
	 * @param itineraries the itineraries to set
	 */
	public void setItineraries(List<ItineraryResult> itineraries) {
		this.itineraries = itineraries;
	}

	private Itinerary itinerary;
}
