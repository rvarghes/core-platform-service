/*
 * ApplyPaymentService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 13, 2009  dmahanth
 * Nov 23, 2009  nvittal	  Added method for apply payment check
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.ApplyPaymentResponse;
import com.kcdata.abe.data.dto.PaymentInformation;

public interface ApplyPaymentService {

	/**
	 * Method to apply payment for the booking
	 * 
	 * @param paymentInformation
	 * @return ApplyPaymentResponse
	 * 
	 * @see
	 * @since
	 */
	public ApplyPaymentResponse applyPayment(PaymentInformation paymentInformation);
	
	/**
	 * Method checks if apply payment could be performed for a given booking
	 *
	 * @param bookingNo
	 * @param userName
	 * @param userGroupName
	 * @return
	 *
	 * @see
	 * @since
	 */
	public ApplyPaymentResponse applyPaymentCheck(String bookingNo, String userName, String userGroupName);
}