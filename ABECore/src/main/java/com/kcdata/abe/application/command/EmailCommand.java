/*
 * EmailCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2010  cmelam
 * Sep 28, 2010  hguntupa	  Refactored by Hemanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.framework.command.ABECommandBase;

public class EmailCommand extends ABECommandBase {

	/**
	 * Auto generated serial id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2049444607006070302L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "emailCommandHandler";

	/**
	 * Method to return the command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	private String emailId;
}
