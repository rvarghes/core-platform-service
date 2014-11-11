/*
 * RetrieveFlightInfoCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Class to hold the RetrieveFlightInfoCommand
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveFlightInfoCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4350125131098773245L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveFlightInfoCommandHandler";
	
	private TripFlight tripFlight;
	
	private FlightInfoCriteria flightInfoCriteria;

	/**
	 * @return the tripFlight
	 */
	public TripFlight getTripFlight() {
		return tripFlight;
	}

	/**
	 * @param tripFlight the tripFlight to set
	 */
	public void setTripFlight(TripFlight tripFlight) {
		this.tripFlight = tripFlight;
	}

	/**
	 * @return the flightInfoCriteria
	 */
	public FlightInfoCriteria getFlightInfoCriteria() {
		return flightInfoCriteria;
	}

	/**
	 * @param flightInfoCriteria the flightInfoCriteria to set
	 */
	public void setFlightInfoCriteria(FlightInfoCriteria flightInfoCriteria) {
		this.flightInfoCriteria = flightInfoCriteria;
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
