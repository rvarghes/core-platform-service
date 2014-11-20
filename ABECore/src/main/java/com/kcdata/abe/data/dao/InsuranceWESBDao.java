/*
 * InsuranceDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Map;

import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Insurance DAO interface for WESB
 *
 * @author sainath
 * @version
 *
 *
 * @see
 * @since
 */

public interface InsuranceWESBDao extends ABEDao {
	
	
	/**
	 * Method to get the available insurance options
	 *
	 * @param itinerary
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public InsuranceResponse retrieveWESBInsurance(Itinerary itinerary,boolean isHbsi,Map<String,HBSiHotelInfo> hbsiHotelList);
}
