/*
 * RetrieveGatewayDestinationsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class to retrieve gateway destinations
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveGatewayDestinationsCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3318814113014470527L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveGatewayDestinationsCommandHandler";

	/**
	 * gateway response
	 */
	public List<Gateway> gateways;

	/**
	 * @return the gateways
	 */
	public List<Gateway> getGateways() {
		return gateways;
	}

	/**
	 * @param gateways
	 *            the gateways to set
	 */
	public void setGateways(List<Gateway> gateways) {
		this.gateways = gateways;
	}

	/**
	 * @return the destinations
	 */
	public List<Destination> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations
	 *            the destinations to set
	 */
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	/**
	 * destination response
	 */
	public List<Destination> destinations;

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
