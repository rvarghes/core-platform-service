/*
 * Destination.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 * Jun 30, 2009  nvittal	  Added a list object to hold services offered
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold destination details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Destination implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 7510430915751556107L;

	public Destination() {
		this.airDestination = false;
		this.hotelDestination = false;
		this.vehicleDestination = false;
	}

	/**
	 * @return the airDestination
	 */
	public boolean isAirDestination() {
		return airDestination;
	}

	/**
	 * @param airDestination
	 *            the airDestination to set
	 */
	public void setAirDestination(boolean airDestination) {
		this.airDestination = airDestination;
	}

	/**
	 * @return the hotelDestination
	 */
	public boolean isHotelDestination() {
		return hotelDestination;
	}

	/**
	 * @param hotelDestination
	 *            the hotelDestination to set
	 */
	public void setHotelDestination(boolean hotelDestination) {
		this.hotelDestination = hotelDestination;
	}

	/**
	 * @return the vehicleDestination
	 */
	public boolean isVehicleDestination() {
		return vehicleDestination;
	}

	/**
	 * @param vehicleDestination
	 *            the vehicleDestination to set
	 */
	public void setVehicleDestination(boolean vehicleDestination) {
		this.vehicleDestination = vehicleDestination;
	}

	/**
	 * @return the airportCode
	 */
	public String getAirportCode() {
		return airportCode;
	}

	/**
	 * @param airportCode
	 *            the airportCode to set
	 */
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	/**
	 * @return the airportName
	 */
	public String getAirportName() {
		return airportName;
	}

	/**
	 * @param airportName
	 *            the airportName to set
	 */
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode
	 *            the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode
	 *            the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return the services
	 */
	public List<DestinationService> getServices() {
		return services;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(List<DestinationService> services) {
		this.services = services;
	}

	/**
	 * @return the nearbyAirports
	 */
	public List<String> getNearbyAirports() {
		return nearbyAirports;
	}

	/**
	 * @param nearbyAirports the nearbyAirports to set
	 */
	public void setNearbyAirports(List<String> nearbyAirports) {
		this.nearbyAirports = nearbyAirports;
	}
	/**
	 * @return the externalDestination
	 */
	public boolean isExternalDestination() {
		return externalDestination;
	}

	/**
	 * @param externalDestination the externalDestination to set
	 */
	public void setExternalDestination(boolean externalDestination) {
		this.externalDestination = externalDestination;
	}

	/**
	 * Equals method implementation for destination object
	 *
	 * @param obj
	 * @return boolean
	 *
	 * @see
	 * @since
	 */
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Destination))
			return false;
		Destination destination = (Destination) obj;
		if (this.getAirportCode().equalsIgnoreCase(destination.getAirportCode()))
			return true;

			return false;
	}
	/**
	 * Return the String representation of Destination object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Destination>\n");
		sb.append("airportCode: " + airportCode + "\n");
		sb.append("airportName: " + airportName + "\n");
		sb.append("cityName: " + cityName + "\n");
		sb.append("stateCode: " + stateCode + "\n");
		sb.append("countryCode: " + countryCode + "\n");
		sb.append("air destination flag: " + airDestination + "\n");
		sb.append("hotel destination flag: " + hotelDestination + "\n");
		sb.append("car destination flag: " + vehicleDestination + "\n");
		sb.append("services: " + services + "\n");
		sb.append("nearbyAirports: "+nearbyAirports+"\n");
		sb.append("externalDestination: "+externalDestination+"\n");
		sb.append("</Destination>");

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
		Destination destination = (Destination) super.clone();
		if(services != null) {
			ArrayList<DestinationService> dServices = new ArrayList<DestinationService>();
			for(DestinationService service: services) {
				dServices.add((DestinationService) service.clone());
			}
			destination.services = dServices;
		}
		return destination;
	}
	
	private String airportCode;
	private String airportName;
	private String cityName;
	private String stateCode;
	private String countryCode;
	private String languageCode;
	// These three flags are used only in case of destinations
	// Indicates if destination has air
	private boolean airDestination;
	// Indicates if destination has hotel
	private boolean hotelDestination;
	// Indicates if destination has car
	private boolean vehicleDestination;
	// Holds list of services offered at the destination
	private List<DestinationService> services;
	// List of near by airport codes
	private List<String> nearbyAirports;
		// Indicates if destination is external to Apple
	private boolean externalDestination;	
	
	private String countryDescription;	
	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}
}