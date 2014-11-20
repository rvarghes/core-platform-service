/*
 * FlightsService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface for retrieving flights Retrieve Flights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface FlightsService extends ABEService {

	/**
	 * Method to retrieve flights
	 * 
	 * @param searchCriteria
	 *            - Search criteria
	 * @return Flights
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveFlights(SearchCriteria searchCriteria);
	
	/**
	 * Method to retrieve the flights information
	 *
	 * @param flightInfoCriteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public FlightInfoResponse retrieveFlightInfo(FlightInfoCriteria flightInfoCriteria);
	
	/**
	 * Method to retrieve the charter flights availibility dates
	 *
	 * @param flightInfoCriteria
	 * @return
	 *
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveCharterOperatingDates(SearchCriteria searchCriteria); 
}