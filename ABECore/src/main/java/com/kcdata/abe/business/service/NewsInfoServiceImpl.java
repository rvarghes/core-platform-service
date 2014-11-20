/*
 * NewsInfoServiceImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 15, 2010  vgandrap		 Service for retrieving news info based on agent
 * 								call center/gateway
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.NewsInfoResponse;
import com.kcdata.abe.data.dao.NewsInfoDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class NewsInfoServiceImpl extends ABEServiceBase implements
		NewsInfoService {

	private NewsInfoDao newsInfoDao;
	
	/**
	 * @return the newsInfoDao
	 */
	public NewsInfoDao getNewsInfoDao() {
		return newsInfoDao;
	}

	/**
	 * @param newsInfoDao the newsInfoDao to set
	 */
	public void setNewsInfoDao(NewsInfoDao newsInfoDao) {
		this.newsInfoDao = newsInfoDao;
	}

	public NewsInfoResponse retrieveNewsInfo(String gateway) {
		return this.newsInfoDao.retrieveNewsInfo(gateway);
	}

}
