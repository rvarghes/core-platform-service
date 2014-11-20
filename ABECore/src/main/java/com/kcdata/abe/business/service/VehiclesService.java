/*
 * VehiclesService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Vehicles service interface
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public interface VehiclesService extends ABEService {

	/**
	 * Method to retrieve vehicle availability
	 *
	 * @param searchCriteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public VehiclesResponse retrieveVehicles(SearchCriteria searchCriteria);
}