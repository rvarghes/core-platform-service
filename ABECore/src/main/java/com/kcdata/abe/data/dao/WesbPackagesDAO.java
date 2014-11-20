/*
 * PackagesDAO.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Map;

import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Interface for packages dao Retrieve Packages usecase
 * 
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface WesbPackagesDAO extends ABEDao {

	/**
	 * Method to retrieve the packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse wesbRetrievePackages(PackagesRequest request,Map<String,HBSiHotelInfo> hbsiHotelList);

	/**
	 * Method to retrieve the flights for packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeFlights(PackagesRequest request);

	/**
	 * Method to retrieve the hotels for packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse wesbChangeHotels(PackagesRequest request);

	/**
	 * Method to retrieve the vehicles for packages
	 * 
	 * @param request
	 *            - request for packages
	 * @return PackagesResponse object with packages
	 * 
	 * @see
	 * @since
	 */
	public PackagesResponse changeVehicles(PackagesRequest request);

	/**
	 * Method to retrieve the price break up of given package
	 * 
	 * @param hotel
	 * @return
	 * 
	 * @see
	 * @since
	 */
	AllPriceBreakUpResponse retrievePriceBreakUp(
			com.kcdata.abe.data.dto.Package availablePackage);

}
