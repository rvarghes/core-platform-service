/*
 * ItineraryDao.java
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

import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Itinerary Booking DAO interface
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ItineraryWESBDao extends ABEDao {


	/**
	 * 
	 * Method to save changes in given itinerary
	 * 
	 * @param itinerary,isHbsi
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveWESBItineraryChanges(Itinerary itinerary,boolean isHbsi,Map<String,HBSiHotelInfo> hbsiHotelList);
	public ItineraryResponse saveWESBPackageItineraryChanges(Itinerary itinerary,List<Hotel> hbsiHotelList,String bookingNumberSAP);
	public ItineraryResponse saveWESBItinerary(Itinerary itinerary);
}
