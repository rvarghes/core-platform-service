/*
 * TestRetrieveSpecialPackagesCommandHandler.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 17, 2011  chazari
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

import com.kcdata.abe.application.command.RetrievePackagesCommand;
import com.kcdata.abe.application.command.handler.RetrievePackagesCommandHandler;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.SpecialOptions;
import com.kcdata.abe.data.dto.SpecialRequestType;
import com.kcdata.abe.data.dto.SpecialType;
import com.kcdata.abe.data.dto.UserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveSpecialPackagesCommandHandler {
	
	@Autowired
	private RetrievePackagesCommandHandler retrievePackagesCommandHandler;
	
	/**
	 * Test to Retrieve Special Packages (and hotel only specials)
	 * Test criteria currently is set for Charter specials. 
	 * In order to get charter specials use
	 * SpecialType.CHARTERSPECIALS
	 * To get hotel only specials use
	 * SpecialType.HOTELONLYSPECIALS
	 * 
	 * @see TestRetrieveSpecialsCommandHandler
	 */
	@Test
	public void testRetrieveSpecialPackages() {
		
		RetrievePackagesCommand packagesCommand = new RetrievePackagesCommand();
		
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(2011, 00, 28);
		searchCriteria.setDepartureDate(c.getTime());	
		
		Occupancy occpancy = new Occupancy();
		occpancy.setNoOfAdults((byte)2);
		
		List<Passenger> pList = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);
		pList.add(passenger);
		
		occpancy.setPassengers(pList);
		searchCriteria.setOccupancy(occpancy);
		
		DestinationOptions dOptions = new DestinationOptions();
		dOptions.setDestination("PUJ");
		dOptions.setNoOfNights((byte)3);
		dOptions.setAirRequested(true); 
		dOptions.setHotelRequested(true);
		dOptions.setFlexiDateIndicator(false);
		
		HotelOptions hotelOptions = new HotelOptions();
		hotelOptions.setNoOfRooms(1);
		hotelOptions.setHotelName("Sirenis Resort Punta Cana Casino & Spa");
		dOptions.setHotelOptions(hotelOptions);
		
		SpecialOptions specialOptions = new SpecialOptions();
		specialOptions.setSpecialBatchId("01281103C1");
		specialOptions.setSpecialType(SpecialType.CHARTERSPECIALS);
		dOptions.setSpecialOptions(specialOptions);
		
		List<DestinationOptions> dOptionsList = new ArrayList<DestinationOptions>();
		dOptionsList.add(dOptions);
		searchCriteria.setDestinationOptions(dOptionsList);
		packagesCommand.setSearchCriteria(searchCriteria);		
		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("10000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		packagesCommand.setIMApplicationInfo(applicationInfo);
		packagesCommand.setSubCommand(RetrievePackagesCommand.SPECIAL_PACKAGE_AVAILABILITY);

		packagesCommand = (RetrievePackagesCommand) retrievePackagesCommandHandler
				.handle(packagesCommand);
		assertNotNull(packagesCommand.getAvailablePackage());
		
	}
}
