/*
 * EmailInfoDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2010  cmelam
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;


import com.kcdata.abe.business.response.EmailResponse;
import com.kcdata.abe.framework.dao.ABEDao;

public interface EmailInfoDao extends ABEDao {

	public EmailResponse sendCreditCardAuthorizationForm(String emailId);

}
