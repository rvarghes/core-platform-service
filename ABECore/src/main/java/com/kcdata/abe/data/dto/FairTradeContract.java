/*
 * FairTradeContract.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for storing terms and conditions text
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class FairTradeContract implements ABEDto {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3293686759205007020L;

	/**
	 * @return the termsAndConditions
	 */
	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	/**
	 * @param termsAndConditions the termsAndConditions to set
	 */
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	private String termsAndConditions;
}