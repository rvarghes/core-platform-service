/*
 * AirlineInfoDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */
package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.AirlineInfoResponse;
import com.kcdata.abe.framework.dao.ABEDao;
/**
 * DAO Interface for Airline Information retrieval
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface AirlineInfoDao extends ABEDao {

	/**
	 * Method to retrieve the airline information
	 * 
	 * @return AirlineInfoResponse
	 * 
	 * @see
	 * @since
	 */
	public AirlineInfoResponse retrieveAirlineInfo(String airlineCode);

	
	
}
