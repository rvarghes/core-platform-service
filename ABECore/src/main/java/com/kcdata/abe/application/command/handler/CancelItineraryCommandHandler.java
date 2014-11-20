/*
 * CancelItineraryCommandHandler.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 14, 2011  hguntupa
 ******************************************************************************
 */
package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.CancelItineraryCommand;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.BookingSearchService;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Class to handle the {@link CancelItineraryCommand}
 * 
 * @author hguntupa
 * 
 */
public class CancelItineraryCommandHandler extends ABECommandHandlerBase {

	ItineraryService itineraryService;
	BookingSearchService bookingSearchService;

	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

	/**
	 * @param itineraryService
	 *            the itineraryService to set
	 */
	public void setItineraryService(ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}
	/**
	 * @return the bookingSearchService
	 */
	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}

	/**
	 * @param bookingSearchService the bookingSearchService to set
	 */
	public void setBookingSearchService(BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}
	/**
	 * Method to handle the {@link CancelItineraryCommand}
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof CancelItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "CancelItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		
		CancelItineraryCommand cancelItineraryCommand = (CancelItineraryCommand) command;
		// Cancel Itinerary Response
		BookingSearchResponse searchResponse = bookingSearchService
		.retrieveBooking(cancelItineraryCommand.getBookingNo());
		ItineraryResponse itineraryResponse = itineraryService
				.priceAndCancelItinerary(cancelItineraryCommand.getBookingNo(),
						cancelItineraryCommand.isCancelItinerary(),searchResponse.getItinerary());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(cancelItineraryCommand, itineraryResponse);
		cancelItineraryCommand.setItinerary(itineraryResponse.getItinerary());
		return cancelItineraryCommand;
	}

	

}
