/*
 * AlertsService.java
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
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface for alerts 
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public interface AlertsService extends ABEService{
	
	/**
	 * Method for retrieving alerts
	 * 
	 * @param alertCriteria
	 * @return
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
