/*
 * ABEError.java
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

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * This class is the base class for all error code classes. N/A for any use
 * case.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEError implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 7855832625241192783L;

	/**
	 * Default constructor
	 */
	public ABEError() {
	}

	/**
	 * Constructor
	 * 
	 * @param errorCode
	 *            error code
	 * @param errorDescription
	 *            error description
	 */
	public ABEError(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	/**
	 * Implementation of toString method
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<ABEError>\n");
		sb.append("errorCode: " + errorCode + "\n");
		sb.append("errorDescription: " + errorDescription + "\n");
		sb.append("\n</ABEError>\n");
		return sb.toString();
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
		return (ABEError) super.clone();
	}

	/**
	 * This field is error code
	 */
	private String errorCode;

	/**
	 * This field is error description
	 */
	private String errorDescription;

}
