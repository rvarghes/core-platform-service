/*
 * TestRetrieveHotelsDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dao.HotelsDao;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Hotel availability DAO
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveHotelsDao {

	@Autowired
	private HotelsDao hotelsDao;

	/**
	 * Method to test the Hotels DAO for retrieving hotels
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveHotels() {
		HotelsRequest hotelsRequest = new HotelsRequest();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);

		hotelsRequest.setDepartureDate(cal.getTime());
		hotelsRequest.setGateway("PHL");
		hotelsRequest.setDestination("CUN");
		hotelsRequest.setNoOfNights((byte) 7);
		hotelsRequest.setHotelRequested(true);
		// 1 room
		HotelOptions hotelOptions = new HotelOptions();
		hotelOptions.setNoOfRooms(1);
		hotelsRequest.setHotelOptions(hotelOptions);

		// 1 room with 2 adults
		Occupancy occupancy = new Occupancy();
		occupancy.setNoOfAdults((byte)2);

		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		// First room with 2 adults
		passenger.setRoomNumber((byte) 1);
		passenger.setAgeCode(AgeCode.ADULT);
		passenger.setGuestCount((byte) 2);
		passengers.add(passenger);

		occupancy.setPassengers(passengers);
		hotelsRequest.setOccupancy(occupancy);

		// Prepare application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.hotelsDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.hotelsDao.getApplicationContextFactory()
					.create();
		}
		this.hotelsDao.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().setIMApplicationInfo(applicationInfo);

		HotelsResponse hotelsResponse = this.hotelsDao
				.retrieveHotels(hotelsRequest);
		assertNotNull(hotelsResponse);
	}
}