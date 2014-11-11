/*
 * ItinerarySearchCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 6, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.ItineraryResult;
import com.kcdata.abe.data.dto.ItinerarySearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

public class ItinerarySearchCommand extends ABECommandBase {

	
	/**
	 * Auto generated serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1054188245631223345L;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "itinerarySearchCommandHandler";

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


	
	public void setItinerarySearchCriteria(ItinerarySearchCriteria itinerarySearchCriteria) {
		this.itinerarySearchCriteria = itinerarySearchCriteria;
	}
	public ItinerarySearchCriteria getItinerarySearchCriteria() {
		return itinerarySearchCriteria;
	}



	public void setItineraries(List<ItineraryResult> itineraries) {
		this.itineraries = itineraries;
	}



	public List<ItineraryResult> getItineraries() {
		return itineraries;
	}



	private ItinerarySearchCriteria itinerarySearchCriteria;
	private List<ItineraryResult> itineraries;

}
