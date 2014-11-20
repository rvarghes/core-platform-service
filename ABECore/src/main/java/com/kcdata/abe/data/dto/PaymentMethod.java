/*
 * PaymentMethod.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for payment methods accepted for the agency
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class PaymentMethod implements ABEDto {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -5738316686853575825L;

	/**
	 * @return the method
	 */
	public char getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(char method) {
		this.method = method;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the String representation of paryment method object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<PaymentMethod>\n");
		sb.append("method: "+method+"\n");
		sb.append("description: "+description+"\n");		
		sb.append("</PaymentMethod>");

		return sb.toString();
	}

	/**
	 * Clone method implementation
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 *
	 * @see
	 * @since
	 */
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private char method;
	private String description;
}