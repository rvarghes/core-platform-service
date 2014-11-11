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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Input;
import com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType;
import com.kcdata.abe.bapi.Yst_Bapi_Ins_ReqType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.business.response.InsuranceResponse;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.InsuranceConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * Itinerary Insurance DAO implementation class
 * 
 * @author dmahanth
 * @version
 * 
 * @see
 * @since
 */
public class InsuranceSAPDaoImpl extends ABESAPDaoBase implements InsuranceDao {

	/**
	 * Instance of Logger
	 */
	final ABELogger logger = ABELogger.getLogger(com.kcdata.abe.data.dao.InsuranceSAPDaoImpl.class);
	
	
	/**
	 * Method to get the available insurance options
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public InsuranceResponse retrieveInsurance(Itinerary itinerary) {

		InsuranceResponse insuranceResponse = new InsuranceResponse();

		// Create Input for BAPI
		Y_Bapi_Insurance_Availability_Input bapiInput = new Y_Bapi_Insurance_Availability_Input();

		byte itemRPH = 0;

		// Flights Input for Insurance
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemRPH);
		}

		// Hotels Input for Insurance
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemRPH);
		}

		// Packages input for Insurance
		if (itinerary.getPackages() != null) {
			this.preparePackagesInput(itinerary.getPackages(), bapiInput,
					itemRPH);
		}

		// multi-destination packages input for Insurance
		if (itinerary.getMultiDestinationPackages() != null) {
			this.prepareMultiDestPackagesInput(itinerary
					.getMultiDestinationPackages(), bapiInput, itemRPH);
		}

		// Guests input for Insurance
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Set IMApplication info
		bapiInput.setIm_Application_Info(prepareLocalIMApplicationInfo(itinerary.getImApplicationInfo()));

		// Set insurance request info
		bapiInput.setIm_Bapi_Ins_Req(this
				.prepareInsuranceRequestType(itinerary));

		// Execute the BAPI
		Y_Bapi_Insurance_Availability_Output bapiOutput = (Y_Bapi_Insurance_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Insurance_Availability", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				insuranceResponse);
		// Check for any business errors from BAPI
		if (insuranceResponse.isBusinessErrorOccurred()) {
			return insuranceResponse;
		}

		// Prepare insurance options
		Yst_Bapi_Ins_AvailabilityType_List insuranceAvailList = bapiOutput
				.get_as_listIt_Ins_Avail();

		if (insuranceAvailList != null && !insuranceAvailList.isEmpty()) {
			// Set insurance options to response
			insuranceResponse.setInsuranceGroupList(InsuranceConvertUtils
					.processInsuranceResponse(bapiOutput, itinerary
							.getSearchCriteria()));
		} else {
			// Unable to retrieve insurance information
			logger.warn("Unable to retrieve insurance for Itineary [ "+itinerary.toString()+" ]");
			
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_INSURANCE_AVAILABILITY_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_INSURANCE_AVAILABILITY_ERROR", null,
							null));
			insuranceResponse.saveBusinessError(businessError);
		}

		return insuranceResponse;
	}

	/**
	 * Method to process the Itinerary and prepare the flights structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private byte prepareFlightsInput(List<TripFlight> flights,
			Y_Bapi_Insurance_Availability_Input bapiInput, byte itemRPH) {
		Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput
				.get_as_listIt_Flt_Items();
		Yst_Ota_Flt_SegmentsType_List segmentsList = bapiInput
				.get_as_listIt_Flt_Segments();
		if (flightItemsList == null) {
			flightItemsList = new Yst_Ota_Flt_ItemsType_List();
			segmentsList = new Yst_Ota_Flt_SegmentsType_List();
		}
		for (TripFlight tripFlight : flights) {
			// Process the Flight Item
			++itemRPH;
			flightItemsList.add(FlightConvertUtils.prepareFlightItemTypeList(
					tripFlight, itemRPH));
			// Process the segment details
			segmentsList.addAll(FlightConvertUtils.prepareFltSegmentsTypeList(
					tripFlight, itemRPH));
		}
		bapiInput.setIt_Flt_Items(flightItemsList);
		bapiInput.setIt_Flt_Segments(segmentsList);
		return itemRPH;
	}

	/**
	 * Method to process the Itinerary and prepare the hotels structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private byte prepareHotelsInput(List<Hotel> hotels,
			Y_Bapi_Insurance_Availability_Input bapiInput, byte itemRPH) {
		Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput
				.get_as_listIt_Htl_Items();
		if (itemsTypeList == null) {
			itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
		}
		for (Hotel hotel : hotels) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
					.prepareHotelItemTypeList(hotel, itemRPH, null,false);
			if (hotelItemsList != null) {
				itemsTypeList.addAll(hotelItemsList);
				itemRPH += hotelItemsList.size();
			}
		}
		bapiInput.setIt_Htl_Items(itemsTypeList);
		return itemRPH;
	}

	/**
	 * Method to process the packages to prepare all packages structures
	 * 
	 * @param packages
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private byte preparePackagesInput(List<Package> packages,
			Y_Bapi_Insurance_Availability_Input bapiInput, byte itemRPH) {
		for (Package availablePackage : packages) {
			byte flightRPH = 0;
			if (availablePackage.getSelectedFlight() != null) {
				Yst_Ota_Flt_ItemsType_List flightItemsList = bapiInput
						.get_as_listIt_Flt_Items();
				Yst_Ota_Flt_SegmentsType_List segmentsList = bapiInput
						.get_as_listIt_Flt_Segments();
				if (flightItemsList == null) {
					flightItemsList = new Yst_Ota_Flt_ItemsType_List();
					segmentsList = new Yst_Ota_Flt_SegmentsType_List();
				}
				TripFlight tripFlight = availablePackage.getSelectedFlight();

				flightItemsList.add(FlightConvertUtils
						.prepareFlightItemTypeList(tripFlight, ++itemRPH));
				// Process the segment details
				segmentsList.addAll(FlightConvertUtils
						.prepareFltSegmentsTypeList(tripFlight, itemRPH));
				bapiInput.setIt_Flt_Items(flightItemsList);
				bapiInput.setIt_Flt_Segments(segmentsList);
				flightRPH = itemRPH;
			}

			if (availablePackage.getSelectedHotel() != null) {
				Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput
						.get_as_listIt_Htl_Items();
				if (itemsTypeList == null) {
					itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
				}
				Hotel hotel = availablePackage.getSelectedHotel();
				Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
						.prepareHotelItemTypeList(hotel, itemRPH, null,false);
				if (hotelItemsList != null) {
					if (flightRPH != 0) {
						Iterator<Yst_Ota_Htl_ItemsType> hotelIterator = hotelItemsList
								.iterator();
						while (hotelIterator.hasNext()) {
							Yst_Ota_Htl_ItemsType hotelItemType = hotelIterator
									.next();
							hotelItemType.setFlt_Item_Rph("" + flightRPH);
						}
					}
					itemsTypeList.addAll(hotelItemsList);
					itemRPH += hotelItemsList.size();
				}
				bapiInput.setIt_Htl_Items(itemsTypeList);
			}
		}
		return itemRPH;
	}

	/**
	 * Method to process the multidestination packages to prepare all packages
	 * structures
	 * 
	 * @param packages
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareMultiDestPackagesInput(
			List<MultiDestinationPackage> multiDestPkgs,
			Y_Bapi_Insurance_Availability_Input bapiInput, byte itemRPH) {

		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			// Flights Input for Insurance availability
			if (multiDestPkg.getSelectedFlights() != null) {
				itemRPH = this.prepareFlightsInput(multiDestPkg
						.getSelectedFlights(), bapiInput, itemRPH);
			}

			// Hotels Input for Insurance availability
			if (multiDestPkg.getSelectedHotels() != null) {
				itemRPH = this.prepareHotelsInput(multiDestPkg
						.getSelectedHotels(), bapiInput, itemRPH);
			}
		}
		return itemRPH;
	}

	/**
	 * Method to prepare the Insurance request
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Yst_Bapi_Ins_ReqType prepareInsuranceRequestType(Itinerary itinerary) {
		Yst_Bapi_Ins_ReqType insuranceReqType = new Yst_Bapi_Ins_ReqType();
		if (itinerary.getSearchCriteria() != null
				&& itinerary.getSearchCriteria().getDepartureDate() != null) {
			SearchCriteria searchCriteria = itinerary.getSearchCriteria();
			insuranceReqType.setDest_Locid(searchCriteria
					.getTripReturnLocation());
			if (searchCriteria.getDepartureDate() != null) {
				insuranceReqType.setDep_Date(new java.sql.Date(searchCriteria
						.getDepartureDate().getTime()));
			}
			Date returnDate = searchCriteria.getTripReturnDate();
			if (returnDate != null) {
				insuranceReqType.setRet_Date(new java.sql.Date(returnDate
						.getTime()));
			}
			populateOccupancyInRequest(searchCriteria.getOccupancy(),
					insuranceReqType);
		} else {
			// Determine the Departure and return dates from Itinerary
			prepareInsuranceRequestDetails(itinerary, insuranceReqType);
		}
		if (itinerary.getBookingNo() != null) {
			insuranceReqType.setBooking_Num(itinerary.getBookingNo());
		}
		return insuranceReqType;
	}

	/**
	 * Method to populate occupancy in Insurance request
	 * 
	 * @param occupancy
	 * @param insuranceReqType
	 * 
	 * @see
	 * @since
	 */
	private void populateOccupancyInRequest(Occupancy occupancy,
			Yst_Bapi_Ins_ReqType insuranceReqType) {
		if (occupancy != null) {
			insuranceReqType.setNo_Adults(occupancy.getNoOfAdults());
			insuranceReqType.setNo_Child(occupancy.getNoOfChilds() + "");
			insuranceReqType.setNo_Infants(occupancy.getNoOfInfants() + "");
			insuranceReqType.setNo_Lapchild(occupancy.getNoOfLapChilds() + "");
			insuranceReqType.setNo_Seniors(occupancy.getNoOfSeniors() + "");
			if (occupancy.getNoOfChilds() > 0) {
				this.setChildAges(insuranceReqType, occupancy.getPassengers());
			}
		}
	}

