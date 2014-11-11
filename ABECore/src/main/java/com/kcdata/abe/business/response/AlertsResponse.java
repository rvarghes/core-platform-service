/*
 * AlertsResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Alerts response class
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */
public class AlertsResponse extends ABEResponse  {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8504012735624086237L;
	
	/**
	 * @return the alertList
	 */
	public List<Alert> getAlertList() {
		return alertList;
	}

	/**
	 * @param alertList the alertList to set
	 */
	public void setAlertList(List<Alert> alertList) {
		this.alertList = alertList;
	}

	
	/**
	 * Holds alert list
	 */
	private List<Alert> alertList;

}
