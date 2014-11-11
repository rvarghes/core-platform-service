/*
 * HotelChainResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 09, 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.HotelChain;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for hotel chain response
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelChainResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 534203163004566807L;
	
	/**
	 * @return the resortAreas
	 */
	public List<HotelChain> getHotelChain() {
		return hotelChain;
	}

	/**
	 * @param resortAreas the resortAreas to set
	 */
	public void setHotelChain(List<HotelChain> hotelChain) {
		this.hotelChain = hotelChain;
	}

	/**
	 * Field to hold list of resort areas
	 */
	private List<HotelChain> hotelChain;
}
