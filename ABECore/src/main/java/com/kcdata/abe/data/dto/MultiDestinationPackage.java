/*
 * MultiDestinationPackage.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class for multi-destination packages
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class MultiDestinationPackage extends BasePackage {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4227709159068475564L;

	/**
	 * Selected flights
	 */
	List<TripFlight> selectedFlights;

	/**
	 * Selected Hotels
	 */
	List<Hotel> selectedHotels;

	/**
	 * Selected Vehicles
	 */
	List<Vehicle> selectedVehicles;

	/**
	 * Change Position. Used during the change components workflow
	 */
	byte changePosition;

	/**
	 * @return the selectedFlights
	 */
	public List<TripFlight> getSelectedFlights() {
		return selectedFlights;
	}

	/**
	 * @param selectedFlights
	 *            the selectedFlights to set
	 */
	public void setSelectedFlights(List<TripFlight> selectedFlights) {
		this.selectedFlights = selectedFlights;
	}

	/**
	 * @return the selectedHotels
	 */
	public List<Hotel> getSelectedHotels() {
		return selectedHotels;
	}

	/**
	 * @param selectedHotels
	 *            the selectedHotels to set
	 */
	public void setSelectedHotels(List<Hotel> selectedHotels) {
		this.selectedHotels = selectedHotels;
	}

	/**
	 * @return the selectedVehicles
	 */
	public List<Vehicle> getSelectedVehicles() {
		return selectedVehicles;
	}

	/**
	 * @param selectedVehicles
	 *            the selectedVehicles to set
	 */
	public void setSelectedVehicles(List<Vehicle> selectedVehicles) {
		this.selectedVehicles = selectedVehicles;
	}

	/**
	 * @return the changePosition
	 */
	public byte getChangePosition() {
		return changePosition;
	}

	/**
	 * @param changePosition
	 *            the changePosition to set
	 */
	public void setChangePosition(byte changePosition) {
		this.changePosition = changePosition;
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
		MultiDestinationPackage availablePackage = (MultiDestinationPackage) super
				.clone();
		if (selectedFlights != null) {
			ArrayList<TripFlight> flightsList = new ArrayList<TripFlight>();
			for (TripFlight flight : selectedFlights) {
				flightsList.add((TripFlight) flight.clone());
			}
			availablePackage.setSelectedFlights(flightsList);
		}
		if (selectedHotels != null) {
			ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
			for (Hotel hotel : selectedHotels) {
				hotelsList.add((Hotel) hotel.clone());
			}
			availablePackage.setSelectedHotels(hotelsList);
		}
		if (selectedVehicles != null) {
			ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
			for (Vehicle vehicle : selectedVehicles) {
				vehiclesList.add((Vehicle) vehicle.clone());
			}
			availablePackage.setSelectedVehicles(vehiclesList);
		}
		return availablePackage;
	}
}
