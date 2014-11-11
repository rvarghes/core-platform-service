/*
 * PaymentHistoryDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.PaymentHistoryResponse;
import com.kcdata.abe.framework.dao.ABEDao;

public interface PaymentHistoryDao  extends ABEDao {

	/**
	 * Method to get payment history for provided booking number.
	 *
	 * @param bookingNumber
	 * @return PaymentHistoryResponse
	 *
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse getPaymentHistory(String bookingNumber);
}
