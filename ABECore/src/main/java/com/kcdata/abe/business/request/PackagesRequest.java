/*
 * PackagesRequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 23, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.business.request;

import java.util.List;

import com.kcdata.abe.bapi.util.Yst_Ota_Flt_Orig_DestType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List;
/*Code commented for revocation of 3620608 on 04/05/2013*/
//import com.kcdata.abe.bapi.util.Yzst_Ota_Flt_Segments_CpyType_List;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.framework.request.ABERequest;

/**
 * Package request class. This class holds the information required for all
 * package requests
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PackagesRequest extends ABERequest {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 5391400408429035871L;

	/**
	 * Flights request of packages
	 */
	private FlightsRequest flightsRequest;

	/**
	 * Hotels request of packages
	 */
	private HotelsRequest hotelsRequest;

	/**
	 * Cars request of packages
	 */
	private VehiclesRequest vehiclesRequest;

	/**
	 * Field to hold the flights
	 */
	private List<TripFlight> flightsList;

	/**
	 * Field to hold hotels
	 */
	private List<Hotel> hotelList;

	/**
	 * Field to hold destination based services
	 */
	private List<Destination> destinationsList;

	/**
	 * Field to hold the vehicles list
	 */
	private List<Vehicle> vehiclesList;

	/**
	 * Field to hold the package object Applicable only in ChangeFlight,
	 * ChangeHotel and ChangeCar scenarios
	 */
	private com.kcdata.abe.data.dto.Package availablePackage;

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
	private Yst_Ota_Flt_SegmentsType_List sapSegmentsList;
	private Yst_Ota_Flt_Orig_DestType_List sapOrigDestOptionsList;
	private Yst_Ota_Htl_InfoType_List sapHotelInfoList;
	private Yst_Ota_Htl_AmenityType_List sapHotelAmenityList;
	private Yst_Ota_Htl_Dest_ServicesType_List sapDestServicesList;
	private Yst_Ota_Htl_AvailabilityType_List sapHotelAvailabilityList;
	private Yst_Ota_Htl_Vend_ServicesType_List sapVendorServicesList;
	private Yst_Ota_Htl_Room_PricingType_List sapRoomPricingList;
	private Yst_Ota_RoomstaycandidatesType_List sapRoomStayCandidatesList;
	private Yst_Ota_Veh_AvailabilityType_List sapVehicleAvailabilityList;
	/*Code commented for revocation of 3620608 on 04/05/2013*/
