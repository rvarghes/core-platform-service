/*
 * TestPaymentHistoryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.test.command.handler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kcdata.abe.application.command.PaymentHistoryCommand;
import com.kcdata.abe.application.command.handler.PaymentHistoryCommandHandler;
import com.kcdata.abe.business.response.PaymentHistoryResponse;

/**
 * JUnit test class for apply payment check command handler
 * 
 * @author ashokg
 * @version
 * 
 * @see
 * @since
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestPaymentHistoryCommandHandler {
	
	@Autowired
	private PaymentHistoryCommandHandler paymentHistoryCommandHandler;
	
	@Test
	public void getPaymentHistory(){
		PaymentHistoryCommand paymentHistoryCommand = new PaymentHistoryCommand();
		paymentHistoryCommand.setBookingNumber("0050521020");
		
		paymentHistoryCommand = (PaymentHistoryCommand) paymentHistoryCommandHandler.handle(paymentHistoryCommand);
		
		//Business error will be populated for Non-Sked desk users
		//Info message will be populated for Sked Desk users
		assertTrue(paymentHistoryCommand.getBusinessErrors() == null 
						&& paymentHistoryCommand.getInfoMessages() == null);
		
	}
}
