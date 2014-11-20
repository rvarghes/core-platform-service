/*
 * ItineraryComparisonEmailDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 27, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.List;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABEDao;

public interface ItineraryComparisonEmailDao extends ABEDao {

	/**
	 * 
	 * Service to send itineraries comparison email
	 * 
	 * @param itineraries
	 * @param imgByteArray
	 * @param emailId
	 * @param fromEmailId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse sendItineraryComparisonEmail(
			List<Itinerary> itineraries, byte[] imgByteArray, String emailId);

}
