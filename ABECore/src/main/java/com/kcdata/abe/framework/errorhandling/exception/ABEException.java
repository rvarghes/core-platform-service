/*
 * ABEException.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.errorhandling.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABEApplicationContextFactory;
import com.kcdata.abe.framework.context.ABEApplicationContextFactoryImpl;
import com.kcdata.abe.framework.env.ABETier;

/**
 * This abstract class is extended by all ABE specific exceptions including
 * ABEBusinessException and ABESystemException. N/A for any use case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public abstract class ABEException extends RuntimeException implements
		ABEThrowable {

	/**
	 * Auto generated id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -422087614596797405L;

	/**
	 * Application tier where the exception is thrown.
	 * 
	 * @see
	 * @since
	 */
	private ABETier tier;

	/**
	 * This field contains the application context.
	 * 
	 * @see
	 * @since
	 */
	private ABEApplicationContext applicationContext;

	/**
	 * This method returns the stack trace in string format.
	 * 
	 * @return String format of the exception stack trace
	 * 
	 * @see
	 * @since
	 */
	public String getStringStackTrace() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		this.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	/**
	 * This method returns the stack trace in string format.
	 * 
	 * @param t
	 *            any Throwable
	 * @return String format of the exception stack trace
	 * 
	 * @see
	 * @since
	 */
	public static String getStringStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		t.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}

	/**
	 * Constructor.
	 * 
	 * @param tier
	 *            ABETier
	 * @param internalMessage
	 *            String value of the error message
	 * @param cause
	 *            cause of the exception
	 */
	public ABEException(ABETier tier, String internalMessage, Throwable cause) {
		super(internalMessage, cause);
		this.tier = tier;
		this.setApplicationContext();
	}

	/**
	 * Constructor.
	 * 
	 * @param internalMessage
	 *            String value of the error message
	 * @param cause
	 *            cause of the exception
	 */
	public ABEException(String internalMessage, Throwable cause) {
		super(internalMessage, cause);
		this.setApplicationContext();
	}

	/**
	 * This method populates application context.
	 * 
	 * 
	 * @see
	 * @since
	 */
	private void setApplicationContext() {
		ABEApplicationContextFactory cf = new ABEApplicationContextFactoryImpl();
		this.applicationContext = cf.getApplicationContext();
	}

	/**
	 * Constructor.
	 * 
	 * @param tier
	 *            ABETier
	 * @param internalMessage
	 *            String value of the error message
	 */
	public ABEException(ABETier tier, String internalMessage) {
		this(tier, internalMessage, null);
	}

	/**
	 * @return Returns the tier.
	 */
	public ABETier getTier() {
		return tier;
	}

	/**
	 * @return Returns the applicationContext.
	 */
	public ABEApplicationContext getApplicationContext() {
		return applicationContext;
	}
}