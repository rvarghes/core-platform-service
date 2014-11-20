/*
 * BookingLockCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.BookingLockCommand;
import com.kcdata.abe.business.response.BookingLockResponse;
import com.kcdata.abe.business.service.BookingLockService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for Booking Lock functionality
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockCommandHandler extends ABECommandHandlerBase {

	private BookingLockService bookingLockService;

	/**
	 * @return the bookingLockService
	 */
	public BookingLockService getBookingLockService() {
		return bookingLockService;
	}

	/**
	 * @param bookingLockService
	 *            the bookingLockService to set
	 */
	public void setBookingLockService(BookingLockService bookingLockService) {
		this.bookingLockService = bookingLockService;
	}

	/**
	 * Method to handle the booking lock
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof BookingLockCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "BookingLockCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		BookingLockCommand bookingLockCommand = (BookingLockCommand) command;
		BookingLockResponse bookingLockResponse = null;
		if (BookingLockCommand.RELEASE_LOCK.equals(bookingLockCommand
				.getSubCommand())
				|| BookingLockCommand.RELEASE_LOCK_ADMIN
						.equals(bookingLockCommand.getSubCommand())) {
			bookingLockResponse = this.bookingLockService
					.releaseLock(bookingLockCommand.getBookingLockDetails());
		} else {
			bookingLockResponse = this.bookingLockService
					.createLock(bookingLockCommand.getBookingNo());
		}
		this.processResponse(bookingLockCommand, bookingLockResponse);
		bookingLockCommand.setBookingLockDetails(bookingLockResponse
				.getBookingLockDetails());
		return bookingLockCommand;
	}

}
