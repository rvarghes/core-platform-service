/*
 * RetrieveAirlineInfoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAirlineInfoCommand;
import com.kcdata.abe.business.response.AirlineInfoResponse;
import com.kcdata.abe.business.service.AirlineInfoService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching airline info
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class RetrieveAirlineInfoCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AirlineInfoService airlineInfoService;

	/**
	 * @return the resortAreaService
	 */
	public AirlineInfoService getAirlineInfoService() {
		return airlineInfoService;
	}

	/**
	 * @param resortAreasService
	 *            the resortAreasService to set
	 */
	public void setAirlineInfoService(AirlineInfoService airlineInfoService) {
		this.airlineInfoService = airlineInfoService;
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
		if (!(command instanceof RetrieveAirlineInfoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAirlineInfoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAirlineInfoCommand retrieveAirlineInfoCommand = (RetrieveAirlineInfoCommand) command;
		AirlineInfoResponse airlineInfoResponse = airlineInfoService
				.retrieveAirlineInfo(retrieveAirlineInfoCommand.getAirlineCode());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(retrieveAirlineInfoCommand, airlineInfoResponse);
		retrieveAirlineInfoCommand.setAirlineInfo(airlineInfoResponse
				.getAirlineInfo());
		return retrieveAirlineInfoCommand;
	
	}
}
