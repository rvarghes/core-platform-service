/*
 * FareRulesResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.FareRule;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for fare rules response
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FareRulesResponse extends ABEResponse {
	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 567191323350547119L;

	/**
	 * @return the fareRules
	 */
	public List<FareRule> getFareRules() {
		return fareRules;
	}

	/**
	 * @param fareRules
	 *            the fareRules to set
	 */
	public void setFareRules(List<FareRule> fareRules) {
		this.fareRules = fareRules;
	}

	/**
	 * Field to hold list of fare rules
	 */
	private List<FareRule> fareRules;
}