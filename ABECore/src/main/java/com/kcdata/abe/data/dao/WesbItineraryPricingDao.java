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

import java.util.Map;

import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
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
public interface WesbItineraryPricingDao extends ABEDao {
	
	/**
	 * Method to price the given itinerary
	 *
	 * @param itinerary
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ItineraryPricingResponse hotelPriceItinerary(Itinerary itinerary,boolean isHBSi,Map<String,HBSiHotelInfo> hbsiHotelList);
	public ItineraryPricingResponse packagePriceItinerary(Itinerary itinerary);
}
