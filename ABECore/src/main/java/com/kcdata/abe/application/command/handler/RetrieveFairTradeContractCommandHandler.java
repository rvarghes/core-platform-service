/*
 * RetrieveFairTradeContractCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveFairTradeContractCommand;
import com.kcdata.abe.business.response.FairTradeContractResponse;
import com.kcdata.abe.business.service.FairTradeContractService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fair trade contract
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class RetrieveFairTradeContractCommandHandler extends
		ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private FairTradeContractService fairTradeContractService;
	
	/**
	 * @return the fairTradeContractService
	 */
	public FairTradeContractService getFairTradeContractService() {
		return fairTradeContractService;
	}

	/**
	 * @param fairTradeContractService the fairTradeContractService to set
	 */
	public void setFairTradeContractService(
			FairTradeContractService fairTradeContractService) {
		this.fairTradeContractService = fairTradeContractService;
	}

	/**
	 * Handle method implementation
	 *
	 * @param command
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveFairTradeContractCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveFairTradeContractCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveFairTradeContractCommand retrieveFTCCommand = (RetrieveFairTradeContractCommand) command;
		FairTradeContractResponse ftcResponse = fairTradeContractService.retrieveTermsAndConditions();
		
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveFTCCommand, ftcResponse);
		//Set fair trade contract response
		retrieveFTCCommand.setFairTradeContract(ftcResponse.getFairTradeContract());
		return retrieveFTCCommand;
	}
}