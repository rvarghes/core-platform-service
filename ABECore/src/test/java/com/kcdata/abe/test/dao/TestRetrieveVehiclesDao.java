/*
 * TestRetrieveVehiclesDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
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

import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.dao.VehiclesDao;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.data.dto.VehicleOptions;
import com.kcdata.abe.framework.context.ABEApplicationContext;

/**
 * UNIT test class to test Vehicle availability DAO
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
public class TestRetrieveVehiclesDao {

	@Autowired
	private VehiclesDao vehiclesDao;

	/**
	 * Method to test the Vehicles DAO for retrieving hotels
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveHotels() {
		VehiclesRequest vehiclesRequest = new VehiclesRequest();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);

		vehiclesRequest.setNoOfNights((byte) 7);
		vehiclesRequest.setVehicleRequested(true);

		VehicleOptions vehicleOptions = new VehicleOptions();
		vehicleOptions.setPickupLocation("OGG");
		vehicleOptions.setPickupDateTime(cal.getTime());

		cal.add(Calendar.DATE, vehiclesRequest.getNoOfNights());
		vehicleOptions.setDropoffLocation("OGG");
		vehicleOptions.setDropoffDateTime(cal.getTime());
		vehicleOptions.setVendorCode("ZE");//vehicle.getCompanyCode()
		vehiclesRequest.setVehicleOptions(vehicleOptions);

		// Prepare application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("255803");
		applicationInfo.setRequestorID("10000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");

		// Get the Application Context and Request Context
		ABEApplicationContext applicationContext = this.vehiclesDao
				.getApplicationContextFactory().getApplicationContext();
		if (applicationContext == null) {
			applicationContext = this.vehiclesDao
					.getApplicationContextFactory().create();
		}
		this.vehiclesDao.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().setIMApplicationInfo(applicationInfo);

		VehiclesResponse vehiclesResponse = this.vehiclesDao
				.retrieveVehicles(vehiclesRequest);
		assertNotNull(vehiclesResponse.getVehicles());
	}
}