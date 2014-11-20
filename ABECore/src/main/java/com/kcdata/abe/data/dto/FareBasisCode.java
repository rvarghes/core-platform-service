/*
 * FareBasisCode.java
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

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the fare basis code information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FareBasisCode implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2905516902852750769L;

	private String adultCode;
	private String childCode;
	private String infantCode;

	/**
	 * @return the adultCode
	 */
	public String getAdultCode() {
		return adultCode;
	}

	/**
	 * @param adultCode
	 *            the adultCode to set
	 */
	public void setAdultCode(String adultCode) {
		this.adultCode = adultCode;
	}

	/**
	 * @return the childCode
	 */
	public String getChildCode() {
		return childCode;
	}

	/**
	 * @param childCode
	 *            the childCode to set
	 */
	public void setChildCode(String childCode) {
		this.childCode = childCode;
	}

	/**
	 * @return the infantCode
	 */
	public String getInfantCode() {
		return infantCode;
	}

	/**
	 * @param infantCode
	 *            the infantCode to set
	 */
	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
