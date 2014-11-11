/*
 * PaymentHistoryServiceImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.data.dao.PaymentHistoryDao;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class PaymentHistoryServiceImpl extends ABEServiceBase implements
PaymentHistoryService {

	ABELogger logger = ABELogger.getLogger(PaymentHistoryServiceImpl.class);
	
	private PaymentHistoryDao paymentHistoryDao;
	
	/**
	 * @return the paymentHistoryDao
	 */
	public PaymentHistoryDao getPaymentHistoryDao() {
		return paymentHistoryDao;
	}

	/**
	 * @param paymentHistoryDao the paymentHistoryDao to set
	 */
	public void setPaymentHistoryDao(PaymentHistoryDao paymentHistoryDao) {
		this.paymentHistoryDao = paymentHistoryDao;
	}

	/**
	 * 
	 * This function is to retrieve payment history based on provided booking number.
	 * @param bookingNumber
	 * @return PaymentHistoryResponse
	 *
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse getPaymentHistory(String bookingNumber) {
		
		return this.paymentHistoryDao.getPaymentHistory(bookingNumber);
	}

}
