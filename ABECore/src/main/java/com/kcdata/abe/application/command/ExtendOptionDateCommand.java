/*
 * ExtendOptionDateCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 19, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.Date;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

public class ExtendOptionDateCommand extends ABECommandBase {

	/**
	 * TODO: Please insert a description of this field.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1405699617849181136L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "extendoptiondatecommandhandler";


	public String getCommandHandlerName() {
		// TODO Auto-generated method stub
		return COMMAND_HANDLER_NAME;
	}
	
	
	/**
	 * @return the itineraryExtendDate
	 */
	public Date getItineraryExtendDate() {
		return itineraryExtendDate;
	}

	/**
	 * @param itineraryExtendDate the itineraryExtendDate to set
	 */
	public void setItineraryExtendDate(Date itineraryExtendDate) {
		this.itineraryExtendDate = itineraryExtendDate;
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

	private Itinerary itinerary;
	
	private Date itineraryExtendDate;


}