/*	// Field added for Support Item #3620608
	private Yzst_Ota_Flt_Segments_CpyType_List sapAddedSegmentsList;*/

	/**
	 * @return the flightsRequest
	 */
	public FlightsRequest getFlightsRequest() {
		return flightsRequest;
	}

	/**
	 * @param flightsRequest
	 *            the flightsRequest to set
	 */
	public void setFlightsRequest(FlightsRequest flightsRequest) {
		this.flightsRequest = flightsRequest;
	}

	/**
	 * @return the hotelsRequest
	 */
	public HotelsRequest getHotelsRequest() {
		return hotelsRequest;
	}

	/**
	 * @param hotelsRequest
	 *            the hotelsRequest to set
	 */
	public void setHotelsRequest(HotelsRequest hotelsRequest) {
		this.hotelsRequest = hotelsRequest;
	}

	/**
	 * @return the vehiclesRequest
	 */
	public VehiclesRequest getVehiclesRequest() {
		return vehiclesRequest;
	}

	/**
	 * @param vehiclesRequest
	 *            the vehiclesRequest to set
	 */
	public void setVehiclesRequest(VehiclesRequest vehiclesRequest) {
		this.vehiclesRequest = vehiclesRequest;
	}

	/**
	 * @return the flightsList
	 */
	public List<TripFlight> getFlightsList() {
		return flightsList;
	}

	/**
	 * @param flightsList
	 *            the flightsList to set
	 */
	public void setFlightsList(List<TripFlight> flightsList) {
		this.flightsList = flightsList;
	}

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
	 * @return the destinationsList
	 */
	public List<Destination> getDestinationsList() {
		return destinationsList;
	}

	/**
	 * @param destinationsList
	 *            the destinationsList to set
	 */
	public void setDestinationsList(List<Destination> destinationsList) {
		this.destinationsList = destinationsList;
	}

	/**
	 * @return the vehiclesList
	 */
	public List<Vehicle> getVehiclesList() {
		return vehiclesList;
	}

	/**
	 * @param vehiclesList
	 *            the vehiclesList to set
	 */
	public void setVehiclesList(List<Vehicle> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}

	/**
	 * @return the availablePackage
	 */
	public com.kcdata.abe.data.dto.Package getAvailablePackage() {
		return availablePackage;
	}

	/**
	 * @param availablePackage
	 *            the availablePackage to set
	 */
	public void setAvailablePackage(com.kcdata.abe.data.dto.Package availablePackage) {
		this.availablePackage = availablePackage;
	}

	/**
	 * @return the sapSegmentsList
	 */
	public Yst_Ota_Flt_SegmentsType_List getSapSegmentsList() {
		return sapSegmentsList;
	}

	/**
	 * @param sapSegmentsList
	 *            the sapSegmentsList to set
	 */
	public void setSapSegmentsList(Yst_Ota_Flt_SegmentsType_List sapSegmentsList) {
		this.sapSegmentsList = sapSegmentsList;
	}

	/**
	 * @return the sapOrigDestOptionsList
	 */
	public Yst_Ota_Flt_Orig_DestType_List getSapOrigDestOptionsList() {
		return sapOrigDestOptionsList;
	}

	/**
	 * @param sapOrigDestOptionsList
	 *            the sapOrigDestOptionsList to set
	 */
	public void setSapOrigDestOptionsList(
			Yst_Ota_Flt_Orig_DestType_List sapOrigDestOptionsList) {
		this.sapOrigDestOptionsList = sapOrigDestOptionsList;
	}

	/**
	 * @return the sapHotelInfoList
	 */
	public Yst_Ota_Htl_InfoType_List getSapHotelInfoList() {
		return sapHotelInfoList;
	}

	/**
	 * @param sapHotelInfoList
	 *            the sapHotelInfoList to set
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
	 * @param sapHotelAmenityList
	 *            the sapHotelAmenityList to set
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
	 * @param sapDestServicesList
	 *            the sapDestServicesList to set
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
	 * @param sapHotelAvailabilityList
	 *            the sapHotelAvailabilityList to set
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
	 * @param sapVendorServicesList
	 *            the sapVendorServicesList to set
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
	 * @param sapRoomPricingList
	 *            the sapRoomPricingList to set
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
	 * @param sapRoomStayCandidatesList
	 *            the sapRoomStayCandidatesList to set
	 */
	public void setSapRoomStayCandidatesList(
			Yst_Ota_RoomstaycandidatesType_List sapRoomStayCandidatesList) {
		this.sapRoomStayCandidatesList = sapRoomStayCandidatesList;
	}

	/**
	 * @return the sapVehicleAvailabilityList
	 */
	public Yst_Ota_Veh_AvailabilityType_List getSapVehicleAvailabilityList() {
		return sapVehicleAvailabilityList;
	}

	/**
	 * @param sapVehicleAvailabilityList
	 *            the sapVehicleAvailabilityList to set
	 */
	public void setSapVehicleAvailabilityList(
			Yst_Ota_Veh_AvailabilityType_List sapVehicleAvailabilityList) {
		this.sapVehicleAvailabilityList = sapVehicleAvailabilityList;
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
		PackagesRequest packagesRequest = (PackagesRequest) super.clone();
		if (flightsRequest != null) {
			packagesRequest.flightsRequest = (FlightsRequest) flightsRequest
					.clone();
		}
		if (hotelsRequest != null) {
			packagesRequest.hotelsRequest = (HotelsRequest) hotelsRequest
					.clone();
		}
		if (vehiclesRequest != null) {
			packagesRequest.vehiclesRequest = (VehiclesRequest) vehiclesRequest
					.clone();
		}
		return packagesRequest;
	}
	/*Code commented for revocation of 3620608 on 04/05/2013*/
	/**
	 * @return the sapAddedSegmentsList
	 *//*
	public Yzst_Ota_Flt_Segments_CpyType_List getSapAddedSegmentsList() {
		return sapAddedSegmentsList;
	}

	*//**
	 * @param sapAddedSegmentsList the sapAddedSegmentsList to set
	 *//*
	public void setSapAddedSegmentsList(
			Yzst_Ota_Flt_Segments_CpyType_List sapAddedSegmentsList) {
		this.sapAddedSegmentsList = sapAddedSegmentsList;
	}*/
}
