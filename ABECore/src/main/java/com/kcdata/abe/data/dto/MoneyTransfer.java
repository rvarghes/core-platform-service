/*
 * MoneyTransfer.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 12, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;
/**
 * Value object for Money Transfer information
 *
 * @author dmahanth
 * @version
 *
 * @see
 * @since
 */
public class MoneyTransfer implements ABEDto{

	/**
	 * Default serial UID.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3743214358634855700L;
	
	//Guaranteed Check Information
	private String transferFromBooking;
	private double amountApplied;
	private String reason;	
	
	/**
	 * @return the transferFromBooking
	 */
	public String getTransferFromBooking() {
		return transferFromBooking;
	}
	/**
	 * @param transferFromBooking the transferFromBooking to set
	 */
	public void setTransferFromBooking(String transferFromBooking) {
		this.transferFromBooking = transferFromBooking;
	}
	
	/**
	 * @return the amountApplied
	 */
	public double getAmountApplied() {
		return amountApplied;
	}
	/**
	 * @param amountApplied the amountApplied to set
	 */
	public void setAmountApplied(double amountApplied) {
		this.amountApplied = amountApplied;
	}
	
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
