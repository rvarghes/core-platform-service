/*
 * BookingCommentsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Class to hold the booking comments
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingCommentsCommand extends ABECommandBase {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1409878383305443011L;

	public static final String ADD_COMMENT = "ADD_COMMENT";
	public static final String RETRIEVE_COMMENT = "RETRIEVE_COMMENT";

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "bookingCommentsCommandHandler";

	/**
	 * Subcommand needs to be executed
	 */
	private String subCommand;

	/**
	 * For add comment flow
	 */
	private Comment comment;

	/**
	 * For retrieve commetns flow
	 */
	private String bookingNumber;
	private List<Comment> commentsList;

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
	 * @return the comment
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber
	 *            the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	/**
	 * @return the commentsList
	 */
	public List<Comment> getCommentsList() {
		return commentsList;
	}

	/**
	 * @param commentsList
	 *            the commentsList to set
	 */
	public void setCommentsList(List<Comment> commentsList) {
		this.commentsList = commentsList;
	}

	/**
	 * Method to retrieve the command handler name
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
