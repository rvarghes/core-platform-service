/*
 * AgenciesSearchService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 21, 2011  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AgenciesSearchResponse;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service class for Agencies Search Information
 *
 * @author kmadugul
 * @version
 *
 * @see
 * @since
 */
public interface AgenciesSearchService extends ABEService {
	/**
	 * Method to retrieve agencies search list
	 * 
	 * @return AgenciesSearchResponse
	 * 
	 * @see
	 * @since
	 */
	public AgenciesSearchResponse retrieveAgenciesSearchInfo(Agency agency);
}