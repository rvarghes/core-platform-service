/*
 * RetrieveHotelsCommandHandler.java
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
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for RetrieveHotelsCommand usecase
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveHotelsCommandHandler extends ABECommandHandlerBase {

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
		
		SearchCriteria sCriteria = hotelsCommand.getSearchCriteria();
		
		
		HotelsResponse hotelsResponse = hotelsService.retrieveHotels(sCriteria);
		//CQ#8872 - Rewrite business error message
		if(hotelsResponse.getBusinessErrors() !=null){
			for(ABEBusinessError error: hotelsResponse.getBusinessErrors()){
				if (error.getErrorCode() != null
						&& error.getErrorCode().equals("031")) {
					int index = hotelsResponse.getBusinessErrors().indexOf(error);
					error.setErrorDescription(this.getMessageSource().getMessage("HOTELS_NOT_AVAILABLE_SEARCH_CRITERIA",null, null));
					hotelsResponse.getBusinessErrors().set(index, error);
					break;
				}
			}
		}
		this.processResponse(hotelsCommand, hotelsResponse);
		hotelsCommand.setHotels(hotelsResponse.getHotelList());
		hotelsCommand.setDestinations(hotelsResponse.getDestinations());
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