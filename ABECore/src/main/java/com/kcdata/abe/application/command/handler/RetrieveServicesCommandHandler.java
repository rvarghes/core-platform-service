/*
 * RetrieveServicesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveServicesCommand;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.business.service.ServicesService;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class RetrieveServicesCommandHandler extends ABECommandHandlerBase{
	
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
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveServicesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveServicesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveServicesCommand retrieveServicesCommand = (RetrieveServicesCommand) command;
		ServicesResponse servicesResponse = servicesService.retrieveServices(retrieveServicesCommand.getItinerary());
		if(servicesResponse != null)
		{
			SeatMapUtils.removeSeatMapServices(servicesResponse.getServiceGroups());
		}
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(retrieveServicesCommand, servicesResponse);
		retrieveServicesCommand.setServiceGroups(servicesResponse.getServiceGroups());
		return retrieveServicesCommand;
	}
}
