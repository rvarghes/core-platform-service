/*
 * TestBreakDownChargesCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.BreakdownChargesCommand;
import com.kcdata.abe.application.command.handler.BreakdownChargesCommandHandler;

/**
 * TODO: JUnit test class for retrieve booking command handler
 *
 * @author chazari
 * @version
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestBreakDownChargesCommandHandler {
	@Autowired BreakdownChargesCommandHandler breakdownChargesCommandHandler;
	
	@Test
	public void retrieveBreakdownCharges() {
		BreakdownChargesCommand breakdownChargesCommand = new BreakdownChargesCommand();
		breakdownChargesCommand.setBookingNo("0050755554");
		BreakdownChargesCommand returnedCommand = (BreakdownChargesCommand) breakdownChargesCommandHandler.handle(breakdownChargesCommand);
		assertNull(returnedCommand.getBreakdownCharges());
		assertNull(returnedCommand.getCommissionCharges());
	}
}
