/*
 * RetrieveItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 29, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveItineraryCommand;
import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.business.service.ItinerarySearchService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * 
 * Command handler for handle retrieve itinerary command
 *
 * @author vgandrap
 * @version
 *
 *
 * @see
 * @since
 */
public class RetrieveItineraryCommandHandler extends ABECommandHandlerBase {

	// Service class instance
	private ItinerarySearchService itinerarySearchService;


	/**
	 * @return the itinerarySearchService
	 */
	public ItinerarySearchService getItinerarySearchService() {
		return itinerarySearchService;
	}


	/**
	 * @param itinerarySearchService the itinerarySearchService to set
	 */
	public void setItinerarySearchService(
			ItinerarySearchService itinerarySearchService) {
		this.itinerarySearchService = itinerarySearchService;
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
		if (!(command instanceof RetrieveItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "RetrieveItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveItineraryCommand retrieveItineraryCommand = (RetrieveItineraryCommand) command;
		ItinerarySearchResponse searchResponse = itinerarySearchService
				.retrieveItinerary(retrieveItineraryCommand.getQuoteNo());

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveItineraryCommand, searchResponse);
		retrieveItineraryCommand.setItinerary(searchResponse.getItinerary());
		return retrieveItineraryCommand;
	}
}
