/*
 * HotelsDaoSAPImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 26, 2009  nvittal
 * Sep 14, 2009	 hguntupa	  Added methods for hotel availability of packages
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.util.HotelRatingComparator;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.vendorservice.v1.VendorService;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityresponse.v1.HotelsAvailabilityResponse;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspricebreakuprequest.v1.HotelsPriceBreakUpRequest;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelspricebreakupresponse.v1.HotelsPriceBreakUpResponse;
import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.RetrieveHotelsRetrieveHotelsFaultMsg;

/**
 * DAO class for retrieving Hotels from SAP
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HBSiHotelsOnlyDaoImpl extends ABESAPDaoBase implements HBSiHotelsOnlyDao {

	ABELogger logger = ABELogger.getLogger(HotelsWESBDaoImpl.class);
	

	private WesbProxyService proxyService;

	/**
	 * @return the proxyService
	 */
	public WesbProxyService getProxyService() {
		return proxyService;
	}

	/**
	 * @param proxyService
	 *            the proxyService to set
	 */
	public void setProxyService(WesbProxyService proxyService) {
		this.proxyService = proxyService;
	}



	/**
	 * Method to retrieve Hotels
	 * 
	 * @param hotelsRequest
	 * @param hbsiHotelList
	 * @return hotelResponse
	 */

	public HotelsResponse retrieveWesbHotels(Itinerary itinerary, Hotel hotelDTO,HotelsRequest hotelsRequest,
			Map<String, HBSiHotelInfo> hbsiHotelList,String availibiltySource) {
		HotelsResponse hotelResponse = new HotelsResponse();
		
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityresponse.v1.HotelsAvailabilityResponse hotelsAvailabilityResponse = null;
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest hotelsAvailabilityRequest = this
				.getHotelsAvailabilityRequestBO(itinerary,hotelDTO,hotelsRequest,availibiltySource);
		// Create one more response object which will have modified room
		// categories
		hotelsAvailabilityRequest.setAvailabilitySource(availibiltySource);
		HotelsAvailabilityResponse wesbHotelsresponse = new HotelsAvailabilityResponse();
		if(itinerary.getHotels()!=null && itinerary.getFlights()==null && itinerary.getVehicles()==null && itinerary.getPackages()==null && itinerary.getMultiDestinationPackages()==null)
		{
			hotelsAvailabilityRequest.setHotelRequested(true);
			hotelsAvailabilityRequest.setPackageRequest(false);
			
		}
		else
		{
			hotelsAvailabilityRequest.setPackageRequest(true);
			hotelsAvailabilityRequest.setAirRequested(true);
		}
		
		try {
			hotelsAvailabilityResponse = proxyService.getProxyService()
					.retrieveHotels(hotelsAvailabilityRequest);

			if (hotelsAvailabilityResponse != null
					&& hotelsAvailabilityResponse.getBusinessError() != null
					&& hotelsAvailabilityResponse.getBusinessError().size() > 0 && hotelsAvailabilityResponse.getHotelList()==null) {
				HotelsResponse response = new HotelsResponse();
				List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

				for (int l = 0; l < hotelsAvailabilityResponse
						.getBusinessError().size(); l++) {
					ABEBusinessError businessError = null;
					businessError = this
							.getABEBusinessError(hotelsAvailabilityResponse
									.getBusinessError().get(l));
					if (businessError != null)
						businesserrorList.add(businessError);

				}

				if (businesserrorList != null && businesserrorList.size() > 0)
				{
					response.saveBusinessErrors(businesserrorList);
				}
				
				return response;

			}

			// If it is HBSi hotel set the roomTypecode

			List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelResponseList = new ArrayList<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>();

			if (hotelsAvailabilityResponse != null && hbsiHotelList != null) {
				List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelList = hotelsAvailabilityResponse
						.getHotelList();

				for (int i = 0; i < hotelList.size(); i++) {
					com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel hotel = hotelList
							.get(i);

					if (hotel.getHotelCode() != null
							&& hbsiHotelList.containsKey(hotel.getHotelCode())) {
						
						//Populate complimentary services
						VendorService vendorServiceBO = new VendorService();
						List<VendorService> vendorServices = new ArrayList<VendorService>(1);
						vendorServiceBO.setCurrency("USD");
						vendorServiceBO.setPrice(new Double(0.0));
						vendorServiceBO.setServiceName("Roundtrip Transfer");
						vendorServiceBO.setServiceCode("TRANSFER");
						if(hotel.getVendor()!=null)
						vendorServiceBO.setVendorId(Integer.valueOf(hotel.getVendor().getVendorId()));
						vendorServices.add(vendorServiceBO);
						hotel.getVendorServices().add(vendorServiceBO);
						
						
						HBSiHotelInfo hbsiHotelInfo = new HBSiHotelInfo();
						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory> roomCategoryList = hotel
								.getRoomCategories();

						int sizeOfRoomCategory = roomCategoryList.size();
						hbsiHotelInfo = hbsiHotelList.get(hotel.getHotelCode());

						for (int j = 0; j < sizeOfRoomCategory; j++) {

							com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomcategory.v1.RoomCategory roomCategory = roomCategoryList
									.get(j);
							hotel.getRoomCategories().remove(j);
							if (hbsiHotelInfo != null && roomCategory != null) {
								roomCategory.setRoomTypeCode(hbsiHotelInfo
										.getHotelMaterialId());
							}

							hotel.getRoomCategories().add(j, roomCategory);

						}
						if (hbsiHotelInfo != null) {
							hotel.getDisplayRoomCategory().setRoomTypeCode(
									hbsiHotelInfo.getHotelMaterialId());
							if (hotel.getAppleRating() == null
									|| hotel.getAppleRating().equals(""))
								hotel.setAppleRating(hbsiHotelInfo
										.getAppleRating());
							if (hotel.getResortArea() == null) {
								ResortArea resortAreaBO = new ResortArea();
								resortAreaBO.setResortAreaCode(hbsiHotelInfo
										.getResortAreaCode());
								resortAreaBO.setResortAreaName(hbsiHotelInfo
										.getResortAreaName());
								hotel.setResortArea(resortAreaBO);
								hotel.setHotelChain(hbsiHotelInfo.getResortAreaCode());
							}
						}

						hotelResponseList.add(hotel);

					} 

				}

			}

			if (hotelResponseList != null) {

				for (int i = 0; i < hotelResponseList.size(); i++) {
					wesbHotelsresponse.getHotelList().add(
							hotelResponseList.get(i));
				}
			}
			if (hotelsAvailabilityResponse.getDestinations() != null && hotelResponse.getDestinations()!=null) {

				for (int i = 0; i < hotelResponse.getDestinations().size(); i++) {

					wesbHotelsresponse.getDestinations()
							.add(hotelsAvailabilityResponse.getDestinations()
									.get(i));
				}
			}

		} catch (RetrieveHotelsRetrieveHotelsFaultMsg e) {
			e.printStackTrace();

		}
		
		catch (Exception e) {
			e.printStackTrace();

		}
		
		if (wesbHotelsresponse != null) {

			hotelResponse = this.getHotelResponse(wesbHotelsresponse);

		}

		if (hotelResponse.isBusinessErrorOccurred()) {
			return hotelResponse;
		}

		return hotelResponse;
	}

	/**
	 * method to prepare HotelOptions BO
	 * @param hotelOptions
	 * @return hotelOptionsReq
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions getHotelOptionsBO(SearchCriteria searchCriteria,Hotel hotelDTO,String availibiltySource){
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions hotelOptionsReq = 
			new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hoteloptions.v1.HotelOptions();
		
		
		hotelOptionsReq.setAppleRating( hotelDTO.getAppleRating() );
		hotelOptionsReq.setHotelCode(hotelDTO.getHotelCode());
		hotelOptionsReq.setHotelChain( hotelDTO.getHotelChain() );
		
		hotelOptionsReq.setHotelName( hotelDTO.getHotelName() );
		if(hotelDTO.getRoomCategories()!=null && hotelDTO.getRoomCategories().get(0)!=null )
			//Commented below if condition: retrieve quote should return meal plan code and roomtype description
		//if(hotelDTO.getRoomCategories()!=null && hotelDTO.getRoomCategories().get(0)!=null && !availibiltySource.equalsIgnoreCase("CQ"))
		{
			if (hotelDTO.getRoomCategories().get(0).getRoomTypeDescription() == null
					|| hotelDTO.getRoomCategories().get(0)
							.getRoomTypeDescription().isEmpty())
			{
				//Start the fix of HBSI 52 -Phase 1
				hotelOptionsReq.setRoomTypeCode(hotelDTO.getDisplayRoomCategory().getRoomTypeCode());
				//End the fix of HBSi 52 -Phase 1
			}
			else
				{
				hotelOptionsReq.setRoomTypeCode( hotelDTO.getRoomCategories().get(0).getRoomTypeDescription());
				}
			
		hotelOptionsReq.setRatePlanCode( hotelDTO.getRoomCategories().get(0).getRatePlanCode());
		
		if(hotelDTO.getRoomCategories()!=null && hotelDTO.getRoomCategories().get(0)!=null && hotelDTO.getRoomCategories().get(0).getMealPlanType()!=null)
		{
			hotelOptionsReq.setMealPlanCode(hotelDTO.getRoomCategories().get(0).getMealPlanType().getCode());
		} else {
			hotelOptionsReq.setMealPlanCode(hotelDTO.getRoomCategories().get(0).getMealplanDesc()); 
		}
		
		}
		
		if( hotelDTO.getResortArea() != null ){
			hotelOptionsReq.setResortArea( this.getResortAreaReq( hotelDTO.getResortArea() ) );
		}
		if( this.getIMApplicationInfo() != null ){
			hotelOptionsReq.setImApplicationInfo( this.getImApplicationInfoReq( this.getIMApplicationInfo() ) );
		}
		if((new Integer(hotelDTO.getNoOfRooms())) > 0) {
			hotelOptionsReq.setNoOfRooms( new Integer(hotelDTO.getNoOfRooms()) );
		} else {
			hotelOptionsReq.setNoOfRooms(1);
		}
		//hotelOptionsReq.setShowAll( new Boolean(false) );
		
		
		if( (hotelDTO.getDisplayRoomCategory().getAmenities() != null) && (hotelDTO.getDisplayRoomCategory().getAmenities().size() > 0) ){
			for(int i=0; i < hotelDTO.getDisplayRoomCategory().getAmenities().size(); i++){
				if( hotelDTO.getDisplayRoomCategory().getAmenities().get(i) != null ){
					hotelOptionsReq.getAmenities().add(this.getAmenityReq(hotelDTO.getDisplayRoomCategory().getAmenities().get(i)));
				}
			}
		}
		return hotelOptionsReq;
	}
	
	/**
	 * Method to prepare HotelsAvailabilityRequest
	 * 
	 * @param hotelsRequest
	 * @return hotelsAvailabilityRequest
	 */
	private HotelsAvailabilityRequest getHotelsAvailabilityRequestBO(
			Itinerary itinerary,Hotel hotelDTO,HotelsRequest hotelsRequest,String availibiltySource) {
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest hotelsAvailabilityRequest = new com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest();
			//Commented this code what if there are more than one hotel and first hotel is SAP
			//hotelDTO.setNoOfRooms(itinerary.getHotels().get(0).getSelectedRooms().size());
			hotelsAvailabilityRequest.setHotelOptions(this
					.getHotelOptionsBO(itinerary.getSearchCriteria(),hotelDTO,availibiltySource));
		
		/*if (hotelsRequest.getSpecialOptions() != null) {
			hotelsAvailabilityRequest.setSpecialOptions(this
					.getSpecialOptionsReq(hotelsRequest.getSpecialOptions()));
		}*/

		//hotelsAvailabilityRequest.setGateway(itinerary.getHotels().get(0).getOriginLocation());
			hotelsAvailabilityRequest.setGateway(hotelDTO.getOriginLocation());
		
		//hotelsAvailabilityRequest.setDestination(itinerary.getHotels().get(0).getHotelCityCode());
			hotelsAvailabilityRequest.setDestination(hotelDTO.getHotelCityCode());

		//if (itinerary.getHotels().get(0).getCheckInDate() != null) {
		if (hotelDTO.getCheckInDate() != null) {
			hotelsAvailabilityRequest.setDepartureDate(this.getDate(hotelDTO.getCheckInDate()));
		}
		
		//int numberOfNight = (int)(itinerary.getHotels().get(0).getCheckOutDate().getTime() - itinerary.getHotels().get(0).getCheckInDate().getTime())/(1000*60*60*24);
		int numberOfNight = (int)(hotelDTO.getCheckOutDate().getTime() - hotelDTO.getCheckInDate().getTime())/(1000*60*60*24);
		hotelsAvailabilityRequest.setNoOfNights((short)numberOfNight);
		
		if(itinerary.getSearchCriteria() != null && itinerary.getSearchCriteria().getPromoCode() != null) {
			hotelsAvailabilityRequest.setPromoCode(itinerary.getSearchCriteria().getPromoCode());
		}
		
		hotelsAvailabilityRequest.setAirRequested(false);
		hotelsAvailabilityRequest.setHotelRequested(true);
		hotelsAvailabilityRequest.setVehicleRequested(false);

		hotelsAvailabilityRequest.setMultiDestinationRequest(false);
		hotelsAvailabilityRequest.setPackageRequest(false);
		hotelsAvailabilityRequest.setBookingNo(itinerary.getBookingNo());

		if (hotelDTO.getOccupancy() != null) {
			hotelsAvailabilityRequest.setOccupancy(this.getOccupancyReq(hotelDTO.getOccupancy()));
		}
		
		return hotelsAvailabilityRequest;
	}

	/**
	 * Method to prepare HotelsResponse
	 * 
	 * @param hotelsAvailabilityResponse
	 * @return hotelsResponse
	 */
	private HotelsResponse getHotelResponse(
			HotelsAvailabilityResponse hotelsAvailabilityResponse) {
		HotelsResponse hotelsResponse = new HotelsResponse();
		if ((hotelsAvailabilityResponse.getHotelList() != null)
				&& (hotelsAvailabilityResponse.getHotelList().size() > 0)) {
			List<Hotel> hotelList = new ArrayList<Hotel>();
			for (int i = 0; i < hotelsAvailabilityResponse.getHotelList()
					.size(); i++) {
				if (hotelsAvailabilityResponse.getHotelList().get(i) != null) {
					hotelList.add(this.getHotel(hotelsAvailabilityResponse
							.getHotelList().get(i)));
				}
			}
			Collections.sort(hotelList, new HotelRatingComparator());
			hotelsResponse.setHotelList(hotelList);
		}
		if ((hotelsAvailabilityResponse.getDestinations() != null)
				&& (hotelsAvailabilityResponse.getDestinations().size() > 0)) {
			List<Destination> destinations = new ArrayList<Destination>();
			for (int i = 0; i < hotelsAvailabilityResponse.getDestinations()
					.size(); i++) {
				if (hotelsAvailabilityResponse.getDestinations().get(i) != null) {
					destinations.add(this
							.getDestination(hotelsAvailabilityResponse
									.getDestinations().get(i)));
				}
			}
			hotelsResponse.setDestinations(destinations);
		} else {
			hotelsResponse.setDestinations(new ArrayList<Destination>());
		}

		return hotelsResponse;
	}
}