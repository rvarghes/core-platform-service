/*
 * UserService.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.AuthenticateUserResponse;
import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Interface class for user services
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface UserService extends ABEService {
	/**
	 * Method for authenticating user
	 *
	 * @param user - User object
	 * @return User Response object
	 *
	 * @see
	 * @since
	 */
	public AuthenticateUserResponse authenticateUser(User user);

	/**
	 * Method for password change
	 *
	 * @param user - User object
	 * @return User Response object
	 *
	 * @see
	 * @since
	 */
	public AuthenticateUserResponse changePassword(User user);	
}
