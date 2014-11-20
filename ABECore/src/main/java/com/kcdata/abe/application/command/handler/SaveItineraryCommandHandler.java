/*
 * SaveItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 23, 2010  vgandrap		Command Handler class for saving itinerary data &
 * 								create Quote	
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.application.command.SaveItineraryCommand;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class SaveItineraryCommandHandler extends ABECommandHandlerBase{

	/**
	 * Itinerary booking service
	 */
	private ItineraryService itineraryService;

	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

	/**
	 * @param itineraryService
	 *            the itineraryService to set
	 */
	public void setItineraryService(
			ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}
	
	/**
	 * Method to handle the SaveItineraryChangeCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof SaveItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEGAL_COMMAND_ERROR",
					new Object[] { "SaveItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		SaveItineraryCommand saveItineraryCommand = (SaveItineraryCommand) command;
		// Save Itinerary
		//Remove seat information before saving quote
		List<SeatAllocations> tempList = saveItineraryCommand.getItinerary().getSeatAllocationList();
		if(saveItineraryCommand.getItinerary() != null)
		{
			
			saveItineraryCommand.getItinerary().setSeatAllocationList(new ArrayList<SeatAllocations>());
			if(saveItineraryCommand.getItinerary().getServices() != null)
			{
				Iterator it = saveItineraryCommand.getItinerary().getServices().iterator();
				while(it.hasNext())
				{
					Object obj = it.next();
					if(obj instanceof SeatAllocations)
					{
						it.remove();
					}
				}
			}
		}
		ItineraryResponse itineraryResponse = itineraryService
				.saveItinerary(saveItineraryCommand.getItinerary());
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(saveItineraryCommand, itineraryResponse);
		if(tempList != null && itineraryResponse.getItinerary() != null)
		{
			itineraryResponse.getItinerary().setSeatAllocationList(tempList);
		}
		saveItineraryCommand.setItinerary(itineraryResponse
				.getItinerary());
		return saveItineraryCommand;
	}

}
