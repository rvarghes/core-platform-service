/*
 * ABESystemError.java
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

/**
 * This class represents system errors
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABESystemError extends ABEError {

	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3976323570983452684L;
	private String debugMessage;

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 *            error code
	 * @param errorDescription
	 *            error description
	 */
	public ABESystemError(String errorCode, String errorDescription) {
		super(errorCode, errorDescription);
	}

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 *            error code
	 * @param errorDescription
	 *            error description
	 */
	public ABESystemError(String errorCode, String errorDescription,
			String debugMessage) {
		super(errorCode, errorDescription);
		this.debugMessage = debugMessage;
	}

	/**
	 * @return the debugMessage
	 */
	public String getDebugMessage() {
		return debugMessage;
	}

	/**
	 * @param debugMessage
	 *            the debugMessage to set
	 */
	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	public Object clone() throws CloneNotSupportedException {
		return (ABESystemError) super.clone();
	}
}
