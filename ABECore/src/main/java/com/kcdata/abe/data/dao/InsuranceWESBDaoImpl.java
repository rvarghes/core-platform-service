/*
 * InsuranceSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 18, 2009  dmahanth
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.XMLGregorianCalendar;

import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.InsuranceGroup;
import com.kcdata.abe.data.dto.InsuranceGuestAllocation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.XMLGregorianCalendarConversionUtil;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.address.v1.Address;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.agecode.v1.AgeCode;
import com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.agent.v1.Agent;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.airoptions.v1.AirOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.amenity.v1.Amenity;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.cabintype.v1.CabinType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.carrier.v1.Carrier;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.destinationoptions.v1.DestinationOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.flighttriptype.v1.FlightTripType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestpricebreakup.v1.GuestPriceBreakup;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.mealplantype.v1.MealPlanType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.passportinfo.v1.PassportInfo;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypebaseprices.v1.PaxTypeBasePrices;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.paxtypepricebreakup.v1.PaxTypePriceBreakup;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.requesteddatesforavailability.v1.RequestedDatesForAvailability;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialoptions.v1.SpecialOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialrequesttype.v1.SpecialRequestType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.specialtype.v1.SpecialType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.timeofday.v1.TimeOfDay;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.usertype.v1.UserType;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vehicleoptions.v1.VehicleOptions;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendor.v1.Vendor;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsinsurancerequest.v1.HotelsInsuranceRequest;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsinsuranceresponse.v1.HotelsInsuranceResponse;
import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.RetrieveHotelInsuranceRetrieveHotelInsuranceFaultMsg;

/**
 * Itinerary Insurance DAO implementation class
 * 
 * @author sainath
 * @version
 * 
 * @see
 * @since
 */
