/*
 * TestRetrieveVehiclesCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
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

import com.kcdata.abe.application.command.RetrieveVehiclesCommand;
import com.kcdata.abe.application.command.handler.RetrieveVehiclesCommandHandler;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.data.dto.VehicleOptions;

/**
 * UNIT test class for testing retrieve vehicles command handler
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveVehiclesCommandHandler {

	@Autowired
	private RetrieveVehiclesCommandHandler retrieveVehiclesCommandHandler;

	/**
	 * Method to test the RetrieveVehiclesCommandHandler class retrieveVehicles
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveVehicles() {
		RetrieveVehiclesCommand vehiclesCommand = new RetrieveVehiclesCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("255803");
		applicationInfo.setRequestorID("10000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		vehiclesCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setNoOfNights((byte) 7);

		VehicleOptions vehicleOptions = new VehicleOptions();
		vehicleOptions.setPickupLocation("OGG");
		vehicleOptions.setPickupDateTime(cal.getTime());

		cal.add(Calendar.DATE, destnOption.getNoOfNights());
		vehicleOptions.setDropoffLocation("OGG");
		vehicleOptions.setDropoffDateTime(cal.getTime());
		vehicleOptions.setVendorCode("ZE");
		destnOption.setVehicleOptions(vehicleOptions);
		destnOption.setVehicleRequested(true);
		
		destnOptions.add(destnOption);
		searchCriteria.setDestinationOptions(destnOptions);
		
		vehiclesCommand.setSearchCriteria(searchCriteria);
		vehiclesCommand = (RetrieveVehiclesCommand) retrieveVehiclesCommandHandler
				.handle(vehiclesCommand);
		assertNotNull(vehiclesCommand.getVehicles());
	}
}