package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.framework.command.ABECommandBase;

public class RetrieveCharterGatewayDestinationsCommand extends ABECommandBase {

	
	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = -6623094541482713067L;

	/**
	 * Name of Command Handler that handles the command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveCharterGatewayDestinationsCommandHandler";

	/**
	 * Gateway Response
	 */
	public List<Gateway> gateways;
	
	
	/**
	 * @return the gateways
	 */
	public List<Gateway> getGateways() {
		return gateways;
	}


	/**
	 * @param gateways the gateways to set
	 */
	public void setGateways(List<Gateway> gateways) {
		this.gateways = gateways;
	}

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
