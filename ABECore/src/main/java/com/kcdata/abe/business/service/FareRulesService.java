/*
 * FareRulesService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 * Apr 25, 2011  nvittal	  Added method definition for retrieving hotel rate rules
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.FareRulesResponse;
import com.kcdata.abe.business.response.HotelRateRulesResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service class for Fare Rules
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public interface FareRulesService extends ABEService {
	/**
	 * Method to retrieve fare rules
	 *
	 * @return Fare Rules response
	 *
	 * @see
	 * @since
	 */
	public FareRulesResponse retrieveFareRules(TripFlight tripFlight,
			boolean fetchAdditionalRules);

	/**
	 * Method to retrieve Hotel rate rules
	 *
	 * @return Rate Rules response
	 * 
	 * @see
	 * @since
	 */
	public HotelRateRulesResponse retrieveHotelRateRules(Hotel hotel);
	
}