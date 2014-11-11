/*
 * ResortAreaService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ResortAreaResponse;
import com.kcdata.abe.framework.service.ABEService;


/**
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface ResortAreaService extends ABEService {
	/**
	 * Method to retrieve resort areas
	 *
	 * @return Resort Area response
	 *
	 * @see
	 * @since
	 */
	public ResortAreaResponse retrieveResortAreas(String destination);

}
