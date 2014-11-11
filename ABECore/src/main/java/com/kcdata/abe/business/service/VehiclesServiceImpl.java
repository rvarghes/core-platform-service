/*
 * VehiclesServiceImpl.java
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

import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.dao.VehiclesDao;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for vehicle availability search
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class VehiclesServiceImpl extends ABEServiceBase implements
		VehiclesService {

	private VehiclesDao vehiclesDao;

	/**
	 * @return the vehiclesDao
	 */
	public VehiclesDao getVehiclesDao() {
		return vehiclesDao;
	}

	/**
	 * @param vehiclesDao
	 *            the vehiclesDao to set
	 */
	public void setVehiclesDao(VehiclesDao vehiclesDao) {
		this.vehiclesDao = vehiclesDao;
	}

	/**
	 * Method for retrieving vehicle availability
	 * 
	 * @param searchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public VehiclesResponse retrieveVehicles(SearchCriteria searchCriteria) {
		// Prepare vehicle request
		VehiclesRequest vehiclesRequest = searchCriteria.getVehiclesRequest();

		return this.vehiclesDao.retrieveVehicles(vehiclesRequest);
	}

}