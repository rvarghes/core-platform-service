/*
 * BookingSearchResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.BookingResult;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for booking search response
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class BookingSearchResponse extends ABEResponse {

	/**
	 * Default generated serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 4681504689793481338L;

	/**
	 * @return the bookings
	 */
	public List<BookingResult> getBookings() {
		return bookings;
	}

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

	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<BookingResult> bookings) {
		this.bookings = bookings;
	}
	//Set during normal booking search
	private List<BookingResult> bookings;

	//Set when a specific booking is retrieved
	private Itinerary itinerary;
}