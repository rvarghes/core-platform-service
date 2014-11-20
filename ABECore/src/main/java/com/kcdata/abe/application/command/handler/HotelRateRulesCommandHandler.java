/*
 * HotelRateRulesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 25, 2011  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.HotelRateRulesCommand;
import com.kcdata.abe.business.response.HotelRateRulesResponse;
import com.kcdata.abe.business.service.FareRulesService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching direct rate rules for GDS/Worldspan Hotels
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class HotelRateRulesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private FareRulesService rateRulesService;

	/**
	 * @return the rateRulesService
	 */
	public FareRulesService getRateRulesService() {
		return rateRulesService;
	}

	/**
	 * @param rateRulesService the rateRulesService to set
	 */
	public void setRateRulesService(FareRulesService rateRulesService) {
		this.rateRulesService = rateRulesService;
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
		if (!(command instanceof HotelRateRulesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "HotelRateRulesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		HotelRateRulesCommand rateRulesCommand = (HotelRateRulesCommand) command;
		HotelRateRulesResponse rateRulesResponse = rateRulesService
				.retrieveHotelRateRules(rateRulesCommand.getHotel());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(rateRulesCommand, rateRulesResponse);
		rateRulesCommand.setHotel(rateRulesResponse.getHotel());
		return rateRulesCommand;
	}
}