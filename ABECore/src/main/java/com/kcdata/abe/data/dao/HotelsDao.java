/*
 * HotelsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 * Sep 14, 2009	 hguntupa	  Added methods for hotel availability of packages
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.List;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Interface for Hotel DAO
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface HotelsDao extends ABEDao {

	/**
	 * Method to retrieve hotels
	 * 
	 * @param hotelsRequest Hotel Request
	 * @return Hotels response
	 * 
	 * @see
	 * @since
	 */
	HotelsResponse retrieveHotels(HotelsRequest hotelsRequest);

	/**
	 * Method to retrieve hotels for Packages
	 * 
	 * @param hotelsRequest Hotel Request
	 * @return Hotels response
	 * 
	 * @see
	 * @since
	 */
	HotelsResponse retrieveHotelsForPackages(HotelsRequest hotelsRequest);
	
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
	 * @param hotelList
	 * @return
	 */
	HotelsResponse retrieveHotelVendor(List<Hotel> hotelList);
	
	
	/**
	 * 
	 * @param itineraray
	 * @return
	 */
	public List<RequestedDatesForAvailability> getRequestedDatesForAvailability(Hotel hotel);
	
	
	/**
	 * 
	 * @param nookingNo
	 * @return
	 */
	public List<RequestedDatesForAvailability> getRequestedDatesForAvailability(String bookingNo);
	public  boolean checkisStatusValid(Itinerary itinerary) ;	
	
		
}