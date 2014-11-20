/*
 * AgencyResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for agency response
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class AgencyResponse extends ABEResponse {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8555024700861226599L;

	/**
	 * @return the agency
	 */
	public Agency getAgency() {
		return agency;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	private Agency agency;
}