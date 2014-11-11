/*
 * RetrieveAllPricesCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 09, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAllPricesCommand;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.service.HotelsService;
import com.kcdata.abe.business.service.PackagesService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for RetrieveAllPricesCommand usecase
 * 
 * @author hguntupa
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveAllPricesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private HotelsService hotelsService;

	/**
	 * Service class for the command
	 */
	private PackagesService packagesService;

	/**
	 * Method to handle the {@link RetrieveAllPricesCommand}
	 * 
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {

		if (!(command instanceof RetrieveAllPricesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAllPricesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAllPricesCommand retrieveAllPricesCommand = (RetrieveAllPricesCommand) command;
		AllPriceBreakUpResponse response = null;
		if (retrieveAllPricesCommand.getAvailablePackage() != null) {
			// Call Package
			response = this.packagesService
					.retrievePriceBreakUp(retrieveAllPricesCommand
							.getAvailablePackage());
		} else {
			// Call Hotel
			response = this.hotelsService
					.retrievePriceBreakUp(retrieveAllPricesCommand.getHotel());
		}
		this.processResponse(retrieveAllPricesCommand, response);
		retrieveAllPricesCommand.setAllPricesBreakUp(response
				.getAllPricesBreakUp());
		return retrieveAllPricesCommand;
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

	/**
	 * @return the packagesService
	 */
	public PackagesService getPackagesService() {
		return packagesService;
	}

	/**
	 * @param packagesService
	 *            the packagesService to set
	 */
	public void setPackagesService(PackagesService packagesService) {
		this.packagesService = packagesService;
	}

}