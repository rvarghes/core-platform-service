/*
 * AirlineInfoService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AirlineInfoResponse;
import com.kcdata.abe.framework.service.ABEService;

public interface AirlineInfoService extends ABEService{

/**
 * Method to retrieve Airline Info
 *
 * @return Airline Info response
 *
 * @see
 * @since
 */
 public AirlineInfoResponse retrieveAirlineInfo(String airlineCode);

}
