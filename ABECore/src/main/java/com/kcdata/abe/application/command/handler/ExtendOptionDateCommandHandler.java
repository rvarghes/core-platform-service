/*
 * ExtendOptionDateCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 19, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;


import com.kcdata.abe.application.command.ExtendOptionDateCommand;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ExtendOptionDateCommandHandler extends ABECommandHandlerBase {
	
	/**
	 * itineraryService
	 */
	private ItineraryService itineraryService;

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



	public ABECommand handle(ABECommand command) {
		if (!(command instanceof ExtendOptionDateCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "extendOptionDateCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		ExtendOptionDateCommand extendOptionDateCommand  = (ExtendOptionDateCommand) command;	
		ItineraryResponse response=itineraryService.extendOptionDateOfItinerary(extendOptionDateCommand.getItinerary());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(extendOptionDateCommand, response);
		extendOptionDateCommand.setItineraryExtendDate(response.getItineraryExtendDate());
		return extendOptionDateCommand;
	}

}
