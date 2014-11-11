/*
 * HotelConfirmation.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 30,2014    rvarghes
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

public class HotelConfirmation {
	private String hotelPMSConfirmationNo;
	private String sourceReservationID;
	private String sapBookingNo;
	private String identifier;
	private String hotelPNRNo;
	/**
	 * @param hotelPMSConfirmationNo this is Property Management System(PMS) confirmation
	 */
	public void setHotelPMSConfirmationNo(String hotelPMSConfirmationNo) {
		this.hotelPMSConfirmationNo = hotelPMSConfirmationNo;
	}
	public String getHotelPMSConfirmationNo() {
		return hotelPMSConfirmationNo;
	}
	public String getSourceReservationID() {
		return sourceReservationID;
	}
	public String getSapBookingNo() {
		return sapBookingNo;
	}
	public String getIdentifier() {
		return identifier;
	}
	/**
	 * @param sourceReservationID the sourceReservationID is currently held in WebDB2
	 * @param sourceReservationID that contains this pattern (<sapbookingno>+<vendorid>+<datetimestamp>)
	 */
	public void setSourceReservationID(String sourceReservationID) {
		this.sourceReservationID = sourceReservationID;
	}
	/**
	 * @param sapBookingNo the sapBookingNo is booking reference number of SAP
	 */
	public void setSapBookingNo(String sapBookingNo) {
		this.sapBookingNo = sapBookingNo;
	}
	/**
	 * @param identifier the identifier is used by HBSI to track revision. Not used currently
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getHotelPNRNo() {
		return hotelPNRNo;
	}
	public void setHotelPNRNo(String hotelPNRNo) {
		this.hotelPNRNo = hotelPNRNo;
	}
}
