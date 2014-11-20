/*
 * BookingSearchService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.data.dto.BookingSearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service interface for booking search
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface BookingSearchService extends ABEService {
	/**
	 * Method to search bookings
	 *
	 * @param bookingSearchCriteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public BookingSearchResponse search(BookingSearchCriteria bookingSearchCriteria);

	/**
	 * Method to retrieve a booking
	 *
	 * @param bookingNo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public BookingSearchResponse retrieveBooking(String bookingNo);
	
	/**
	 * 
	 * Method to resync the booking
	 *
	 * @param bookingNo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public BookingSearchResponse resyncBooking(ResyncBookingCommand resyncBookingCommand);
}