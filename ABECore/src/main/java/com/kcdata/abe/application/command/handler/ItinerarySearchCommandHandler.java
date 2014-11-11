/*
 * ItinerarySearchCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 6, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ItinerarySearchCommand;
import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.business.service.ItinerarySearchService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * 
 * Command handler class for ItinerarySearchCommand
 *
 * @author vgandrap
 * @version
 *
 *
 * @see
 * @since
 */
public class ItinerarySearchCommandHandler extends ABECommandHandlerBase{
	// Service class instance
	private ItinerarySearchService itinerarySearchService;

	/**
	 * 
	 * Returns ItinerarySearchService
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ItinerarySearchService getItinerarySearchService() {
		return itinerarySearchService;
	}

	/**
	 * 
	 * Set itinerarySearchService
	 *
	 * @param itinerarySearchService
	 *
	 * @see
	 * @since
	 */
	public void setItinerarySearchService(
			ItinerarySearchService itinerarySearchService) {
		this.itinerarySearchService = itinerarySearchService;
	}

	/**
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ItinerarySearchCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "ItinerarySearchCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		ItinerarySearchCommand itinerarySearchCommand = (ItinerarySearchCommand) command;
		ItinerarySearchResponse searchResponse = itinerarySearchService
				.search(itinerarySearchCommand.getItinerarySearchCriteria());

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(itinerarySearchCommand, searchResponse);
		itinerarySearchCommand.setItineraries(searchResponse.getItineraries());
		return itinerarySearchCommand;
	}
}
