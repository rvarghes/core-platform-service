/*
 * TestRetrieveFlightsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;

/**
 * UNIT test class to test the {@link FlightsDao}
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestCharterFlightsCacheDao {

	@Autowired
	private FlightsDao charterFlightsDao;

	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFlight() {
		FlightsRequest request = new FlightsRequest();
		request.setGateway("PHL");
		request.setDestination("CUN");
		Calendar c = Calendar.getInstance();
		c.set(2010, 0, 16, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		request.setDepartureDate(c.getTime());
		request.setNoOfNights((byte) 7);
		request.setFlexiDateIndicator(false);
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
		List<Passenger> pList = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);
		pList.add(passenger);
		occpancy.setPassengers(pList);
		request.setOccupancy(occpancy);
		request.setShowAll(false);
		FlightsResponse response = this.charterFlightsDao.retrieveFlights(request);
		assertNotNull(response);
	}
}
