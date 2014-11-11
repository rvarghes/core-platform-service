/*
 * MultiDestPackagesRequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 14, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.request;

import java.util.List;

import com.kcdata.abe.framework.request.ABERequest;

/**
 * Multi destination packages request class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class MultiDestPackagesRequest extends ABERequest {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1734692044099062512L;

	/**
	 * List of flight requests
	 */
	private List<FlightsRequest> flightsRequestList;

	/**
	 * List of hotels requests
	 */
	private List<HotelsRequest> hotelsRequestList;
	
	/**
	 * List of vehicles requests
	 */
	private List<VehiclesRequest> vehiclesRequestList;

	/**
	 * @return the flightsRequestList
	 */
	public List<FlightsRequest> getFlightsRequestList() {
		return flightsRequestList;
	}

	/**
	 * @param flightsRequestList
	 *            the flightsRequestList to set
	 */
	public void setFlightsRequestList(List<FlightsRequest> flightsRequestList) {
		this.flightsRequestList = flightsRequestList;
	}

	/**
	 * @return the hotelsRequestList
	 */
	public List<HotelsRequest> getHotelsRequestList() {
		return hotelsRequestList;
	}

	/**
	 * @param hotelsRequestList
	 *            the hotelsRequestList to set
	 */
	public void setHotelsRequestList(List<HotelsRequest> hotelsRequestList) {
		this.hotelsRequestList = hotelsRequestList;
	}

	/**
	 * @return the vehiclesRequestList
	 */
	public List<VehiclesRequest> getVehiclesRequestList() {
		return vehiclesRequestList;
	}

	/**
	 * @param vehiclesRequestList
	 *            the vehiclesRequestList to set
	 */
	public void setVehiclesRequestList(List<VehiclesRequest> vehiclesRequestList) {
		this.vehiclesRequestList = vehiclesRequestList;
	}
}
