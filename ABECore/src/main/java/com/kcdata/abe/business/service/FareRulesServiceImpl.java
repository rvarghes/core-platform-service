/*
 * FareRulesServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 * Apr 25, 2011  nvittal	  Added method definition for retrieving hotel rate rules
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.FareRulesResponse;
import com.kcdata.abe.business.response.HotelRateRulesResponse;
import com.kcdata.abe.data.dao.FareRulesDao;
import com.kcdata.abe.data.dao.HotelRateRulesDao;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving fare rules
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class FareRulesServiceImpl extends ABEServiceBase implements
		FareRulesService {

	/**
	 * DAO class for retrieving fare rules
	 */
	private FareRulesDao fareRulesDao;

	/**
	 * DAO class for retrieving hotel rate rules
	 */
	private HotelRateRulesDao hotelRateRulesDao;
	
	/**
	 * @return the fareRulesDao
	 */
	public FareRulesDao getFareRulesDao() {
		return fareRulesDao;
	}

	/**
	 * @param fareRulesDao
	 *            the fareRulesDao to set
	 */
	public void setFareRulesDao(FareRulesDao fareRulesDao) {
		this.fareRulesDao = fareRulesDao;
	}

	/**
	 * @return the hotelRateRulesDao
	 */
	public HotelRateRulesDao getHotelRateRulesDao() {
		return hotelRateRulesDao;
	}

	/**
	 * @param hotelRateRulesDao the hotelRateRulesDao to set
	 */
	public void setHotelRateRulesDao(HotelRateRulesDao hotelRateRulesDao) {
		this.hotelRateRulesDao = hotelRateRulesDao;
	}

	/**
	 * Method to retrieve fare rules
	 *
	 * @param tripFlight
	 * @param fetchAdditionalRules
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public FareRulesResponse retrieveFareRules(TripFlight tripFlight,
			boolean fetchAdditionalRules) {
		return this.fareRulesDao.retrieveFareRules(tripFlight,
				fetchAdditionalRules);
	}

	/**
	 * Method to retrieve hotel rate rules
	 *
	 * @param hotel
	 * @return fareRulesResponse
	 *
	 * @see
	 * @since
	 */
	public HotelRateRulesResponse retrieveHotelRateRules(Hotel hotel) {
		return this.hotelRateRulesDao.retrieveRateRules(hotel);
	}
}