/*
 * RetrieveAirlineInfoCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.AirlineInfo;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Retrieve Airline Info command class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveAirlineInfoCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "airlineInfoCommandHandler";

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
	 * @return the airlineCode
	 */
	public String getAirlineCode() {
		return airlineCode;
	}

	/**
	 * @param airlineCode the airlineCode to set
	 */
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	/**
	 * @return the airlineInfo
	 */
	public AirlineInfo getAirlineInfo() {
		return airlineInfo;
	}

	/**
	 * @param airlineInfo the airlineInfo to set
	 */
	public void setAirlineInfo(AirlineInfo airlineInfo) {
		this.airlineInfo = airlineInfo;
	}

	/**
	 * Field to hold airline code
	 */
	private String airlineCode;
	
	/**
	 * Object to hold airline information
	 */
	private AirlineInfo airlineInfo;
}
