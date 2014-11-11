/*
 * ABEThrowable.java
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

import com.kcdata.abe.framework.env.ABETier;

/**
 * This interface is implemented by all ABE specific exceptions.
 * N/A for any use case.
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface ABEThrowable {
	
	/**
	 * Getter method for application tier field.
	 *
	 * @return ABETier
	 *
	 * @see
	 * @since
	 */
	ABETier getTier();

}
