/*
 * OpsAlertActionCodesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.framework.dao.ABEDao;
/**
 * Ops Alert Action Codes DAO interface
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */
public interface OpsAlertActionCodesDao extends ABEDao{
	
	/**
	 * Method to get the Ops Alert and Action Codes
	 *
	 * @param 
	 * @return OpsAlertResponse
	 *
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlertActionCodes();

}
