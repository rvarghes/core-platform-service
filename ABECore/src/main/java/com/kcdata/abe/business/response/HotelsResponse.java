/*
 * HotelsResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 * Sep 14, 2009	 hguntupa	  Added methods for flights availability of packages
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.framework.response.ABEResponse;

/**
 * Hotels response class
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelsResponse extends ABEResponse {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 8457885541351356978L;

	/**
	 * @return the hotelList
	 */
	public List<Hotel> getHotelList() {
		return hotelList;
	}

	/**
	 * @param hotelList
	 *            the hotelList to set
	 */
	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	/**
	 * @return the destinations
	 */
	public List<Destination> getDestinations() {
		return destinations;
	}

	/**
	 * @param destinations the destinations to set
	 */
	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	/**
	 * @return the sapHotelInfoList
	 */
	public Yst_Ota_Htl_InfoType_List getSapHotelInfoList() {
		return sapHotelInfoList;
	}

	/**
	 * @param sapHotelInfoList the sapHotelInfoList to set
	 */
	public void setSapHotelInfoList(Yst_Ota_Htl_InfoType_List sapHotelInfoList) {
		this.sapHotelInfoList = sapHotelInfoList;
	}

	/**
	 * @return the sapHotelAmenityList
	 */
	public Yst_Ota_Htl_AmenityType_List getSapHotelAmenityList() {
		return sapHotelAmenityList;
	}

	/**
	 * @param sapHotelAmenityList the sapHotelAmenityList to set
	 */
	public void setSapHotelAmenityList(
			Yst_Ota_Htl_AmenityType_List sapHotelAmenityList) {
		this.sapHotelAmenityList = sapHotelAmenityList;
	}

	/**
	 * @return the sapDestServicesList
	 */
	public Yst_Ota_Htl_Dest_ServicesType_List getSapDestServicesList() {
		return sapDestServicesList;
	}

	/**
	 * @param sapDestServicesList the sapDestServicesList to set
	 */
	public void setSapDestServicesList(
			Yst_Ota_Htl_Dest_ServicesType_List sapDestServicesList) {
		this.sapDestServicesList = sapDestServicesList;
	}

	/**
	 * @return the sapHotelAvailabilityList
	 */
	public Yst_Ota_Htl_AvailabilityType_List getSapHotelAvailabilityList() {
		return sapHotelAvailabilityList;
	}

	/**
	 * @param sapHotelAvailabilityList the sapHotelAvailabilityList to set
	 */
	public void setSapHotelAvailabilityList(
			Yst_Ota_Htl_AvailabilityType_List sapHotelAvailabilityList) {
		this.sapHotelAvailabilityList = sapHotelAvailabilityList;
	}

	/**
	 * @return the sapVendorServicesList
	 */
	public Yst_Ota_Htl_Vend_ServicesType_List getSapVendorServicesList() {
		return sapVendorServicesList;
	}

	/**
	 * @param sapVendorServicesList the sapVendorServicesList to set
	 */
	public void setSapVendorServicesList(
			Yst_Ota_Htl_Vend_ServicesType_List sapVendorServicesList) {
		this.sapVendorServicesList = sapVendorServicesList;
	}

	/**
	 * @return the sapRoomPricingList
	 */
	public Yst_Ota_Htl_Room_PricingType_List getSapRoomPricingList() {
		return sapRoomPricingList;
	}

	/**
	 * @param sapRoomPricingList the sapRoomPricingList to set
	 */
	public void setSapRoomPricingList(
			Yst_Ota_Htl_Room_PricingType_List sapRoomPricingList) {
		this.sapRoomPricingList = sapRoomPricingList;
	}

	/**
	 * @return the sapRoomStayCandidatesList
	 */
	public Yst_Ota_RoomstaycandidatesType_List getSapRoomStayCandidatesList() {
		return sapRoomStayCandidatesList;
	}

	/**
	 * @param sapRoomStayCandidatesList the sapRoomStayCandidatesList to set
	 */
	public void setSapRoomStayCandidatesList(
			Yst_Ota_RoomstaycandidatesType_List sapRoomStayCandidatesList) {
		this.sapRoomStayCandidatesList = sapRoomStayCandidatesList;
	}

	/**
	 * Field to hold hotels
	 */
	private List<Hotel> hotelList;

	/**
	 * Field to hold destination based services
	 */
	private List<Destination> destinations;
	
	/*
	 * For packages, we will be calling the multiple threads to retrieve the
	 * availability BAPI and then consolidate them in the form of packages. As
	 * we are passing the availability response(sap structures) to package
	 * consolidation, we would like to reduce the time of parsing SAP structures
	 * to JAVA DTO objects and from DTO objects back to SAP structures during
	 * consolidation. So, we will be caching the availability SAP structures and
	 * passing the same to consolidation BAPI. The below fields helps us to
	 * cache the availability response
	 */
	private Yst_Ota_Htl_InfoType_List sapHotelInfoList;
	private Yst_Ota_Htl_AmenityType_List sapHotelAmenityList;
	private Yst_Ota_Htl_Dest_ServicesType_List sapDestServicesList;
	private Yst_Ota_Htl_AvailabilityType_List sapHotelAvailabilityList;
	private Yst_Ota_Htl_Vend_ServicesType_List sapVendorServicesList;
	private Yst_Ota_Htl_Room_PricingType_List sapRoomPricingList;
	private Yst_Ota_RoomstaycandidatesType_List sapRoomStayCandidatesList;
}
