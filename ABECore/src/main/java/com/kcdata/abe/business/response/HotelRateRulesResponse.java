/*
 * HotelRateRulesResponse.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 29, 2011  nvittal	  Initial creation
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for hotel rate rules response
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class HotelRateRulesResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1985469925825224354L;
	
	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	/**
	 * Holds hotel object with rate rules
	 */
	private Hotel hotel;
}
