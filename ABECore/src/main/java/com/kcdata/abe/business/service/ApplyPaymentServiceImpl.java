/*
 * ApplyPaymentServiceImpl.java
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
import com.kcdata.abe.data.dao.ApplyPaymentDao;
import com.kcdata.abe.data.dto.PaymentInformation;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class ApplyPaymentServiceImpl extends ABEServiceBase implements
ApplyPaymentService {

	ABELogger logger = ABELogger.getLogger(ABELogger.class);

	/**
	 * DAO class for apply payment 
	 */
	private ApplyPaymentDao applyPaymentDao;

	/**
	 * @return the applyPaymentDao
	 */
	public ApplyPaymentDao getApplyPaymentDao() {
		return applyPaymentDao;
	}

	/**
	 * @param applyPaymentDao
	 *            the applyPaymentDao to set
	 */
	public void setApplyPaymentDao(
			ApplyPaymentDao applyPaymentDao) {
		this.applyPaymentDao = applyPaymentDao;
	}

	/**
	 * Method to apply payment for the booking
	 * 
	 * @param PaymentInformation
	 * @return ApplyPaymentResponse
	 * 
	 * @see
	 * @since
	 */
	public ApplyPaymentResponse applyPayment(PaymentInformation paymentInformation) {
		return this.applyPaymentDao.applyPayment(paymentInformation);
	}

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
	public ApplyPaymentResponse applyPaymentCheck(String bookingNo,
			String userName, String userGroupName) {		
		return this.applyPaymentDao.applyPaymentCheck(bookingNo,
			userName, userGroupName);
	}	
}