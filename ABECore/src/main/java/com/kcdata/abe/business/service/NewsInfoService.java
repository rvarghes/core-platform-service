/*
 * NewsInfoService.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 15, 2010  vgandrap	  Service for retrieving news info based on agent
 * 								call center/gateway
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.NewsInfoResponse;
import com.kcdata.abe.framework.service.ABEService;

public interface NewsInfoService extends ABEService{
	
	public NewsInfoResponse retrieveNewsInfo(String gateway);

}
