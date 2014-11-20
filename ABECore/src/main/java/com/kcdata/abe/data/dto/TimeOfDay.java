/*
 * TimeOfDay.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 24, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enum to hold the time of the day
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public enum TimeOfDay {

	MIDNIGHT("MN"), EARLY_MORNING("EM"), MORNING("M"), AFTERNOON("A"), EVENING(
			"E"), NIGHT("N");

	private String code;

	/**
	 * Default Constructor
	 */
	private TimeOfDay() {
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param code
	 */
	private TimeOfDay(String code) {
		this.code = code;
	}

	/**
	 * Method to return the code
	 * 
	 * @see
	 * @since
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Method to test whether the given instance is MIDNIGHT instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isMidNight() {
		return this.getCode().equals(MIDNIGHT.getCode());
	}

	/**
	 * Method to test whether the given instance is EARLY_MORNING instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isEarlyMorning() {
		return this.getCode().equals(EARLY_MORNING.getCode());
	}

	/**
	 * Method to test whether the given instance is MORNING instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isMorning() {
		return this.getCode().equals(MORNING.getCode());
	}

	/**
	 * Method to test whether the given instance is AFTERNOON instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isAfterNoon() {
		return this.getCode().equals(AFTERNOON.getCode());
	}

	/**
	 * Method to test whether the given instance is EVENING instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isEvening() {
		return this.getCode().equals(EVENING.getCode());
	}

	/**
	 * Method to test whether the given instance is NIGHT instance
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean isNight() {
		return this.getCode().equals(NIGHT.getCode());
	}
	
    /**
     * Method to retrieve the {@link TimeOfDay} by name
     * @param v
     * @return
     */
    public static TimeOfDay fromValue(String name) {
        return valueOf(name);
    }	
}
