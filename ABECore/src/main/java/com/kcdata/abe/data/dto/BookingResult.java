/*
 * BookingResult.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for holding booking search result data
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class BookingResult implements ABEDto {

	/**
	 * Default generated serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -2687071509343583784L;

	/**
	 * @return the bookingNo
	 */
	public String getBookingNo() {
		return bookingNo;
	}
	/**
	 * @param bookingNo the bookingNo to set
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the agencyName1
	 */
	public String getAgencyName1() {
		return agencyName1;
	}
	/**
	 * @param agencyName1 the agencyName1 to set
	 */
	public void setAgencyName1(String agencyName1) {
		this.agencyName1 = agencyName1;
	}
	/**
	 * @return the agencyName2
	 */
	public String getAgencyName2() {
		return agencyName2;
	}
	/**
	 * @param agencyName2 the agencyName2 to set
	 */
	public void setAgencyName2(String agencyName2) {
		this.agencyName2 = agencyName2;
	}
	/**
	 * @return the tourId
	 */
	public String getTourId() {
		return tourId;
	}
	/**
	 * @param tourId the tourId to set
	 */
	public void setTourId(String tourId) {
		this.tourId = tourId;
	}
	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}
	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	/**
	 * @return the iataNo
	 */
	public String getIataNo() {
		return iataNo;
	}
	/**
	 * @param iataNo the iataNo to set
	 */
	public void setIataNo(String iataNo) {
		this.iataNo = iataNo;
	}
	/**
	 * @return the bookingStatus
	 */
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the royaltyNo
	 */
	public String getRoyaltyNo() {
		return royaltyNo;
	}
	/**
	 * @param royaltyNo the royaltyNo to set
	 */
	public void setRoyaltyNo(String royaltyNo) {
		this.royaltyNo = royaltyNo;
	}
	
	/**
	 * Return the String representation of booking result
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<BookingResult>\n");
		sb.append("bookingNo: " + bookingNo + "\n");
		sb.append("firstName: " + firstName + "\n");
		sb.append("lastName: " + lastName + "\n");
		sb.append("agencyName1: " + agencyName1 + "\n");
		sb.append("agencyName2: " + agencyName2 + "\n");
		sb.append("tourId: " + tourId + "\n");
		sb.append("bookingDate: " + bookingDate + "\n");
		sb.append("iataNo: " + iataNo + "\n");
		sb.append("bookingStatus: " + bookingStatus + "\n");
		sb.append("amount: "+amount+"\n");
		sb.append("royaltyNo: "+royaltyNo+"\n");
		sb.append("</BookingResult>");

		return sb.toString();
	}
	
	private String bookingNo;
	private String firstName;
	private String lastName;
	private String agencyName1;
	private String agencyName2;
	private String tourId;
	private Date bookingDate;
	private String iataNo;
	// OPT(Option), GTD(Guaranteed), PIF(Paid in full), DRD(Deposit Received), CANC(Cancelled), DEP(Departed), EXP(Expired)
	private BookingStatus bookingStatus;
	private double amount;
	private String royaltyNo;
}