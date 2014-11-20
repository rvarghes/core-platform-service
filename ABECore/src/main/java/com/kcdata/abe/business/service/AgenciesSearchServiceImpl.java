/*
 * AgenciesSearchServiceImpl.java
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
import com.kcdata.abe.data.dao.AgenciesSearchDao;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving agencies search information
 * 
 * @author kmadugul
 * @version
 * 
 * @see
 * @since
 */
public class AgenciesSearchServiceImpl extends ABEServiceBase implements
	AgenciesSearchService {

	/**
	 * DAO class for retrieving agency information
	 */
	private AgenciesSearchDao agenciesSearchDao;


	/**
	 * @return the agenciesSearchDao
	 */
	public AgenciesSearchDao getAgenciesSearchDao() {
		return agenciesSearchDao;
	}


	/**
	 * @param agenciesSearchDao the agenciesSearchDao to set
	 */
	public void setAgenciesSearchDao(AgenciesSearchDao agenciesSearchDao) {
		this.agenciesSearchDao = agenciesSearchDao;
	}


	/**
	 * Method to retrieve agencies search information
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public AgenciesSearchResponse retrieveAgenciesSearchInfo(Agency agencySearch) 
	{
		return this.agenciesSearchDao.retrieveAgenciesSearchInfo(agencySearch);
	}
}