/*
 * SpecialsCacheResponse.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 5, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.applevac.sce.schema.Specials;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * 
 * Specials Response returned from SCEWeb
 * @author chazari
 * @version
 * @see
 * @since
 */
public class SpecialsCacheResponse extends ABEResponse {

	/**
	 * Auto generated serial Id
	 */
	private static final long serialVersionUID = -8583697377442432439L;
	
	private Specials retrievedSpecialsList;

	/**
	 * @return the retrievedSpecialsList
	 */
	public Specials getRetrievedSpecialsList() {
		return retrievedSpecialsList;
	}

	/**
	 * @param retrievedSpecialsList the retrievedSpecialsList to set
	 */
	public void setRetrievedSpecialsList(Specials retrievedSpecialsList) {
		this.retrievedSpecialsList = retrievedSpecialsList;
	}
}
