/*
 * RetrieveFareRulesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.FareRule;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for retrieving fare rules for SKED flights
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveFareRulesCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 7586050025606835944L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveFareRulesCommandHandler";

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
	 * @return the isFetchAdditionalRules
	 */
	public boolean isFetchAdditionalRules() {
		return isFetchAdditionalRules;
	}

	/**
	 * @param isFetchAdditionalRules the isFetchAdditionalRules to set
	 */
	public void setFetchAdditionalRules(boolean isFetchAdditionalRules) {
		this.isFetchAdditionalRules = isFetchAdditionalRules;
	}

	/**
	 * @return the fareRules
	 */
	public List<FareRule> getFareRules() {
		return fareRules;
	}

	/**
	 * @return the addtionalFareRules
	 */
	public List<FareRule> getAdditionalFareRules() {
		return additionalFareRules;
	}

	/**
	 * @param addtionalFareRules the addtionalFareRules to set
	 */
	public void setAdditionalFareRules(List<FareRule> additionalFareRules) {
		this.additionalFareRules = additionalFareRules;
	}

	/**
	 * @param fareRules the fareRules to set
	 */
	public void setFareRules(List<FareRule> fareRules) {
		this.fareRules = fareRules;
	}

	/**
	 * Field to hold trip flight
	 */
	private TripFlight tripFlight;
	/**
	 * Flag indicating additional fare rules retrieval
	 */
	private boolean isFetchAdditionalRules;
	
	/**
	 * Field to hold list of additional fare rules
	 */
	private List<FareRule> additionalFareRules;

	/**
	 * Field to hold list of fare rules
	 */
	private List<FareRule> fareRules;
}