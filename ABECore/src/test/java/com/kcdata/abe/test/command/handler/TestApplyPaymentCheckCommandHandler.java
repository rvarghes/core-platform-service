/*
 * TestApplyPaymentCheckCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.ApplyPaymentCheckCommand;
import com.kcdata.abe.application.command.handler.ApplyPaymentCheckCommandHandler;

/**
 * JUnit test class for apply payment check command handler
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestApplyPaymentCheckCommandHandler {

	@Autowired
	private ApplyPaymentCheckCommandHandler applyPaymentCheckCommandHandler;

	/**
	 * Method for testing retrieve booking command handler
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void applyPaymentCheck() {
		ApplyPaymentCheckCommand applyPaymentCheckCommand = new ApplyPaymentCheckCommand();

		applyPaymentCheckCommand.setBookingNo("0050012242");
		applyPaymentCheckCommand.setUserName("");
		applyPaymentCheckCommand.setUserGroupName("SKEDCDESK");

		applyPaymentCheckCommand = (ApplyPaymentCheckCommand) applyPaymentCheckCommandHandler
				.handle(applyPaymentCheckCommand);
		//Business error will be populated for Non-Sked desk users
		//Info message will be populated for Sked Desk users
		assertTrue(applyPaymentCheckCommand.getBusinessErrors() == null 
						&& applyPaymentCheckCommand.getInfoMessages() == null);

	}
}