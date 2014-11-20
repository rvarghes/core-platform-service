/*
 * OpsAlertCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 8, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.command.ABECommandBase;

public class OpsAlertCommand extends ABECommandBase {

	/**
	 * Default serialization version Id.
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8929626796032673002L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "opsAlertCommandHandler";

	public static final String CREATE_ALERT = "CREATE_ALERT";
	public static final String RETRIEVE_ALERT = "RETRIEVE_ALERT";

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

	/**
	 * Subcommand needs to be executed
	 */
	private String subCommand;

	/**
	 * Field to hold Ops alert information for the booking
	 */
	private OpsAlert opsAlert;

	/**
	 * Field to hold opsAlert ID
	 */
	private String opsAlertCode;

	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand
	 *            the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	/**
	 * @return the opsAlert
	 */
	public OpsAlert getOpsAlert() {
		return opsAlert;
	}

	/**
	 * @param opsAlert
	 *            the opsAlert to set
	 */
	public void setOpsAlert(OpsAlert opsAlert) {
		this.opsAlert = opsAlert;
	}

	/**
	 * @return the opsAlertCode
	 */
	public String getOpsAlertCode() {
		return opsAlertCode;
	}

	/**
	 * @param opsAlertCode
	 *            the opsAlertCode to set
	 */
	public void setOpsAlertCode(String opsAlertCode) {
		this.opsAlertCode = opsAlertCode;
	}

}
