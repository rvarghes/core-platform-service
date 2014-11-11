/*
 * ItinerarySearchDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 26, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.data.dto.ItinerarySearchCriteria;
import com.kcdata.abe.framework.dao.ABEDao;

public interface ItinerarySearchDao extends ABEDao {
	
	public ItinerarySearchResponse retrieveItinerary(String quoteNo);
	public ItinerarySearchResponse search(ItinerarySearchCriteria itinerarySearchCriteria);
}
