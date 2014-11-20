/*
 * AdvancedSkedSearchCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 23, 2009  nvittal
 * Jul 10, 2009	 nvittal	  Changes as per Search Criteria refactoring
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.AdvancedSkedSearchCommand;
import com.kcdata.abe.business.response.AdvancedSkedSearchResponse;
import com.kcdata.abe.business.service.AdvancedSkedSearchService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for advanced SKED search
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AdvancedSkedSearchCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AdvancedSkedSearchService advancedSkedSearchService;

	/**
	 * @return the advancedSkedSearchService
	 */
	public AdvancedSkedSearchService getAdvancedSkedSearchService() {
		return advancedSkedSearchService;
	}

	/**
	 * @param advancedSkedSearchService
	 *            the advancedSkedSearchService to set
	 */
	public void setAdvancedSkedSearchService(
			AdvancedSkedSearchService advancedSkedSearchService) {
		this.advancedSkedSearchService = advancedSkedSearchService;
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
		if (!(command instanceof AdvancedSkedSearchCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "AdvancedSkedSearchCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		AdvancedSkedSearchCommand advancedSkedSearchCommand = (AdvancedSkedSearchCommand) command;
		AdvancedSkedSearchResponse advSkedSrchResponse = advancedSkedSearchService
				.retrieveAdvancedSkedSearchOptions(advancedSkedSearchCommand
						.getSearchCriteria());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(advancedSkedSearchCommand, advSkedSrchResponse);
		advancedSkedSearchCommand
				.setCarriers(advSkedSrchResponse.getCarriers());
		advancedSkedSearchCommand.setStopovers(advSkedSrchResponse
				.getStopovers());
		return advancedSkedSearchCommand;
	}
}