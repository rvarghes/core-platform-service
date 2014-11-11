/*
 * ApplyPaymentCheckCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ApplyPaymentCheckCommand;
import com.kcdata.abe.business.response.ApplyPaymentResponse;
import com.kcdata.abe.business.service.ApplyPaymentService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for apply payment check
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class ApplyPaymentCheckCommandHandler extends ABECommandHandlerBase{

	/**
	 * Service class for the command
	 */
	private ApplyPaymentService applyPaymentService;

	/**
	 * @return the applyPaymentService
	 */
	public ApplyPaymentService getApplyPaymentService() {
		return applyPaymentService;
	}

	/**
	 * @param insuranceService
	 *            the insuranceService to set
	 */
	public void setApplyPaymentService(
			ApplyPaymentService applyPaymentService) {
		this.applyPaymentService = applyPaymentService;
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
		if (!(command instanceof ApplyPaymentCheckCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ApplyPaymentCheckCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		ApplyPaymentCheckCommand applyPmntCheckCommand = (ApplyPaymentCheckCommand) command;
		ApplyPaymentResponse applyPaymentResponse = 
			applyPaymentService.applyPaymentCheck(applyPmntCheckCommand.getBookingNo(), 
					applyPmntCheckCommand.getUserName(), applyPmntCheckCommand.getUserGroupName());
		
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(applyPmntCheckCommand, applyPaymentResponse);
		return applyPmntCheckCommand;
	}
}