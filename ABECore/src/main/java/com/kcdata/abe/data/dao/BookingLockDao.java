/*
 * BookingLockDao.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 21, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.business.response.BookingLockResponse;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.framework.dao.ABEDao;

/**
 * Interface to define the booking lock functionality
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public interface BookingLockDao extends ABEDao {
	
	/**
	 * Method to lock the booking from editing
	 *
	 * @param bookingNo
	 * @return
	 *
	 * @see
	 * @since
	 */
	public BookingLockResponse createLock(String bookingNo);
	
	/**
	 * Method to release booking lock
	 *
	 * @param bookingLockDetails
	 *
	 * @see
	 * @since
	 */
	public BookingLockResponse releaseLock(BookingLockDetails bookingLockDetails);
}
