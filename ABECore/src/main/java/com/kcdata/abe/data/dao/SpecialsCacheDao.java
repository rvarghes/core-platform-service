/*
 * SpecialsCacheDao.java
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

import com.applevac.sce.service.external.SpecialsSearchCriteria;
import com.kcdata.abe.business.response.SpecialsCacheResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Specials interface to SCEWeb accesses
 * @author chazari
 */
public interface SpecialsCacheDao extends ABEDao {
	/**
	 * Returns a list of specials from SCE Service.
	 * @param searchCriteria
	 * @return specialsList
	 * @see
	 * @since
	 */
	public SpecialsCacheResponse retrieveSpecialsFromGrid(SpecialsSearchCriteria searchCriteria);
}
