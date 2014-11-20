/*
 * ItineraryDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Date;
import java.util.List;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Itinerary Booking DAO interface
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ItineraryDao extends ABEDao {

	/**
	 * Method to book the given itinerary
	 * 
	 * @param itinerary
	 * @param servicesResponse of type ServicesResponse
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse bookItinerary(Itinerary itinerary, ServicesResponse servicesResponse);

	/**
	 * 
	 * Method to save changes in given itinerary
	 * 
	 * @param itinerary of type Itinerary
	 * @param servicesResponse of type ServicesResponse
	 * @return of type ItineraryResponse
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItineraryChanges(Itinerary itinerary, Itinerary oldItinerary, ServicesResponse servicesResponse);

	/**
	 * 
	 * Method to save the itinerary, or create a Quote
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItinerary(Itinerary itinerary);

	/**
	 * 
	 * 
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse extendOptionDateOfItinerary(Itinerary itinerary);

	/**
	 * Method to price and cancel the itinerary of given booking no.
	 * 
	 * @param bookingNo
	 *            - Booking number of the itinerary to be canceled
	 * @param cancelItinerary
	 *            - If the flag is true, price and cancel the itinerary. If the
	 *            flag is false, then only price the itinerary for cancellation.
	 *            Do not cancel it.
	 * @return
	 */
	public ItineraryResponse priceAndCancelItinerary(String bookingNo,
			boolean cancelItinerary);
	
	/**
	 * Method to update additional PNR details when confirmation number comes back from HBSI on callback
	 * @param bookingNo
	 * 				- Booking number of SAP that needs update in ZHPNR
	 * @return
	 */
	public ItineraryResponse updateSupplierConfirmation(HotelConfirmation hotelConfirmation);
}
