/*
 * TestRetrieveFairTradeContractCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.RetrieveFairTradeContractCommand;
import com.kcdata.abe.application.command.handler.RetrieveFairTradeContractCommandHandler;

/**
 * UNIT test class to test the
 * {@link TestRetrieveFairTradeContractCommandHandler}
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestRetrieveFairTradeContractCommandHandler {

	@Autowired
	private RetrieveFairTradeContractCommandHandler retrieveFTCCommandHandler;

	/**
	 * Method for testing fair trade contract command handler
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveFTC() throws ParseException {
		RetrieveFairTradeContractCommand ftcCommand = new RetrieveFairTradeContractCommand();

		ftcCommand = (RetrieveFairTradeContractCommand) retrieveFTCCommandHandler
				.handle(ftcCommand);
		assertNotNull(ftcCommand.getFairTradeContract());
	}
}