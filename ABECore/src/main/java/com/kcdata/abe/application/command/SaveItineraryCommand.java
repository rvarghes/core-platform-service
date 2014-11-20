/*
 * SaveItineraryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 23, 2010  vgandrap
 ******************************************************************************
 */
package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * 
 * Command class for saving changes in specific Itinerary
 *
 * @author vgandrap
 * @version
 *
 *
 * @see
 * @since
 */

public class SaveItineraryCommand extends ABECommandBase {
	
	/**
	 * Auto generated serial version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9024697132676248897L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "saveItineraryCommandHandler";
	
	/**
	 * Itinerary object to be saved
	 */
	private Itinerary itinerary;

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary
	 *            the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	/**
	 * Method to return the command handler name
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

