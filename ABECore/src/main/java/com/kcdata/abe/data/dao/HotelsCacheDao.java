/*
 * HotelsCacheDao.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 13, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.HotelsResponse;

public interface HotelsCacheDao {

	/**
	 * Method queries SCEWeb for a list of hotels and filter to a hotel 
	 * matching a hotel name that's passed through hotel request
	 * @param hotelsRequest
	 * @return hotelsResponse
	 */
	public abstract HotelsResponse retrieveHotels(HotelsRequest hotelsRequest);

}