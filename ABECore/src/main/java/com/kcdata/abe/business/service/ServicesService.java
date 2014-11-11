/*
 * ServicesService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ServiceDetailsResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.framework.service.ABEService;

public interface ServicesService extends ABEService {
	
	/**
	 * Method for retrieving available services
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ServicesResponse retrieveServices(Itinerary itinerary);
	
	/**
	 * Method to retrieve service details
	 *
	 * @param service
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ServiceDetailsResponse retrieveServiceDetails(Service service);	
}
