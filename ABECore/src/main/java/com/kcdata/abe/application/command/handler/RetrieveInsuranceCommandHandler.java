/*
 * RetrieveInsuranceCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveInsuranceCommand;
import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.business.service.InsuranceService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class RetrieveInsuranceCommandHandler extends ABECommandHandlerBase{
	
	
	/**
	 * Service class for the command
	 */
	private InsuranceService insuranceService;

	/**
	 * @return the insuranceService
	 */
	public InsuranceService getInsuranceService() {
		return insuranceService;
	}

	/**
	 * @param insuranceService
	 *            the insuranceService to set
	 */
	public void setInsuranceService(
			InsuranceService insuranceService) {
		this.insuranceService = insuranceService;
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
		if (!(command instanceof RetrieveInsuranceCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveInsuranceCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveInsuranceCommand retrieveInsuranceCommand = (RetrieveInsuranceCommand) command;
		InsuranceResponse insuranceResponse = insuranceService.retrieveInsurance(retrieveInsuranceCommand.getItinerary());
		
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(retrieveInsuranceCommand, insuranceResponse);
		retrieveInsuranceCommand.setInsuranceGroupList(insuranceResponse.getInsuranceGroupList());
		return retrieveInsuranceCommand;
	}

}
