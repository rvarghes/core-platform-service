/*
 * ResortAreaServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ResortAreaResponse;
import com.kcdata.abe.data.dao.ResortAreaDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for retrieving resort areas
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class ResortAreaServiceImpl extends ABEServiceBase implements
		ResortAreaService {

	/**
	 * DAO class for retrieving resort area
	 */
	private ResortAreaDao resortAreaDao;

	/**
	 * @return the resortAreaDao
	 */
	public ResortAreaDao getResortAreaDao() {
		return resortAreaDao;
	}

	/**
	 * @param resortAreaDao
	 *            the resortAreaDao to set
	 */
	public void setResortAreaDao(ResortAreaDao resortAreaDao) {
		this.resortAreaDao = resortAreaDao;
	}

	
	public ResortAreaResponse retrieveResortAreas(String destination) {
		return this.resortAreaDao.retrieveResortAreas(destination);
	}

}