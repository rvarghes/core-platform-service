/*
 * RetrieveFlightInfoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveFlightInfoCommand;
import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.business.service.FlightsService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for RetrieveFlightInfoCommand
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveFlightInfoCommandHandler extends ABECommandHandlerBase {

	private FlightsService flightsService;

	/**
	 * @return the flightsService
	 */
	public FlightsService getFlightsService() {
		return flightsService;
	}

	/**
	 * @param flightsService
	 *            the flightsService to set
	 */
	public void setFlightsService(FlightsService flightsService) {
		this.flightsService = flightsService;
	}

	/**
	 * Method to handle the RetrieveFlightInfoCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveFlightInfoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveFlightInfoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveFlightInfoCommand retrieveFlightInfoCommand = (RetrieveFlightInfoCommand) command;
		FlightInfoResponse flightInfoResponse = flightsService
				.retrieveFlightInfo(retrieveFlightInfoCommand
						.getFlightInfoCriteria());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveFlightInfoCommand, flightInfoResponse);
		retrieveFlightInfoCommand.setTripFlight(flightInfoResponse
				.getTripFlight());
		return retrieveFlightInfoCommand;
	}

}
