/*
 * TestRetrieveFlightsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dao.FlightsDao;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.context.ABEApplicationContext;

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
public class TestSkedFlightsSAPDao {

	@Autowired
	private FlightsDao skedFlightsDao;

	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveRoundTripFlights() {
		FlightsRequest request = new FlightsRequest();
		request.setGateway("PHL");
		request.setDestination("CUN");
		Calendar c = Calendar.getInstance();
		c.set(2009, 8, 1);
		request.setDepartureDate(c.getTime());
		request.setNoOfNights((byte)7);
		request.setFlexiDateIndicator(true);
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
//		occpancy.setNoOfChilds(2);
//		occpancy.setNoOfInfants(2);
//		List<Passenger> pList = new ArrayList<Passenger>();
//		Passenger passenger = new Passenger();
//		passenger.setAgeCode(AgeCode.INFANT);
//		passenger.setLapChild(true);
//		pList.add(passenger);
//		occpancy.setPassengers(pList);
		request.setOccupancy(occpancy);
		request.setShowAll(false);
		request.setTripType(FlightTripType.ROUNDTRIP);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.skedFlightsDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.skedFlightsDao
					.getApplicationContextFactory().create();
		}
		this.skedFlightsDao.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.setIMApplicationInfo(applicationInfo);
		FlightsResponse response = this.skedFlightsDao.retrieveFlights(request);
		assertNotNull(response);
		assertNotNull(response.getFlightList());
	}

	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveOneWayFlights() {
		FlightsRequest request = new FlightsRequest();
		request.setGateway("PHL");
		request.setDestination("OGG");
		Calendar c = Calendar.getInstance();
		c.set(2009, 8, 1);
		request.setDepartureDate(c.getTime());
		request.setNoOfNights((byte)7);
		request.setFlexiDateIndicator(true);
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
//		occpancy.setNoOfChilds(2);
//		occpancy.setNoOfInfants(2);
//		List<Passenger> pList = new ArrayList<Passenger>();
//		Passenger passenger = new Passenger();
//		passenger.setAgeCode(AgeCode.INFANT);
//		passenger.setLapChild(true);
//		pList.add(passenger);
//		occpancy.setPassengers(pList);
		request.setOccupancy(occpancy);
		request.setShowAll(false);
		request.setTripType(FlightTripType.ONEWAY);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.skedFlightsDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.skedFlightsDao
					.getApplicationContextFactory().create();
		}
		this.skedFlightsDao.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.setIMApplicationInfo(applicationInfo);
		FlightsResponse response = this.skedFlightsDao.retrieveFlights(request);
		assertNotNull(response);		
		assertNotNull(response.getFlightList());
	}

	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveAnchorFlightsAvailability() {
		FlightsRequest request = new FlightsRequest();
		request.setGateway("PHL");
		request.setDestination("OGG");
		request.setAnchorGateway("HNL");
		Calendar c = Calendar.getInstance();
		c.set(2009, 8, 1);
		request.setDepartureDate(c.getTime());
		request.setNoOfNights((byte)7);
		request.setFlexiDateIndicator(true);
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
//		occpancy.setNoOfChilds(2);
//		occpancy.setNoOfInfants(2);
//		List<Passenger> pList = new ArrayList<Passenger>();
//		Passenger passenger = new Passenger();
//		passenger.setAgeCode(AgeCode.INFANT);
//		passenger.setLapChild(true);
//		pList.add(passenger);
//		occpancy.setPassengers(pList);
		request.setOccupancy(occpancy);
		request.setShowAll(false);
		request.setTripType(FlightTripType.ANCHOR);
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.skedFlightsDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.skedFlightsDao
					.getApplicationContextFactory().create();
		}
		this.skedFlightsDao.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.setIMApplicationInfo(applicationInfo);
		FlightsResponse response = this.skedFlightsDao.retrieveFlights(request);
		assertNotNull(response);		
		assertNotNull(response.getFlightList());
	}	
}
