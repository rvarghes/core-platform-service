/*
 * PaymentHistoryService.java
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

public interface PaymentHistoryService {

	/**
	 * 
	 *  function to retrieve payments done till 
	 *  date for the provided booking number. 
	 *
	 * @param bookingNumber
	 * @return PaymentHistoryResponse
	 *
	 * @see
	 * @since
	 */
	public PaymentHistoryResponse getPaymentHistory(String bookingNumber);
}
