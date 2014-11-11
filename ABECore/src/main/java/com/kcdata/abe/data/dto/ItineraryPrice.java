/*
 * ItineraryPrice.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO to hold the Itinerary price information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryPrice implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3609758863964354570L;

	private double totalPrice;
	private double preBPGTotalPrice;
	/**
	 * @return the preBPGTotalPrice
	 */
	public double getPreBPGTotalPrice() {
		return preBPGTotalPrice;
	}

	/**
	 * @param preBPGTotalPrice the preBPGTotalPrice to set
	 */
	public void setPreBPGTotalPrice(double preBPGTotalPrice) {
		this.preBPGTotalPrice = preBPGTotalPrice;
	}

	private double totalTax;
	private double promoSavings;
	private String currency;
	private double depositAmount;
	private Date depositDate;
	/**
	 * @return the depositAmount
	 */
	public double getDepositAmount() {
		return depositAmount;
	}

	/**
	 * @param depositAmount the depositAmount to set
	 */
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	/**
	 * @return the depositDate
	 */
	public Date getDepositDate() {
		return depositDate;
	}

	/**
	 * @param depositDate the depositDate to set
	 */
	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}


	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the totalTax
	 */
	public double getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax
	 *            the totalTax to set
	 */
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the promoSavings
	 */
	public double getPromoSavings() {
		return promoSavings;
	}

	/**
	 * @param promoSavings the promoSavings to set
	 */
	public void setPromoSavings(double promoSavings) {
		this.promoSavings = promoSavings;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
