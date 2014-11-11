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

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveFlightsCommand;
import com.kcdata.abe.application.command.handler.RetrieveFlightsCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link RetrieveFlightsCommandHandler}
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
public class TestRetrieveFlightsCommandHandler {
	
	@Autowired
	private RetrieveFlightsCommandHandler retrieveFlightsCommandHandler;
	
	/**
	 * Method to test the CharterFlightsCacheDaoImpl class retrieveFlights method
	 *
	 *
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFlight() {
		RetrieveFlightsCommand flightsCommand = new RetrieveFlightsCommand();
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar c = Calendar.getInstance();
		c.set(2011, 5, 12);
		searchCriteria.setDepartureDate(c.getTime());		
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
//		occpancy.setNoOfChilds((byte)2);
//		occpancy.setNoOfInfants((byte)2);
		List<Passenger> pList = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);
		pList.add(passenger);
		occpancy.setPassengers(pList);
		searchCriteria.setOccupancy(occpancy);
		DestinationOptions dOptions = new DestinationOptions();
		dOptions.setDestination("CUN");
		dOptions.setNoOfNights((byte)7);
		dOptions.setCharterOnly(true);
		dOptions.setAirRequested(true);
		dOptions.setFlexiDateIndicator(false);
//		dOptions.setNearbyAirportIndicator(true);
//		List<String> nearByGateways = new ArrayList<String>();
//		nearByGateways.add("BWI");
//		searchCriteria.setNearByGateways(nearByGateways);
		
		List<DestinationOptions> dOptionsList = new ArrayList<DestinationOptions>();
		dOptionsList.add(dOptions);
		searchCriteria.setDestinationOptions(dOptionsList);
		flightsCommand.setSearchCriteria(searchCriteria);		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("0000010000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		flightsCommand.setIMApplicationInfo(applicationInfo);		
		flightsCommand = (RetrieveFlightsCommand) retrieveFlightsCommandHandler.handle(flightsCommand);
		assertNotNull(flightsCommand.getFlights());		
	}
}
