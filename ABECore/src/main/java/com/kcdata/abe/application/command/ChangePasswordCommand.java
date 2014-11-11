/*
 * ChangePasswordCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command for change password
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ChangePasswordCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2895759694172863770L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "changePasswordCommandHandler";

	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */
	
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	// Object to hold user details
	public User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
