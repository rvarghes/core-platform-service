/*
 * BookingStatus.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 28, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

/**
 * Enumeration for booking status
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public enum BookingStatus {
	OPT("OPT"), GTD("GTD"), PIF("PIF"), DRD("DRD"), CANC("CANC"), DEP("DEP"), EXP("EXP");
	
	private String status;
	
	//Private constructor
	private BookingStatus() {
	}
	
	private BookingStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Method to retrieve the status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isOption() {
		return this.status == OPT.status;
	}	
	
	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isGuaranteed() {
		return this.status == GTD.status;
	}

	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isPaidInFull() {
		return this.status == PIF.status;
	}	

	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isDepositReceived() {
		return this.status == DRD.status;
	}	

	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isCancelled() {
		return this.status == CANC.status;
	}	

	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isDeparted() {
		return this.status == DEP.status;
	}	

	/**
	 * Method to check booking status
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public boolean isExpired() {
		return this.status == EXP.status;
	}
}