/*
 * ApplyPaymentCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ApplyPaymentCommand;
import com.kcdata.abe.business.response.ApplyPaymentResponse;
import com.kcdata.abe.business.service.ApplyPaymentService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class ApplyPaymentCommandHandler extends ABECommandHandlerBase{

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
		if (!(command instanceof ApplyPaymentCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ApplyPaymentCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		ApplyPaymentCommand applyPaymentCommand = (ApplyPaymentCommand) command;
		ApplyPaymentResponse applyPaymentResponse = applyPaymentService.applyPayment(applyPaymentCommand.getPaymentInformation());
		
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(applyPaymentCommand, applyPaymentResponse);
		return applyPaymentCommand;
	}
}
