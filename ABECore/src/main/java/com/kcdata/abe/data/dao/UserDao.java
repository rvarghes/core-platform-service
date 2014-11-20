/*
 * UserDao.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.AuthenticateUserResponse;
import com.kcdata.abe.data.dto.User;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * User DAO Interface class
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public interface UserDao extends ABEDao {

	public AuthenticateUserResponse authenticateUser(User user);
	
	public AuthenticateUserResponse changePassword(User user);
	
}
