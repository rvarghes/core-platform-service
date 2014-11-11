/*
 * TestRetrieveAgencyInfoCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveAgencyInfoCommand;
import com.kcdata.abe.application.command.handler.RetrieveAgencyInfoCommandHandler;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

/**
 * UNIT test class to test the {@link TestRetrieveAgencyInfoCommandHandler}
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveAgencyInfoCommandHandler {

	@Autowired
	private RetrieveAgencyInfoCommandHandler retrieveAgencyInfoCommandHandler;

	/**
	 * Method for testing agency info retrieval DAO
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveAgencyInfo() {
		RetrieveAgencyInfoCommand agencyInfoCommand = new RetrieveAgencyInfoCommand();

		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setRequestorID("10000");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		agencyInfoCommand.setIMApplicationInfo(applicationInfo);

		agencyInfoCommand = (RetrieveAgencyInfoCommand) retrieveAgencyInfoCommandHandler
				.handle(agencyInfoCommand);
		assertNotNull(agencyInfoCommand.getAgency());
	}
}