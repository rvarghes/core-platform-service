/*
 * ABEInterceptorBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.aop.interceptor;

import org.springframework.context.MessageSource;

import com.kcdata.abe.framework.context.ABEApplicationContextFactory;

/**
 * Base class to be extended by all the interceptors N/A any specific usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEInterceptorBase implements ABEInterceptor {
	/**
	 * Field used for accessing application context information..
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
	 * Method to set application context factory
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
	 * Method to set the Application Context Factory
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
