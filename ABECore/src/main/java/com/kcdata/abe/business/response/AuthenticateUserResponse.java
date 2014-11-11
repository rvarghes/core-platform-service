/*
 * AuthenticateUserResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * User authentication response class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AuthenticateUserResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6049105276404256311L;

	// Object to hold user details
	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
