/*
 * BookingSearchSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 8, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import com.kcdata.abe.application.command.ResyncBookingCommand;
import com.kcdata.abe.bapi.Y_Bapi_Resync_Booking_Input;
import com.kcdata.abe.bapi.Y_Bapi_Resync_Booking_Output;
import com.kcdata.abe.bapi.Y_Bapi_Search_Bookings_Input;
import com.kcdata.abe.bapi.Y_Bapi_Search_Bookings_Output;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Reservation_Input;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Reservation_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType;
import com.kcdata.abe.bapi.Yst_Book_ParaType;
import com.kcdata.abe.bapi.Yst_Book_ResType;
import com.kcdata.abe.bapi.Yst_Ota_ChargesType;
import com.kcdata.abe.bapi.Yst_Res_StatusType;
import com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.data.dto.Agent;
import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.BookingResult;
import com.kcdata.abe.data.dto.BookingSearchCriteria;
import com.kcdata.abe.data.dto.BookingStatus;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryCharge;
import com.kcdata.abe.data.dto.ItineraryPrice;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.InsuranceConvertUtils;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

/**
 * DAO implementation class for booking search
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class BookingSearchSAPDaoImpl extends ABESAPDaoBase implements
		BookingSearchDao {
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
	 * Method to retrieve bookings
	 * 
	 * @param bookingSearchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingSearchResponse search(
			BookingSearchCriteria bookingSearchCriteria) {
		BookingSearchResponse searchResponse = new BookingSearchResponse();

		if (bookingSearchCriteria == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_BOOKING_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_BOOKING_SEARCH_CRITERIA", null, null));
			searchResponse.saveBusinessError(businessError);
			return searchResponse;
		}

		Y_Bapi_Search_Bookings_Input bapiInput = new Y_Bapi_Search_Bookings_Input();
		// Set input search criteria
		this.setBookingSearchInput(bapiInput, bookingSearchCriteria);

		// Execute booking search BAPI
		Y_Bapi_Search_Bookings_Output bapiOutput = (Y_Bapi_Search_Bookings_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Search_Bookings", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), searchResponse);

		if (searchResponse.isBusinessErrorOccurred())
			return searchResponse;

		// Set Booking search results to response
		this.processBookingSearchOutput(bapiOutput, searchResponse);

		return searchResponse;
	}

	/**
	 * Method sets bookings search criteria to BAPI input parameter
	 * 
	 * @param bapiInput
	 * @param bookingSearchCriteria
	 * 
	 * @see
	 * @since
	 */
	private void setBookingSearchInput(Y_Bapi_Search_Bookings_Input bapiInput,
			BookingSearchCriteria bookingSearchCriteria) {
		Yst_Book_ParaType searchInput = new Yst_Book_ParaType();
		searchInput.setAgent(bookingSearchCriteria.getAgentName());
		searchInput.setCreatedby(bookingSearchCriteria.getCreatedBy());
		searchInput.setDest(bookingSearchCriteria.getDestination());
		if (bookingSearchCriteria.getBookingDate() != null)
			searchInput.setErdat(new java.sql.Date(bookingSearchCriteria
					.getBookingDate().getTime()));
		searchInput.setGateway(bookingSearchCriteria.getGateway());
		searchInput.setIatano(bookingSearchCriteria.getIataNo());
		searchInput.setKunnr(bookingSearchCriteria.getCustomerNo());
		searchInput.setName_Fst(bookingSearchCriteria.getFirstName());
		searchInput.setName_Lst(bookingSearchCriteria.getLastName());
		searchInput.setRoyalty_No(bookingSearchCriteria.getRoyaltyNo());
		if(null != bookingSearchCriteria.getBookingEndDate()){
			searchInput.setBookingenddate(new java.sql.Date(bookingSearchCriteria.getBookingEndDate().getTime()));
		}
		if(null != bookingSearchCriteria.getBookingStartDate()){
			searchInput.setBookingstartdate(new java.sql.Date(bookingSearchCriteria.getBookingStartDate().getTime()));
		}
		searchInput
				.setSearch_Level("" + bookingSearchCriteria.getSearchLevel());
		if (bookingSearchCriteria.getDepartureDate() != null)
			searchInput.setVdatu(new java.sql.Date(bookingSearchCriteria
					.getDepartureDate().getTime()));
		// Set search criteria to BAPI input parameter
		bapiInput.setIm_Search_Para(searchInput);
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
	private void processBookingSearchOutput(
			Y_Bapi_Search_Bookings_Output bapiOutput,
			BookingSearchResponse searchResponse) {
		if (bapiOutput.get_as_listIt_Searchresults() != null) {
			Iterator<Yst_Book_ResType> itResults = bapiOutput
					.get_as_listIt_Searchresults().iterator();
			ArrayList<BookingResult> bookings = new ArrayList<BookingResult>();

			while (itResults.hasNext()) {
				Yst_Book_ResType result = itResults.next();
				BookingResult booking = new BookingResult();
				booking.setBookingNo(result.getBookingnumber());
				booking.setBookingDate(result.getCreate_Date());
				booking.setFirstName(result.getName_Fst());
				booking.setLastName(result.getName_Lst());
				booking.setIataNo(result.getIatano());
				booking.setAgencyName1(result.getAgency_Name1());
				booking.setAgencyName2(result.getAgency_Name2());
				booking.setAmount(result.getPax_Amount().doubleValue());
				booking.setTourId(result.getTour_Id());
				booking.setRoyaltyNo(result.getRoyalty_No());
				// Begin: Set booking status
				String status = result.getBooking_Stat();
				if (status.equals(BookingStatus.OPT.getStatus()))
					booking.setBookingStatus(BookingStatus.OPT);
				else if (status.equals(BookingStatus.CANC.getStatus()))
					booking.setBookingStatus(BookingStatus.CANC);
				else if (status.equals(BookingStatus.DEP.getStatus()))
					booking.setBookingStatus(BookingStatus.DEP);
				else if (status.equals(BookingStatus.DRD.getStatus()))
					booking.setBookingStatus(BookingStatus.DRD);
				else if (status.equals(BookingStatus.EXP.getStatus()))
					booking.setBookingStatus(BookingStatus.EXP);
				else if (status.equals(BookingStatus.GTD.getStatus()))
					booking.setBookingStatus(BookingStatus.GTD);
				else if (status.equals(BookingStatus.PIF.getStatus()))
					booking.setBookingStatus(BookingStatus.PIF);
				// End: Set booking status

				// Add booking to bookings list
				bookings.add(booking);
			}
			searchResponse.setBookings(bookings);
		}
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
	public BookingSearchResponse retrieveBooking(String bookingNo) {
			
	   return processBapi(bookingNo);
	}

	/**
	 * Method processes booking details response
	 * 
	 * @param bookingNo
	 * @param bapiOutput
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Itinerary processBookingDetails(String bookingNo,
			Y_Ota_Retrieve_Reservation_Output bapiOutput) {
		Itinerary itinerary = new Itinerary();
		itinerary.setBookingNo(bookingNo);

		// Prepare booking header
		itinerary.setBookingHeader(this.processBookingHeader(bapiOutput
				.getEx_St_Res_Status()));

		// Parse guest info data in booking
		itinerary.setGuests(GuestInfoConvertUtil.processGuestInfo(bapiOutput
				.get_as_listIt_Guestinfo()));

		// Parse hotels data in booking
		itinerary.setHotels(HotelConvertUtils.processReservedHotels(bapiOutput
				.get_as_listIt_Res_Hotels(), bapiOutput.get_as_listIt_Vendor_Info(), itinerary.getGuests()));

		// Parse flights data in booking
		itinerary.setFlights(FlightConvertUtils.processReservedFlights(
				bapiOutput.get_as_listIt_Res_Flights(), bapiOutput
						.get_as_listIt_Flight_Segments(), this
						.getAirportsTimeZones(), this.getAirlineNames(),
				itinerary.getGuests()));

		//Process seat allocations
		if(!itinerary.getBookingHeader().getBookingStatus().isCancelled() 
				&& !itinerary.getBookingHeader().getBookingStatus().isExpired())
		{
			itinerary.setSeatAllocationList(FlightConvertUtils
					.processSeatAllocations(bapiOutput.get_as_listIt_Seatmap(), itinerary));
		}
		// Process for charter packages if at least one hotel and flight is
		// available
		processPackages(itinerary);

		// Parse vehicles data in booking
		itinerary.setVehicles(VehicleConvertUtils
				.parseReservedVehicles(bapiOutput.get_as_listIt_Res_Veh()));

		// Parse Supplements/Services data in booking
		itinerary.setServices(ServicesConvertUtils
				.processReservedServices(bapiOutput.get_as_listIt_Res_Ser()));
//Commented for time being
		// Remove seat services here
//		SeatMapUtils.removeSeatServicesWhileRetrieve(itinerary.getServices());
		
		// Parse Insurance data in booking
		itinerary.setInsurances(InsuranceConvertUtils
				.processReservedInsurance(bapiOutput.get_as_listIt_Res_Ins()));

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
		if (itinerary.getBookingHeader() != null) {
			if (itinerary.getBookingHeader().getSalesOrg() != null) {
				imApplicationInfo.setSalesOrg(itinerary.getBookingHeader()
						.getSalesOrg());
			}
			if (itinerary.getBookingHeader().getAgency() != null) {
				if (imApplicationInfo.getType() != null
						&& imApplicationInfo.getType().isTravelAgent()) {
					imApplicationInfo.setRequestorID(itinerary
							.getBookingHeader().getAgency().getIataNo());
				} else {
					imApplicationInfo.setRequestorID(itinerary
							.getBookingHeader().getAgency().getCustomerNo());
				}
				if (itinerary.getBookingHeader().getAgency().getAgents() != null
						&& itinerary.getBookingHeader().getAgency().getAgents()
								.size() > 0) {
					Agent agent = (Agent) itinerary.getBookingHeader()
							.getAgency().getAgents().get(0);
					imApplicationInfo.setAgentNumber("" + agent.getAgentNo());
					if("9999999999". equals(agent.getAgentNo())) {
						if(agent.getFullName() != null && agent.getFullName().indexOf(" ") != -1) {
							byte index = (byte) agent.getFullName().indexOf(" ");
							imApplicationInfo.setAgentFirstName(agent.getFullName().substring(0, index));
							imApplicationInfo.setAgentLastName(agent.getFullName().substring(index+1));
						} else {
							imApplicationInfo.setAgentFirstName(agent.getFullName());
						}
					}
				}
			}

		}
		// Process Itinerary price
		itinerary.setItineraryPrice(this.parseItineraryPrice(bapiOutput
				.getEx_St_Res_Status()));
		// Process Itinerary charges
		if (bapiOutput.get_as_listIt_Charges() != null) {
			itinerary.setItineraryCharges(this.parseItineraryCharges(bapiOutput
					.get_as_listIt_Charges()));
		}
		itinerary.setImApplicationInfo(imApplicationInfo);
		
		return itinerary;
	}

	/**
	 * Method process booking header details
	 * 
	 * @param orderHeader
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private BookingHeader processBookingHeader(Yst_Res_StatusType orderHeader) {
		if (orderHeader == null)
			return null;

		BookingHeader bookingHeader = new BookingHeader();

		bookingHeader.setBookingNo(orderHeader.getBooking_Num());
		if (orderHeader.getBk_Date() != null)
			bookingHeader.setBookingDate(orderHeader.getBk_Date());
		// Begin: Set booking status
		String status = orderHeader.getBk_Status();
		if (status != null) {
			if (status.equals(BookingStatus.OPT.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.OPT);
			else if (status.equals(BookingStatus.CANC.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.CANC);
			else if (status.equals(BookingStatus.DEP.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.DEP);
			else if (status.equals(BookingStatus.DRD.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.DRD);
			else if (status.equals(BookingStatus.EXP.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.EXP);
			else if (status.equals(BookingStatus.GTD.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.GTD);
			else if (status.equals(BookingStatus.PIF.getStatus()))
				bookingHeader.setBookingStatus(BookingStatus.PIF);
		}
		// End: Set booking status
		bookingHeader.setTourId(orderHeader.getTour_Id());
		// Begin: Set agency
		Agency agency = new Agency();
		agency.setCustomerNo(orderHeader.getCust_Num());
		agency.setIataNo(orderHeader.getIata_Num());
		agency.setPrimaryPhone(orderHeader.getAgency_Ph());
		agency.setName(orderHeader.getAgencyname());
		Agent agent = new Agent();
		agent.setFirstName(orderHeader.getResagentname());
		agent.setFullName(orderHeader.getResagentname());
		agent.setRoyaltyNo(orderHeader.getRoyalty_Num());
		if (orderHeader.getPerson_No() != null
				&& !"".equals(orderHeader.getPerson_No())) {
			if("0000000000".equals(orderHeader.getPerson_No())) {
				agent.setAgentNo("9999999999");
			} else {
				agent.setAgentNo(orderHeader.getPerson_No());				
			}
		}
		ArrayList<Agent> agents = new ArrayList<Agent>();
		agents.add(agent);
		agency.setAgents(agents);
		bookingHeader.setAgency(agency);
		// End: Set agency
		bookingHeader.setTourPrice(orderHeader.getTour_Price().doubleValue());
		bookingHeader.setAmountDue(orderHeader.getAmt_Due().doubleValue());
		bookingHeader.setAmountPaid(orderHeader.getPaid_Amt().doubleValue());
		bookingHeader.setBaseCommission(orderHeader.getBase_Comm().doubleValue());
		bookingHeader.setMinimumAmount(orderHeader.getMin_Amt().doubleValue());		
		bookingHeader.setPaymentDue(orderHeader.getTour_Price().
				subtract(orderHeader.getPaid_Amt()).setScale(2,java.math.BigDecimal.ROUND_UP).doubleValue());		
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
		
		//Modified for issue#3892839 - Expired bookings should read Apply payment allow – N
		if ("X".equals(orderHeader.getApply_Pymt()) || BookingStatus.EXP.getStatus().equals(status)) {
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
		bookingHeader.setAgencyRatingCode(orderHeader.getAbc_Code());
		// Set Booking document type ('ZGR' for group booking)
		bookingHeader.setBookingDocumentType(orderHeader.getAuart());
		return bookingHeader;
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
			String flightPosnr=null;
			if(tripFlight != null && tripFlight.getOutboundFlight()!=null){
			 flightPosnr = tripFlight.getOutboundFlight().getPosnr();
			}else {
				itinerary.setNeedToResync(true);
				return;		
			}
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
							populatePackagePrice(availablePackage);
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
	 * Method to populate package pricing
	 * 
	 * @param packages
	 * 
	 * @see
	 * @since
	 */
	private void populatePackagePrice(Package availablePackage) {
		double packagePrice = 0;
		double perPersonPkgPrice = 0;
		if (availablePackage.getSelectedHotel() != null) {
			// Air + Hotel, Air + Hotel + Car and Hotel + Car scenarios
			Hotel hotel = availablePackage.getSelectedHotel();
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				roomPrice.setPackagePrice(roomPrice.getTotalAmount());
				packagePrice += roomPrice.getPackagePrice();
				perPersonPkgPrice += roomPrice.getPerAdultBasePrice();
			}
			Price price = availablePackage.getPrice();
			if (price == null) {
				price = new Price();
			}
			price.setPackagePrice(packagePrice);
			price.setPerAdultBasePrice(perPersonPkgPrice);
			availablePackage.setPrice(price);
		} else if (availablePackage.getSelectedFlight() != null) {
			// Air + Car scenario
			availablePackage.setPrice(availablePackage.getSelectedFlight()
					.getPrice());
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
	 * 
	 * Method used to resync current booking against offline updates done in SAP
	 * tables
	 * 
	 * @param bookingNo
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public BookingSearchResponse resyncBooking(ResyncBookingCommand resyncBookingCommand) {
		BookingSearchResponse bookingResponse = new BookingSearchResponse();
		// Prepare BAPI input
		Y_Bapi_Resync_Booking_Input bapiInput = new Y_Bapi_Resync_Booking_Input();

		// set the booking number
		bapiInput.setP_Vbeln(resyncBookingCommand.getBookingNo());
		Yst_Bapi_Appli_InfoType appliInfoType = new Yst_Bapi_Appli_InfoType();
		IMApplicationInfo applicationInfo = resyncBookingCommand.getIMApplicationInfo();
		if(applicationInfo.getCreatedBy() != null)
			appliInfoType.setCreatedby(applicationInfo.getCreatedBy().toUpperCase());
		bapiInput.setIm_Application_Info(appliInfoType);
		// Execute Resync booking BAPI
		Y_Bapi_Resync_Booking_Output bapiOutput = (Y_Bapi_Resync_Booking_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Resync_Booking",
						bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				bookingResponse);

		return bookingResponse;
	}

	/**
	 * Method to parse the header and update itinerary pricing
	 * 
	 * @param reservationStatus
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private ItineraryPrice parseItineraryPrice(
			Yst_Res_StatusType reservationStatus) {
		if (reservationStatus == null) {
			return null;
		}
		ItineraryPrice itineraryPrice = new ItineraryPrice();
		itineraryPrice.setTotalPrice(reservationStatus.getTour_Price()
				.doubleValue());
		itineraryPrice.setTotalTax(reservationStatus.getTaxes().doubleValue());
		itineraryPrice.setPromoSavings(reservationStatus.getPromo_Saving()
				.doubleValue()
				* -1);
		return itineraryPrice;
	}

	/**
	 * Method to process the Itinerary charges
	 * 
	 * @param chargesTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private List<ItineraryCharge> parseItineraryCharges(
			Yst_Ota_ChargesType_List chargesTypeList) {
		Iterator<Yst_Ota_ChargesType> chargesIterator = chargesTypeList
				.iterator();
		List<ItineraryCharge> chargesList = new ArrayList<ItineraryCharge>();
		while (chargesIterator.hasNext()) {
			Yst_Ota_ChargesType chargeType = chargesIterator.next();
			ItineraryCharge charge = new ItineraryCharge();
			charge.setCode(chargeType.getCode());
			charge.setDescription(chargeType.getCharge_Name());
			charge.setQuantity(chargeType.getQuantity().doubleValue());
			charge.setPrice(chargeType.getPrice().doubleValue());
			charge.setUnitsOfMeasure(chargeType.getUom());
			chargesList.add(charge);
		}
		return chargesList;
	}

	
	
	private BookingSearchResponse processBapi(String bookingNo){
		BookingSearchResponse bookingResponse = new BookingSearchResponse();
		
		if (bookingNo == null || bookingNo.trim().equals("")) {
			// Invalid booking number, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_BOOKING_NUMBER");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_BOOKING_NUMBER", null, null));
			bookingResponse.saveBusinessError(businessError);
			return bookingResponse;
		}

		// Prepare BAPI input
		Y_Ota_Retrieve_Reservation_Input bapiInput = new Y_Ota_Retrieve_Reservation_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		bapiInput.setIm_Reservation_No(bookingNo);

		// Execute booking search BAPI
		Y_Ota_Retrieve_Reservation_Output bapiOutput = (Y_Ota_Retrieve_Reservation_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Retrieve_Reservation", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				bookingResponse);

		// Check for any business errors from BAPI
		if (bookingResponse.isBusinessErrorOccurred()) {
			return bookingResponse;
		}
		// Process booking output details
		bookingResponse.setItinerary(this.processBookingDetails(bookingNo,
				bapiOutput));
		
		if ((bookingResponse.getItinerary().getBookingHeader().getBookingStatus().equals(BookingStatus.valueOf("CANC"))) ||(
				bookingResponse.getItinerary().isBookingCancelled()))
				{
			int listIndex = 0;
			int listSize = bookingResponse.getItinerary().getGuests().size();
			for (GuestInfo guestInfo:bookingResponse.getItinerary().getGuests()){
				if (listSize==1){
					listSize=2;
				}
				bookingResponse.getItinerary().getGuests().get(listIndex).getPriceBreakup()
				.setFees(guestInfo.getPriceBreakup().getFees());
				bookingResponse.getItinerary().getGuests().get(listIndex).getPriceBreakup()
				.setTotalPrice(guestInfo.getPriceBreakup().getTotalPrice());
				listIndex++;
			}
		}
		
		return bookingResponse;

		
	}

}