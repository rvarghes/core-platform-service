/*
 * AlertType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 6, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;
/**
 * Transfer object to hold alert type information
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */
public class AlertType implements ABEDto{

	/**
	 * Default Serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8274286781558752295L;
	
	private String alertCode;
	private String actionCode;
	private String description;
	
	/**
	 * @return the alertCode
	 */
	public String getAlertCode() {
		return alertCode;
	}
	/**
	 * @param alertCode the alertCode to set
	 */
	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}
	
	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}
	/**
	 * @param actionCode the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
