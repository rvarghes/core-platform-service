/*
 * SAPConnectionFactory.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.sap;

import java.io.Serializable;

import org.springframework.context.MessageSourceAware;

import com.sap.mw.jco.JCO.Client;

/**
 * Client factory class for retrieving and releasing SAP Clients.
 * A/A for any use case
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface SAPClientFactory extends Serializable, MessageSourceAware {
	
	/**
	 * Method for retrieving SAP client
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public Client getSAPClient();
	
	/**
	 * Method for releasing SAP client
	 *
	 * @param sapClient - client object to be released
	 *
	 * @see
	 * @since
	 */
	public void releaseSAPClient(Client sapClient);

}
