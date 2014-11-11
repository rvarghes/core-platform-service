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

import com.kcdata.abe.application.command.ChangePasswordCommand;
import com.kcdata.abe.application.command.handler.ChangePasswordCommandHandler;
import com.kcdata.abe.data.dto.User;

/**
 * Class to unit test the application
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class ChangePasswordTest {

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
		
		ChangePasswordCommand command = new ChangePasswordCommand();
		User user = new User();
		user.setLoginId("vmarni");
		user.setPassword("intelli123");
		user.setNewPassword("init123");
		command.setUser(user);
		
		ChangePasswordCommandHandler handler = (ChangePasswordCommandHandler) context.getBean(command.getCommandHandlerName());
		command = (ChangePasswordCommand) handler.handle(command);
		System.out.println("Errors: "+command.getBusinessErrors());
		System.out.println("User: "+command.getUser());		
	}

}
