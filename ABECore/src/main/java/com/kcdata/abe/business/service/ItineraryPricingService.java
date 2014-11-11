/*
 * ItineraryPricingService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface to define pricing service
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ItineraryPricingService extends ABEService {
	
	/**
	 * Method to price the given itinerary
	 *
	 * @param itinerary
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ItineraryPricingResponse priceItinerary(Itinerary itinerary);

}
