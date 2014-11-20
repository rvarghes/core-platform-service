/*
 * BreakdownChargesHeader.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 3, 2010  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO for breakdown charges header details
 * 
 * @author nvittal
 */
public class BreakdownChargesHeader implements ABEDto {

	/**
	 * Default generated serial UID
	 */
	private static final long serialVersionUID = -3294157878597764766L;
	
	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}
	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	 * @return the bookingStatus
	 */
	public String getBookingStatus() {
		return bookingStatus;
	}
	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	/**
	 * @return the depositDue
	 */
	public double getDepositDue() {
		return depositDue;
	}
	/**
	 * @param depositDue the depositDue to set
	 */
	public void setDepositDue(double depositDue) {
		this.depositDue = depositDue;
	}
	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	private String customerNumber;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String postalCode;
	private Date bookingDate;
	private String bookingStatus;
	private double depositDue;
	private Date departureDate;
	private int duration;
}