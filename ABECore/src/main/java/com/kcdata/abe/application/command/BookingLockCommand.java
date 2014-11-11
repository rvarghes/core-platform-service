/*
 * BookingLockCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for Booking Lock
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6940092502351291135L;

	public static final String CREATE_LOCK = "CREATE_LOCK";
	public static final String RELEASE_LOCK = "RELEASE_LOCK";
	public static final String RELEASE_LOCK_ADMIN = "RELEASE_LOCK_ADMIN";

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "bookingLockCommandHandler";

	private BookingLockDetails bookingLockDetails;

	private String bookingNo;

	private String subCommand;

	/**
	 * @return the bookingLockDetails
	 */
	public BookingLockDetails getBookingLockDetails() {
		return bookingLockDetails;
	}

	/**
	 * @param bookingLockDetails
	 *            the bookingLockDetails to set
	 */
	public void setBookingLockDetails(BookingLockDetails bookingLockDetails) {
		this.bookingLockDetails = bookingLockDetails;
	}

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
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
	 * Returns command handler name
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
