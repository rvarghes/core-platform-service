/*
 * BookingLockResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 21, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import com.kcdata.abe.data.dto.BookingLockDetails;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Class to hold the booking lock response
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6958478356606575220L;

	private BookingLockDetails bookingLockDetails;

	/**
	 * @return the bookingLockDetails
	 */
	public BookingLockDetails getBookingLockDetails() {
		return bookingLockDetails;
	}

	/**
	 * @param bookingLockDetails
	 *            the bookingLockDetails to set
	 */
	public void setBookingLockDetails(BookingLockDetails bookingLockDetails) {
		this.bookingLockDetails = bookingLockDetails;
	}
}
