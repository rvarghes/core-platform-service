/*
 * ResortAreaDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.ResortAreaResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for resort area retrieval
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface ResortAreaDao extends ABEDao {

	/**
	 * Method to retrieve the resort areas
	 * 
	 * @return ResortAreaResponse
	 * 
	 * @see
	 * @since
	 */
	public ResortAreaResponse retrieveResortAreas(String destination);

}
