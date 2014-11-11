/*
 * AmenitiesService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AmenitiesResponse;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Retrieve amenities interface class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface AmenitiesService extends ABEService {

	/**
	 * Method to retrieve amenities
	 * 
	 * @return AmenitiesResponse
	 * 
	 * @see
	 * @since
	 */
	public AmenitiesResponse retrieveAmenities();
	
}
