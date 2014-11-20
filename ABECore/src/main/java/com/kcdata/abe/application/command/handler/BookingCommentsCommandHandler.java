/*
 * BookingCommentsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.BookingCommentsCommand;
import com.kcdata.abe.business.response.CommentsResponse;
import com.kcdata.abe.business.service.CommentsService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for Booking Comments
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingCommentsCommandHandler extends ABECommandHandlerBase {

	private CommentsService commentsService;

	/**
	 * @return the commentsService
	 */
	public CommentsService getCommentsService() {
		return commentsService;
	}

	/**
	 * @param commentsService
	 *            the commentsService to set
	 */
	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	/**
	 * Method to handle the RetrievePackagesCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof BookingCommentsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "BookingCommentsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		BookingCommentsCommand commentsCommand = (BookingCommentsCommand) command;
		CommentsResponse commentsResponse;

		if (BookingCommentsCommand.ADD_COMMENT.equals(commentsCommand
				.getSubCommand())) {
			commentsResponse = commentsService.addComment(commentsCommand
					.getComment());
		} else {
			commentsResponse = commentsService.retrieveComments(commentsCommand
					.getBookingNumber());
			commentsCommand.setCommentsList(commentsResponse.getComments());
		}
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(commentsCommand, commentsResponse);
		return commentsCommand;
	}
}
