/*
 * NewsInfoDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 14, 2010  vgandrap	 Dao Interface for retrieving News
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.NewsInfoResponse;
import com.kcdata.abe.framework.dao.ABEDao;

public interface NewsInfoDao extends ABEDao{
	
	/**
	 * 
	 * Retrieve News based on agent call center/gateway  
	 *
	 * @param gateway
	 * @return
	 *
	 * @see
	 * @since
	 */
	public NewsInfoResponse retrieveNewsInfo(String gateway);
}
