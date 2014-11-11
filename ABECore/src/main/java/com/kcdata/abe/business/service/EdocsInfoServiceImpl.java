/*
 * EdocsInfoServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.EdocsInfoResponse;
import com.kcdata.abe.data.dao.EdocsInfoDao;
import com.kcdata.abe.data.dto.EdocsInfo;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * EdocsService implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class EdocsInfoServiceImpl extends ABEServiceBase implements
		EdocsInfoService {

	private EdocsInfoDao edocsInfoDao;

	/**
	 * @return the edocsInfoDao
	 */
	public EdocsInfoDao getEdocsInfoDao() {
		return edocsInfoDao;
	}

	/**
	 * @param edocsInfoDao
	 *            the edocsInfoDao to set
	 */
	public void setEdocsInfoDao(EdocsInfoDao edocsInfoDao) {
		this.edocsInfoDao = edocsInfoDao;
	}

	/**
	 * Method to store the edocs info
	 * 
	 * @param edocsInfo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public EdocsInfoResponse storeEdocsInfo(EdocsInfo edocsInfo) {
		return this.edocsInfoDao.storeEdocsInfo(edocsInfo);
	}
}
