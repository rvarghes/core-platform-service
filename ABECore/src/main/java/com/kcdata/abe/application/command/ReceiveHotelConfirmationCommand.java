/* ReceiveHotelConfirmationCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 30,2014   rvarghes
 ******************************************************************************
 */
 
package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.framework.command.ABECommandBase;

public class ReceiveHotelConfirmationCommand extends ABECommandBase {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5418567961813170541L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "receiveHotelConfirmationCommandHandler";
	
	private HotelConfirmation hotelConfirmation;
	/**
	 * Method to return the command handler name
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
	 * @param hotelConfirmation the hotelConfirmation to set
	 */
	public void setHotelConfirmation(HotelConfirmation hotelConfirmation) {
		this.hotelConfirmation = hotelConfirmation;
	}
	/**
	 * @return the hotelConfirmation
	 */
	public HotelConfirmation getHotelConfirmation() {
		return hotelConfirmation;
	}

}
