/*
 * TestPaymentHistoryCommandHandler.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 20, 2011  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveAlertsCommand;
import com.kcdata.abe.application.command.handler.RetrieveAlertsCommandHandler;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

/**
 * JUnit test class for apply payment check command handler
 * 
 * @author hguntupa
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveAlertsCommandHandler {

	@Autowired
	private RetrieveAlertsCommandHandler retrieveAlertsCommandHandler;

	@Test
	public void getPaymentHistory() {
		// Set application info object
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("0000255803");
		applicationInfo.setRequestorID("0000010000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("hguntupalli");
		
		RetrieveAlertsCommand retrieveAlertsCommand = new RetrieveAlertsCommand();
		retrieveAlertsCommand.setIMApplicationInfo(applicationInfo);
		retrieveAlertsCommand.setBookingNumber("0051186512");
		
		retrieveAlertsCommand = (RetrieveAlertsCommand) retrieveAlertsCommandHandler.handle(retrieveAlertsCommand);
		assertTrue(retrieveAlertsCommand.getAlerts() != null);
	}
}
