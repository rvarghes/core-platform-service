/*
 * HotelAvailTest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 30, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
 * Class to unit test hotel availability
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelAvailTest {

	/**
	 * Main method to test hotel availability
	 * 
	 * @param args
	 * 
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		RetrieveHotelsCommand command = new RetrieveHotelsCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		command.setIMApplicationInfo(applicationInfo);

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
		destnOption.setNoOfNights((byte)7);

		HotelOptions hotelOptions = new HotelOptions();
		// 2 rooms
		hotelOptions.setNoOfRooms(2);
		destnOption.setHotelOptions(hotelOptions);
		destnOptions.add(destnOption);
		searchCriteria.setDestinationOptions(destnOptions);

		// 2 rooms - 1 room with 2 adults, 2nd room with 1 adult and 1 child
		Occupancy occupancy = new Occupancy();
		occupancy.setNoOfAdults((byte)3);
		occupancy.setNoOfChilds((byte)1);

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		// First room with 2 adults
		passenger.setRoomNumber((byte) 1);
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);
		passengers.add(passenger);

		// Second room with 1 adult & 1 child
		passenger = new Passenger();
		passenger.setRoomNumber((byte) 2);
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 1);
		passengers.add(passenger);

		passenger = new Passenger();
		passenger.setRoomNumber((byte) 2);
		passenger.setAgeCode(AgeCode.CHILD);
		passenger.setGuestCount((byte) 1);
		passenger.setAge((byte) 6);
		passengers.add(passenger);
		occupancy.setPassengers(passengers);
		searchCriteria.setOccupancy(occupancy);

		command.setSearchCriteria(searchCriteria);
		RetrieveHotelsCommandHandler handler = (RetrieveHotelsCommandHandler) context
				.getBean(command.getCommandHandlerName());
		command = (RetrieveHotelsCommand) handler.handle(command);

		System.out.println(command.getHotels());
		System.out.println(command.getDestinations());
	}
}