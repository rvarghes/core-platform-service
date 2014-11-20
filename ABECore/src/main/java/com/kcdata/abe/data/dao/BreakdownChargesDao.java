/*
 * BreakdownChargesDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.BreakdownChargesResponse;
import com.kcdata.abe.framework.dao.ABEDao;

public interface BreakdownChargesDao extends ABEDao {
	/**
	 * Method returns price break down for a specified booking
	 * @param bookingNo
	 * @return BreakdownChargesResponse
	 */
	public BreakdownChargesResponse retrievePriceBreakdown(String bookingNo);	
}
