/*
 * SpecialsCacheDataServiceImpl.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 5, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.data.dao.SpecialsCacheDao;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.SpecialRequestType;
import com.kcdata.abe.data.util.SpecialUtils;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class SpecialsCacheDataServiceImpl extends ABEServiceBase implements
		SpecialsCacheDataService {
	
	private SpecialsCacheDao specialsCacheDao;
	
	/**
	 * @return the specialsCacheDao
	 */
	public SpecialsCacheDao getSpecialsCacheDao() {
		return specialsCacheDao;
	}
	/**
	 * @param specialsCacheDao the specialsCacheDao to set
	 */
	public void setSpecialsCacheDao(SpecialsCacheDao specialsCacheDao) {
		this.specialsCacheDao = specialsCacheDao;
	}
	 
	/**
	 * Returns a list of specials for a given search criteria
	 * @param searchCriteria
	 * @return specialsCacheResponse
	 */
	public SpecialsCacheResponse retrieveSpecials(
			SearchCriteria searchCriteria) {
		return specialsCacheDao.retrieveSpecialsFromGrid(SpecialUtils
				.convertSearchCriteria(searchCriteria.getHotelsRequest(),SpecialRequestType.ALLSPECIALS));
	}

}
