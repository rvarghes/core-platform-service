/*
 * BasePackage.java
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

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Base class for the packages
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public abstract class BasePackage implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2508656715691761829L;

	/**
	 * Search criteria
	 */
	private SearchCriteria searchCriteria;

	/**
	 * Options for selection
	 */
	private List<TripFlight> flightOptions;
	private List<Hotel> hotelOptions;
	private List<Vehicle> vehicleOptions;
	private List<Destination> destinationServices;

	/**
	 * Package price
	 */
	private Price price;
	
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
	 * @return the flightOptions
	 */
	public List<TripFlight> getFlightOptions() {
		return flightOptions;
	}

	/**
	 * @param flightOptions
	 *            the flightOptions to set
	 */
	public void setFlightOptions(List<TripFlight> flightOptions) {
		this.flightOptions = flightOptions;
	}

	/**
	 * @return the hotelOptions
	 */
	public List<Hotel> getHotelOptions() {
		return hotelOptions;
	}

	/**
	 * @param hotelOptions
	 *            the hotelOptions to set
	 */
	public void setHotelOptions(List<Hotel> hotelOptions) {
		this.hotelOptions = hotelOptions;
	}

	/**
	 * @return the vehicleOptions
	 */
	public List<Vehicle> getVehicleOptions() {
		return vehicleOptions;
	}

	/**
	 * @param vehicleOptions
	 *            the vehicleOptions to set
	 */
	public void setVehicleOptions(List<Vehicle> vehicleOptions) {
		this.vehicleOptions = vehicleOptions;
	}

	/**
	 * @return the destinationServices
	 */
	public List<Destination> getDestinationServices() {
		return destinationServices;
	}

	/**
	 * @param destinationServices
	 *            the destinationServices to set
	 */
	public void setDestinationServices(List<Destination> destinationServices) {
		this.destinationServices = destinationServices;
	}

	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Price price) {
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
		BasePackage availablePackage = (BasePackage) super.clone();
		if(searchCriteria != null) {
			availablePackage.searchCriteria = (SearchCriteria) searchCriteria.clone();
		}
		if(price != null) {
			availablePackage.price = (Price) price.clone();
		}
		return availablePackage;
	}		

}
