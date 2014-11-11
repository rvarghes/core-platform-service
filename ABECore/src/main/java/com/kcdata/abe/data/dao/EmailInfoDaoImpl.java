/*
 * EmailInfoDaoImpl.java
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

import org.springframework.core.io.Resource;

import com.kcdata.abe.business.response.EmailResponse;
import com.kcdata.abe.data.util.EmailUtils;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEInfoMessage;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;

public class EmailInfoDaoImpl extends ABEDaoBase implements EmailInfoDao {

	ABELogger abeLogger = ABELogger.getLogger(EmailInfoDaoImpl.class);
	
	private EmailUtils emailProcessor;
	private Resource attachment;

	/**
	 * @return the attachment
	 */
	public Resource getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment
	 *            the attachment to set
	 */
	public void setAttachment(Resource attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the emailProcessor
	 */
	public EmailUtils getEmailProcessor() {
		return emailProcessor;
	}

	/**
	 * @param emailProcessor
	 *            the emailProcessor to set
	 */
	public void setEmailProcessor(EmailUtils emailProcessor) {
		this.emailProcessor = emailProcessor;
	}

	/**
	 * 
	 * This function is to return email response .
	 * 
	 * @param emailId
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public EmailResponse sendCreditCardAuthorizationForm(String emailId) {
		EmailResponse emailResponse = new EmailResponse();
		if (emailId == null || "".equals(emailId)) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_EMAIL_ID");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_EMAIL_ID", null, null));
			emailResponse.saveBusinessError(businessError);
		}
		if (getAttachment() == null) {
			ABESystemError systemError = new ABESystemError(
					"UNABLE_TO_LOAD_CREDIT_CARD_FORM", this.getMessageSource()
							.getMessage("UNABLE_TO_LOAD_CREDIT_CARD_FORM",
									null, null));
			throw new ABESystemException(systemError, ABETier.DATA, new Exception());
		}
		try {
			emailProcessor.sendCreditCardPaymentForm(emailId, this
					.getAttachment());
			ABEInfoMessage infoMessage = new ABEInfoMessage();
			infoMessage.setErrorCode("EMAIL_SENT_SUCCESSFULLY");
			infoMessage.setErrorDescription(this.getMessageSource().getMessage(
					"EMAIL_SENT_SUCCESSFULLY", null, null));
			emailResponse.saveInfoMessage(infoMessage);
		} catch (Exception ex) {
			abeLogger.trace(ex.toString());
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("UNABLE_TO_SEND_EMAIL");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("UNABLE_TO_SEND_EMAIL", null, null));
			emailResponse.saveBusinessError(businessError);
		}
		return emailResponse;
	}// end method sendCreditCardAuthorizationForm

}
