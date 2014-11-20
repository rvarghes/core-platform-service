/*
 * RetrieveCharterDatesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 22, 2009  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveCharterFlightsDatesCommand;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.service.FlightsService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler for RetrieveCharterFlightsDatesCommand CharterFlightsDates usecase
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveCharterDatesCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service to retrieve the Charter Flights availability dates
	 */
	private FlightsService flightsService;

	/**
	 * @return the CharterFlightsDates
	 */
	public FlightsService getFlightsService() {
		return flightsService;
	}

	/**
	 * @param CharterFlightsDates
	 *            the CharterFlightsDates to set
	 */
	public void setFlightsService(FlightsService flightsService) {
		this.flightsService = flightsService;
	}

	/**
	 * Method to handle the RetrieveCharterFlightsDatesCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveCharterFlightsDatesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveCharterFlightsDatesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveCharterFlightsDatesCommand retrieveCharterFlightsDatesCommand = (RetrieveCharterFlightsDatesCommand) command;
		//get charter flights
		FlightsResponse charterFlightsResponse = flightsService.retrieveCharterOperatingDates(retrieveCharterFlightsDatesCommand.getSearchCriteria());
		
		if(charterFlightsResponse.getCharterDates() != null && charterFlightsResponse.getCharterDates().size()>0)
		{
		retrieveCharterFlightsDatesCommand.setCharterDates(charterFlightsResponse.getCharterDates());
		retrieveCharterFlightsDatesCommand.setNonCharterDates(charterFlightsResponse.getNonCharterDates());
		retrieveCharterFlightsDatesCommand.setCharterNotAvailDates(charterFlightsResponse.getCharterNotAvailDates());
		}
		return retrieveCharterFlightsDatesCommand;
	}
}
