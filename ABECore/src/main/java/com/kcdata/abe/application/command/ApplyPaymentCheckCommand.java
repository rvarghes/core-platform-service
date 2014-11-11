/*
 * ApplyPaymentCheckCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for apply payment check
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class ApplyPaymentCheckCommand extends ABECommandBase{

	/**
	 * Default serialization version Id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5677587878753645396L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "applyPaymentCheckCommandHandler";
	
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userGroupName
	 */
	public String getUserGroupName() {
		return userGroupName;
	}
	/**
	 * @param userGroupName the userGroupName to set
	 */
	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	private String bookingNo;
	private String userName;
	private String userGroupName;
	private String subCommand;
	private Itinerary itinerary;

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
}