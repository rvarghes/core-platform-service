/*
 * VehiclesResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 * Sep 24, 2009  hguntupa	  Added new methods for vehicle packages availability
 * Oct 8, 2009	 hguntupa	  Added Vendor details
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleVendorDetails;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Vehicle response class
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class VehiclesResponse extends ABEResponse {

	/**
	 * Default generated serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6548647894545765568L;

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles
	 *            the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the vendorDetails
	 */
	public List<VehicleVendorDetails> getVendorDetails() {
		return vendorDetails;
	}

	/**
	 * @param vendorDetails
	 *            the vendorDetails to set
	 */
	public void setVendorDetails(List<VehicleVendorDetails> vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

	/**
	 * @return the sapVehicleAvailabilityList
	 */
	public Yst_Ota_Veh_AvailabilityType_List getSapVehicleAvailabilityList() {
		return sapVehicleAvailabilityList;
	}

	/**
	 * @param sapVehicleAvailabilityList
	 *            the sapVehicleAvailabilityList to set
	 */
	public void setSapVehicleAvailabilityList(
			Yst_Ota_Veh_AvailabilityType_List sapVehicleAvailabilityList) {
		this.sapVehicleAvailabilityList = sapVehicleAvailabilityList;
	}

	private List<Vehicle> vehicles;
	private List<VehicleVendorDetails> vendorDetails;

	/*
	 * For packages, we will be calling the multiple threads to retrieve the
	 * availability BAPI and then consolidate them in the form of packages. As
	 * we are passing the availability response(sap structures) to package
	 * consolidation, we would like to reduce the time of parsing SAP structures
	 * to JAVA DTO objects and from DTO objects back to SAP structures during
	 * consolidation. So, we will be caching the availability SAP structures and
	 * passing the same to consolidation BAPI. The below fields helps us to
	 * cache the availability response
	 */
	private Yst_Ota_Veh_AvailabilityType_List sapVehicleAvailabilityList;
}