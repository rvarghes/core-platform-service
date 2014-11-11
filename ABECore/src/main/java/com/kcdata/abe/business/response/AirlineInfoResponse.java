/*
 * AirlineInfoResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.AirlineInfo;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Airline Info response class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AirlineInfoResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

	// Object to hold airlineInfo details
	private AirlineInfo airlineInfo;

	/**
	 * @return the airlineInfo
	 */
	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}

	/**
	 * @param airlineInfo
	 *            the airlineInfo to set
	 */
	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}
	
	
}
