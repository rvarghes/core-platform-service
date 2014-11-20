/*
 * PrintItineraryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 21, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

public class PrintItineraryCommand extends ABECommandBase {

	/**
	 * Auto generated serial version id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6952966130526944593L;
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "printItineraryCommandHandler";

	/**
	 * 
	 */
	private List<Comment> commentCollection = new java.util.ArrayList<Comment>();
	
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
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary
	 *            the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public void setContentFormat(String contentFormat) {
		this.contentFormat = contentFormat;
	}

	public String getContentFormat() {
		return contentFormat;
	}

	/**
	 * @return the printContent
	 */
	public String getPrintContent() {
		return printContent;
	}

	/**
	 * @param printContent
	 *            the printContent to set
	 */
	public void setPrintContent(String printContent) {
		this.printContent = printContent;
	}
	

	private String contentFormat;
	private Itinerary itinerary;
	private String printContent;
	private EmailAndPrintMessage messages;

	/**
	 * @return the messages
	 */
	public EmailAndPrintMessage getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(EmailAndPrintMessage messages) {
		this.messages = messages;
	}
	
	/**
	 * @param commentCollection the commentCollection to set
	 */
	public void setCommentCollection(List<Comment> commentCollection) {
		this.commentCollection = commentCollection;
	}

	/**
	 * @return the commentCollection
	 */
	public List<Comment> getCommentCollection() {
		return commentCollection;
	}
	
}
