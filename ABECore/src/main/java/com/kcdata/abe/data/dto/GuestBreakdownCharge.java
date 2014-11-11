/*
 * GuestBreakdownCharge.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

public class GuestBreakdownCharge implements ABEDto{
	
	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -6593144050426624811L;
	private String paxId;
	private String lastName;
	private String firstName;
	private String chargeDescription;
	private double itemPrice;
	private double netPrice;
	/**
	 * @return the paxId
	 */
	public String getPaxId() {
		return paxId;
	}
	/**
	 * @param paxId the paxId to set
	 */
	public void setPaxId(String paxId) {
		this.paxId = paxId;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the chargeDescription
	 */
	public String getChargeDescription() {
		return chargeDescription;
	}
	/**
	 * @param chargeDescription the chargeDescription to set
	 */
	public void setChargeDescription(String chargeDescription) {
		this.chargeDescription = chargeDescription;
	}
	/**
	 * @return the itemPrice
	 */
	public double getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the netPrice
	 */
	public double getNetPrice() {
		return netPrice;
	}
	/**
	 * @param netPrice the netPrice to set
	 */
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
}
