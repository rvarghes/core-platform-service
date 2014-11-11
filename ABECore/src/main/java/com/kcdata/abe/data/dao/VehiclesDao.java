/*
 * VehiclesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Interface for Vehicle DAO
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface VehiclesDao extends ABEDao {

	
	/**
	 * Method to retrieve vehicles
	 *
	 * @param vehiclesRequest
	 * @return
	 *
	 * @see
	 * @since
	 */
	VehiclesResponse retrieveVehicles(VehiclesRequest vehiclesRequest);
	
	/**
	 * Method to retrieve vehicles for Packages
	 * 
	 * @param vehiclesRequest Vehicles Request
	 * @return Vehicles response
	 * 
	 * @see
	 * @since
	 */
	VehiclesResponse retrieveVehiclesForPackages(VehiclesRequest vehiclesRequest);	
}