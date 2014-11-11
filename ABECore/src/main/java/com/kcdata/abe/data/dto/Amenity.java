/*
 * Amenity.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 29, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold hotel amenity information
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class Amenity implements ABEDto {

	/**
	 * Default Serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8743457695898500738L;

	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}
	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	/**
	 * @return the roomCategoryId
	 */
	public int getRoomCategoryId() {
		return roomCategoryId;
	}
	/**
	 * @param roomCategoryId the roomCategoryId to set
	 */
	public void setRoomCategoryId(int roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}
	/**
	 * @return the amenityCode
	 */
	public String getAmenityCode() {
		return amenityCode;
	}
	/**
	 * @param amenityCode the amenityCode to set
	 */
	public void setAmenityCode(String amenityCode) {
		this.amenityCode = amenityCode;
	}
	/**
	 * @return the amenityName
	 */
	public String getAmenityName() {
		return amenityName;
	}
	/**
	 * @param amenityName the amenityName to set
	 */
	public void setAmenityName(String amenityName) {
		this.amenityName = amenityName;
	}	
	/**
	 * @return the amenityDate
	 */
	public Date getAmenityDate() {
		return amenityDate;
	}
	/**
	 * @param amenityDate the amenityDate to set
	 */
	public void setAmenityDate(Date amenityDate) {
		this.amenityDate = amenityDate;
	}
	/**
	 * @return the amenityValue
	 */
	public String getAmenityValue() {
		return amenityValue;
	}
	/**
	 * @param amenityValue the amenityValue to set
	 */
	public void setAmenityValue(String amenityValue) {
		this.amenityValue = amenityValue;
	}
	/**
	 * Returns the String representation of Amenity object
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Amenity>\n");
		sb.append("hotelId: "+hotelId+"\n");
		sb.append("roomCategoryId: "+roomCategoryId+"\n");
		sb.append("amenityCode: "+amenityCode+"\n");
		sb.append("amenityName: "+amenityName+"\n");
		sb.append("amenityDate: "+amenityDate+"\n");
		sb.append("amenityValue: "+amenityValue+"\n");
		sb.append("</Amenity>");

		return sb.toString();
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
		return super.clone();
	}
	
	private int hotelId;
	private int roomCategoryId;
	private String amenityCode;
	private String amenityName;
	private Date amenityDate;
	private String amenityValue;
}
