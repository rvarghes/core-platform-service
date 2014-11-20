/*
 * BookingLockService.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 22, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.service;

import com.kcdata.abe.business.response.BookingLockResponse;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.framework.service.ABEService;

/**
 * Service interface for Booking Lock details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public interface BookingLockService extends ABEService {
	
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
