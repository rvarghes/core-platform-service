/*
 * TestApp.java
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

import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kcdata.abe.application.command.RetrieveFlightsCommand;
import com.kcdata.abe.application.command.handler.RetrieveFlightsCommandHandler;
import com.kcdata.abe.data.dto.SearchCriteria;

/**
 * Class to unit test the application
 * N/A for any usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class TestApp {

	/**
	 * Main method to test the Application
	 *
	 * @param args
	 *
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:*-context.xml");
		
		RetrieveFlightsCommand command = new RetrieveFlightsCommand();
		SearchCriteria sCriteria = new SearchCriteria();
		sCriteria.setGateway("PHL");
		//sCriteria.setDestination("CUN");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		sCriteria.setDepartureDate(cal.getTime());
		//sCriteria.setDuration(7);
		command.setSearchCriteria(sCriteria);
		RetrieveFlightsCommandHandler handler = (RetrieveFlightsCommandHandler) context.getBean(command.getCommandHandlerName());
		command = (RetrieveFlightsCommand) handler.handle(command);
		
		System.out.println("Context Started");
	}

}
