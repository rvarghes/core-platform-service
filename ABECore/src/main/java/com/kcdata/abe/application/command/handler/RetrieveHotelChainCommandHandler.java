/*
 * RetrieveHotelChainCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov,09 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveHotelChainCommand;
import com.kcdata.abe.business.response.HotelChainResponse;
import com.kcdata.abe.business.service.HotelChainService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for fetching hotel chain
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveHotelChainCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private HotelChainService hotelChainService;

	/**
	 * @return the resortAreaService
	 */
	public HotelChainService getHotelChainService() {
		return hotelChainService;
	}

	/**
	 * @param resortAreasService
	 *            the resortAreasService to set
	 */
	public void setHotelChainService(HotelChainService hotelChainService) {
		this.hotelChainService = hotelChainService;
	}

	/**
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveHotelChainCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveHotelChainCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveHotelChainCommand retrieveHotelChainCommand = (RetrieveHotelChainCommand) command;
		HotelChainResponse hotelChainResponse = hotelChainService.retrieveHotelChain(retrieveHotelChainCommand.getDestination());
		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(retrieveHotelChainCommand, hotelChainResponse);
		retrieveHotelChainCommand.setHotelChain(hotelChainResponse.getHotelChain());
		return retrieveHotelChainCommand;
	}

}