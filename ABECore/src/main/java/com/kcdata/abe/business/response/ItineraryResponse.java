/*
 * ItineraryResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.Date;
import java.util.List;

import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Response class to hold the itinerary booking information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9098890952715760636L;

	private Itinerary itinerary;
	private List<Itinerary> itineraries;
	/**
	 * @return the itineraries
	 */
	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	/**
	 * @param itineraries the itineraries to set
	 */
	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	private String htmlItinerary;
	private Date itineraryExtendDate;
	private String tokenNo;

	/**
	 * @return the tokenNo
	 */
	public String getTokenNo() {
		return tokenNo;
	}

	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * @return the itineraryExtendDate
	 */
	public Date getItineraryExtendDate() {
		return itineraryExtendDate;
	}

	/**
	 * @param itineraryExtendDate the itineraryExtendDate to set
	 */
	public void setItineraryExtendDate(Date itineraryExtendDate) {
		this.itineraryExtendDate = itineraryExtendDate;
	}

	/**
	 * @return the htmlItinerary
	 */
	public String getHtmlItinerary() {
		return htmlItinerary;
	}

	/**
	 * @param htmlItinerary the htmlItinerary to set
	 */
	public void setHtmlItinerary(String htmlItinerary) {
		this.htmlItinerary = htmlItinerary;
	}

	/**
	 * @return the itinerary
	 */
	public Itinerary getItinerary() {
		return itinerary;
	}

	/**
	 * @param itinerary
	 *            the itinerary to set
	 */
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
}
