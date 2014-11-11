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

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kcdata.abe.application.command.RetrieveGatewayDestinationsCommand;
import com.kcdata.abe.application.command.handler.RetrieveGatewayDestinationsCommandHandler;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.UserType;

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
public class GatewayDestnTest {

	/**
	 * Main method to test the Application
	 *
	 * @param args
	 *
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		RetrieveGatewayDestinationsCommand command = new RetrieveGatewayDestinationsCommand();
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		command.setIMApplicationInfo(applicationInfo);
		RetrieveGatewayDestinationsCommandHandler handler = (RetrieveGatewayDestinationsCommandHandler) context.getBean(command.getCommandHandlerName());
		command = (RetrieveGatewayDestinationsCommand) handler.handle(command);

		System.out.println("Gateways: "+command.getGateways());
		System.out.println("Destinations: "+command.getDestinations());		
	}

}
