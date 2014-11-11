/*
 * RetrieveHotelsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * June 26, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for retrieving hotels
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class RetrieveHotelsCommand extends ABECommandBase {
	
	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8229223012133674935L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveHotelsCommandHandler";
	
	/**
	 * Search criteria for retrieving hotels
	 */
	private SearchCriteria searchCriteria;
	
	/**
	 * List of hotels 
	 */
	public List<Hotel> hotels;

	/**
	 * List of destination for destn based services 
	 */
	public List<Destination> destinations;
	
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

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the hotels
	 */
	public List<Hotel> getHotels() {
		return hotels;
	}

	/**
	 * @param hotels the hotels to set
	 */
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	/**
	 * @return the destinations
	 */
	public List<Destination> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations the destinations to set
	 */
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

}
