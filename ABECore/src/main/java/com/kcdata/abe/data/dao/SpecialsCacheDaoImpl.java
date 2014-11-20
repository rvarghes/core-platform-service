/*
 * SpecialsCacheDaoImpl.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 4, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.io.IOException;

import org.springframework.util.StopWatch;

import com.applevac.sce.service.external.SpecialsCacheService;
import com.applevac.sce.service.external.SpecialsSearchCriteria;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.logging.ABELogger;

public class SpecialsCacheDaoImpl extends ABEDaoBase implements SpecialsCacheDao {
	
	private SpecialsCacheService specialsCacheService;
	ABELogger logger = ABELogger.getLogger("bapi.performance.log");
	
	/**
	 * @return the specialsCacheService
	 */
	public SpecialsCacheService getSpecialsCacheService() {
		return specialsCacheService;
	}

	/**
	 * @param specialsCacheService the specialsCacheService to set
	 */
	public void setSpecialsCacheService(SpecialsCacheService specialsCacheService) {
		this.specialsCacheService = specialsCacheService;
	}

	/**
	 * Returns a list of specials from SCE Service.
	 *
	 * @param searchCriteria
	 * @return specialsList
	 *
	 * @see SpecialsCacheDao
	 * @since
	 */
	public SpecialsCacheResponse retrieveSpecialsFromGrid(
			SpecialsSearchCriteria searchCriteria) {
		SpecialsCacheResponse specialsResponse = new SpecialsCacheResponse();
		
		try {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start("SPECIALS_RETRIEVAL");
			specialsResponse.setRetrievedSpecialsList(specialsCacheService
					.retrieveSpecialsFromGrid(searchCriteria));
			stopWatch.stop();
			logger.debug("Execution of Command: RETRIEVE_SPECIALS"
					+ " completed. Total time for execution(in milliSeconds):"
					+ stopWatch.getTotalTimeMillis());
		} catch (Exception e) {
			ABESystemError systemError; 
			if (e instanceof IOException) {
				systemError = new ABESystemError(
						"UNABLE_TO_CONNECT_TO_SPECIALS_SERVICE",
						this.getMessageSource().getMessage(
								"UNABLE_TO_CONNECT_TO_SPECIALS_SERVICE", null,
								null));
			} else {
				systemError = new ABESystemError(
						"UNABLE_TO_RETRIEVE_SPECIALS_FROM_CACHE",
						this
								.getMessageSource()
								.getMessage(
										"UNABLE_TO_RETRIEVE_SPECIALS_FROM_CACHE",
										null, null));
			}
			systemError.setDebugMessage(e.getMessage());
			specialsResponse.saveSystemError(systemError);
			return specialsResponse;
		}
		return specialsResponse;
		
	}

}
