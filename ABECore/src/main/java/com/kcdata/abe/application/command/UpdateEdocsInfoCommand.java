/*
 * UpdateEdocsInfoCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for updating EdocsInfo
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class UpdateEdocsInfoCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8624156610913184188L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "updateEdocsInfoCommandHandler";

	private EdocsInfo edocsInfo;

	/**
	 * @return the edocsInfo
	 */
	public EdocsInfo getEdocsInfo() {
		return edocsInfo;
	}

	/**
	 * @param edocsInfo
	 *            the edocsInfo to set
	 */
	public void setEdocsInfo(EdocsInfo edocsInfo) {
		this.edocsInfo = edocsInfo;
	}

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

}
