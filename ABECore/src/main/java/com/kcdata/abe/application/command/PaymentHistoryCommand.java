/*
 * PaymentHistoryCommand.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.ArrayList;

import com.kcdata.abe.data.dto.PaymentHistoryInfo;
import com.kcdata.abe.framework.command.ABECommandBase;

public class PaymentHistoryCommand  extends ABECommandBase{

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "paymentHistoryCommandHandler";
	/**
	 * Serial Version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 5568909777565061476L;

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

	private String bookingNumber;
	private ArrayList<PaymentHistoryInfo> paymentHistoryInfoList;
	/**
	 * @return the paymentHistoryInfoList
	 */
	public ArrayList<PaymentHistoryInfo> getPaymentHistoryInfoList() {
		return paymentHistoryInfoList;
	}

	/**
	 * @param paymentHistoryInfoList the paymentHistoryInfoList to set
	 */
	public void setPaymentHistoryInfoList(
			ArrayList<PaymentHistoryInfo> paymentHistoryInfoList) {
		this.paymentHistoryInfoList = paymentHistoryInfoList;
	}

	private String subCommand;
	
	/**
	 * @return the subCommand
	 */
	public String getSubCommand() {
		return subCommand;
	}

	/**
	 * @param subCommand the subCommand to set
	 */
	public void setSubCommand(String subCommand) {
		this.subCommand = subCommand;
	}

	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}
}
