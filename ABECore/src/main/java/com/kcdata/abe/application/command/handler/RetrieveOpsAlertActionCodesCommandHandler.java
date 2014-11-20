/*
 * RetrieveOpsAlertActionCodesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveOpsAlertActionCodesCommand;
import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.business.service.OpsAlertService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class RetrieveOpsAlertActionCodesCommandHandler extends
		ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private OpsAlertService opsAlertService;

	/**
	 * @return the opsAlertService
	 */
	public OpsAlertService getOpsAlertService() {
		return opsAlertService;
	}

	/**
	 * @param opsAlertService
	 *            the opsAlertService to set
	 */
	public void setOpsAlertService(OpsAlertService opsAlertService) {
		this.opsAlertService = opsAlertService;
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
		if (!(command instanceof RetrieveOpsAlertActionCodesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveOpsAlertActionCodesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveOpsAlertActionCodesCommand retrieveOpsAlertActionCodesCommand = (RetrieveOpsAlertActionCodesCommand) command;
		OpsAlertResponse opsAlertResponse = opsAlertService
				.retrieveOpsAlertActionCodes();

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveOpsAlertActionCodesCommand,
				opsAlertResponse);
		retrieveOpsAlertActionCodesCommand.setOpsAlert(opsAlertResponse
				.getOpsAlert());
		return retrieveOpsAlertActionCodesCommand;
	}
}
