/*
 * EdocsInfo.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the Edoc information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class EdocsInfo implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1504025470197379837L;

	private String bookingNumber;
	private Agent agentDetails;
	private List<GuestInfo> guests;
	private boolean edocsAccepted;
	private String customerNumber;
	private String taEmail;
	private String callCenter;
	private boolean clientEdocsOnly;

	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber
	 *            the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	/**
	 * @return the agentDetails
	 */
	public Agent getAgentDetails() {
		return agentDetails;
	}

	/**
	 * @param agentDetails
	 *            the agentDetails to set
	 */
	public void setAgentDetails(Agent agentDetails) {
		this.agentDetails = agentDetails;
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
	 * @return the edocsAccepted
	 */
	public boolean isEdocsAccepted() {
		return edocsAccepted;
	}

	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber
	 *            the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @param edocsAccepted
	 *            the edocsAccepted to set
	 */
	public void setEdocsAccepted(boolean edocsAccepted) {
		this.edocsAccepted = edocsAccepted;
	}

	/**
	 * @return the taEmail
	 */
	public String getTaEmail() {
		return taEmail;
	}

	/**
	 * @param taEmail
	 *            the taEmail to set
	 */
	public void setTaEmail(String taEmail) {
		this.taEmail = taEmail;
	}

	/**
	 * @return the callCenter
	 */
	public String getCallCenter() {
		return callCenter;
	}

	/**
	 * @param callCenter
	 *            the callCenter to set
	 */
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	/**
	 * @return the clientEdocsOnly
	 */
	public boolean isClientEdocsOnly() {
		return clientEdocsOnly;
	}

	/**
	 * @param clientEdocsOnly
	 *            the clientEdocsOnly to set
	 */
	public void setClientEdocsOnly(boolean clientEdocsOnly) {
		this.clientEdocsOnly = clientEdocsOnly;
	}

	/**
	 * Returns the String representation of agent object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<EdocsInfo>\n");
		sb.append("bookingNumber: " + bookingNumber + "\n");
		sb.append("agentDetails: " + agentDetails + "\n");
		sb.append("guests: " + guests + "\n");
		sb.append("edocsAccepted: " + edocsAccepted + "\n");
		sb.append("customerNumber: " + customerNumber + "\n");
		sb.append("taEmail: " + taEmail + "\n");
		sb.append("</EdocsInfo>");
		return sb.toString();
	}

	/**
	 * Clone method implementation
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	protected Object clone() throws CloneNotSupportedException {
		EdocsInfo edocsInfo = (EdocsInfo) super.clone();
		if (agentDetails != null) {
			edocsInfo.setAgentDetails((Agent) agentDetails.clone());
		}
		if (guests != null) {
			ArrayList<GuestInfo> guestsList = new ArrayList<GuestInfo>();
			for (GuestInfo guestInfo : guests) {
				guestsList.add((GuestInfo) guestInfo.clone());
			}
			edocsInfo.setGuests(guestsList);
		}
		return edocsInfo;
	}
}
