/*
 * RetrieveHotelChainCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.CarType;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * 
 * @author npanday
 *
 */
public class RetrieveVehicleClassCommand extends ABECommandBase {


	private static final long serialVersionUID = 7323745806513840406L;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveVehicleClassCommandHandler";

	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */
	
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}
	
	/**
	 * @param carTypes the carTypes to set
	 */
	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}


	/**
	 * @return the carTypes
	 */
	public List<CarType> getCarTypes() {
		return carTypes;
	}


	private List<CarType> carTypes;
}