	/**
	 * Private method to set the child ages to Insurance Request
	 * 
	 * @param airRequest
	 * @param passList
	 * 
	 * @see
	 * @since
	 */
	private void setChildAges(Yst_Bapi_Ins_ReqType insuranceRequest,
			List<Passenger> passList) {
		byte childCount = 0;
		for (Passenger passenger : passList) {
			if (passenger.getAgeCode().isChild()) {
				childCount++;
				switch (childCount) {
				case 1:
					insuranceRequest.setChild1_Age(passenger.getAge() + "");
					break;
				case 2:
					insuranceRequest.setChild2_Age(passenger.getAge() + "");
					break;
				case 3:
					insuranceRequest.setChild3_Age(passenger.getAge() + "");
					break;
				case 4:
					insuranceRequest.setChild4_Age(passenger.getAge() + "");
					break;
				case 5:
					insuranceRequest.setChild5_Age(passenger.getAge() + "");
					break;
				case 6:
					insuranceRequest.setChild6_Age(passenger.getAge() + "");
					break;
				}
			}
		}
	}

	/**
	 * Method to process the Itinerary and prepare the GuestInfo structures
	 * 
	 * @param itinerary
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareGuestsInput(List<GuestInfo> guests,
			Y_Bapi_Insurance_Availability_Input bapiInput) {
		ArrayList<GuestInfo> filteredList = new ArrayList<GuestInfo>();
		for (GuestInfo guestDetails : guests) {
			if ("CANC".equals(guestDetails.getStatus())
					|| "EXP".equals(guestDetails.getStatus())
					|| "D".equals(guestDetails.getChangeType())) {
				continue;
			}
			filteredList.add(guestDetails);
		}
		Yst_Ota_GuestinfoType_List guestInfoList = GuestInfoConvertUtil
				.prepareGuestInfoTypeList(filteredList);
		if (guestInfoList != null) {
			bapiInput.setIt_Guestinfo(guestInfoList);
		}
	}

	/**
	 * Method to prepare and set the Insurance request details
	 * 
	 * 
	 * @param itinerary
	 * @param reqType
	 * 
	 * @see
	 * @since
	 */
	private void prepareInsuranceRequestDetails(Itinerary itinerary,
			Yst_Bapi_Ins_ReqType reqType) {
		// default date is 2 years from now
		Date departureDate = new Date(new Date().getTime()
				+ (2 * 365 * 24 * 60 * 60 * 1000L));
		Date returnDate = new Date();
		Occupancy occupancy = null;
		InsuranceCriteria insuranceCriteria = new InsuranceCriteria(
				departureDate, returnDate, occupancy);
		if (itinerary.getMultiDestinationPackages() != null) {
			for (MultiDestinationPackage multiDestinationPackage : itinerary
					.getMultiDestinationPackages()) {
				insuranceCriteria = updateDatesAndOccupancyFromMultiDestPackages(
						multiDestinationPackage, insuranceCriteria);
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				insuranceCriteria = updateDatesAndOccupancyFromPackages(
						availablePackage, insuranceCriteria);
			}
		}
		if (itinerary.getFlights() != null) {
			for (TripFlight tripFlight : itinerary.getFlights()) {
				insuranceCriteria = updateDatesAndOccupancyFromFlights(
						tripFlight, insuranceCriteria);
			}
		}
		if (itinerary.getHotels() != null) {
			for (Hotel hotel : itinerary.getHotels()) {
				insuranceCriteria = updateDatesAndOccupancyFromHotels(hotel,
						insuranceCriteria);
			}
		}
		if (insuranceCriteria.getDepartureDate() != null) {
			reqType.setDep_Date(new java.sql.Date(insuranceCriteria
					.getDepartureDate().getTime()));
		}
		if (insuranceCriteria.getReturnDate() != null) {
			reqType.setRet_Date(new java.sql.Date(insuranceCriteria
					.getReturnDate().getTime()));
		}
		populateOccupancyInRequest(insuranceCriteria.getOccupancy(), reqType);
	}

