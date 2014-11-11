/*
 * BreakdownChargesService.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.BreakdownChargesResponse;
import com.kcdata.abe.framework.service.ABEService;

/**
 * @author chazari
 * @version
 * @see
 * @since
 */
public interface BreakdownChargesService extends ABEService {
	
	/**
	 * Method returns price break down for a specified booking
	 * @param bookingNo
	 * @return BreakdownChargesResponse
	 */
	public BreakdownChargesResponse retrievePriceBreakdown(String bookingNo);	
}
