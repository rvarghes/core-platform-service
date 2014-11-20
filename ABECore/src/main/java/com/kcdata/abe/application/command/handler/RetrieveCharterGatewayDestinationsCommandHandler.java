package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.application.command.RetrieveCharterGatewayDestinationsCommand;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;
import com.kcdata.abe.business.service.CharterGatewayDestinationsService;

public class RetrieveCharterGatewayDestinationsCommandHandler extends
		ABECommandHandlerBase {
	
	private CharterGatewayDestinationsService charterGatewayDestinationsService;

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveCharterGatewayDestinationsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "RetrieveCharterGatewayDestinationsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		
		RetrieveCharterGatewayDestinationsCommand charterGatewayDestinationsCommand = (RetrieveCharterGatewayDestinationsCommand) command;
		CharterGatewayDestinationResponse charterGatewayDestinationResponse = charterGatewayDestinationsService
					.retrieveCharterGatewayDestinations();
		this.processResponse(charterGatewayDestinationsCommand, charterGatewayDestinationResponse);
		charterGatewayDestinationsCommand.setGateways(charterGatewayDestinationResponse.getGatewayList());
		return charterGatewayDestinationsCommand;		
	}

	
	/**
	 * @return the charterGatewayDestinationsService
	 */
	public CharterGatewayDestinationsService getCharterGatewayDestinationsService() {
		return charterGatewayDestinationsService;
	}


	/**
	 * @param charterGatewayDestinationsService the charterGatewayDestinationsService to set
	 */
	public void setCharterGatewayDestinationsService(
			CharterGatewayDestinationsService charterGatewayDestinationsService) {
		this.charterGatewayDestinationsService = charterGatewayDestinationsService;
	}
}
