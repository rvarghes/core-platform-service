/*
 * BookingSearchCriteria.java
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
 * Value object for bookings search criteria
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class BookingSearchCriteria implements ABEDto {

	/**
	 * Default generated Serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6075427724814728845L;

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the iataNo
	 */
	public String getIataNo() {
		return iataNo;
	}

	/**
	 * @param iataNo
	 *            the iataNo to set
	 */
	public void setIataNo(String iataNo) {
		this.iataNo = iataNo;
	}

	/**
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * @param customerNo
	 *            the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @param gateway
	 *            the gateway to set
	 */
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	/**
	 * @return the bookingDate
	 */
	public Date getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate
	 *            the bookingDate to set
	 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the quoteNo
	 */
	public String getQuoteNo() {
		return quoteNo;
	}

	/**
	 * @param quoteNo
	 *            the quoteNo to set
	 */
	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
	}

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName
	 *            the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the searchLevel
	 */
	public char getSearchLevel() {
		return searchLevel;
	}

	/**
	 * @param searchLevel
	 *            the searchLevel to set
	 */
	public void setSearchLevel(char searchLevel) {
		this.searchLevel = searchLevel;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the royaltyNo
	 */
	public String getRoyaltyNo() {
		return royaltyNo;
	}

	/**
	 * @param royaltyNo
	 *            the royaltyNo to set
	 */
	public void setRoyaltyNo(String royaltyNo) {
		this.royaltyNo = royaltyNo;
	}
	
	
	/**
	 * @return the bookingStartDate
	 */
	public Date getBookingStartDate() {
		return bookingStartDate;
	}

	/**
	 * @param bookingStartDate the bookingStartDate to set
	 */
	public void setBookingStartDate(Date bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	/**
	 * @return the bookingEndDate
	 */
	public Date getBookingEndDate() {
		return bookingEndDate;
	}

	/**
	 * @param bookingEndDate the bookingEndDate to set
	 */
	public void setBookingEndDate(Date bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	
	

	/**
	 * Return the String representation of booking search criteria
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<BookingSearchCriteria>\n");
		sb.append("lastName: " + lastName + "\n");
		sb.append("firstName: " + firstName + "\n");
		sb.append("iataNo: " + iataNo + "\n");
		sb.append("customerNo: " + customerNo + "\n");
		sb.append("destination: " + destination + "\n");
		sb.append("gateway: " + gateway + "\n");
		sb.append("bookingDate: " + bookingDate + "\n");
		sb.append("quoteNo: " + quoteNo + "\n");
		sb.append("agentName: " + agentName + "\n");
		sb.append("departureDate: "+departureDate+"\n");
		sb.append("searchLevel: "+searchLevel+"\n");
		sb.append("createdBy: "+createdBy+"\n");
		sb.append("royaltyNo: "+royaltyNo+"\n");
		sb.append("bookingStartDate: "+bookingStartDate+"\n");
		sb.append("bookingEndDate: "+bookingEndDate+"\n");
		sb.append("</BookingSearchCriteria>");

		return sb.toString();
	}
	
	private String lastName;
	private String firstName;
	private String iataNo;
	private String customerNo;
	private String destination;
	private String gateway;
	private Date bookingDate;
	private String quoteNo;
	private String agentName;
	private Date departureDate;
	// Search level Low/Medium/High for basic/advance/search all 
	// based on bookings made in last 60/180/365 days
	private char searchLevel;
	private String createdBy;
	private String royaltyNo;	
	private Date bookingStartDate;
	private Date bookingEndDate;
	
}