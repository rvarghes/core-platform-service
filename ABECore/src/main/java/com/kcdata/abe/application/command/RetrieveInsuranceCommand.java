/*
 * RetrieveInsuranceCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.InsuranceGroup;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

public class RetrieveInsuranceCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7012832136814744428L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveInsuranceCommandHandler";

	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */

	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * Field to hold list of insurance groups
	 */
	private List<InsuranceGroup> insuranceGroupList;

	/**
	 * Field to hold the itinerary
	 */
	private Itinerary itinerary;

	/**
	 * @return the insuranceGroupList
	 */
	public List<InsuranceGroup> getInsuranceGroupList() {
		return insuranceGroupList;
	}

	/**
	 * @param insuranceGroupList
	 *            the insuranceGroupList to set
	 */
	public void setInsuranceGroupList(List<InsuranceGroup> insuranceGroupList) {
		this.insuranceGroupList = insuranceGroupList;
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
}
