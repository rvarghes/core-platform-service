/*
 * InsuranceGuestAllocation.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the Guest Allocation for Insurance
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class InsuranceGuestAllocation implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -767307762042595277L;

	private String guestID;
	private String posnr;
	private String oldPosnr;
	private double price;

	/**
	 * @return the guestID
	 */
	public String getGuestID() {
		return guestID;
	}

	/**
	 * @param guestID
	 *            the guestID to set
	 */
	public void setGuestID(String guestID) {
		this.guestID = guestID;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr
	 *            the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the oldPosnr
	 */
	public String getOldPosnr() {
		return oldPosnr;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @param oldPosnr
	 *            the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
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
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
