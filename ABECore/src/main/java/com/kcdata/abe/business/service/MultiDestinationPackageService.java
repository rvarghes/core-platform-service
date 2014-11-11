/*
 * MultiDestinationPackageService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.MultiDestinationPackageResponse;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service class for multi-destination packages
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface MultiDestinationPackageService extends ABEService {

	/**
	 * Method to retrieve the packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for multi-destination packages
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse retrievePackages(SearchCriteria searchCriteria);

	/**
	 * Method to retrieve the flights for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeFlights(MultiDestinationPackage multiDestPackage);

	/**
	 * Method to retrieve the hotels for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeHotels(MultiDestinationPackage availablePackage);

	/**
	 * Method to retrieve the vehicles for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param multiDestPackage
	 *            - package to be changed
	 * @return MultiDestinationPackageResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public MultiDestinationPackageResponse changeVehicles(MultiDestinationPackage availablePackage);
}
