/*
 * TestValidatePromoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
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

import com.kcdata.abe.application.command.ValidatePromoCommand;
import com.kcdata.abe.application.command.handler.ValidatePromoCommandHandler;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class for validate promo command handler
 * 
 * @author hguntupa
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestValidatePromoCommandHandler {

	@Autowired
	private ValidatePromoCommandHandler validatePromoCommandHandler;

	/**
	 * Method to test the RetrieveVehiclesCommandHandler class retrieveVehicles
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void validatePromo() {
		ValidatePromoCommand validatePromoCommand = new ValidatePromoCommand();

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		validatePromoCommand.setIMApplicationInfo(applicationInfo);

		// Prepare & set search criteria
		SearchCriteria searchCriteria = new SearchCriteria();
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 1);
		searchCriteria.setDepartureDate(cal.getTime());
		searchCriteria.setGateway("PHL");
		searchCriteria.setPromoCode("ABEGEN");

		// Prepare destination options
		ArrayList<DestinationOptions> destnOptions = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestinationId(1);
		destnOption.setNoOfNights((byte) 7);
		destnOption.setDestination("CUN");
		destnOptions.add(destnOption);
		searchCriteria.setDestinationOptions(destnOptions);
		validatePromoCommand.setSearchCriteria(searchCriteria);

		validatePromoCommand = (ValidatePromoCommand) validatePromoCommandHandler
				.handle(validatePromoCommand);

		assertNotNull(validatePromoCommand.getInfoMessages());
	}
}