/*
 * RetrieveAgenciesSearchCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 21, 2011  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for retrieving agencies search information
 * 
 * @author kmadugul
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveAgenciesSearchCommand extends ABECommandBase {

	
	private static final long serialVersionUID = 8454760817892309120L;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveAgenciesSearchCommandHandler";

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
	 * @return the agency
	 */
	public List<Agency> getAgenciesSearchList() {
		return agenciesSearchList;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgenciesSearchList(List<Agency> agenciesSearchList) {
		this.agenciesSearchList = agenciesSearchList;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}

	private List<Agency> agenciesSearchList;
	private Agency agency;
}