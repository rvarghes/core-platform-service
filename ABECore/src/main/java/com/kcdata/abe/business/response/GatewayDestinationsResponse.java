/*
 * GatewayDestinationsResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.data.dto.NearbyAirport;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Gateway destination response class
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class GatewayDestinationsResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7102744828653176831L;

	/**
	 * @return the gatewayList
	 */
	public List<Gateway> getGatewayList() {
		return gatewayList;
	}

	/**
	 * @param gatewayList the gatewayList to set
	 */
	public void setGatewayList(List<Gateway> gatewayList) {
		this.gatewayList = gatewayList;
	}

	/**
	 * @return the destinationList
	 */
	public List<Destination> getDestinationList() {
		return destinationList;
	}

	/**
	 * @param destinationList the destinationList to set
	 */
	public void setDestinationList(List<Destination> destinationList) {
		this.destinationList = destinationList;
	}

	/**
	 * @return the nearbyAirportList
	 */
	public List<NearbyAirport> getNearbyAirportList() {
		return nearbyAirportList;
	}

	/**
	 * @param nearbyAirportList the nearbyAirportList to set
	 */
	public void setNearbyAirportList(List<NearbyAirport> nearbyAirportList) {
		this.nearbyAirportList = nearbyAirportList;
	}

	/**
	 * Holds destination list
	 */
	private List<Destination> destinationList;
	
	/**
	 * Holds gateway list
	 */
	private List<Gateway> gatewayList;

	/**
	 * Holds nearby airport list
	 */
	private List<NearbyAirport> nearbyAirportList;
	
	/**
	 * Holds gateway destination code and respective names
	 */
	private Map<String, String> gatewayDestCodeAndNameMap;

	public Map<String, String> getGatewayDestCodeAndNameMap() {
		return gatewayDestCodeAndNameMap;
	}

	public void setGatewayDestCodeAndNameMap(
			Map<String, String> gatewayDestCodeAndNameMap) {
		this.gatewayDestCodeAndNameMap = gatewayDestCodeAndNameMap;
	}
}
