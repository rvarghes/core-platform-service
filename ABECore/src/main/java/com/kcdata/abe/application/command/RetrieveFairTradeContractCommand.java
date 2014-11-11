/*
 * RetrieveFairTradeContractCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.FairTradeContract;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for fair trade contract
 * 
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class RetrieveFairTradeContractCommand extends ABECommandBase {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 492929186968543857L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveFairTradeContractCommandHandler";
	
	/**
	 * Returns command handler class name
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
	 * @return the fairTradeContract
	 */
	public FairTradeContract getFairTradeContract() {
		return fairTradeContract;
	}


	/**
	 * @param fairTradeContract the fairTradeContract to set
	 */
	public void setFairTradeContract(FairTradeContract fairTradeContract) {
		this.fairTradeContract = fairTradeContract;
	}
	//Fair trade contract object
	private FairTradeContract fairTradeContract;
}