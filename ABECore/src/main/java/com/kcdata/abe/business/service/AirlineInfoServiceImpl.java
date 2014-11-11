/*
 * AirlineInfoServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AirlineInfoResponse;
import com.kcdata.abe.data.dao.AirlineInfoDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving airline information
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class AirlineInfoServiceImpl extends ABEServiceBase implements
AirlineInfoService {

	/**
	 * DAO class for retrieving airline information
	 */
	private AirlineInfoDao airlineInfoDao;

	/**
	 * @return the airlineInfoDao
	 */
	public AirlineInfoDao getAirlineInfoDao() {
		return airlineInfoDao;
	}

	/**
	 * @param airlineInfoDao
	 *            the airlineInfoDao to set
	 */
	public void setAirlineInfoDao(AirlineInfoDao airlineInfoDao) {
		this.airlineInfoDao = airlineInfoDao;
	}

	
	public AirlineInfoResponse retrieveAirlineInfo(String airlineCode) {
		return this.airlineInfoDao.retrieveAirlineInfo(airlineCode);
	}
	
	
}
