/*
 * TestRetrievePackagesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
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

import com.kcdata.abe.application.command.RetrieveMultiDestPackageCommand;
import com.kcdata.abe.application.command.handler.RetrieveMultiDestPackageCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link RetrieveMultiDestPackageCommandHandler}
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
public class TestRetrieveMultiDestPackageCommandHandler {

	@Autowired
	private RetrieveMultiDestPackageCommandHandler retrieveMultiDestPackageCommandHandler;

	/**
	 * Method to test the RetrievePackagesCommandHandler class
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrievePackages() {
		RetrieveMultiDestPackageCommand multiDestPkgCommand = new RetrieveMultiDestPackageCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		multiDestPkgCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("ORD");
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 12);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		// Destination 1 details
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("KOA");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);

		// Destination 1 details
		destnOption = new DestinationOptions();
		destnOption.setDestinationId(2);
		destnOption.setDestination("HNL");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		hotelOptions = new HotelOptions();
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

		multiDestPkgCommand.setSearchCriteria(searchCriteria);

		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage());
	}

	/**
	 * Method to test the RetrievePackagesCommandHandler class
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void changeFlights() {
		RetrieveMultiDestPackageCommand multiDestPkgCommand = new RetrieveMultiDestPackageCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		multiDestPkgCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("ORD");
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 12);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		// Destination 1 details
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("KOA");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);

		// Destination 1 details
		destnOption = new DestinationOptions();
		destnOption.setDestinationId(2);
		destnOption.setDestination("HNL");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		hotelOptions = new HotelOptions();
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

		multiDestPkgCommand.setSearchCriteria(searchCriteria);

		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage());

		// Set the change command
		multiDestPkgCommand.getMultiDestinationPackage().setChangePosition(
				(byte) 0);
		multiDestPkgCommand.setSubCommand(RetrieveMultiDestPackageCommand.CHANGE_FLIGHT);
		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage().getFlightOptions());
	}
	/**
	 * Method to test the RetrievePackagesCommandHandler class
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void changeHotels() {
		RetrieveMultiDestPackageCommand multiDestPkgCommand = new RetrieveMultiDestPackageCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		multiDestPkgCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("ORD");
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 12);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		// Destination 1 details
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("KOA");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);

		// Destination 1 details
		destnOption = new DestinationOptions();
		destnOption.setDestinationId(2);
		destnOption.setDestination("HNL");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		hotelOptions = new HotelOptions();
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

		multiDestPkgCommand.setSearchCriteria(searchCriteria);

		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage());

		// Set the change command
		multiDestPkgCommand.getMultiDestinationPackage().setChangePosition(
				(byte) 0);
		multiDestPkgCommand.setSubCommand(RetrieveMultiDestPackageCommand.CHANGE_HOTEL);
		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage().getHotelOptions());
	}

	/**
	 * Method to test the RetrievePackagesCommandHandler class
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void changeVehicles() {
		RetrieveMultiDestPackageCommand multiDestPkgCommand = new RetrieveMultiDestPackageCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		multiDestPkgCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("ORD");
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 12);
		searchCriteria.setDepartureDate(cal.getTime());

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		// Destination 1 details
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setDestination("KOA");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		HotelOptions hotelOptions = new HotelOptions();
		// 1 room
		hotelOptions.setNoOfRooms(1);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);

		// Destination 1 details
		destnOption = new DestinationOptions();
		destnOption.setDestinationId(2);
		destnOption.setDestination("HNL");
		destnOption.setNoOfNights((byte) 7);
		// Set Package falgs
		destnOption.setAirRequested(true);
		destnOption.setHotelRequested(true);
		destnOption.setVehicleRequested(true);

		hotelOptions = new HotelOptions();
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

		multiDestPkgCommand.setSearchCriteria(searchCriteria);

		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage());

		// Set the change command
		multiDestPkgCommand.getMultiDestinationPackage().setChangePosition(
				(byte) 0);
		multiDestPkgCommand.setSubCommand(RetrieveMultiDestPackageCommand.CHANGE_VEHICLE);
		multiDestPkgCommand = (RetrieveMultiDestPackageCommand) retrieveMultiDestPackageCommandHandler
				.handle(multiDestPkgCommand);
		assertNotNull(multiDestPkgCommand.getMultiDestinationPackage().getVehicleOptions());
	}
}