	/**
	 * Method to populate daparture date, return date and Occupancy from flights
	 * 
	 * @param tripFlight
	 * @param insuranceCriteria
	 * 
	 * @see
	 * @since
	 */
	private InsuranceCriteria updateDatesAndOccupancyFromFlights(
			TripFlight tripFlight, InsuranceCriteria insuranceCriteria) {
		if (tripFlight.getOutboundFlight().getDepartureTime().compareTo(
				insuranceCriteria.getDepartureDate()) < 0) {
			insuranceCriteria.setDepartureDate(tripFlight.getOutboundFlight()
					.getDepartureTime());
		}
		if (tripFlight.getInboundFlight() != null
				&& tripFlight.getInboundFlight().getDepartureTime().compareTo(
						insuranceCriteria.getReturnDate()) > 0) {
			insuranceCriteria.setReturnDate(tripFlight.getInboundFlight()
					.getDepartureTime());
		}
		insuranceCriteria.setOccupancy(this.retrieveMaxOccupancy(
				insuranceCriteria.getOccupancy(), tripFlight.getOccupancy()));
		return insuranceCriteria;
	}

	/**
	 * Method to populate daparture date, return date and Occupancy from hotels
	 * 
	 * @param hotel
	 * @param insuranceCriteria
	 * 
	 * @see
	 * @since
	 */
	private InsuranceCriteria updateDatesAndOccupancyFromHotels(Hotel hotel,
			InsuranceCriteria insuranceCriteria) {
		if (hotel.getCheckInDate().compareTo(insuranceCriteria.getDepartureDate()) < 0) {
			insuranceCriteria.setDepartureDate(hotel.getCheckInDate());
		}
		if (hotel.getCheckOutDate().compareTo(insuranceCriteria.getReturnDate()) > 0) {
			insuranceCriteria.setReturnDate(hotel.getCheckOutDate());
		}
		insuranceCriteria.setOccupancy(this.retrieveMaxOccupancy(
				insuranceCriteria.getOccupancy(), hotel.getOccupancy()));
		return insuranceCriteria;
	}

