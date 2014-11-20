/*
 * ResortAreaResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * June 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.ResortArea;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for resort area response
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ResortAreaResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 534203163004566807L;
	
	/**
	 * @return the resortAreas
	 */
	public List<ResortArea> getResortAreas() {
		return resortAreas;
	}

	/**
	 * @param resortAreas the resortAreas to set
	 */
	public void setResortAreas(List<ResortArea> resortAreas) {
		this.resortAreas = resortAreas;
	}

	/**
	 * Field to hold list of resort areas
	 */
	private List<ResortArea> resortAreas;
}
