/*
 * BookingLockDetails.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 21, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the booking lock details
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class BookingLockDetails implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7908496938634112828L;

	private String bookingNo;
	private String lockId;
	private String lockMessage;
	private boolean alreadyLocked;
	private boolean admin;

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}

	/**
	 * @param bookingNo
	 *            the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	/**
	 * @return the lockId
	 */
	public String getLockId() {
		return lockId;
	}

	/**
	 * @param lockId
	 *            the lockId to set
	 */
	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	/**
	 * @return the lockMessage
	 */
	public String getLockMessage() {
		return lockMessage;
	}

	/**
	 * @param lockMessage
	 *            the lockMessage to set
	 */
	public void setLockMessage(String lockMessage) {
		this.lockMessage = lockMessage;
	}

	/**
	 * @return the alreadyLocked
	 */
	public boolean isAlreadyLocked() {
		return alreadyLocked;
	}

	/**
	 * @param alreadyLocked
	 *            the alreadyLocked to set
	 */
	public void setAlreadyLocked(boolean alreadyLocked) {
		this.alreadyLocked = alreadyLocked;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Returns the String representation of Vehicle object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<BookingLockDetails>\n");
		sb.append("bookingNo: " + bookingNo + "\n");
		sb.append("lockId: " + lockId + "\n");
		sb.append("lockMessage: " + lockMessage + "\n");
		sb.append("alreadyLocked: " + alreadyLocked + "\n");
		sb.append("admin: " + admin + "\n");
		sb.append("</BookingLockDetails>");
		return sb.toString();
	}
}
