/*
 * RetrieveResortAreasCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveResortAreaCommand;
import com.kcdata.abe.business.response.ResortAreaResponse;
import com.kcdata.abe.business.service.ResortAreaService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching resort areas
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveResortAreaCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private ResortAreaService resortAreaService;

	/**
	 * @return the resortAreaService
	 */
	public ResortAreaService getResortAreaService() {
		return resortAreaService;
	}

	/**
	 * @param resortAreasService
	 *            the resortAreasService to set
	 */
	public void setResortAreaService(ResortAreaService resortAreaService) {
		this.resortAreaService = resortAreaService;
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
		if (!(command instanceof RetrieveResortAreaCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveResortAreaCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveResortAreaCommand retrieveResortAreaCommand = (RetrieveResortAreaCommand) command;
		ResortAreaResponse resortAreaResponse = resortAreaService
				.retrieveResortAreas(retrieveResortAreaCommand.getDestination());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(retrieveResortAreaCommand, resortAreaResponse);
		retrieveResortAreaCommand.setResortAreas(resortAreaResponse
				.getResortAreas());
		return retrieveResortAreaCommand;
	}

}