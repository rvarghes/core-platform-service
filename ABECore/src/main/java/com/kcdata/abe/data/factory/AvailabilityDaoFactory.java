/*
 * AvailabilityDaoFactory.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.factory;

import com.kcdata.abe.data.dao.threads.AvailabilityThreadDao;

/**
 * Interface to define the factory method for {@link AvailabilityThreadDao}.
 * Interface to be implemented Spring container to provide the
 * {@link AvailabilityThreadDao} objects
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface AvailabilityDaoFactory {

	public AvailabilityThreadDao createAvailabilityThreadDao();
	
}
