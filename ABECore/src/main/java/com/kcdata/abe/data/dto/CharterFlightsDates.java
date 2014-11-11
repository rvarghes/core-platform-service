/*
 * Flight.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold flight details Retrieve Flights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class CharterFlightsDates implements ABEDto {

	/**
	 * Serilization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2604570398153275175L;
	private Date charterDate;

	/**
	 * @return the charterDate
	 */
	public Date getCharterDate() {
		return charterDate;
	}

	/**
	 * @param charterDate
	 *            the charterDate to set
	 */
	public void setCharterDate(Date charterDate) {
		this.charterDate = charterDate;
	}
}
