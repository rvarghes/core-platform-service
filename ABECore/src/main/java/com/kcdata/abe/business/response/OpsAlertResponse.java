/*
 * OpsAlertResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.response.ABEResponse;

public class OpsAlertResponse extends ABEResponse{

	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8784590984707700356L;

	/**
	 * Field to hold list of ops Alert and action codes
	 */
	private OpsAlert opsAlert;

	/**
	 * @return the opsAlert
	 */
	public OpsAlert getOpsAlert() {
		return opsAlert;
	}

	/**
	 * @param opsAlert
	 *            the opsAlert to set
	 */
	public void setOpsAlert(OpsAlert opsAlert) {
		this.opsAlert = opsAlert;
	}
}
