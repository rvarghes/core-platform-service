/*
 * FlightInfoDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Dao interface to retrieve the flight information by specifying the criteria
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface FlightInfoDao extends ABEDao {
	
	/**
	 * Method to retrieve the flight information based on search criteria
	 *
	 * @param criteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public FlightInfoResponse retrieveFlightInfo(FlightInfoCriteria criteria);
}
