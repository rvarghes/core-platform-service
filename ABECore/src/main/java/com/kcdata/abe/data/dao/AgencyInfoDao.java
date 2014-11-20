/*
 * AgencyInfoDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for retrieving agency information
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public interface AgencyInfoDao extends ABEDao {

	/**
	 * Method to retrieve agency info
	 * 
	 * @return AgencyResponse
	 * 
	 * @see
	 * @since
	 */
	public AgencyResponse retrieveAgencyInfo();
}