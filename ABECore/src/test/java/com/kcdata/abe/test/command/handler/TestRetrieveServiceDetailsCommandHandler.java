/*
 * TestRetrieveServiceDetailsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 20, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveServiceDetailsCommand;
import com.kcdata.abe.application.command.handler.RetrieveServiceDetailsCommandHandler;
import com.kcdata.abe.data.dto.Service;

/**
 * UNIT test class for testing retrieve service details command handler
 * 
 * @author hguntupa
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveServiceDetailsCommandHandler {

	@Autowired
	private RetrieveServiceDetailsCommandHandler retrieveServiceDetailsCommandHandler;

	/**
	 * Method to test the TestRetrieveServiceDetailsCommandHandler class
	 * method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveServiceDetails() {
		RetrieveServiceDetailsCommand retrieveServiceDetailsCommand = new RetrieveServiceDetailsCommand();
		Service service = new Service();
		service.setServiceCode("SUPAUA001001");
		Calendar cal = Calendar.getInstance();
		cal.set(2009, 11, 10);
		service.setDepatureDate(cal.getTime());
		cal.set(2009, 11, 17);
		service.setReturnDate(cal.getTime());
		retrieveServiceDetailsCommand.setService(service);
		retrieveServiceDetailsCommand = (RetrieveServiceDetailsCommand) retrieveServiceDetailsCommandHandler.handle(retrieveServiceDetailsCommand);
		assertNotNull(retrieveServiceDetailsCommand.getService());
	}
}