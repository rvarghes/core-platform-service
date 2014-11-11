/*
 * AlertsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;

import com.kcdata.abe.business.response.AlertsResponse;
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for Alerts and Advisory retrieval
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface AlertsDao extends ABEDao {

	/**
	 * Method to retrieve the Alerts and Advisory
	 * 
	 * @return AlertsResponse
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlertsOrAdvisory(
			ArrayList<AlertCriteria> alertCriteriaList, boolean advisory);

	/**
	 * Method to retrieve the Alerts and Advisory
	 * 
	 * @return AlertsResponse
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlerts(String bookingNumber);

}
