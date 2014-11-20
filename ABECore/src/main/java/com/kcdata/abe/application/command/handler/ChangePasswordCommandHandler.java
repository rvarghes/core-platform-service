/*
 * ChangePasswordCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.ChangePasswordCommand;
import com.kcdata.abe.business.response.AuthenticateUserResponse;
import com.kcdata.abe.business.service.UserService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for password change
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class ChangePasswordCommandHandler extends ABECommandHandlerBase {
	
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
	 * @param userService the userService to set
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
		if (!(command instanceof ChangePasswordCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "ChangePasswordCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, 
										new IllegalArgumentException(message));
		}
		ChangePasswordCommand changePwdCommand = 
									(ChangePasswordCommand) command;
		
		AuthenticateUserResponse userResponse = 
			userService.changePassword(changePwdCommand.getUser());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(changePwdCommand, userResponse);
		changePwdCommand.setUser(userResponse.getUser());
		return changePwdCommand;
	}

}
