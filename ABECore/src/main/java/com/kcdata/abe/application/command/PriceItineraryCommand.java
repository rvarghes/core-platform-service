/*
 * PriceItineraryCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for pricing the Itinerary
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PriceItineraryCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6474633909387089135L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "priceItineraryCommandHandler";

	/**
	 * Itinerary object to be priced
	 */
	private Itinerary itinerary;
	
	private String subCommand;

	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

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
