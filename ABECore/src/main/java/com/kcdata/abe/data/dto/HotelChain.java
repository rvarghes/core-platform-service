/*
 * ResortArea.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold hotel chain details
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelChain implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */	
	private static final long serialVersionUID = 7485178912346395885L;
	/**
	 * @return the hotelChainName
	 */
	public String getHotelChainName() {
		return hotelChainName;
	}

	/**
	 * @param hotelChainName
	 *            the hotelChainName to set
	 */
	public void setHotelChainName(String hotelChainName) {
		this.hotelChainName = hotelChainName;
	}

	/**
	 * @return the hotelChainCode
	 */
	public String getHotelChainCode() {
		return hotelChainCode;
	}

	/**
	 * @param hotelChainCode
	 *            the hotelChainCode to set
	 */
	public void setHotelChainCode(String hotelChainCode) {
		this.hotelChainCode = hotelChainCode;
	}

	/**
	 * Returns the String representation of Hotel Chain object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<HotelChain>\n");
		sb.append("hotelChainCode: " + hotelChainCode + "\n");
		sb.append("hotelChainName: " + hotelChainName + "\n");
		sb.append("</HotelChain>");

		return sb.toString();
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

	private String hotelChainCode;
	private String hotelChainName;
	
	
}