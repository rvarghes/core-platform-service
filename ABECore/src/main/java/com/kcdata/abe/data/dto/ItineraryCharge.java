/*
 * ItineraryCharge.java
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

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO to hold the booking charges
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ItineraryCharge implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4990844141694015447L;
	
	private String code;
	private String description;
	private double quantity;
	private String unitsOfMeasure;
	private double price;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the unitsOfMeasure
	 */
	public String getUnitsOfMeasure() {
		return unitsOfMeasure;
	}
	/**
	 * @param unitsOfMeasure the unitsOfMeasure to set
	 */
	public void setUnitsOfMeasure(String unitsOfMeasure) {
		this.unitsOfMeasure = unitsOfMeasure;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
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
