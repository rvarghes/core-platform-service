/*
 * SpecialType.java
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
 * Enumerates various special type options
 * @author chazari
 * @version
 */
public enum SpecialType {
	SKEDSPECIALS("S"), CHARTERSPECIALS("C"), HOTELONLYSPECIALS("H");
	
	private String type;
	
	private SpecialType() {
	}
	
	private SpecialType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Method to check whether the requested type is a sked special
	 * @param specialsType
	 * @return "true" if the type is SKEDSPECIALS else "false".
	 */
	public boolean isSkedSpecial() {
		return SKEDSPECIALS.getType().equals(this.getType());
	}
	
	/**
	 * Method to check whether the requested type is a charter special
	 * @param specialsType
	 * @return "true" if the type is CHARTERSPECIALS else "false".
	 */
	public boolean isCharterSpecial() {
		return CHARTERSPECIALS.getType().equals(this.getType());
	}
	
}
