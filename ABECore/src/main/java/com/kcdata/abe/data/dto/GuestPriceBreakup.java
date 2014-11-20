/*
 * GuestPriceBreakup.java
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
 * DTO to hold the price breakup information of a guest
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class GuestPriceBreakup implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2791580762448529194L;

	private double flightPrice;
	private double hotelPrice;
	private double vehiclePrice;
	private double insurancePrice;
	private double supplementsPrice;
	private double taxPrice;
	private double fees;
	private double servicePrice;
	private double totalPrice;
	private double basePrice;

	/**
	 * @return the flightPrice
	 */
	public double getFlightPrice() {
		return flightPrice;
	}

	/**
	 * @param flightPrice
	 *            the flightPrice to set
	 */
	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}

	/**
	 * @return the hotelPrice
	 */
	public double getHotelPrice() {
		return hotelPrice;
	}

	/**
	 * @param hotelPrice
	 *            the hotelPrice to set
	 */
	public void setHotelPrice(double hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	/**
	 * @return the vehiclePrice
	 */
	public double getVehiclePrice() {
		return vehiclePrice;
	}

	/**
	 * @param vehiclePrice
	 *            the vehiclePrice to set
	 */
	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	/**
	 * @return the insurancePrice
	 */
	public double getInsurancePrice() {
		return insurancePrice;
	}

	/**
	 * @param insurancePrice
	 *            the insurancePrice to set
	 */
	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	/**
	 * @return the supplementsPrice
	 */
	public double getSupplementsPrice() {
		return supplementsPrice;
	}

	/**
	 * @param supplementsPrice
	 *            the supplementsPrice to set
	 */
	public void setSupplementsPrice(double supplementsPrice) {
		this.supplementsPrice = supplementsPrice;
	}

	/**
	 * @return the taxPrice
	 */
	public double getTaxPrice() {
		return taxPrice;
	}

	/**
	 * @param taxPrice
	 *            the taxPrice to set
	 */
	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}

	/**
	 * @return the fees
	 */
	public double getFees() {
		return fees;
	}

	/**
	 * @param fees
	 *            the fees to set
	 */
	public void setFees(double fees) {
		this.fees = fees;
	}

	/**
	 * @return the servicePrice
	 */
	public double getServicePrice() {
		return servicePrice;
	}

	/**
	 * @param servicePrice
	 *            the servicePrice to set
	 */
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
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
	 * @return the basePrice
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * toString implementation
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<GuestPriceBreakup>\n");
		sb.append("flightPrice: " + flightPrice + "\n");
		sb.append("hotelPrice: " + hotelPrice + "\n");
		sb.append("vehiclePrice: " + vehiclePrice + "\n");
		sb.append("insurancePrice: " + insurancePrice + "\n");
		sb.append("supplementsPrice: " + supplementsPrice + "\n");
		sb.append("taxPrice: " + taxPrice + "\n");
		sb.append("fees: " + fees + "\n");
		sb.append("servicePrice: " + servicePrice + "\n");
		sb.append("totalPrice: " + totalPrice + "\n");
		sb.append("basePrice: " + basePrice + "\n");		
		sb.append("</GuestPriceBreakup>");

		return sb.toString();
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
