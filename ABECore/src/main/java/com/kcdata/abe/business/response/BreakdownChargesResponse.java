/*
 * BreakdownChargesResponse.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.BreakdownChargesHeader;
import com.kcdata.abe.data.dto.GuestBreakdownCharge;
import com.kcdata.abe.data.dto.GuestBreakdownCommissionCharge;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.framework.response.ABEResponse;

public class BreakdownChargesResponse extends ABEResponse {

	/**
	 * Generated serial version UID
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9059363078760262760L;
	
	/**
	 * @return the breakdownChargesHeader
	 */
	public BreakdownChargesHeader getBreakdownChargesHeader() {
		return breakdownChargesHeader;
	}
	/**
	 * @param breakdownChargesHeader the breakdownChargesHeader to set
	 */
	public void setBreakdownChargesHeader(
			BreakdownChargesHeader breakdownChargesHeader) {
		this.breakdownChargesHeader = breakdownChargesHeader;
	}
	/**
	 * @return the breakdownCharges
	 */
	public List<GuestBreakdownCharge> getBreakdownCharges() {
		return breakdownCharges;
	}
	/**
	 * @param breakdownCharges the breakdownCharges to set
	 */
	public void setBreakdownCharges(List<GuestBreakdownCharge> breakdownCharges) {
		this.breakdownCharges = breakdownCharges;
	}
	/**
	 * @return the commissionCharges
	 */
	public List<GuestBreakdownCommissionCharge> getCommissionCharges() {
		return commissionCharges;
	}
	/**
	 * @param commissionCharges the commissionCharges to set
	 */
	public void setCommissionCharges(
			List<GuestBreakdownCommissionCharge> commissionCharges) {
		this.commissionCharges = commissionCharges;
	}
	/**
	 * @return the bookingHeader
	 */
	public BookingHeader getBookingHeader() {
		return bookingHeader;
	}
	/**
	 * @param bookingHeader the bookingHeader to set
	 */
	public void setBookingHeader(BookingHeader bookingHeader) {
		this.bookingHeader = bookingHeader;
	}
	/**
	 * @return the guests
	 */
	public List<GuestInfo> getGuests() {
		return guests;
	}
	/**
	 * @param guests the guests to set
	 */
	public void setGuests(List<GuestInfo> guests) {
		this.guests = guests;
	}
	/**
	 * @param applicationInfo the applicationInfo to set
	 */
	public void setApplicationInfo(IMApplicationInfo applicationInfo) {
		this.applicationInfo = applicationInfo;
	}
	/**
	 * @return the applicationInfo
	 */
	public IMApplicationInfo getApplicationInfo() {
		return applicationInfo;
	}
	private BreakdownChargesHeader breakdownChargesHeader;
	private List<GuestBreakdownCharge> breakdownCharges;
	private List<GuestBreakdownCommissionCharge> commissionCharges;
	private BookingHeader bookingHeader;
	private List<GuestInfo> guests; 
	private IMApplicationInfo applicationInfo;
}