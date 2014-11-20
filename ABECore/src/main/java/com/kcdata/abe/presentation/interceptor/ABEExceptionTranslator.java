/*
 * ABEExceptionTranslator.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 9, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.presentation.interceptor;

import org.springframework.flex.core.ExceptionTranslator;
import org.springframework.util.ClassUtils;

import com.kcdata.abe.framework.aop.interceptor.ABEInterceptorBase;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

import flex.messaging.MessageException;

/**
 * Translator class to convert ABE Exceptions to FLEX Message Exceptions
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEExceptionTranslator extends ABEInterceptorBase implements
		ExceptionTranslator {

	/**
	 * Checks if the translator can handle the specified exception class
	 * 
	 * @param arg0
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public boolean handles(Class<?> clazz) {
		if (ClassUtils.isAssignable(ABESystemException.class, clazz)) {
			return true;
		}
		return false;
	}

	/**
	 * Translate the specified exception into an appropriate MessageException
	 * 
	 * @param arg0
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public MessageException translate(Throwable throwable) {
		final MessageException exception = new MessageException();
		if (throwable != null) {
			ABEApplicationContext appContext = this
					.getApplicationContextFactory().getApplicationContext();
			if(appContext != null && appContext.getRequestContext() != null) {
				exception.setCode(appContext.getRequestContext().getRequestId());
			}
			if (throwable instanceof ABESystemException) {
				ABESystemError systemError = ((ABESystemException) throwable)
						.getSystemErrorCode();
				exception.setMessage(systemError.getErrorDescription());
			}
			exception.setRootCause(throwable);
		}
		return exception;
	}

}
