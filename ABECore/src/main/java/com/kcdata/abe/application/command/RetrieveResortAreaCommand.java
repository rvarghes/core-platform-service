/*
 * RetrieveResortAreasCommand.java
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

import com.kcdata.abe.data.dto.ResortArea;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Retrieve resort areas command class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveResortAreaCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3406958002772360489L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveResortAreaCommandHandler";

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
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the resortAreas
	 */
	public List<ResortArea> getResortAreas() {
		return resortAreas;
	}

	/**
	 * @param resortAreas the resortAreas to set
	 */
	public void setResortAreas(List<ResortArea> resortAreas) {
		this.resortAreas = resortAreas;
	}

	/**
	 * Field to hold destination
	 */
	private String destination;
	
	/**
	 * Field to hold list of resort areas
	 */
	private List<ResortArea> resortAreas;
}