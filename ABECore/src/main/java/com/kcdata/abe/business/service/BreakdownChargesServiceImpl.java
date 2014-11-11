/*
 * BreakdownChargesServiceImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.BreakdownChargesResponse;
import com.kcdata.abe.data.dao.BreakdownChargesDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class BreakdownChargesServiceImpl extends ABEServiceBase implements BreakdownChargesService {
	
	private BreakdownChargesDao breakdownChargesDao;

	/**
	 * @return the breakdownChargesDao
	 */
	public BreakdownChargesDao getBreakdownChargesDao() {
		return breakdownChargesDao;
	}

	/**
	 * @param breakdownChargesDao the breakdownChargesDao to set
	 */
	public void setBreakdownChargesDao(BreakdownChargesDao breakdownChargesDao) {
		this.breakdownChargesDao = breakdownChargesDao;
	}

	/**
	 * Method returns the price breakdown for a specified booking
	 * @param bookingNo
	 * @return
	 * @see
	 * @since
	 */
	public BreakdownChargesResponse retrievePriceBreakdown(String bookingNo) {
		return breakdownChargesDao.retrievePriceBreakdown(bookingNo);
	}
}
 