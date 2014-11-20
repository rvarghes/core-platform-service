/*
 * BookingSearchCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.BookingResult;
import com.kcdata.abe.data.dto.BookingSearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for booking search
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingSearchCommand extends ABECommandBase {

	/**
	 * Default generated serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8686015047081600459L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "bookingSearchCommandHandler";

	/**
	 * Returns command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * @return the bookingSearchCriteria
	 */
	public BookingSearchCriteria getBookingSearchCriteria() {
		return bookingSearchCriteria;
	}

	/**
	 * @param bookingSearchCriteria
	 *            the bookingSearchCriteria to set
	 */
	public void setBookingSearchCriteria(
			BookingSearchCriteria bookingSearchCriteria) {
		this.bookingSearchCriteria = bookingSearchCriteria;
	}

	/**
	 * @return the bookings
	 */
	public List<BookingResult> getBookings() {
		return bookings;
	}

	/**
	 * @param bookings
	 *            the bookings to set
	 */
	public void setBookings(List<BookingResult> bookings) {
		this.bookings = bookings;
	}
	//Booking search criteria
	private BookingSearchCriteria bookingSearchCriteria;
	//Booking results list
	private List<BookingResult> bookings;
}