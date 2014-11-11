/*
 * ItinerarySearchCriteria.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 31, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

public class ItinerarySearchCriteria implements ABEDto {


	/**
	 * Auto generated serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8332935924190355265L;

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
	 * Return the String representation of booking search criteria
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<ItinerarySearchCriteria>\n");
		sb.append("iataNo: " + iataNo + "\n");
		sb.append("customerNo: " + customerNo + "\n");
		sb.append("destination: " + destination + "\n");
		sb.append("gateway: " + gateway + "\n");
		sb.append("quoteNo: " + quoteNo + "\n");
		sb.append("agentName: " + agentName + "\n");
		sb.append("departureDate: "+departureDate+"\n");
		sb.append("searchLevel: "+searchLevel+"\n");
		sb.append("createdBy: "+createdBy+"\n");
		sb.append("</ItinerarySearchCriteria>");

		return sb.toString();
	}
	
	public void setItineraryDate(Date itineraryDate) {
		this.itineraryDate = itineraryDate;
	}

	public Date getItineraryDate() {
		return itineraryDate;
	}

	private String iataNo;
	private String customerNo;
	private String destination;
	private String gateway;
	private Date itineraryDate;
	private String quoteNo;
	private String agentName;
	private Date departureDate;
	// Search level Low/Medium/High for basic/advance/search all 
	// based on bookings made in last 60/180/365 days
	private char searchLevel;
	private String createdBy;
}
