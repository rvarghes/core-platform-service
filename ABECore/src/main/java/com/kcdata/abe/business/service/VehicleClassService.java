/*
 * HotelChainService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 09, 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.VehicleClassResponse;
import com.kcdata.abe.framework.service.ABEService;


/**
 * 
 * @author npanday
 *
 */
public interface VehicleClassService extends ABEService {

	public VehicleClassResponse retrieveVehicleClass();

}
