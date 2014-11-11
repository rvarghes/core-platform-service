/*
 * FairTradeContractServiceImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.FairTradeContractResponse;
import com.kcdata.abe.data.dao.FairTradeContractDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Fair trade contract service implementation class
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class FairTradeContractServiceImpl extends ABEServiceBase implements
		FairTradeContractService {

	private FairTradeContractDao fairTradeContractDao;
	
	/**
	 * @return the fairTradeContractDao
	 */
	public FairTradeContractDao getFairTradeContractDao() {
		return fairTradeContractDao;
	}

	/**
	 * @param fairTradeContractDao the fairTradeContractDao to set
	 */
	public void setFairTradeContractDao(FairTradeContractDao fairTradeContractDao) {
		this.fairTradeContractDao = fairTradeContractDao;
	}

	/**
	 * Method for retrieving terms and conditions text
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public FairTradeContractResponse retrieveTermsAndConditions() {
		return this.fairTradeContractDao.retrieveTermsAndConditions();
	}
}