/*
 * EmailServiceImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.EmailResponse;
import com.kcdata.abe.data.dao.EmailInfoDao;
import com.kcdata.abe.framework.service.ABEServiceBase;

public class EmailServiceImpl extends ABEServiceBase implements EmailService {

	private EmailInfoDao emailInfoDao;

	/**
	 * @return the emailInfoDao
	 */
	public EmailInfoDao getEmailInfoDao() {
		return emailInfoDao;
	}

	/**
	 * @param emailInfoDao
	 *            the emailInfoDao to set
	 */
	public void setEmailInfoDao(EmailInfoDao emailInfoDao) {
		this.emailInfoDao = emailInfoDao;
	}

	public EmailResponse sendCreditCardAuthorizationForm(String emailId) {
		return emailInfoDao.sendCreditCardAuthorizationForm(emailId);
	}

}
