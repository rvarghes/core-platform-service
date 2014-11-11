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
import java.util.List;
import java.util.Map;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.util.HotelRatingComparator;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.resortarea.v1.ResortArea;
import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.roomprice.v1.RoomPrice;
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
public class HotelsWESBDaoImpl extends ABESAPDaoBase implements WesbHotelDao {

	ABELogger logger = ABELogger.getLogger(HotelsWESBDaoImpl.class);
	private List<Hotel> naHotelList=new ArrayList<Hotel>();

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

	public HotelsResponse retrieveWesbHotels(HotelsRequest hotelsRequest,
			Map<String, HBSiHotelInfo> hbsiHotelList) {
		HotelsResponse hotelResponse = new HotelsResponse();
		if (hotelsRequest == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			hotelResponse.saveBusinessError(businessError);
			return hotelResponse;
		}
		
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityresponse.v1.HotelsAvailabilityResponse hotelsAvailabilityResponse = null;
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest hotelsAvailabilityRequest = this
				.getHotelsAvailabilityRequest(hotelsRequest);
		// Create one more response object which will have modified room
		// categories
		if(hotelsRequest!=null && hotelsRequest.getHotelOptions()!=null){
			if(hotelsRequest.getHotelOptions().isNoTierOne()){
				naHotelList.clear();
				if(hotelsRequest.getHotelOptions().isShowAll()){
					hotelsAvailabilityRequest.getHotelOptions().setShowMsg("X");
				}else{
					hotelsAvailabilityRequest.getHotelOptions().setShowMsg("");
				}					
			}else{
				//request is for tier one hotels
				if(hotelsRequest.getHotelOptions().isShowTierOne()){
					hotelsAvailabilityRequest.getHotelOptions().setShowMsg("T");
					naHotelList.clear();
				}
				//request is for ShowMore
					else if(hotelsRequest.getHotelOptions().isShowMore()){
						hotelsAvailabilityRequest.getHotelOptions().setShowMsg("S");
					}
				//request is for showAll
					else if(hotelsRequest.getHotelOptions().isShowAll())
						hotelsAvailabilityRequest.getHotelOptions().setShowMsg("A");
			}
		}
		HotelsAvailabilityResponse wesbHotelsresponse = new HotelsAvailabilityResponse();

		boolean isShowAll=false;
		try {
			hotelsAvailabilityResponse = proxyService.getProxyService()
					.retrieveHotels(hotelsAvailabilityRequest);
			if(hotelsAvailabilityResponse.getInfoMsg()!=null && hotelsAvailabilityResponse.getInfoMsg().equalsIgnoreCase("R")){
				if(hotelsRequest!=null && hotelsRequest.getHotelOptions()!=null){
					hotelsRequest.getHotelOptions().setShowMore(true);
					hotelsRequest.getHotelOptions().setShowTierOne(false);
					hotelResponse = new HotelsResponse();
					hotelResponse=this.retrieveWesbHotels(hotelsRequest, hbsiHotelList);
					return hotelResponse;
				}
			}else if(hotelsAvailabilityResponse.getInfoMsg()!=null && hotelsAvailabilityResponse.getInfoMsg().equalsIgnoreCase("S")){
				if(hotelsRequest!=null && hotelsRequest.getHotelOptions()!=null)
					hotelsRequest.getHotelOptions().setInfoMessage(true);	
			}else{
				if(hotelsRequest!=null && hotelsRequest.getHotelOptions()!=null){
					hotelsRequest.getHotelOptions().setInfoMessage(false);
				}
			}
			if(hotelsRequest.getHotelOptions()!=null){
				if(hotelsRequest.getHotelOptions().isShowTierOne()&&!hotelsRequest.getHotelOptions().isInfoMessage()){
					hotelsRequest.getHotelOptions().setNoTierOne(true);
				}
				if(hotelsRequest.getHotelOptions().isShowAll()){
					isShowAll=true;
				}
			}
			
			if (hotelsAvailabilityResponse != null
					&& hotelsAvailabilityResponse.getBusinessError() != null
					&& hotelsAvailabilityResponse.getBusinessError().size() > 0
					&&((hotelsAvailabilityResponse.getHotelList()!=null && !(hotelsAvailabilityResponse.getHotelList().size()>0)) || (hotelsAvailabilityResponse.getHotelList()==null))) {
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
							
							//Set the hotel code as vendor code
							hotel.setHotelCode(hbsiHotelInfo.getHotelVendorCode());
							
							hotel.getDisplayRoomCategory().setRoomTypeCode(
									hbsiHotelInfo.getHotelMaterialId());
							if (hotel.getAppleRating() == null
									|| hotel.getAppleRating().equals(""))
								hotel.setAppleRating(hbsiHotelInfo
										.getAppleRating());
							if (hotel.getResortArea() == null) {
								ResortArea resortAreaBO = new ResortArea();
								resortAreaBO.setResortAreaCode(hbsiHotelInfo
										.getResortAreaName());
								resortAreaBO.setResortAreaName(hbsiHotelInfo
										.getResortAreaName());
								hotel.setResortArea(resortAreaBO);
								hotel.setHotelChain(hbsiHotelInfo.getResortAreaCode());
							}
						}
						hotel.setIsHBSi(true);
						hotelResponseList.add(hotel);

					} else {

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
			if (hotelsAvailabilityResponse.getDestinations() != null) {

				//for (int i = 0; i < hotelResponse.getDestinations().size(); i++) {
					for (int i = 0; i < hotelsAvailabilityResponse.getDestinations().size(); i++) {
					wesbHotelsresponse.getDestinations()
							.add(hotelsAvailabilityResponse.getDestinations()
									.get(i));
				}
			}
			

		} catch (RetrieveHotelsRetrieveHotelsFaultMsg e) {
			

		}
		
		catch (Exception e) {
			

		}
		
		if (wesbHotelsresponse != null) {

			hotelResponse = this.getHotelResponse(wesbHotelsresponse,isShowAll);

		}

		if (hotelResponse.isBusinessErrorOccurred()) {
			return hotelResponse;
		}

		return hotelResponse;
	}

	
	/**
	 * Method to retrieve the price break up of given hotel 
	 * 
	 * @param hotel
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public AllPriceBreakUpResponse retrievePriceBreakUp(Hotel hotel) {
		AllPriceBreakUpResponse response = new AllPriceBreakUpResponse();
			// Return business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL");
			/*businessError.setErrorDescription(this.getMessageSource()
					.getMessage("HBSI_HOTEL", null, null));*/
			businessError.setErrorDescription("Room prices are not available for HBSi hotel");
			
