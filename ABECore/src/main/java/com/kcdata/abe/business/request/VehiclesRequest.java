/*
 * VehicleRequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.request;

import com.kcdata.abe.data.dto.VehicleOptions;
import com.kcdata.abe.framework.request.ABERequest;

/**
 * Vehicle request class
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class VehiclesRequest extends ABERequest {

	/**
	 * Default generated serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2233224517853273426L;

	/**
	 * @return the vehicleOptions
	 */
	public VehicleOptions getVehicleOptions() {
		return vehicleOptions;
	}

	/**
	 * @param vehicleOptions the vehicleOptions to set
	 */
	public void setVehicleOptions(VehicleOptions vehicleOptions) {
		this.vehicleOptions = vehicleOptions;
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
		VehiclesRequest vehicleRequest = (VehiclesRequest) super.clone();
		if(vehicleOptions != null) {
			vehicleRequest.vehicleOptions = (VehicleOptions) vehicleOptions.clone();
		}
		return vehicleRequest;
	}
	
	private VehicleOptions vehicleOptions;
}