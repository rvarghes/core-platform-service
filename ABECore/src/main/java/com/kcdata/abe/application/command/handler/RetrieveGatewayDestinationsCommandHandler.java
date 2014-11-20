/*
 * RetrieveGatewayDestinationsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveGatewayDestinationsCommand;
import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class to retrieve gateway destinations
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveGatewayDestinationsCommandHandler extends
		ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private GatewayDestinationsService gatewayDestinationsService;

	/**
	 * Method to handle the RetrieveGatewayDestinationsCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof RetrieveGatewayDestinationsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveGatewayDestinationsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveGatewayDestinationsCommand gatewayDestinationsCommand = (RetrieveGatewayDestinationsCommand) command;

		GatewayDestinationsResponse gatewayDestnResponse = gatewayDestinationsService
				.retrieveGatewayDestinations();
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(gatewayDestinationsCommand, gatewayDestnResponse);
		gatewayDestinationsCommand.setGateways(gatewayDestnResponse
				.getGatewayList());
		gatewayDestinationsCommand.setDestinations(gatewayDestnResponse
				.getDestinationList());
		return gatewayDestinationsCommand;
	}

	/**
	 * @return the flightsService
	 */
	public GatewayDestinationsService getGatewayDestinationsService() {
		return gatewayDestinationsService;
	}

	/**
	 * @param flightsService
	 *            the flightsService to set
	 */
	public void setGatewayDestinationsService(
			GatewayDestinationsService gatewayDestinationsService) {
		this.gatewayDestinationsService = gatewayDestinationsService;
	}

}
