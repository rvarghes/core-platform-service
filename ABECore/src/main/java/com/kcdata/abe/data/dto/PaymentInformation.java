/*
 * PaymentInformation.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;
/**
 * Value object to hold the payment information
 *
 * @author dmahanth
 * @version
 *
 * @see
 * @since
 */
public class PaymentInformation implements ABEDto{

	/**
	 * Default serial UID.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8619774441408906778L;

	private String bookingNo;
	private CreditCard creditCard;
	private GuaranteedCheck guaranteedCheck;
	private MoneyTransfer moneyTransfer;
	private char creditCardFlag;
	private char guaranteedCheckFlag;
	private char moneyTransferFlag;
	private IMApplicationInfo imApplicationInfo;
	
	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/**
	 * @return the creditCard
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	/**
	 * @return the guaranteedCheck
	 */
	public GuaranteedCheck getGuaranteedCheck() {
		return guaranteedCheck;
	}
	/**
	 * @param guaranteedCheck the guaranteedCheck to set
	 */
	public void setGuaranteedCheck(GuaranteedCheck guaranteedCheck) {
		this.guaranteedCheck = guaranteedCheck;
	}
	
	/**
	 * @return the moneyTransfer
	 */
	public MoneyTransfer getMoneyTransfer() {
		return moneyTransfer;
	}
	/**
	 * @param moneyTransfer the moneyTransfer to set
	 */
	public void setMoneyTransfer(MoneyTransfer moneyTransfer) {
		this.moneyTransfer = moneyTransfer;
	}
	
	/**
	 * @return the creditCardFlag
	 */
	public char getCreditCardFlag() {
		return creditCardFlag;
	}
	/**
	 * @param creditCardFlag the creditCardFlag to set
	 */
	public void setCreditCardFlag(char creditCardFlag) {
		this.creditCardFlag = creditCardFlag;
	}
	
	/**
	 * @return the guaranteedCheckFlag
	 */
	public char getGuaranteedCheckFlag() {
		return guaranteedCheckFlag;
	}
	/**
	 * @param guaranteedCheckFlag the guaranteedCheckFlag to set
	 */
	public void setGuaranteedCheckFlag(char guaranteedCheckFlag) {
		this.guaranteedCheckFlag = guaranteedCheckFlag;
	}
	
	/**
	 * @return the moneyTransferFlag
	 */
	public char getMoneyTransferFlag() {
		return moneyTransferFlag;
	}
	/**
	 * @param moneyTransferFlag the moneyTransferFlag to set
	 */
	public void setMoneyTransferFlag(char moneyTransferFlag) {
		this.moneyTransferFlag = moneyTransferFlag;
	}
	
	/**
	 * @return the imApplicationInfo
	 */
	public IMApplicationInfo getImApplicationInfo() {
		return imApplicationInfo;
	}

	/**
	 * @param imApplicationInfo
	 *            the imApplicationInfo to set
	 */
	public void setImApplicationInfo(IMApplicationInfo imApplicationInfo) {
		this.imApplicationInfo = imApplicationInfo;
	}
}
