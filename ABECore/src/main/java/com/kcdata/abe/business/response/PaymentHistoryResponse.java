/*
 * PaymentHistoryResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2010  agudise
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.ArrayList;

import com.kcdata.abe.data.dto.PaymentHistoryInfo;
import com.kcdata.abe.framework.response.ABEResponse;

public class PaymentHistoryResponse  extends ABEResponse {

	/**
	 * Default generated serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 707525210172657868L;

	private ArrayList<PaymentHistoryInfo> paymentHistoryInfoList;

	/**
	 * @return the paymentHistoryInfoList
	 */
	public ArrayList<PaymentHistoryInfo> getPaymentHistoryInfoList() {
		return paymentHistoryInfoList;
	}

	/**
	 * @param paymentHistoryInfoList the paymentHistoryInfoList to set
	 */
	public void setPaymentHistoryInfoList(
			ArrayList<PaymentHistoryInfo> paymentHistoryInfoList) {
		this.paymentHistoryInfoList = paymentHistoryInfoList;
	}
	
}
