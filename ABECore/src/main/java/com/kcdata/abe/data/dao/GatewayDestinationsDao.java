/*
 * GatewayDestinationsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.List;

import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.data.dto.NearbyGateway;


import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for gateway destination retrieval
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface GatewayDestinationsDao extends ABEDao {

	/**
	 * Method to retrieve the Gateway Destinations
	 * 
	 * @return GatewayDestinationsResponse
	 * 
	 * @see
	 * @since
	 */
	public GatewayDestinationsResponse retrieveGatewayDestinations();
	
	/**
	 * Method to check whether charters are offered for the given gateway and destination
	 *
	 * @param gateway
	 * @param destination
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isCharterOfferedGatewayDestination(String gateway, String destination);
	
	
	/**
	 * 
	 * Method will return all near by airport with in given range
	 * 
	 * @param gateway
	 * @param gateWayRange
	 * @return
	 */
	public List<NearbyGateway> getNearByGateways(String gateway,String gateWayRange );
		


}
