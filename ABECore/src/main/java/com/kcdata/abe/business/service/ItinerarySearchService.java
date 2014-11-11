/*
 * ItinerarySearchService.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 29, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.data.dto.ItinerarySearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * 
 * Service to handle search of itineraries for a criteria and search
 * specific itinerary for the number passed
 *
 * @author vgandrap
 * @version
 *
 *
 * @see
 * @since
 */
public interface ItinerarySearchService extends ABEService {
	
	
	/**
	 * 
	 * Returns the search result (list) of itineraries for the specific criteria
	 *
	 * @param itinerarySearchCriteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ItinerarySearchResponse search(ItinerarySearchCriteria itinerarySearchCriteria);
	
	/**
	 * 
	 * Retrieve details of this itinerary no.
	 *
	 * @param quoteNo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ItinerarySearchResponse retrieveItinerary(String quoteNo);
}
