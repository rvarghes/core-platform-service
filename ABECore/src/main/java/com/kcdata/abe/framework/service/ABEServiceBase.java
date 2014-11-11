/*
 * ABEServiceBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.service;

import org.springframework.context.MessageSource;

import com.kcdata.abe.framework.context.ABEApplicationContextFactory;

/**
 * This abstract class is extended by all business services.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public abstract class ABEServiceBase implements ABEService {

    /**
     * Field used for accessing application context information.
     *
     * @see
     * @since
     */
    private ABEApplicationContextFactory applicationContextFactory;

	/**
	 * Spring MessageSource object
	 */
	private MessageSource messageSource;
	
	/**
	 * Method returns the ABEApplicationContaxtFactory
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
	 * Method sets the ApplicationContextFactory
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

}