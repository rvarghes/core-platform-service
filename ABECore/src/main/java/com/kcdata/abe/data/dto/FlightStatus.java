/*
 * FlightStatus.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold the flight status values
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public enum FlightStatus {

	AVAILABLE('A'), ONREQUEST('R'), NOTAVAILABLE('N');

	private char status;

	/**
	 * Default constructor
	 */
	private FlightStatus() {
	}

	/**
	 * Overloaded constructor
	 * @param status
	 */
	private FlightStatus(char status) {
		this.status = status;
	}

	/**
	 * Method to retrieve the status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public char getStatus() {
		return this.status;
	}

	/**
	 * Method to check whether the Flight is available for booking
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isAvaiable() {
		return this.status == AVAILABLE.status;
	}

	/**
	 * Method to check whether the Flight is available on Request
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isOnRequest() {
		return this.status == ONREQUEST.status;
	}

	/**
	 * Method to check whether the Flight is not available for booking
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isNotAvailable() {
		return this.status == NOTAVAILABLE.status;
	}

}
