/*
 * HotelChainResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 09, 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.CarType;
import com.kcdata.abe.data.dto.HotelChain;
import com.kcdata.abe.framework.response.ABEResponse;


/**
 * 
 * @author npanday
 *
 */
public class VehicleClassResponse extends ABEResponse {

	private static final long serialVersionUID = -2308310537727313163L;
	private List<CarType> carTypes;
	/**
	 * @param carTypes the carTypes to set
	 */
	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}
	/**
	 * @return the carTypes
	 */
	public List<CarType> getCarTypes() {
		return carTypes;
	}
	
}
