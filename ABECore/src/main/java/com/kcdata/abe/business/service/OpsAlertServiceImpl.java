/*
 * OpsAlertServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 * Nov 3, 2009	hguntupa	  Refactored and Added new method to retrieve OpsAlert
 *****************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.data.dao.OpsAlertDao;
import com.kcdata.abe.data.dao.OpsAlertActionCodesDao;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class OpsAlertServiceImpl extends ABEServiceBase implements
		OpsAlertService {

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for retrieving Ops Alert Action Codes
	 */
	private OpsAlertActionCodesDao opsAlertActionCodesDao;
	/**
	 * DAO class for creating Ops Alert for booking
	 */
	private OpsAlertDao opsAlertDao;

	/**
	 * @return the opsAlertActionCodesDao
	 */
	public OpsAlertActionCodesDao getOpsAlertActionCodesDao() {
		return opsAlertActionCodesDao;
	}

	/**
	 * @param opsAlertActionCodesDao
	 *            the opsAlertActionCodesDao to set
	 */
	public void setOpsAlertActionCodesDao(
			OpsAlertActionCodesDao opsAlertActionCodesDao) {
		this.opsAlertActionCodesDao = opsAlertActionCodesDao;
	}

	/**
	 * @return the opsAlertDao
	 */
	public OpsAlertDao getCreateOpsAlertDao() {
		return opsAlertDao;
	}

	/**
	 * @param opsAlertDao
	 *            the opsAlertDao to set
	 */
	public void setCreateOpsAlertDao(OpsAlertDao opsAlertDao) {
		this.opsAlertDao = opsAlertDao;
	}

	/**
	 * Method for retrieving Ops Alert and Action Codes
	 * 
	 * @param None
	 * @return OpsAlertResponse
	 * 
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlertActionCodes() {
		return this.opsAlertActionCodesDao.retrieveOpsAlertActionCodes();
	}

	/**
	 * Method for creating Ops Alert for the booking
	 * 
	 * @param OpsAlert
	 *            opsAlert
	 * @return OpsAlertResponse
	 * 
	 * @see
	 * @since
	 */
	public OpsAlertResponse createOpsAlert(OpsAlert opsAlert) {
		return this.opsAlertDao.createOpsAlert(opsAlert);
	}
	
	/**
	 * Method to retrieve OpsAlert based on ID
	 *
	 * @param opsAlert
	 * @return
	 *
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlert(String alertCode) {
		return this.opsAlertDao.retrieveOpsAlert(alertCode);
	}

}
