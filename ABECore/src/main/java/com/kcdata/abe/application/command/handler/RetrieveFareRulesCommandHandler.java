/*
 * RetrieveFareRulesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveFareRulesCommand;
import com.kcdata.abe.business.response.FareRulesResponse;
import com.kcdata.abe.business.service.FareRulesService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching fare rules for SKED flights
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveFareRulesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private FareRulesService fareRulesService;

	/**
	 * @return the fareRuleService
	 */
	public FareRulesService getFareRulesService() {
		return fareRulesService;
	}

	/**
	 * @param fareRuleService
	 *            the fareRuleService to set
	 */
	public void setFareRulesService(FareRulesService fareRulesService) {
		this.fareRulesService = fareRulesService;
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
		if (!(command instanceof RetrieveFareRulesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveFareRulesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveFareRulesCommand retrieveFareRulesCommand = (RetrieveFareRulesCommand) command;
		FareRulesResponse fareRulesResponse = fareRulesService
				.retrieveFareRules(retrieveFareRulesCommand.getTripFlight(),
						retrieveFareRulesCommand.isFetchAdditionalRules());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveFareRulesCommand, fareRulesResponse);
		if(!retrieveFareRulesCommand.isFetchAdditionalRules())
			retrieveFareRulesCommand.setFareRules(fareRulesResponse.getFareRules());
		else
			retrieveFareRulesCommand.setAdditionalFareRules(fareRulesResponse.getFareRules());
		return retrieveFareRulesCommand;
	}
}