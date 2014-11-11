/*
 * ApplyPaymentCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.framework.command.ABECommandBase;

public class ApplyPaymentCommand extends ABECommandBase{

	/**
	 * Default serialization version Id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5677587878753645396L;
	
	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "applyPaymentCommandHandler";
	
	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */
	
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * Object to hold Payment Information
	 */
	private PaymentInformation paymentInformation;
	
	/**
	 * @return the paymentInformation
	 */
	public PaymentInformation getPaymentInformation() {
		return paymentInformation;
	}

	/**
	 * @param paymentInformation
	 *            the paymentInformation to set
	 */
	public void setPaymentInformation(PaymentInformation paymentInformation) {
		this.paymentInformation = paymentInformation;
	}
}
