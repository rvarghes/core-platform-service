/*
 * RetrieveOpsAlertActionCodesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.command.ABECommandBase;

public class RetrieveOpsAlertActionCodesCommand extends ABECommandBase{

	/**
	 * Default serialization version Id.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 4349253724850544018L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveOpsAlertActionCodesCommandHandler";
	
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
	 * Field to hold Ops alerts and actions codes
	 */
	private OpsAlert opsAlert;
	
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
	
}
