/*
 * PackagesResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.FlightOffer;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Package Response class Class to hold the package response
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PackagesResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7030411714435439662L;

	/**
	 * Field to hold the flights
	 */
	private List<TripFlight> flightsList;

	/**
	 * Field to hold hotels
	 */
	private List<Hotel> hotelList;

	/**
	 * Field to hold destination based services
	 */
	private List<Destination> destinationsList;

	/**
	 * Field to hold vehicles list
	 */
	private List<Vehicle> vehiclesList;
	
	/**
	 * Field to hold the Package
	 */
	Package availablePackage;
	//Added as indicator of sold out charter flight
	private boolean soldOutFlights;

	private FlightOffer flightOffer;

	/**
	 * @return the flightsList
	 */
	public List<TripFlight> getFlightsList() {
		return flightsList;
	}

	/**
	 * @param flightsList
	 *            the flightsList to set
	 */
	public void setFlightsList(List<TripFlight> flightsList) {
		this.flightsList = flightsList;
	}

	/**
	 * @return the hotelList
	 */
	public List<Hotel> getHotelList() {
		return hotelList;
	}

	/**
	 * @param hotelList
	 *            the hotelList to set
	 */
	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	/**
	 * @return the destinationsList
	 */
	public List<Destination> getDestinationsList() {
		return destinationsList;
	}

	/**
	 * @param destinationsList
	 *            the destinationsList to set
	 */
	public void setDestinationsList(List<Destination> destinationsList) {
		this.destinationsList = destinationsList;
	}

	/**
	 * @return the vehiclesList
	 */
	public List<Vehicle> getVehiclesList() {
		return vehiclesList;
	}

	/**
	 * @param vehiclesList
	 *            the vehiclesList to set
	 */
	public void setVehiclesList(List<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	/**
	 * @return the availablePackage
	 */
	public Package getAvailablePackage() {
		return availablePackage;
	}

	/**
	 * @param availablePackage the availablePackage to set
	 */
	public void setAvailablePackage(Package availablePackage) {
		this.availablePackage = availablePackage;
	}

	/**
	 * @return the soldOutFlights
	 */
	public boolean isSoldOutFlights() {
		return soldOutFlights;
	}

	/**
	 * @param soldOutFlights the soldOutFlights to set
	 */
	public void setSoldOutFlights(boolean soldOutFlights) {
		this.soldOutFlights = soldOutFlights;
	}

	/**
	 * @return the flightOffer
	 */
	public FlightOffer getFlightOffer() {
		return flightOffer;
	}

	/**
	 * @param flightOffer the flightOffer to set
	 */
	public void setFlightOffer(FlightOffer flightOffer) {
		this.flightOffer = flightOffer;
	}
	
}
