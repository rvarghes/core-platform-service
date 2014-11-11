/*
 * RetrieveMultiDestPackageCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Class to retrieve multi-destination packages
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveMultiDestPackageCommand extends ABECommandBase {

	public static final String MULTI_DEST_PACKAGE_AVAILABILITY = "MULTI_DEST_PACKAGE_AVAILABILITY";
	public static final String CHANGE_FLIGHT = "CHANGE_FLIGHT";
	public static final String CHANGE_HOTEL = "CHANGE_HOTEL";
	public static final String CHANGE_VEHICLE = "CHANGE_VEHICLE";

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7588429657040109619L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveMultiDestPackageCommandHandler";

	/**
	 * Search criteria for retrieving flights
	 */
	private SearchCriteria searchCriteria;

	/**
	 * Subcommand needs to be executed
	 */
	private String subCommand;

	/**
	 * MultiDestinationPackage availability
	 */
	private MultiDestinationPackage multiDestinationPackage;

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
	 * @return the multiDestinationPackage
	 */
	public MultiDestinationPackage getMultiDestinationPackage() {
		return multiDestinationPackage;
	}

	/**
	 * @param multiDestinationPackage
	 *            the multiDestinationPackage to set
	 */
	public void setMultiDestinationPackage(
			MultiDestinationPackage multiDestinationPackage) {
		this.multiDestinationPackage = multiDestinationPackage;
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
}
