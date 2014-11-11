/*
 * ApplyPaymentResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.framework.response.ABEResponse;

public class ApplyPaymentResponse extends ABEResponse{

	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9041436213279796665L;
	
	/**
	 * Field to hold Payment Information and response
	 */
	private PaymentInformation paymentInformation;

	/**
	 * @return the paymentInformation
	 */
	public PaymentInformation getPaymentInformation() {
		return paymentInformation;
	}

	/**
	 * @param paymentInformation
	 *            the paymentInformation to set
	 */
	public void setPaymentInformation(PaymentInformation paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

}
