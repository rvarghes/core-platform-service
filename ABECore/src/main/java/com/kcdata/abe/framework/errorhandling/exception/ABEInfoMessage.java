/*
 * ABEInfoMessage.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.framework.errorhandling.exception;

/**
 * Class for info type messages
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ABEInfoMessage extends ABEError {

	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3684742060306757050L;

	/**
	 * Default Constructor
	 */
	public ABEInfoMessage() {
		super();
	}

	/**
	 * Constructor for creating the ABEInfoMessage object
	 * 
	 * 
	 * @param code
	 * @param description
	 */
	public ABEInfoMessage(String code, String description) {
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
		return (ABEInfoMessage) super.clone();
	}	

}
