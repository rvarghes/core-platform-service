/*
 * OpsAlertDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 8, 2009  dmahanth
 * Nov 3, 2009	hguntupa	  Refactored and Added new method to retrieve OpsAlert
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Create Ops Alert DAO interface
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface OpsAlertDao extends ABEDao {

	/**
	 * Method to create Ops Alert for the booking
	 * 
	 * @param
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
