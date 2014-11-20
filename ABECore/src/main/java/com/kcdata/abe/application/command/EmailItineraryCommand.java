/*
 * EmailItineraryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.EmailAndPrintMessage;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommandBase;

public class EmailItineraryCommand extends ABECommandBase{

	/**
	 * Auto generated serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2049444607006070302L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "emailItineraryCommandHandler";
	public static final String EMAIL_ITINERARY_COMPARISON = "EMAIL_ITINERARY_COMPARISON";
	
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}
	/**
	 * @param itinerary the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
	public void setEmailFormat(String emailFormat) {
		this.emailFormat = emailFormat;
	}

	public String getEmailFormat() {
		return emailFormat;
	}
	
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
	 * @return the fromEmailId
	 */
	public String getFromEmailId() {
		return fromEmailId;
	}

	/**
	 * @param fromEmailId the fromEmailId to set
	 */
	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
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

	/**
	 * @return the itineraries
	 */
	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	/**
	 * @param itineraries the itineraries to set
	 */
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	/**
	 * @return the imgByteArray
	 */
	public byte[] getImgByteArray() {
		return imgByteArray;
	}

	/**
	 * @param imgByteArray the imgByteArray to set
	 */
	public void setImgByteArray(byte[] imgByteArray) {
		this.imgByteArray = imgByteArray;
	}

	private String emailId;
	private String emailFormat;
	private Itinerary itinerary;
	private String fromEmailId;
	private String subCommand;
	private List<Itinerary> itineraries;
	private byte[] imgByteArray;

}
