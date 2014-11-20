/*
 * RetrieveVehiclesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveVehiclesCommand;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.business.service.VehiclesService;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for vehicle availability
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveVehiclesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Vehicle service class
	 * 
	 * @see
	 * @since
	 */
	private VehiclesService vehiclesService;

	/**
	 * @return the vehiclesService
	 */
	public VehiclesService getVehiclesService() {
		return vehiclesService;
	}

	/**
	 * @param vehiclesService
	 *            the vehiclesService to set
	 */
	public void setVehiclesService(VehiclesService vehiclesService) {
		this.vehiclesService = vehiclesService;
	}

	/**
	 * handle method implementation
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveVehiclesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveVehiclesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveVehiclesCommand vehiclesCommand = (RetrieveVehiclesCommand) command;

		SearchCriteria searchCriteria = vehiclesCommand.getSearchCriteria();

		VehiclesResponse vehiclesResponse = vehiclesService
				.retrieveVehicles(searchCriteria);
		
		this.processResponse(vehiclesCommand, vehiclesResponse);
		vehiclesCommand.setVehicles(vehiclesResponse.getVehicles());
		vehiclesCommand.setVendorDetails(vehiclesResponse.getVendorDetails());
		return vehiclesCommand;
	}

}