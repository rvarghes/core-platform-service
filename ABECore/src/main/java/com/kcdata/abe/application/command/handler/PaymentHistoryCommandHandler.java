/*
 * PaymentHistoryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.PaymentHistoryCommand;
import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.business.service.PaymentHistoryService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class PaymentHistoryCommandHandler  extends ABECommandHandlerBase{

	
	private PaymentHistoryService paymentHistoryService;
	
	/**
	 * @return the paymentHistoryService
	 */
	public PaymentHistoryService getPaymentHistoryService() {
		return paymentHistoryService;
	}

	/**
	 * @param paymentHistoryService the paymentHistoryService to set
	 */
	public void setPaymentHistoryService(PaymentHistoryService paymentHistoryService) {
		this.paymentHistoryService = paymentHistoryService;
	}

	/**
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ABECommand handle(ABECommand command) {
		if (!(command instanceof PaymentHistoryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "PaymentHistoryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}//End of if condition...
		
		PaymentHistoryCommand paymentHistoryCommand = (PaymentHistoryCommand) command;
		PaymentHistoryResponse paymentHistoryResponse = paymentHistoryService.getPaymentHistory(paymentHistoryCommand.getBookingNumber());

		// Process response and set the business errors, warnings, and info messages to command
		this.processResponse(paymentHistoryCommand, paymentHistoryResponse);

		// Setting paymentHistory Data...
		paymentHistoryCommand.setPaymentHistoryInfoList(paymentHistoryResponse.getPaymentHistoryInfoList());
		
		return paymentHistoryCommand;
	}

}
