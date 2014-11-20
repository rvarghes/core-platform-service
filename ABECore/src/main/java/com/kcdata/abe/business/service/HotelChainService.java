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

import com.kcdata.abe.business.response.HotelChainResponse;
import com.kcdata.abe.framework.service.ABEService;


/**
 *
 * @author kmadugul
 * @version
 *
 *
 * @see
 * @since
 */
public interface HotelChainService extends ABEService {
	/**
	 * Method to hotel chain
	 *
	 * @return Hotel Chain response
	 *
	 * @see
	 * @since
	 */
	public HotelChainResponse retrieveHotelChain(String destination);

}
