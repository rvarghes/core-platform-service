/*
 * ItinerarySearchSAPDaoImpl.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Mar 26, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

import com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Input;
import com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Quote_Input;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Quote_Output;
import com.kcdata.abe.bapi.Yst_Bapi_QuotesearchType;
import com.kcdata.abe.bapi.Yst_Book_ParaType;
import com.kcdata.abe.bapi.Yst_Book_ResType;
import com.kcdata.abe.bapi.Yst_Res_StatusType;
import com.kcdata.abe.business.response.ItinerarySearchResponse;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryResult;
import com.kcdata.abe.data.dto.ItinerarySearchCriteria;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.UserType;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.InsuranceConvertUtils;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

public class ItinerarySearchSAPDaoImpl extends ABESAPDaoBase implements
		ItinerarySearchDao {

	private Properties airportsTimeZones;
	private Properties airlineNames;

	/**
	 * @return the aiportsTimeZones
	 */
	public Properties getAirportsTimeZones() {
		return airportsTimeZones;
	}

	/**
	 * @param aiportsTimeZones
	 *            the aiportsTimeZones to set
	 */
	public void setAirportsTimeZones(Properties airportsTimeZones) {
		this.airportsTimeZones = airportsTimeZones;
	}

	/**
	 * @return the airlineNames
	 */
	public Properties getAirlineNames() {
		return airlineNames;
	}

	/**
	 * @param airlineNames
	 *            the airlineNames to set
	 */
	public void setAirlineNames(Properties airlineNames) {
		this.airlineNames = airlineNames;
	}

	/**
	 * Method for retrieving a booking
	 * 
	 * @param bookingNo
	 *            String
	 * @return BookingSearchResponse
	 * 
	 * @see
	 * @since
	 */
	public ItinerarySearchResponse retrieveItinerary(String quote) {
		ItinerarySearchResponse quoteResponse = new ItinerarySearchResponse();

		if (quote == null || quote.trim().equals("")) {
			// Invalid booking number, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_QUOTE_NUMBER");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_QUOTE_NUMBER", null, null));
			quoteResponse.saveBusinessError(businessError);
			return quoteResponse;
		}

		// Prepare BAPI input
		Y_Ota_Retrieve_Quote_Input bapiInput = new Y_Ota_Retrieve_Quote_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());
		
		// Prepare search type; search by name or by itinerary number
		Yst_Bapi_QuotesearchType searchType = new Yst_Bapi_QuotesearchType();
		
		if(isNaN(quote)){
			searchType.setName(quote.toUpperCase());
		} else {
			searchType.setQuotation_No(quote);
		}
		
		bapiInput.setIm_St_Quotesearch(searchType);

		// Execute booking search BAPI
		Y_Ota_Retrieve_Quote_Output bapiOutput = (Y_Ota_Retrieve_Quote_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Ota_Retrieve_Quote",
						bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				quoteResponse);

		// Check for any business errors from BAPI
		if (quoteResponse.isBusinessErrorOccurred()) {
			return quoteResponse;
		}
		// Process booking output details
		quoteResponse.setItinerary(this
				.processQuoteDetails(bapiOutput));

		return quoteResponse;
	}

	public ItinerarySearchResponse search(
			ItinerarySearchCriteria itinerarySearchCriteria) {
		ItinerarySearchResponse searchResponse = new ItinerarySearchResponse();

		if (itinerarySearchCriteria == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_ITINERARY_SEARCH_CRITERIA");
			businessError
					.setErrorDescription(this.getMessageSource().getMessage(
							"INVALID_ITINERARY_SEARCH_CRITERIA", null, null));
			searchResponse.saveBusinessError(businessError);
			return searchResponse;
		}

		Y_Bapi_Search_Quotations_Input bapiInput = new Y_Bapi_Search_Quotations_Input();
		// Set input search criteria
		this.setItinerarySearchInput(bapiInput, itinerarySearchCriteria);

		// Execute quotations search BAPI
		Y_Bapi_Search_Quotations_Output bapiOutput = (Y_Bapi_Search_Quotations_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Search_Quotations", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), searchResponse);

		if (searchResponse.isBusinessErrorOccurred())
			return searchResponse;

		// Set Booking search results to response
		this.processItinerariesSearchOutput(bapiOutput, searchResponse);

		return searchResponse;
	}

	private void setItinerarySearchInput(
			Y_Bapi_Search_Quotations_Input bapiInput,
			ItinerarySearchCriteria itinerarySearchCriteria) {
		Yst_Book_ParaType searchInput = new Yst_Book_ParaType();
		searchInput.setName(itinerarySearchCriteria.getQuoteNo().toUpperCase());
		searchInput.setAgent(itinerarySearchCriteria.getAgentName());
		searchInput.setCreatedby(itinerarySearchCriteria.getCreatedBy());
		searchInput.setDest(itinerarySearchCriteria.getDestination());
		if (itinerarySearchCriteria.getItineraryDate() != null)
			searchInput.setErdat(new java.sql.Date(itinerarySearchCriteria
					.getItineraryDate().getTime()));
		searchInput.setGateway(itinerarySearchCriteria.getGateway());
		searchInput.setIatano(itinerarySearchCriteria.getIataNo());
		searchInput.setKunnr(itinerarySearchCriteria.getCustomerNo());
		searchInput.setSearch_Level(""
				+ itinerarySearchCriteria.getSearchLevel());
		if (itinerarySearchCriteria.getDepartureDate() != null)
			searchInput.setVdatu(new java.sql.Date(itinerarySearchCriteria
					.getDepartureDate().getTime()));
		// Set search criteria to BAPI input parameter
		bapiInput.setIm_Search_Para(searchInput);
	}

	/**
	 * Method processes itinerary details response
	 * 
	 * @param bookingNo
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private Itinerary processQuoteDetails(Y_Ota_Retrieve_Quote_Output bapiOutput) {
		Itinerary itinerary = new Itinerary();
		itinerary.setQuoteNo(bapiOutput.getEx_St_Res_Status().getBooking_Num());
		// retrieve quote name
		String quoteName = (bapiOutput.getEx_St_Res_Status().getName() != null) ? bapiOutput
				.getEx_St_Res_Status().getName()
				: null;
		itinerary.setName(quoteName);
		// Prepare booking header
		itinerary.setBookingHeader(this.processQuoteHeader(bapiOutput
				.getEx_St_Res_Status()));

		// Parse guest info data in booking
		itinerary.setGuests(GuestInfoConvertUtil
				.processQuotedGuestInfo(bapiOutput.get_as_listIt_Guestinfo()));
		Map<String, Package> packagesMap = new HashMap<String, Package>();
		// Parse hotels data in booking
		itinerary.setHotels(HotelConvertUtils.processQuotedHotels(bapiOutput
				.get_as_listIt_Htl_Items(), itinerary.getGuests(), packagesMap));

		// Parse flights data in booking
		itinerary.setFlights(FlightConvertUtils.processQuotedFlights(bapiOutput
				.get_as_listIt_Flt_Items(), bapiOutput
				.get_as_listIt_Flt_Segments(), this.getAirportsTimeZones(),
				this.getAirlineNames(), itinerary.getGuests(),packagesMap));
		
		if(packagesMap.values() != null && packagesMap.values().size() != 0) {
			itinerary.setPackages(new ArrayList<Package>(packagesMap.values()));
			if (itinerary.getFlights().size() == 0) {
				itinerary.setFlights(null);
			}
			if (itinerary.getHotels().size() == 0) {
				itinerary.setHotels(null);
			}		
		}
		// Process for charter packages if at least one hotel and flight is
		// available
		//processPackages(itinerary);

		// Parse vehicles data in booking
		itinerary.setVehicles(VehicleConvertUtils
				.parseQuotedVehicles(bapiOutput.get_as_listIt_Veh_Items()));

		// Parse Supplements/Services data in booking
		itinerary.setServices(ServicesConvertUtils
				.processQuotedServices(bapiOutput.get_as_listIt_Ser_Items()));

		// Parse Insurance data in booking
		itinerary.setInsurances(InsuranceConvertUtils
				.processQuotedInsurance(bapiOutput.get_as_listIt_Ins_Items()));

		// Parse PAX price breakup
		GuestInfoConvertUtil.processPaxPriceBreakup(itinerary.getGuests(),
				bapiOutput.get_as_listIt_Pax_Pricing());

		// Prepare search criteria for itinerary
		itinerary.setSearchCriteria(this.prepareSearchCriteria(itinerary
				.getGuests()));

		// Set IMApplicationInfo back to Itinerary as it is required in
		// front-end
		IMApplicationInfo imApplicationInfo = this
				.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().getIMApplicationInfo();
		
		imApplicationInfo.setRequestorID(bapiOutput.getEx_St_Res_Status().getRequestorid());
		imApplicationInfo.setAgentNumber(bapiOutput.getEx_St_Res_Status().getAgentsine());
		if(UserType.ADMINISTRATOR.getCode()==bapiOutput.getEx_St_Res_Status().getType()){
			imApplicationInfo.setType(UserType.ADMINISTRATOR);
		}
		if(UserType.TRAVEL_AGENT.getCode()==bapiOutput.getEx_St_Res_Status().getType()){
			imApplicationInfo.setType(UserType.TRAVEL_AGENT);
		}
		if(UserType.RESERVATION_AGENT.getCode()==bapiOutput.getEx_St_Res_Status().getType()){
			imApplicationInfo.setType(UserType.RESERVATION_AGENT);
		}
		if(UserType.SKED_DESK.getCode()==bapiOutput.getEx_St_Res_Status().getType()){
			imApplicationInfo.setType(UserType.SKED_DESK);
		}
		if(UserType.CUSTOMER.getCode()==bapiOutput.getEx_St_Res_Status().getType()){
			imApplicationInfo.setType(UserType.CUSTOMER);
		}
		itinerary.setImApplicationInfo(imApplicationInfo);
		return itinerary;
	}

	/**
	 * 
	 * Method used to prepare CharterPackages from flights and hotels
	 * 
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private void processPackages(Itinerary itinerary) {
		if (itinerary.getFlights() == null || itinerary.getHotels() == null) {
			return;
		}
		ListIterator<TripFlight> flightIterator = itinerary.getFlights()
				.listIterator();
		while (flightIterator.hasNext()) {
			TripFlight tripFlight = flightIterator.next();
			String flightPosnr = tripFlight.getOutboundFlight().getPosnr();
			if (flightPosnr != null) {
				ListIterator<Hotel> hotelIterator = itinerary.getHotels()
						.listIterator();
				boolean hotelFound = false;
				while (hotelIterator.hasNext()) {
					Hotel hotel = hotelIterator.next();
					for (RoomCategory roomCategory : hotel.getRoomCategories()) {
						if (flightPosnr.equals(roomCategory.getPosnr())) {
							Package availablePackage = new Package();
							availablePackage.setSelectedFlight(tripFlight);
							availablePackage.setSelectedHotel(hotel);
							flightIterator.remove();
							hotelIterator.remove();
							if (itinerary.getPackages() == null) {
								itinerary.setPackages(new ArrayList<Package>());
							}
							itinerary.getPackages().add(availablePackage);
							hotelFound = true;
							break;
						}
					}
					if (hotelFound) {
						break;
					}
				}
			}
		}
		if (itinerary.getFlights().size() == 0) {
			itinerary.setFlights(null);
		}
		if (itinerary.getHotels().size() == 0) {
			itinerary.setHotels(null);
		}
	}

	/**
	 * Method to prepare the Occupancy from GuestInfo structure
	 * 
	 * @param guestList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private SearchCriteria prepareSearchCriteria(List<GuestInfo> guestList) {
		SearchCriteria searchCriteria = new SearchCriteria();
		if (guestList != null) {
			Occupancy occupancy = new Occupancy();
			ArrayList<Passenger> passengers = new ArrayList<Passenger>();
			for (GuestInfo guestInfo : guestList) {
				Passenger passenger = new Passenger();
				passenger.setAgeCode(guestInfo.getAgeCode());
				passenger.setGuestCount((byte) 1);
				passenger.setPaxId(Byte.parseByte(guestInfo.getGuestId()));
				if (guestInfo.getAgeCode() != null) {
					if (guestInfo.getAgeCode().getAgeCode() == AgeCode.ADULT
							.getAgeCode()) {
						occupancy.setNoOfAdults((byte) (occupancy
								.getNoOfAdults() + 1));
					} else if (guestInfo.getAgeCode().getAgeCode() == AgeCode.CHILD
							.getAgeCode()) {
						passenger.setAge(guestInfo.getAge());
						occupancy.setNoOfChilds(((byte) (occupancy
								.getNoOfChilds() + 1)));
					} else if (guestInfo.getAgeCode().getAgeCode() == AgeCode.LAPCHILD
							.getAgeCode()) {
						occupancy.setNoOfLapChilds((byte) (occupancy
								.getNoOfLapChilds() + 1));
					} else if (guestInfo.getAgeCode().getAgeCode() == AgeCode.INFANT
							.getAgeCode()) {
						occupancy.setNoOfInfants((byte) (occupancy
								.getNoOfInfants() + 1));
					} else {
						occupancy.setNoOfSeniors((byte) (occupancy
								.getNoOfSeniors() + 1));
					}
				}
				passengers.add(passenger);
			}
			occupancy.setPassengers(passengers);
			searchCriteria.setOccupancy(occupancy);
		}
		return searchCriteria;
	}

	/**
	 * Method process quote header details; BookingHeader VO reused.
	 * 
	 * @param orderHeader
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private BookingHeader processQuoteHeader(Yst_Res_StatusType orderHeader) {
		if (orderHeader == null)
			return null;

		BookingHeader bookingHeader = new BookingHeader();

		bookingHeader.setBookingNo(orderHeader.getBooking_Num());
		if (orderHeader.getBk_Date() != null)
			bookingHeader.setBookingDate(orderHeader.getBk_Date());
		bookingHeader.setTourId(orderHeader.getTour_Id());
		
		// Begin: Set agency
		Agency agency = new Agency();
		agency.setCustomerNo(orderHeader.getRequestorid());
		agency.setPrimaryPhone(orderHeader.getAgency_Ph());
		agency.setName(orderHeader.getAgencyname());
		Agent agent = new Agent();
		agent.setFirstName(orderHeader.getResagentname());
		agent.setFullName(orderHeader.getResagentname());
		agent.setRoyaltyNo(orderHeader.getRoyalty_Num());
		if (orderHeader.getAgentsine() != null
				&& !"".equals(orderHeader.getAgentsine())) {
			agent.setAgentNo(orderHeader.getAgentsine());
		}
		ArrayList<Agent> agents = new ArrayList<Agent>();
		agents.add(agent);
		agency.setAgents(agents);
		bookingHeader.setAgency(agency);
		
		// End: Set agency
		bookingHeader.setTourPrice(orderHeader.getTour_Price().doubleValue());
		bookingHeader.setAmountDue(orderHeader.getAmt_Due().doubleValue());
		bookingHeader.setAmountPaid(orderHeader.getPaid_Amt().doubleValue());
		bookingHeader.setBaseCommission(orderHeader.getBase_Comm()
				.doubleValue());
		bookingHeader.setMinimumAmount(orderHeader.getMin_Amt().doubleValue());
		if (orderHeader.getDep_Date() != null)
			bookingHeader.setDepartureDate(orderHeader.getDep_Date());
		if (orderHeader.getOpt_Date() != null)
			bookingHeader.setOptionDate(orderHeader.getOpt_Date());
		if (orderHeader.getGuar_Date() != null)
			bookingHeader.setGuaranteedDate(orderHeader.getGuar_Date());
		if (orderHeader.getFinpayduedate() != null)
			bookingHeader.setFinalDueDate(orderHeader.getFinpayduedate());
		if (orderHeader.getCanc_Date() != null)
			bookingHeader.setCancellationDate(orderHeader.getCanc_Date());
		if (orderHeader.getTkt_Date() != null)
			bookingHeader.setTicketingDate(orderHeader.getTkt_Date());
		if (orderHeader.getVouchersprndate() != null)
			bookingHeader.setVoucherDate(orderHeader.getVouchersprndate());
		// Set Tracking no
		bookingHeader.setTrackingNo(orderHeader.getTrackingno());
		// Set promo fields
		bookingHeader.setPromoId(orderHeader.getPromo_Id());
		bookingHeader.setPromoCode(orderHeader.getPromo_Code());
		bookingHeader.setPromoSaving(orderHeader.getPromo_Saving()
				.doubleValue());
		// Set user tracking fields
		bookingHeader.setCreatedBy(orderHeader.getCreatedby());
		if (orderHeader.getCreatedon() != null)
			bookingHeader.setCreatedDate(orderHeader.getCreatedon());
		if (orderHeader.getLastchangeby() != null)
			bookingHeader.setLastChangeBy(orderHeader.getLastchangeby());
		if (orderHeader.getLastchangeon() != null)
			bookingHeader.setLastChangeDate(orderHeader.getLastchangeon());
		bookingHeader.setSalesOrg(orderHeader.getSales_Org());
		bookingHeader.setDistributionChannel(orderHeader.getDist_Chan());
		bookingHeader.setCallCenter(orderHeader.getCall_Center());
		if ("X".equals(orderHeader.getApply_Pymt())) {
			bookingHeader.setApplyPaymentAllowed(false);
		} else {
			bookingHeader.setApplyPaymentAllowed(true);
		}
		if (orderHeader.getZero_Price_Item() != null
				&& Integer.parseInt(orderHeader.getZero_Price_Item()) > 0) {
			bookingHeader.setZeroPriceError(true);
		} else {
			bookingHeader.setZeroPriceError(false);
		}
		if (orderHeader.getZero_Price_Head() != null
				&& "X".equals(orderHeader.getZero_Price_Head())) {
			bookingHeader.setPriceMismatchError(true);
		} else {
			bookingHeader.setPriceMismatchError(false);
		}
		if (orderHeader.getAlert_Code() != null) {
			bookingHeader.setAlertCode(orderHeader.getAlert_Code());
		}
		if (orderHeader.getAct_Code() != null) {
			bookingHeader.setActionCode(orderHeader.getAct_Code());
		}
		
		return bookingHeader;
	}

	/**
	 * Method processes booking search results onto response
	 * 
	 * @param bapiOutput
	 * @param searchResponse
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void processItinerariesSearchOutput(
			Y_Bapi_Search_Quotations_Output bapiOutput,
			ItinerarySearchResponse searchResponse) {
		if (bapiOutput.get_as_listIt_Searchresults() != null) {
			Iterator<Yst_Book_ResType> itResults = bapiOutput
					.get_as_listIt_Searchresults().iterator();
			ArrayList<ItineraryResult> itineraries = new ArrayList<ItineraryResult>();

			while (itResults.hasNext()) {
				Yst_Book_ResType result = itResults.next();
				ItineraryResult itinerary = new ItineraryResult();
				itinerary.setName(result.getName());
				itinerary.setQuoteNo(result.getBookingnumber());
				itinerary.setItineraryDate(result.getCreate_Date());
				itinerary.setIataNo(result.getIatano());
				itinerary.setAgencyName1(result.getAgency_Name1());
				itinerary.setAgencyName2(result.getAgency_Name2());
				// itinerary.setAmount(result.getPax_Amount().doubleValue());
				itinerary.setTourId(result.getTour_Id());
				itineraries.add(itinerary);
			}
			searchResponse.setItineraries(itineraries);
		}
	}
	
	/**
	 * 
	 * Utility method to find if the string is a number or a non-number
	 *
	 * @param value
	 * @return
	 *
	 * @see
	 * @since
	 */
	private boolean isNaN(String value) {
		for (int i = 0; i < value.length(); i++) { 
			if (!Character.isDigit(value.charAt(i))) 
				return true;        
		}
		return false;
		}
}
