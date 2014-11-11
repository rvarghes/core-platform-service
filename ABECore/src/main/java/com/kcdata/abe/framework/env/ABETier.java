/*
 * ABETier.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.env;

/**
 * This interface defines the various layers in the system Enable to track the
 * exact source layer for errors.
 * N/A for any specific usecase 
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */

public enum ABETier {
	APPLICATION("APPLICATION TIER"), BUSINESS("BUSINESS TIER"), DATA(
			"DATA TIER"), FRAMEWORK("FRAMEWORK TIER"), PRESENTATION(
			"PRESENTATION TIER"), ABAP("ABAP TIER"), NDS("NDS TIER"), UNDEFINED(
			"UNDEFINED");

	/**
	 * Field to hold the tier name
	 */
	private final String tier;

	public String getTier() {
		return tier;
	}

	/**
	 * 
	 * @param tier
	 */
	private ABETier(String tier) {
		this.tier = tier;
	}

}
