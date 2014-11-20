/*
 * RetrieveAmenitiesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Retrieve amenities  command class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class RetrieveAmenitiesCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3864959129619396855L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveAmenitiesCommandHandler";

	/**
	 * amenities response
	 */
	public List<Amenity> amenities;

	/**
	 * @return the amenities
	 */
	public List<Amenity> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities
	 *            the amenities to set
	 */
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * Method to retrieve the command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}
	
}
