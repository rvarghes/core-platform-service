/*
 * ItinerarySAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 * Mar 22, 2010	 vgandrap	  Refactored this class name from ItineraryBookingSAPDaoImpl
 * 								after inclusion of generic methods for save itinerary & 
 * 								save itinerary changes.
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Service;

import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.logging.ABELogger;

import com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.deletedlist.v1.DeletedList;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsbookingresponse.v1.HotelsBookingResponse;
import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.CancelHotelBookingCancelHotelBookingFaultMsg;
import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.ModifyHotelBookingModifyHotelBookingFaultMsg;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagebookingrequest.v1.PackageBookingRequest;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagebookingresponse.v1.PackageBookingResponse;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.CancelPackageBookingCancelHotelBookingFaultMsg;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.ModifyPackageBookingModifyPackageBookingFaultMsg;
import com.kcdataservices.partners.www.kcdebsrvlib_hotel.businessobjects.hotelsbookingrequest.v1.HotelsBookingRequest;

/**
 * Itinerary Booking DAO implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryWESBDaoImpl extends ABESAPDaoBase implements
		ItineraryWESBDao {

	ABELogger bookingLogger = ABELogger.getLogger("bookings.log");

	private WesbProxyService proxyService;

	/**
	 * @param wesbProxyService
	 *            the wesbProxyService to set
	 */
	public void setProxyService(WesbProxyService wesbProxyService) {
		this.proxyService = wesbProxyService;
	}

	public ItineraryResponse saveWESBItinerary(Itinerary itinerary)
	{
		ItineraryResponse bookingResponse = new ItineraryResponse();
		ABEBusinessError businessError = new ABEBusinessError();
		businessError.setErrorCode("INVALID_HOTEL");
		/*businessError.setErrorDescription(this.getMessageSource()
				.getMessage("HBSI_QUOTE", null, null));*/
		businessError.setErrorDescription("Quote is not available for HBSi hotel");
		
		//Room Prices are not available for HBSi hotels
		bookingResponse.saveBusinessError(businessError);
		return bookingResponse;
	}
	
	/**
	 * Method to save specific changed itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveWESBItineraryChanges(Itinerary itinerary,
			boolean isHbsi,Map<String,HBSiHotelInfo> hbsiHotelList) {
		ItineraryResponse itineraryResponse = new ItineraryResponse();
		if (itinerary == null) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			itineraryResponse.saveBusinessError(businessError);
			return itineraryResponse;
		}

		HotelsBookingRequest hotelsBookingRequest = new HotelsBookingRequest();
		if (isHbsi == true)
			hotelsBookingRequest.setIsHBSi(true);
		

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = setHotelsRequestObject(itinerary);
		
		if(itinerary.getItineraryPrice()!=null)
		{
			itineraryClient.setItineraryPrice(this.getItineraryPriceReq(itinerary.getItineraryPrice()));
		}

		hotelsBookingRequest.setItinerary(itineraryClient);
		//set the header elements
		hotelsBookingRequest.setHotelRequested(true);
		hotelsBookingRequest.setPackageRequest(false);
		hotelsBookingRequest.setMultiDestinationRequest(false);
		hotelsBookingRequest.setVehicleRequested(false);
		hotelsBookingRequest.setAirRequested(false);
		
		if (hbsiHotelList != null
				&& hotelsBookingRequest != null
				&& hotelsBookingRequest.getItinerary().getHotels() != null
				&& hotelsBookingRequest.getItinerary().getHotels()
						.size() > 0)
		{
			for(int j=0;j<hotelsBookingRequest.getItinerary().getHotels().size();j++)
			{
				if(hbsiHotelList.containsKey(hotelsBookingRequest.getItinerary().getHotels().get(j).getHotelCode()))
				{
					hotelsBookingRequest.getItinerary().getHotels().get(j).setIsHBSi(true);
					hotelsBookingRequest.setIsHBSi(true);
				}
				else
				{
					hotelsBookingRequest.getItinerary().getHotels().get(j).setIsHBSi(false);
				}
			}
		}
		
		/*else if (itinerary.isBookingCancelled() == true
				&& hbsiHotelList != null
				&& hotelsBookingRequest != null
				&& hotelsBookingRequest.getItinerary().getDeletedList() != null
				&& hotelsBookingRequest.getItinerary().getDeletedList()
						.size() > 0)*/
		
