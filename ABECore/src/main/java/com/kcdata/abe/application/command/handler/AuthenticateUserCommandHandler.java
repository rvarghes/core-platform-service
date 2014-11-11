/*
 * AuthenticateUserCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.kcdata.abe.application.command.AuthenticateUserCommand;
import com.kcdata.abe.business.response.AuthenticateUserResponse;
import com.kcdata.abe.business.service.UserService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for user authentication
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AuthenticateUserCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private UserService userService;

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		if (!(command instanceof AuthenticateUserCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "AuthenticateUserCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		AuthenticateUserCommand authenticateUserCommand = (AuthenticateUserCommand) command;

		AuthenticateUserResponse userResponse = userService
				.authenticateUser(authenticateUserCommand.getUser());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(authenticateUserCommand, userResponse);
		authenticateUserCommand.setUser(userResponse.getUser());
		//Red issue 3621774: Determine the server offset time
		authenticateUserCommand.setServerOffsetTime(TimeZone.getDefault().getOffset(authenticateUserCommand
				.getDateObj().getTime()));
		// Determine the server offset
		authenticateUserCommand.setServerOffset(computeServerOffSet(
				authenticateUserCommand.getDateStr(), authenticateUserCommand
						.getDateObj()));
		return authenticateUserCommand;
	}

	/**
	 * Method to determine the server offset
	 * 
	 * @param dateStr
	 * @param dateObj
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private int computeServerOffSet(String dateStr, Date dateObj) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date parsedDate;
		try {
			parsedDate = dateFormat.parse(dateStr);
			return ((int)(dateObj.getTime() - parsedDate.getTime()))/(60 * 1000);
		} catch (ParseException e) {
		}
		return 0;
	}

}
