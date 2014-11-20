/*
 * ViewItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 16, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;



import com.kcdata.abe.application.command.ViewItineraryCommand;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ViewItineraryCommandHandler extends ABECommandHandlerBase{
	
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
		if (!(command instanceof ViewItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] {"ViewItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		ViewItineraryCommand viewItineraryCommand = (ViewItineraryCommand) command;
		ItineraryResponse itineraryResponse=itineraryService.viewInvoice(viewItineraryCommand);
		//set the tokenNo
		viewItineraryCommand.setTokenNo(itineraryResponse.getTokenNo());
		return viewItineraryCommand;
	}
	
	/**
	 * Itinerary booking service
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

}
