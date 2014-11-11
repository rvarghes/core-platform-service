/*
 * AlertsServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 24, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import java.util.ArrayList;

import com.kcdata.abe.business.response.AlertsResponse;
import com.kcdata.abe.data.dao.AlertsDao;
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service class for alerts
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AlertsServiceImpl extends ABEServiceBase implements AlertsService {

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for retrieving alerts
	 */
	private AlertsDao alertsDao;

	/**
	 * @return the alertsDao
	 */
	public AlertsDao getAlertsDao() {
		return alertsDao;
	}

	/**
	 * @param alertsDao
	 *            the alertsDao to set
	 */
	public void setAlertsDao(AlertsDao alertsDao) {
		this.alertsDao = alertsDao;
	}

	/**
	 * Method for retrieving alerts
	 * 
	 * @param alertCriteria
	 * @return alertsResponse
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlertsOrAdvisory(
			ArrayList<AlertCriteria> alertCriteriaList, boolean advisory) {
		return this.alertsDao.retrieveAlertsOrAdvisory(alertCriteriaList,
				advisory);
	}

	/**
	 * Methods to retrieve alerts based on booking number
	 * 
	 * @return alerts response
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlerts(String bookingNumber) {
		return this.alertsDao.retrieveAlerts(bookingNumber);
	}
}
