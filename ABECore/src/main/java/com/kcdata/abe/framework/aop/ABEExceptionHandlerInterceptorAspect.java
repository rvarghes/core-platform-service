/*
 * ABESystemExceptionHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.aop;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.aop.interceptor.ABEInterceptorBase;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessException;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * Class handles all the system exceptions N/A for any usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEExceptionHandlerInterceptorAspect extends ABEInterceptorBase {

	ABELogger logger = ABELogger
			.getLogger(ABEExceptionHandlerInterceptorAspect.class);

	/**
	 * Method to handle the system exceptions
	 * 
	 * @param abe
	 * 
	 * @see
	 * @since
	 */
	public void handleSystemException(ABESystemException abeSystemException) {
		ABESystemError systemError = abeSystemException.getSystemErrorCode();
		StringBuilder sb = new StringBuilder();
		sb.append("\n####  EXCEPTION  ####\n\n");
		sb.append("[EXCEPTION CLASS: ");
		sb.append(abeSystemException.getClass().getName());
		sb.append("]\n[ERROR CODE: ");
		sb.append(systemError.getErrorCode());
		sb.append("]\n");
		sb.append("[EXCEPTION TIER: ");
		sb.append(abeSystemException.getTier());
		sb.append("]\n[EXCEPTION CAUSE: ");
		sb.append(abeSystemException.getCause());
		sb.append("]\n[EXCEPTION STACK TRACE: ");
		sb.append(abeSystemException.getStringStackTrace());
		sb.append("]\n\n");
		ABEApplicationContext appContext = this.getApplicationContextFactory()
				.getApplicationContext();
		if (appContext != null) {
			sb.append(appContext.getAuditText());
		}
		logger.fatal(sb.toString());
	}

	/**
	 * Method to handle the Business exceptions
	 * 
	 * @param abe
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public void handleBusinessException(
			ABEBusinessException abeBusinessException) {
		StringBuilder sb = new StringBuilder();
		sb.append("\n####  EXCEPTION  ####\n\n");
		sb.append("[EXCEPTION CLASS: ");
		sb.append(abeBusinessException.getClass().getName());
		sb.append("]\n[ERROR CODE: ");
		ArrayList<ABEBusinessError> businessErrorCodes = (ArrayList<ABEBusinessError>) abeBusinessException
				.getBusinessErrors();
		for (int i = 0; i < businessErrorCodes.size(); i++) {
			sb.append(((ABEBusinessError) businessErrorCodes.get(i))
					.getErrorCode());
		}
		sb.append("]\n[EXCEPTION TIER: ");
		sb.append(abeBusinessException.getTier());
		sb.append("]\n[EXCEPTION CAUSE: ");
		sb.append(abeBusinessException.getCause());
		sb.append("]\n[EXCEPTION MESSAGE: ");
		sb.append(abeBusinessException.getMessage());
		sb.append("]\n");
		List businessErrors = abeBusinessException.getBusinessErrors();
		ABEBusinessError businessError;
		for (int i = 0; i < businessErrors.size(); i++) {
			businessError = (ABEBusinessError) businessErrors.get(i);
			sb.append("[CODE: ");
			sb.append(businessError.getErrorCode());
			sb.append(" DESC: ");
			sb.append(businessError.getErrorDescription());
			sb.append("]\n");
		}
		sb.append("[EXCEPTION STACK TRACE: ");
		sb.append(abeBusinessException.getStringStackTrace());
		sb.append("]\n\n");
		ABEApplicationContext appContext = this.getApplicationContextFactory()
				.getApplicationContext();
		if (appContext != null) {
			sb.append(appContext.getAuditText());
		}
		logger.error(sb.toString());
	}

	/**
	 * Method to handle the system exceptions
	 * 
	 * @param abe
	 * 
	 * @see
	 * @since
	 */
	public void handleException(Exception exception) {
		if (exception instanceof ABEBusinessException) {
			this.handleBusinessException((ABEBusinessException) exception);
		} else if (exception instanceof ABESystemException) {
			this.handleSystemException((ABESystemException) exception);
		} else {
			ABESystemError systemError = new ABESystemError("UNKNOWN_ERROR",
					this.getMessageSource().getMessage("UNKNOWN_ERROR", null,
							null));
			this.handleSystemException(new ABESystemException(systemError,
					ABETier.UNDEFINED, exception));
		}
	}
}
