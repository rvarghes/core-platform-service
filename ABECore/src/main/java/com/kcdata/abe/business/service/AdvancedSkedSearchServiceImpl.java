/*
 * AdvancedSkedSearchServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  nvittal	  
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AdvancedSkedSearchResponse;
import com.kcdata.abe.data.dao.AdvancedSkedSearchDao;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service class for advanced SKED search
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AdvancedSkedSearchServiceImpl extends ABEServiceBase implements
		AdvancedSkedSearchService {

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for retrieving advanced SKED search
	 */
	private AdvancedSkedSearchDao advancedSkedSearchDao;

	/**
	 * @return the advancedSkedSearchDao
	 */
	public AdvancedSkedSearchDao getAdvancedSkedSearchDao() {
		return advancedSkedSearchDao;
	}

	/**
	 * @param advancedSkedSearchDao
	 *            the advancedSkedSearchDao to set
	 */
	public void setAdvancedSkedSearchDao(
			AdvancedSkedSearchDao advancedSkedSearchDao) {
		this.advancedSkedSearchDao = advancedSkedSearchDao;
	}

	/**
	 * Method for retrieving advanced sked search options
	 * 
	 * @param searchCriteria
	 * @return advancedSkedSearchResponse
	 * 
	 * @see
	 * @since
	 */
	public AdvancedSkedSearchResponse retrieveAdvancedSkedSearchOptions(
			SearchCriteria searchCriteria) {
		return this.advancedSkedSearchDao
				.retrieveAdvancedSkedSearchOptions(searchCriteria);
	}

}
