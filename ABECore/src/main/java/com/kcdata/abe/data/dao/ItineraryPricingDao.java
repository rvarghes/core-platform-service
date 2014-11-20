/*
 * ItineraryPricingDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.request.PricingRequest;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Itinerary Pricing DAO interface
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ItineraryPricingDao extends ABEDao {
	
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
	
	/**
	 * Method to price the given thread of a PricingRequest
	 * 
	 * @param pricingRequest
	 * @return
	 */
	
	public ItineraryPricingResponse priceItinerayThread(PricingRequest pricingRequest);

}
