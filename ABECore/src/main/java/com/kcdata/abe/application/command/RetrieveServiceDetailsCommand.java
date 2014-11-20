/*
 * RetrieveServiceDetailsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 20, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for retrieving Service details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveServiceDetailsCommand extends ABECommandBase {

	/**
	 * Suto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9143391057093976828L;

	private Service service;

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveServiceDetailsCommandHandler";

	/**
	 * Method to retrieve the command handler name
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
