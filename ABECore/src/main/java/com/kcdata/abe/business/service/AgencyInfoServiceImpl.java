/*
 * FareRulesServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.data.dao.AgencyInfoDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving agency information
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class AgencyInfoServiceImpl extends ABEServiceBase implements
	AgencyInfoService {

	/**
	 * DAO class for retrieving agency information
	 */
	private AgencyInfoDao agencyInfoDao;


	/**
	 * @return the agencyInfoDao
	 */
	public AgencyInfoDao getAgencyInfoDao() {
		return agencyInfoDao;
	}


	/**
	 * @param agencyInfoDao the agencyInfoDao to set
	 */
	public void setAgencyInfoDao(AgencyInfoDao agencyInfoDao) {
		this.agencyInfoDao = agencyInfoDao;
	}


	/**
	 * Method to retrieve agency information
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public AgencyResponse retrieveAgencyInfo() {
		return this.agencyInfoDao.retrieveAgencyInfo();
	}
}