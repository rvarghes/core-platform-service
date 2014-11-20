/*
 * UserServiceImpl.java
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
import com.kcdata.abe.data.dao.UserDao;
import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for user services
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class UserServiceImpl extends ABEServiceBase implements UserService {

	/**
	 * DAO class for user services
	 */
	private UserDao userDao;

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	
	/**
	 * Method for user authentication purpose
	 *
	 * @param user
	 * @return User Response object
	 *
	 * @see
	 * @since
	 */
	
	public AuthenticateUserResponse authenticateUser(User user) {
		return this.userDao.authenticateUser(user);
	}

	/**
	 * Method for user password change
	 *
	 * @param user
	 * @return User Response object
	 *
	 * @see
	 * @since
	 */
	
	public AuthenticateUserResponse changePassword(User user) {
		return this.userDao.changePassword(user);
	}
}
