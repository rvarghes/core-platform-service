/*
 * FairTradeContractService.java
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
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface class for Fair Trade Contract
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public interface FairTradeContractService extends ABEService {

	public FairTradeContractResponse retrieveTermsAndConditions();
}