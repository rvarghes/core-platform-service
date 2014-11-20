/*
 * ABEWarning.java
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
 * This class is for Warnings
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEWarning extends ABEError {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6089673803686729974L;

	/**
	 * Default Constructor
	 */
	public ABEWarning() {
		super();
	}

	/**
	 * Constructor for creating the Warning object
	 * 
	 * @param code
	 *            - warning code
	 * @param description
	 *            - warning description
	 */
	public ABEWarning(String code, String description) {
		super(code, description);
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
		return (ABEWarning) super.clone();
	}
}
