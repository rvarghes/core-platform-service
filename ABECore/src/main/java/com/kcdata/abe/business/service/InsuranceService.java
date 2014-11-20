/*
 * InsuranceService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.service.ABEService;

public interface InsuranceService extends ABEService{

	
	/**
	 * Method for retrieving insurance options
	 * 
	 * @param itinerary
	 * @return InsuranceResponse
	 * 
	 * @see
	 * @since
	 */
	public InsuranceResponse retrieveInsurance(Itinerary itinerary);
			
}
