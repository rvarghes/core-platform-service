/*
 * ABEDBDaoBase.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.dao;

import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.kcdata.abe.framework.context.ABEApplicationContextFactory;

/**
 * This abstract class is extended by all Data Access Objects (DAO). N/A for any
 * use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public abstract class ABEDBDaoBase extends SimpleJdbcDaoSupport implements
		ABEDao {
	/**
	 * Field for ABEApplicationContextFactory
	 */
	ABEApplicationContextFactory applicationContextFactory;

	/**
	 * Spring MessageSource object
	 */
	private MessageSource messageSource;

	/**
	 * Method returns ABEApplicationContextFactory
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
	 * Method to set the ABEApplicationContextFactory
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
