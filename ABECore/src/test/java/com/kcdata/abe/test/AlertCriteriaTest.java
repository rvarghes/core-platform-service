/*
 * AdvSkedSearchTest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kcdata.abe.application.command.RetrieveAlertsCommand;
import com.kcdata.abe.application.command.handler.RetrieveAlertsCommandHandler;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

public class AlertCriteriaTest {

	/**
	 * Unit test class for Alerts
	 * 
	 * @param args
	 * 
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		RetrieveAlertsCommand command = new RetrieveAlertsCommand();
		ArrayList<AlertCriteria> arrAlertCriteria = new ArrayList<AlertCriteria>();
		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		command.setIMApplicationInfo(applicationInfo);
		
		AlertCriteria alertCriteria = new AlertCriteria();
		Calendar c = Calendar.getInstance();
		
		alertCriteria.setDestination("CUN");
		c.set(2009, 7, 16);
		alertCriteria.setBookingDate(c.getTime());
		c.set(2009, 9, 1);
		alertCriteria.setTravelDate(c.getTime());
		alertCriteria.setDuration(0);
		arrAlertCriteria.add(alertCriteria);
		command.setAlertCriteriaList(arrAlertCriteria);
		
		RetrieveAlertsCommandHandler handler = (RetrieveAlertsCommandHandler) context
				.getBean(command.getCommandHandlerName());
		command = (RetrieveAlertsCommand) handler.handle(command);

		Iterator<Alert> it = command.getAlerts().iterator();
		while (it.hasNext()) {
			Alert alerts = it.next();
			System.out.println("Alert: " + alerts.toString());
		}
		
	}

}
