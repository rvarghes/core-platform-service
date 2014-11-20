/*
 * OpsAlert.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 6, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold operation alerts information
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class OpsAlert implements ABEDto {

	/**
	 * Default Serial UID.
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4905104804965221201L;

	private List<AlertType> alertTypes;
	private List<ActionType> actionTypes;
	private String actionCode;
	private String alertCode;
	private String instructions;
	private String hotelName;
	private String userName;
	private String localtelephNo;
	private String service;
	private String reprintDoc;
	private String type;
	private IMApplicationInfo imApplicationInfo;
	private FlightTransferInfo inFlightInfo;
	private FlightTransferInfo outFlightInfo;
	private List<GuestInfo> guests;
	private Address documentAddress;
	private BookingHeader bookingHeader;
	private String travelAgencyAccountNo;

	/**
	 * @return the alertTypes
	 */
	public List<AlertType> getAlertTypes() {
		return alertTypes;
	}

	/**
	 * @param alertTypes
	 *            the alertTypes to set
	 */
	public void setAlertTypes(List<AlertType> alertTypes) {
		this.alertTypes = alertTypes;
	}

	/**
	 * @return the actionTypes
	 */
	public List<ActionType> getActionTypes() {
		return actionTypes;
	}

	/**
	 * @param actionTypes
	 *            the actionTypes to set
	 */
	public void setActionTypes(List<ActionType> actionTypes) {
		this.actionTypes = actionTypes;
	}

	/**
	 * @return the actionCode
	 */
	public String getActionCode() {
		return actionCode;
	}

	/**
	 * @param actionCode
	 *            the actionCode to set
	 */
	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	/**
	 * @return the alertCode
	 */
	public String getAlertCode() {
		return alertCode;
	}

	/**
	 * @param alertCode
	 *            the alertCode to set
	 */
	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}

	/**
	 * @return the instructions
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions
	 *            the instructions to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName
	 *            the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the localtelephNo
	 */
	public String getLocaltelephNo() {
		return localtelephNo;
	}

	/**
	 * @param localtelephNo
	 *            the localtelephNo to set
	 */
	public void setLocaltelephNo(String localtelephNo) {
		this.localtelephNo = localtelephNo;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the reprintDoc
	 */
	public String getReprintDoc() {
		return reprintDoc;
	}

	/**
	 * @param reprintDoc
	 *            the reprintDoc to set
	 */
	public void setReprintDoc(String reprintDoc) {
		this.reprintDoc = reprintDoc;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the imApplicationInfo
	 */
	public IMApplicationInfo getImApplicationInfo() {
		return imApplicationInfo;
	}

	/**
	 * @param imApplicationInfo
	 *            the imApplicationInfo to set
	 */
	public void setImApplicationInfo(IMApplicationInfo imApplicationInfo) {
		this.imApplicationInfo = imApplicationInfo;
	}

	/**
	 * @return the inFlightInfo
	 */
	public FlightTransferInfo getInFlightInfo() {
		return inFlightInfo;
	}

	/**
	 * @param inFlightInfo
	 *            the inFlightInfo to set
	 */
	public void setInFlightInfo(FlightTransferInfo inFlightInfo) {
		this.inFlightInfo = inFlightInfo;
	}

	/**
	 * @return the outFlightInfo
	 */
	public FlightTransferInfo getOutFlightInfo() {
		return outFlightInfo;
	}

	/**
	 * @param outFlightInfo
	 *            the outFlightInfo to set
	 */
	public void setOutFlightInfo(FlightTransferInfo outFlightInfo) {
		this.outFlightInfo = outFlightInfo;
	}

	/**
	 * @return the guests
	 */
	public List<GuestInfo> getGuests() {
		return guests;
	}

	/**
	 * @param guests
	 *            the guests to set
	 */
	public void setGuests(List<GuestInfo> guests) {
		this.guests = guests;
	}

	/**
	 * @return the documentAddress
	 */
	public Address getDocumentAddress() {
		return documentAddress;
	}

	/**
	 * @param documentAddress
	 *            the documentAddress to set
	 */
	public void setDocumentAddress(Address documentAddress) {
		this.documentAddress = documentAddress;
	}

	/**
	 * @return the bookingHeader
	 */
	public BookingHeader getBookingHeader() {
		return bookingHeader;
	}

	/**
	 * @param bookingHeader
	 *            the bookingHeader to set
	 */
	public void setBookingHeader(BookingHeader bookingHeader) {
		this.bookingHeader = bookingHeader;
	}

	/**
	 * @return the travelAgencyAccountNo
	 */
	public String getTravelAgencyAccountNo() {
		return travelAgencyAccountNo;
	}

	/**
	 * @param travelAgencyAccountNo
	 *            the travelAgencyAccountNo to set
	 */
	public void setTravelAgencyAccountNo(String travelAgencyAccountNo) {
		this.travelAgencyAccountNo = travelAgencyAccountNo;
	}

}
