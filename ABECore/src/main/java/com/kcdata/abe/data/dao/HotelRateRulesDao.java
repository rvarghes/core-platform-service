/*
 * HotelRateRulesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 25, 2011  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.HotelRateRulesResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for Hotel direct rate rules retrieval
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public interface HotelRateRulesDao extends ABEDao {

	/**
	 * Method to retrieve the fare rules
	 * 
	 * @return HotelRateRulesResponse
	 * 
	 * @see
	 * @since
	 */
	public HotelRateRulesResponse retrieveRateRules(Hotel hotel);
}