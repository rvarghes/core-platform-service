/*
 * OpsAlertService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 * Nov 3, 2009	hguntupa	  Refactored and Added new method to retrieve OpsAlert
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.service.ABEService;

public interface OpsAlertService extends ABEService{

	/**
	 * Method to get the Ops Alert and Action Codes
	 *
	 * @param None
	 * @return OpsAlertResponse
	 *
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlertActionCodes();
	
	/**
	 * Method to create Ops Alert for booking
	 *
	 * @param OpsAlert opsAlert
	 * @return OpsAlertResponse
	 *
	 * @see
	 * @since
	 */
	public OpsAlertResponse createOpsAlert(OpsAlert opsAlert);
	
	/**
	 * Method to retrieve OpsAlert based on ID
	 *
	 * @param opsAlert
	 * @return
	 *
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlert(String alertCode);	
}
