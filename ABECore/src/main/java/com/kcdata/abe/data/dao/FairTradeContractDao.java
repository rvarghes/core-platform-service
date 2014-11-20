/*
 * FairTradeContractDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 19, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.FairTradeContractResponse;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Fair Trade Contract DAO Interface class
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public interface FairTradeContractDao extends ABEDao {

	public FairTradeContractResponse retrieveTermsAndConditions();
}