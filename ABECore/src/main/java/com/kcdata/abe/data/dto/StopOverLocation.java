/*
 * StopOver.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold stop over details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class StopOverLocation implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

	/**
	 * @return the stopoverCode
	 */
	public String getStopoverCode() {
		return stopoverCode;
	}

	/**
	 * @param stopoverCode
	 *            the stopoverCode to set
	 */
	public void setStopoverCode(String stopoverCode) {
		this.stopoverCode = stopoverCode;
	}

	/**
	 * @return the stopoverName
	 */
	public String getStopoverName() {
		return stopoverName;
	}

	/**
	 * @param stopoverName
	 *            the stopoverName to set
	 */
	public void setStopoverName(String stopoverName) {
		this.stopoverName = stopoverName;
	}

	/**
	 * @return the carriers
	 */
	public List<Carrier> getCarriers() {
		return carriers;
	}

	/**
	 * @param carriers
	 *            the carriers to set
	 */
	public void setCarriers(List<Carrier> carriers) {
		this.carriers = carriers;
	}

	/**
	 * Returns the String representation of StopOver object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<StopOverLocation>\n");
		sb.append("stopoverCode: " + stopoverCode + "\n");
		sb.append("stopoverName: " + stopoverName + "\n");
		sb.append("carriers: " + carriers + "\n");
		sb.append("</StopOverLocation>");

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
		StopOverLocation location = (StopOverLocation) super.clone();
		if (carriers != null) {
			ArrayList<Carrier> carriersList = new ArrayList<Carrier>();
			for (Carrier carrier : carriers) {
				carriersList.add((Carrier) carrier.clone());
			}
			location.carriers = carriersList;
		}
		return location;
	}

	private String stopoverCode;
	private String stopoverName;
	private List<Carrier> carriers;
}