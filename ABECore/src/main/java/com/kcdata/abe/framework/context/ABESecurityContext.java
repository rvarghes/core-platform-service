/*
 * ABESecurityContext.java
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

import java.io.Serializable;

/**
 * This interface is implemented by ABESecurityContextImpl.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
import com.kcdata.abe.framework.audit.ABEAuditable;

public interface ABESecurityContext extends ABEAuditable, Serializable {

	/**
	 * Getter method for UserName field 
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public String getUserName();
	
	/**
	 * Setter method for UserName field
	 *
	 * @param userName
	 *
	 * @see
	 * @since
	 */
	public void setUserName(String userName);	
}
