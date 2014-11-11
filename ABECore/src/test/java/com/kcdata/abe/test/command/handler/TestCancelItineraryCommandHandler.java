/*
 * TestSaveItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 23, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.CancelItineraryCommand;
import com.kcdata.abe.application.command.handler.CancelItineraryCommandHandler;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestCancelItineraryCommandHandler {
	
	@Autowired
	private CancelItineraryCommandHandler cancelItineraryCommandHandler;
	
	@Test
	public void saveItineraryChanges() {
		CancelItineraryCommand cancelItineraryCommand = new CancelItineraryCommand();

		cancelItineraryCommand.setBookingNo("0050017461");

		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("0000010000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		cancelItineraryCommand.setIMApplicationInfo(applicationInfo);

		cancelItineraryCommand = (CancelItineraryCommand) cancelItineraryCommandHandler
				.handle(cancelItineraryCommand);
		
		assertNotNull(cancelItineraryCommand.getItinerary());
	}
	
}

