/*
 * Vehicle.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Added new fields for holding search criteria for cars
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for holding vehicle data
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class Vehicle implements ABEDto {

	/**
	 * Default generated serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3152238686804869L;

	/**
	 * @return the vehicleId
	 */
	public byte getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId
	 *            the vehicleId to set
	 */
	public void setVehicleId(byte vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the vehicleUniqueId
	 */
	public String getVehicleUniqueId() {
		return vehicleUniqueId;
	}

	/**
	 * @param vehicleUniqueId
	 *            the vehicleUniqueId to set
	 */
	public void setVehicleUniqueId(String vehicleUniqueId) {
		this.vehicleUniqueId = vehicleUniqueId;
	}

	/**
	 * @return the pickupLocation
	 */
	public String getPickupLocation() {
		return pickupLocation;
	}

	/**
	 * @param pickupLocation
	 *            the pickupLocation to set
	 */
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	/**
	 * @return the pickupTime
	 */
	public Date getPickupTime() {
		return pickupTime;
	}

	/**
	 * @param pickupTime
	 *            the pickupTime to set
	 */
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	/**
	 * @return the dropOffLocation
	 */
	public String getDropOffLocation() {
		return dropOffLocation;
	}

	/**
	 * @param dropOffLocation
	 *            the dropOffLocation to set
	 */
	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	/**
	 * @return the dropOffTime
	 */
	public Date getDropOffTime() {
		return dropOffTime;
	}

	/**
	 * @param dropOffTime
	 *            the dropOffTime to set
	 */
	public void setDropOffTime(Date dropOffTime) {
		this.dropOffTime = dropOffTime;
	}

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode
	 *            the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the companyDescription
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * @param companyDescription
	 *            the companyDescription to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	/**
	 * @return the rateCategory
	 */
	public byte getRateCategory() {
		return rateCategory;
	}

	/**
	 * @param rateCategory
	 *            the rateCategory to set
	 */
	public void setRateCategory(byte rateCategory) {
		this.rateCategory = rateCategory;
	}

	/**
	 * @return the airConditionIndicator
	 */
	public String getAirConditionIndicator() {
		return airConditionIndicator;
	}

	/**
	 * @param airConditionIndicator
	 *            the airConditionIndicator to set
	 */
	public void setAirConditionIndicator(String airConditionIndicator) {
		this.airConditionIndicator = airConditionIndicator;
	}

	/**
	 * @return the capacity
	 */
	public byte getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity
	 *            the capacity to set
	 */
	public void setCapacity(byte capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @param transmission
	 *            the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	/**
	 * @return the extendedLocation
	 */
	public String getExtendedLocation() {
		return extendedLocation;
	}

	/**
	 * @param extendedLocation
	 *            the extendedLocation to set
	 */
	public void setExtendedLocation(String extendedLocation) {
		this.extendedLocation = extendedLocation;
	}

	/**
	 * @return the counterLocation
	 */
	public String getCounterLocation() {
		return counterLocation;
	}

	/**
	 * @param counterLocation
	 *            the counterLocation to set
	 */
	public void setCounterLocation(String counterLocation) {
		this.counterLocation = counterLocation;
	}

	/**
	 * @return the rateQualifier
	 */
	public String getRateQualifier() {
		return rateQualifier;
	}

	/**
	 * @param rateQualifier
	 *            the rateQualifier to set
	 */
	public void setRateQualifier(String rateQualifier) {
		this.rateQualifier = rateQualifier;
	}

	/**
	 * @return the doorCount
	 */
	public String getDoorCount() {
		return doorCount;
	}

	/**
	 * @param doorCount
	 *            the doorCount to set
	 */
	public void setDoorCount(String doorCount) {
		this.doorCount = doorCount;
	}

	/**
	 * @return the uniqueIdType
	 */
	public byte getUniqueIdType() {
		return uniqueIdType;
	}

	/**
	 * @param uniqueIdType
	 *            the uniqueIdType to set
	 */
	public void setUniqueIdType(byte uniqueIdType) {
		this.uniqueIdType = uniqueIdType;
	}

	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId
	 *            the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the ratePlanCategory
	 */
	public String getRatePlanCategory() {
		return ratePlanCategory;
	}

	/**
	 * @param ratePlanCategory
	 *            the ratePlanCategory to set
	 */
	public void setRatePlanCategory(String ratePlanCategory) {
		this.ratePlanCategory = ratePlanCategory;
	}

	/**
	 * @return the vehicleCategory
	 */
	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	/**
	 * @param vehicleCategory
	 *            the vehicleCategory to set
	 */
	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	/**
	 * @return the vehicleClass
	 */
	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	/**
	 * @param vehicleClass
	 *            the vehicleClass to set
	 */
	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 * @return the guestAllocation
	 */
	public String getGuestAllocation() {
		return guestAllocation;
	}

	/**
	 * @param guestAllocation
	 *            the guestAllocation to set
	 */
	public void setGuestAllocation(String guestAllocation) {
		this.guestAllocation = guestAllocation;
	}

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr
	 *            the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the oldPosnr
	 */
	public String getOldPosnr() {
		return oldPosnr;
	}

	/**
	 * @param oldPosnr
	 *            the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
	}

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @param gateway
	 *            the gateway to set
	 */
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the noOfChildSeat
	 */
	public byte getNoOfChildSeat() {
		return noOfChildSeat;
	}

	/**
	 * @param noOfChildSeat
	 *            the noOfChildSeat to set
	 */
	public void setNoOfChildSeat(byte noOfChildSeat) {
		this.noOfChildSeat = noOfChildSeat;
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
		Vehicle vehicle = (Vehicle) super.clone();
		if (price != null) {
			vehicle.setPrice((Price) price.clone());
		}
		if (searchCriteria != null) {
			vehicle.searchCriteria = (SearchCriteria) searchCriteria.clone();
		}

		return vehicle;
	}
	
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns the String representation of Vehicle object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Vehicle>\n");
		sb.append("vehicleId: " + vehicleId + "\n");
		sb.append("vehicleUniqueId: " + vehicleUniqueId + "\n");
		sb.append("Pickup Location: " + pickupLocation + "\n");
		sb.append("Pickup Time: " + pickupTime + "\n");
		sb.append("Dropoff Location: " + dropOffLocation + "\n");
		sb.append("Dropoff time: " + dropOffTime + "\n");
		sb.append("companyCode: " + companyCode + "\n");
		sb.append("companyDescription: " + companyDescription + "\n");
		sb.append("rateCategory: " + rateCategory + "\n");
		sb.append("airConditionIndicator: " + airConditionIndicator + "\n");
		sb.append("vehicleCategory: " + vehicleCategory + "\n");
		sb.append("vehicleClass: " + vehicleClass + "\n");
		sb.append("capacity: " + capacity + "\n");
		sb.append("description: " + description + "\n");
		sb.append("transmission: " + transmission + "\n");
		sb.append("extendedLocation: " + extendedLocation + "\n");
		sb.append("counterLocation: " + counterLocation + "\n");
		sb.append("rateQualifier: " + rateQualifier + "\n");
		sb.append("doorCount: " + doorCount + "\n");
		sb.append("uniqueIdType: " + uniqueIdType + "\n");
		sb.append("uniqueId: " + uniqueId + "\n");
		sb.append("currency: " + currency + "\n");
		sb.append("ratePlanCategory: " + ratePlanCategory + "\n");
		sb.append("gateway: " + gateway + "\n");
		sb.append("destination: " + destination + "\n");
		sb.append("status: " + status + "\n");
		sb.append("posnr: " + posnr + "\n");
		sb.append("oldPosnr: " + oldPosnr + "\n");
		sb.append("noOfChildSeat: " + noOfChildSeat + "\n");
		sb.append("</Vehicle>");
		return sb.toString();
	}

	private byte vehicleId;
	// Unique identifier code for each vehicle
	private String vehicleUniqueId;
	// Fields for populating the search criteria
	private String pickupLocation;
	private Date pickupTime;
	private String dropOffLocation;
	private Date dropOffTime;
	private String companyCode;
	private String companyDescription;
	private byte rateCategory;
	private String airConditionIndicator;
	private VehicleCategory vehicleCategory;
	private VehicleClass vehicleClass;
	private byte capacity;
	private String description;
	private String transmission;
	private String extendedLocation;
	private String counterLocation;
	private String rateQualifier;
	private String doorCount;
	// Unique ID Type ( eg. 5 - Travel Agency )
	private byte uniqueIdType;
	private String uniqueId;
	private String currency;
	// Rate Plan Category ( Material Group )
	private String ratePlanCategory;
	// Vehicle pricing details
	private Price price;
	private String guestAllocation;
	private SearchCriteria searchCriteria;
	private String gateway;
	private String destination;
	// POSNR numbers for reserved vehicles
	private String posnr;
	private String oldPosnr;
	private String status;

	// Car seat count
	private byte noOfChildSeat;

}