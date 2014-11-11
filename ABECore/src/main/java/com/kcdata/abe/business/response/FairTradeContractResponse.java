/*
 * FairTradeContractResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.FairTradeContract;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response object for fair trade contract
 * 
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class FairTradeContractResponse extends ABEResponse {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6012472687026975012L;

	/**
	 * @return the fairTradeContract
	 */
	public FairTradeContract getFairTradeContract() {
		return fairTradeContract;
	}

	/**
	 * @param fairTradeContract the fairTradeContract to set
	 */
	public void setFairTradeContract(FairTradeContract fairTradeContract) {
		this.fairTradeContract = fairTradeContract;
	}

	private FairTradeContract fairTradeContract;
}