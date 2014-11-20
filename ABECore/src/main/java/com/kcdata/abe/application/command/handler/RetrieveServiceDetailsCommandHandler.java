/*
 * RetrieveServiceDetailsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 20, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveServiceDetailsCommand;
import com.kcdata.abe.business.response.ServiceDetailsResponse;
import com.kcdata.abe.business.service.ServicesService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for retrieving the Service details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveServiceDetailsCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private ServicesService servicesService;

	/**
	 * @return the ServicesService
	 */
	public ServicesService getServicesService() {
		return servicesService;
	}

	/**
	 * @param servicesService
	 *            the servicesService to set
	 */
	public void setServicesService(
			ServicesService servicesService) {
		this.servicesService = servicesService;
	}

	/**
	 * Method to handle the RetrieveServiceDetailsCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveServiceDetailsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveServiceDetailsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveServiceDetailsCommand retrieveServiceDetailsCommand = (RetrieveServiceDetailsCommand) command;
		ServiceDetailsResponse serviceDetailsResponse = servicesService
				.retrieveServiceDetails(retrieveServiceDetailsCommand.getService());

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveServiceDetailsCommand, serviceDetailsResponse);
		retrieveServiceDetailsCommand.setService(serviceDetailsResponse.getService());
		return retrieveServiceDetailsCommand;
	}

}
