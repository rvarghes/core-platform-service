/*
 * ABECommandHandlerBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.command.handler;

import org.springframework.context.MessageSource;

import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.context.ABEApplicationContextFactory;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * abstract ABECommandHandlerBase class. This class is the base class for all
 * CommandHandler classes.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public abstract class ABECommandHandlerBase implements ABECommandHandler {

	/**
	 * Field used for accessing application context information.
	 * 
	 * @see
	 * @since
	 */
	ABEApplicationContextFactory applicationContextFactory;

	/**
	 * Spring MessageSource object
	 */
	private MessageSource messageSource;

	/**
	 * Method to return the ApplicationContextFactory
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public ABEApplicationContextFactory getApplicationContextFactory() {
		return applicationContextFactory;
	}

	/**
	 * Method to set the ApplicationContextFactory
	 * 
	 * @param applicationContextFactory
	 * 
	 * @see
	 * @since
	 */
	
	public void setApplicationContextFactory(
			ABEApplicationContextFactory applicationContextFactory) {
		this.applicationContextFactory = applicationContextFactory;
	}

	/**
	 * Method to set the MessageSource
	 * 
	 * @param messageSource
	 * 
	 * @see
	 * @since
	 */
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * Method to return the MessageSource
	 * 
	 * @param messageSource
	 * 
	 * @see
	 * @since
	 */
	public MessageSource getMessageSource() {
		return this.messageSource;
	}

	/**
	 * This method process response object's business errors, warnings and info messages
	 * 
	 * @param response
	 *            response object being processed
	 * 
	 * @see
	 * @since
	 */
	public void processResponse(ABECommand command, ABEResponse response) {
		if (response != null) {	
			command.setSystemErrors(response.getSystemErrors());
			command.setBusinessErrors(response.getBusinessErrors());
			command.setWarnings(response.getWarnings());
			command.setInfoMessages(response.getInfoMessages());
		}
	}

}
