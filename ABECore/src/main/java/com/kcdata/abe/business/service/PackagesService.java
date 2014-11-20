/*
 * PackagesService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface for package services
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface PackagesService extends ABEService {

	/**
	 * Method to retrieve the packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	
	public PackagesResponse retrievePackages(SearchCriteria searchCriteria);

	/**
	 * Method to retrieves special packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	
	public PackagesResponse retrieveSpecialPackages(SearchCriteria searchCriteria);
	
	/**
	 * Method to retrieve the flights for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param availablePackage
	 *            - package to be changed
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeFlights(SearchCriteria searchCriteria,
			Package availablePackage);

	/**
	 * Method to retrieve the hotels for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param availablePackage
	 *            - package to be changed
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeHotels(SearchCriteria searchCriteria,
			Package availablePackage);

	/**
	 * Method to retrieve the vehicles for packages
	 * 
	 * @param searchCriteria
	 *            - searchCriteria for packages
	 * @param availablePackage
	 *            - package to be changed
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeVehicles(SearchCriteria searchCriteria,
			Package availablePackage);

	/**
	 * Method to retrieve the price break up of given Package
	 *
	 * @param hotel
	 * @return
	 *
	 * @see
	 * @since
	 */
	AllPriceBreakUpResponse retrievePriceBreakUp(Package availablePackage);	
}
