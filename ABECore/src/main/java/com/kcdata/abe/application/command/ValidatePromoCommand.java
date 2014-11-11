/*
 * ValidatePromoCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for validating the promo code
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ValidatePromoCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1185283869346319910L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "validatePromoCommandHandler";

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

}
