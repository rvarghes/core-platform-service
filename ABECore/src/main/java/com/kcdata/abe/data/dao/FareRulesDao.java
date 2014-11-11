/*
 * FareRulesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.FareRulesResponse;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for fare rules retrieval
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public interface FareRulesDao extends ABEDao {

	/**
	 * Method to retrieve the fare rules
	 * 
	 * @return FareRulesResponse
	 * 
	 * @see
	 * @since
	 */
	public FareRulesResponse retrieveFareRules(TripFlight tripFlight,
			boolean fetchAdditionalRules);
}