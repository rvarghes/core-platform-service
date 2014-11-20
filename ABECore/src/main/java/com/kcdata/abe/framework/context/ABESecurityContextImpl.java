/*
 * ABESecuriyContextImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.context;

/**
 * Implementation for the ABESecurityContext
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class ABESecurityContextImpl implements ABESecurityContext {

	/**
	 * Auto generated id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9033687227376531743L;
	
	/**
	 * Field to hold the user name
	 */
	private String userName;

	/**
	 * method to return the user name
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String getUserName() {
		return userName;
	}

	/**
	 * Method to set the user name
	 *
	 * @param userName
	 *
	 * @see
	 * @since
	 */
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Method to return the audit text
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String getAuditText() {
        StringBuilder sb = new StringBuilder();
        sb.append("## SECURITY CONTEXT DUMP ##");
        sb.append("\n[USERNAME: ");
        sb.append(this.getUserName());
        sb.append("]\n");
        return sb.toString();
	}

}
