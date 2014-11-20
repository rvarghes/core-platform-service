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
 * Transfer object to hold resort area details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ResortArea implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

	/**
	 * @return the resortAreaName
	 */
	public String getResortAreaName() {
		return resortAreaName;
	}

	/**
	 * @param resortAreaName
	 *            the resortAreaName to set
	 */
	public void setResortAreaName(String resortAreaName) {
		this.resortAreaName = resortAreaName;
	}

	/**
	 * @return the resortAreaCode
	 */
	public String getResortAreaCode() {
		return resortAreaCode;
	}

	/**
	 * @param resortAreaCode
	 *            the resortAreaCode to set
	 */
	public void setResortAreaCode(String resortAreaCode) {
		this.resortAreaCode = resortAreaCode;
	}

	/**
	 * Returns the String representation of Resort Area object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<ResortArea>\n");
		sb.append("resortAreaCode: " + resortAreaCode + "\n");
		sb.append("resortAreaName: " + resortAreaName + "\n");
		sb.append("</ResortArea>");

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

	private String resortAreaCode;
	private String resortAreaName;
}