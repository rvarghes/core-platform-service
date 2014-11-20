/*
 * VehicleVendorDetails.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 8, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the Vehicle Vendor details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class VehicleVendorDetails implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1232959431024710242L;

	private String vendorCode;
	private String vendorName;
	private List<String> carTypes;
	private String cashDepositRequird;
	private String ageRequired;
	private String additionalDrivers;
	private String options;
	private String pickupDropOffLocations;
	private String fuelMilage;
	private String taxes;
	private String generalRequirements;
	private String seatBeltsChildRestraints;
	private String drivingAreas;
	private String availableDestinations;
	private String marketStratagy;

	/**
	 * @return the vendorCode
	 */
	public String getVendorCode() {
		return vendorCode;
	}

	/**
	 * @param vendorCode
	 *            the vendorCode to set
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName
	 *            the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the carTypes
	 */
	public List<String> getCarTypes() {
		return carTypes;
	}

	/**
	 * @param carTypes
	 *            the carTypes to set
	 */
	public void setCarTypes(List<String> carTypes) {
		this.carTypes = carTypes;
	}

	/**
	 * @return the cashDepositRequird
	 */
	public String getCashDepositRequird() {
		return cashDepositRequird;
	}

	/**
	 * @param cashDepositRequird
	 *            the cashDepositRequird to set
	 */
	public void setCashDepositRequird(String cashDepositRequird) {
		this.cashDepositRequird = cashDepositRequird;
	}

	/**
	 * @return the ageRequired
	 */
	public String getAgeRequired() {
		return ageRequired;
	}

	/**
	 * @param ageRequired
	 *            the ageRequired to set
	 */
	public void setAgeRequired(String ageRequired) {
		this.ageRequired = ageRequired;
	}

	/**
	 * @return the additionalDrivers
	 */
	public String getAdditionalDrivers() {
		return additionalDrivers;
	}

	/**
	 * @param additionalDrivers
	 *            the additionalDrivers to set
	 */
	public void setAdditionalDrivers(String additionalDrivers) {
		this.additionalDrivers = additionalDrivers;
	}

	/**
	 * @return the options
	 */
	public String getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * @return the pickupDropOffLocations
	 */
	public String getPickupDropOffLocations() {
		return pickupDropOffLocations;
	}

	/**
	 * @param pickupDropOffLocations
	 *            the pickupDropOffLocations to set
	 */
	public void setPickupDropOffLocations(String pickupDropOffLocations) {
		this.pickupDropOffLocations = pickupDropOffLocations;
	}

	/**
	 * @return the fuelMilage
	 */
	public String getFuelMilage() {
		return fuelMilage;
	}

	/**
	 * @param fuelMilage
	 *            the fuelMilage to set
	 */
	public void setFuelMilage(String fuelMilage) {
		this.fuelMilage = fuelMilage;
	}

	/**
	 * @return the taxes
	 */
	public String getTaxes() {
		return taxes;
	}

	/**
	 * @param taxes
	 *            the taxes to set
	 */
	public void setTaxes(String taxes) {
		this.taxes = taxes;
	}

	/**
	 * @return the generalRequirements
	 */
	public String getGeneralRequirements() {
		return generalRequirements;
	}

	/**
	 * @param generalRequirements
	 *            the generalRequirements to set
	 */
	public void setGeneralRequirements(String generalRequirements) {
		this.generalRequirements = generalRequirements;
	}

	/**
	 * @return the seatBeltsChildRestraints
	 */
	public String getSeatBeltsChildRestraints() {
		return seatBeltsChildRestraints;
	}

	/**
	 * @param seatBeltsChildRestraints
	 *            the seatBeltsChildRestraints to set
	 */
	public void setSeatBeltsChildRestraints(String seatBeltsChildRestraints) {
		this.seatBeltsChildRestraints = seatBeltsChildRestraints;
	}

	/**
	 * @return the drivingAreas
	 */
	public String getDrivingAreas() {
		return drivingAreas;
	}

	/**
	 * @param drivingAreas
	 *            the drivingAreas to set
	 */
	public void setDrivingAreas(String drivingAreas) {
		this.drivingAreas = drivingAreas;
	}

	/**
	 * @return the availableDestinations
	 */
	public String getAvailableDestinations() {
		return availableDestinations;
	}

	/**
	 * @param availableDestinations
	 *            the availableDestinations to set
	 */
	public void setAvailableDestinations(String availableDestinations) {
		this.availableDestinations = availableDestinations;
	}

	/**
	 * @return the marketStratagy
	 */
	public String getMarketStratagy() {
		return marketStratagy;
	}

	/**
	 * @param marketStratagy
	 *            the marketStratagy to set
	 */
	public void setMarketStratagy(String marketStratagy) {
		this.marketStratagy = marketStratagy;
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
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
