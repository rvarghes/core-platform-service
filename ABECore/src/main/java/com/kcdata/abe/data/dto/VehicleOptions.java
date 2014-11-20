/*
 * VehicleOptions.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 9, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold car search options
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class VehicleOptions implements ABEDto {

	/**
	 * Default serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1668197649900317205L;

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
	 * @return the pickupDateTime
	 */
	public Date getPickupDateTime() {
		return pickupDateTime;
	}

	/**
	 * @param pickupDateTime
	 *            the pickupDateTime to set
	 */
	public void setPickupDateTime(Date pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}

	/**
	 * @return the dropoffLocation
	 */
	public String getDropoffLocation() {
		return dropoffLocation;
	}

	/**
	 * @param dropoffLocation
	 *            the dropoffLocation to set
	 */
	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	/**
	 * @return the dropoffDateTime
	 */
	public Date getDropoffDateTime() {
		return dropoffDateTime;
	}

	/**
	 * @param dropoffDateTime
	 *            the dropoffDateTime to set
	 */
	public void setDropoffDateTime(Date dropoffDateTime) {
		this.dropoffDateTime = dropoffDateTime;
	}

	private String pickupLocation;
	private Date pickupDateTime;
	private String dropoffLocation;
	private Date dropoffDateTime;
	private String vendorCode;
	private String vehicleClass;

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
	 * @return the vehicleClass
	 */
	public String getVehicleClass() {
		return vehicleClass;
	}

	/**
	 * @param vehicleClass
	 *            the vehicleClass to set
	 */
	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
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