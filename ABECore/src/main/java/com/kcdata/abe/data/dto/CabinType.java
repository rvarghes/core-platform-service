/*
 * CabinType.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold the Cabin Type
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public enum CabinType {

	FIRST('F'), BUSINESS('C'), ECONOMY('Y'), PREMIUM_ECONOMY('W');
	
	private char type;

	/**
	 * Default constructor
	 */
	private CabinType() {
	}
	
	/**
	 * Overloaded constructor for creating the CabinType
	 * @param type
	 */
	private CabinType(char type) {
		this.type = type;
	}
		
	/**
	 * Method to check whether the instance is FIRST class or not
	 *
	 * @return "true" for first class and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isFirstClass()
	{
		return this.type == FIRST.type;
	}

	/**
	 * Method to check whether the instance is BUSINESS or not
	 *
	 * @return "true" for business class and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isBusinessClass()
	{
		return this.type == BUSINESS.type;
	}
	
	
	
	/**
	 * Method to check whether the instance is ECONOMY or not
	 *
	 * @return "true" for ECONOMY class and "false" otherwise
	 *
	 * @see
	 * @since
	 */
	public boolean isEconomyClass()
	{
		return this.type == ECONOMY.type;
	}
	
	/**
	 * Method to return the type value
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public boolean isPREMIUM_ECONOMYClass()
	{
		return this.type == PREMIUM_ECONOMY.type;
	}
	public char getType() {
		return this.type;
	}

    /**
     * Method to retrieve the CabinType by name
     * @param v
     * @return
     */
    public static CabinType fromValue(String name) {
        return valueOf(name);
    }
}
