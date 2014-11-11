/*
 * SpecialsCacheDataService.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 12, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.data.dto.SearchCriteria;

public interface SpecialsCacheDataService {

	/**
	 * Returns a list of specials to be displayed on Consumer front end
	 * @param searchCriteria
	 * @return
	 * @see
	 * @since
	 */
	public abstract SpecialsCacheResponse retrieveSpecials(
			SearchCriteria searchCriteria);

}