/*
 * RetrievePackagesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.FlightOffer;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class to retrieve packages availability
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrievePackagesCommand extends ABECommandBase {

	public static final String PACKAGE_AVAILABILITY = "PACKAGE_AVAILABILITY";
	public static final String CHANGE_FLIGHT = "CHANGE_FLIGHT";
	public static final String CHANGE_HOTEL = "CHANGE_HOTEL";
	public static final String CHANGE_VEHICLE = "CHANGE_VEHICLE";
	public static final String SPECIAL_PACKAGE_AVAILABILITY = "SPECIAL_PACKAGE_AVAILABILITY";

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1571329904453114862L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrievePackagesCommandHandler";

	/**
	 * Search criteria for retrieving flights
	 */
	private SearchCriteria searchCriteria;

	/**
	 * Subcommand needs to be executed
	 */
	private String subCommand;

	/**
	 * Package availability
	 */
	private Package availablePackage;
	//Added as indicator if requested charter flight date(s) are all sold out
	private boolean charterSoldOut;
	private FlightOffer flightOffer;
	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand
	 *            the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	/**
	 * @return the availablePackage
	 */
	public Package getAvailablePackage() {
		return availablePackage;
	}

	/**
	 * @param availablePackage
	 *            the availablePackage to set
	 */
	public void setAvailablePackage(Package availablePackage) {
		this.availablePackage = availablePackage;
	}

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
	 * @return the charterSoldOut
	 */
	public boolean getCharterSoldOut() {
		return charterSoldOut;
	}

	/**
	 * @param charterSoldOut the charterSoldOut to set
	 */
	public void setCharterSoldOut(boolean charterSoldOut) {
		this.charterSoldOut = charterSoldOut;
	}

	/**
	 * @return the flightOffer
	 */
	public FlightOffer getFlightOffer() {
		return flightOffer;
	}

	/**
	 * @param flightOffer the flightOffer to set
	 */
	public void setFlightOffer(FlightOffer flightOffer) {
		this.flightOffer = flightOffer;
	}

}
