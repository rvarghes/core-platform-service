/*
 * Passenger.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 9, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold passenger details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Passenger implements ABEDto {

	/**
	 * Default serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7427232484726263863L;

	/**
	 * @return the paxId
	 */
	public byte getPaxId() {
		return paxId;
	}

	/**
	 * @param paxId
	 *            the paxId to set
	 */
	public void setPaxId(byte paxId) {
		this.paxId = paxId;
	}

	/**
	 * @return the roomNumber
	 */
	public byte getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber
	 *            the roomNumber to set
	 */
	public void setRoomNumber(byte roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the ageCode
	 */
	public AgeCode getAgeCode() {
		return ageCode;
	}

	/**
	 * @param ageCode
	 *            the ageCode to set
	 */
	public void setAgeCode(AgeCode ageCode) {
		this.ageCode = ageCode;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	/**
	 * @return the guestCount
	 */
	public byte getGuestCount() {
		return guestCount;
	}

	/**
	 * @param guestCount
	 *            the guestCount to set
	 */
	public void setGuestCount(byte guestCount) {
		this.guestCount = guestCount;
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

	// Passenger ID
	private byte paxId;
	// Room number
	private byte roomNumber;
	// 7-Infant, 8-Child, 10-Adult, 11-Senior - determines pax type
	private AgeCode ageCode;
	// Age of the PAX, will be 0 for adult & senior
	private byte age;
	// No of passengers occupying the room
	private byte guestCount;
}