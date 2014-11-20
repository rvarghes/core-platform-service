/*
 * TestRetrievePackagesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 25, 2009  hguntupa
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

import com.kcdata.abe.application.command.RetrievePackagesCommand;
import com.kcdata.abe.application.command.handler.RetrievePackagesCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link RetrievePackagesCommandHandler}
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
public class TestRetrievePackagesCommandHandler {

	@Autowired
	private RetrievePackagesCommandHandler retrievePackagesCommandHandler;

	/**
	 * Method to test the RetrievePackagesCommandHandler class
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrievePackages() {
		RetrievePackagesCommand packagesCommand = new RetrievePackagesCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		packagesCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("ORD");
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 11, 12);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("KOA");
		destnOption.setNoOfNights((byte) 7);

		// Set Package falgs
		destnOption.setAirRequested(false);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);
		
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
		
		packagesCommand.setSearchCriteria(searchCriteria);

		packagesCommand = (RetrievePackagesCommand) retrievePackagesCommandHandler
				.handle(packagesCommand);
		assertNotNull(packagesCommand.getAvailablePackage());
	}
}
