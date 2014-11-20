/*
 * GatewayDestinationsService.java
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
import com.kcdata.abe.framework.service.ABEService;

/**
 * Retrieve gateway destination interface class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface GatewayDestinationsService extends ABEService {
	/**
	 * Method to retrieve gateway destinations
	 * 
	 * @return Gateway Destinations
	 * 
	 * @see
	 * @since
	 */
	public GatewayDestinationsResponse retrieveGatewayDestinations();

}
