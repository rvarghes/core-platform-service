/*
 * TestRetrieveBookingCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveBookingCommand;
import com.kcdata.abe.application.command.handler.RetrieveBookingCommandHandler;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

/**
 * JUnit test class for retrieve booking command handler
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveBookingCommandHandler {

	@Autowired
	private RetrieveBookingCommandHandler retrieveBookingCommandHandler;

	/**
	 * Method for testing retrieve booking command handler
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveBooking() {
		RetrieveBookingCommand retrieveBookingCommand = new RetrieveBookingCommand();

		retrieveBookingCommand.setBookingNo("0050013314");

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("0000010000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		retrieveBookingCommand.setIMApplicationInfo(applicationInfo);

		retrieveBookingCommand = (RetrieveBookingCommand) retrieveBookingCommandHandler
				.handle(retrieveBookingCommand);
		assertNotNull(retrieveBookingCommand.getItinerary());
	}
}