/*
 * BookingSearchDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.data.dto.BookingSearchCriteria;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO interface for searching bookings
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public interface BookingSearchDao extends ABEDao {

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
	 * Method to resync booking
	 *
	 * @param bookingNo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public BookingSearchResponse resyncBooking(ResyncBookingCommand resyncBookingCommand);
}