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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.kcdata.abe.application.command.AdvancedSkedSearchCommand;
import com.kcdata.abe.application.command.handler.AdvancedSkedSearchCommandHandler;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.UserType;

public class AdvSkedSearchTest {

	/**
	 * Method tp test AdvnacedSked Search
	 * 
	 * @param args
	 * 
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");

		AdvancedSkedSearchCommand command = new AdvancedSkedSearchCommand();
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		command.setIMApplicationInfo(applicationInfo);

		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setGateway("PHL");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 2);
		searchCriteria.setDepartureDate(cal.getTime());

		ArrayList<DestinationOptions> destnOptionList = new ArrayList<DestinationOptions>();
		DestinationOptions destnOption = new DestinationOptions();
		destnOption.setDestination("HNL");
		destnOption.setNoOfNights((byte)2);
		destnOptionList.add(destnOption);
		
		searchCriteria.setDestinationOptions(destnOptionList);

		command.setSearchCriteria(searchCriteria);

		AdvancedSkedSearchCommandHandler handler = (AdvancedSkedSearchCommandHandler) context
				.getBean(command.getCommandHandlerName());
		command = (AdvancedSkedSearchCommand) handler.handle(command);
	}
}
