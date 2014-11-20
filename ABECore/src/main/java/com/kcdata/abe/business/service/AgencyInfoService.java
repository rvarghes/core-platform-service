/*
 * AgencyInfoService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service class for Agency Information
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public interface AgencyInfoService extends ABEService {
	/**
	 * Method to retrieve agency information
	 *
	 * @return Agency response
	 *
	 * @see
	 * @since
	 */
	public AgencyResponse retrieveAgencyInfo();
}