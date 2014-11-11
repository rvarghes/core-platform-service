/*
 * Package.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 25, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.List;

/**
 * Class to hold the package details Retrieve packages usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Package extends BasePackage {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4756896849794214242L;

	/**
	 * Flight Component
	 */
	private TripFlight selectedFlight;

	/**
	 * Hotel Component
	 */
	private Hotel selectedHotel;

	/**
	 * Vehicle component
	 */
	private Vehicle selectedVehicle;

	//IGT-A--Issue # 3620601---START
	private List<GroupedTripFlight> groupedTripFlight;
	private List<TripFlight> displayTripFlightList;
	//IGT-A--Issue # 3620601---END
	
	/**
	 * @return the selectedFlight
	 */
	public TripFlight getSelectedFlight() {
		return selectedFlight;
	}

	/**
	 * @param selectedFlight
	 *            the selectedFlight to set
	 */
	public void setSelectedFlight(TripFlight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

	/**
	 * @return the selectedHotel
	 */
	public Hotel getSelectedHotel() {
		return selectedHotel;
	}

	/**
	 * @param selectedHotel
	 *            the selectedHotel to set
	 */
	public void setSelectedHotel(Hotel selectedHotel) {
		this.selectedHotel = selectedHotel;
	}

	/**
	 * @return the selectedVehicle
	 */
	public Vehicle getSelectedVehicle() {
		return selectedVehicle;
	}

	/**
	 * @param selectedVehicle
	 *            the selectedVehicle to set
	 */
	public void setSelectedVehicle(Vehicle selectedVehicle) {
		this.selectedVehicle = selectedVehicle;
	}
	
	//IGT-A--Issue # 3620601---START
	/**
	 * @return the groupedTripFlight
	 */
	public List<GroupedTripFlight> getGroupedTripFlight() {
		return groupedTripFlight;
	}

	/**
	 * @param groupedTripFlight the groupedTripFlight to set
	 */
	public void setGroupedTripFlight(List<GroupedTripFlight> groupedTripFlight) {
		this.groupedTripFlight = groupedTripFlight;
	}

	/**
	 * @return the displayTripFlightList
	 */
	public List<TripFlight> getDisplayTripFlightList() {
		return displayTripFlightList;
	}

	/**
	 * @param displayTripFlightList the displayTripFlightList to set
	 */
	public void setDisplayTripFlightList(List<TripFlight> displayTripFlightList) {
		this.displayTripFlightList = displayTripFlightList;
	}
	//IGT-A--Issue # 3620601---END

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
		Package availablePackage = (Package) super.clone();
		if(selectedFlight != null) {
			availablePackage.selectedFlight = (TripFlight) selectedFlight.clone();				
		}
		if(selectedHotel != null) {
			availablePackage.selectedHotel = (Hotel) selectedHotel.clone();			
		}
		if(selectedVehicle != null) {
			availablePackage.selectedVehicle = (Vehicle) selectedVehicle.clone();
		}
		return availablePackage;
	}	
}
