/*
 * HotelsService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface for retrieving hotels
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface HotelsService extends ABEService {
	/**
	 * Method to retrieve hotels
	 * 
	 * @param searchCriteria
	 *            - Search criteria
	 * @return Hotels
	 * 
	 * @see
	 * @since
	 */
	public HotelsResponse retrieveHotels(SearchCriteria searchCriteria);

	
	/**
	 * Method to retrieve the price break up of given hotel
	 *
	 * @param hotel
	 * @return
	 *
	 * @see
	 * @since
	 */
	AllPriceBreakUpResponse retrievePriceBreakUp(Hotel hotel);	
	
	/**
	 * @param hotelList TODO
	 * @return
	 */
	public HotelsResponse retrieveHotelVendor(List<Hotel> hotelList);
}
