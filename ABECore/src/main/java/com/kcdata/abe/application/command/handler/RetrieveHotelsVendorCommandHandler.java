/*
 * RetrieveHotelsVendorCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.List;

import com.kcdata.abe.application.command.RetrieveHotelsCommand;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.service.HotelsService;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for RetrieveHotelsCommand usecase
 * 
 * @author atripath
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveHotelsVendorCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private HotelsService hotelsService;

	/**
	 * Method to handle the RetrieveHotelsCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof RetrieveHotelsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveHotelsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		RetrieveHotelsCommand hotelsCommand = (RetrieveHotelsCommand) command;
		
		List<Hotel> hotelList = hotelsCommand.getHotels();
		HotelsResponse hotelsResponse = hotelsService.retrieveHotelVendor(hotelList);
		this.processResponse(hotelsCommand, hotelsResponse);
		hotelsCommand.setHotels(hotelsResponse.getHotelList());
		return hotelsCommand;
	}

	/**
	 * @return the hotelsService
	 */
	public HotelsService getHotelsService() {
		return hotelsService;
	}

	/**
	 * @param hotelsService
	 *            the hotelsService to set
	 */
	public void setHotelsService(HotelsService hotelsService) {
		this.hotelsService = hotelsService;
	}

}