package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.WesbProxyService;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.util.WesbConvertBOFromDTOUtil;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdataservices.partners.kcdebsrvlib_hotel.businessobjects.hotelsbookingresponse.v1.HotelsBookingResponse;
import com.kcdataservices.partners.kcdebsrvlib_hotel.interfaces.hotelservicebs.v1.BookHotelItineraryBookHotelItineraryFaultMsg;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagebookingrequest.v1.PackageBookingRequest;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packagebookingresponse.v1.PackageBookingResponse;
import com.kcdataservices.partners.kcdebsrvlib_package.interfaces.packageservicebs.v1.BookPackageItineraryBookPackageItineraryFaultMsg;
import com.kcdataservices.partners.www.kcdebsrvlib_hotel.businessobjects.hotelsbookingrequest.v1.HotelsBookingRequest;

public class WesbBookingDaoImpl extends ABESAPDaoBase implements WesbBookingDao {

	WesbProxyService proxyService;

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
	 * Method to prepare itinerary BO for Hotel Only Booking
	 * 
	 * @param itinerary
	 * @return itineraryBO
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary getHotelOnlyItineraryBO(
			Itinerary itinerary) {

		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();

		// Prepare List Of Hotels BO
		if (itinerary.getHotels() != null) {
			for (int i = 0; i < itinerary.getHotels().size(); i++) {
				if (itinerary.getHotels().get(i) != null) {
					itineraryBO.getHotels().add(i,
							this.getHotelReq(itinerary.getHotels().get(i)));

					// itineraryBO.getHotels().add(i,
					// this.getHotelReq(itinerary.getHotels().get(i)));
				}

			}
		}

		// Prepare List of GuestInfo BO
		if (itinerary.getGuests() != null) {
			for (int i = 0; i < itinerary.getGuests().size(); i++) {
				if (itinerary.getGuests().get(i) != null) {
					itineraryBO.getGuests().add(
							i,
							WesbConvertBOFromDTOUtil.getGuestInfoBO(itinerary
									.getGuests().get(i)));

					// itineraryBO.getGuests().add(i,
					// this.getGuestInfoReq(itinerary.getGuests().get(i)));
				}

			}
		}

		// Prepare IMApplicationInfo BO
		itineraryBO.setImApplicationInfo(this.getImApplicationInfoReq(this
				.getIMApplicationInfo()));

		// Prepare list of Services BO
		if (itinerary.getServices() != null
				&& itinerary.getServices().size() > 0) {
			for (int i = 0; i < itinerary.getServices().size(); i++) {
				if (itinerary.getServices().get(i) != null) {
					itineraryBO.getServices().add(i,
							this.getServiceReq(itinerary.getServices().get(i)));

					// itineraryBO.getServices().add(i,
					// this.getServiceReq(itinerary.getServices().get(i)));
				}
			}
		}

		// Prepare list of insurance

		if ((itinerary.getInsurances() != null)
				&& (itinerary.getInsurances().size() > 0)) {
			for (int i = 0; i < itinerary.getInsurances().size(); i++) {
				itineraryBO.getInsurances().add(
						this.getInsuranceReq(itinerary.getInsurances().get(i)));
			}
		}

		// Prepare TransferInfo BO
		if (itinerary.getTransferInfo() != null) {
			itineraryBO.setTransferInfo(this.getOpsAlertReq(itinerary
					.getTransferInfo()));
		}

		return itineraryBO;
	}

	/**
	 * Method to prepare itinerary Request Object for package booking
	 * 
	 * @param itinerary
	 * @return itineraryPackageBO
	 */
	public com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary getPackageItineraryBO(
			Itinerary itinerary, List<Hotel> hbsiHotelList)

	{
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itineraryPackageBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();
		// Prepare List Of Hotels BO
		if (hbsiHotelList != null) {
			for (int i = 0; i < hbsiHotelList.size(); i++) {

				itineraryPackageBO.getHotels().add(i,
						this.getHotelReq(hbsiHotelList.get(i)));

			}
		}

		// Prepare List of GuestInfo BO
		if (itinerary.getGuests() != null) {
			for (int i = 0; i < itinerary.getGuests().size(); i++) {
				if (itinerary.getGuests().get(i) != null) {
					itineraryPackageBO.getGuests().add(
							i,
							WesbConvertBOFromDTOUtil.getGuestInfoBO(itinerary
									.getGuests().get(i)));
				}

			}
		}

		// Prepare IMApplicationInfo BO
		itineraryPackageBO.setImApplicationInfo(this
				.getImApplicationInfoReq(this.getIMApplicationInfo()));

		return itineraryPackageBO;
	}

