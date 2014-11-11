/*
 * HotelChainDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 09, 2010  kmadugul
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.HotelChainResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * DAO Interface for hotel chain retrieval
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface HotelChainDao extends ABEDao {

	/**
	 * Method to retrieve the hotel chain
	 * 
	 * @return HotelChainResponse
	 * 
	 * @see
	 * @since
	 */
	public HotelChainResponse retrieveHotelChain(String destination);

}
