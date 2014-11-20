/*
 * AmenitiesServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 19, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AmenitiesResponse;
import com.kcdata.abe.data.dao.AmenitiesDao;
import com.kcdata.abe.framework.service.ABEServiceBase;


/**
 * Service implementation class for retrieving amenities
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AmenitiesServiceImpl extends ABEServiceBase implements
AmenitiesService {
	
	/**
	 * DAO class for retrieving amenities 
	 */
	private AmenitiesDao amenitiesDao;

	/**
	 * @return the amenitiesDao
	 */
	public AmenitiesDao getAmenitiesDao() {
		return amenitiesDao;
	}

	/**
	 * @param amenitiesDao
	 *            the amenitiesDao to set
	 */
	public void setAmenitiesDao(
			AmenitiesDao amenitiesDao) {
		this.amenitiesDao = amenitiesDao;
	}

	/**
	 * Method to retrieve amenities
	 * 
	 * @param IMApplicationInfo
	 *            - imApplicationInfo
	 * @return AmenitiesResponse
	 * 
	 * @see
	 * @since
	 */
	
	public AmenitiesResponse retrieveAmenities() {
		return this.amenitiesDao.retrieveAmenities();
	}
}
