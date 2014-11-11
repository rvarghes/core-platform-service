/*
 * SpecialRequestType.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 21, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enumerates various special request type options
 *
 * @author chazari
 * @version
 */
public enum SpecialRequestType {
	ALLSPECIALS("ALL"), ONESPECIAL("AVL");
	
	private String type;
	
	/**
	 * Default constructor
	 */
	private SpecialRequestType() {
	}
	
	/**
	 * Overloaded to a specific type
	 * @param type
	 */
	private SpecialRequestType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method to check whether the requested type is a All specials
	 * @param specialsType
	 * @return "true" if the type is ALLSPECIALS else "false".
	 */
	public boolean allSpecialsRequested() {
		return ALLSPECIALS.getType().equals(this.getType());
	}
}
