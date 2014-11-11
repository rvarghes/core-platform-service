/*
 * HotelOptions.java
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

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold options for hotel availability search
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelOptions implements ABEDto {

	/**
	 * Default serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 7073226707326477883L;

	/**
	 * @return the noOfRooms
	 */
	public int getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * @param noOfRooms
	 *            the noOfRooms to set
	 */
	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	/**
	 * @return the resortArea
	 */
	public ResortArea getResortArea() {
		return resortArea;
	}

	/**
	 * @param resortArea
	 *            the resortArea to set
	 */
	public void setResortArea(ResortArea resortArea) {
		this.resortArea = resortArea;
	}

	/**
	 * @return the hotelCode
	 */
	public String getHotelCode() {
		return hotelCode;
	}

	/**
	 * @param hotelCode
	 *            the hotelCode to set
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
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
	 * @return the appleRating
	 */
	public String getAppleRating() {
		return appleRating;
	}

	/**
	 * @param appleRating
	 *            the appleRating to set
	 */
	public void setAppleRating(String appleRating) {
		this.appleRating = appleRating;
	}

	/**
	 * @return the hotelChain
	 */
	public String getHotelChain() {
		return hotelChain;
	}

	/**
	 * @param hotelChain
	 *            the hotelChain to set
	 */
	public void setHotelChain(String hotelChain) {
		this.hotelChain = hotelChain;
	}

	

	/**
	 * @return the showAll
	 */
	public boolean isShowAll() {
		return showAll;
	}

	/**
	 * @param showAll
	 *            the showAll to set
	 */
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	/**
	 * @return the amenities
	 */
	public List<Amenity> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities
	 *            the amenities to set
	 */
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the roomTypeCode
	 */
	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	/**
	 * @param roomTypeCode
	 *            the roomTypeCode to set
	 */
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	/**
	 * @return the ratePlanCode
	 */
	public String getRatePlanCode() {
		return ratePlanCode;
	}

	/**
	 * @param ratePlanCode
	 *            the ratePlanCode to set
	 */
	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}

	/**
	 * @return the gdsHotelCode
	 */
	public String getGdsHotelCode() {
		return gdsHotelCode;
	}

	/**
	 * @param gdsHotelCode the gdsHotelCode to set
	 */
	public void setGdsHotelCode(String gdsHotelCode) {
		this.gdsHotelCode = gdsHotelCode;
	}

	
	/**
	 * @return the showTierOne
	 */
	public boolean isShowTierOne() {
		return showTierOne;
	}

	/**
	 * @param showTierOne the showTierOne to set
	 */
	public void setShowTierOne(boolean showTierOne) {
		this.showTierOne = showTierOne;
	}

	/**
	 * @return the noTierOne
	 */
	public boolean isNoTierOne() {
		return noTierOne;
	}

	/**
	 * @param showTierOne the showTierOne to set
	 */
	public void setNoTierOne(boolean noTierOne) {
		this.noTierOne = noTierOne;
	}
	/**
	 * @return the showMore
	 */
	public boolean isShowMore() {
		return showMore;
	}

	/**
	 * @param showMore the showMore to set
	 */
	public void setShowMore(boolean showMore) {
		this.showMore = showMore;
	}
	
	/**
	 * @return the infoMessage
	 */
	public boolean isInfoMessage() {
		return infoMessage;
	}

	/**
	 * @param infoMessage the infoMessage to set
	 */
	public void setInfoMessage(boolean infoMessage) {
		this.infoMessage = infoMessage;
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
		HotelOptions options = (HotelOptions) super.clone();
		if (resortArea != null) {
			options.resortArea = (ResortArea) resortArea.clone();
		}
		if (amenities != null) {
			ArrayList<Amenity> amenList = new ArrayList<Amenity>();
			for (Amenity amenity : amenities) {
				amenList.add((Amenity) amenity.clone());
			}
			options.amenities = amenList;
		}
		return options;
	}

	public String getShow_All() {
		return show_All;
	}

	public void setShow_All(String show_All) {
		this.show_All = show_All;
	}

	private int noOfRooms;
	private ResortArea resortArea;
	private String hotelCode;
	private String hotelName;
	private String appleRating;
	private String hotelChain;
	//Flag for status indicator, true displays tier1 hotels
	private boolean showTierOne;
	private boolean noTierOne;
	//Flag for status indicator, true displays non tier1 hotels
	private boolean showMore;
	// Flag for status indicator (O,R,Q,C status), true displays all hotels
	private boolean infoMessage;
	// Flag for  PAGE_NUM Of table IT_REQUEST_OPT Will have value ‘S’ 
	private boolean showAll;
	private String show_All;
	private List<Amenity> amenities;
	private String roomTypeCode;
	private String ratePlanCode;
	private String gdsHotelCode;
}