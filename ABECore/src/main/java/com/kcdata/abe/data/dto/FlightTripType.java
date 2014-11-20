/*
 * FlightTripType.java
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
 * Enum to hold the Flight Trip Type
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public enum FlightTripType {
	
	ROUNDTRIP("B"), ONEWAY("O"), ANCHOR("A");

	/**
	 * Default constructor
	 */
	private FlightTripType() {		
	}
	
	/**
	 * Overloaded constructor for creating the FlightTripType
	 * @param type
	 */
	private FlightTripType(String type) {
		this.type = type;
	}
	
	private String type;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method to check whether the requested type is a RoundTrip
	 *
	 * @param tripType
	 * @return "true" if the type is ROUNDTRIP else "false".
	 *
	 * @see
	 * @since
	 */
	public boolean isRoundTrip()
	{
		return ROUNDTRIP.getType().equals(this.getType());
	}
	
	/**
	 * Method to check whether the requested type is a Oneway
	 *
	 * @param tripType
	 * @return "true" if the type is ONEWAY else "false".
	 *
	 * @see
	 * @since
	 */
	public boolean isOnewayTrip()
	{
		return ONEWAY.getType().equals(this.getType());
	}

	/**
	 * Method to check whether the requested type is a AnchorTrip
	 *
	 * @param tripType
	 * @return "true" if the type is ANCHOR else "false".
	 *
	 * @see
	 * @since
	 */
	public boolean isAnchorTrip()
	{
		return ANCHOR.getType().equals(this.getType());
	}
	
    /**
     * Method to retrieve the {@link FlightTripType} by name
     * @param name
     * @return
     */
    public static FlightTripType fromValue(String name) {
        return valueOf(name);
    }
	
}
