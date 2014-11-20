/*
 * FlightType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold the Flight Type
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public enum FlightType {
	
	CHARTER('C', 'C'), PUBLISHED('S','P'), CONTRACTED('S','C');
	
	private char type;
	private char code;

	/**
	 * Default constructor
	 */
	private FlightType() {
	}
	
	/**
	 * Overloaded constructor for creating the FlightType
	 * @param type
	 */
	private FlightType(char type, char code) {
		this.type = type;
		this.code = code;
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
		return this.type == CHARTER.type && this.code == CHARTER.code;
	}

	/**
	 * Method to check whether the instance is PUBLISHED or not
	 *
	 * @return "true" for charter and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isPublished()
	{
		return this.type == PUBLISHED.type && this.code == PUBLISHED.code;
	}
	
	/**
	 * Method to check whether the instance is BULK or not
	 *
	 * @return "true" for charter and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isBulk()
	{
		return this.type == CONTRACTED.type && this.code == CONTRACTED.code;
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

	/**
	 * Method to return the code value
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public char getCode() {
		return this.code;
	}

}

