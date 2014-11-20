/*
 * EmailService.java
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
import com.kcdata.abe.framework.service.ABEService;

public interface EmailService extends ABEService{
	
	public EmailResponse sendCreditCardAuthorizationForm(String emailId);
	}
