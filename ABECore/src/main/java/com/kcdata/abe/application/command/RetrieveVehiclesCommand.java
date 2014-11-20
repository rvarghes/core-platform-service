/*
 * RetrieveVehiclesCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 * Oct 8, 2009   hguntupa	  Added Vehicle Vendor details
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.List;

import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.dto.VehicleVendorDetails;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Command class for vehicle availability
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class RetrieveVehiclesCommand extends ABECommandBase {

	/**
	 * Default generated serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3219208575083841968L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveVehiclesCommandHandler";

	/**
	 * Method to retrieve the command handler name
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
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
	 * @return the vedorDetails
	 */
	public List<VehicleVendorDetails> getVendorDetails() {
		return vendorDetails;
	}

	/**
	 * @param vedorDetails
	 *            the vedorDetails to set
	 */
	public void setVendorDetails(List<VehicleVendorDetails> vedorDetails) {
		this.vendorDetails = vedorDetails;
	}

	/**
	 * Search criteria for retrieving vehicles
	 */
	private SearchCriteria searchCriteria;

	/**
	 * List of vehicles
	 */
	private List<Vehicle> vehicles;

	/**
	 * List of Vehicle Vendor details
	 */
	private List<VehicleVendorDetails> vendorDetails;
}