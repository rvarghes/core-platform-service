/*
 * AgeCode.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 29, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;


/**
 * Enumeration for Age Qualifying code
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public enum AgeCode {
	LAPCHILD(50, 'L'), INFANT(7, 'I'), CHILD(8, 'C'), ADULT(10, 'A'), SENIOR(11, 'S');

	public int getAgeCode() {
		return age;
	}

	public boolean isLapChild() {
		return (LAPCHILD.getAgeCode() == this.getAgeCode());
	}

	public boolean isInfant() {
		return (INFANT.getAgeCode() == this.getAgeCode());
	}

	public boolean isChild() {
		return (CHILD.getAgeCode() == this.getAgeCode());
	}

	public boolean isAdult() {
		return (ADULT.getAgeCode() == this.getAgeCode());
	}

	public boolean isSenior() {
		return (SENIOR.getAgeCode() == this.getAgeCode());
	}
	
	public char getPaxTypeCode() {
		return this.paxTypeCode;
	}

	/**
	 * Overloaded constructor with parameter
	 * 
	 * @param age
	 */
	private AgeCode(int age, char paxTypeCode ) {
		this.age = age;
		this.paxTypeCode = paxTypeCode;
	}

	/**
	 * Default constructor
	 */
	private AgeCode() {
	}
	
	
    /**
     * Method to retrieve the AgeCode by name
     * @param v
     * @return
     */
    public static AgeCode fromValue(String name) {
        return valueOf(name);
    }


	/**
	 * Field to hold the age
	 */
	private int age;
	private char paxTypeCode;
}