public class InsuranceWESBDaoImpl extends ABESAPDaoBase implements
		InsuranceWESBDao {

	/**
	 * Instance of Logger
	 */
	final ABELogger logger = ABELogger
			.getLogger(com.kcdata.abe.data.dao.InsuranceWESBDaoImpl.class);

	private WesbProxyService proxyService;

	/**
	 * @param wesbProxyService
	 *            the wesbProxyService to set
	 */
	public void setProxyService(WesbProxyService wesbProxyService) {
		this.proxyService = wesbProxyService;
	}

	/**
	 * Method to get the available insurance options
	 * 
	 * @param itinerary
	 * 
	 * @return insuranceResponse
	 * 
	 */

	public InsuranceResponse retrieveWESBInsurance(Itinerary itinerary,
			boolean isHbsi,Map<String,HBSiHotelInfo> hbsiHotelList) {

		InsuranceResponse insuranceResponse = new InsuranceResponse();
		if (itinerary == null) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			insuranceResponse.saveBusinessError(businessError);
			return insuranceResponse;
		}

		HotelsInsuranceRequest hotelsInsuranceRequest = new HotelsInsuranceRequest();

		/*if (isHbsi == true)
			hotelsInsuranceRequest.setIsHBSi(true);*/

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = getInsuranceRequestObject(itinerary);

		// set the booking number which is required during change booking to
		// retrive aleready selected insurances guest allocation list
		itineraryClient.setBookingNo(itinerary.getBookingNo());
		hotelsInsuranceRequest.setItinerary(itineraryClient);
		
		if (hbsiHotelList != null
				&& hotelsInsuranceRequest != null
				&& hotelsInsuranceRequest.getItinerary().getHotels() != null
				&& hotelsInsuranceRequest.getItinerary().getHotels()
						.size() > 0)
		{
			for(int j=0;j<hotelsInsuranceRequest.getItinerary().getHotels().size();j++)
			{
				if(hbsiHotelList.containsKey(hotelsInsuranceRequest.getItinerary().getHotels().get(j).getHotelCode()))
				{
					hotelsInsuranceRequest.getItinerary().getHotels().get(j).setIsHBSi(true);
					hotelsInsuranceRequest.setIsHBSi(true);
				}
				else
				{
					hotelsInsuranceRequest.getItinerary().getHotels().get(j).setIsHBSi(false);
				}
			}
		}
		

		HotelsInsuranceResponse hotelsInsuranceResponse = null;

		// HotelBusServiceExport_HotelServiceBSHttpPortProxy proxyService;
		// proxyService = new
		// HotelBusServiceExport_HotelServiceBSHttpPortProxy(new
		// URL("http://172.22.50.211:9080/KCDEBBusSrv_HotelService_v1Web/sca/HotelBusServiceExport/WEB-INF/wsdl/KCDEBBusSrv_HotelService_v1_HotelBusServiceExport.wsdl"),new
		// QName("http://www.partners.kcdataservices.com/KCDEBSrvLib_Hotel/interfaces/HotelServiceBS/v1",
		// "HotelBusServiceExport_HotelServiceBSHttpService"));

		
		//set the header elements
		hotelsInsuranceRequest.setHotelRequested(true);
		hotelsInsuranceRequest.setPackageRequest(false);
		hotelsInsuranceRequest.setAirRequested(false);
		hotelsInsuranceRequest.setVehicleRequested(false);
		hotelsInsuranceRequest.setMultiDestinationRequest(false);
		try {
			hotelsInsuranceResponse = proxyService.getProxyService()
					.retrieveHotelInsurance(hotelsInsuranceRequest);
		} catch (RetrieveHotelInsuranceRetrieveHotelInsuranceFaultMsg e) {

		}
		if (hotelsInsuranceResponse == null) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_INSURANCE_AVAILABILITY_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_INSURANCE_AVAILABILITY_ERROR", null,
							null));
			insuranceResponse.saveBusinessError(businessError);
		}
		if (hotelsInsuranceResponse != null
				&& hotelsInsuranceResponse.getBusinessError() != null
				&& hotelsInsuranceResponse.getBusinessError().size() > 0) {

			List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

			for (int l = 0; l < hotelsInsuranceResponse.getBusinessError()
					.size(); l++) {
				ABEBusinessError businessError = null;
				businessError = this
						.getABEBusinessError(hotelsInsuranceResponse
								.getBusinessError().get(l));
				if (businessError != null)
					businesserrorList.add(businessError);

			}

			if (businesserrorList != null && businesserrorList.size() > 0)
				insuranceResponse.saveBusinessErrors(businesserrorList);

			return insuranceResponse;

		}
		if(hotelsInsuranceResponse!=null)
		{
		insuranceResponse = getInsuranceResponseObject(hotelsInsuranceResponse);
		}

		/*
		 * if (insuranceResponse.isBusinessErrorOccurred()){ return
		 * insuranceResponse; }
		 */

		return insuranceResponse;
	}

	/**
	 * Method for setting List of Hotels Object
	 * 
	 * @param itinerary
	 * 
	 * @return itinerary
	 */

	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary getInsuranceRequestObject(
			Itinerary itinerary) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();

		// BEGIN :- Setting Itinerary Objects data into the Clients Itinerary
		// Object
		//  Affiliate will not send the  searchCriteria.
		if(itinerary.getSearchCriteria()!=null){
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria searchCriteriaItinerary = 
			getSearchCriteriaObject(itinerary.getSearchCriteria());
			itineraryClient.setSearchCriteria(searchCriteriaItinerary);
		}

		// BEGIN :- Setting IMApplicationInfo Objects data into the Clients
		// IMApplicationInfo Object

		/*com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo imApplicationInfo = setImApplicationInfo();
		itineraryClient.setImApplicationInfo(imApplicationInfo);*/
		
		if( itinerary.getImApplicationInfo() != null ){
			itineraryClient.setImApplicationInfo( this.getIMApplicationInfoReq(itinerary.getImApplicationInfo()) );
		}

		// END :- Setting IMApplicationInfo Objects data into the Clients
		// IMApplicationInfo Object

		// BEGIN :- Setting Hotel Objects data into the Clients Hotel Object

		if (itinerary.getHotels() != null) {
			for(int i=0; i < itinerary.getHotels().size(); i++){
				itineraryClient.getHotels().add( this.getHotelReq(itinerary.getHotels().get(i)) );
			}
			
			/*
			for (int i = 0; i < itinerary.getHotels().size(); i++) {
				if (itinerary.getHotels().get(i) != null) {
					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotelClient = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel();
					hotelClient.setHotelId(itinerary.getHotels().get(i)
							.getHotelId());
					hotelClient.setHotelCode(itinerary.getHotels().get(i)
							.getHotelCode());
					hotelClient.setHotelChain(itinerary.getHotels().get(i)
							.getHotelChain());
					hotelClient.setHotelName(itinerary.getHotels().get(i)
							.getHotelName());
					hotelClient.setNoOfRooms(itinerary.getHotels().get(i)
							.getNoOfRooms());
					hotelClient.setAppleRating(itinerary.getHotels().get(i)
							.getAppleRating());

					if (itinerary.getHotels().get(i).getResortArea() != null) {
						ResortArea resortArea = new ResortArea();
						resortArea.setResortAreaCode(itinerary.getHotels()
								.get(i).getResortArea().getResortAreaCode());
						resortArea.setResortAreaName(itinerary.getHotels()
								.get(i).getResortArea().getResortAreaName());
						hotelClient.setResortArea(resortArea);
					}

					XMLGregorianCalendar checkInDate = XMLGregorianCalendarConversionUtil
							.asXMLGregorianCalendar(itinerary.getHotels()
									.get(i).getCheckInDate());
					hotelClient.setCheckInDate(checkInDate);
					XMLGregorianCalendar checkOutDate = XMLGregorianCalendarConversionUtil
							.asXMLGregorianCalendar(itinerary.getHotels()
									.get(i).getCheckOutDate());
					hotelClient.setCheckOutDate(checkOutDate);
					hotelClient.setMinRate(itinerary.getHotels().get(i)
							.getMinRate());
					hotelClient.setCurrency(itinerary.getHotels().get(i)
							.getCurrency());

					// BEGIN :- Setting RoomCategory Objects data into the
					// Clients RoomCategory Object

					List<com.kcdata.abe.data.dto.RoomCategory> roomCategoryList = itinerary
							.getHotels().get(i).getRoomCategories();
					if (roomCategoryList != null) {
						for (int j = 0; j < roomCategoryList.size(); j++) {
							if (roomCategoryList.get(j) != null) {
								com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategory = getRoomCategoryObject(
										roomCategoryList, j);
								hotelClient.getRoomCategories().add(j,
										roomCategory);
							}
						}
					}

					// END :- Setting RoomCategory Objects data into the Clients
					// RoomCategory Object

					// BEGIN :- Setting List of VendorService Objects data into
					// the Clients List of VendorService Object

					if (itinerary.getHotels().get(i).getVendorServices() != null) {
						for (int j = 0; j < itinerary.getHotels().get(i)
								.getVendorServices().size(); j++) {
							VendorService vendorService = new VendorService();
							vendorService.setVendorId(itinerary.getHotels()
									.get(i).getVendorServices().get(j)
									.getVendorId());
							vendorService.setServiceCode(itinerary.getHotels()
									.get(i).getVendorServices().get(j)
									.getServiceCode());
							vendorService.setServiceName(itinerary.getHotels()
									.get(i).getVendorServices().get(j)
									.getServiceName());
							vendorService.setPrice(itinerary.getHotels().get(i)
									.getVendorServices().get(j).getPrice());
							vendorService.setCurrency(itinerary.getHotels()
									.get(i).getVendorServices().get(j)
									.getCurrency());
							hotelClient.getVendorServices().add(j,
									vendorService);
						}
					}

					// END :- Setting List of VendorService Objects data into
					// the Clients List of VendorService Object

					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory displayRoomCategory = getDisplayRoomCategoryObject(itinerary
							.getHotels().get(i).getDisplayRoomCategory());
					hotelClient.setDisplayRoomCategory(displayRoomCategory);

					List<com.kcdata.abe.data.dto.RoomPrice> roomPricesListPre = itinerary
							.getHotels().get(i).getPreselectedRooms();
					if (roomPricesListPre != null) {
						for (int k = 0; k < roomPricesListPre.size(); k++) {
							RoomPrice roomPrice = getRoomPriceObject(
									roomPricesListPre, k);
							hotelClient.getPreselectedRooms().add(k, roomPrice);
						}
					}
					List<com.kcdata.abe.data.dto.RoomPrice> roomPricesList = itinerary
							.getHotels().get(i).getSelectedRooms();
					if (roomPricesList != null) {
						for (int k = 0; k < roomPricesList.size(); k++) {
							RoomPrice roomPrice = getRoomPriceObject(
									roomPricesList, k);
							hotelClient.getSelectedRooms().add(k, roomPrice);
						}
					}

					// BEGIN :- Setting Occupancy Objects data into the Clients
					// Occupancy Object

					com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyHotel = new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
					occupancyHotel.setNoOfAdults(itinerary.getHotels().get(i)
							.getOccupancy().getNoOfAdults());
					occupancyHotel.setNoOfChilds(itinerary.getHotels().get(i)
							.getOccupancy().getNoOfChilds());
					occupancyHotel.setNoOfInfants(itinerary.getHotels().get(i)
							.getOccupancy().getNoOfInfants());
					occupancyHotel.setNoOfLapChilds(itinerary.getHotels()
							.get(i).getOccupancy().getNoOfLapChilds());
					occupancyHotel.setNoOfSeniors(itinerary.getHotels().get(i)
							.getOccupancy().getNoOfSeniors());

					List<com.kcdata.abe.data.dto.Passenger> passengerListHotel = itinerary
							.getHotels().get(i).getOccupancy().getPassengers();
					if (passengerListHotel != null) {
						for (int i1 = 0; i1 < passengerListHotel.size(); i1++) {
							com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger passenger = getPassengerObject(
									passengerListHotel, i1);
							occupancyHotel.getPassengers().add(i1, passenger);
						}
					}
					hotelClient.setOccupancy(occupancyHotel);

					// END :- Setting Occupancy Objects data into the Clients
					// Occupancy Object

					hotelClient.setHotelCityCode(itinerary.getHotels().get(i)
							.getHotelCityCode());
					hotelClient.setOriginLocation(itinerary.getHotels().get(i)
							.getOriginLocation());

					if (itinerary.getHotels().get(i).getSearchCriteria() != null) {
						com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria searchCriteria = getSearchCriteriaObject(itinerary
								.getHotels().get(i).getSearchCriteria());
						hotelClient.setSearchCriteria(searchCriteria);
					}
					hotelClient.setRiskHotel(itinerary.getHotels().get(i)
							.isRiskHotel());
					hotelClient.setNoOfNights(itinerary.getHotels().get(i)
							.getNoOfNights());
					hotelClient.setPackageHotelNoChange(itinerary.getHotels()
							.get(i).isPackageHotelNoChange());
					hotelClient.setAppleSpecialsAndSavers(itinerary.getHotels()
							.get(i).isAppleSpecialsAndSavers());
					hotelClient.setNoOfRequestedRooms(itinerary.getHotels()
							.get(i).getNoOfRequestedRooms());

					// BEGIN :- Setting List of RequestedDatesForAvailability
					// Objects data into the Clients List of
					// RequestedDatesForAvailability Object

					if (itinerary.getHotels().get(i)
							.getRequestedDatesForAvailabilities() != null) {
						for (int n = 0; n < itinerary.getHotels().get(i)
								.getRequestedDatesForAvailabilities().size(); n++) {
							RequestedDatesForAvailability requestedDatesForAvailability = new RequestedDatesForAvailability();
							if (itinerary.getHotels().get(i)
									.getRequestedDatesForAvailabilities()
									.get(n).getReqDates() != null) {
								for (int p = 0; p < itinerary.getHotels()
										.get(i)
										.getRequestedDatesForAvailabilities()
										.get(n).getReqDates().size(); p++) {
									requestedDatesForAvailability
											.getReqDates()
											.add(n,
													itinerary
															.getHotels()
															.get(i)
															.getRequestedDatesForAvailabilities()
															.get(n)
															.getReqDates()
															.get(p));
								}
							}
							requestedDatesForAvailability
									.setNoOfRooms(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getNoOfRooms());
							requestedDatesForAvailability
									.setBookingDate(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getBookingDate());
							requestedDatesForAvailability
									.setBookingDuration(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getBookingDuration());
							requestedDatesForAvailability
									.setRoomDescription(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getRoomDescription());
							requestedDatesForAvailability
									.setRoomStatus(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getRoomStatus());
							requestedDatesForAvailability
									.setMaterialNumber(itinerary
											.getHotels()
											.get(i)
											.getRequestedDatesForAvailabilities()
											.get(n).getMaterialNumber());

							hotelClient.getRequestedDatesForAvailabilities()
									.add(n, requestedDatesForAvailability);
						}
					}

					// END :- Setting List of RequestedDatesForAvailability
					// Objects data into the Clients List of
					// RequestedDatesForAvailability Object

					// BEGIN :- Setting Vendor Objects data into the Clients
					// Vendor Object

					Vendor vendor = new Vendor();
					if (itinerary.getHotels().get(i).getVendor() != null) {
						vendor.setVendorId(itinerary.getHotels().get(i)
								.getVendor().getVendorId());
						vendor.setFirstName(itinerary.getHotels().get(i)
								.getVendor().getFirstName());
						vendor.setLastName(itinerary.getHotels().get(i)
								.getVendor().getLastName());
						vendor.setStreetAddrs(itinerary.getHotels().get(i)
								.getVendor().getStreetAddrs());
						vendor.setCity(itinerary.getHotels().get(i).getVendor()
								.getCity());
						vendor.setRegion(itinerary.getHotels().get(i)
								.getVendor().getRegion());
						vendor.setCountry(itinerary.getHotels().get(i)
								.getVendor().getCountry());
						vendor.setPostalCode(itinerary.getHotels().get(i)
								.getVendor().getPostalCode());
						vendor.setPhone(itinerary.getHotels().get(i)
								.getVendor().getPhone());
						vendor.setEmail(itinerary.getHotels().get(i)
								.getVendor().getEmail());
						vendor.setFaxNo(itinerary.getHotels().get(i)
								.getVendor().getFaxNo());
						vendor.setMode(itinerary.getHotels().get(i).getVendor()
								.getMode());
						// DataType Issue
						vendor.setVendorExist(itinerary.getHotels().get(i)
								.getVendor().isVendorExist());

						hotelClient.setVendor(vendor);
					}

					// END :- Setting Vendor Objects data into the Clients
					// Vendor Object

					itineraryClient.getHotels().add(i, hotelClient);
				}
			}

		*/}

		// END :- Setting Hotel Objects data into the Clients Hotel Object

		// BEGIN :- Setting GuestInfo Objects data into the Clients GuestInfo
		// Object

		List<GuestInfo> guestInfos = itinerary.getGuests();
		if (guestInfos != null) {
			setGuestInfoObject(guestInfos, itineraryClient);
		}

		// END :- Setting GuestInfo Objects data into the Clients GuestInfo
		// Object

		// END :- Setting Itinerary Objects data into the Clients Itinerary
		// Object

		return itineraryClient;
	}

	/**
	 * Method for setting Insurance Response Object
	 * 
	 * @param hotelsInsuranceResponse
	 * 
	 * @return insuranceResponse
	 */

	private InsuranceResponse getInsuranceResponseObject(
			HotelsInsuranceResponse hotelsInsuranceResponse) {
		InsuranceResponse insuranceResponse = new InsuranceResponse();
		List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurancegroup.v1.InsuranceGroup> insuranceGroupClientList = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurancegroup.v1.InsuranceGroup>) hotelsInsuranceResponse
				.getInsuranceGroupList();

		List<InsuranceGroup> insuranceGroupsDTO = new ArrayList<InsuranceGroup>();
		if (insuranceGroupClientList != null) {
			for (int i = 0; i < insuranceGroupClientList.size(); i++) {
				InsuranceGroup insuranceGroup = new InsuranceGroup();
				insuranceGroup.setCode(insuranceGroupClientList.get(i)
						.getCode());
				insuranceGroup.setDescription(insuranceGroupClientList.get(i)
						.getDescription());
				List<Insurance> insuranceList = new ArrayList<Insurance>();
				if (insuranceGroupClientList.get(i).getInsuranceList() != null) {

					for (int j = 0; j < insuranceGroupClientList.get(i)
							.getInsuranceList().size(); j++) {
						Insurance insuranceDTO = new Insurance();
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getItemRPH() != null) {
							insuranceDTO.setItemRPH(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getItemRPH().intValue());
						}
						insuranceDTO.setMaterialNo(insuranceGroupClientList
								.get(i).getInsuranceList().get(j)
								.getMaterialNo());
						insuranceDTO.setMaterailDesc(insuranceGroupClientList
								.get(i).getInsuranceList().get(j)
								.getMaterailDesc());
						insuranceDTO
								.setValidDateFrom(XMLGregorianCalendarConversionUtil
										.asDate(insuranceGroupClientList.get(i)
												.getInsuranceList().get(j)
												.getValidDateFrom()));
						insuranceDTO
								.setValidDateTo(XMLGregorianCalendarConversionUtil
										.asDate(insuranceGroupClientList.get(i)
												.getInsuranceList().get(j)
												.getValidDateTo()));
						insuranceDTO.setVacationType(insuranceGroupClientList
								.get(i).getInsuranceList().get(j)
								.getVacationType());
						insuranceDTO
								.setVacationDescription(insuranceGroupClientList
										.get(i).getInsuranceList().get(j)
										.getVacationDescription());

						// DataType issue
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getAdultPrice() != null) {
							insuranceDTO.setAdultPrice(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getAdultPrice().doubleValue());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getChildPrice() != null) {
							insuranceDTO.setChildPrice(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getChildPrice().doubleValue());
						}
						// insuranceDTO.setChildRuleDesc(insuranceGroupClientList.get(i).getInsuranceList().get(j).getChildRuleDesc());
						insuranceDTO.setChildRuleDesc("");

						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getChildMinAge() != null) {
							insuranceDTO
									.setChildMinAge(insuranceGroupClientList
											.get(i).getInsuranceList().get(j)
											.getChildMinAge().intValue());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getChildMaxAge() != null) {
							insuranceDTO
									.setChildMaxAge(insuranceGroupClientList
											.get(i).getInsuranceList().get(j)
											.getChildMaxAge().intValue());
						}
						insuranceDTO.setOptionIns(insuranceGroupClientList.get(i).getInsuranceList().get(j).getOptionIns());
						if(insuranceGroupClientList.get(i).getInsuranceList().get(j).getOptionIns() == null) {
							insuranceDTO.setOptionIns("");	
						}
						
						insuranceDTO.setOptionDesc(insuranceGroupClientList
								.get(i).getInsuranceList().get(j)
								.getOptionDesc());
						insuranceDTO
								.setGuestAllocation(insuranceGroupClientList
										.get(i).getInsuranceList().get(j)
										.getGuestAllocation());
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getAdultsQty() != null) {
							insuranceDTO.setAdultsQty(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getAdultsQty());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getChildsQty() != null) {
							insuranceDTO.setChildsQty(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getChildsQty());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getInfantsQty() != null) {
							insuranceDTO.setInfantsQty(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getInfantsQty());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getLapChildQty() != null) {
							insuranceDTO
									.setLapChildQty(insuranceGroupClientList
											.get(i).getInsuranceList().get(j)
											.getLapChildQty());
						}
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getSeniorsQty() != null) {
							insuranceDTO.setSeniorsQty(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getSeniorsQty());
						}

						List<Integer> childAgeList = new ArrayList<Integer>();

						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getChildAges() != null) {
							for (int k = 0; k < insuranceGroupClientList.get(i)
									.getInsuranceList().get(j).getChildAges()
									.size(); k++) {
								childAgeList.add(insuranceGroupClientList
										.get(i).getInsuranceList().get(j)
										.getChildAges().get(k).intValue());
							}
						}
						insuranceDTO.setChildAges(childAgeList);

						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getTotalPrice() != null) {
							insuranceDTO.setTotalPrice(insuranceGroupClientList
									.get(i).getInsuranceList().get(j)
									.getTotalPrice());
						}
						insuranceDTO.setPosnr(insuranceGroupClientList.get(i)
								.getInsuranceList().get(j).getPosnr());
						insuranceDTO
								.setOldPosnr(insuranceGroupClientList.get(i)
										.getInsuranceList().get(j)
										.getOldPosnr());
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getMaxQuantity() != null) {
							insuranceDTO
									.setMaxQuantity(insuranceGroupClientList
											.get(i).getInsuranceList().get(j)
											.getMaxQuantity());
						}
						insuranceDTO
								.setDisabledGuestAllocation(insuranceGroupClientList
										.get(i).getInsuranceList().get(j)
										.getDisabledGuestAllocation());

						List<InsuranceGuestAllocation> guestAllocationList = new ArrayList<InsuranceGuestAllocation>();
						if (insuranceGroupClientList.get(i).getInsuranceList()
								.get(j).getGuestAllocationList() != null) {
							for (int p = 0; p < insuranceGroupClientList.get(i)
									.getInsuranceList().get(j)
									.getGuestAllocationList().size(); p++) {
								InsuranceGuestAllocation insuranceGuestAllocationDTO = new InsuranceGuestAllocation();
								insuranceGuestAllocationDTO
										.setGuestID(insuranceGroupClientList
												.get(i).getInsuranceList()
												.get(j)
												.getGuestAllocationList()
												.get(p).getGuestID());
								insuranceGuestAllocationDTO
										.setPosnr(insuranceGroupClientList
												.get(i).getInsuranceList()
												.get(j)
												.getGuestAllocationList()
												.get(p).getPosnr());
								insuranceGuestAllocationDTO
										.setOldPosnr(insuranceGroupClientList
												.get(i).getInsuranceList()
												.get(j)
												.getGuestAllocationList()
												.get(p).getOldPosnr());
								if (insuranceGroupClientList.get(i)
										.getInsuranceList().get(j)
										.getGuestAllocationList().get(p)
										.getPrice() != null) {
									insuranceGuestAllocationDTO
											.setPrice(insuranceGroupClientList
													.get(i).getInsuranceList()
													.get(j)
													.getGuestAllocationList()
													.get(p).getPrice());
								}
								guestAllocationList
										.add(insuranceGuestAllocationDTO);
							}
						}
						insuranceDTO
								.setGuestAllocationList(guestAllocationList);

						insuranceList.add(insuranceDTO);
					}
				}
				insuranceGroup.setInsuranceList(insuranceList);

				insuranceGroupsDTO.add(insuranceGroup);
			}
		}
		insuranceResponse.setInsuranceGroupList(insuranceGroupsDTO);
		return insuranceResponse;
	}

	/**
	 * Method for setting Clients RoomCategory Object
	 * 
	 * @param displayRoomCategory
	 * @return roomCategory
	 */

	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory getDisplayRoomCategoryObject(
			com.kcdata.abe.data.dto.RoomCategory displayRoomCategory) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategory = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory();
		roomCategory.setHotelId(displayRoomCategory.getHotelId());
		roomCategory.setRoomCategoryId(displayRoomCategory.getRoomCategoryId());
		roomCategory.setRoomTypeCode(displayRoomCategory.getRoomTypeCode());
		roomCategory.setRoomTypeDescription(displayRoomCategory
				.getRoomTypeDescription());
		roomCategory.setRatePlanId(displayRoomCategory.getRatePlanId());
		roomCategory.setRatePlanCode(displayRoomCategory.getRatePlanCode());
		roomCategory.setRatePlanDescription(displayRoomCategory
				.getRatePlanDescription());
		roomCategory.setRateIndicator(displayRoomCategory.getRateIndicator());
		roomCategory.setCorporateId(displayRoomCategory.getCorporateId());
		roomCategory.setGuaranteeType(displayRoomCategory.getGuaranteeType());
		roomCategory.setGuaranteeMethod(displayRoomCategory
				.getGuaranteeMethod());
		roomCategory.setGuaranteeRequired(displayRoomCategory
				.getGuaranteeRequired());
		roomCategory.setGuaranteeAmount(displayRoomCategory
				.getGuaranteeAmount());
		roomCategory.setRatePlanCategory(displayRoomCategory
				.getRatePlanCategory());
		roomCategory.setNoOfRoomsAvailable(displayRoomCategory
				.getNoOfRoomsAvailable());
		roomCategory.setStatus(displayRoomCategory.getStatus());
		roomCategory.setCurrency(displayRoomCategory.getCurrency());

		// BEGIN :- Setting RoomPrice Objects data into the Clients RoomPrice
		// Object

		List<com.kcdata.abe.data.dto.RoomPrice> roomPricesList = displayRoomCategory
				.getRoomPrices();
		if (roomPricesList != null) {
			for (int k = 0; k < roomPricesList.size(); k++) {
				RoomPrice roomPrice = getRoomPriceObject(roomPricesList, k);
				roomCategory.getRoomPrices().add(k, roomPrice);
			}
		}

		// END :- Setting RoomPrice Objects data into the Clients RoomPrice
		// Object

		if (displayRoomCategory.getAmenities() != null) {
			for (int m = 0; m < displayRoomCategory.getAmenities().size(); m++) {
				Amenity amenityBO = new Amenity();

				amenityBO.setAmenityCode(displayRoomCategory.getAmenities()
						.get(m).getAmenityCode());
				XMLGregorianCalendar amenityDate = XMLGregorianCalendarConversionUtil
						.asXMLGregorianCalendar(displayRoomCategory
								.getAmenities().get(m).getAmenityDate());
				amenityBO.setAmenityDate(amenityDate);
				amenityBO.setAmenityName(displayRoomCategory.getAmenities()
						.get(m).getAmenityName());
				amenityBO.setAmenityValue(displayRoomCategory.getAmenities()
						.get(m).getAmenityValue());
				amenityBO.setHotelId(displayRoomCategory.getAmenities().get(m)
						.getHotelId());
				amenityBO.setRoomCategoryId(displayRoomCategory.getAmenities()
						.get(m).getRoomCategoryId());

				roomCategory.getAmenities().add(m, amenityBO);
			}
		}
		if (roomPricesList != null) {
			RoomPrice roomPrice = getRoomPriceObject(roomPricesList, 0);
			roomCategory.setDisplayRoomPrice(roomPrice);
		}
		MealPlanType mealPlanType = new MealPlanType();
		if (displayRoomCategory.getMealPlanType() != null) {
			mealPlanType.setCode(displayRoomCategory.getMealPlanType()
					.getCode());
			mealPlanType.setDescription(displayRoomCategory.getMealPlanType()
					.getDescription());
			roomCategory.setMealPlanType(mealPlanType);
		}

		roomCategory.setPosnr(displayRoomCategory.getPosnr());
		roomCategory.setOldPosnr(displayRoomCategory.getOldPosnr());
		roomCategory.setRiskRoomCategory(displayRoomCategory
				.isRiskRoomCategory());
		roomCategory.setAppleChoice(displayRoomCategory.getAppleChoice());
		roomCategory.setMealplanDesc(displayRoomCategory.getMealplanDesc());

		// hotelClient.getRoomCategories().add(j, roomCategory);

		return roomCategory;
	}

	/**
	 * Method for setting Clients IMApplicationInfo Object
	 * 
	 * @return imApplicationInfo
	 */

	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo setImApplicationInfo() {
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo imApplicationInfo = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.imapplicationinfo.v1.IMApplicationInfo();

		imApplicationInfo.setAgentFirstName(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getAgentFirstName());

		imApplicationInfo.setAgentLastName(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getAgentLastName());

		imApplicationInfo.setAgentNumber(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getAgentNumber());

		imApplicationInfo.setContextID(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getContextID());

		imApplicationInfo.setCreatedBy(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getCreatedBy());

		imApplicationInfo.setIsoCountry(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getIsoCountry());

		imApplicationInfo.setIsoCurrency(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getIsoCurrency());

		imApplicationInfo.setPseudoCityCode(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getPseudoCityCode());

		imApplicationInfo.setRequestorID(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getRequestorID());

		imApplicationInfo.setSalesOrg(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSalesOrg());

		// BEGIN :- Setting Agent Objects data into the Clients Agent Object

		Agent agent = new Agent();

		agent.setAgentNo(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getAgentNo());
		agent.setFirstName(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getFirstName());
		agent.setLastName(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getLastName());
		agent.setFullName(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getFullName());
		agent.setEmailId(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getEmailId());
		agent.setRoyaltyNo(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getRoyaltyNo());

		agent.setPrint(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getPrint());
		agent.setFaxInput(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getSelectedAgent().getFaxInput());

		imApplicationInfo.setSelectedAgent(agent);// Agent

		// END :- Setting Agent Objects data into the Clients Agent Object

		UserType userType = new UserType();
		userType.setCode(this.getApplicationContextFactory()
				.getApplicationContext().getRequestContext()
				.getIMApplicationInfo().getType().getCode());

		imApplicationInfo.setType(userType);// UserType

		return imApplicationInfo;
	}

	/**
	 * Method for setting Clients RoomPrice Object
	 * 
	 * @param roomPricesList
	 * 
	 * @return roomPrice
	 */
	private RoomPrice getRoomPriceObject(
			List<com.kcdata.abe.data.dto.RoomPrice> roomPricesList, int k) {

		RoomPrice roomPrice = new RoomPrice();
		// added two more fields
		roomPrice.setHotelCost(roomPricesList.get(k).getHotelCost());
		roomPrice.setTransferCost(roomPricesList.get(k).getTransferCost());

		roomPrice.setRoomCategoryId(roomPricesList.get(k).getRoomCategoryId());
		roomPrice.setRoomId(roomPricesList.get(k).getRoomId());
		roomPrice.setTotalAmount(roomPricesList.get(k).getTotalAmount());
		roomPrice.setTax(roomPricesList.get(k).getTax());
		roomPrice.setCommissionAmount(roomPricesList.get(k)
				.getCommissionAmount());
		roomPrice.setCommissionPercent(roomPricesList.get(k)
				.getCommissionPercent());
		roomPrice.setLateFee(roomPricesList.get(k).getLateFee());
		roomPrice.setFreeNights(roomPricesList.get(k).getFreeNights());
		roomPrice.setPromoSavingsAmount(roomPricesList.get(k)
				.getPromoSavingsAmount());
		roomPrice.setSavings(roomPricesList.get(k).getSavings());
		roomPrice.setCurrency(roomPricesList.get(k).getCurrency());

		// BEGIN :- Setting PaxTypePriceBreakup Objects data into the Clients
		// PaxTypePriceBreakup Object

		if (roomPricesList.get(k).getPaxTypePriceBreakups() != null) {
			for (int l = 0; l < roomPricesList.get(k).getPaxTypePriceBreakups()
					.size(); l++) {
				PaxTypePriceBreakup paxTypePriceBreakup = new PaxTypePriceBreakup();
				paxTypePriceBreakup
						.setPaxType(Character.toString(roomPricesList.get(k)
								.getPaxTypePriceBreakups().get(l).getPaxType()));
				paxTypePriceBreakup.setCount(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getCount());
				paxTypePriceBreakup.setTaxes(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getTaxes());
				paxTypePriceBreakup.setPrice(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getPrice());
				paxTypePriceBreakup.setUsTax(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getUsTax());
				paxTypePriceBreakup.setForeignTax(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getForeignTax());
				paxTypePriceBreakup.setAirportTax(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getAirportTax());
				paxTypePriceBreakup.setTotalAmount(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getTotalAmount());
				paxTypePriceBreakup.setTypeRule(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getTypeRule());
				paxTypePriceBreakup.setMinAge(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getMinAge());
				paxTypePriceBreakup.setMaxAge(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getMaxAge());
				paxTypePriceBreakup.setSavings(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getSavings());

				paxTypePriceBreakup.setRoomId(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getRoomId());
				paxTypePriceBreakup.setAge(roomPricesList.get(k)
						.getPaxTypePriceBreakups().get(l).getAge());

				roomPrice.getPaxTypePriceBreakups().add(l, paxTypePriceBreakup);
			}
		}

		// END :- Setting PaxTypePriceBreakup Objects data into the Clients
		// PaxTypePriceBreakup Object

		roomPrice.setPriceChanged(roomPricesList.get(k).isPriceChanged());

		roomPrice
				.setGuestAllocation(roomPricesList.get(k).getGuestAllocation());
		roomPrice.setPackagePrice(roomPricesList.get(k).getPackagePrice());

		// BEGIN :- Setting PaxTypeBasePrices Objects data into the Clients
		// PaxTypeBasePrices Object

		if (roomPricesList.get(k).getPaxBasePrices() != null) {
			PaxTypeBasePrices paxTypeBasePrices = new PaxTypeBasePrices();

			paxTypeBasePrices.setNoOfAdults(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfAdults());
			paxTypeBasePrices.setNoOfChilds(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfChilds());
			paxTypeBasePrices.setNoOfInfants(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfInfants());
			paxTypeBasePrices.setNoOfLapChilds(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfLapChilds());
			paxTypeBasePrices.setNoOfSeniors(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfSeniors());
			paxTypeBasePrices.setChild1Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild1Age());
			paxTypeBasePrices.setChild2Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild2Age());
			paxTypeBasePrices.setChild3Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild3Age());
			paxTypeBasePrices.setChild4Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild4Age());
			paxTypeBasePrices.setChild5Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild5Age());
			paxTypeBasePrices.setChild6Age(roomPricesList.get(k)
					.getPaxBasePrices().getChild6Age());
			paxTypeBasePrices.setChild6Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild6Type());
			paxTypeBasePrices.setNoOfMinors(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfMinors());
			paxTypeBasePrices.setNoOfJuniors(roomPricesList.get(k)
					.getPaxBasePrices().getNoOfJuniors());
			paxTypeBasePrices.setChild1Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild1Type());
			paxTypeBasePrices.setChild2Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild2Type());
			paxTypeBasePrices.setChild3Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild3Type());
			paxTypeBasePrices.setChild4Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild4Type());
			paxTypeBasePrices.setChild5Type(roomPricesList.get(k)
					.getPaxBasePrices().getChild5Type());
			paxTypeBasePrices.setChildBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getChildBasePrice());
			paxTypeBasePrices.setAdultBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getAdultBasePrice());
			paxTypeBasePrices.setSeniorBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getSeniorBasePrice());
			paxTypeBasePrices.setInfantBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getInfantBasePrice());
			paxTypeBasePrices.setLapChildBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getLapChildBasePrice());
			paxTypeBasePrices.setJuniorBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getJuniorBasePrice());
			paxTypeBasePrices.setMinorBasePrice(roomPricesList.get(k)
					.getPaxBasePrices().getMinorBasePrice());

			roomPrice.setPaxBasePrices(paxTypeBasePrices);
		}
		// END :- Setting PaxTypeBasePrices Objects data into the Clients
		// PaxTypeBasePrices Object

		roomPrice.setPerAdultBasePrice(roomPricesList.get(k)
				.getPerAdultBasePrice());
		roomPrice.setPerAdultBasePriceSavings(roomPricesList.get(k)
				.getPerAdultBasePriceSavings());

		// XMLGregorianCalendar checkInDateRP =
		// XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(roomPricesList.get(k).getCheckInDate());
		// roomPrice.setCheckInDate(checkInDateRP);

		// roomCategory.getRoomPrices().add(k, roomPrice);
		return roomPrice;
	}

	/**
	 * Method for setting Clients RoomCategory Object
	 * 
	 * @param roomCategoryList
	 * 
	 * @return roomCategory
	 */
	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory getRoomCategoryObject(
			List<com.kcdata.abe.data.dto.RoomCategory> roomCategoryList, int j) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategory = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory();
		roomCategory.setHotelId(roomCategoryList.get(j).getHotelId());
		roomCategory.setRoomCategoryId(roomCategoryList.get(j)
				.getRoomCategoryId());

		roomCategory.setRoomTypeCode(roomCategoryList.get(j).getRoomTypeCode());
		// roomCategory.setRoomTypeCode(hotelMaterialCode);

		roomCategory.setRoomTypeDescription(roomCategoryList.get(j)
				.getRoomTypeDescription());
		roomCategory.setRatePlanId(roomCategoryList.get(j).getRatePlanId());
		roomCategory.setRatePlanCode(roomCategoryList.get(j).getRatePlanCode());
		roomCategory.setRatePlanDescription(roomCategoryList.get(j)
				.getRatePlanDescription());
		roomCategory.setRateIndicator(roomCategoryList.get(j)
				.getRateIndicator());
		roomCategory.setCorporateId(roomCategoryList.get(j).getCorporateId());
		roomCategory.setGuaranteeType(roomCategoryList.get(j)
				.getGuaranteeType());
		roomCategory.setGuaranteeMethod(roomCategoryList.get(j)
				.getGuaranteeMethod());
		roomCategory.setGuaranteeRequired(roomCategoryList.get(j)
				.getGuaranteeRequired());
		roomCategory.setGuaranteeAmount(roomCategoryList.get(j)
				.getGuaranteeAmount());
		roomCategory.setRatePlanCategory(roomCategoryList.get(j)
				.getRatePlanCategory());
		roomCategory.setNoOfRoomsAvailable(roomCategoryList.get(j)
				.getNoOfRoomsAvailable());
		roomCategory.setStatus(roomCategoryList.get(j).getStatus());
		roomCategory.setCurrency(roomCategoryList.get(j).getCurrency());

		// BEGIN :- Setting RoomPrice Objects data into the Clients RoomPrice
		// Object

		List<com.kcdata.abe.data.dto.RoomPrice> roomPricesList = roomCategoryList
				.get(j).getRoomPrices();
		if (roomPricesList != null) {
			for (int k = 0; k < roomPricesList.size(); k++) {
				RoomPrice roomPrice = getRoomPriceObject(roomPricesList, k);
				roomCategory.getRoomPrices().add(k, roomPrice);
			}
		}

		// END :- Setting RoomPrice Objects data into the Clients RoomPrice
		// Object

		if (roomCategoryList.get(j).getAmenities() != null) {
			for (int m = 0; m < roomCategoryList.get(j).getAmenities().size(); m++) {
				Amenity amenityBO = new Amenity();

				amenityBO.setAmenityCode(roomCategoryList.get(j).getAmenities()
						.get(m).getAmenityCode());
				XMLGregorianCalendar amenityDate = XMLGregorianCalendarConversionUtil
						.asXMLGregorianCalendar(roomCategoryList.get(j)
								.getAmenities().get(m).getAmenityDate());
				amenityBO.setAmenityDate(amenityDate);
				amenityBO.setAmenityName(roomCategoryList.get(j).getAmenities()
						.get(m).getAmenityName());
				amenityBO.setAmenityValue(roomCategoryList.get(j)
						.getAmenities().get(m).getAmenityValue());
				amenityBO.setHotelId(roomCategoryList.get(j).getAmenities()
						.get(m).getHotelId());
				amenityBO.setRoomCategoryId(roomCategoryList.get(j)
						.getAmenities().get(m).getRoomCategoryId());

				roomCategory.getAmenities().add(m, amenityBO);
			}
		}

		RoomPrice roomPrice = getRoomPriceObject(roomPricesList, 0);
		roomCategory.setDisplayRoomPrice(roomPrice);

		MealPlanType mealPlanType = new MealPlanType();
		if (roomCategoryList.get(j).getMealPlanType() != null) {
			mealPlanType.setCode(roomCategoryList.get(j).getMealPlanType()
					.getCode());
			mealPlanType.setDescription(roomCategoryList.get(j)
					.getMealPlanType().getDescription());
			roomCategory.setMealPlanType(mealPlanType);
		}

		roomCategory.setPosnr(roomCategoryList.get(j).getPosnr());
		roomCategory.setOldPosnr(roomCategoryList.get(j).getOldPosnr());
		roomCategory.setRiskRoomCategory(roomCategoryList.get(j)
				.isRiskRoomCategory());
		roomCategory.setAppleChoice(roomCategoryList.get(j).getAppleChoice());
		roomCategory.setMealplanDesc(roomCategoryList.get(j).getMealplanDesc());

		// hotelClient.getRoomCategories().add(j, roomCategory);

		return roomCategory;
	}

	/**
	 * Method for setting Clients SearchCriteria Object
	 * 
	 * @param searchCriteriaList
	 * 
	 * @return searchCriteriaClient
	 */
	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria getSearchCriteriaObject(
			com.kcdata.abe.data.dto.SearchCriteria searchCriteriaList) {
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria searchCriteriaClient = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.searchcriteria.v1.SearchCriteria();
		searchCriteriaClient.setGateway(searchCriteriaList.getGateway());
		XMLGregorianCalendar departureDate = XMLGregorianCalendarConversionUtil
				.asXMLGregorianCalendar(searchCriteriaList.getDepartureDate());
		searchCriteriaClient.setDepartureDate(departureDate);
		searchCriteriaClient.setPromoCode(searchCriteriaList.getPromoCode());

		// BEGIN :- Setting Occupancy Objects data into the Clients Occupancy
		// Object

		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy occupancyClient = new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.occupancy.v1.Occupancy();
		occupancyClient.setNoOfAdults(searchCriteriaList.getOccupancy()
				.getNoOfAdults());
		occupancyClient.setNoOfChilds(searchCriteriaList.getOccupancy()
				.getNoOfChilds());
		occupancyClient.setNoOfInfants(searchCriteriaList.getOccupancy()
				.getNoOfInfants());
		occupancyClient.setNoOfLapChilds(searchCriteriaList.getOccupancy()
				.getNoOfLapChilds());
		occupancyClient.setNoOfSeniors(searchCriteriaList.getOccupancy()
				.getNoOfSeniors());

		List<com.kcdata.abe.data.dto.Passenger> passengerList = searchCriteriaList
				.getOccupancy().getPassengers();

		if (passengerList != null) {
			for (int i = 0; i < passengerList.size(); i++) {
				com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger passenger = getPassengerObject(
						passengerList, i);
				occupancyClient.getPassengers().add(i, passenger);
			}
		}

		searchCriteriaClient.setOccupancy(occupancyClient);

		// END :- Setting Occupancy Objects data into the Clients Occupancy
		// Object

		List<com.kcdata.abe.data.dto.DestinationOptions> destinationOptionsList = (List<com.kcdata.abe.data.dto.DestinationOptions>) searchCriteriaList
				.getDestinationOptions();
		if (destinationOptionsList != null) {
			for (int i = 0; i < destinationOptionsList.size(); i++) {
				DestinationOptions destinationOptions = getdestinationOptionsObject(
						destinationOptionsList, i);
				searchCriteriaClient.getDestinationOptions().add(i,
						destinationOptions);
			}
		}
		// searchCriteriaClient.setdestinationOptions(searchCriteriaList.getDestinationOptions());

		List<String> nearByGatewaysList = searchCriteriaList
				.getNearByGateways();
		if (nearByGatewaysList != null) {
			// List<String> gatewaysList =new ArrayList<String>();
			for (int i = 0; i < nearByGatewaysList.size(); i++) {
				// gatewaysList.add(nearByGatewaysList.get(i));
				searchCriteriaClient.getNearByGateways().add(i,
						nearByGatewaysList.get(i));
			}
		}

		searchCriteriaClient.setAnchorGateway(searchCriteriaList
				.getAnchorGateway());
		XMLGregorianCalendar anchorDepartureDate = XMLGregorianCalendarConversionUtil
				.asXMLGregorianCalendar(searchCriteriaList
						.getAnchorDepartureDate());
		searchCriteriaClient.setAnchorDepartureDate(anchorDepartureDate);

		FlightTripType flightTripTypeClient = new FlightTripType();
		if (searchCriteriaList.getFlightTripType() != null) {
			flightTripTypeClient.setType(searchCriteriaList.getFlightTripType()
					.getType());
		}
		searchCriteriaClient.setFlightTripType(flightTripTypeClient);

		searchCriteriaClient.setBookingNo(searchCriteriaList.getBookingNo());

		searchCriteriaClient.setFilterSpecials(searchCriteriaList
				.isFilterSpecials());

		// END :- Setting SearchCriteria Objects data into the Clients
		// SearchCriteria Object

		return searchCriteriaClient;
	}

	/**
	 * Method for setting Clients DestinationOptions Object
	 * 
	 * @param destinationOptionsList
	 * 
	 * @return destinationOptions
	 */
	private DestinationOptions getdestinationOptionsObject(
			List<com.kcdata.abe.data.dto.DestinationOptions> destinationOptionsList,
			int i) {
		DestinationOptions destinationOptions = new DestinationOptions();

		destinationOptions.setAirRequested(destinationOptionsList.get(i)
				.isAirRequested());
		destinationOptions.setAlternateGatewayMiles(destinationOptionsList.get(
				i).getAlternateGatewayMiles());
		destinationOptions.setCharterOnly(destinationOptionsList.get(i)
				.isCharterOnly());
		destinationOptions.setDestination(destinationOptionsList.get(i)
				.getDestination());
		destinationOptions.setDestinationId(destinationOptionsList.get(i)
				.getDestinationId());
		destinationOptions.setDoubleConnections(destinationOptionsList.get(i)
				.getDoubleConnections());
		destinationOptions.setFlexiDateIndicator(destinationOptionsList.get(i)
				.isFlexiDateIndicator());
		destinationOptions.setHotelRequested(destinationOptionsList.get(i)
				.isHotelRequested());
		destinationOptions.setMultiCarrierFlights(destinationOptionsList.get(i)
				.getMultiCarrierFlights());
		destinationOptions.setNearbyAirportIndicator(destinationOptionsList
				.get(i).isNearbyAirportIndicator());
		destinationOptions.setNonStopFlights(destinationOptionsList.get(i)
				.getNonStopFlights());
		destinationOptions.setNoOfAirOptions(destinationOptionsList.get(i)
				.getNoOfAirOptions());
		destinationOptions.setNoOfNights(destinationOptionsList.get(i)
				.getNoOfNights());
		destinationOptions.setSkedOnly(destinationOptionsList.get(i)
				.isSkedOnly());
		destinationOptions.setVehicleRequested(destinationOptionsList.get(i)
				.isVehicleRequested());

		if (destinationOptionsList.get(i).getOutboundAirOptions() != null) {
			com.kcdata.abe.data.dto.AirOptions outBoundAirOptions = destinationOptionsList
					.get(i).getOutboundAirOptions();

			AirOptions outBoundAirOptionsClient = getAirOptionsObject(outBoundAirOptions);
			destinationOptions.setOutboundAirOptions(outBoundAirOptionsClient);
		}

		if (destinationOptionsList.get(i).getInboundAirOptions() != null) {
			destinationOptions
					.setInboundAirOptions(getAirOptionsObject(destinationOptionsList
							.get(i).getInboundAirOptions()));
		}
		if (destinationOptionsList.get(i).getVehicleOptions() != null) {
			destinationOptions
					.setVehicleOptions(getVehicleOptionsOBject(destinationOptionsList
							.get(i).getVehicleOptions()));
		}
		if (destinationOptionsList.get(i).getSpecialOptions() != null) {
			destinationOptions
					.setSpecialOptions(getSpecialOptionsBO(destinationOptionsList
							.get(i).getSpecialOptions()));
		}

		// Prepare List of Carriers preferredCarriersList for DestinationOptions
		if (destinationOptionsList.get(i).getPreferredCarriersList() != null) {
			for (int i1 = 0; i1 < destinationOptionsList.get(i1)
					.getPreferredCarriersList().size(); i1++) {
				Carrier carrierBO = getCarriersBO(destinationOptionsList
						.get(i1).getPreferredCarriersList().get(i1));
				destinationOptions.getPreferredCarriersList()
						.add(i1, carrierBO);
			}
		}

		// Prepare List nearByDestinations for DestinationOptions BO
		if (destinationOptionsList.get(i).getNearByDestinations() != null) {
			for (int i1 = 0; i1 < destinationOptionsList.get(i1)
					.getNearByDestinations().size(); i1++) {
				destinationOptions.getNearByDestinations().add(
						i1,
						destinationOptionsList.get(i1).getNearByDestinations()
								.get(i1));
			}

		}

		return destinationOptions;

	}

	/**
	 * Method for setting Clients AirOptions Object
	 * 
	 * @param outBoundAirOptions
	 * 
	 * @return airOptionsBO
	 */
	private AirOptions getAirOptionsObject(
			com.kcdata.abe.data.dto.AirOptions outBoundAirOptions) {
		AirOptions airOptionsBO = new AirOptions();
		airOptionsBO.setClassOfService(outBoundAirOptions.getClassOfService());
		airOptionsBO.setConnectingCity(outBoundAirOptions.getConnectingCity());
		airOptionsBO
				.setConnectionCity1(outBoundAirOptions.getConnectionCity1());
		airOptionsBO
				.setConnectionCity2(outBoundAirOptions.getConnectionCity2());
		airOptionsBO.setExcludeCity1(outBoundAirOptions.getExcludeCity1());
		airOptionsBO.setExcludeCity2(outBoundAirOptions.getExcludeCity2());
		airOptionsBO.setExcludeCity3(outBoundAirOptions.getExcludeCity3());
		airOptionsBO.setFlightNo(outBoundAirOptions.getFlightNo());
		airOptionsBO.setNoOfStops(outBoundAirOptions.getNoOfStops());
		airOptionsBO.setShowAll(outBoundAirOptions.isShowAll());
		airOptionsBO.setStopOverCity(outBoundAirOptions.getStopOverCity());
		airOptionsBO.setStopOverDuration(outBoundAirOptions
				.getStopOverDuration());
		if (outBoundAirOptions.getDepartureTimeOfDay() != null) {
			TimeOfDay timeOfDay = new TimeOfDay();
			timeOfDay.setCode(outBoundAirOptions.getDepartureTimeOfDay()
					.getCode());
			airOptionsBO.setDepartureTimeOfDay(timeOfDay);
		}
		if (outBoundAirOptions.getArrivaTimeOfDay() != null) {
			TimeOfDay timeOfDay = new TimeOfDay();
			timeOfDay
					.setCode(outBoundAirOptions.getArrivaTimeOfDay().getCode());
			airOptionsBO.setArrivaTimeOfDay(timeOfDay);
		}
		if (outBoundAirOptions.getCabinType() != null) {
			CabinType cabinType = new CabinType();
			cabinType.setType(Character.toString(outBoundAirOptions
					.getCabinType().getType()));
			airOptionsBO.setCabinType(cabinType);
		}
		return airOptionsBO;
	}

	/**
	 * Method for setting Clients VehicleOptions Object
	 * 
	 * @param vehicleOptionDTO
	 * 
	 * @return vehicleOptionsBO
	 */
	private VehicleOptions getVehicleOptionsOBject(
			com.kcdata.abe.data.dto.VehicleOptions vehicleOptionDTO) {
		VehicleOptions vehicleOptionsBO = new VehicleOptions();
		XMLGregorianCalendar dropoffDateTime = XMLGregorianCalendarConversionUtil
				.asXMLGregorianCalendar(vehicleOptionDTO.getDropoffDateTime());
		vehicleOptionsBO.setDropoffDateTime(dropoffDateTime);
		vehicleOptionsBO.setDropoffLocation(vehicleOptionDTO
				.getDropoffLocation());
		XMLGregorianCalendar pickupDateTime = XMLGregorianCalendarConversionUtil
				.asXMLGregorianCalendar(vehicleOptionDTO.getPickupDateTime());
		vehicleOptionsBO.setPickupDateTime(pickupDateTime);
		vehicleOptionsBO
				.setPickupLocation(vehicleOptionDTO.getPickupLocation());
		vehicleOptionsBO.setVendorCode(vehicleOptionDTO.getVendorCode());
		vehicleOptionsBO.setVehicleClass(vehicleOptionDTO.getVehicleClass());
		return vehicleOptionsBO;
	}

	/**
	 * Method for setting Clients SpecialType Object
	 * 
	 * @param specialTypeDTO
	 * 
	 * @return specialTypeBO
	 */
	private SpecialType getSpecialTypeBO(
			com.kcdata.abe.data.dto.SpecialType specialTypeDTO) {
		SpecialType specialTypeBO = new SpecialType();
		specialTypeBO.setType(specialTypeDTO.getType());
		return specialTypeBO;
	}

	/**
	 * Method for setting Clients SpecialRequestType Object
	 * 
	 * @return specialRequestTypeBO
	 */
	private SpecialRequestType getSpecialRequestTypeBO(
			com.kcdata.abe.data.dto.SpecialRequestType specialRequestTypeDTO) {
		SpecialRequestType specialRequestTypeBO = new SpecialRequestType();
		specialRequestTypeBO.setType(specialRequestTypeDTO.getType());
		return specialRequestTypeBO;
	}

	/**
	 * Method for setting Clients SpecialOptions Object
	 * 
	 * @param specialRequestTypeDTO
	 * 
	 * @return specialOptionsBO
	 */
	private SpecialOptions getSpecialOptionsBO(
			com.kcdata.abe.data.dto.SpecialOptions specialOptionsDTO) {
		SpecialOptions specialOptionsBO = new SpecialOptions();
		specialOptionsBO.setSpecialBatchId(specialOptionsDTO
				.getSpecialBatchId());
		specialOptionsBO.setSpecialCategoryId(specialOptionsDTO
				.getSpecialCategoryId());
		specialOptionsBO.setSpecialId(specialOptionsDTO.getSpecialId());
		if (specialOptionsDTO.getSpecialType() != null) {
			specialOptionsBO.setSpecialType(getSpecialTypeBO(specialOptionsDTO
					.getSpecialType()));
		}
		if (specialOptionsDTO.getSpecialRequestType() != null) {
			specialOptionsBO
					.setSpecialRequestType(getSpecialRequestTypeBO(specialOptionsDTO
							.getSpecialRequestType()));
		}
		return specialOptionsBO;

	}

	/**
	 * Method for setting Clients Carrier Object
	 * 
	 * @param carrierDTO
	 * 
	 * @return carrierBO
	 */
	private Carrier getCarriersBO(com.kcdata.abe.data.dto.Carrier carrierDTO) {
		Carrier carrierBO = new Carrier();
		carrierBO.setCarrierCode(carrierDTO.getCarrierCode());
		carrierBO.setCarrierName(carrierDTO.getCarrierName());
		carrierBO.setCodeshareAvaialable(carrierDTO.isCodeshareAvaialable());
		carrierBO.setCodeShareInfo(carrierDTO.getCodeShareInfo());
		return carrierBO;

	}

	/**
	 * Method for setting Clients Passenger Object
	 * 
	 * @param passengerList
	 * 
	 * @return passenger
	 */

	private Passenger getPassengerObject(
			List<com.kcdata.abe.data.dto.Passenger> passengerList, int i) {
		com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger passenger = new com.kcdataservices.partners.kcdebdmnlib_common.businessobjects.passenger.v1.Passenger();
		passenger.setPaxId(passengerList.get(i).getPaxId());
		passenger.setRoomNumber(passengerList.get(i).getRoomNumber());
		if (passengerList.get(i).getAgeCode() != null) {
			AgeCode ageCode = new AgeCode();
			ageCode.setAge((int) passengerList.get(i).getAgeCode().getAgeCode());
			ageCode.setPaxTypeCode(Character.toString(passengerList.get(i)
					.getAgeCode().getPaxTypeCode()));
			passenger.setAgeCode(ageCode);
		}
		passenger.setAge(passengerList.get(i).getAge());
		passenger.setGuestCount(passengerList.get(i).getGuestCount());
		// occupancyClient.getPassengers().add(i, passenger);
		return passenger;
	}

	/**
	 * Method for setting Clients GuestInfo Object
	 * 
	 * @param passengerList
	 * 
	 * @return
	 */
	private void setGuestInfoObject(
			List<GuestInfo> guestInfos,
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient) {

		for (int i = 0; i < guestInfos.size(); i++) {
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo guestInfo = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.guestinfo.v1.GuestInfo();
			guestInfo.setSelectedFlag(guestInfos.get(i).getSelectedFlag());
			guestInfo.setGuestId(guestInfos.get(i).getGuestId());
			if (guestInfos.get(i).getAgeCode() != null) {
				AgeCode ageCode = new AgeCode();
				ageCode.setAge((int) guestInfos.get(i).getAgeCode()
						.getAgeCode());
				ageCode.setPaxTypeCode(Character.toString(guestInfos.get(i)
						.getAgeCode().getPaxTypeCode()));
				guestInfo.setAgeCode(ageCode);
			}
			guestInfo.setAge(guestInfos.get(i).getAge());
			guestInfo.setLapChild(guestInfos.get(i).isLapChild());
			guestInfo.setTitle(guestInfos.get(i).getTitle());
			guestInfo.setFirstName(guestInfos.get(i).getFirstName());
			guestInfo.setLastName(guestInfos.get(i).getLastName());
			guestInfo.setMiddleName(guestInfos.get(i).getMiddleName());
			guestInfo.setGender(guestInfos.get(i).getGender());
			XMLGregorianCalendar dateOfBirth = XMLGregorianCalendarConversionUtil
					.asXMLGregorianCalendar(guestInfos.get(i).getDateOfBirth());
			guestInfo.setDateOfBirth(dateOfBirth);
			guestInfo.setPhoneNumber(guestInfos.get(i).getPhoneNumber());
			guestInfo.setEmailId(guestInfos.get(i).getEmailId());
			guestInfo.setParentGuestId(guestInfos.get(i).getParentGuestId());
			guestInfo.setEmergencyContactName(guestInfos.get(i)
					.getEmergencyContactName());
			guestInfo.setEmergencyContactPhone(guestInfos.get(i)
					.getEmergencyContactPhone());
			guestInfo
					.setFrequentFlyerNo(guestInfos.get(i).getFrequentFlyerNo());
			if (guestInfos.get(i).getPassportInfo() != null) {
				PassportInfo passportInfo = new PassportInfo();
				passportInfo.setPassportNumber(guestInfos.get(i)
						.getPassportInfo().getPassportNumber());
				passportInfo.setNationality(guestInfos.get(i).getPassportInfo()
						.getNationality());
				passportInfo.setCountryOfIssue(guestInfos.get(i)
						.getPassportInfo().getCountryOfIssue());
				XMLGregorianCalendar expirationDate = XMLGregorianCalendarConversionUtil
						.asXMLGregorianCalendar(guestInfos.get(i)
								.getPassportInfo().getExpirationDate());
				passportInfo.setExpirationDate(expirationDate);
				if (guestInfos.get(i).getPassportInfo().getAddress() != null) {
					Address address = new Address();
					address.setStreetAddress(guestInfos.get(i)
							.getPassportInfo().getAddress().getStreetAddress());
					address.setCity(guestInfos.get(i).getPassportInfo()
							.getAddress().getCity());
					address.setState(guestInfos.get(i).getPassportInfo()
							.getAddress().getState());
					//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					//Todo: This country field couldn't be required as per business
					// So we are just commneted for future use
//					address.setCountry(guestInfos.get(i).getPassportInfo()
//							.getAddress().getCountry());
					//End of the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
					  
					address.setZipCode(guestInfos.get(i).getPassportInfo()
							.getAddress().getZipCode());
					passportInfo.setAddress(address);
				}
				guestInfo.setPassportInfo(passportInfo);
			}
			guestInfo.setAirRemarks(guestInfos.get(i).getAirRemarks());
			guestInfo.setHotelRemarks(guestInfos.get(i).getHotelRemarks());
			guestInfo.setCruiseRemarks(guestInfos.get(i).getCruiseRemarks());
			guestInfo.setMealRequest(guestInfos.get(i).getMealRequest());
			guestInfo.setAirRequest(guestInfos.get(i).getAirRequest());
			guestInfo.setGroundRequest(guestInfos.get(i).getGroundRequest());
			guestInfo
					.setCateringRequest(guestInfos.get(i).getCateringRequest());
			guestInfo.setSeatPreference(guestInfos.get(i).getSeatPreference());

			GuestPriceBreakup guestPriceBreakup = new GuestPriceBreakup();
			if (guestInfos.get(i).getPriceBreakup() != null) {
				guestPriceBreakup.setFlightPrice(guestInfos.get(i)
						.getPriceBreakup().getFlightPrice());
				guestPriceBreakup.setHotelPrice(guestInfos.get(i)
						.getPriceBreakup().getHotelPrice());
				guestPriceBreakup.setVehiclePrice(guestInfos.get(i)
						.getPriceBreakup().getVehiclePrice());
				guestPriceBreakup.setInsurancePrice(guestInfos.get(i)
						.getPriceBreakup().getInsurancePrice());
				guestPriceBreakup.setSupplementsPrice(guestInfos.get(i)
						.getPriceBreakup().getSupplementsPrice());
				guestPriceBreakup.setTaxPrice(guestInfos.get(i)
						.getPriceBreakup().getTaxPrice());
				guestPriceBreakup.setFees(guestInfos.get(i).getPriceBreakup()
						.getFees());
				guestPriceBreakup.setServicePrice(guestInfos.get(i)
						.getPriceBreakup().getServicePrice());
				guestPriceBreakup.setTotalPrice(guestInfos.get(i)
						.getPriceBreakup().getTotalPrice());

				// For basePrice field in GuestPriceBreakup class in WESB is
				// String type,but in ABECore it is Double.
				guestPriceBreakup.setBasePrice(guestInfos.get(i)
						.getPriceBreakup().getBasePrice());

				guestInfo.setPriceBreakup(guestPriceBreakup);
			}

			guestInfo.setPnrNumber(guestInfos.get(i).getPnrNumber());
			guestInfo.setStatus(guestInfos.get(i).getStatus());
			guestInfo.setRedressNumber(guestInfos.get(i).getRedressNumber());
			guestInfo.setChangeType(guestInfos.get(i).getChangeType());
			guestInfo.setOldPaxId(guestInfos.get(i).getOldPaxId());
			guestInfo.setPaxWeight(guestInfos.get(i).getPaxWeight());

			itineraryClient.getGuests().add(i, guestInfo);
		}

	}

}
