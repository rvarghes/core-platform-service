/*
 * NearbyGateways.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2011  npanday
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold near by gateways details
 * 
 * @author Nishakant
 * @version
 *
 */
public class NearbyGateway implements ABEDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	/**
	 * @return the gatewayCode
	 */
	public String getGatewayCode() {
		return gatewayCode;
	}


	/**
	 * @param gatewayCode the gatewayCode to set
	 */
	public void setGatewayCode(String gatewayCode) {
		this.gatewayCode = gatewayCode;
	}


	/**
	 * @return the nearbyGatewayCode
	 */
	public String getNearbyGatewayCode() {
		return nearbyGatewayCode;
	}


	/**
	 * @param nearbyGatewayCode the nearbyGatewayCode to set
	 */
	public void setNearbyGatewayCode(String nearbyGatewayCode) {
		this.nearbyGatewayCode = nearbyGatewayCode;
	}


	/**
	 * @return the distanceFromGateway
	 */
	public String getDistanceFromGateway() {
		return distanceFromGateway;
	}


	/**
	 * @param distanceFromGateway the distanceFromGateway to set
	 */
	public void setDistanceFromGateway(String distanceFromGateway) {
		this.distanceFromGateway = distanceFromGateway;
	}


	private String gatewayCode;
	private String nearbyGatewayCode;
	private String distanceFromGateway;
	
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	
}
