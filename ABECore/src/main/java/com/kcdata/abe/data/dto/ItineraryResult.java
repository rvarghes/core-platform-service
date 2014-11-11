/*
 * ItineraryResult.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 6, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

public class ItineraryResult implements ABEDto {
	
	/**
	 * Auto generated serial id.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8516812333280300063L;
	
	/**
	 * @return the quoteNo
	 */
	public String getQuoteNo() {
		return quoteNo;
	}
	/**
	 * @param quoteNo the quoteNo to set
	 */
	public void setQuoteNo(String quoteNo) {
		this.quoteNo = quoteNo;
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
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * @param customerNo the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
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
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * set the itinerary creation date
	 *
	 * @param itineraryDate
	 *
	 * @see
	 * @since
	 */
	public void setItineraryDate(Date itineraryDate) {
		this.itineraryDate = itineraryDate;
	}
	
	/**
	 * 
	 * Get the itinerary creation date 
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	public Date getItineraryDate() {
		return itineraryDate;
	}
	
	private String quoteNo;
	private String name;
	private String agencyName1;
	private String agencyName2;
	private String iataNo;
	private String customerNo;
	private String tourId;
	private Date itineraryDate;
	private double amount;
}
