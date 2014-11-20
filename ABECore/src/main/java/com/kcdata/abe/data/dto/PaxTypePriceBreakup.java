/*
 * PaxTypePriceBreakup.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO class to hold the PAX Type based pricing details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PaxTypePriceBreakup implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3231015803245238607L;

	private char paxType;
	private int count;
	private double taxes;
	private double price;
	private double usTax;
	private double foreignTax;
	private double airportTax;
	private double totalAmount;
	private String typeRule;
	private byte minAge;
	private byte maxAge;
	private double savings;
	private double lateFee;

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	/**
	 * Used only in Multi-destination price break-up
	 */
	private byte roomId;

	/**
	 * Field to hold age while calculating PaxTypeBreakUp for
	 * multi-destination packages
	 */
	private byte age;

	/**
	 * @return the paxType
	 */
	public char getPaxType() {
		return paxType;
	}

	/**
	 * @param paxType
	 *            the paxType to set
	 */
	public void setPaxType(char paxType) {
		this.paxType = paxType;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the taxes
	 */
	public double getTaxes() {
		return taxes;
	}

	/**
	 * @param taxes
	 *            the taxes to set
	 */
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the usTax
	 */
	public double getUsTax() {
		return usTax;
	}

	/**
	 * @param usTax
	 *            the usTax to set
	 */
	public void setUsTax(double usTax) {
		this.usTax = usTax;
	}

	/**
	 * @return the foreignTax
	 */
	public double getForeignTax() {
		return foreignTax;
	}

	/**
	 * @param foreignTax
	 *            the foreignTax to set
	 */
	public void setForeignTax(double foreignTax) {
		this.foreignTax = foreignTax;
	}

	/**
	 * @return the airportTax
	 */
	public double getAirportTax() {
		return airportTax;
	}

	/**
	 * @param airportTax
	 *            the airportTax to set
	 */
	public void setAirportTax(double airportTax) {
		this.airportTax = airportTax;
	}

	/**
	 * @return the totalAmout
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmout
	 *            the totalAmout to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the typeRule
	 */
	public String getTypeRule() {
		return typeRule;
	}

	/**
	 * @param typeRule
	 *            the typeRule to set
	 */
	public void setTypeRule(String typeRule) {
		this.typeRule = typeRule;
	}

	/**
	 * @return the minAge
	 */
	public byte getMinAge() {
		return minAge;
	}

	/**
	 * @param minAge
	 *            the minAge to set
	 */
	public void setMinAge(byte minAge) {
		this.minAge = minAge;
	}

	/**
	 * @return the maxAge
	 */
	public byte getMaxAge() {
		return maxAge;
	}

	/**
	 * @param maxAge
	 *            the maxAge to set
	 */
	public void setMaxAge(byte maxAge) {
		this.maxAge = maxAge;
	}

	/**
	 * @return the roomId
	 */
	public byte getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setRoomId(byte roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}
	
	/**
	 * @return the savings
	 */
	public double getSavings() {
		return savings;
	}

	/**
	 * @param savings the savings to set
	 */
	public void setSavings(double savings) {
		this.savings = savings;
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
