/*
 * BAPIExecutionManager.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.framework.sap;

import org.springframework.context.MessageSourceAware;

/**
 * Interface for the BAPI Execution 
 * N/A for any usecase
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface BAPIExecutionManager extends MessageSourceAware {
	
	/**
	 * Method to execute the BAPI
	 *
	 * @param name - Name of the BAPI to be executed
	 * @param input - Input for the BAPI
	 * @return response of the BAPI 
	 *
	 * @see
	 * @since
	 */
	public Object executeBAPI(String name, Object input);

}
