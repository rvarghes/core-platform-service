/*
 * RetrieveItineraryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 29, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

public class RetrieveItineraryCommand extends ABECommandBase {

	/**
	 * Auto Generated serial ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -9009982592665924891L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveItineraryCommandHandler";
	
	/**
	 * Returns command handler name
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
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	/**
	 * 
	 * set quote no
	 *
	 * @param quoteNo
	 *
	 * @see
	 * @since
	 */
	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}
	
	/**
	 * 
	 * get quote no
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public String getQuoteNo() {
		return quoteNo;
	}

	//Itinerary number
	private String quoteNo;
	//Retrieved itinerary details
	private Itinerary itinerary;
}