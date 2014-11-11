/*
 * TestRetrieveServicesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 19, 2009  hguntupa
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

import com.kcdata.abe.application.command.RetrieveHotelsCommand;
import com.kcdata.abe.application.command.RetrieveServicesCommand;
import com.kcdata.abe.application.command.handler.RetrieveHotelsCommandHandler;
import com.kcdata.abe.application.command.handler.RetrieveServicesCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class for testing retrieve services command handler
 * 
 * @author hguntupa
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveServicesCommandHandler {

	@Autowired
	private RetrieveHotelsCommandHandler retrieveHotelsCommandHandler;

	@Autowired
	private RetrieveServicesCommandHandler retrieveServicesCommandHandler;

	/**
	 * Method to test the RetrieveServicesCommandHandler class retrieveServices
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveServices() {
		RetrieveHotelsCommand hotelsCommand = new RetrieveHotelsCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		hotelsCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("CUN");
		destnOption.setNoOfNights((byte) 7);
		destnOption.setHotelRequested(true);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);
		searchCriteria.setDestinationOptions(destnOptions);

		// 1 room with 2 adults
		Occupancy occupancy = new Occupancy();
		occupancy.setNoOfAdults((byte) 2);

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();

		passenger.setRoomNumber((byte) 1);
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);

		passengers.add(passenger);
		occupancy.setPassengers(passengers);

		searchCriteria.setOccupancy(occupancy);

		hotelsCommand.setSearchCriteria(searchCriteria);
		hotelsCommand = (RetrieveHotelsCommand) retrieveHotelsCommandHandler
				.handle(hotelsCommand);
		assertNotNull(hotelsCommand.getHotels());

		Itinerary itinerary = new Itinerary();
		itinerary.setImApplicationInfo(applicationInfo);
		itinerary.setSearchCriteria(searchCriteria);
		List<Hotel> hotelsList = new ArrayList<Hotel>();
		hotelsList.add(hotelsCommand.getHotels().get(0));
		itinerary.setHotels(hotelsList);
		RetrieveServicesCommand servicesCommand = new RetrieveServicesCommand();
		servicesCommand.setIMApplicationInfo(applicationInfo);
		servicesCommand.setItinerary(itinerary);
		servicesCommand = (RetrieveServicesCommand) retrieveServicesCommandHandler
				.handle(servicesCommand);
		assertNotNull(servicesCommand.getServiceGroups());
	}
}