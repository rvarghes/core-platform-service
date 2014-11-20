/*
 * RetrieveCharterFlightsDatesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 21, 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.CharterFlightsDates;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class to retrieve charter flights dates availability
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RetrieveCharterFlightsDatesCommand extends ABECommandBase {
	
	
	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8295073480918841147L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveCharterDatesCommandHandler";

	/**
	 * Search criteria for retrieving flights
	 */
	private SearchCriteria searchCriteria;
	
	private List<CharterFlightsDates> charterDates;
	private List<CharterFlightsDates> charterNotAvailDates;
	private List<java.util.Date> nonCharterDates;
	
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
	 * @return the searchCriteria
	 */
	public List<CharterFlightsDates> getCharterDates() {
		return charterDates;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setCharterDates(List<CharterFlightsDates> charterDates) {
		this.charterDates = charterDates;
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
	 * @param nonCharterDates the nonCharterDates to set
	 */
	public void setNonCharterDates(List<java.util.Date> nonCharterDates) {
		this.nonCharterDates = nonCharterDates;
	}

	/**
	 * @return the nonCharterDates
	 */
	public List<java.util.Date> getNonCharterDates() {
		return nonCharterDates;
	}

	/**
	 * @param charterNotAvailDates the charterNotAvailDates to set
	 */
	public void setCharterNotAvailDates(List<CharterFlightsDates> charterNotAvailDates) {
		this.charterNotAvailDates = charterNotAvailDates;
	}

	/**
	 * @return the charterNotAvailDates
	 */
	public List<CharterFlightsDates> getCharterNotAvailDates() {
		return charterNotAvailDates;
	}

}