// if (hbsiHotelList != null
//				&& hotelsBookingRequest != null
//				&& hotelsBookingRequest.getItinerary().getDeletedList() != null
//				&& hotelsBookingRequest.getItinerary().getDeletedList()
//						.size() > 0)
//		{
//			for(int k=0;k<hotelsBookingRequest.getItinerary().getDeletedList().size();k++)
//			{
//				if(hotelsBookingRequest.getItinerary().getDeletedList().get(k)!=null)
//				{
//					if (hotelsBookingRequest.getItinerary()
//							.getDeletedList().get(k).getHotelList() != null
//							&& hotelsBookingRequest.getItinerary()
//									.getDeletedList().get(k).getHotelList()
//									.size() > 0)
//							{
//							for(int h=0;h<hotelsBookingRequest.getItinerary().getDeletedList().get(k).getHotelList().size();h++)
//								{
//								if(hbsiHotelList.containsKey(hotelsBookingRequest.getItinerary().getDeletedList().get(k).getHotelList().get(h).getHotelCode()))
//								{
//									hotelsBookingRequest.getItinerary().getDeletedList().get(k).getHotelList().get(h).setIsHBSi(true);
//									hotelsBookingRequest.setIsHBSi(true);
//
//								}
//								else
//								{
//									hotelsBookingRequest.getItinerary().getDeletedList().get(k).getHotelList().get(h).setIsHBSi(false);
//								}
//								}
//							}
//				}
//			}
//		}
//
//		
	
		HotelsBookingResponse hotelsBookingResponse = null;
		try {
			if (itinerary.isBookingCancelled() == true) {
				DecimalFormat decimalFormat = new DecimalFormat("##.##");
				double price=0.0;
				if (hotelsBookingRequest.getItinerary().getHotels().size()>0 && hotelsBookingRequest.getItinerary().getHotels().get(0).getSelectedRooms().get(0).getPaxBasePrices()!=null){
				 price = hotelsBookingRequest.getItinerary().getHotels().get(0).getSelectedRooms().get(0).getPaxBasePrices().getAdultBasePrice();
				if (String.valueOf(price).contains("E")){
				 price = price/10000000000000000d;
				}
				price =Double.valueOf(decimalFormat.format(price));
								
				if (hotelsBookingRequest.getItinerary().getHotels().size()>0) {
				hotelsBookingRequest.getItinerary().getHotels().get(0).getSelectedRooms().get(0).getPaxBasePrices().setAdultBasePrice(price);
				price = hotelsBookingRequest.getItinerary().getHotels().get(0).getSelectedRooms().get(0).getPaxBasePrices().getChildBasePrice();
				if (String.valueOf(price).contains("E")){
				price = price/10000000000000000d;
				}
				price =Double.valueOf(decimalFormat.format(price));
				hotelsBookingRequest.getItinerary().getHotels().get(0).getSelectedRooms().get(0).getPaxBasePrices().setChildBasePrice(price);
				}
				}
				hotelsBookingResponse = proxyService.getProxyService()
						.cancelHotelBooking(hotelsBookingRequest);
				
			} else {

				hotelsBookingResponse = proxyService.getProxyService()
						.modifyHotelBooking(hotelsBookingRequest);
			}

		} catch (ModifyHotelBookingModifyHotelBookingFaultMsg e) {

		} catch (CancelHotelBookingCancelHotelBookingFaultMsg e) {

		} catch (Exception e) {

		}

		if (hotelsBookingResponse != null
				&& hotelsBookingResponse.getBusinessError() != null
				&& hotelsBookingResponse.getBusinessError().size() > 0) {

			List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

			for (int l = 0; l < hotelsBookingResponse
					.getBusinessError().size(); l++) {
				ABEBusinessError businessError = null;
				businessError = this
						.getABEBusinessError(hotelsBookingResponse
								.getBusinessError().get(l));
				if (businessError != null)
					businesserrorList.add(businessError);

			}

			if (businesserrorList != null && businesserrorList.size() > 0)
				itineraryResponse.saveBusinessErrors(businesserrorList);

			return itineraryResponse;

		}
		//Start the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
		 //Checking the System Error in the response
		if (hotelsBookingResponse != null
				&& hotelsBookingResponse.getSystemErrors() != null
				&& hotelsBookingResponse.getSystemErrors().size() > 0) {
			List<ABESystemError> systemErrorsList = new ArrayList<ABESystemError>();
			for (int l = 0; l < hotelsBookingResponse.getSystemErrors().size(); l++) {
				ABESystemError systemError = null;
				systemError = this.getABESystemError(hotelsBookingResponse
						.getSystemErrors().get(l));
				if (systemError != null)
					systemErrorsList.add(systemError);

			}

			if (systemErrorsList != null && systemErrorsList.size() > 0)
				itineraryResponse.saveSystemErrors(systemErrorsList);

			return itineraryResponse;

		}
		//End of the implemention of AV3749/HBsi 52 emergency tab information for passgenger enhancement
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryWESBResponse = hotelsBookingResponse
				.getItinerary();
		Itinerary itineraryDTO = getItinerary(itineraryWESBResponse);
		itineraryResponse.setItinerary(itineraryDTO);

		return itineraryResponse;

	}

	/**
	 * Method for setting List of Hotels Object
	 * 
	 * @param itinerary
	 * 
	 * @return itinerary
	 */

	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary getPackageRequestBO(
			Itinerary itinerary, List<Hotel> hbsiHotelsList) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();

		if (itinerary.isBookingCancelled()) {
			itineraryClient.setBookingCancelled(true);
		}
		// set the Booking number
		itineraryClient.setBookingNo(itinerary.getBookingNo());
		itineraryClient.setIsReserve(itinerary.isReserve());
		itineraryClient.setIsModify(itinerary.isModify());
		itineraryClient.setIsNoChange(itinerary.isNoChange());
		if (hbsiHotelsList != null) {
			for (int i = 0; i < hbsiHotelsList.size(); i++) {
				if (hbsiHotelsList.get(i) != null) {
					itineraryClient.getHotels().add(i,
							this.getHotelReq(hbsiHotelsList.get(i)));
				}
			}
		}

		if (itinerary.getGuests() != null) {
			for (int i = 0; i < itinerary.getGuests().size(); i++) {
				itineraryClient.getGuests().add(i,
						this.getGuestInfoReq(itinerary.getGuests().get(i)));
			}
		}

		if (itinerary.getImApplicationInfo() != null) {
			itineraryClient.setImApplicationInfo(this
					.getImApplicationInfoReq(itinerary.getImApplicationInfo()));
		}
		if (itinerary.getBookingHeader() != null) {
			itineraryClient.setBookingHeader(this.getBookingHeaderReq(itinerary
					.getBookingHeader()));
		}
		
		if (itinerary.getDeletedList() != null) {

			List<DeletedList> deletedList = new ArrayList<DeletedList>();
			DeletedList deletedListBO = new DeletedList();
			for (int i = 0; i < itinerary.getDeletedList().size(); i++) {

				if (itinerary.getDeletedList() != null) {
					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Hotel) {

						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));

						if (hotelListBO != null && hotelListBO.size() > 0) {
							for (int j = 0; j < hotelListBO.size(); j++) {
								deletedListBO.getHotelList().add(j,
										hotelListBO.get(j));
							}
						}

					}
					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Service) {
						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service> serviceListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));

						if (serviceListBO != null && serviceListBO.size() > 0) {
							for (int j = 0; j < serviceListBO.size(); j++) {
								deletedListBO.getServiceList().add(j,
										serviceListBO.get(j));
							}
						}
					}

					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Insurance) {
						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance> insuranceListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));
						if (insuranceListBO != null
								&& insuranceListBO.size() > 0) {
							for (int j = 0; j < insuranceListBO.size(); j++) {
								deletedListBO.getInsuranceList().add(j,
										insuranceListBO.get(j));
							}
						}
					}

				}

			}

			if (deletedListBO != null) {
				itineraryClient.getDeletedList().add(deletedListBO);
			}
		}

		return itineraryClient;
	}

	/**
	 * Method for setting List of Hotels Object
	 * 
	 * @param itinerary
	 * 
	 * @return itinerary
	 */

	private com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary setHotelsRequestObject(
			Itinerary itinerary) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();

		if (itinerary.isBookingCancelled()) {
			itineraryClient.setBookingCancelled(true);
		}
		// set the Booking number
		itineraryClient.setBookingNo(itinerary.getBookingNo());
		itineraryClient.setAllowBPG(itinerary.isAllowBPG());
		if (itinerary.getHotels() != null) {
			for (int i = 0; i < itinerary.getHotels().size(); i++) {
				if (itinerary.getHotels().get(i) != null) {
					itineraryClient.getHotels().add(i,
							this.getHotelReq(itinerary.getHotels().get(i)));
				}
			}
		}
		if (itinerary.getInsurances() != null) {
			for (int i = 0; i < itinerary.getInsurances().size(); i++) {
				itineraryClient.getInsurances().add(i,
						this.getInsuranceReq(itinerary.getInsurances().get(i)));
			}
		}
		if (itinerary.getGuests() != null) {
			for (int i = 0; i < itinerary.getGuests().size(); i++) {
				itineraryClient.getGuests().add(i,
						this.getGuestInfoReq(itinerary.getGuests().get(i)));
			}
		}
		if (itinerary.getServices() != null) {
			for (int i = 0; i < itinerary.getServices().size(); i++) {
				itineraryClient.getServices().add(i,
						this.getServiceReq(itinerary.getServices().get(i)));
			}
		}
		if (itinerary.getTransferInfo() != null) {
			itineraryClient.setTransferInfo(this.getOpsAlertReq(itinerary
					.getTransferInfo()));
		}
		if (itinerary.getImApplicationInfo() != null) {
			itineraryClient.setImApplicationInfo(this
					.getImApplicationInfoReq(itinerary.getImApplicationInfo()));
		}
		if (itinerary.getRfaRequest() != null) {
			itineraryClient.setRfaRequest(this.getRFARequestReq(itinerary
					.getRfaRequest()));
		}

		if (itinerary.getBookingHeader() != null) {
			itineraryClient.setBookingHeader(this.getBookingHeaderReq(itinerary
					.getBookingHeader()));
		}

		if (itinerary.getDeletedList() != null) {

			List<DeletedList> deletedList = new ArrayList<DeletedList>();
			DeletedList deletedListBO = new DeletedList();
			for (int i = 0; i < itinerary.getDeletedList().size(); i++) {

				if (itinerary.getDeletedList() != null) {
					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Hotel) {

						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel> hotelListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.hotel.v1.Hotel>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));

						if (hotelListBO != null && hotelListBO.size() > 0) {
							for (int j = 0; j < hotelListBO.size(); j++) {
								deletedListBO.getHotelList().add(j,
										hotelListBO.get(j));
							}
						}

					}
					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Service) {
						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service> serviceListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.service.v1.Service>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));

						if (serviceListBO != null && serviceListBO.size() > 0) {
							for (int j = 0; j < serviceListBO.size(); j++) {
								deletedListBO.getServiceList().add(j,
										serviceListBO.get(j));
							}
						}
					}

					if (itinerary.getDeletedList().get(i) != null
							&& itinerary.getDeletedList().get(i) instanceof Insurance) {
						List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance> insuranceListBO = (List<com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.insurance.v1.Insurance>) this
								.getDeletedObject(itinerary.getDeletedList()
										.get(i));
						if (insuranceListBO != null
								&& insuranceListBO.size() > 0) {
							for (int j = 0; j < insuranceListBO.size(); j++) {
								deletedListBO.getInsuranceList().add(j,
										insuranceListBO.get(j));
							}
						}
					}

				}

			}

			if (deletedListBO != null) {
				itineraryClient.getDeletedList().add(deletedListBO);
			}
			
			//set the booking lock details
			if(itinerary.getBookingLockDetails()!=null)
			{
				itineraryClient.setBookingLockDetails(this.getBookingLockDetailsReq(itinerary.getBookingLockDetails()));
			}

		}

		return itineraryClient;
	}

	/**
	 * Method to save specific changed itinerary for Package
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveWESBPackageItineraryChanges(
			Itinerary itinerary, List<Hotel> hbsiHotelList,
			String bookingnumberSAP) {
		ItineraryResponse itineraryResponse = new ItineraryResponse();
		if (itinerary == null) {
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			itineraryResponse.saveBusinessError(businessError);
			return itineraryResponse;
		}

		PackageBookingRequest packageBookingRequest = new PackageBookingRequest();

		packageBookingRequest.setIsHBSi(true);

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryClient = getPackageRequestBO(
				itinerary, hbsiHotelList);
		itineraryClient.setBookingNo(bookingnumberSAP);
		
		if(itinerary.getItineraryPrice()!=null)
		{
			itineraryClient.setItineraryPrice(this.getItineraryPriceReq(itinerary.getItineraryPrice()));
		}
		//Setting the isHbsi flag to true inside Hotel Object
		
		for(int i=0;i<itineraryClient.getHotels().size();i++)
		{
			itineraryClient.getHotels().get(i).setIsHBSi(true);
		}
		
		if((itinerary.getPackages()!=null && itinerary.getPackages().size()>0) || (itinerary.getFlights() != null && itinerary.getFlights().size() > 0))
		 {
			packageBookingRequest.setPackageRequest(true);
		}
		else
		{
			packageBookingRequest.setMultiDestinationRequest(true);
		}

		
		packageBookingRequest.setItinerary(itineraryClient);

		PackageBookingResponse packageBookingResponse = null;
		try {
			if (itinerary.isBookingCancelled() == true) {
				packageBookingResponse = proxyService.getPackageProxyService()
						.cancelPackageBooking(packageBookingRequest);
			} else {
				packageBookingResponse = proxyService.getPackageProxyService()
						.modifyPackageBooking(packageBookingRequest);
			}

		} catch (ModifyPackageBookingModifyPackageBookingFaultMsg e) {

		} catch (CancelPackageBookingCancelHotelBookingFaultMsg e) {

		}

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryWESBResponse = packageBookingResponse
				.getItinerary();
		Itinerary itineraryDTO = getItinerary(itineraryWESBResponse);
		itineraryResponse.setItinerary(itineraryDTO);
		return itineraryResponse;
	}
}
