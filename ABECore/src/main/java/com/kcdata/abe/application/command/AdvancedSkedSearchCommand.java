/*
 * AdvancedSkedSearchCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;
//SVN Commit Tortois SVN
import java.util.List;

import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.StopOver;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Advanced SKED search command class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AdvancedSkedSearchCommand extends ABECommandBase {
	//Added comment to check svn repository on new version
	 
	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3406958002772360489L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "advancedSkedSearchCommandHandler";

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

	private String subCommand;
	/**
	 * Field to hold list of flight carriers
	 */
	private List<Carrier> carriers;

	/**
	 * Field to hold list of stop overs
	 */
	private List<StopOver> stopovers;

	/**
	 * Field to hold search criteria
	 */
	private SearchCriteria searchCriteria;

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
	 * @return the carriers
	 */
	public List<Carrier> getCarriers() {
		return carriers;
	}

	/**
	 * @param carriers
	 *            the carriers to set
	 */
	public void setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
	}

	/**
	 * @return the stopovers
	 */
	public List<StopOver> getStopovers() {
		return stopovers;
	}

	/**
	 * @param stopovers
	 *            the stopovers to set
	 */
	public void setStopovers(List<StopOver> stopovers) {
		this.stopovers = stopovers;
	}
	
	public String getSubCommand(){
		return this.subCommand;
	}
	public void setSubCommand(String subCommand){
		this.subCommand = subCommand;
	}
}