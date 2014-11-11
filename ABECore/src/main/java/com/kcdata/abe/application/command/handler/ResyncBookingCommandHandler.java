/*
 * ResyncBookingCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 12, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.service.BookingSearchService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ResyncBookingCommandHandler extends ABECommandHandlerBase {

	// Service class instance
	private BookingSearchService bookingSearchService;

	/**
	 * @return the bookingSearchService
	 */
	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}

	/**
	 * @param bookingSearchService
	 *            the bookingSearchService to set
	 */
	public void setBookingSearchService(
			BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}

	/**
	 * Handle method implementation for booking retrieval
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ResyncBookingCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "ResyncBookingCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		ResyncBookingCommand resyncBookingCommand = (ResyncBookingCommand) command;
		BookingSearchResponse searchResponse = bookingSearchService
				.resyncBooking(resyncBookingCommand);

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(resyncBookingCommand, searchResponse);
		if(searchResponse.getItinerary()!=null) {
			resyncBookingCommand.setItinerary(searchResponse.getItinerary());
		}
		return resyncBookingCommand;
	}
}