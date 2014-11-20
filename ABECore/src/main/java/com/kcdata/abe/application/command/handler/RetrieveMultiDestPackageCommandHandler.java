/*
 * RetrieveMultiDestPackageCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveMultiDestPackageCommand;
import com.kcdata.abe.business.response.MultiDestinationPackageResponse;
import com.kcdata.abe.business.service.MultiDestinationPackageService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for RetrieveMultiDestPackageCommand. RetrieveMultiDestPackage
 * usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveMultiDestPackageCommandHandler extends
		ABECommandHandlerBase {

	/**
	 * Service to retrieve multi-destination services
	 */
	private MultiDestinationPackageService multiDestinationPackageService;

	/**
	 * @return the multiDestinationPackageService
	 */
	public MultiDestinationPackageService getMultiDestinationPackageService() {
		return multiDestinationPackageService;
	}

	/**
	 * @param multiDestinationPackageService
	 *            the multiDestinationPackageService to set
	 */
	public void setMultiDestinationPackageService(
			MultiDestinationPackageService multiDestinationPackageService) {
		this.multiDestinationPackageService = multiDestinationPackageService;
	}

	/**
	 * Method to handle the RetrievePackagesCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveMultiDestPackageCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveMultiDestPackageCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveMultiDestPackageCommand multiDestPkgCommand = (RetrieveMultiDestPackageCommand) command;
		MultiDestinationPackageResponse multiDestPkgResponse;

		if (RetrieveMultiDestPackageCommand.CHANGE_FLIGHT
				.equals(multiDestPkgCommand.getSubCommand())) {
			// Change flight of a package
			multiDestPkgResponse = multiDestinationPackageService
					.changeFlights(multiDestPkgCommand
							.getMultiDestinationPackage());
		} else if (RetrieveMultiDestPackageCommand.CHANGE_HOTEL
				.equals(multiDestPkgCommand.getSubCommand())) {
			// Change hotel component of a package
			multiDestPkgResponse = multiDestinationPackageService
					.changeHotels(multiDestPkgCommand
							.getMultiDestinationPackage());
		} else if (RetrieveMultiDestPackageCommand.CHANGE_VEHICLE
				.equals(multiDestPkgCommand.getSubCommand())) {
			// Change vehicle component of a package
			multiDestPkgResponse = multiDestinationPackageService
					.changeVehicles(multiDestPkgCommand
							.getMultiDestinationPackage());
		} else {
			// Retrieve Multi-destination packages
			multiDestPkgResponse = multiDestinationPackageService
					.retrievePackages(multiDestPkgCommand.getSearchCriteria());
		}

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(multiDestPkgCommand, multiDestPkgResponse);
		multiDestPkgCommand.setMultiDestinationPackage(multiDestPkgResponse
				.getMultiDestinationPackage());
		return multiDestPkgCommand;
	}

}
