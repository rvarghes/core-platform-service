/*
 * ApplyPaymentTest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.test;

import java.util.Iterator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kcdata.abe.application.command.ApplyPaymentCommand;
import com.kcdata.abe.application.command.handler.ApplyPaymentCommandHandler;
import com.kcdata.abe.data.dto.CreditCard;
import com.kcdata.abe.data.dto.GuaranteedCheck;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;

public class ApplyPaymentTest {

	/**
	 * Unit test class for apply payment for the booking
	 * 
	 * @param args
	 * 
	 * @see
	 * @since
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		ApplyPaymentCommand command = new ApplyPaymentCommand();
		
		ApplyPaymentCommandHandler handler = (ApplyPaymentCommandHandler) context
				.getBean(command.getCommandHandlerName());
		
		IMApplicationInfo applicationInfo = new IMApplicationInfo();
		applicationInfo.setAgentNumber("124");
		applicationInfo.setRequestorID("10");
		applicationInfo.setType(UserType.RESERVATION_AGENT);
		applicationInfo.setContextID("ABE");
		applicationInfo.setCreatedBy("CBEUSER");
		command.setIMApplicationInfo(applicationInfo);
		
		PaymentInformation paymentInformation = new PaymentInformation();
		paymentInformation.setBookingNo("0011086546");
		paymentInformation.setCreditCardFlag('X');
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNo("4012100000000");
		creditCard.setCardType("V");
		creditCard.setExpiryYear("2010");
		creditCard.setExpiryMonth("12");
		creditCard.setFirstName("JHON");
		creditCard.setLastName("SMITH");
		creditCard.setAmountUSD(877.33);
		creditCard.setPostalCode("19073");
		creditCard.setStreet("123 STREET");
		creditCard.setCity("PHILADELPHIA");
		creditCard.setAmount(877.33);
		creditCard.setCountryCode("US");
		creditCard.setState("PA");
		creditCard.setCVVCode("123");
		paymentInformation.setCreditCard(creditCard);
		
		GuaranteedCheck guaranteedCheck = new GuaranteedCheck();
		paymentInformation.setGuaranteedCheck(guaranteedCheck);
		
		command.setPaymentInformation(paymentInformation);
		command = (ApplyPaymentCommand) handler.handle(command);
	
		if(command.getBusinessErrors() != null){
			Iterator<ABEBusinessError> it = command.getBusinessErrors().iterator();
			while (it.hasNext()) {
				ABEBusinessError businessError = it.next();
				System.out.println("ABEBusinessError: " + businessError.toString());
			}	
		}
		else if(command.getWarnings() != null){
			Iterator<ABEWarning> itwarning = command.getWarnings().iterator();
			while (itwarning.hasNext()) {
				ABEWarning warning = itwarning.next();
				System.out.println("ABEWarning: " + warning.toString());
			}	
		}
		else
			System.out.println("*************** Apply Payment is successful ************************");
	}
}
