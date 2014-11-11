/*
 * NearbyAirport.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold near by airport details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class NearbyAirport implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3168175940640987051L;

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(String client) {
		this.client = client;
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
	 * @return the nearbyCode
	 */
	public String getNearbyCode() {
		return nearbyCode;
	}

	/**
	 * @param nearbyCode
	 *            the nearbyCode to set
	 */
	public void setNearbyCode(String nearbyCode) {
		this.nearbyCode = nearbyCode;
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

	private String client;
	private String airportCode;
	private String nearbyCode;
}
