/*
 * RetrieveSpecialsCommand.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 5, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.applevac.sce.schema.Specials;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class to retrieve a list of specials for a given search criteria
 */
public class RetrieveSpecialsCommand extends ABECommandBase {

	/**
	 * Auto generated serialID
	 */
	private static final long serialVersionUID = -7030812560528879471L;
	/**
	 * Name of the command handler that handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveSpecialsCommandHandler";
	
	public static final String RETRIEVE_HOTELS = "RETRIEVE_HOTELS";
	public static final String RETRIEVE_PACKAGES = "RETRIEVE_PACKAGES";
	
	private SearchCriteria searchCriteria;
	
	private Specials specialsList;
	
	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}
	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	/**
	 * @return the specialsList
	 */
	public Specials getSpecialsList() {
		return specialsList;
	}
	/**
	 * @param specialsList the specialsList to set
	 */
	public void setSpecialsList(Specials specialsList) {
		this.specialsList = specialsList;
	}

	/**
	 * Returns a command handler name
	 * @return COMMAND_HANDLER_NAME
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

}
