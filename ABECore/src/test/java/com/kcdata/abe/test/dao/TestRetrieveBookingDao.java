/*
 * TestRetrieveBookingDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.data.dao.BookingSearchDao;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Retrieve Booking DAO
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveBookingDao {

	@Autowired
	private BookingSearchDao bookingSearchDao;

	/**
	 * Method to test Retrieve Booking DAO for booking retrieval
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveBooking() {
		// Prepare application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		
		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.bookingSearchDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.bookingSearchDao.getApplicationContextFactory()
					.create();
		}
		this.bookingSearchDao.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().setIMApplicationInfo(applicationInfo);

		
		BookingSearchResponse searchResponse = this.bookingSearchDao
				.retrieveBooking("11090765");
		assertNotNull(searchResponse.getItinerary());
	}
}