/*
 * BookingLockServiceImpl.java
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
import com.kcdata.abe.data.dao.BookingLockDao;
import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.framework.service.ABEServiceBase;

/**
 * Service implementation class for Booking Lock functionality
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockServiceImpl extends ABEServiceBase implements
		BookingLockService {

	private BookingLockDao bookingLockDao;

	/**
	 * @return the bookingLockDao
	 */
	public BookingLockDao getBookingLockDao() {
		return bookingLockDao;
	}

	/**
	 * @param bookingLockDao
	 *            the bookingLockDao to set
	 */
	public void setBookingLockDao(BookingLockDao bookingLockDao) {
		this.bookingLockDao = bookingLockDao;
	}

	/**
	 * Method to lock the booking from editing
	 * 
	 * @param bookingNo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingLockResponse createLock(String bookingNo) {
		return this.bookingLockDao.createLock(bookingNo);
	}

	/**
	 * Method to release booking lock
	 * 
	 * @param bookingLockDetails
	 * 
	 * @see
	 * @since
	 */
	public BookingLockResponse releaseLock(BookingLockDetails bookingLockDetails) {
		return this.bookingLockDao.releaseLock(bookingLockDetails);
	}

}
