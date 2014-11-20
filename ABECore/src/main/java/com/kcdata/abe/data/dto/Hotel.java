/*
 * Hotel.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold hotel data
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Hotel implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7412826460083331339L;

	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId
	 *            the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the hotelCode
	 */
	public String getHotelCode() {
		return hotelCode;
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
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate
	 *            the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the minRate
	 */
	public double getMinRate() {
		return minRate;
	}

	/**
	 * @param minRate
	 *            the minRate to set
	 */
	public void setMinRate(double minRate) {
		this.minRate = minRate;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the rooms
	 */
	public List<RoomCategory> getRoomCategories() {
		return roomCategories;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRoomCategories(List<RoomCategory> roomCategories) {
		this.roomCategories = roomCategories;
	}

	/**
	 * @return the vendorServices
	 */
	public List<VendorService> getVendorServices() {
		return vendorServices;
	}

	/**
	 * @param vendorServices
	 *            the vendorServices to set
	 */
	public void setVendorServices(List<VendorService> vendorServices) {
		this.vendorServices = vendorServices;
	}

	/**
	 * @return the displayRoomCategory
	 */
	public RoomCategory getDisplayRoomCategory() {
		return displayRoomCategory;
	}

	/**
	 * @param displayRoomCategory
	 *            the displayRoomCategory to set
	 */
	public void setDisplayRoomCategory(RoomCategory displayRoomCategory) {
		this.displayRoomCategory = displayRoomCategory;
	}

	/**
	 * @return the preselectedRooms
	 */
	public List<RoomPrice> getPreselectedRooms() {
		return preselectedRooms;
	}

	/**
	 * @param preselectedRooms
	 *            the preselectedRooms to set
	 */
	public void setPreselectedRooms(List<RoomPrice> preselectedRooms) {
		this.preselectedRooms = preselectedRooms;
	}

	/**
	 * @return the selectedRooms
	 */
	public List<RoomPrice> getSelectedRooms() {
		return selectedRooms;
	}

	/**
	 * @param selectedRooms
	 *            the selectedRooms to set
	 */
	public void setSelectedRooms(List<RoomPrice> selectedRooms) {
		this.selectedRooms = selectedRooms;
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
	 * @return the hotelCityCode
	 */
	public String getHotelCityCode() {
		return hotelCityCode;
	}

	/**
	 * @param hotelCityCode
	 *            the hotelCityCode to set
	 */
	public void setHotelCityCode(String hotelCityCode) {
		this.hotelCityCode = hotelCityCode;
	}

	/**
	 * @return the originLocation
	 */
	public String getOriginLocation() {
		return originLocation;
	}

	/**
	 * @param originLocation
	 *            the originLocation to set
	 */
	public void setOriginLocation(String originLocation) {
		this.originLocation = originLocation;
	}

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
	 * @return the riskHotel
	 */
	public boolean isRiskHotel() {
		return riskHotel;
	}

	/**
	 * @param riskHotel
	 *            the riskHotel to set
	 */
	public void setRiskHotel(boolean riskHotel) {
		this.riskHotel = riskHotel;
	}

	/**
	 * @return the packageHotelNoChange
	 */
	public boolean isPackageHotelNoChange() {
		return packageHotelNoChange;
	}

	/**
	 * @param packageHotelNoChange
	 *            the packageHotelNoChange to set
	 */
	public void setPackageHotelNoChange(boolean packageHotelNoChange) {
		this.packageHotelNoChange = packageHotelNoChange;
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
	 * Method to retrieve the RoomCategory by ID
	 * 
	 * @param roomCategoryId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public RoomCategory getRoomCatgoryById(int roomCategoryId) {
		if (this.roomCategories != null) {
			for (RoomCategory roomCategory : this.roomCategories) {
				if (roomCategoryId == roomCategory.getRoomCategoryId()) {
					return roomCategory;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the String representation of Hotel object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Hotel>\n");
		sb.append("hotelId: " + hotelId + "\n");
		sb.append("hotelCode: " + hotelCode + "\n");
		sb.append("hotelChain: " + hotelChain + "\n");
		sb.append("hotelName: " + hotelName + "\n");
		sb.append("noOfRooms: " + noOfRooms + "\n");
		sb.append("appleRating: " + appleRating + "\n");
		sb.append("resortArea: " + resortArea + "\n");
		sb.append("checkInDate: " + checkInDate + "\n");
		sb.append("checkOutDate: " + checkOutDate + "\n");
		sb.append("minRate: " + minRate + "\n");
		sb.append("currency: " + currency + "\n");
		sb.append("roomCategories: " + roomCategories + "\n");
		sb.append("vendorServices: " + vendorServices + "\n");
		sb.append("displayRoomCategory: " + displayRoomCategory + "\n");
		sb.append("preselectedRooms: " + preselectedRooms + "\n");
		sb.append("selectedRooms: " + selectedRooms + "\n");
		sb.append("occupancy: " + occupancy + "\n");
		sb.append("gdsHotelCode: " + gdsHotelCode + "\n");
		sb.append("isHBSI: " + isHBSI + "\n");
		sb.append("hbsiPNR: " + hbsiPNR + "\n");
		sb.append("</Hotel>");

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
		Hotel hotel = (Hotel) super.clone();
		if (resortArea != null) {
			hotel.resortArea = (ResortArea) resortArea.clone();
		}
		if (roomCategories != null) {
			ArrayList<RoomCategory> roomCategoriesList = new ArrayList<RoomCategory>();
			for (RoomCategory category : roomCategories) {
				roomCategoriesList.add((RoomCategory) category.clone());
			}
			hotel.roomCategories = roomCategoriesList;
		}
		if (vendorServices != null) {
			ArrayList<VendorService> vendorServicesList = new ArrayList<VendorService>();
			for (VendorService service : vendorServices) {
				vendorServicesList.add((VendorService) service.clone());
			}
			hotel.vendorServices = vendorServicesList;
		}
		if (displayRoomCategory != null) {
			hotel.displayRoomCategory = (RoomCategory) displayRoomCategory
					.clone();
		}
		if (searchCriteria != null) {
			hotel.searchCriteria = (SearchCriteria) searchCriteria.clone();
		}
		return hotel;
	}

	private int hotelId;
	private String hotelCode;
	private String hotelChain;
	private String hotelName;
	private int noOfRooms;
	private String appleRating;
	private ResortArea resortArea;
	private Date checkInDate;
	private Date checkOutDate;
	// Best Rate / Price for Hotel
	private double minRate;
	private String currency;
	private List<RoomCategory> roomCategories;
	private List<VendorService> vendorServices;
	private RoomCategory displayRoomCategory;
	// List of preselected rooms based on low cost room category;
	private List<RoomPrice> preselectedRooms;
	// List of rooms selected by user
	private List<RoomPrice> selectedRooms;
	private Occupancy occupancy;
	private String hotelCityCode;
	private String originLocation;
	private SearchCriteria searchCriteria;
	private boolean riskHotel;
	private String noOfNights;
	private boolean appleSpecialsAndSavers; 
	private int noOfRequestedRooms;
	private boolean isHBSI;
	private String hbsiPNR;
	
	public String getHbsiPNR() {
		return hbsiPNR;
	}

	public void setHbsiPNR(String hbsiPNR) {
		this.hbsiPNR = hbsiPNR;
	}

	public boolean isHBSI() {
		return isHBSI;
	}

	public void setHBSI(boolean isHBSI) {
		this.isHBSI = isHBSI;
	}

	private List<RequestedDatesForAvailability> requestedDatesForAvailabilities;  
	
	/*CQ#8775 - Edocs implementation*/
	private Vendor vendor;
	private String vendorHotelCode;
	
	/**
	 * @return the noOfNights
	 */
	public String getNoOfNights() {
		return noOfNights;
	}

	/**
	 * @param noOfNights the noOfNights to set
	 */
	public void setNoOfNights(String noOfNights) {
		this.noOfNights = noOfNights;
	}

	/**
	 * @param isAppleSpecialsAndSavers the isAppleSpecialsAndSavers to set
	 */
	public void setAppleSpecialsAndSavers(boolean appleSpecialsAndSavers) {
		this.appleSpecialsAndSavers = appleSpecialsAndSavers;
	}

	/**
	 * @return the isAppleSpecialsAndSavers
	 */
	public boolean isAppleSpecialsAndSavers() {
		return appleSpecialsAndSavers;
	}

	/**
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * @param noOfRequestedRooms the noOfRequestedRooms to set
	 */
	public void setNoOfRequestedRooms(int noOfRequestedRooms) {
		this.noOfRequestedRooms = noOfRequestedRooms;
	}

	/**
	 * @return the noOfRequestedRooms
	 */
	public int getNoOfRequestedRooms() {
		return noOfRequestedRooms;
	}

	/**
	 * @param requestedDatesForAvailabilities the requestedDatesForAvailabilities to set
	 */
	public void setRequestedDatesForAvailabilities(
			List<RequestedDatesForAvailability> requestedDatesForAvailabilities) {
		this.requestedDatesForAvailabilities = requestedDatesForAvailabilities;
	}

	/**
	 * @return the requestedDatesForAvailabilities
	 */
	public List<RequestedDatesForAvailability> getRequestedDatesForAvailabilities() {
		return requestedDatesForAvailabilities;
	}

	// Field used to track whether hotel is changed in a package or not
	private boolean packageHotelNoChange;
	// Holds hotel property code from GDS
	private String gdsHotelCode;
	
	//Cancellation Policy for Hotel
	private List<String> cancellationPolicy;

	/**
	 * @return the cancellationPolicy
	 */
	public List<String> getCancellationPolicy() {
		return cancellationPolicy;
	}

	/**
	 * @param cancellationPolicy the cancellationPolicy to set
	 */
	public void setCancellationPolicy(List<String> cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}

	/**
	 * @return the vendorHotelCode
	 */
	public String getVendorHotelCode() {
		return vendorHotelCode;
	}

	/**
	 * @param vendorHotelCode the vendorHotelCode to set
	 */
	public void setVendorHotelCode(String vendorHotelCode) {
		this.vendorHotelCode = vendorHotelCode;
	}
}