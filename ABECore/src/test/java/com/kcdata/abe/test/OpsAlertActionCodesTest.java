/*
 * OpsAlertActionCodesTest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.test;

import java.util.Iterator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kcdata.abe.application.command.RetrieveOpsAlertActionCodesCommand;
import com.kcdata.abe.application.command.handler.RetrieveOpsAlertActionCodesCommandHandler;
import com.kcdata.abe.data.dto.ActionType;
import com.kcdata.abe.data.dto.AlertType;
import com.kcdata.abe.data.dto.OpsAlert;

public class OpsAlertActionCodesTest {

	/**
	 * Unit test class for Ops Alerts and Actions
	 * 
	 * @param args
	 * 
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		RetrieveOpsAlertActionCodesCommand command = new RetrieveOpsAlertActionCodesCommand();
		
		RetrieveOpsAlertActionCodesCommandHandler handler = (RetrieveOpsAlertActionCodesCommandHandler) context
				.getBean(command.getCommandHandlerName());
		command = (RetrieveOpsAlertActionCodesCommand) handler.handle(command);

		OpsAlert opsAlert = command.getOpsAlert();
		
		Iterator<AlertType> itAlerts = opsAlert.getAlertTypes().iterator();
		while (itAlerts.hasNext()) {
			AlertType alertType = itAlerts.next();
			System.out.println("AlertType: " + alertType.getDescription());
		}
		
		System.out.println("*********************");
		
		Iterator<ActionType> itActions = opsAlert.getActionTypes().iterator();
		while (itActions.hasNext()) {
			ActionType actionType = itActions.next();
			System.out.println("Action Type: " + actionType.getDescription());
		}
		
	}
	
	
}
