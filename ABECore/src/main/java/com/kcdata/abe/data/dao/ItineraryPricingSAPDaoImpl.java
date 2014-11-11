/*
 * ItineraryPricingSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 18, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.kcdata.abe.bapi.Y_Ota_Pricing_Input;
import com.kcdata.abe.bapi.Y_Ota_Pricing_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.Yst_FarerulesType;
import com.kcdata.abe.bapi.Yst_InfotextType;
import com.kcdata.abe.bapi.Yst_Order_HdrType;
import com.kcdata.abe.bapi.Yst_Ota_ChargesType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Items_Paxtype_PricingType;
import com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_FarerulesType_List;
import com.kcdata.abe.bapi.util.Yst_InfotextType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Items_Paxtype_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List;
import com.kcdata.abe.business.request.PricingRequest;
import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.InsuranceGuestAllocation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryCancellationRules;
import com.kcdata.abe.data.dto.ItineraryCharge;
import com.kcdata.abe.data.dto.ItineraryPrice;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PaxTypePriceBreakup;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.InsuranceConvertUtils;
import com.kcdata.abe.data.util.PaxTypePriceByRoomComparator;
import com.kcdata.abe.data.util.PaxTypePriceByTypeComparator;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.util.DateUtils;

/**
 * Itinerary Pricing DAO implementation class
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ItineraryPricingSAPDaoImpl extends ABESAPDaoBase implements
		ItineraryPricingDao {

	private FlightInfoDao flightInfoDao;

	/**
	 * @return the flightInfoDao
	 */
	public FlightInfoDao getFlightInfoDao() {
		return flightInfoDao;
	}

	/**
	 * @param flightInfoDao
	 *            the flightInfoDao to set
	 */
	public void setFlightInfoDao(FlightInfoDao flightInfoDao) {
		this.flightInfoDao = flightInfoDao;
	}

	/**
	 * Method to price the given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryPricingResponse priceItinerary(Itinerary itinerary) {
		ItineraryPricingResponse pricingResponse = new ItineraryPricingResponse();
		// Create Input for BAPI
		Y_Ota_Pricing_Input bapiInput = new Y_Ota_Pricing_Input();
		HashMap<Byte, Object> itemsMap = new HashMap<Byte, Object>();
		HashMap<Byte, RoomCategory> roomCategoryMap = new HashMap<Byte, RoomCategory>();
		HashMap<Service, List<Byte>> clonedServicesMap = new HashMap<Service, List<Byte>>();
		byte itemRPH = 0;

		// Set the header
		Yst_Bapi_Req_HdrType reqHeaderType = new Yst_Bapi_Req_HdrType();
		reqHeaderType.setBooking_Num(itinerary.getBookingNo());
		if (itinerary.getBookingHeader() != null
				&& itinerary.getBookingHeader().getPromoId() != null) {
			reqHeaderType.setPromo_Code(itinerary.getBookingHeader()
					.getPromoId());
		} else if (itinerary.getSearchCriteria() != null
				&& itinerary.getSearchCriteria().getPromoCode() != null) {
			reqHeaderType.setPromo_Code(itinerary.getSearchCriteria()
					.getPromoCode());
		}
		if (itinerary.isBookingCancelled()) {
			reqHeaderType.setCancel_Booking_Ind("1");
		}
		// BPG Indicator
		if (itinerary.isAllowBPG()) {
			reqHeaderType.setBpg_Ind("1");
		}

		bapiInput.setIm_Bapi_Req_Hdr(reqHeaderType);

		// Flights Input for pricing
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemsMap, itemRPH);
			//set if requesting for sold out charter flight to be price also
			if (itinerary.getSearchCriteria() != null &&
					itinerary.getSearchCriteria().getDestinationOptions() != null){
				for (Yst_Ota_Flt_ItemsType flightItem: bapiInput.getIt_Flt_Items()){
					flightItem.setCharter_Flt_Sold_Out(itinerary.getSearchCriteria().getDestinationOptions().get(0).isSoldOutFlight()?"1":"0");
				}
			}
		}

		// Hotels Input for Pricing
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemsMap, roomCategoryMap, itemRPH, null);
		}

		// Cars Input for Pricing
		if (itinerary.getVehicles() != null) {
			itemRPH = this.prepareVehiclesInput(itinerary.getVehicles(),
					bapiInput, itemsMap, itemRPH);
		}

		// Packages Input for pricing
		if (itinerary.getPackages() != null) {
			itemRPH = this.preparePackagesInput(itinerary.getPackages(),
					bapiInput, itemsMap, roomCategoryMap, itemRPH);
			//set if requesting for sold out charter flight to be price also
			if (itinerary.getSearchCriteria() != null &&
					itinerary.getSearchCriteria().getDestinationOptions() != null){
				for (Yst_Ota_Flt_ItemsType flightItem: bapiInput.getIt_Flt_Items()){
					flightItem.setCharter_Flt_Sold_Out(itinerary.getSearchCriteria().getDestinationOptions().get(0).isSoldOutFlight()?"1":"0");
				}
			}
		}
		// Packages Input for pricing
		if (itinerary.getMultiDestinationPackages() != null) {
			itemRPH = this.prepareMultiDestPackagesInput(
					itinerary.getMultiDestinationPackages(), bapiInput,
					itemsMap, roomCategoryMap, itemRPH);
		}

		// Services input for pricing
		if (itinerary.getServices() != null) {
			itemRPH = this.prepareServicesInput(itinerary, bapiInput, itemsMap,
					clonedServicesMap, itemRPH);
		}

		// Insurance input for pricing
		if (itinerary.getInsurances() != null) {
			itemRPH = this.prepareInsuranceInput(itinerary.getInsurances(),
					bapiInput, itemRPH);
		}

		// Guest Info input for pricing
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Prepare items for deletion
		// Deleted items should pass only during the change Bookingprocess.
		if (itinerary.getDeletedList() != null
				&& itinerary.getBookingNo() != null) {
			this.prepareDeletetedList(itinerary, itinerary.getDeletedList(),
					bapiInput, itemsMap, roomCategoryMap, itemRPH);
		}

		// Set IMApplication info
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());

		// Execute the BAPI
		Y_Ota_Pricing_Output bapiOutput = (Y_Ota_Pricing_Output) this.getBapiExecutionManager().executeBAPI("Y_Ota_Pricing",bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),pricingResponse);
		// Check for any business errors from BAPI
		if (pricingResponse.isBusinessErrorOccurred()) {
			pricingResponse.setItinerary(itinerary);
			return pricingResponse;
		}

		// Parse the response structures
		// Process Flight pricing if exists
		if (bapiOutput.get_as_listIt_Flt_Items() != null) {
			this.parseFlightsPricingResponse(itemsMap,
					bapiOutput.get_as_listIt_Flt_Items(),
					bapiOutput.get_as_listIt_Flt_Segments());
		}

		// Process Hotel pricing if exists
		if (bapiOutput.getIt_Htl_Items() != null) {
			this.parseHotelPricingResponse(itemsMap, roomCategoryMap,
					bapiOutput.get_as_listIt_Htl_Items());
		}

		// Process Hotel pricing if exists
		if (bapiOutput.get_as_listIt_Veh_Items() != null) {
			this.parseVehiclePricingResponse(itemsMap,
					bapiOutput.get_as_listIt_Veh_Items());
		}

		// Process Services pricing if exists
		if (itinerary.getServices() != null
				&& bapiOutput.get_as_listIt_Ser_Items() != null) {
			this.parseServicesPricingResponse(itinerary, itemsMap,
					clonedServicesMap, bapiOutput.get_as_listIt_Ser_Items(),
					bapiInput.get_as_listIt_Ser_Items());
		}

		// Process Insurance pricing if exists
		if (itinerary.getInsurances() != null
				&& bapiOutput.get_as_listIt_Ins_Items() != null) {
			List<Insurance> insuranceList = InsuranceConvertUtils
					.parseInsuranceResponse(bapiOutput
							.get_as_listIt_Ins_Items());
			// Delete insurances from deletedList if any
			deleteInsuranceFromDeletedItems(itinerary);
			updateDeletedInsuranceList(insuranceList, itinerary);
		}

		// Process PAX based pricing
		if (itinerary.getGuests() != null
				&& bapiOutput.get_as_listIt_Pax_Pricing() != null) {
			GuestInfoConvertUtil.processPaxPriceBreakup(itinerary.getGuests(),
					bapiOutput.get_as_listIt_Pax_Pricing());
		}

		// Process PAX type based component level pricing
		if (bapiOutput.get_as_listIt_Items_Paxtype_Pricing() != null) {
			this.parsePaxTypeComponentPricing(itemsMap,
					bapiOutput.get_as_listIt_Items_Paxtype_Pricing(),itinerary.getGuests());
		}

		// Process booking level charges
		if (bapiOutput.get_as_listIt_Charges() != null) {
			itinerary.setItineraryCharges(this.parseItineraryCharges(bapiOutput
					.get_as_listIt_Charges()));
		}

		// Process the Itinerary Header
		if (bapiOutput.getEx_St_Order_Hdr() != null) {
			itinerary.setItineraryPrice(this.parseItineraryHeader(bapiOutput
					.getEx_St_Order_Hdr()));
		}

		// Process Hotels
		if (itinerary.getHotels() != null) {
			this.updateHotelDisplayPrices(itinerary.getHotels());
		}

		// Process Packages
		if (itinerary.getPackages() != null) {
			this.parsePackagesPricingResponse(itinerary.getPackages());
		}

		// Process MultiDestinationPackages
		if (itinerary.getMultiDestinationPackages() != null) {
			this.parseMultiDestPackagesPricingResponse(itinerary
					.getMultiDestinationPackages());
		}
		// Process the charters with no. of stops
		processChartersWithStops(itinerary);

		// process Sked Information Rules
		if (itinerary.isBookingCancelled()) {
			itinerary.setCancellationRules(this.parseCancellationRules(
					bapiOutput.get_as_listIt_Infotext(),
					bapiOutput.get_as_listIt_Skedrules()));
		}
		
		prepareLateFee(itinerary,bapiOutput.get_as_listIt_Pax_Pricing());
		// Set the itinerary
		pricingResponse.setItinerary(itinerary);
		return pricingResponse;
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
	
	private void prepareLateFee(Itinerary itinerary,Yst_Ota_Pax_PricingType_List paxPriceList){
		double lateFee=0;
		if(paxPriceList!=null && !paxPriceList.isEmpty())
			return;
		Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
		long duration= -1;
		if(itinerary.getSearchCriteria().getDepartureDate()!=null){
			duration=(DateUtils.dateDifferenceInDays(currentDate,itinerary.getSearchCriteria().getDepartureDate()));
		}else{
			if(itinerary.getPackages()!=null){
				duration=(DateUtils.dateDifferenceInDays(currentDate,itinerary.getPackages().get(0).getSelectedHotel().getCheckInDate()));
			}else if(itinerary.getHotels()!=null){
				duration=(DateUtils.dateDifferenceInDays(currentDate,itinerary.getHotels().get(0).getCheckInDate()));
			}else if(itinerary.getFlights()!=null){
				duration=(DateUtils.dateDifferenceInDays(currentDate,itinerary.getFlights().get(0).getOutboundFlight().getDepartureTime()));
			}		
		}
		if(duration!=-1&&duration<14)
			lateFee=calcualteGuestForLateFee(itinerary.getGuests());
		double totalPrice=itinerary.getItineraryPrice().getTotalPrice();
		if(totalPrice>0)
			itinerary.getItineraryPrice().setTotalPrice(totalPrice+lateFee);
		
		List<MultiDestinationPackage> multiDestinationPackages= itinerary.getMultiDestinationPackages();
		if(multiDestinationPackages!=null)
			for (Iterator iterator = multiDestinationPackages.iterator(); iterator.hasNext();) {
				MultiDestinationPackage multiDestinationPackage = (MultiDestinationPackage) iterator.next();
				multiDestinationPackage.getPrice().setPackagePrice(multiDestinationPackage.getPrice().getPackagePrice()+lateFee);
				continue;				
			}			
		
	}
	private byte prepareFlightsInput(List<TripFlight> flights,
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			byte itemRPH) {
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
			itemsMap.put(itemRPH, tripFlight);
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
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap, byte itemRPH,
			String flightType) {
		Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
		Yst_Ota_RoomstaycandidatesType_List roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
		if (itemsTypeList == null) {
			itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
			roomStayList = new Yst_Ota_RoomstaycandidatesType_List();
		}
		for (Hotel hotel : hotels) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils.prepareHotelItemTypeList(hotel, itemRPH, flightType,false);
			if (hotelItemsList != null) {
				itemsTypeList.addAll(hotelItemsList);
			}
			/**
			 * Prepare room stay list
			 */
			if (hotel.getSelectedRooms() != null) {
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					RoomCategory roomCategory = hotel
							.getRoomCatgoryById(roomPrice.getRoomCategoryId());
					if (roomCategory != null) {
						// Prepare Hotel Item
						itemsMap.put(++itemRPH, roomPrice);
						roomCategoryMap.put(itemRPH, roomCategory);
						// Prepare room stay candidates
						if (hotel.getOccupancy() != null && hotel.getOccupancy().getPassengers() != null) {
							roomStayList.addAll(HotelConvertUtils
								.prepareRoomStayCandidates(
										hotel.getOccupancy(),
										roomPrice.getRoomId(), itemRPH));
							}
						}
				}
			}
		}
		bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
		bapiInput.setIt_Htl_Items(itemsTypeList);
		return itemRPH;
	}

	/**
	 * Method to process the vehicles to prepare the vehicle structures
	 * 
	 * @param vehicles
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareVehiclesInput(List<Vehicle> vehicles,
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			byte itemRPH) {
		Yst_Ota_Veh_ItemsType_List vehicleItemsList = bapiInput
				.get_as_listIt_Veh_Items();
		if (vehicleItemsList == null) {
			vehicleItemsList = new Yst_Ota_Veh_ItemsType_List();
		}
		for (Vehicle vehicle : vehicles) {
			vehicleItemsList.add(VehicleConvertUtils.prepareVehItemType(
					vehicle, ++itemRPH));
			itemsMap.put(itemRPH, vehicle);
		}
		bapiInput.setIt_Veh_Items(vehicleItemsList);
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
	private byte preparePackagesInput(List<Package> packages,
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap, byte itemRPH) {
		for (Package availablePackage : packages) {
			itemRPH = preparePackageInput(availablePackage, bapiInput,
					itemsMap, roomCategoryMap, itemRPH);
		}
		return itemRPH;
	}

	/**
	 * Method to process the package to prepare all packages structures
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
	private byte preparePackageInput(Package availablePackage,
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap, byte itemRPH) {
		byte vehicleRph = 0;
		byte flightRph = 0;
		if (availablePackage.getSelectedVehicle() != null) {
			Yst_Ota_Veh_ItemsType_List vehicleItemsList = bapiInput
					.get_as_listIt_Veh_Items();
			if (vehicleItemsList == null) {
				vehicleItemsList = new Yst_Ota_Veh_ItemsType_List();
			}
			Vehicle vehicle = availablePackage.getSelectedVehicle();
			vehicleItemsList.add(VehicleConvertUtils.prepareVehItemType(
					vehicle, ++itemRPH));
			itemsMap.put(itemRPH, vehicle);
			bapiInput.setIt_Veh_Items(vehicleItemsList);
			vehicleRph = itemRPH;
		}

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

			Yst_Ota_Flt_ItemsType selectedFlightItem = FlightConvertUtils
					.prepareFlightItemTypeList(tripFlight, ++itemRPH);

			if (availablePackage.getSelectedHotel() == null && vehicleRph != 0) {
				// Flight + Car scenario.
				// Get the first element and set the VehicleRPH
				selectedFlightItem.setVeh_Item_Rph(vehicleRph + "");
			}
			flightItemsList.add(selectedFlightItem);
			// Process the segment details
			segmentsList.addAll(FlightConvertUtils.prepareFltSegmentsTypeList(
					tripFlight, itemRPH));
			itemsMap.put(itemRPH, tripFlight);
			bapiInput.setIt_Flt_Items(flightItemsList);
			bapiInput.setIt_Flt_Segments(segmentsList);
			flightRph = itemRPH;
		}

		if (availablePackage.getSelectedHotel() != null) {
			Yst_Ota_Htl_ItemsType_List itemsTypeList = bapiInput
					.get_as_listIt_Htl_Items();
			Yst_Ota_RoomstaycandidatesType_List roomStayList = bapiInput
					.get_as_listIt_Htl_Roomstaycandidates();
			if (itemsTypeList == null) {
				itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
				roomStayList = new Yst_Ota_RoomstaycandidatesType_List();
			}
			Hotel hotel = availablePackage.getSelectedHotel();
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
					.prepareHotelItemTypeList(hotel, itemRPH, null,false);
			if (hotelItemsList != null) {
				Iterator<Yst_Ota_Htl_ItemsType> iterator = hotelItemsList
						.iterator();
				while (iterator.hasNext()) {
					Yst_Ota_Htl_ItemsType hotelItemType = (Yst_Ota_Htl_ItemsType) iterator
							.next();
					if (flightRph != 0) {
						// Air + Hotel or Air + Hotel + Car scenario
						hotelItemType.setFlt_Item_Rph(flightRph + "");
					}
					if (vehicleRph != 0) {
						// Hotel + Car or Air + Hotel + Car scenario
						hotelItemType.setVeh_Item_Rph(vehicleRph + "");
					}
				}
				itemsTypeList.addAll(hotelItemsList);
			}
			/**
			 * Prepare room stay list
			 */
			if (hotel.getSelectedRooms() != null) {
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					RoomCategory roomCategory = hotel
							.getRoomCatgoryById(roomPrice.getRoomCategoryId());
					if (roomCategory != null) {
						// Prepare Hotel Item
						itemsMap.put(++itemRPH, roomPrice);
						roomCategoryMap.put(itemRPH, roomCategory);
						// Prepare room stay candidates
						if (hotel.getOccupancy() != null && hotel.getOccupancy().getPassengers() != null) {
							roomStayList.addAll(HotelConvertUtils
								.prepareRoomStayCandidates(
										hotel.getOccupancy(),
										roomPrice.getRoomId(), itemRPH));
						}
					}
				}
			}
			bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
			bapiInput.setIt_Htl_Items(itemsTypeList);
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
			Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap, byte itemRPH) {

		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			// Flights Input for pricing
			if (multiDestPkg.getSelectedFlights() != null) {
				itemRPH = this.prepareFlightsInput(
						multiDestPkg.getSelectedFlights(), bapiInput, itemsMap,
						itemRPH);
			}

			// Hotels Input for Pricing
			if (multiDestPkg.getSelectedHotels() != null) {
				String flightType = multiDestPkg.getSelectedFlights() != null ? "S"
						: null;
				itemRPH = this.prepareHotelsInput(
						multiDestPkg.getSelectedHotels(), bapiInput, itemsMap,
						roomCategoryMap, itemRPH, flightType);
			}

			// Cars Input for Pricing
			if (multiDestPkg.getSelectedVehicles() != null) {
				itemRPH = this.prepareVehiclesInput(
						multiDestPkg.getSelectedVehicles(), bapiInput,
						itemsMap, itemRPH);
			}
		}
		return itemRPH;
	}

	/**
	 * Method to process Services for pricing
	 * 
	 * @param servicesList
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareServicesInput(Itinerary itinerary, Y_Ota_Pricing_Input bapiInput, HashMap<Byte, Object> itemsMap, HashMap<Service, List<Byte>> servicesMap, byte itemRPH) {
		Yst_Ota_Ser_ItemsType_List serviceItemsList = new Yst_Ota_Ser_ItemsType_List();
		for (Service service : itinerary.getServices()) {
			// If the Service is free and mandatory, then we need not send them
			// for pricing and booking.
			if (service.isMandatory() && service.isFree()) {
				itemRPH++;
				continue;
			}
			// In multi-room bookings, if a supplement is linked with two rooms,
			// then we need to split the supplement to two line items.
			// And then attach assign the pax accordingly
			// processAirSpecificSupplements
			if (service.getGuestAllocation() != null) {

				if (service.getFlightMaterialCode() != null && !"".equals(service.getFlightMaterialCode())) {
					// Process Air Specific supplements
					itemRPH = ServicesConvertUtils.processFlightSpecificSupplements(service, itinerary, itemsMap, serviceItemsList, itemRPH, servicesMap);
				}// End of flight material condition check...
				else if (service.getHotelMaterialCode() != null && !"".equals(service.getHotelMaterialCode())) {
					// Process Hotel specific supplements
					itemRPH = ServicesConvertUtils.processHotelSpecificSupplements(service, itinerary, itemsMap, serviceItemsList, itemRPH, servicesMap);
				} else if (service.getDestination() != null && !"".equals(service.getDestination())) {
					// Process destination specific supplements
					itemRPH = ServicesConvertUtils.processDestinationSpecificSupplements(service, itinerary, itemsMap, serviceItemsList, itemRPH, servicesMap);
				} else if (service.getGateway() != null && !"".equals(service.getGateway())) {
					// Process gateway specific supplements
					itemRPH = ServicesConvertUtils.processGatewaySpecificSupplements(service, itinerary, itemsMap, serviceItemsList, itemRPH, servicesMap);
				} else {
					serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(service, ++itemRPH));
					itemsMap.put(itemRPH, service);
				}
			} else {
				serviceItemsList.add(ServicesConvertUtils.prepareServiceItemType(service, ++itemRPH));
				itemsMap.put(itemRPH, service);
			}
		}
		bapiInput.setIt_Ser_Items(serviceItemsList);
		return itemRPH;
	}

	/**
	 * Method to process insurance for pricing
	 * 
	 * @param insuranceList
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareInsuranceInput(List<Insurance> insuranceList,
			Y_Ota_Pricing_Input bapiInput, byte itemRPH) {
		Yst_Bapi_Ins_ItemsType_List insuranceItemTypeList = bapiInput
				.get_as_listIt_Ins_Items();
		if (insuranceItemTypeList == null) {
			insuranceItemTypeList = new Yst_Bapi_Ins_ItemsType_List();
		}
		// Loop through the insurance and check whether insurance is allocated.
		for (Insurance insurance : insuranceList) {
			if (insurance.getGuestAllocationList() != null) {
				try {
					Insurance clonedObj = (Insurance) insurance.clone();
					// Insurance is allocated
					List<InsuranceGuestAllocation> allocationList = clonedObj
							.getGuestAllocationList();
					clonedObj.setGuestAllocationList(null);
					for (InsuranceGuestAllocation guestAllocation : allocationList) {
						clonedObj.setGuestAllocation(guestAllocation
								.getGuestID());
						clonedObj.setPosnr(guestAllocation.getPosnr());
						clonedObj.setOldPosnr(guestAllocation.getOldPosnr());
						/*** Added for Tour Guard Issue to set Adult, Child and Total Price***/						
						clonedObj.setTotalPrice(guestAllocation.getPrice());						
						//clonedObj.setAdultPrice(insurance.getAdultPrice());
						//clonedObj.setChildPrice(insurance.getChildPrice());
						insuranceItemTypeList.add(InsuranceConvertUtils
								.prepareInsuranceType(clonedObj, ++itemRPH));
					}
				} catch (CloneNotSupportedException e) {
					// Do not raise exception as it should not fail other
					// components.
				}
			} else {
				// Insurance is not allocated. Quantity based
				insuranceItemTypeList.add(InsuranceConvertUtils
						.prepareInsuranceType(insurance, ++itemRPH));
			}
		}
		bapiInput.setIt_Ins_Items(insuranceItemTypeList);
		return itemRPH;
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
			Y_Ota_Pricing_Input bapiInput) {
		Yst_Ota_GuestinfoType_List guestInfoList = GuestInfoConvertUtil
				.prepareGuestInfoTypeList(guests);
		if (guestInfoList != null) {
			bapiInput.setIt_Guestinfo(guestInfoList);
		}
	}

	/**
	 * Method to process and input deleted items for pricing
	 * 
	 * @param deletedList
	 * @param bapiInput
	 * @param itemsMap
	 * @param itemRPH
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte prepareDeletetedList(Itinerary itinerary,
			List<ABEDto> deletedList, Y_Ota_Pricing_Input bapiInput,
			HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap, byte itemRPH) {
		if (deletedList != null) {
			for (ABEDto object : deletedList) {
				if (object instanceof TripFlight) {
					// Process as a Flight
					List<TripFlight> flightsList = new ArrayList<TripFlight>();
					flightsList.add((TripFlight) object);
					itemRPH = this.prepareFlightsInput(flightsList, bapiInput,
							itemsMap, itemRPH);
				} else if (object instanceof Hotel) {
					// Process as a Hotel
					List<Hotel> hotelsList = new ArrayList<Hotel>();
					hotelsList.add((Hotel) object);
					itemRPH = this.prepareHotelsInput(hotelsList, bapiInput,
							itemsMap, roomCategoryMap, itemRPH, null);
				} else if (object instanceof Vehicle) {
					// Process as a Vehicle
					List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
					vehiclesList.add((Vehicle) object);
					itemRPH = this.prepareVehiclesInput(vehiclesList,
							bapiInput, itemsMap, itemRPH);
				} else if (object instanceof Service) {
					// Process as a Service
					Yst_Ota_Ser_ItemsType_List serviceItemsList = bapiInput
							.get_as_listIt_Ser_Items();
					if (serviceItemsList == null) {
						serviceItemsList = new Yst_Ota_Ser_ItemsType_List();
					}
					serviceItemsList
							.add(ServicesConvertUtils.prepareServiceItemType(
									(Service) object, ++itemRPH));
					bapiInput.setIt_Ser_Items(serviceItemsList);
				} else if (object instanceof Insurance) {
					// Process as a Insurance
					List<Insurance> insuranceList = new ArrayList<Insurance>();
					insuranceList.add((Insurance) object);
					itemRPH = this.prepareInsuranceInput(insuranceList,
							bapiInput, itemRPH);
				} else if (object instanceof Package) {
					// Process as a Package
					Package availablePackage = (Package) object;
					itemRPH = preparePackageInput(availablePackage, bapiInput,
							itemsMap, roomCategoryMap, itemRPH);
				}
			}
		}
		return itemRPH;
	}

	/**
	 * Method to parse the Flight Items for pricing
	 * 
	 * @param itemsMap
	 * @param flightItemsList
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void parseFlightsPricingResponse(HashMap<Byte, Object> itemsMap,
			Yst_Ota_Flt_ItemsType_List flightItemsList,
			Yst_Ota_Flt_SegmentsType_List flightSegmentsList) {
		Iterator<Yst_Ota_Flt_ItemsType> flightItemIterator = flightItemsList
				.iterator();
		while (flightItemIterator.hasNext()) {
			Yst_Ota_Flt_ItemsType flightItem = flightItemIterator.next();
			byte itemRPH = Byte.parseByte(flightItem.getItem_Rph());
			Object flightObj = itemsMap.get(itemRPH);
			if (flightObj != null) {
				TripFlight tripFlight = (TripFlight) flightObj;
				Price initialPrice = tripFlight.getPrice();
				Price price = new Price();
				price.setAdultPrice(flightItem.getAdult_Price().doubleValue());
				price.setAirportFee(flightItem.getAirport_Tax().doubleValue());
				price.setChildPrice(flightItem.getChild_Price().doubleValue());
				price.setForeignTax(flightItem.getForeign_Tax().doubleValue());
				price.setInfantPrice(flightItem.getInfant_Price().doubleValue());
				price.setOccpancyBasedPrice(flightItem.getTotal().doubleValue());
				price.setPriceChanged(true);
				price.setLateFee(initialPrice.getLateFee());
				price.setPromoSavings(flightItem.getPromo_Savings()
						.doubleValue());
				price.setTotalTax(flightItem.getTotal_Tax().doubleValue());
				price.setUsTax(flightItem.getUs_Tax().doubleValue());
				if (flightItem.getCommission_Prct() != null) {
					price.setCommissionPercent(flightItem.getCommission_Prct()
							.floatValue());
				}
				if (flightItem.getCommission() != null) {
					price.setCommissionAmount(flightItem.getCommission()
							.doubleValue());
				}
				price.setInitialPrice(initialPrice);
				price.setPackagePrice(flightItem.getPkg_Total().doubleValue());
				price.setPerAdultBasePrice(flightItem.getPer_Adult_Base_Price()
						.doubleValue());				
				tripFlight.setPrice(price);
				//Update class of service from pricing response
				this.updateClassOfService(tripFlight, itemRPH, flightItem,
						flightSegmentsList);
			}
		}
	}
	
	/**
	 * Update class of service at segment level from pricing response
	 * 
	 * @param tripFlight
	 * @param fltItemRPH
	 * @param flightItem
	 * @param flightSegmentsList
	 */
	private void updateClassOfService(TripFlight tripFlight, byte fltItemRPH,
			Yst_Ota_Flt_ItemsType flightItem,
			Yst_Ota_Flt_SegmentsType_List flightSegmentsList) {
		if (flightSegmentsList == null || flightSegmentsList.isEmpty())
			return;
		//Update COS for outbound flight segments
		for (FlightSegment segment : tripFlight.getOutboundFlight()
				.getFlightSegments()) {
			for (Yst_Ota_Flt_SegmentsType flightSegment : flightSegmentsList
					.toArrayYst_Ota_Flt_SegmentsType()) {
				if (fltItemRPH == Byte.parseByte(flightSegment.getItem_Rph())
						&& segment.getGateway().equalsIgnoreCase(
								flightSegment.getDep_Locid())
						&& segment.getDestination().equalsIgnoreCase(
								flightSegment.getArr_Locid())) {
					segment.setClassOfService(flightSegment.getFlight_Class());
				}
			}
		}
		//Update COS for inbound flight segments
		if (tripFlight.getInboundFlight() != null) {
			for (FlightSegment segment : tripFlight.getInboundFlight()
					.getFlightSegments()) {
				for (Yst_Ota_Flt_SegmentsType flightSegment : flightSegmentsList
						.toArrayYst_Ota_Flt_SegmentsType()) {
					if (fltItemRPH == Byte.parseByte(flightSegment
							.getItem_Rph())
							&& segment.getGateway().equalsIgnoreCase(
									flightSegment.getDep_Locid())
							&& segment.getDestination().equalsIgnoreCase(
									flightSegment.getArr_Locid())) {
						segment.setClassOfService(flightSegment
								.getFlight_Class());
					}
				}
			}
		}
	}

	/**
	 * Method to process the Hotel response
	 * 
	 * @param itemsMap
	 * @param hotelItemsList
	 * @param hotel
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void parseHotelPricingResponse(HashMap<Byte, Object> itemsMap,
			HashMap<Byte, RoomCategory> roomCategoryMap,
			Yst_Ota_Htl_ItemsType_List hotelItemsList) {
		Iterator<Yst_Ota_Htl_ItemsType> hotelItemIterator = hotelItemsList
				.iterator();
		while (hotelItemIterator.hasNext()) {
			Yst_Ota_Htl_ItemsType hotelItem = hotelItemIterator.next();
			byte itemRPH = Byte.parseByte(hotelItem.getItem_Rph());

			// CQ 8540: If the FIT package is upgraded to CP, then front end is
			// not holding the package rate plan code.
			// So, get the roomCategory from RoomCategory map and update the
			// rate plan code.
			RoomCategory roomCategory = roomCategoryMap.get(itemRPH);
			if (roomCategory != null) {
				roomCategory.setRatePlanCode(hotelItem.getRateplancode());
			}

			Object roomPriceObj = itemsMap.get(itemRPH);
			if (roomPriceObj != null) {
				RoomPrice roomPrice = (RoomPrice) roomPriceObj;
				RoomPrice clonedRoomPrice = null;
				try {
					clonedRoomPrice = (RoomPrice) roomPrice.clone();
				} catch (CloneNotSupportedException ex) {
				}
				roomPrice.setInitialPrice(clonedRoomPrice);
				roomPrice.setCheckInDate(hotelItem.getArr_Date());
				if (hotelItem.getFree_Nights() != null	&& !"".equals(hotelItem.getFree_Nights())) {
					roomPrice.setFreeNights(Integer.parseInt(hotelItem.getFree_Nights()));
				} else {
					roomPrice.setFreeNights(0);
				}
				roomPrice.setTax(hotelItem.getTaxes().doubleValue());				
				roomPrice.setPromoSavingsAmount(hotelItem.getPromo_Savings().doubleValue());
				roomPrice.setSavings(hotelItem.getSavings().doubleValue());
				roomPrice.setTotalAmount(hotelItem.getTotal().doubleValue());
				if (hotelItem.getCommission_Prct() != null) {
					roomPrice.setCommissionPercent(hotelItem.getCommission_Prct().floatValue());
				}
				if (hotelItem.getCommission() != null) {
					roomPrice.setCommissionAmount(hotelItem.getCommission().doubleValue());
				}
				if (hotelItem.getPkg_Total() != null) {
					roomPrice.setPackagePrice(hotelItem.getPkg_Total().doubleValue());
				}
			}
		}
	}

	/**
	 * Method to process the Vehicle response
	 * 
	 * @param itemsMap
	 * @param hotelItemsList
	 * @param hotel
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void parseVehiclePricingResponse(HashMap<Byte, Object> itemsMap,
			Yst_Ota_Veh_ItemsType_List vehicleItemsList) {
		Iterator<Yst_Ota_Veh_ItemsType> vehicleItemsIterator = vehicleItemsList
				.iterator();
		while (vehicleItemsIterator.hasNext()) {
			Yst_Ota_Veh_ItemsType vehicleItem = vehicleItemsIterator.next();
			byte itemRPH = Byte.parseByte(vehicleItem.getItem_Rph());
			Object vehicleObj = itemsMap.get(itemRPH);
			if (vehicleObj != null) {
				Vehicle vehicle = (Vehicle) vehicleObj;
				try {
					SimpleDateFormat sdfDateTime = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					vehicle.setPickupTime(sdfDateTime.parse(vehicleItem
							.getPickup_Date()
							+ " "
							+ vehicleItem.getPickup_Time()));
					vehicle.setDropOffTime(sdfDateTime.parse(vehicleItem
							.getDropoff_Date()
							+ " "
							+ vehicleItem.getDropoff_Time()));
				} catch (Exception e) {
				}
				Price initialPrice = vehicle.getPrice();
				Price price = new Price();
				price.setOccpancyBasedPrice(vehicleItem.getTotal()
						.doubleValue());
				price.setPriceChanged(true);
				price.setTotalTax(vehicleItem.getTaxes().doubleValue());
				price.setInitialPrice(initialPrice);
				if (vehicleItem.getCommission_Prct() != null) {
					price.setCommissionPercent(vehicleItem.getCommission_Prct()
							.floatValue());
				}
				if (vehicleItem.getCommission() != null) {
					price.setCommissionAmount(vehicleItem.getCommission()
							.doubleValue());
				}
				vehicle.setPrice(price);
			}
		}
	}

	/**
	 * Method to parse Services pricing response
	 * 
	 * @param itemsMap
	 * @param serviceItemsList
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void parseServicesPricingResponse(Itinerary itinerary,
			HashMap<Byte, Object> itemsMap,
			HashMap<Service, List<Byte>> servicesMap,
			Yst_Ota_Ser_ItemsType_List serviceItemsList,
			Yst_Ota_Ser_ItemsType_List inputServicesList) {
		Iterator<Yst_Ota_Ser_ItemsType> iterator = serviceItemsList.iterator();
		ArrayList<Byte> serviceRPHList = new ArrayList<Byte>();
		while (iterator.hasNext()) {
			Yst_Ota_Ser_ItemsType serviceItemType = iterator.next();
			if (serviceItemType.getTotal() != null) {
				byte itemRph = Byte.parseByte(serviceItemType.getItem_Rph());
				serviceRPHList.add(itemRph);
				Object serviceObj = itemsMap.get(itemRph);
				if (serviceObj != null) {
					Service service = (Service) serviceObj;
					service.setTotalPrice(serviceItemType.getTotal()
							.doubleValue());
					service.setAdultPrice(serviceItemType.getPrice()
							.doubleValue());
					service.setChild1Price(serviceItemType.getPrice_C1()
							.doubleValue());
					service.setChild2Price(serviceItemType.getPrice_C2()
							.doubleValue());
					service.setChild3Price(serviceItemType.getPrice_C3()
							.doubleValue());
				}
			}
		}
		// Check whether the input and output services list sizes are same
		// If not, some of the services are dropped in R/3. So, remove them from
		// the list
		if (serviceItemsList.size() != inputServicesList.size()) {
			Iterator<Yst_Ota_Ser_ItemsType> inputIterator = inputServicesList
					.iterator();
			while (inputIterator.hasNext()) {
				Yst_Ota_Ser_ItemsType inputServiceItemType = inputIterator
						.next();
				byte inputItemRph = Byte.parseByte(inputServiceItemType
						.getItem_Rph());
				if (!serviceRPHList.contains(inputItemRph)) {
					itemsMap.remove(inputItemRph);
				}
			}
		}
		Set<Service> servicesSet = servicesMap.keySet();
		ListIterator<Service> servicesIterator = itinerary.getServices()
				.listIterator();
		while (servicesIterator.hasNext()) {
			// For each service, check whether the given service is exist in
			// ServiceMap or ItemsMap.
			// If it is not available in both places means, delete the service
			Service service = servicesIterator.next();
			if (servicesSet.contains(service)) {
				List<Byte> clonedServiceRphList = servicesMap.get(service);
				if (clonedServiceRphList != null) {
					// If the services are cloned, retrieve and set the price to
					// actual
					// service object
					double totalPrice = 0;
					boolean serviceExist = false;
					for (byte itemRph : clonedServiceRphList) {
						Object serviceObj = itemsMap.get(itemRph);
						if (serviceObj != null) {
							Service clonedService = (Service) serviceObj;
							totalPrice += clonedService.getTotalPrice();
							serviceExist = true;
						}
					}
					if (serviceExist) {
						service.setTotalPrice(totalPrice);
					} else {
						// If all the cloned objects are removed in R/3, delete
						// the service
						servicesIterator.remove();
					}
				}
			} else if ((!itemsMap.containsValue(service))
					&& (!(service.isMandatory() && service.isFree()))) {
				servicesIterator.remove();
			}
		}
		if (itinerary.getServices().size() == 0) {
			itinerary.setServices(null);
		}
	}

	private void updateHotelDisplayPrices(List<Hotel> hotels) {
		for (Hotel hotel : hotels) {
			double displayPrice = 0;
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				displayPrice += roomPrice.getPackagePrice();
			}
			if (hotel.getDisplayRoomCategory() != null && hotel.getDisplayRoomCategory().getDisplayRoomPrice()!=null) {
			hotel.getDisplayRoomCategory().getDisplayRoomPrice()
					.setTotalAmount(displayPrice);
		}
	}
	}

	/**
	 * Method to parse the Packages pricing response
	 * 
	 * @param packages
	 * 
	 * @see
	 * @since
	 */
	private void parsePackagesPricingResponse(List<Package> packages) {
		for (Package availablePackage : packages) {
			double packagePrice = 0;
			double perPersonPkgPrice = 0;
			double commissionPkgPrice = 0;
			double packageTax = 0;
			List<PaxTypePriceBreakup> paxTypeBreakupList = new ArrayList<PaxTypePriceBreakup>();
			/*
			if(availablePackage.getSelectedFlight() != null){
				TripFlight tripFlight = availablePackage.getSelectedFlight();
				packageTax +=tripFlight.getPrice().getTotalTax();
			}
			*/
			if (availablePackage.getSelectedHotel() != null) {
				// Air + Hotel, Air + Hotel + Car and Hotel + Car scenarios
				Hotel hotel = availablePackage.getSelectedHotel();				
				for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
					packagePrice += roomPrice.getPackagePrice();
					perPersonPkgPrice += roomPrice.getPerAdultBasePrice();
					if (roomPrice.getPaxTypePriceBreakups() != null) {
						paxTypeBreakupList.addAll(roomPrice
								.getPaxTypePriceBreakups());
					}
					if(roomPrice.getPaxTypePriceBreakups() != null && !roomPrice.getPaxTypePriceBreakups().isEmpty()){
						for (PaxTypePriceBreakup paxTypePriceBreakup : paxTypeBreakupList) {
							packageTax +=paxTypePriceBreakup.getTaxes()*paxTypePriceBreakup.getCount();
						}
						
					}
					commissionPkgPrice += roomPrice.getCommissionAmount();
				}
				
				
				
				Price price = availablePackage.getPrice();
				if (price == null) {
					price = new Price();
				}
				price.setPackagePrice(packagePrice);
				price.setPerAdultBasePrice(perPersonPkgPrice);
				price.setCommissionAmount(commissionPkgPrice);
				price.setPaxTypePriceBreakups(paxTypeBreakupList);
				price.setTotalTax(packageTax);
				price.setBasePrice(packagePrice-packageTax);
				availablePackage.setPrice(price);
			} else if (availablePackage.getSelectedFlight() != null) {
				// Air + Car scenario
				availablePackage.setPrice(availablePackage.getSelectedFlight()
						.getPrice());
			}
		}
	}

	/**
	 * Method to parse the Packages pricing response
	 * 
	 * @param packages
	 * 
	 * @see
	 * @since
	 */
	private void parseMultiDestPackagesPricingResponse(
			List<MultiDestinationPackage> multiDestPkgs) {
		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			Price price = new Price();
			// Prepare the Price break-up for multi-destination based on
			// SearchCriteria
			List<PaxTypePriceBreakup> paxTypePriceList = this.getPaxTypeFromSearchCriteria(multiDestPkg.getSearchCriteria());

			// Add Flights price
			if (multiDestPkg.getSelectedFlights() != null && !multiDestPkg.getSelectedFlights().isEmpty()) {
				for (TripFlight flight : multiDestPkg.getSelectedFlights()) {
					if (flight.getPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()+ flight.getPrice().getOccpancyBasedPrice()-flight.getPrice().getLateFee());
						price.setCommissionAmount(price.getCommissionAmount()+ flight.getPrice().getCommissionAmount());
						if(paxTypePriceList!=null){
							determineMultiDestFlightsPriceTypeBreakUp(flight.getPrice().getPaxTypePriceBreakups(),paxTypePriceList);
						}
					}
				}
			}
			// Add Hotels price
			if (multiDestPkg.getSelectedHotels() != null && !multiDestPkg.getSelectedHotels().isEmpty()) {
				// Sort PAX types by room
				if(paxTypePriceList!=null){
				Collections.sort(paxTypePriceList,new PaxTypePriceByRoomComparator());
				}

				for (Hotel hotel : multiDestPkg.getSelectedHotels()) {
					if (hotel.getDisplayRoomCategory() != null && hotel.getDisplayRoomCategory().getDisplayRoomPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()+ hotel.getDisplayRoomCategory().getDisplayRoomPrice().getTotalAmount()-hotel.getSelectedRooms().get(0).getLateFee());
						for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
							price.setCommissionAmount(price.getCommissionAmount()+ roomPrice.getCommissionAmount());
						}
					}
					if(paxTypePriceList!=null){
					determineMultiDestHotelPriceTypeBreakUp(hotel.getPreselectedRooms(), paxTypePriceList);
					}
				}
			}
			// Add Vehicles price
			if (multiDestPkg.getSelectedVehicles() != null && !multiDestPkg.getSelectedVehicles().isEmpty()) {
				for (Vehicle vehicle : multiDestPkg.getSelectedVehicles()) {
					if (vehicle.getPrice() != null) {
						price.setPackagePrice(price.getPackagePrice()+ vehicle.getPrice().getOccpancyBasedPrice());
						price.setCommissionAmount(price.getCommissionAmount()+ vehicle.getPrice().getCommissionAmount());
						if(paxTypePriceList!=null){
						//Method parameter changed and method modified for support Item #3620548
						determineMultiDestVehiclePriceTypeBreakUp(vehicle.getPrice(),paxTypePriceList);
						}
					}
				}
			}
			price.setPaxTypePriceBreakups(paxTypePriceList);			
			multiDestPkg.setPrice(price);
		}
	}

	/**
	 * Method to process the component level PAX type based price breakup
	 * 
	 * @param itemsMap
	 * @param itemPaxTypePriceList
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void parsePaxTypeComponentPricing(HashMap<Byte, Object> itemsMap,Yst_Ota_Items_Paxtype_PricingType_List itemPaxTypePriceList,List<GuestInfo> guests) {
		Iterator<Yst_Ota_Items_Paxtype_PricingType> itemPaxTypePriceIterator = itemPaxTypePriceList.iterator();
		byte currentItemRPH = 0;
		boolean isFirst = true;
		double lateFeeApplied=0;
		double totalLateFeeToBEApplied=0;
		
		List<PaxTypePriceBreakup> paxTypePriceList = null;		
		while (itemPaxTypePriceIterator.hasNext()) {
			Yst_Ota_Items_Paxtype_PricingType paxTypePrice = itemPaxTypePriceIterator.next();
			byte itemRPH = Byte.parseByte(paxTypePrice.getItem_Rph());
			//System.out.println("");
			totalLateFeeToBEApplied=calcualteGuestForLateFee(guests);
			if (isFirst) {
				currentItemRPH = itemRPH;
				isFirst = false;
				paxTypePriceList = new ArrayList<PaxTypePriceBreakup>();
			} else if (currentItemRPH != itemRPH) {
				Object itemObj = itemsMap.get(currentItemRPH);
				currentItemRPH = itemRPH;
				if (itemObj != null) {
					if (itemObj instanceof TripFlight) {
						TripFlight flight = (TripFlight) itemObj;
						if (flight.getPrice() != null) {
							flight.getPrice().setPaxTypePriceBreakups(paxTypePriceList);							
							lateFeeApplied+=calculateLate(flight,paxTypePriceList,lateFeeApplied,totalLateFeeToBEApplied);
						}
					} else if (itemObj instanceof RoomPrice) {
						RoomPrice roomPrice = (RoomPrice) itemObj;
						roomPrice.setPaxTypePriceBreakups(paxTypePriceList);
						lateFeeApplied+=caluculateLate(roomPrice,paxTypePriceList,lateFeeApplied,totalLateFeeToBEApplied);
					}
				}
				paxTypePriceList = new ArrayList<PaxTypePriceBreakup>();
			}
			
			PaxTypePriceBreakup priceBreakup = new PaxTypePriceBreakup();
			if (paxTypePrice.getPaxtype() != null) {
				priceBreakup.setPaxType(paxTypePrice.getPaxtype().charAt(0));
			}
			if (paxTypePrice.getGuestcount() != null) {
				priceBreakup.setCount(Integer.parseInt(paxTypePrice.getGuestcount()));
			}
			priceBreakup.setTaxes(paxTypePrice.getTaxes().doubleValue());
			priceBreakup.setPrice(paxTypePrice.getPrice_Per_Pax().doubleValue());
			priceBreakup.setUsTax(paxTypePrice.getUs_Tax().doubleValue());
			priceBreakup.setForeignTax(paxTypePrice.getForeign_Tax().doubleValue());
			priceBreakup.setAirportTax(paxTypePrice.getAirport_Fee().doubleValue());
			priceBreakup.setTotalAmount(paxTypePrice.getTotal().doubleValue());
			priceBreakup.setTypeRule(paxTypePrice.getChild_Rule_Desc());
			if (paxTypePrice.getMin_Age() != null && !"".equals(paxTypePrice.getMin_Age())) {
				priceBreakup.setMinAge(Byte.parseByte(paxTypePrice.getMin_Age()));
			}
			if (paxTypePrice.getMax_Age() != null && !"".equals(paxTypePrice.getMax_Age())) {
				priceBreakup.setMaxAge(Byte.parseByte(paxTypePrice.getMax_Age()));
			}
			paxTypePriceList.add(priceBreakup);
		}
		Object itemObj = itemsMap.get(currentItemRPH);
		if (itemObj != null) {
			if (itemObj instanceof TripFlight) {
				TripFlight flight = (TripFlight) itemObj;
				if (flight.getPrice() != null) {
					flight.getPrice().setPaxTypePriceBreakups(paxTypePriceList);
					lateFeeApplied+=calculateLate(flight,paxTypePriceList,lateFeeApplied,totalLateFeeToBEApplied);
				}
			} else if (itemObj instanceof RoomPrice) {
				RoomPrice roomPrice = (RoomPrice) itemObj;
				roomPrice.setPaxTypePriceBreakups(paxTypePriceList);
				lateFeeApplied+=caluculateLate(roomPrice,paxTypePriceList,lateFeeApplied,totalLateFeeToBEApplied);
			}
		}
	}
	
	private static double  calcualteGuestForLateFee(List<GuestInfo> guests){
		
		int totalLateFeeToBEApplied=0;
		for (Iterator iterator = guests.iterator(); iterator.hasNext();) {
			GuestInfo guestInfo = (GuestInfo) iterator.next();
			if(!guestInfo.getAgeCode().isLapChild())
				totalLateFeeToBEApplied+=10;			
		}
		return totalLateFeeToBEApplied;
	}
	private static double caluculateLate(RoomPrice roomPrice ,List<PaxTypePriceBreakup> paxTypePriceList,double lateFeeApplied,double totalLateFeeToBEApplied){
		
		double lateFee=0;		
		 java.util.Date departureDate=roomPrice.getCheckInDate();
		 Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
		 long duration=(DateUtils.dateDifferenceInDays(currentDate,departureDate));
		 for (Iterator iterator = paxTypePriceList.iterator(); iterator.hasNext();) {
			PaxTypePriceBreakup paxTypePriceBreakup = (PaxTypePriceBreakup) iterator.next();	
			if(paxTypePriceBreakup.getPaxType()!='L'){			 
				if(duration<14 && lateFeeApplied<totalLateFeeToBEApplied){
					int passengerCount=paxTypePriceBreakup.getCount();
					lateFee+=10*passengerCount;
					paxTypePriceBreakup.setPrice(paxTypePriceBreakup.getPrice()+10);
					paxTypePriceBreakup.setLateFee(10);
					paxTypePriceBreakup.setTotalAmount(paxTypePriceBreakup.getTotalAmount());					
			 }
		 }
			
	}
		//flight.getPrice().setOccpancyBasedPrice(flight.getPrice().getOccpancyBasedPrice()+lateFee);
		roomPrice.setTotalAmount(roomPrice.getTotalAmount()+lateFee);		
		roomPrice.setPackagePrice(roomPrice.getPackagePrice()+lateFee);		
		return lateFee;
	}
	
	private static double  calculateLate(TripFlight flight,List<PaxTypePriceBreakup> paxTypePriceList,double lateFeeApplied,double totalLateFeeToBEApplied){		
		double lateFee=0;		
		 java.util.Date departureDate=flight.getOutboundFlight().getDepartureTime();
		 Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
		 long duration=(DateUtils.dateDifferenceInDays(currentDate,departureDate));
		 for (Iterator iterator = paxTypePriceList.iterator(); iterator.hasNext();) {
			PaxTypePriceBreakup paxTypePriceBreakup = (PaxTypePriceBreakup) iterator.next();	
			if(paxTypePriceBreakup.getPaxType()!='L'){			 
				if(duration<14 && lateFeeApplied<totalLateFeeToBEApplied){
					int passengerCount=paxTypePriceBreakup.getCount();
					lateFee+=10*passengerCount;
					paxTypePriceBreakup.setPrice(paxTypePriceBreakup.getPrice()+10);
					paxTypePriceBreakup.setLateFee(10);					
					paxTypePriceBreakup.setTotalAmount(paxTypePriceBreakup.getTotalAmount());					
			 }
		 }
			
	}
		 flight.getPrice().setOccpancyBasedPrice(flight.getPrice().getOccpancyBasedPrice()+lateFee);
		
		return lateFee;
		
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

	/**
	 * 
	 * Construct the cancellation info/rules text
	 * 
	 * @param infoTypeList
	 * @param skedRulesTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private ItineraryCancellationRules parseCancellationRules(
			Yst_InfotextType_List infoTypeList,
			Yst_FarerulesType_List skedRulesTypeList) {
		ItineraryCancellationRules cancellationRules = new ItineraryCancellationRules();
		Iterator<Yst_InfotextType> infoIterator = infoTypeList.iterator();
		while (infoIterator.hasNext()) {
			Yst_InfotextType infoText = infoIterator.next();
			cancellationRules.addSkedInfoRules(infoText.getZzruletxt());
		}

		Iterator<Yst_FarerulesType> skedRulesIterator = skedRulesTypeList
				.iterator();
		while (skedRulesIterator.hasNext()) {
			Yst_FarerulesType skedRule = skedRulesIterator.next();
			cancellationRules.addSkedCancellationRules(skedRule.getText());
		}
		return cancellationRules;
	}

	/**
	 * Method to process the Itinerary header structure
	 * 
	 * @param pricingHeader
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private ItineraryPrice parseItineraryHeader(Yst_Order_HdrType pricingHeader) {
		ItineraryPrice price = new ItineraryPrice();
		price.setTotalPrice(pricingHeader.getTotal().doubleValue());
		price.setTotalTax(pricingHeader.getTaxes().doubleValue());
		price.setPromoSavings(pricingHeader.getPromo_Savings().doubleValue());
		price.setCurrency(pricingHeader.getCurrency());
		price.setDepositAmount(pricingHeader.getMindeposit_Amt().doubleValue());
		price.setDepositDate(pricingHeader.getDeposit_Dt());
		return price;
	}

	/**
	 * Method to construct PaxTypePriceBreakup structure from SearchCriteria
	 * 
	 * @param searchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<PaxTypePriceBreakup> getPaxTypeFromSearchCriteria(
			SearchCriteria searchCriteria) {
		if (searchCriteria == null || searchCriteria.getOccupancy() == null
				|| searchCriteria.getOccupancy().getPassengers() == null) {
			return null;
		}
		List<PaxTypePriceBreakup> paxTypeList = new ArrayList<PaxTypePriceBreakup>();
		for (Passenger passenger : searchCriteria.getOccupancy()
				.getPassengers()) {
			PaxTypePriceBreakup paxTypePriceBreakUp = new PaxTypePriceBreakup();
			paxTypePriceBreakUp.setPaxType(passenger.getAgeCode()
					.getPaxTypeCode());
			paxTypePriceBreakUp.setCount(passenger.getGuestCount());
			paxTypePriceBreakUp.setAge(passenger.getAge());
			paxTypePriceBreakUp.setRoomId(passenger.getRoomNumber());
			paxTypeList.add(paxTypePriceBreakUp);
		}
		// Sort the Pax Types based on type and ages
		Collections.sort(paxTypeList, new PaxTypePriceByTypeComparator());
		return paxTypeList;
	}

	/**
	 * Method to update the price type break up for multi destination flights
	 * 
	 * @param flightsPaxTypeList
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	private void determineMultiDestFlightsPriceTypeBreakUp(
			List<PaxTypePriceBreakup> flightsPaxTypeList,
			List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		if(flightsPaxTypeList == null || multiDestPaxTypeList == null)
			return;
		// Clone the current list
		List<PaxTypePriceBreakup> clonedList = clonePaxTypeBreakUpList(flightsPaxTypeList);
		for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
			if (clonedList.size() > 0) {
				PaxTypePriceBreakup flightPaxTypeBreakUp = clonedList.get(0);
				paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()+ flightPaxTypeBreakUp.getTaxes());
				paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()+ flightPaxTypeBreakUp.getPrice());
				paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()+ flightPaxTypeBreakUp.getUsTax());
				paxTypeBreakUp.setForeignTax(paxTypeBreakUp.getForeignTax()	+ flightPaxTypeBreakUp.getForeignTax());
				paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()	+ flightPaxTypeBreakUp.getAirportTax());
				paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()+ flightPaxTypeBreakUp.getTotalAmount());
				if (flightPaxTypeBreakUp.getCount() - paxTypeBreakUp.getCount() > 0) {
					flightPaxTypeBreakUp.setCount(flightPaxTypeBreakUp.getCount() - paxTypeBreakUp.getCount());
				} else {
					clonedList.remove(0);
				}
			}
		}
	}

	/**
	 * Method to update the price type break up for multi-destination hotels
	 * 
	 * @param selectedRooms
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	private void determineMultiDestHotelPriceTypeBreakUp(List<RoomPrice> selectedRooms,List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		for (RoomPrice roomPrice : selectedRooms) {
			byte roomId = roomPrice.getRoomId();
			List<PaxTypePriceBreakup> roomPaxTypeList = roomPrice.getPaxTypePriceBreakups();
			
			java.util.Date departureDate=roomPrice.getCheckInDate();
			 Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
			 long duration=(DateUtils.dateDifferenceInDays(currentDate,departureDate));

			// Clone the current list
			List<PaxTypePriceBreakup> clonedList = clonePaxTypeBreakUpList(roomPaxTypeList);
			for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
				if (paxTypeBreakUp.getRoomId() != roomId) {
					continue;
				}
				if (paxTypeBreakUp.getPaxType() == 'A') {
					// Process Adults
					ListIterator<PaxTypePriceBreakup> roomTypeIterator = clonedList.listIterator();
					while (roomTypeIterator.hasNext()) {
						PaxTypePriceBreakup roomPaxType = roomTypeIterator.next();
						if (roomPaxType.getPaxType() == 'A') {
							paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()+ roomPaxType.getTaxes());
							paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()+ roomPaxType.getPrice());
							paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()+ roomPaxType.getUsTax());
							paxTypeBreakUp.setForeignTax(paxTypeBreakUp	.getForeignTax()+ roomPaxType.getForeignTax());
							paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()	+ roomPaxType.getAirportTax());
							paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()+ roomPaxType.getTotalAmount());
							if(duration<14)
								paxTypeBreakUp.setLateFee(10);								
							if (roomPaxType.getCount()- paxTypeBreakUp.getCount() > 0) {
								roomPaxType.setCount(roomPaxType.getCount()	- paxTypeBreakUp.getCount());
							} else {
								roomTypeIterator.remove();
							}
							break;
						}
					}
				} else {
					// Process Childrens
					boolean childPricingExists = false;
					PaxTypePriceBreakup childPriceBreakUp = null;
					for (PaxTypePriceBreakup clonedPaxType : clonedList) {
						if (paxTypeBreakUp.getAge() >= clonedPaxType.getMinAge()&& paxTypeBreakUp.getAge() <= clonedPaxType	.getMaxAge()) {
							childPriceBreakUp = clonedPaxType;
							childPricingExists = true;
						}
					}
					if (!childPricingExists) {
						// Check for adults
						for (PaxTypePriceBreakup clonedPaxType : clonedList) {
							if (clonedPaxType.getPaxType() == 'A') {
								childPriceBreakUp = clonedPaxType;
								childPricingExists = true;
								break;
							}
						}
					}
					if (childPricingExists) {
						paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()+ childPriceBreakUp.getTaxes());
						paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()+ childPriceBreakUp.getPrice());
						paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()+ childPriceBreakUp.getUsTax());
						paxTypeBreakUp.setForeignTax(paxTypeBreakUp.getForeignTax()	+ childPriceBreakUp.getForeignTax());
						paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()+ childPriceBreakUp.getAirportTax());
						paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()+ childPriceBreakUp.getTotalAmount());
						if(duration<14 && paxTypeBreakUp.getPaxType() == 'L')
							paxTypeBreakUp.setLateFee(10);
						if (childPriceBreakUp.getCount()
								- paxTypeBreakUp.getCount() > 0) {
							childPriceBreakUp.setCount(childPriceBreakUp.getCount() - paxTypeBreakUp.getCount());
						} else {
							int index = clonedList.indexOf(childPriceBreakUp);
							clonedList.remove(index);
						}
					}
				}
			}
		}
	}

	/**
	 * Method to update the price type break up for multi-destination vehicles
	 * 
	 * @param paxTypeBreakUpList
	 * @param multiDestPaxTypeList
	 * 
	 * @see
	 * @since
	 */
	//Method parameter changed and method modified for support Item #3620548
	private void determineMultiDestVehiclePriceTypeBreakUp(
			Price vehiclePrice,
			List<PaxTypePriceBreakup> multiDestPaxTypeList) {
		int adultCount = 0;
		for (PaxTypePriceBreakup paxTypePriceBreakup : multiDestPaxTypeList) {
			if (paxTypePriceBreakup.getPaxType() == 'A') {
				adultCount += paxTypePriceBreakup.getCount();
			}
		}
		if (vehiclePrice.getPaxTypePriceBreakups()!= null
				&& vehiclePrice.getPaxTypePriceBreakups().size()>0)
		{
			PaxTypePriceBreakup vehiclePaxType = vehiclePrice.getPaxTypePriceBreakups().get(0);
			for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
				paxTypeBreakUp.setTaxes(paxTypeBreakUp.getTaxes()
						+ (vehiclePaxType.getTaxes() / adultCount));
				paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
						+ (vehiclePaxType.getPrice() / adultCount));
				paxTypeBreakUp.setUsTax(paxTypeBreakUp.getUsTax()
						+ (vehiclePaxType.getUsTax() / adultCount));
				paxTypeBreakUp.setForeignTax(paxTypeBreakUp.getForeignTax()
						+ (vehiclePaxType.getForeignTax() / adultCount));
				paxTypeBreakUp.setAirportTax(paxTypeBreakUp.getAirportTax()
						+ (vehiclePaxType.getAirportTax() / adultCount));
				paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()
						+ (vehiclePaxType.getTotalAmount() / adultCount));
			}
		}
		else{
			for (PaxTypePriceBreakup paxTypeBreakUp : multiDestPaxTypeList) {
				paxTypeBreakUp.setPrice(paxTypeBreakUp.getPrice()
						+ (vehiclePrice.getOccpancyBasedPrice() / adultCount));
				paxTypeBreakUp.setTotalAmount(paxTypeBreakUp.getTotalAmount()
						+ vehiclePrice.getOccpancyBasedPrice());
			}
		}
	}

	/**
	 * Method to clone the PaxTypeBreakUp List
	 * 
	 * @param paxTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<PaxTypePriceBreakup> clonePaxTypeBreakUpList(
			List<PaxTypePriceBreakup> paxTypeList) {
		if (paxTypeList == null || paxTypeList.size() == 0) {
			return null;
		}
		List<PaxTypePriceBreakup> returnList = new ArrayList<PaxTypePriceBreakup>();
		for (PaxTypePriceBreakup paxTypePriceBreakup : paxTypeList) {
			try {
				returnList.add((PaxTypePriceBreakup) paxTypePriceBreakup
						.clone());
			} catch (CloneNotSupportedException ex) {
			}
		}
		return returnList;
	}

	/**
	 * Method to update the deleted insurances to deleted list
	 * 
	 * @param insuranceList
	 * @param itinerary
	 * 
	 * @see
	 * @since
	 */
	private void updateDeletedInsuranceList(List<Insurance> insuranceList,
			Itinerary itinerary) {
		if (insuranceList == null) {
			return;
		}
		ArrayList<Insurance> actualList = new ArrayList<Insurance>();
		ArrayList<Insurance> deletedList = new ArrayList<Insurance>();
		for (Insurance insurance : insuranceList) {
			if (insurance.getGuestAllocationList() == null) {
				actualList.add(insurance);
			} else {
				List<InsuranceGuestAllocation> guestAllocationList = insurance
						.getGuestAllocationList();
				ListIterator<InsuranceGuestAllocation> allocationIterator = guestAllocationList
						.listIterator();
				ArrayList<InsuranceGuestAllocation> deletedAllocationList = new ArrayList<InsuranceGuestAllocation>();
				while (allocationIterator.hasNext()) {
					InsuranceGuestAllocation guestAllocaton = allocationIterator
							.next();
					if (guestAllocaton.getPosnr() != null
							&& !guestAllocaton.getPosnr().equals("000000")
							&& guestAllocaton.getPosnr().equals(
									guestAllocaton.getOldPosnr())) {
						deletedAllocationList.add(guestAllocaton);
						allocationIterator.remove();
					}
				}
				if (deletedAllocationList.size() == 0) {
					actualList.add(insurance);
				} else {
					try {
						Insurance clonedInsurance = (Insurance) insurance
								.clone();
						// Actual Insurance Update
						if (guestAllocationList.size() > 0) {
							insurance
									.setGuestAllocation(getPaxAllocationStr(guestAllocationList));
							insurance
									.setGuestAllocationList(guestAllocationList);
							actualList.add(insurance);
						}
						// Deleted Insurance Update
						clonedInsurance
								.setGuestAllocation(getPaxAllocationStr(deletedAllocationList));
						clonedInsurance
								.setGuestAllocationList(deletedAllocationList);
						deletedList.add(clonedInsurance);
					} catch (CloneNotSupportedException e) {
						actualList.add(insurance);
					}
				}
			}
		}
		if (actualList.size() > 0) {
			itinerary.setInsurances(actualList);
		} else {
			itinerary.setInsurances(null);
		}
		if (deletedList.size() > 0) {
			List<ABEDto> deletedItems = itinerary.getDeletedList();
			if (deletedItems == null) {
				deletedItems = new ArrayList<ABEDto>();
				itinerary.setDeletedList(deletedItems);
			}
			deletedItems.addAll(deletedList);
		}
	}

	/**
	 * Method to get the Guest Allocation String
	 * 
	 * @param guestAllocationList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private String getPaxAllocationStr(
			List<InsuranceGuestAllocation> guestAllocationList) {
		StringBuffer allocationStr = new StringBuffer();
		for (InsuranceGuestAllocation insuranceGuestAllocation : guestAllocationList) {
			allocationStr.append(insuranceGuestAllocation.getGuestID()).append(
					",");
		}
		if (allocationStr.length() > 1) {
			return allocationStr.substring(0, allocationStr.length() - 1);
		}
		return null;
	}

	/**
	 * Method to delete the Insurance from deleted list
	 * 
	 * @param itinerary
	 * 
	 * @see
	 * @since
	 */
	private void deleteInsuranceFromDeletedItems(Itinerary itinerary) {
		if (itinerary.getDeletedList() != null
				&& itinerary.getDeletedList().size() > 0) {
			ListIterator<ABEDto> listIterator = itinerary.getDeletedList()
					.listIterator();
			while (listIterator.hasNext()) {
				ABEDto object = listIterator.next();
				if (object instanceof Insurance) {
					listIterator.remove();
				}
			}
		}
	}

	/**
	 * Method to process the charters with stops and fill the stops information
	 * 
	 * @param itinerary
	 * 
	 * @see
	 * @since
	 */
	private void processChartersWithStops(Itinerary itinerary) {
		if (itinerary.getFlights() != null) {
			for (TripFlight tripFlight : itinerary.getFlights()) {
				updateFlightDetailsOfCharter(tripFlight);
			}
		}
		if (itinerary.getPackages() != null) {
			for (Package availablePackage : itinerary.getPackages()) {
				if (availablePackage.getSelectedFlight() != null) {
					updateFlightDetailsOfCharter(availablePackage
							.getSelectedFlight());
				}
			}
		}
	}

	/**
	 * Method to update stop details of the flight
	 * 
	 * @param tripFlight
	 * 
	 * @see
	 * @since
	 */
	private void updateFlightDetailsOfCharter(TripFlight tripFlight) {
		if (!tripFlight.getFlightType().isCharter()) {
			return;
		}
		boolean outBoundSeat  = false;
		boolean inBoundSeat = false;
		Long outboundContractId = null;
		Long inboundContractId = null;
		if(tripFlight.getOutboundFlight() != null)
		{
			outBoundSeat = tripFlight.getOutboundFlight().isSeatMapAvailable();
			outboundContractId = tripFlight.getOutboundFlight().getContractId();
		}
		if(tripFlight.getInboundFlight() != null)
		{
			inBoundSeat = tripFlight.getInboundFlight().isSeatMapAvailable();
			inboundContractId = tripFlight.getInboundFlight().getContractId();
		}
		byte outBoundStops = 0;
		if (tripFlight.getOutboundFlight() != null) {
			if (tripFlight.getOutboundFlight().getNoOfStops() != null) {
				outBoundStops = Byte.parseByte(tripFlight.getOutboundFlight()
						.getNoOfStops());
			}
		}
		byte inBoundStops = 0;
		if (tripFlight.getInboundFlight() != null) {
			if (tripFlight.getInboundFlight().getNoOfStops() != null) {
				inBoundStops = Byte.parseByte(tripFlight.getInboundFlight()
						.getNoOfStops());
			}
		}
		if (outBoundStops != (tripFlight.getOutboundFlight()
				.getFlightSegments().size() - 1)
				|| (tripFlight.getInboundFlight() != null && inBoundStops != (tripFlight
						.getInboundFlight().getFlightSegments().size() - 1))) {
			FlightInfoCriteria flightInfoCriteria = new FlightInfoCriteria();
			FlightSegment flightSegment = tripFlight.getOutboundFlight()
					.getFlightSegments().get(0);
			if (tripFlight.getOutboundFlight().getMaterial() != null) {
				flightInfoCriteria.setMaterial(tripFlight.getOutboundFlight()
						.getMaterial());
			} else {
				Material material = new Material();
				material.setMaterialNo(tripFlight.getOutboundFlight()
						.getGateway()
						+ tripFlight.getOutboundFlight().getDestination() + "C");
				SimpleDateFormat sdf = new SimpleDateFormat("MMddyy");
				StringBuffer batchNo = new StringBuffer();
				batchNo.append(sdf.format(tripFlight.getOutboundFlight()
						.getDepartureTime()));
				if (tripFlight.getDuration() < 10) {
					batchNo.append("0");
				}
				batchNo.append(tripFlight.getDuration());
				batchNo.append(flightSegment.getClassOfService());
				batchNo.append(flightSegment.getRotation());
				material.setBatchNo(batchNo.toString());
				flightInfoCriteria.setMaterial(material);
			}
			FlightInfoResponse flightInfoResponse = flightInfoDao
					.retrieveFlightInfo(flightInfoCriteria);
			if (!flightInfoResponse.isErrorsOccurred()
					&& flightInfoResponse.getTripFlight() != null) {
				TripFlight flightDetails = flightInfoResponse.getTripFlight();
				//CQ8827 : Code fix added for setting oldPosnr & posnr value for Inbound & Outbound Flight.
				Flight outboundFlight = updateSeatsAvailable(flightDetails.getOutboundFlight(),
															 flightSegment.getSeatsAvailable());
				Flight inboundFlight = updateSeatsAvailable(flightDetails.getInboundFlight(),
															flightSegment.getSeatsAvailable());
				if(outboundFlight !=null && tripFlight.getOutboundFlight()!=null){
					outboundFlight.setOldPosnr(tripFlight.getOutboundFlight().getOldPosnr());
					outboundFlight.setPosnr(tripFlight.getOutboundFlight().getPosnr());
				}
				if(inboundFlight !=null && tripFlight.getInboundFlight() !=null){
					inboundFlight.setOldPosnr(tripFlight.getInboundFlight().getOldPosnr());
					inboundFlight.setPosnr(tripFlight.getInboundFlight().getPosnr());
				}
				
				if(outboundFlight != null)
				{
					outboundFlight.setSeatMapAvailable(outBoundSeat);
					outboundFlight.setContractId(outboundContractId);
				}
				if(inboundFlight != null)
				{
					inboundFlight.setSeatMapAvailable(inBoundSeat);
					inboundFlight.setContractId(inboundContractId);
				}
				tripFlight.setOutboundFlight(outboundFlight);
				tripFlight.setInboundFlight(inboundFlight);
			}

		}
	}

	/**
	 * Method to update no. of seats available at each segment
	 * 
	 * @param flight
	 * @param seatAvailable
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Flight updateSeatsAvailable(Flight flight, byte seatAvailable) {
		if (flight == null) {
			return null;
		}
		for (FlightSegment flightSegment : flight.getFlightSegments()) {
			flightSegment.setSeatsAvailable(seatAvailable);
		}
		return flight;
	}
	
	/**
	 * Method to price a given PricingRequest
	 * 
	 * 
	 * @param pricingRequest
	 * @return
	 */
	public ItineraryPricingResponse priceItinerayThread(
			PricingRequest pricingRequest) {
		if(pricingRequest == null)
			return null;
		else
			return priceItinerary(pricingRequest.getItinerary());
	}
}
