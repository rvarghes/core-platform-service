/*
 * ABEBusinessError.java
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
 * This class represents the business errors
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABEBusinessError extends ABEError {
	
	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1570758197907869793L;

	/**
	 * Default constructor
	 */
	public ABEBusinessError() {
		super();
	}
	
	/**
	 * Constructor to create the ABEErrorCode object
	 * 
	 * @param errorCode
	 * @param errorDescription
	 */
	public ABEBusinessError(String errorCode, String errorDescription) {
		super(errorCode, errorDescription);
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
		return (ABEBusinessError) super.clone();
	}	
}
