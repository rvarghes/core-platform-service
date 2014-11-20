/*
 * TestOpsAlertCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.OpsAlertCommand;
import com.kcdata.abe.application.command.handler.OpsAlertCommandHandler;

/**
 * UNIT test class to test the {@link TestOpsAlertCommandHandler}
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestOpsAlertCommandHandler {

	@Autowired
	private OpsAlertCommandHandler opsAlertCommandHandler;

	/**
	 * Method to test the OpsAlertCommandHandler class retrieve OpsAlert method
	 * 
	 * 
	 * @see
	 * @since
	 */
	@Test
	public void retrieveOpsAlert() {
		OpsAlertCommand opsAlertCommand = new OpsAlertCommand();
		opsAlertCommand.setSubCommand(OpsAlertCommand.RETRIEVE_ALERT);
		opsAlertCommand.setOpsAlertCode("0200021765");
		opsAlertCommand = (OpsAlertCommand) opsAlertCommandHandler.handle(opsAlertCommand);
		assertNotNull(opsAlertCommand.getOpsAlert());
	}
}
