/*
 * TestRetrieveHotelsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveHotelsCommand;
import com.kcdata.abe.application.command.handler.RetrieveHotelsCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class for testing retrieve hotels command handler
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveHotelsCommandHandler {

	@Autowired
	private RetrieveHotelsCommandHandler retrieveHotelsCommandHandler;

	/**
	 * Method to test the RetrieveHotelsCommandHandler class retrieveHotels
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveHotels() {
		RetrieveHotelsCommand hotelsCommand = new RetrieveHotelsCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("0000010000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		hotelsCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 9);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("CUN");
		destnOption.setNoOfNights((byte) 7);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);
		searchCriteria.setDestinationOptions(destnOptions);
		destnOption.setHotelRequested(true);

		// 1 room with 2 adults
		Occupancy occupancy = new Occupancy();
		occupancy.setNoOfAdults((byte)2);

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
	}
}