	/**
	 * Method to get the booking number
	 * 
	 * @param itinerary
	 * @return bookingNumber
	 */
	public String getBookingNumberFromBO(
			com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary itinerary) {
		String bookingNumber = "";
		if (itinerary != null) {
			bookingNumber = itinerary.getBookingNo();
		}
		return bookingNumber;
	}

	/**
	 * Hotel Only Booking
	 * 
	 * @param itinerary
	 * @return ItineraryResponse
	 */

	public ItineraryResponse bookHotelItinerary(Itinerary itinerary,
			boolean isHBSi, Map<String, HBSiHotelInfo> hbsiHotelList) {
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary hotelItineraryBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();
		hotelItineraryBO = getHotelOnlyItineraryBO(itinerary);

		HotelsBookingRequest hotelBookingRequet = new HotelsBookingRequest();
		HotelsBookingResponse hotelBookingResponse = new HotelsBookingResponse();

		ItineraryResponse itineraryResponse = new ItineraryResponse();

		/*
		 * if (isHBSi == true) hotelBookingRequet.setIsHBSi(true);
		 */

		if (itinerary.getItineraryPrice() != null) {
			hotelItineraryBO.setItineraryPrice(this
					.getItineraryPriceReq(itinerary.getItineraryPrice()));
		}

		hotelBookingRequet.setItinerary(hotelItineraryBO);

		if (hbsiHotelList != null && hotelBookingRequet != null
				&& hotelBookingRequet.getItinerary().getHotels() != null
				&& hotelBookingRequet.getItinerary().getHotels().size() > 0) {
			for (int j = 0; j < hotelBookingRequet.getItinerary().getHotels()
					.size(); j++) {
				if (hbsiHotelList.containsKey(hotelBookingRequet.getItinerary()
						.getHotels().get(j).getHotelCode())) {
					hotelBookingRequet.getItinerary().getHotels().get(j)
							.setIsHBSi(true);
					hotelBookingRequet.setIsHBSi(true);
				} else {
					hotelBookingRequet.getItinerary().getHotels().get(j)
							.setIsHBSi(false);
				}
			}
		}

		// set the header elements
		hotelBookingRequet.setHotelRequested(true);
		hotelBookingRequet.setPackageRequest(false);
		hotelBookingRequet.setAirRequested(false);
		hotelBookingRequet.setVehicleRequested(false);
		hotelBookingRequet.setMultiDestinationRequest(false);
		if( null!=itinerary.getSearchCriteria() && itinerary.getSearchCriteria().getPromoCode() != null)
			hotelBookingRequet.setPromoCode(itinerary.getSearchCriteria().getPromoCode());
		try {

			hotelBookingResponse = proxyService.getProxyService()
					.bookHotelItinerary(hotelBookingRequet);

		} catch (BookHotelItineraryBookHotelItineraryFaultMsg e) {

		}
			if (hotelBookingResponse != null
				&& hotelBookingResponse.getBusinessError() != null
				&& hotelBookingResponse.getBusinessError().size() > 0) {

				List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

				for (int l = 0; l < hotelBookingResponse.getBusinessError()
						.size(); l++) {
					ABEBusinessError businessError = null;
					businessError = this
							.getABEBusinessError(hotelBookingResponse
									.getBusinessError().get(l));
					if (businessError != null)
						businesserrorList.add(businessError);

				}

				if (businesserrorList != null && businesserrorList.size() > 0)
					itineraryResponse.saveBusinessErrors(businesserrorList);
			}
			// Checking the System Error(s)
			else if (hotelBookingResponse.getSystemErrors() != null
					&& hotelBookingResponse.getSystemErrors().size() > 0) {

				List<ABESystemError> systemErrorList = new ArrayList<ABESystemError>();
				for (int l = 0; l < hotelBookingResponse.getSystemErrors()
						.size(); l++) {
					ABESystemError systemError = null;
					systemError = this.getABESystemError(hotelBookingResponse
							.getSystemErrors().get(l));
					if (systemError != null)
						systemErrorList.add(systemError);

				}

				if (systemErrorList != null && systemErrorList.size() > 0)
					itineraryResponse.saveSystemErrors(systemErrorList);
			}
			// Composing/Process the response object into predefined format
			else {
				if (hotelBookingResponse.getItinerary() != null) {
					// Request and response are same except Response adds
					// Booking
					// number
					// and allowBPG

					itinerary
							.setBookingNo(getBookingNumberFromBO(hotelBookingResponse
									.getItinerary()));

					if (hotelBookingResponse.getItinerary().isAllowEdocs()) {
						itinerary.setAllowEdocs(true);

					}

					/*
					 * Itinerary bookingResponseItinerary =
					 * this.getItinerary(hotelBookingResponse.getItinerary());
					 */
					itineraryResponse.setItinerary(itinerary);

				}
			}
			// End HBSI -8 Phase -1 fix
		
		return itineraryResponse;
	}