	/**
	 * Method to populate daparture date, return date and Occupancy from
	 * packages
	 * 
	 * @param availablePackage
	 * @param insuranceCriteria
	 * 
	 * @see
	 * @since
	 */
	private InsuranceCriteria updateDatesAndOccupancyFromPackages(Package availablePackage,
			InsuranceCriteria insuranceCriteria) {
		if (availablePackage.getSelectedFlight() != null) {
			updateDatesAndOccupancyFromFlights(availablePackage
					.getSelectedFlight(), insuranceCriteria);
		}
		if (availablePackage.getSelectedHotel() != null) {
			updateDatesAndOccupancyFromHotels(availablePackage
					.getSelectedHotel(), insuranceCriteria);
		}
		return insuranceCriteria;
	}

	/**
	 * Method to populate daparture date, return date and Occupancy from mutli
	 * destination packages
	 * 
	 * @param multiDestinationPackage
	 * @param insuranceCriteria
	 * 
	 * @see
	 * @since
	 */
	private InsuranceCriteria updateDatesAndOccupancyFromMultiDestPackages(
			MultiDestinationPackage multiDestinationPackage, InsuranceCriteria insuranceCriteria) {
		if (multiDestinationPackage.getSelectedFlights() != null) {
			for (TripFlight tripFlight : multiDestinationPackage
					.getSelectedFlights()) {
				updateDatesAndOccupancyFromFlights(tripFlight, insuranceCriteria);
			}
		}
		if (multiDestinationPackage.getSelectedHotels() != null) {
			for (Hotel hotel : multiDestinationPackage.getSelectedHotels()) {
				updateDatesAndOccupancyFromHotels(hotel, insuranceCriteria);
			}
		}
		return insuranceCriteria;
	}

