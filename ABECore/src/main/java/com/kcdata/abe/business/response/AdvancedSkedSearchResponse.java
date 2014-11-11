/*
 * AdvancedSkedSearchResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * June 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.StopOver;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class for advanced SKED search response
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AdvancedSkedSearchResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 534203163004566807L;

	/**
	 * Field to hold list of flight carriers
	 */
	private List<Carrier> carriers;

	/**
	 * Field to hold list of stop overs
	 */
	private List<StopOver> stopovers;

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
	 * @return the stopovers
	 */
	public List<StopOver> getStopovers() {
		return stopovers;
	}

	/**
	 * @param stopovers
	 *            the stopovers to set
	 */
	public void setStopovers(List<StopOver> stopovers) {
		this.stopovers = stopovers;
	}

}
