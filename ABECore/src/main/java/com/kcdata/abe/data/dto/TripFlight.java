/*
 * TripFlight.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 * Sep 24, 2009  hguntupa	  Added negotiatedFareCode for packages
 * Mar 01, 2010	 hguntupa	  Added ticketedDate field for holding the PNR ticketed date
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.util.ABEConstants;

/**
 * Class to hold the roundtrip flight details Retrieve Flights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class TripFlight implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9113170582582069022L;
	private Flight outboundFlight;
	private Flight inboundFlight;
	private Price price;
	private int duration;
	private FlightTripType tripType;
	private FlightType flightType;
	private FlightStatus status;
	private Carrier carrier;
	// Contract details of the flight. Applicable for Bulk and Charter flights
	// only
	private String contractDocumentNo;
	private String revisionNo;
	private String lineNo;
	private Occupancy occupancy;
	private String guestAllocation;
	private String negotiatedFareCode;
	private SearchCriteria searchCriteria;
	private Date ticketedDate;
	private String seatMapConcatReq;
	private boolean visibleSeatMap;
	private String legIdConcat;
	//IGT--3620582---Nov02,2012--Sked flights showing allocated to the wrong passengers. Shows switched in ABE - E-Docs Display incorrectly
	/*code commented for revocation of 3620582 and it's setter & getter
	private String allocatedGuestNames;*/
	
	// Field used to track whether flight is changed in a package or not
	private boolean packageFlightNoChange;
	private boolean isHotelModified = ABEConstants.False;
	private boolean isCpPackage = ABEConstants.False;
	
	
	//IGT-A---Isue # 3620601---START
	private String flightIdForInternalUse;
	private String flightClassForInternalUse;
	private String flightRotForInternalUse;
	/*the _flightSelectedForDisplay variable will be true for those flights, which will come in display. 
		so, forming a group and changing the tripFlight of the same group will set selectedFlights' "_flightSelectedForDisplay" 
		variable to false, and newly selected tripFlight "_flightSelectedForDisplay" will be set to true.*/
	private boolean flightSelectedForDisplay = false;	
	//IGT-A---Isue # 3620601---END
	
	// Field added to set FlightItemRPH for ASA 20 Seat Selection not printing on paper docs
	private byte flightItemRPH;

	// Field added for Support Item #3535943 
	private double packagePrice;
	private boolean isPackagePriceSet = false;
	private double flightPriceAfterPricing;
	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria
	 *            the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	/**
	 * @return the outboundFlight
	 */
	public Flight getOutboundFlight() {
		return outboundFlight;
	}

	/**
	 * @param outboundFlight
	 *            the outboundFlight to set
	 */
	public void setOutboundFlight(Flight outboundFlight) {
		this.outboundFlight = outboundFlight;
	}

	/**
	 * @return the inboundFlight
	 */
	public Flight getInboundFlight() {
		return inboundFlight;
	}

	/**
	 * @param inboundFlight
	 *            the inboundFlight to set
	 */
	public void setInboundFlight(Flight inboundFlight) {
		this.inboundFlight = inboundFlight;
	}

	/**
	 * @return the price
	 */
	public Price getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Price price) {
		this.price = price;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the tripType
	 */
	public FlightTripType getTripType() {
		return tripType;
	}

	/**
	 * @param tripType
	 *            the tripType to set
	 */
	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}

	/**
	 * @return the flightType
	 */
	public FlightType getFlightType() {
		return flightType;
	}

	/**
	 * @param flightType
	 *            the flightType to set
	 */
	public void setFlightType(FlightType flightType) {
		this.flightType = flightType;
	}

	/**
	 * @return the status
	 */
	public FlightStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	/**
	 * @return the carrier
	 */
	public Carrier getCarrier() {
		return carrier;
	}

	/**
	 * @param carrier
	 *            the carrier to set
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	/**
	 * @return the contractDocumentNo
	 */
	public String getContractDocumentNo() {
		return contractDocumentNo;
	}

	/**
	 * @param contractDocumentNo
	 *            the contractDocumentNo to set
	 */
	public void setContractDocumentNo(String contractDocumentNo) {
		this.contractDocumentNo = contractDocumentNo;
	}

	/**
	 * @return the revisionNo
	 */
	public String getRevisionNo() {
		return revisionNo;
	}

	/**
	 * @param revisionNo
	 *            the revisionNo to set
	 */
	public void setRevisionNo(String revisionNo) {
		this.revisionNo = revisionNo;
	}

	/**
	 * @return the lineNo
	 */
	public String getLineNo() {
		return lineNo;
	}

	/**
	 * @param lineNo
	 *            the lineNo to set
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	/**
	 * @return the occupancy
	 */
	public Occupancy getOccupancy() {
		return occupancy;
	}

	/**
	 * @param occupancy
	 *            the occupancy to set
	 */
	public void setOccupancy(Occupancy occupancy) {
		this.occupancy = occupancy;
	}

	/**
	 * @return the guestAllocation
	 */
	public String getGuestAllocation() {
		return guestAllocation;
	}

	/**
	 * @param guestAllocation
	 *            the guestAllocation to set
	 */
	public void setGuestAllocation(String guestAllocation) {
		this.guestAllocation = guestAllocation;
	}

	/**
	 * @return the negotiatedFareCode
	 */
	public String getNegotiatedFareCode() {
		return negotiatedFareCode;
	}

	/**
	 * @param negotiatedFareCode
	 *            the negotiatedFareCode to set
	 */
	public void setNegotiatedFareCode(String negotiatedFareCode) {
		this.negotiatedFareCode = negotiatedFareCode;
	}

	/**
	 * @return the ticketedDate
	 */
	public Date getTicketedDate() {
		return ticketedDate;
	}

	/**
	 * @param ticketedDate
	 *            the ticketedDate to set
	 */
	public void setTicketedDate(Date ticketedDate) {
		this.ticketedDate = ticketedDate;
	}

	/**
	 * @return the packageFlightNoChange
	 */
	public boolean isPackageFlightNoChange() {
		return packageFlightNoChange;
	}

	/**
	 * @param packageFlightNoChange
	 *            the packageFlightNoChange to set
	 */
	public void setPackageFlightNoChange(boolean packageFlightNoChange) {
		this.packageFlightNoChange = packageFlightNoChange;
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
		TripFlight tripFlight = (TripFlight) super.clone();
		if (outboundFlight != null) {
			tripFlight.outboundFlight = (Flight) outboundFlight.clone();
		}
		if (inboundFlight != null) {
			tripFlight.inboundFlight = (Flight) inboundFlight.clone();
		}
		if (price != null) {
			tripFlight.price = (Price) price.clone();
		}
		if (occupancy != null) {
			tripFlight.occupancy = (Occupancy) occupancy.clone();
		}
		if (searchCriteria != null) {
			tripFlight.searchCriteria = (SearchCriteria) searchCriteria.clone();
		}

		return tripFlight;
	}

	public String getSeatMapConcatReq() {
		return seatMapConcatReq;
	}

	public void setSeatMapConcatReq(String seatMapConcatReq) {
		this.seatMapConcatReq = seatMapConcatReq;
	}

	public boolean isVisibleSeatMap() {
		return visibleSeatMap;
	}

	public void setVisibleSeatMap(boolean visibleSeatMap) {
		this.visibleSeatMap = visibleSeatMap;
	}

	public String getLegIdConcat() {
		return legIdConcat;
	}

	public void setLegIdConcat(String legIdConcat) {
		this.legIdConcat = legIdConcat;
	}

	/**
	 * @return the isHotelModified
	 */
	public boolean isHotelModified() {
		return isHotelModified;
	}

	/**
	 * @param isHotelModified the isHotelModified to set
	 */
	public void setHotelModified(boolean isHotelModified) {
		this.isHotelModified = isHotelModified;
	}

	/**
	 * @return the isCpPackage
	 */
	public boolean isCpPackage() {
		return isCpPackage;
	}

	/**
	 * @param isCpPackage the isCpPackage to set
	 */
	public void setCpPackage(boolean isCpPackage) {
		this.isCpPackage = isCpPackage;
	}

	/**
	 * @return the flightItemRPH
	 */
	public byte getFlightItemRPH() {
		return flightItemRPH;
	}

	/**
	 * @param flightItemRPH the flightItemRPH to set
	 */
	public void setFlightItemRPH(byte flightItemRPH) {
		this.flightItemRPH = flightItemRPH;
	}
	/**
	 * @return the allocatedGuestNames
	 */
	/*public String getAllocatedGuestNames() {
		return allocatedGuestNames;
	}*/

	/**
	 * @param allocatedGuestNames the allocatedGuestNames to set
	 */
	/*public void setAllocatedGuestNames(String allocatedGuestNames) {
		this.allocatedGuestNames = allocatedGuestNames;
	}*/

	/**
	 * @return the packagePrice
	 */
	public double getPackagePrice() {
		return packagePrice;
	}

	/**
	 * @param packagePrice the packagePrice to set
	 */
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}


	//IGT-A--Issue # 3620601---START
	/**
	 * @return the flightIdForInternalUse
	 */
	public String getFlightIdForInternalUse() {
		return flightIdForInternalUse;
	}

	/**
	 * @param flightIdForInternalUse the flightIdForInternalUse to set
	 */
	public void setFlightIdForInternalUse(String flightIdForInternalUse) {
		this.flightIdForInternalUse = flightIdForInternalUse;
	}

	/**
	 * @return the flightClassForInternalUse
	 */
	public String getFlightClassForInternalUse() {
		return flightClassForInternalUse;
	}

	/**
	 * @param flightClassForInternalUse the flightClassForInternalUse to set
	 */
	public void setFlightClassForInternalUse(String flightClassForInternalUse) {
		this.flightClassForInternalUse = flightClassForInternalUse;
	}

	/**
	 * @return the flightRotForInternalUse
	 */
	public String getFlightRotForInternalUse() {
		return flightRotForInternalUse;
	}

	/**
	 * @param flightRotForInternalUse the flightRotForInternalUse to set
	 */
	public void setFlightRotForInternalUse(String flightRotForInternalUse) {
		this.flightRotForInternalUse = flightRotForInternalUse;
	}

	/**
	 * @return the flightSelectedForDisplay
	 */
	public boolean isFlightSelectedForDisplay() {
		return flightSelectedForDisplay;
	}

	/**
	 * @param flightSelectedForDisplay the flightSelectedForDisplay to set
	 */
	public void setFlightSelectedForDisplay(boolean flightSelectedForDisplay) {
		this.flightSelectedForDisplay = flightSelectedForDisplay;
	}
	//IGT-A--Issue # 3620601---END

	/**
	 * @return the isPackagePriceSet
	 */
	public boolean isPackagePriceSet() {
		return isPackagePriceSet;
	}

	/**
	 * @param isPackagePriceSet the isPackagePriceSet to set
	 */
	public void setPackagePriceSet(boolean isPackagePriceSet) {
		this.isPackagePriceSet = isPackagePriceSet;
	}

	/**
	 * @return the flightPriceAfterPricing
	 */
	public double getFlightPriceAfterPricing() {
		return flightPriceAfterPricing;
	}

	/**
	 * @param flightPriceAfterPricing the flightPriceAfterPricing to set
	 */
	public void setFlightPriceAfterPricing(double flightPriceAfterPricing) {
		this.flightPriceAfterPricing = flightPriceAfterPricing;
	}

}
