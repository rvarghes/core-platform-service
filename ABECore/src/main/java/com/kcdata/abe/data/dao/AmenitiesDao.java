/*
 * AmenitiesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 ******************************************************************************
 */


package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.AmenitiesResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for amenities codes retrieval
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public interface AmenitiesDao extends ABEDao  {
	
	/**
	 * Method to retrieve the amenity codes and names
	 * 
	 * @return AmenitiesResponse
	 * 
	 * @see
	 * @since
	 */
	public AmenitiesResponse retrieveAmenities();
	

}
