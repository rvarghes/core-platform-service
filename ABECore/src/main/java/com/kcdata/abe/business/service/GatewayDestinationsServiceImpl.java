/*
 * GatewayDestinationsServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.data.dao.GatewayDestinationsDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving gateway destinations
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class GatewayDestinationsServiceImpl extends ABEServiceBase implements
		GatewayDestinationsService {

	/**
	 * DAO class for retrieving gateway destinations
	 */
	private GatewayDestinationsDao gatewayDestinationsDao;

	/**
	 * @return the gatewayDestinationsDao
	 */
	public GatewayDestinationsDao getGatewayDestinationsDao() {
		return gatewayDestinationsDao;
	}

	/**
	 * @param gatewayDestinationsDao
	 *            the gatewayDestinationsDao to set
	 */
	public void setGatewayDestinationsDao(
			GatewayDestinationsDao gatewayDestinationsDao) {
		this.gatewayDestinationsDao = gatewayDestinationsDao;
	}

	/**
	 * Method to retrieve gateway destinations
	 * 
	 * @param searchCriteria
	 *            - Search criteria
	 * @return GatewayDestinations
	 * 
	 * @see
	 * @since
	 */
	
	public GatewayDestinationsResponse retrieveGatewayDestinations() {
		return this.gatewayDestinationsDao.retrieveGatewayDestinations();
	}

}
