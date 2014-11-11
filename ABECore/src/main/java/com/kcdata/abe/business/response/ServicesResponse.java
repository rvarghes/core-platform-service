/*
 * ServicesResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 30, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.ServiceGroup;
import com.kcdata.abe.framework.response.ABEResponse;

public class ServicesResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 4006188914264361855L;

	/**
	 * Field to hold list of services
	 */
	private List<ServiceGroup> serviceGroups;
	
	/**
	 * Field to hold list of Seat Services
	 */
	private List<ServiceGroup> seatServiceGroups;

	/**
	 * @return the serviceGroups
	 */
	public List<ServiceGroup> getServiceGroups() {
		return serviceGroups;
	}

	/**
	 * @param serviceGroups
	 *            the serviceGroups to set
	 */
	public void setServiceGroups(List<ServiceGroup> serviceGroups) {
		this.serviceGroups = serviceGroups;
	}

	/**
	 * @return the seatServiceGroups
	 */
	public List<ServiceGroup> getSeatServiceGroups() {
		return seatServiceGroups;
	}

	/**
	 * @param seatServiceGroups the seatServiceGroups to set
	 */
	public void setSeatServiceGroups(List<ServiceGroup> seatServiceGroups) {
		this.seatServiceGroups = seatServiceGroups;
	}

}
