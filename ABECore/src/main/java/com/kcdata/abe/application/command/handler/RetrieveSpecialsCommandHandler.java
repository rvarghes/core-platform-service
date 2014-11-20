/*
 * RetrieveSpecialsCommandHandler.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 5, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveSpecialsCommand;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.business.service.SpecialsCacheDataService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class RetrieveSpecialsCommandHandler extends ABECommandHandlerBase {
	
	private SpecialsCacheDataService specialsService;
	
	/**
	 * @return the specialsService
	 */
	public SpecialsCacheDataService getSpecialsService() {
		return specialsService;
	}

	/**
	 * @param specialsService the specialsService to set
	 */
	public void setSpecialsService(SpecialsCacheDataService specialsService) {
		this.specialsService = specialsService;
	}
	
	/**
	 * Method to handle the RetrieveSpecialsCommand
	 * @param command
	 * @return command
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveSpecialsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveSpecialsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION, new IllegalArgumentException(
					message));
		}
		RetrieveSpecialsCommand specialsCommand = (RetrieveSpecialsCommand)command;
		SpecialsCacheResponse specialsResponse = specialsService.retrieveSpecials(specialsCommand.getSearchCriteria());
		this.processResponse(specialsCommand, specialsResponse);
		specialsCommand.setSpecialsList(specialsResponse.getRetrievedSpecialsList());
		return specialsCommand;
	}

}
