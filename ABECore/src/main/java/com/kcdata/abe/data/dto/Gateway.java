/*
 * GatewayDestination.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold gateway details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Gateway implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

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
	 * @return the nearbyAirports
	 */
	public List<String> getNearbyAirports() {
		return nearbyAirports;
	}

	/**
	 * @param nearbyAirports
	 *            the nearbyAirports to set
	 */
	public void setNearbyAirports(List<String> nearbyAirports) {
		this.nearbyAirports = nearbyAirports;
	}

	/**
	 * Equals method implementation for gateway object
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
		if (!(obj instanceof Gateway))
			return false;
		Gateway gateway = (Gateway) obj;
		if (this.getAirportCode().equalsIgnoreCase(gateway.getAirportCode()))
			return true;

		return false;
	}

	/**
	 * Returns the String representation of Gateway object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Gateway>\n");
		sb.append("airportCode: " + airportCode + "\n");
		sb.append("airportName: " + airportName + "\n");
		sb.append("cityName: " + cityName + "\n");
		sb.append("stateCode: " + stateCode + "\n");
		sb.append("countryCode: " + countryCode + "\n");
		sb.append("nearbyAirports: " + nearbyAirports + "\n");
		sb.append("</Gateway>");

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
		return super.clone();
	}

	
	private String airportCode;
	private String airportName;
	private String cityName;
	private String stateCode;
	private String countryCode;
	private String countryDescription;	
	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}


	private String languageCode;
	// List of near by airport codes
	private List<String> nearbyAirports;
}