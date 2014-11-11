/*
 * EmailCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.EmailCommand;
import com.kcdata.abe.business.response.EmailResponse;
import com.kcdata.abe.business.service.EmailService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class EmailCommandHandler extends ABECommandHandlerBase {

	private EmailService emailService;

	/**
	 * @return the emailService
	 */
	public EmailService getEmailService() {
		return emailService;
	}

	/**
	 * @param emailService
	 *            the emailService to set
	 */
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof EmailCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "EmailItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}

		EmailCommand emailBaseCommand = (EmailCommand) command;
		EmailResponse emailResponse = emailService
				.sendCreditCardAuthorizationForm(emailBaseCommand.getEmailId());
		this.processResponse(emailBaseCommand, emailResponse);
		return emailBaseCommand;
	}

}