	/**
	 * Method to retrieve the max occupancy of the arguments
	 * 
	 * @param occupancy1
	 * @param occupancy2
	 * 
	 * @see
	 * @since
	 */
	private Occupancy retrieveMaxOccupancy(Occupancy occupancy1,
			Occupancy occupancy2) {
		if (occupancy1 == null && occupancy2 == null) {
			return null;
		} else if (occupancy1 == null) {
			return occupancy2;
		} else if (occupancy2 == null) {
			return occupancy1;
		} else {
			if (occupancy1.getNoOfAdults() + occupancy1.getNoOfChilds()
					+ occupancy1.getNoOfInfants()
					+ occupancy1.getNoOfLapChilds()
					+ occupancy1.getNoOfSeniors() < occupancy2.getNoOfAdults()
					+ occupancy2.getNoOfChilds() + occupancy2.getNoOfInfants()
					+ occupancy2.getNoOfLapChilds()
					+ occupancy2.getNoOfSeniors()) {
				return occupancy2;
			} else {
				return occupancy1;
			}
		}
	}

	/**
	 * Private class to hold the insurance criteria
	 * 
	 * @author hguntupa
	 * @version
	 * 
	 * 
	 * @see
	 * @since
	 */
	private class InsuranceCriteria {
		private Date departureDate;
		private Date returnDate;
		private Occupancy occupancy;

		public InsuranceCriteria() {
		}

		public InsuranceCriteria(Date departureDate, Date returnDate,
				Occupancy occupancy) {
			this.departureDate = departureDate;
			this.returnDate = returnDate;
			this.occupancy = occupancy;
		}

		/**
		 * @return the departureDate
		 */
		public Date getDepartureDate() {
			return departureDate;
		}

		/**
		 * @param departureDate
		 *            the departureDate to set
		 */
		public void setDepartureDate(Date departureDate) {
			this.departureDate = departureDate;
		}

		/**
		 * @return the returnDate
		 */
		public Date getReturnDate() {
			return returnDate;
		}

		/**
		 * @param returnDate
		 *            the returnDate to set
		 */
		public void setReturnDate(Date returnDate) {
			this.returnDate = returnDate;
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
	}
	
	
	
}