	/**
	 * Method to handle booking for Package
	 * 
	 * @param itinerary
	 * @param bookingNumberSAP
	 * @return itineraryPackageResponse
	 * 
	 * 
	 */
	public ItineraryResponse bookPackageItinerary(Itinerary itinerary,
			List<Hotel> hbsiHotelList, String bookingNumberSAP) {
		PackageBookingRequest packageBookingRequest = new PackageBookingRequest();
		PackageBookingResponse packageBookingResponse = new PackageBookingResponse();
		// Itinerary itineraryDTO = new Itinerary();
		ItineraryResponse itineraryPackageResponse = new ItineraryResponse();
		com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary packageItineraryBO = new com.kcdataservices.partners.kcdebdmnlib_hva.businessobjects.itinerary.v1.Itinerary();
		packageItineraryBO = getPackageItineraryBO(itinerary, hbsiHotelList);

		// set the itineraryPrice

		if (itinerary.getItineraryPrice() != null) {
			packageItineraryBO.setItineraryPrice(this
					.getItineraryPriceReq(itinerary.getItineraryPrice()));
		}

		packageItineraryBO.setBookingNo(bookingNumberSAP);
		packageBookingRequest.setItinerary(packageItineraryBO);

		// set the is HBSi to true as this method will be called only when user
		// requests for HBSi hotels

		packageBookingRequest.setIsHBSi(true);

		if (packageBookingRequest != null
				&& packageBookingRequest.getItinerary() != null
				&& packageBookingRequest.getItinerary().getHotels() != null) {
			for (int hbsi = 0; hbsi < packageBookingRequest.getItinerary()
					.getHotels().size(); hbsi++) {
				packageBookingRequest.getItinerary().getHotels().get(hbsi)
						.setIsHBSi(true);
			}

		}

		// set the header elements
		if ((itinerary.getPackages() != null && itinerary.getPackages().size() > 0)
				|| (itinerary.getFlights() != null && itinerary.getFlights()
						.size() > 0)) {
			packageBookingRequest.setPackageRequest(true);
		} else {
			packageBookingRequest.setMultiDestinationRequest(true);
		}

		try {

			packageBookingResponse = proxyService.getPackageProxyService()
					.bookPackageItinerary(packageBookingRequest);

		} catch (BookPackageItineraryBookPackageItineraryFaultMsg e) {

		}

		//Start the fix of HBSI 8 Phase 1 fix
		//Checking the response object : NULL/NOT NULL
		if (packageBookingResponse != null) {
			//Checking the business Error(s) in response object
			if (packageBookingResponse.getBusinessError() != null
					&& packageBookingResponse.getBusinessError().size() > 0) {

				List<ABEBusinessError> businesserrorList = new ArrayList<ABEBusinessError>();

				for (int l = 0; l < packageBookingResponse.getBusinessError()
						.size(); l++) {
					ABEBusinessError businessError = null;
					businessError = this
							.getABEBusinessError(packageBookingResponse
									.getBusinessError().get(l));
					if (businessError != null)
						businesserrorList.add(businessError);

				}

				if (businesserrorList != null && businesserrorList.size() > 0)
					itineraryPackageResponse
							.saveBusinessErrors(businesserrorList);

			}
			//Checking the System Error(s) in response object
			else if (packageBookingResponse.getSystemErrors() != null
					&& packageBookingResponse.getSystemErrors().size() > 0) {

				List<ABESystemError> systemErrorList = new ArrayList<ABESystemError>();

				for (int l = 0; l < packageBookingResponse.getSystemErrors()
						.size(); l++) {
					ABESystemError systemError = null;
					systemError = this.getABESystemError(packageBookingResponse
							.getSystemErrors().get(l));
					if (systemError != null)
						systemErrorList.add(systemError);

				}

				if (systemErrorList != null && systemErrorList.size() > 0)
					itineraryPackageResponse.saveSystemErrors(systemErrorList);

			}
			//Normal flow after checked Business and System Error(s)
			//execute when both Business and System Error(s) are null.
			else {
				// Request and Response are same except Booking number and
				// allowBPG
				String bookingNumber = getBookingNumberFromBO(packageBookingResponse
						.getItinerary());
				itinerary.setBookingNo(bookingNumber);
				if (packageBookingResponse.getItinerary().isAllowEdocs()) {
					itinerary.setAllowEdocs(true);
				}
				itineraryPackageResponse.setItinerary(itinerary);
			}
		}
		//End of HBSI 8 Phase 1 fix
		return itineraryPackageResponse;
	}

}
