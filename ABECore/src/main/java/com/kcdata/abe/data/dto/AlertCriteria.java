/*
 * AlertCriteria.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class holds Alert Criteria to fetch the alerts and advisory list
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AlertCriteria implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8270371861232523793L;
	
	
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
	 * @return the travelDate
	 */
	public Date getTravelDate() {
		return travelDate;
	}

	/**
	 * @param travelDate
	 *            the travelDate to set
	 */
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * @return the salesOrg
	 */
	public String getSalesOrg() {
		return salesOrg;
	}

	/**
	 * @param salesOrg
	 *            the salesOrg to set
	 */
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
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
	 * Returns the String representation of Alert object
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<AlertCriteria>\n");
		sb.append("gateway: "+gateway+"\n");
		sb.append("destination: "+destination+"\n");
		sb.append("bookingDate: "+bookingDate+"\n");
		sb.append("travelDate: "+travelDate+"\n");
		sb.append("material: "+material+"\n");
		sb.append("salesOrg: "+salesOrg+"\n");
		sb.append("duration: "+duration+"\n");
		sb.append("</AlertCriteria>");

		return sb.toString();
	}
	
	
	private String gateway;
	private String destination;
	private Date bookingDate;
	private Date travelDate;
	private String material;
	private String salesOrg;
	private int duration;

}
