/*
 * UpdateEdocsInfoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.UpdateEdocsInfoCommand;
import com.kcdata.abe.business.response.EdocsInfoResponse;
import com.kcdata.abe.business.service.EdocsInfoService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class to handle UpdateEdocsInfoCommand
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class UpdateEdocsInfoCommandHandler extends ABECommandHandlerBase {

	private EdocsInfoService edocsInfoService;

	/**
	 * @return the edocsInfoService
	 */
	public EdocsInfoService getEdocsInfoService() {
		return edocsInfoService;
	}

	/**
	 * @param edocsInfoService
	 *            the edocsInfoService to set
	 */
	public void setEdocsInfoService(EdocsInfoService edocsInfoService) {
		this.edocsInfoService = edocsInfoService;
	}

	/**
	 * Handler class to handle the UpdateCommandHandler
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof UpdateEdocsInfoCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "UpdateEdocsInfoCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		UpdateEdocsInfoCommand edocsInfoCommand = (UpdateEdocsInfoCommand) command;

		// Update EdocsInfo
		EdocsInfoResponse edocsInfoResponse = edocsInfoService
				.storeEdocsInfo(edocsInfoCommand.getEdocsInfo());

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(edocsInfoCommand, edocsInfoResponse);
		return edocsInfoCommand;
	}
}
