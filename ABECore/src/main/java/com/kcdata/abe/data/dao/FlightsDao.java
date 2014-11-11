/*
 * FlightsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Sep 14, 2009	 hguntupa	  Added methods for flights availability of packages
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Interface for flights dao RetrieveFlights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface FlightsDao extends ABEDao {

	/**
	 * Method to retrieve the charter flights availability dates
	 * 
	 * @param request
	 *            - request for flights
	 * @return FlightsResponse object with flights
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveCharterOperatingDates(FlightsRequest request);
	/**
	 * Method to retrieve the flights
	 * 
	 * @param request
	 *            - request for flights
	 * @return FlightsResponse object with flights
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveFlights(FlightsRequest request);
	
	/**
	 * Method to retrieve flights for package availability
	 *
	 * @param request
	 *            - request for flights
	 * @return FlightsResponse object with flights
	 *
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveFlightsForPackage(FlightsRequest request);
	
	/**
	 * Retrieve available flight offer for alternate duration
	 * 
	 * @param flightsRequest
	 * @return
	 */
	public FlightsResponse retrieveFlightOffer(FlightsRequest flightsRequest);
}