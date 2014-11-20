/*
 * ViewItineraryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 16, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.framework.command.ABECommandBase;

public class ViewItineraryCommand extends ABECommandBase{

	/**
	 * TODO: Please insert a description of this field.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "viewItineraryCommandHandler";
	
	
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
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}
	/**
	 * @param bookingNo the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	

	/**
	 * @return the tokenNo
	 */
	public String getTokenNo() {
		return tokenNo;
	}
	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}
	
	/**
	 * @return the agencyCopy
	 */
	public String getAgencyCopy() {
		return agencyCopy;
	}
	/**
	 * @param agencyCopy the agencyCopy to set
	 */
	public void setAgencyCopy(String agencyCopy) {
		this.agencyCopy = agencyCopy;
	}

	private String bookingNo;
	private String tokenNo;
	private String agencyCopy;
}
