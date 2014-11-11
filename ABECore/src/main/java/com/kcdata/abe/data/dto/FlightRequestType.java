/*
 * FlightRequestType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 27, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold flight request type
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public enum FlightRequestType {
	CHARTER('C'), SCHEDULED('S');
	
	private char type;

	/**
	 * Default constructor
	 */
	private FlightRequestType() {
	}
	
	/**
	 * Overloaded constructor for creating the FlightRequestType
	 * @param type
	 */
	private FlightRequestType(char type) {
		this.type = type;
	}
		
	/**
	 * Method to check whether the instance is CHARTER or not
	 *
	 * @return "true" for charter and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isCharter()
	{
		return this.type == CHARTER.type;
	}

	/**
	 * Method to check whether the instance is SCHEDULED or not
	 *
	 * @return "true" for charter and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isScheduled()
	{
		return this.type == SCHEDULED.type;
	}
		
	/**
	 * Method to return the type value
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public char getType() {
		return this.type;
	}

}
