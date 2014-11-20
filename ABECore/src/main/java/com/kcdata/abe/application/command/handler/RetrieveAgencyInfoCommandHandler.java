/*
 * RetrieveAgencyInfoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAgencyInfoCommand;
import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.business.service.AgencyInfoService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching agency information
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveAgencyInfoCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AgencyInfoService agencyInfoService;

	/**
	 * @return the agencyInfoService
	 */
	public AgencyInfoService getAgencyInfoService() {
		return agencyInfoService;
	}

	/**
	 * @param agencyInfoService the agencyInfoService to set
	 */
	public void setAgencyInfoService(AgencyInfoService agencyInfoService) {
		this.agencyInfoService = agencyInfoService;
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
		if (!(command instanceof RetrieveAgencyInfoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAgencyInfoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAgencyInfoCommand retrieveAgencyInfoCommand = (RetrieveAgencyInfoCommand) command;
		AgencyResponse agencyResponse = agencyInfoService.retrieveAgencyInfo();
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveAgencyInfoCommand, agencyResponse);
		retrieveAgencyInfoCommand.setAgency(agencyResponse.getAgency());
		return retrieveAgencyInfoCommand;
	}
}