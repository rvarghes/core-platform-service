/*
 * RetrieveAgenciesSearchCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 21, 2011  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAgenciesSearchCommand;
import com.kcdata.abe.business.response.AgenciesSearchResponse;
import com.kcdata.abe.business.service.AgenciesSearchService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching agencies search information
 * 
 * @author kmadugul
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveAgenciesSearchCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AgenciesSearchService agenciesSearchService;

	/**
	 * @return the agenciesSearchService
	 */
	public AgenciesSearchService getAgenciesSearchService() 
	{
		return agenciesSearchService;
	}

	/**
	 * @param agenciesSearchService the agenciesSearchService to set
	 */
	public void setAgenciesSearchService(AgenciesSearchService agenciesSearchService) 
	{
		this.agenciesSearchService = agenciesSearchService;
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
		if (!(command instanceof RetrieveAgenciesSearchCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAgenciesSearchCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAgenciesSearchCommand retrieveAgenciesSearchCommand = (RetrieveAgenciesSearchCommand) command;
		AgenciesSearchResponse agenciesSearchResponse = agenciesSearchService.retrieveAgenciesSearchInfo(retrieveAgenciesSearchCommand.getAgency());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveAgenciesSearchCommand, agenciesSearchResponse);
		retrieveAgenciesSearchCommand.setAgenciesSearchList(agenciesSearchResponse.getAgenciesList());
		return retrieveAgenciesSearchCommand;
	}
}