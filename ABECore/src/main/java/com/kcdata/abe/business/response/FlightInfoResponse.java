/*
 * FlightInfoResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class to hold flight info response
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightInfoResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2187675197745040873L;

	private TripFlight tripFlight;

	/**
	 * @return the tripFlight
	 */
	public TripFlight getTripFlight() {
		return tripFlight;
	}

	/**
	 * @param tripFlight
	 *            the tripFlight to set
	 */
	public void setTripFlight(TripFlight tripFlight) {
		this.tripFlight = tripFlight;
	}

}
