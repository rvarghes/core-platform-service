/*
 * RetrieveAmenitiesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAmenitiesCommand;
import com.kcdata.abe.business.response.AmenitiesResponse;
import com.kcdata.abe.business.service.AmenitiesService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;


/**
 * Command handler class for retrieving Amenities codes and names
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class RetrieveAmenitiesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AmenitiesService amenitiesService;

	/**
	 * Method to handle the RetrieveAmenitiesCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof RetrieveAmenitiesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAmenitiesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAmenitiesCommand amenitiesCommand = (RetrieveAmenitiesCommand) command;

		AmenitiesResponse amenitiesResponse = amenitiesService.retrieveAmenities();
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(amenitiesCommand, amenitiesResponse);
		amenitiesCommand.setAmenities(amenitiesResponse.getAmenities());
				
		return amenitiesCommand;
	}

	/**
	 * @return the amenitiesService
	 */
	public AmenitiesService getAmenitiesService() {
		return amenitiesService;
	}

	/**
	 * @param amenitiesService
	 *            the amenitiesService to set
	 */
	public void setAmenitiesService(
			AmenitiesService amenitiesService) {
		this.amenitiesService = amenitiesService;
	}
	
}