			//Room Prices are not available for HBSi hotels
			response.saveBusinessError(businessError);
			return response;
		
/*		HotelsPriceBreakUpRequest hotelPriceBreakUprequest = new HotelsPriceBreakUpRequest();
		HotelsPriceBreakUpResponse hotelPriceBrekUpResponse = null;
		if (hotel != null)
			hotelPriceBreakUprequest.setHotel(this.getHotelReq(hotel));

		try {
			hotelPriceBrekUpResponse = proxyService.getProxyService()
					.retrieveHotelPriceBreakUp(hotelPriceBreakUprequest);
		} catch (Exception e) {

		}
		if(hotelPriceBrekUpResponse.getBusinessError()!=null && hotelPriceBrekUpResponse.getBusinessError().size()>0)
		{

			
			List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

			for (int l = 0; l < hotelPriceBrekUpResponse
					.getBusinessError().size(); l++) {
				ABEBusinessError businessError = null;
				businessError = this
						.getABEBusinessError(hotelPriceBrekUpResponse
								.getBusinessError().get(l));
				if (businessError != null)
					businesserrorList.add(businessError);

			}

			if (businesserrorList != null && businesserrorList.size() > 0)
				response.saveBusinessErrors(businesserrorList);

			return response;

		
		}
		if (hotelPriceBrekUpResponse != null
				&& hotelPriceBrekUpResponse.getAllPricesBreakUp() != null) {
			response.setAllPricesBreakUp(this
					.getAllPriceBreakResponse(hotelPriceBrekUpResponse
							.getAllPricesBreakUp()));
		}

		return response;*/
	}

	
	/**
	 * Method to prepare HotelsAvailabilityRequest
	 * 
	 * @param hotelsRequest
	 * @return hotelsAvailabilityRequest
	 */
	private HotelsAvailabilityRequest getHotelsAvailabilityRequest(
			HotelsRequest hotelsRequest) {
		com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest hotelsAvailabilityRequest = new com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsavailabilityrequest.v1.HotelsAvailabilityRequest();

		if (hotelsRequest.getHotelOptions() != null) {
			hotelsAvailabilityRequest.setHotelOptions(
					this
					.getHotelOptionsReq(hotelsRequest.getHotelOptions()));
		}
		if (hotelsRequest.getSpecialOptions() != null) {
			hotelsAvailabilityRequest.setSpecialOptions(this
					.getSpecialOptionsReq(hotelsRequest.getSpecialOptions()));
		}

		hotelsAvailabilityRequest.setGateway(hotelsRequest.getGateway());
		hotelsAvailabilityRequest
				.setDestination(hotelsRequest.getDestination());

		if (hotelsRequest.getDepartureDate() != null) {
			hotelsAvailabilityRequest.setDepartureDate(this
					.getDate(hotelsRequest.getDepartureDate()));
		}
		hotelsAvailabilityRequest.setNoOfNights(hotelsRequest.getNoOfNights());
		hotelsAvailabilityRequest.setPromoCode(hotelsRequest.getPromoCode());
		hotelsAvailabilityRequest.setAirRequested(new Boolean(hotelsRequest
				.isAirRequested()));
		hotelsAvailabilityRequest.setHotelRequested(new Boolean(hotelsRequest
				.isHotelRequested()));
		hotelsAvailabilityRequest.setVehicleRequested(new Boolean(hotelsRequest
				.isVehicleRequested()));

		hotelsAvailabilityRequest.setMultiDestinationRequest(new Boolean(
				hotelsRequest.isMultiDestinationRequest()));
		hotelsAvailabilityRequest.setPackageRequest(new Boolean(hotelsRequest
				.isPackageRequest()));
		hotelsAvailabilityRequest.setBookingNo(hotelsRequest.getBookingNo());

		if (hotelsRequest.getOccupancy() != null) {
			hotelsAvailabilityRequest.setOccupancy(this
					.getOccupancyReq(hotelsRequest.getOccupancy()));
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
			HotelsAvailabilityResponse hotelsAvailabilityResponse, boolean isShowAll) {
		HotelsResponse hotelsResponse = new HotelsResponse();
		if ((hotelsAvailabilityResponse.getHotelList() != null)
				&& (hotelsAvailabilityResponse.getHotelList().size() > 0)) {
			List<Hotel> hotelList = new ArrayList<Hotel>();
			for (int i = 0; i < hotelsAvailabilityResponse.getHotelList()
					.size(); i++) {
				if (hotelsAvailabilityResponse.getHotelList().get(i) != null) {
					if(isShowAll ||
							(hotelsAvailabilityResponse.getHotelList().get(i).getDisplayRoomCategory()!=null
									&&hotelsAvailabilityResponse.getHotelList().get(i).getDisplayRoomCategory().
										getStatus().equalsIgnoreCase("O"))&&hotelsAvailabilityResponse.getHotelList().get(i).
										getDisplayRoomCategory().getNoOfRoomsAvailable()>0 ){
						hotelList.add(this.getHotel(hotelsAvailabilityResponse
							.getHotelList().get(i)));
					}else{
						naHotelList.add(this.getHotel(hotelsAvailabilityResponse
							.getHotelList().get(i)));
					}
				}
			}
			if(isShowAll){
				hotelList.addAll(naHotelList);
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