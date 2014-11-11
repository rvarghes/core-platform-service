/*
 * HotelConvertUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 24, 2009  hguntupa
 * Jul 11, 2013  kahmed        Fixed the late fee calcualtion issue against 3787402 	
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.kcdata.abe.bapi.YfrfacntType;
import com.kcdata.abe.bapi.Yst_Htl_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_AmenityType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_AvailabilityType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_Req_AmenityType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_Vend_ServicesType;
import com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType;
import com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType;
import com.kcdata.abe.bapi.Zapi_VendaddrType;
import com.kcdata.abe.bapi.util.YfrfacntType_List;
import com.kcdata.abe.bapi.util.Yst_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.bapi.util.Zapi_VendaddrType_List;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.data.dao.HBSiHotelDao;
import com.kcdata.abe.data.dao.HBSiHotelDaoImpl;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.data.dto.CancelPolicy;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.DestinationService;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.HBSiRates;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.MealPlanType;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PaxTypeBasePrices;
import com.kcdata.abe.data.dto.ResortArea;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.VendorService;
import com.kcdata.abe.data.dto.Vendor;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.DateUtils;
import com.thoughtworks.xstream.converters.basic.DateConverter;

//import flex.messaging.io.amf.ASObject;
//import flex.messaging.io.amf.translator.ASTranslator;

/**
 * Utility class for conversions between SAP and Java objects
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelConvertUtils {
	
	private HBSiHotelDao hbsiHotelDao;
	
	private static HBSiHotelDao hbsiHotelDaoStatic;

	/**
	 * @return the hbsiHotelDao
	 */
	public HBSiHotelDao getHbsiHotelDao() {
		return hbsiHotelDao;
	}

	public void init() {
		hbsiHotelDaoStatic = this.hbsiHotelDao;
		
	}
	
	/**
	 * @param hbsiHotelDao the hbsiHotelDao to set
	 */
	public void setHbsiHotelDao(HBSiHotelDao hbsiHotelDao) {
		this.hbsiHotelDao = hbsiHotelDao;
		
	}

	/**
	 * Method prepares hotel search request options
	 * 
	 * @param hotelsRequest
	 *            HotelsRequest
	 * @return Yst_Ota_Htl_ReqType
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Htl_ReqType[] prepareRequestOptions(
			HotelsRequest hotelsRequest) {
		// Prepare hotel availability request header criteria
		Yst_Ota_Htl_ReqType[] hotelAvailabilityRequest = new Yst_Ota_Htl_ReqType[1];
		hotelAvailabilityRequest[0] = new Yst_Ota_Htl_ReqType();
		hotelAvailabilityRequest[0].setItem_Rph("1");
		hotelAvailabilityRequest[0].setArr_Date(new java.sql.Date(hotelsRequest
				.getDepartureDate().getTime()));
		Calendar calDeparture = Calendar.getInstance();
		calDeparture.setTime(hotelsRequest.getDepartureDate());
		calDeparture.add(Calendar.DATE, hotelsRequest.getNoOfNights());
		hotelAvailabilityRequest[0].setDep_Date(new java.sql.Date(calDeparture
				.getTime().getTime()));
		hotelAvailabilityRequest[0].setOrigin_Location(hotelsRequest
				.getGateway());
		hotelAvailabilityRequest[0].setHotel_City_Code(hotelsRequest
				.getDestination());

		// Check for any additional hotel option criteria
		HotelOptions hotelOptions = hotelsRequest.getHotelOptions();

		if (hotelOptions != null) {
			// Set apple rating filter, if input
			if (hotelOptions.getAppleRating() != null) {
				hotelAvailabilityRequest[0].setRating(hotelOptions
						.getAppleRating());
			}
			// Set hotel chain filter, if input
			if (hotelOptions.getHotelChain() != null) {
				hotelAvailabilityRequest[0].setHotel_Chain(hotelOptions
						.getHotelChain());
			}
			// Set resort area filter, if input
			if (hotelOptions.getResortArea() != null
					&& hotelOptions.getResortArea().getResortAreaCode() != null) {
				hotelAvailabilityRequest[0].setResort_Area(hotelOptions
						.getResortArea().getResortAreaCode());
			}
			// Set hotel name filter, if input
			if (hotelOptions.getHotelName() != null) {
				hotelAvailabilityRequest[0]
						.setName(hotelOptions.getHotelName());
			}
			// Set required no of rooms
			if (hotelOptions.getNoOfRooms() > 0) {
				hotelAvailabilityRequest[0].setNo_Of_Rooms(new Integer(
						hotelOptions.getNoOfRooms()).shortValue());
			}

			// Set Hotel Code
			hotelAvailabilityRequest[0].setHotel_Code(hotelOptions
					.getHotelCode());
			// Set GDS Hotel Code
			if(hotelOptions.getGdsHotelCode() != null)
			hotelAvailabilityRequest[0].setGds_Hotel_Code(hotelOptions
					.getGdsHotelCode());
					
			//CQ8865- Set Hotel RatePlanCode
			if(hotelOptions.getRatePlanCode() !=null){
			 hotelAvailabilityRequest[0].setRateplancode(hotelOptions.getRatePlanCode());
			}
			if(hotelOptions.getRoomTypeCode() !=null){
				 hotelAvailabilityRequest[0].setRoomtypecode(hotelOptions.getRoomTypeCode());
				}
			
		} // End of hotel options criteria if
		return hotelAvailabilityRequest;
	}

	/**
	 * Method sets the room occupancy criteria for hotel availability BAPI input
	 * 
	 * @param roomOccupancy
	 *            Occupancy
	 * @return Yst_Ota_RoomstaycandidatesType_List
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_RoomstaycandidatesType_List prepareRoomOccupancy(
			Occupancy roomOccupancy) {

		Yst_Ota_RoomstaycandidatesType_List occupancyList = new Yst_Ota_RoomstaycandidatesType_List();
		if (roomOccupancy == null || roomOccupancy.getPassengers() == null)
			return occupancyList;

		Iterator<Passenger> itPassengers = roomOccupancy.getPassengers()
				.iterator();

		while (itPassengers.hasNext()) {
			Passenger passenger = itPassengers.next();
			Yst_Ota_RoomstaycandidatesType occupancy = new Yst_Ota_RoomstaycandidatesType();
			// Item RPH indicates the identifier for the destination
			occupancy.setItem_Rph("1");
			occupancy.setRoom_Rph(new Integer(passenger.getRoomNumber())
					.toString());
			// Age code possible values: 7-Infant, 8-Child, 10-Adult, 11-Senior
			// Conversion of Infant/Lap Child code to Child type will be taken
			// care in SAP
			occupancy.setAgequalifyingcode(new Integer(passenger.getAgeCode()
					.getAgeCode()).toString());
			// Age will be specified only in case of child PAX
			// Age will be set to "1" for Infant/Lap Child
			if (passenger.getAgeCode().isChild()) {
				occupancy.setAge(new Integer(passenger.getAge()).toString());
			} else if (passenger.getAgeCode().isInfant()
					|| passenger.getAgeCode().isLapChild()) {
				occupancy.setAge("1");
			}
			occupancy.setGuestcount(new Integer(passenger.getGuestCount())
					.toString());
			occupancyList.add(occupancy);
		} // End of while
		return occupancyList;
	}

	/**
	 * Method prepares amenity search request options
	 * 
	 * @param hotelOptions
	 *            HotelOptions
	 * @return Yst_Ota_Htl_Req_AmenityType_List
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Htl_Req_AmenityType_List prepareAmenityOptions(
			HotelOptions hotelOptions) {
		Yst_Ota_Htl_Req_AmenityType_List amenityList = new Yst_Ota_Htl_Req_AmenityType_List();
		// Prepare & set amenity filters
		if (hotelOptions != null && hotelOptions.getAmenities() != null
				&& !hotelOptions.getAmenities().isEmpty()) {
			Iterator<Amenity> itAmenities = hotelOptions.getAmenities()
					.iterator();
			while (itAmenities.hasNext()) {
				Amenity amenity = itAmenities.next();
				Yst_Ota_Htl_Req_AmenityType amenityType = new Yst_Ota_Htl_Req_AmenityType();
				amenityType.setItem_Rph("1");
				amenityType.setAmenity_Code(amenity.getAmenityCode());
				amenityType.setAmenity_Value("Y");
				amenityList.add(amenityType);
			} // End of while
		} // End of amenity filters criteria
		return amenityList;
	}

	/**
	 * Method processes the hotel availability BAPI response and builds hotel
	 * data
	 * 
	 * @param bapiOutput
	 *            BAPI response
	 * @param hotelResponse
	 *            Hotel response object to hold hotels data
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Hotel> parseHotelAvailability(
			HotelsRequest hotelRequest,
			Yst_Ota_Htl_InfoType_List hotelInfoList,
			Yst_Ota_Htl_AvailabilityType_List hotelAvailabilityList,
			Yst_Ota_Htl_Room_PricingType_List roomPricingList,
			Yst_Ota_Htl_AmenityType_List hotelAmenityList,
			Yst_Ota_Htl_Vend_ServicesType_List hotelVendorServicesList) {

		if (hotelInfoList == null || hotelInfoList.isEmpty()) {
			return null;
		}
		HotelOptions hotelOptions = hotelRequest.getHotelOptions();

		// Prepare hotels list
		HashMap<String, Hotel> hotelMap = prepareHotelData(hotelInfoList,
				hotelRequest);
		// Prepare room category list
		HashMap<String, HashMap<String, RoomCategory>> hotelRoomCatMap = prepareRoomCategoryData(hotelAvailabilityList);
		// Set room price data to hotel & room category
		setRoomPriceData(hotelMap, hotelRoomCatMap, roomPricingList,
				hotelOptions.getNoOfRooms(), hotelRequest.isPackageRequest());

		// Set hotel room category amenity data
		setRoomCategoryAmenityData(hotelMap, hotelRoomCatMap, hotelAmenityList);

		// Set hotel based services data
		setHotelServicesData(hotelMap, hotelVendorServicesList);

		// Sort hotels based on price
		ArrayList<Hotel> hotelList = new ArrayList(hotelMap.values());
		// Sort all hotels based on least room category prices
		sortHotels(hotelList, hotelRequest.isPackageRequest());

		// Return sorted hotel data
		return hotelList;
	}

	/**
	 * Method prepares hotel data from BAPI response
	 * 
	 * @param hotelsList
	 *            Hotel list from BAPI
	 * @param hotelRequest
	 *            Hotel search request options
	 * @return Hotels map
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static HashMap<String, Hotel> prepareHotelData(
			Yst_Ota_Htl_InfoType_List hotelsList, HotelsRequest hotelRequest) {
		HashMap<String, Hotel> hotelsMap = new HashMap<String, Hotel>();
		// Parse & prepare hotel data
		Iterator<Yst_Ota_Htl_InfoType> itHotelInfo = hotelsList.iterator();
		while (itHotelInfo.hasNext()) {
			// Parse each hotel row
			Yst_Ota_Htl_InfoType hotelInfoRow = itHotelInfo.next();
			Hotel hotel = new Hotel();
			hotel.setOriginLocation(hotelRequest.getGateway());
			hotel
					.setHotelId(new Integer(hotelInfoRow.getItem_Rph())
							.intValue());
			hotel.setHotelName(hotelInfoRow.getName());
			hotel.setAppleRating(hotelInfoRow.getRating());
			hotel.setHotelCode(hotelInfoRow.getHotel_Code());
			hotel.setHotelChain(hotelInfoRow.getHotel_Chain());
			hotel.setCheckInDate(hotelInfoRow.getArr_Date());
			hotel.setCheckOutDate(hotelInfoRow.getDep_Date());
			hotel.setMinRate(hotelInfoRow.getMin_Rate().doubleValue());
			hotel.setCurrency(hotelInfoRow.getCurrency());
			hotel.setOccupancy(hotelRequest.getOccupancy());
			hotel.setHotelCityCode(hotelRequest.getDestination());
			hotel.setGdsHotelCode(hotelInfoRow.getGds_Hotel_Code());			
			// Set resort area
			if (hotelInfoRow.getResort_Area() != null) {
				ResortArea resortArea = new ResortArea();
				resortArea.setResortAreaCode(hotelInfoRow.getResort_Area());
				resortArea.setResortAreaName(hotelInfoRow.getResort_Area());
				hotel.setResortArea(resortArea);
			}
			hotelsMap.put(hotelInfoRow.getItem_Rph(), hotel);
		}
		return hotelsMap;
	}

	/**
	 * Method prepares room category data from BAPI response
	 * 
	 * @param roomCategoryList
	 *            Room category list from BAPI
	 * @return Room category map
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static HashMap<String, HashMap<String, RoomCategory>> prepareRoomCategoryData(
			Yst_Ota_Htl_AvailabilityType_List roomCategoryList) {
		// Map to hold hotel room data
		HashMap<String, HashMap<String, RoomCategory>> hotelRoomCatMap = new HashMap<String, HashMap<String, RoomCategory>>();
		// Parse room category data
		if (roomCategoryList != null && !roomCategoryList.isEmpty()) {
			Iterator<Yst_Ota_Htl_AvailabilityType> itRoomCategory = roomCategoryList
					.iterator();
			while (itRoomCategory.hasNext()) {
				Yst_Ota_Htl_AvailabilityType roomCategoryRow = itRoomCategory
						.next();
				RoomCategory roomCategory = new RoomCategory();
				roomCategory.setHotelId(new Integer(roomCategoryRow
						.getItem_Rph()).intValue());
				roomCategory.setRoomCategoryId(new Integer(roomCategoryRow
						.getRoom_Cat_Rph()).intValue());
				roomCategory.setRoomTypeCode(roomCategoryRow.getRoomtypecode());
				roomCategory.setRoomTypeDescription(roomCategoryRow
						.getRoom_Type_Desc());
				roomCategory.setRatePlanId(roomCategoryRow.getRate_Plan_Id());
				roomCategory.setRatePlanCode(roomCategoryRow.getRateplancode());
				roomCategory.setRatePlanDescription(roomCategoryRow
						.getRate_Plan_Desc());
				roomCategory.setRateIndicator(roomCategoryRow
						.getRateindicator());
				roomCategory.setCorporateId(roomCategoryRow.getCorpinfo_Code());
				roomCategory.setGuaranteeType(roomCategoryRow
						.getGuarantee_Type());
				roomCategory.setGuaranteeMethod(roomCategoryRow
						.getGuarantee_Method());
				roomCategory.setGuaranteeRequired(roomCategoryRow
						.getGuarantee_Req());
				roomCategory.setGuaranteeAmount(roomCategoryRow
						.getGuarantee_Amount().doubleValue());
				roomCategory.setRatePlanCategory(roomCategoryRow
						.getRate_Plan_Catg());
				if (roomCategoryRow.getAvail_Rooms() != null
						&& !"".equals(roomCategoryRow.getAvail_Rooms())) {
					roomCategory.setNoOfRoomsAvailable(new Integer(
							roomCategoryRow.getAvail_Rooms()).intValue());
				}
				roomCategory.setStatus(roomCategoryRow.getStatus());
				roomCategory.setCurrency(roomCategoryRow.getCurrency());
				// MealPlan Code
				if(roomCategoryRow.getMeal_Info()!= null && !(roomCategoryRow.getMeal_Info().trim().equals(""))){
					roomCategory.setMealPlanType(MealPlanType
							.getMealPlanType(roomCategoryRow.getMeal_Info()));
					roomCategory.setMealplanDesc(MealPlanType.getMealPlanType(roomCategoryRow.getMeal_Info()).getDescription());
				}
				if ("Y".equals(roomCategoryRow.getRisk())) {
					roomCategory.setRiskRoomCategory(true);
				}

				// Setting Apple Choice value to room Category.
				if (roomCategoryRow.getApple_Choice() != null
						&& !"".equalsIgnoreCase(roomCategoryRow
								.getApple_Choice())
						&& ABEConstants.appleSavers.contains(roomCategoryRow
								.getApple_Choice().toUpperCase())) {
					roomCategory.setAppleChoice(true);
				} else {
					roomCategory.setAppleChoice(false);
				}

				String hotelKey = roomCategoryRow.getItem_Rph();
				String roomCatKey = roomCategoryRow.getItem_Rph()
						+ roomCategoryRow.getRoom_Cat_Rph();
				// Create/update rooms map with current room category
				HashMap<String, RoomCategory> roomCatsMap = hotelRoomCatMap
						.get(hotelKey);
				if (roomCatsMap == null) {
					roomCatsMap = new HashMap<String, RoomCategory>();
				}
				roomCatsMap.put(roomCatKey, roomCategory);
				hotelRoomCatMap.put(hotelKey, roomCatsMap);
			} // End of room category while
		} // End of room category if
		return hotelRoomCatMap;
	}

	/**
	 * Method sets rooms data to respective room category & hotel
	 * 
	 * @param hotelMap
	 *            Hotel list
	 * @param hotelRoomCatMap
	 *            Room category list
	 * @param roomsList
	 *            Room data
	 * @param noOfRooms
	 *            No of rooms selected during search
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static void setRoomPriceData(HashMap<String, Hotel> hotelMap,
			HashMap<String, HashMap<String, RoomCategory>> hotelRoomCatMap,
			Yst_Ota_Htl_Room_PricingType_List roomsList, int noOfRooms,
			boolean isPackage) {
		if (roomsList != null && !roomsList.isEmpty()) {
			ArrayList[] roomsArray = new ArrayList[noOfRooms];
			// Parse room price data
			Iterator<Yst_Ota_Htl_Room_PricingType> itRoomPricing = roomsList.iterator();
			int prevHotelId = 0;
			String prevHotelKey = "";
			while (itRoomPricing.hasNext()) {
				Yst_Ota_Htl_Room_PricingType roomPricingRow = itRoomPricing.next();
				String hotelKey = roomPricingRow.getItem_Rph();
				String roomCatKey = roomPricingRow.getItem_Rph()+ roomPricingRow.getRoom_Cat_Rph();

				RoomPrice roomPrice = new RoomPrice();

				int hotelId = new Integer(roomPricingRow.getItem_Rph()).intValue();
				if (prevHotelId == 0)
					prevHotelId = hotelId;
				if (prevHotelKey == "")
					prevHotelKey = hotelKey;
				// Reset rooms map for each hotel
				if (prevHotelId != hotelId) {
					// Sort rooms array list to identify least priced room
					// category for this hotel
					setLeastRoomCategory(hotelMap, prevHotelKey, roomsArray,isPackage);
					roomsArray = new ArrayList[noOfRooms];
					prevHotelId = hotelId;
					prevHotelKey = hotelKey;
				}
				roomPrice.setHotelId(hotelId);
				// Per Adult Base Price...
				roomPrice.setPerAdultBasePrice(roomPricingRow.getPer_Adult_Base_Price().doubleValue());
				roomPrice.setPerAdultBasePriceSavings(roomPricingRow.getPer_Adult_Savings().doubleValue());
				roomPrice.setRoomCategoryId(new Integer(roomPricingRow.getRoom_Cat_Rph()).intValue());
				byte roomNo = new Byte(roomPricingRow.getRoom_Rph()).byteValue();
				roomPrice.setRoomId(roomNo);
				roomPrice.setTotalAmount(roomPricingRow.getTotal().doubleValue());
				roomPrice.setTax(roomPricingRow.getTaxes().doubleValue());
				//Start the fix of 3787402 (Late fee calculation issue).
				//If DepartureDate diff with CurrentDate < 14 then lateFee should be deducted. (Each passenger =10.0 $ )
				Date checkInDate = hotelMap.get(prevHotelKey).getCheckInDate();
				Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
				long duration = (DateUtils.dateDifferenceInDays(currentDate, checkInDate));
				if (duration<14){
					int passengerCount=Integer.valueOf(roomPricingRow
									  .getNo_Adults()+(roomPricingRow
									  .getNo_Child())+roomPricingRow
								      .getNo_Infants());
					double lateFee=passengerCount*10;
					if (lateFee>0.0){
						lateFee=10;
					}
					roomPrice.setLateFee(lateFee);
				}
				//End of the fix 3787402
				roomPrice.setFreeNights(new Integer(roomPricingRow.getFree_Nights()).intValue());
				roomPrice.setPromoSavingsAmount(roomPricingRow.getPromo_Savings().doubleValue());
				roomPrice.setSavings(roomPricingRow.getSavings().doubleValue());
				roomPrice.setCurrency(roomPricingRow.getCurrency());
				// Set the PAX base prices
				PaxTypeBasePrices paxTypeBasePrices = new PaxTypeBasePrices();
				paxTypeBasePrices.setNoOfAdults(roomPricingRow.getNo_Adults());
				paxTypeBasePrices.setNoOfChilds(roomPricingRow.getNo_Child());
				paxTypeBasePrices.setNoOfInfants(roomPricingRow.getNo_Infants());
				paxTypeBasePrices.setNoOfJuniors(roomPricingRow.getNo_Juniors());
				paxTypeBasePrices.setNoOfLapChilds(roomPricingRow.getNo_Lapchild());
				paxTypeBasePrices.setNoOfMinors(roomPricingRow.getNo_Minors());
				paxTypeBasePrices.setNoOfSeniors(roomPricingRow.getNo_Seniors());
				paxTypeBasePrices.setChild1Age(roomPricingRow.getChild1_Age());
				paxTypeBasePrices.setChild2Age(roomPricingRow.getChild2_Age());
				paxTypeBasePrices.setChild3Age(roomPricingRow.getChild3_Age());
				paxTypeBasePrices.setChild4Age(roomPricingRow.getChild4_Age());
				paxTypeBasePrices.setChild5Age(roomPricingRow.getChild5_Age());
				paxTypeBasePrices.setChild6Age(roomPricingRow.getChild6_Age());
				paxTypeBasePrices.setChild1Type(roomPricingRow.getChild1_Type());
				paxTypeBasePrices.setChild2Type(roomPricingRow.getChild2_Type());
				paxTypeBasePrices.setChild3Type(roomPricingRow.getChild3_Type());
				paxTypeBasePrices.setChild4Type(roomPricingRow.getChild4_Type());
				paxTypeBasePrices.setChild5Type(roomPricingRow.getChild5_Type());
				paxTypeBasePrices.setChild6Type(roomPricingRow.getChild6_Type());
				paxTypeBasePrices.setAdultBasePrice(roomPricingRow.getAdult_Base_Price().doubleValue());
				paxTypeBasePrices.setChildBasePrice(roomPricingRow.getChild_Base_Price().doubleValue());
				paxTypeBasePrices.setSeniorBasePrice(roomPricingRow.getSenior_Base_Price().doubleValue());
				paxTypeBasePrices.setJuniorBasePrice(roomPricingRow.getJunior_Base_Price().doubleValue());
				paxTypeBasePrices.setMinorBasePrice(roomPricingRow.getMinor_Base_Price().doubleValue());
				roomPrice.setPaxBasePrices(paxTypeBasePrices);

				if (roomPricingRow.getPkg_Total() != null) {
					roomPrice.setPackagePrice(roomPricingRow.getPkg_Total().doubleValue());
				}

				// Update respective room object with price information
				HashMap<String, RoomCategory> roomCatsMap = hotelRoomCatMap.get(hotelKey);
				RoomCategory roomCategory = roomCatsMap.get(roomCatKey);
				
				if (roomCategory != null) {
					// Begin: Update room array list for determining
					// cheapest room category
					if (roomsArray[roomNo - 1] == null)
						roomsArray[roomNo - 1] = new ArrayList();
					RoomCategory displayRoomCategory = new RoomCategory();
					BeanUtils.copyProperties(roomCategory, displayRoomCategory);
					RoomPrice dispRoomPrice = new RoomPrice();
					BeanUtils.copyProperties(roomPrice, dispRoomPrice);
					displayRoomCategory.setDisplayRoomPrice(dispRoomPrice);
					roomsArray[roomNo - 1].add(displayRoomCategory);
					// End: Update room array list for determining cheapest
					// room category

					ArrayList<RoomPrice> roomPriceList = (ArrayList<RoomPrice>) roomCategory.getRoomPrices();
					if (roomPriceList == null)
						roomPriceList = new ArrayList<RoomPrice>();
					roomPriceList.add(roomPrice);
					roomCategory.setRoomPrices(roomPriceList);
					List<String> packageTotal=new ArrayList<String>();
					packageTotal.add(roomPricingRow.getPkg_Total().toString());
					roomCategory.setRoomPrices2(packageTotal);
					roomCatsMap.put(roomCatKey, roomCategory);
					// Update respective hotel entry with room data
					Hotel hotel = hotelMap.get(hotelKey);
					hotel.setRoomCategories(new ArrayList<RoomCategory>(roomCatsMap.values()));
					// Setting rooms array to hotel
					hotelMap.put(hotelKey, hotel);
					if (!itRoomPricing.hasNext()) {
						setLeastRoomCategory(hotelMap, hotelKey, roomsArray,isPackage);
					}
				}
			} // End of room price while
		} // End of room price if
	}

	/**
	 * Method prepares hotel based services data
	 * 
	 * @param hotelMap
	 *            Hotel list
	 * @param hotelServicesList
	 *            Hotel services list
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static void setHotelServicesData(HashMap<String, Hotel> hotelMap,
			Yst_Ota_Htl_Vend_ServicesType_List hotelVendorServicesList) {
		if (hotelVendorServicesList == null
				|| hotelVendorServicesList.isEmpty()) {
			return;
		}
		Iterator<Yst_Ota_Htl_Vend_ServicesType> itVendServices = hotelVendorServicesList
				.iterator();

		while (itVendServices.hasNext()) {
			Yst_Ota_Htl_Vend_ServicesType vendSerivcesRow = itVendServices
					.next();
			VendorService vendorService = new VendorService();
			vendorService
					.setVendorId(new Integer(vendSerivcesRow.getItem_Rph())
							.intValue());
			vendorService.setServiceCode(vendSerivcesRow.getCode());
			vendorService.setServiceName(vendSerivcesRow.getService_Name());
			vendorService.setPrice(vendSerivcesRow.getPrice().doubleValue());
			vendorService.setCurrency(vendSerivcesRow.getCurrency());

			String hotelKey = vendSerivcesRow.getItem_Rph();
			// Update respective hotel entry with room data
			Hotel hotel = hotelMap.get(hotelKey);
			// Update respective hotel object with vendor service data
			ArrayList<VendorService> vendServiceList = (ArrayList<VendorService>) hotel
					.getVendorServices();
			if (vendServiceList == null)
				vendServiceList = new ArrayList<VendorService>();
			vendServiceList.add(vendorService);
			hotel.setVendorServices(vendServiceList);
			hotelMap.put(hotelKey, hotel);
		} // End of hotel vendor services while
	}

	/**
	 * Method prepares room category based amenities
	 * 
	 * @param hotelMap
	 *            Hotels list
	 * @param hotelRoomCatMap
	 *            Room categories list
	 * @param roomCategoryAmenityList
	 *            Amenity list
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static void setRoomCategoryAmenityData(
			HashMap<String, Hotel> hotelMap,
			HashMap<String, HashMap<String, RoomCategory>> hotelRoomCatMap,
			Yst_Ota_Htl_AmenityType_List roomCategoryAmenityList) {
		if (roomCategoryAmenityList == null
				|| roomCategoryAmenityList.isEmpty()) {
			return;
		}
		Iterator<Yst_Ota_Htl_AmenityType> itRoomCatAmenity = roomCategoryAmenityList
				.iterator();

		while (itRoomCatAmenity.hasNext()) {
			Yst_Ota_Htl_AmenityType roomCatAmenityRow = itRoomCatAmenity.next();
			Amenity roomCatAmenity = new Amenity();
			roomCatAmenity.setHotelId(new Integer(roomCatAmenityRow
					.getItem_Rph()).intValue());
			roomCatAmenity.setRoomCategoryId(new Integer(roomCatAmenityRow
					.getRoom_Cat_Rph()).intValue());
			roomCatAmenity.setAmenityCode(roomCatAmenityRow.getAmenity_Code());
			roomCatAmenity.setAmenityName(roomCatAmenityRow.getAmenity_Name());
			// Date until which amenity is offered
			if (roomCatAmenityRow.getAmenity_Date() != null) {
				roomCatAmenity.setAmenityDate(roomCatAmenityRow
						.getAmenity_Date());
			}
			roomCatAmenity
					.setAmenityValue(roomCatAmenityRow.getAmenity_Value());

			String hotelKey = roomCatAmenityRow.getItem_Rph();
			String roomCatKey = roomCatAmenityRow.getItem_Rph()
					+ roomCatAmenityRow.getRoom_Cat_Rph();
			// Update respective room object with price information
			HashMap<String, RoomCategory> roomCatsMap = hotelRoomCatMap
					.get(hotelKey);
			RoomCategory roomCategory = roomCatsMap.get(roomCatKey);
			ArrayList<Amenity> amenityList = (ArrayList<Amenity>) roomCategory
					.getAmenities();
			if (amenityList == null)
				amenityList = new ArrayList<Amenity>();
			amenityList.add(roomCatAmenity);
			roomCategory.setAmenities(amenityList);
			roomCatsMap.put(roomCatKey, roomCategory);
			// Update respective hotel entry with room data
			Hotel hotel = hotelMap.get(hotelKey);
			hotel.setRoomCategories(new ArrayList<RoomCategory>(roomCatsMap
					.values()));
			hotelMap.put(hotelKey, hotel);
		} // End of room category amenity loop
	}

	/**
	 * Method determines low cost room category for each room of the hotel
	 * 
	 * @param hotelMap
	 *            Hotels map
	 * @param hotelKey
	 *            Hotel key for setting least priced room category
	 * @param roomsArray
	 *            Rooms array
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static void setLeastRoomCategory(HashMap<String, Hotel> hotelMap,
			String hotelKey, ArrayList[] roomsArray, boolean isPackage) {
		Hotel hotel = hotelMap.get(hotelKey);
		// Sort rooms array list to identify low cost room category for this
		// hotel
		ArrayList<RoomPrice> preselectedRooms = new ArrayList<RoomPrice>();
		for (int roomIndex = 0; roomIndex < roomsArray.length; roomIndex++) {
			Collections.sort(roomsArray[roomIndex], new RoomCategoryComparator(
					isPackage));
			RoomCategory roomCategory = new RoomCategory();
			for(int i=0;i<roomsArray[roomIndex].size();i++){
				roomCategory = (RoomCategory) roomsArray[roomIndex].get(i);
				if(roomCategory.getNoOfRoomsAvailable()>0){//if room is not available then select best available room
					break;
				}else{
					roomCategory = (RoomCategory) roomsArray[roomIndex].get(0);
				}
			}
			 
			RoomCategory displayRoomCategory = new RoomCategory();
			RoomPrice displayRoomPrice = new RoomPrice();
			if (roomIndex == 0) {
				BeanUtils.copyProperties(roomCategory, displayRoomCategory);
				hotel.setDisplayRoomCategory(displayRoomCategory);
				BeanUtils.copyProperties(displayRoomCategory
						.getDisplayRoomPrice(), displayRoomPrice);
				// Update preselected rooms with current room
				preselectedRooms.add(displayRoomPrice);
			} else {
				BeanUtils.copyProperties(hotel.getDisplayRoomCategory(),
						displayRoomCategory);
				BeanUtils.copyProperties(displayRoomCategory
						.getDisplayRoomPrice(), displayRoomPrice);
				if (!roomCategory.getRoomTypeDescription().equalsIgnoreCase(
						displayRoomCategory.getRoomTypeDescription()))
					displayRoomCategory.setRoomTypeDescription("Mixed");

				if (isPackage) {
					displayRoomPrice.setPackagePrice(roomCategory
							.getDisplayRoomPrice().getPackagePrice()
							+ displayRoomPrice.getPackagePrice());
				}
				displayRoomPrice.setTotalAmount(roomCategory
						.getDisplayRoomPrice().getTotalAmount()
						+ displayRoomPrice.getTotalAmount());
				displayRoomPrice.setPerAdultBasePrice(roomCategory
						.getDisplayRoomPrice().getPerAdultBasePrice()
						+ displayRoomPrice.getPerAdultBasePrice());
				displayRoomPrice.setSavings(roomCategory.getDisplayRoomPrice()
						.getSavings()
						+ displayRoomPrice.getSavings());

				displayRoomCategory.setDisplayRoomPrice(displayRoomPrice);
				// Update preselected rooms with current room
				preselectedRooms.add(roomCategory.getDisplayRoomPrice());
				hotel.setDisplayRoomCategory(displayRoomCategory);
			}
		} // End of rooms loop

		// Set preselected rooms for the hotel
		hotel.setPreselectedRooms(preselectedRooms);
		hotel.setSelectedRooms(preselectedRooms);
		hotelMap.put(hotelKey, hotel);
	}

	/**
	 * Method sorts hotel data based on price
	 * 
	 * @param hotelList
	 *            Hotels list
	 * 
	 * @see
	 * @since
	 */
	private static void sortHotels(ArrayList<Hotel> hotelList, boolean isPackage) {
		// Sort hotels based on price
		if (hotelList != null) {
			Iterator<Hotel> itHotel = hotelList.iterator();
			// Iterate hotels
			while (itHotel.hasNext()) {
				Hotel hotel = itHotel.next();
				ArrayList<RoomCategory> roomCategoryList = (ArrayList<RoomCategory>) hotel
						.getRoomCategories();
				Iterator<RoomCategory> itRoomCategory = roomCategoryList
						.iterator();
				boolean riskHotel = false;
				// Iterate room categories
				while (itRoomCategory.hasNext()) {
					RoomCategory roomCategory = itRoomCategory.next();
					// Retrieve and sort rooms in current room category
					ArrayList<RoomPrice> roomPriceList = (ArrayList<RoomPrice>) roomCategory
							.getRoomPrices();
					Collections.sort(roomPriceList, new RoomPriceComparator(
							isPackage));
					RoomPrice displayRoomPrice = roomPriceList.get(0);
					// Set the room with least price as display room price for
					// this category
					roomCategory.setDisplayRoomPrice(displayRoomPrice);
					if (roomCategory.isRiskRoomCategory()) {
						riskHotel = true;
					}
				} // End of room category while
				// Sort room categories
				Collections.sort(roomCategoryList,
						new RoomCategoryPriceComparator(isPackage));
				hotel.setRiskHotel(riskHotel);
			} // End of hotel while
			// Sort all hotels based on least room category prices
			Collections.sort(hotelList, new HotelPriceComparator());
			Collections.sort(hotelList, new HotelRatingComparator());
			Collections.sort(hotelList, new HotelRiskComparator());
		} // End of if
	}
	/**
	 * Method to convert destination services
	 * 
	 * @param destinationServiceList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Destination> processDestinationServices(
			Yst_Ota_Htl_Dest_ServicesType_List destinationServiceList) {

		Iterator<Yst_Ota_Htl_Dest_ServicesType> itDestServices = destinationServiceList
				.iterator();
		HashMap<String, Destination> destnMap = new HashMap<String, Destination>();

		while (itDestServices.hasNext()) {
			Yst_Ota_Htl_Dest_ServicesType destSerivcesRow = itDestServices
					.next();
			Destination tmpDestn = new Destination();
			String destnKey = destSerivcesRow.getDestination();
			tmpDestn.setAirportCode(destnKey);

			DestinationService destnService = new DestinationService();
			destnService.setServiceCode(destSerivcesRow.getCode());
			destnService.setServiceName(destSerivcesRow.getService_Name());
			destnService.setPrice(destSerivcesRow.getPrice().doubleValue());
			destnService.setCurrency(destSerivcesRow.getCurrency());

			// Retrieve destination object from map
			Destination destination = destnMap.get(destnKey);
			ArrayList<DestinationService> destnServiceList = new ArrayList<DestinationService>();
			if (destination == null) {
				destination = tmpDestn;
			} else {
				destnServiceList = (ArrayList<DestinationService>) destination
						.getServices();
			}
			destnServiceList.add(destnService);
			destination.setServices(destnServiceList);
			// Update destination map
			destnMap.put(destnKey, destination);
		} // End of destn services while

		return new ArrayList(destnMap.values());
	}

	/**
	 * Method to prepare the Hotel structures
	 * 
	 * @param packagesRequest
	 * @param hotelsList
	 * 
	 * @see
	 * @since
	 */
	public static void prepareHotelsStructures(PackagesRequest packagesRequest,
			List<Hotel> hotelsList) {
		if (hotelsList == null || hotelsList.size() == 0) {
			return;
		}
		Yst_Ota_Htl_InfoType_List hotelInfoList = packagesRequest
				.getSapHotelInfoList();
		Yst_Ota_Htl_Vend_ServicesType_List vendorServicesList = new Yst_Ota_Htl_Vend_ServicesType_List();
		byte hotelItemRph = 0;
		if (hotelInfoList != null) {
			hotelItemRph = (byte) packagesRequest.getSapHotelInfoList().size();
		} else {
			hotelInfoList = new Yst_Ota_Htl_InfoType_List();
		}
		// Parse each hotel object
		for (Hotel hotel : hotelsList) {
			// Prepare HotelInfo structure and add to to the existing list
			++hotelItemRph;
			hotelInfoList.add(prepareHotelInfo(hotel, hotelItemRph));

			// Prepare Hotel availability, amenities and pricing structure
			prepareHotelAvailabilityList(hotel, hotelItemRph, packagesRequest);

			// Prepare Hotel Vendor services
			if (hotel.getVendorServices() != null
					&& hotel.getVendorServices().size() > 0) {
				if (vendorServicesList == null) {
					vendorServicesList = new Yst_Ota_Htl_Vend_ServicesType_List();
				}
				vendorServicesList.addAll(prepareHotelVendorServices(hotel
						.getVendorServices(), hotelItemRph));
			}
		}
		packagesRequest.setSapHotelInfoList(hotelInfoList);
	}

	/**
	 * Method to convert the given Hotel object to Yst_Ota_Htl_InfoType
	 * structure
	 * 
	 * @param hotel
	 * @param hotelItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static Yst_Ota_Htl_InfoType prepareHotelInfo(Hotel hotel,
			byte hotelItemRph) {
		Yst_Ota_Htl_InfoType hotelInfoType = new Yst_Ota_Htl_InfoType();
		hotelInfoType.setItem_Rph("" + hotelItemRph);
		hotelInfoType.setName(hotel.getHotelName());
		hotelInfoType.setRating(hotel.getAppleRating());
		hotelInfoType.setHotel_Code(hotel.getHotelCode());
		if (hotel.getResortArea() != null) {
			hotelInfoType.setResort_Area(hotel.getResortArea()
					.getResortAreaCode());
		}
		hotelInfoType.setArr_Date(new java.sql.Date(hotel.getCheckInDate()
				.getTime()));
		hotelInfoType.setDep_Date(new java.sql.Date(hotel.getCheckOutDate()
				.getTime()));
		hotelInfoType.setMin_Rate(new BigDecimal(hotel.getMinRate()));
		hotelInfoType.setCurrency(hotel.getCurrency());
		hotelInfoType.setHotel_Chain(hotel.getHotelChain());
		return hotelInfoType;
	}

	/**
	 * Method to convert the room categories to SAP type
	 * 
	 * @param hotel
	 * @param hotelItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static void prepareHotelAvailabilityList(Hotel hotel,
			byte hotelItemRph, PackagesRequest packagesRequest) {
		if (hotel.getRoomCategories() == null) {
			return;
		}
		Yst_Ota_Htl_AvailabilityType_List hotelAvailabilityList = packagesRequest
				.getSapHotelAvailabilityList();
		Yst_Ota_Htl_AmenityType_List amenityTypeList = packagesRequest
				.getSapHotelAmenityList();
		Yst_Ota_Htl_Room_PricingType_List roomPricingTypeList = packagesRequest
				.getSapRoomPricingList();
		byte roomCategoryRph = 0;
		for (RoomCategory roomCategory : hotel.getRoomCategories()) {
			Yst_Ota_Htl_AvailabilityType hotelAvailabilityType = new Yst_Ota_Htl_AvailabilityType();
			hotelAvailabilityType.setItem_Rph("" + hotelItemRph);
			hotelAvailabilityType.setRoom_Cat_Rph("" + (++roomCategoryRph));
			hotelAvailabilityType.setRoomtypecode(roomCategory
					.getRoomTypeCode());
			hotelAvailabilityType.setRateplancode(roomCategory
					.getRatePlanCode());
			hotelAvailabilityType.setRoom_Type_Desc(roomCategory
					.getRoomTypeDescription());
			hotelAvailabilityType.setRate_Plan_Desc(roomCategory
					.getRatePlanDescription());
			hotelAvailabilityType.setRateindicator(roomCategory
					.getRateIndicator());
			hotelAvailabilityType.setCorpinfo_Code(roomCategory
					.getCorporateId());
			hotelAvailabilityType.setGuarantee_Type(roomCategory
					.getGuaranteeType());
			hotelAvailabilityType.setGuarantee_Method(roomCategory
					.getGuaranteeMethod());
			hotelAvailabilityType.setGuarantee_Req(roomCategory
					.getGuaranteeRequired());
			hotelAvailabilityType.setGuarantee_Amount(new BigDecimal(
					roomCategory.getGuaranteeAmount()));
			hotelAvailabilityType.setRate_Plan_Catg(roomCategory
					.getRatePlanCategory());
			hotelAvailabilityType.setAvail_Rooms(""
					+ roomCategory.getNoOfRoomsAvailable());
			hotelAvailabilityType.setStatus(roomCategory.getStatus());
			hotelAvailabilityType.setCurrency(roomCategory.getCurrency());
			hotelAvailabilityType.setRate_Plan_Id(roomCategory.getRatePlanId());
			if (hotelAvailabilityList == null) {
				hotelAvailabilityList = new Yst_Ota_Htl_AvailabilityType_List();
			}
			hotelAvailabilityList.add(hotelAvailabilityType);

			// Process the room prices
			if (roomCategory.getRoomPrices() != null
					&& roomCategory.getRoomPrices().size() > 0) {
				if (roomPricingTypeList == null) {
					roomPricingTypeList = new Yst_Ota_Htl_Room_PricingType_List();
				}
				for (RoomPrice roomPrice : roomCategory.getRoomPrices()) {
					Yst_Ota_Htl_Room_PricingType roomPricing = new Yst_Ota_Htl_Room_PricingType();
					roomPricing.setItem_Rph("" + hotelItemRph);
					roomPricing.setRoom_Cat_Rph("" + roomCategoryRph);
					roomPricing.setRoom_Rph("" + roomPrice.getRoomId());
					roomPricing.setTotal(new BigDecimal(roomPrice
							.getTotalAmount()));
					roomPricing.setTaxes(new BigDecimal(roomPrice.getTax()));
					roomPricing.setLatefee(new BigDecimal(roomPrice
							.getLateFee()));
					roomPricing.setFree_Nights(roomPrice.getFreeNights() + "");
					roomPricing.setPromo_Savings(new BigDecimal(roomPrice
							.getPromoSavingsAmount()));
					roomPricing.setSavings(new BigDecimal(roomPrice
							.getSavings()));
					roomPricing.setCurrency(roomPrice.getCurrency());
					roomPricing.setPer_Adult_Base_Price(new BigDecimal(
							roomPrice.getPerAdultBasePrice()));
					roomPricingTypeList.add(roomPricingTypeList);
				}
			}

			// Process Amenities
			if (roomCategory.getAmenities() != null
					&& roomCategory.getAmenities().size() > 0) {
				if (amenityTypeList == null) {
					amenityTypeList = new Yst_Ota_Htl_AmenityType_List();
				}
				for (Amenity amenity : roomCategory.getAmenities()) {
					Yst_Ota_Htl_AmenityType amenityType = new Yst_Ota_Htl_AmenityType();
					amenityType.setItem_Rph(hotelItemRph + "");
					amenityType.setRoom_Cat_Rph(roomCategoryRph + "");
					amenityType.setAmenity_Code(amenity.getAmenityCode());
					amenityType.setAmenity_Name(amenity.getAmenityName());
					if (amenity.getAmenityDate() != null) {
						amenityType.setAmenity_Date(new java.sql.Date(amenity
								.getAmenityDate().getTime()));
					}
					amenityType.setAmenity_Value(amenity.getAmenityValue());
					amenityTypeList.add(amenityType);
				}
			}
		}
		packagesRequest.setSapHotelAvailabilityList(hotelAvailabilityList);
		packagesRequest.setSapHotelAmenityList(amenityTypeList);
		packagesRequest.setSapRoomPricingList(roomPricingTypeList);
	}

	/**
	 * Method to prepare the Yst_Ota_Htl_Vend_ServicesType_List type from hotel
	 * vendor services
	 * 
	 * @param vendorServices
	 * @param hotelItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static Yst_Ota_Htl_Vend_ServicesType_List prepareHotelVendorServices(
			List<VendorService> vendorServices, byte hotelItemRph) {
		Yst_Ota_Htl_Vend_ServicesType_List vendorServicesTypeList = new Yst_Ota_Htl_Vend_ServicesType_List();
		for (VendorService vendorService : vendorServices) {
			Yst_Ota_Htl_Vend_ServicesType vendorServiceType = new Yst_Ota_Htl_Vend_ServicesType();
			vendorServiceType.setItem_Rph(hotelItemRph + "");
			vendorServiceType.setCode(vendorService.getServiceCode());
			vendorServiceType.setService_Name(vendorService.getServiceName());
			vendorServiceType
					.setPrice(new BigDecimal(vendorService.getPrice()));
			vendorServiceType.setCurrency(vendorService.getCurrency());
			vendorServicesTypeList.add(vendorServiceType);
		}
		return vendorServicesTypeList;
	}

	/**
	 * Method to convert the Hotel objects to Hotel Item structures in SAP
	 * 
	 * @param hotel
	 * @param hotelItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Htl_ItemsType_List prepareHotelItemTypeList(
			Hotel hotel, byte hotelItemRph, String flightType, boolean isChangeflight) {
		
		/*if (hbsiHotelDaoStatic == null) {
			System.out.println("Dao object is null....");
		} else {
			System.out.println("Got the object...");
		}*/
		
		if (hotel != null && hotel.getSelectedRooms() != null) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = new Yst_Ota_Htl_ItemsType_List();
			
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				RoomCategory roomCategory = hotel.getRoomCatgoryById(roomPrice
						.getRoomCategoryId());
				if (roomCategory != null) {
					// Prepare Hotel Item
					Yst_Ota_Htl_ItemsType hotelItem = new Yst_Ota_Htl_ItemsType();
					//set the Source partner
					if(hotel.getHotelCode()!=null)
					{
						if(hbsiHotelDaoStatic.isHBSiHotel(hotel.getHotelCode()))
						{
						hotelItem.setSource_Partner("HBSI");
						hotelItem.setStatecode("");
						if(hotel.getVendor()!=null)
						{
						hotelItem.setPostalcode(hotel.getVendor().getPostalCode());
						
						hotelItem.setCity(hotel.getVendor().getCity());
						hotelItem.setPhonenumber(hotel.getVendor().getPhone());
						hotelItem.setCountrycode(hotel.getVendor().getCountry());
						hotelItem.setLine1(hotel.getVendor().getStreetAddrs());
						hotelItem.setEmail(hotel.getVendor().getEmail());
						} 
						
						
						hotelItem.setLine2("");
						
						
						if(hotel.getDisplayRoomCategory()!=null)
						{
							hotelItem.setSource_Pnrno(hotel.getHbsiPNR());
							hotelItem.setRateplndesc(roomCategory.getRatePlanDescription());
							hotelItem.setSource_Roomtypecode(roomCategory.getRoomTypeCode());
							//roomPrice.getHotelCost();
							
							/*hotelItem.setTotal_Hotel_Cost(roomPrice.getHotelCost());
							hotelItem.setTransfer_Cost(roomPrice.getTransferCost());*/
							
							if(roomPrice!=null && roomPrice.getHotelCost()!=null)
							{
							BigDecimal hotelCost = new BigDecimal(roomPrice.getHotelCost().doubleValue());
							hotelItem.setTotal_Hotel_Cost(hotelCost);
							}
							if(roomPrice!=null && roomPrice.getTransferCost()!=null)
							{
							BigDecimal transferCost = new BigDecimal(roomPrice.getTransferCost().doubleValue());
							hotelItem.setTotal_Transfer_Cost(transferCost);
							}
							
							if( roomCategory.getMealPlanType()!=null)
							{
								hotelItem.setMealplan_Code(roomCategory.getMealPlanType().getCode());
								hotelItem.setMealplan_Desc(roomCategory.getMealPlanType().getDescription());
							}
						}
						
//						Convert Cancel Policy ASObject to JAVA Object
						CancelPolicy cancelPolicyAS;
//						 ASTranslator astCP = new ASTranslator();
//						if(roomCategory.getCancelPolicy()!=null && roomCategory.getCancelPolicy().size()>0)
//						{
//							for(int cpInt=0;cpInt<roomCategory.getCancelPolicy().size();cpInt++)
//							{
//								if(roomCategory.getCancelPolicy().get(cpInt)!=null)
//								{
//									Object hbsiRateObject = roomCategory.getCancelPolicy().get(cpInt);
//									if(hbsiRateObject instanceof ASObject)
//									{
//									ASObject hbsiAsObject = (ASObject)hbsiRateObject;
//									hbsiAsObject.setType("com.kcdata.abe.data.dto.CancelPolicy");
//									cancelPolicyAS= (CancelPolicy)astCP.convert(hbsiAsObject, CancelPolicy.class);
//									roomCategory.getCancelPolicy().set(cpInt, cancelPolicyAS);
//									
//									}
//								}
//							}
//						}
						
//						Setting Cancel policy
						if(roomCategory.getCancelPolicy()!=null && roomCategory.getCancelPolicy().size()>0)
						{
							
							double occupancy = 0;
							CancelPolicy cancelPolicy = roomCategory.getCancelPolicy().get(0);
							if(cancelPolicy.getCancelAmount()!=null && cancelPolicy.getCancelAmount()!=0.0){
							short noOfNights=(short) DateUtils.dateDifferenceInDays(hotel.getCheckInDate(),hotel.getCheckOutDate());
							if(roomCategory.getHbsiRates()!=null && roomCategory.getHbsiRates().size()>0)
							{
								double amountBeforeTax = 0.0;
								double amountWithMarkUp=0.0;
								double cancelMinFee=0.0;
								double cancelFinalFee=0.0;
								if(hotel.getOccupancy()!=null)
								for(int hbsiRate=0;hbsiRate<roomCategory.getHbsiRates().size();hbsiRate++)
								{
									if(roomCategory.getHbsiRates().get(hbsiRate)!=null &&
											roomCategory.getHbsiRates().get(hbsiRate).getDescription()!=null
											&&Integer.parseInt(roomCategory.getHbsiRates().get(hbsiRate).getDescription())==roomPrice.getRoomId())
									{
										amountBeforeTax = roomCategory.getHbsiRates().get(hbsiRate).getAmountBeforeTax();
										amountWithMarkUp=amountBeforeTax / 0.8;
							
							 cancelMinFee= (cancelPolicy.getCancelAmount()*amountWithMarkUp)/100;
							 occupancy=returnOccupancyRoomWise(hotel,roomPrice.getRoomId()) ;
							 cancelMinFee = Math.round((cancelMinFee / occupancy)* 1e2) / 1e2;
							 cancelFinalFee+=cancelMinFee;
									}
								}
							 //cutOffdays = getCancelCutOfDays(hotel.getCheckInDate());
							 String cutOffdays = String.valueOf(DateUtils.dateDifferenceInDaysForCancelPenalty(cancelPolicy.getCancelPolicyDeadLine(),hotel.getCheckInDate()));
							// cutOffdays = getCancelCutOfDays(hotel.getCheckInDate(),cutOffdays);
							 hotelItem.setCancel_Cutoffdays(cutOffdays);
							 hotelItem.setCancel_Min_Dura(String.valueOf(noOfNights));
							 hotelItem.setCancel_Min_Days("00");
							 hotelItem.setCancel_Min_Fee(new BigDecimal(String.valueOf(cancelFinalFee)));
							 
							 hotelItem.setCancel_Max_Dura(String.valueOf(noOfNights));
							 hotelItem.setCancel_Max_Days("00");
							 hotelItem.setCancel_Max_Fee(new BigDecimal(String.valueOf(cancelFinalFee)));
							 
							 
							 hotelItem.setCancel_Mid_Days("00");
							 hotelItem.setCancel_Mid_Fee(new BigDecimal(String.valueOf(cancelFinalFee)));
							 
							 hotelItem.setCancel_Policycode(cancelPolicy.getCancelPolicyCode());
							 
							 if(cancelPolicy.getCancelDescription()!=null && cancelPolicy.getCancelDescription().size()>0)
							 hotelItem.setCancel_Policydesc(cancelPolicy.getCancelDescription().get(0));
							 
									
							}
							 
							}else{
								if(roomCategory.getHbsiRates()!=null && roomCategory.getHbsiRates().size()>0)
								{
									double totalNights = cancelPolicy.getNmbrOfNights();
									double finalAmount = 0.0;
									double amountBeforeTax = 0.0;
									double amountWithMarkUp=0.0;
									
									for(int hbsiRate=0;hbsiRate<roomCategory.getHbsiRates().size();hbsiRate++)
									{
										if(roomCategory.getHbsiRates().get(hbsiRate)!=null &&
												roomCategory.getHbsiRates().get(hbsiRate).getDescription()!=null
												&&Integer.parseInt(roomCategory.getHbsiRates().get(hbsiRate).getDescription())==roomPrice.getRoomId())
										{
											double unitMultiplier = (double) roomCategory.getHbsiRates().get(hbsiRate).getUnitMultiplier();
											amountBeforeTax = roomCategory.getHbsiRates().get(hbsiRate).getAmountBeforeTax();
											amountWithMarkUp=amountBeforeTax / 0.8;
											double perNightRate = amountWithMarkUp/ unitMultiplier;
											if (unitMultiplier >= totalNights) {
												finalAmount += totalNights* perNightRate;
												break;
											} else {
												finalAmount += unitMultiplier* perNightRate;
												totalNights = totalNights - unitMultiplier;

											}
											if (!(totalNights > 0))
												break;
											}
										}
									DecimalFormat decim = new DecimalFormat("0.00");
									finalAmount=finalAmount * hotel.getNoOfRooms();
								    Double finalCancelAmount = Double.parseDouble(decim.format(finalAmount));
									
								    String cutOffdays = String.valueOf(DateUtils.dateDifferenceInDaysForCancelPenalty(cancelPolicy.getCancelPolicyDeadLine(),hotel.getCheckInDate()));
															
									if(hotel.getOccupancy()!=null)
									occupancy=returnOccupancyRoomWise(hotel,roomPrice.getRoomId()) ;
									finalCancelAmount = Math.round((finalCancelAmount / occupancy)* 1e2) / 1e2;
									 
									//	cutOffdays = getCancelCutOfDays(hotel.getCheckInDate(),cutOffdays);
									 hotelItem.setCancel_Cutoffdays(cutOffdays);
									 hotelItem.setCancel_Min_Dura(String.valueOf((short)totalNights));
									 hotelItem.setCancel_Min_Days("00");
									 hotelItem.setCancel_Min_Fee(new BigDecimal(String.valueOf(finalCancelAmount)));
									 
									 hotelItem.setCancel_Max_Dura(String.valueOf((short)totalNights));
									 hotelItem.setCancel_Max_Days("00");
									 hotelItem.setCancel_Max_Fee(new BigDecimal(String.valueOf(finalCancelAmount)));
									 
									 
									 hotelItem.setCancel_Mid_Days("00");
									 hotelItem.setCancel_Mid_Fee(new BigDecimal(String.valueOf(finalCancelAmount)));
									 
									 hotelItem.setCancel_Policycode(cancelPolicy.getCancelPolicyCode());
									 
									 if(cancelPolicy.getCancelDescription()!=null && cancelPolicy.getCancelDescription().size()>0)
									 hotelItem.setCancel_Policydesc(cancelPolicy.getCancelDescription().get(0));
									}
								}
															
							}
						}
						
						
						}
					
					
					hotelItem.setItem_Rph((++hotelItemRph) + "");
					
					hotelItem.setRoomtypecode(roomCategory.getRoomTypeCode());
					hotelItem.setRoom_Type_Desc(roomCategory.getRoomTypeDescription());
					
					if(hotel.getHotelCode()!=null) {
							String roomTypeCode = roomCategory.getRoomTypeCode();
							if(roomTypeCode.contains("-RD-")) {
								String [] splitRoomTypeCode = null;
								splitRoomTypeCode = roomTypeCode.split("-RD-");
								hotelItem.setRoomtypecode(splitRoomTypeCode[0]);
								hotelItem.setRoom_Type_Desc(splitRoomTypeCode[1]);
								hotelItem.setSource_Roomtypecode(splitRoomTypeCode[0]);
							}
					}

					if(isChangeflight && hotel.getHotelCode()!=null && !hbsiHotelDaoStatic.isHBSiHotel(hotel.getHotelCode())){
						hotelItem.setRateplancode("APPLEVAC");
					}else{
						hotelItem.setRateplancode(roomCategory.getRatePlanCode());
					}
					hotelItem.setRateindicator(roomCategory.getRateIndicator());
					hotelItem.setCorpinfo_Code(roomCategory.getCorporateId());
					hotelItem
							.setGuarantee_Type(roomCategory.getGuaranteeType());
					hotelItem.setGuarantee_Method(roomCategory
							.getGuaranteeMethod());
					hotelItem.setGuarantee_Req(roomCategory
							.getGuaranteeRequired());
					hotelItem.setRate_Plan_Catg(roomCategory
							.getRatePlanCategory());
					hotelItem.setRate_Plan_Id(roomCategory.getRatePlanId());
					hotelItem.setArr_Date(new java.sql.Date(hotel
							.getCheckInDate().getTime()));
					hotelItem.setDep_Date(new java.sql.Date(hotel
							.getCheckOutDate().getTime()));
					hotelItem.setOrigin_Location(hotel.getOriginLocation());
					hotelItem.setHotel_City_Code(hotel.getHotelCityCode());
					hotelItem.setHotel_Chain(hotel.getHotelChain());
					hotelItem.setFree_Nights(roomPrice.getFreeNights() + "");
					hotelItem.setTaxes(new BigDecimal(roomPrice.getTax()));
					hotelItem.setPromo_Savings(new BigDecimal(roomPrice
							.getPromoSavingsAmount()));
					hotelItem
							.setSavings(new BigDecimal(roomPrice.getSavings()));
					hotelItem.setTotal(new BigDecimal(roomPrice
							.getTotalAmount()));
					hotelItem.setPer_Adult_Base_Price(new BigDecimal(roomPrice
							.getPerAdultBasePrice()));
					// Add PAX allocation
					hotelItem.setPax_Alloc_Rph(roomPrice.getGuestAllocation());
					// Set POSNR numbers
					hotelItem.setPosnr(roomCategory.getPosnr());
					hotelItem.setOld_Posnr(roomCategory.getOldPosnr());

					// Set the PaxTypeBase prices
					if (roomPrice.getPaxBasePrices() != null) {
						PaxTypeBasePrices paxTypeBasePrices = roomPrice
								.getPaxBasePrices();
						hotelItem.setNo_Adults(paxTypeBasePrices
								.getNoOfAdults());
						hotelItem
								.setNo_Child(paxTypeBasePrices.getNoOfChilds());
						hotelItem.setNo_Infants(paxTypeBasePrices
								.getNoOfInfants());
						hotelItem.setNo_Juniors(paxTypeBasePrices
								.getNoOfJuniors());
						hotelItem.setNo_Lapchild(paxTypeBasePrices
								.getNoOfLapChilds());
						hotelItem.setNo_Minors(paxTypeBasePrices
								.getNoOfMinors());
						hotelItem.setNo_Seniors(paxTypeBasePrices
								.getNoOfSeniors());
						hotelItem.setChild1_Age(paxTypeBasePrices
								.getChild1Age());
						hotelItem.setChild2_Age(paxTypeBasePrices
								.getChild2Age());
						hotelItem.setChild3_Age(paxTypeBasePrices
								.getChild3Age());
						hotelItem.setChild4_Age(paxTypeBasePrices
								.getChild4Age());
						hotelItem.setChild5_Age(paxTypeBasePrices
								.getChild5Age());
						hotelItem.setChild6_Age(paxTypeBasePrices
								.getChild6Age());
						hotelItem.setChild1_Type(paxTypeBasePrices
								.getChild1Type());
						hotelItem.setChild2_Type(paxTypeBasePrices
								.getChild2Type());
						hotelItem.setChild3_Type(paxTypeBasePrices
								.getChild3Type());
						hotelItem.setChild4_Type(paxTypeBasePrices
								.getChild4Type());
						hotelItem.setChild5_Type(paxTypeBasePrices
								.getChild5Type());
						hotelItem.setChild6_Type(paxTypeBasePrices
								.getChild6Type());
						
						hotelItem.setAdult_Base_Price(new BigDecimal(paxTypeBasePrices.getAdultBasePrice()));
						int noOfAdults = 0;
						int noOfChild = 0;
						if (roomPrice.getPaxBasePrices().getNoOfAdults() != null)
							noOfAdults = Integer.parseInt(roomPrice.getPaxBasePrices().getNoOfAdults());
						if(roomPrice.getPaxBasePrices().getNoOfChilds() != null)
							noOfChild = Integer.parseInt(roomPrice.getPaxBasePrices().getNoOfChilds());
						
						if(hotel.getHotelCode() != null && hotel.getHotelCode() != ""){
							if(hbsiHotelDaoStatic.isHBSiHotel(hotel.getHotelCode()))
							{
								//Set the taxes = per person tax, calculate the tax from hbsiRates and divide by number of adults and no of child
								//calculate the per person price by dividing the perpersonAdultPrice/noOfAdults
								//adultBasePrice = perPersonPrice - perPersonTax
								double taxes=0.0;
								HBSiRates hbsi;
//								 ASTranslator ast = new ASTranslator();
//								if(roomCategory.getHbsiRates()!=null && roomCategory.getHbsiRates().size()>0)
//								{
//									for(int hbsiRate=0;hbsiRate<roomCategory.getHbsiRates().size();hbsiRate++)
//									{
//										if(roomCategory.getHbsiRates().get(hbsiRate)!=null)
//										{
//											Object hbsiRateObject = roomCategory.getHbsiRates().get(hbsiRate);
//											if(hbsiRateObject instanceof ASObject)
//											{
//											ASObject hbsiAsObject = (ASObject)hbsiRateObject;
//											hbsiAsObject.setType("com.kcdata.abe.data.dto.HBSiRates");
//											hbsi= (HBSiRates)ast.convert(hbsiAsObject, HBSiRates.class);
//											roomCategory.getHbsiRates().set(hbsiRate, hbsi);
//											
//											}
//										}
//									}
//								}
								
								
								if(roomCategory.getHbsiRates()!=null && roomCategory.getHbsiRates().size()>0)
								{
									for(int hbsiRate=0;hbsiRate<roomCategory.getHbsiRates().size();hbsiRate++)
									{
										if(roomCategory.getHbsiRates().get(hbsiRate)!=null &&
												roomCategory.getHbsiRates().get(hbsiRate).getDescription()!=null
												&&Integer.parseInt(roomCategory.getHbsiRates().get(hbsiRate).getDescription())==roomPrice.getRoomId())
										{
											taxes = taxes + new BigDecimal(roomCategory.getHbsiRates().get(hbsiRate).getTax()).doubleValue();
										}
									}
								}
								
								
								
								
								if (roomPrice.getPaxBasePrices() != null && roomPrice.getPaxBasePrices().getNoOfAdults() != null) {
//									taxes = taxes/(noOfAdults + noOfChild);
									taxes = Math.round((taxes/(noOfAdults + noOfChild)) * 1e2) / 1e2;
//									hotelItem.setTaxes(new BigDecimal(String.valueOf(Math.round(taxes * 1e2) / 1e2)));
									hotelItem.setTaxes(new BigDecimal(String.valueOf(taxes)));
									double adultbasePrice = paxTypeBasePrices.getAdultBasePrice();
									double tempAdultBasePrice = Math.round((adultbasePrice/noOfAdults) * 1e2) / 1e2;
	//								double tempTaxPerAdult = Math.round((taxes / noOfAdults) * 1e2) / 1e2;
									tempAdultBasePrice = Math.round((tempAdultBasePrice - taxes) * 1e2) / 1e2;
									
									hotelItem.setAdult_Base_Price(new BigDecimal(String.valueOf(tempAdultBasePrice)));
								}
							}

						}
												
						
						
						hotelItem.setChild_Base_Price(new BigDecimal(
								paxTypeBasePrices.getChildBasePrice()));
						hotelItem.setSenior_Base_Price(new BigDecimal(
								paxTypeBasePrices.getSeniorBasePrice()));
						hotelItem.setJunior_Base_Price(new BigDecimal(
								paxTypeBasePrices.getJuniorBasePrice()));
						hotelItem.setMinor_Base_Price(new BigDecimal(
								paxTypeBasePrices.getMinorBasePrice()));
					} else if (hotel.getOccupancy() != null) {
						// Populate No. adults, childs, infants and lapchilds
						populateOccupancyForHotelItem(roomPrice.getRoomId(),
								hotel.getOccupancy(), hotelItem);
					}

					hotelItem.setHotel_Name(hotel.getHotelName());
					hotelItem.setRating(hotel.getAppleRating());
					if (hotel.getResortArea() != null) {
						hotelItem.setResort_Area(hotel.getResortArea()
								.getResortAreaCode());
					}
					hotelItem
							.setDuration(""
									+ DateUtils.dateDifferenceInDays(hotel
											.getCheckInDate(), hotel
											.getCheckOutDate()));
					hotelItem.setHotel_Code(hotel.getHotelCode());
					
			
					if (flightType != null) {
						hotelItem.setFlight_Req_Type(flightType);
					}
					if (hotel.isPackageHotelNoChange()) {
						hotelItem.setPkg_Htl_Nochange("X");
					}
					hotelItem.setGds_Hotel_Code(hotel.getGdsHotelCode());
					hotelItemsList.add(hotelItem);
				}
			}
			return hotelItemsList;
		}
		return null;
	}

	/**
	 * Method sets the room occupancy criteria for hotel availability BAPI input
	 * 
	 * @param roomOccupancy
	 * @param hotelItemRph
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_RoomstaycandidatesType_List prepareRoomStayCandidates(
			Occupancy roomOccupancy, int roomId, byte hotelItemRph) {

		if (roomOccupancy == null || roomOccupancy.getPassengers() == null) {
			return null;
		}
		Yst_Ota_RoomstaycandidatesType_List occupancyList = new Yst_Ota_RoomstaycandidatesType_List();
		Iterator<Passenger> itPassengers = roomOccupancy.getPassengers()
				.iterator();
		while (itPassengers.hasNext()) {
			Passenger passenger = itPassengers.next();
			if (roomId == passenger.getRoomNumber()) {
				Yst_Ota_RoomstaycandidatesType occupancy = new Yst_Ota_RoomstaycandidatesType();
				occupancy.setItem_Rph(hotelItemRph + "");
				// Room RPH will be always one
				occupancy.setRoom_Rph(1 + "");
				// Age code possible values: 7-Infant, 8-Child, 10-Adult,
				// 11-Senior
				occupancy.setAgequalifyingcode(new Integer(passenger
						.getAgeCode().getAgeCode()).toString());
				// Age will be specified only in case of child PAX
				occupancy.setAge(new Integer(passenger.getAge()).toString());
				occupancy.setGuestcount(new Integer(passenger.getGuestCount())
						.toString());
				occupancyList.add(occupancy);
			}
		} // End of while
		return occupancyList;
	}

	/**
	 * Method parses the reserved hotels data in the booking
	 * @param reservedHotels
	 * @param vendorList TODO
	 * @param itinerary
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Hotel> processReservedHotels(
			Yst_Ota_Res_HotelsType_List reservedHotels,
			Zapi_VendaddrType_List vendorList, List<GuestInfo> guestsList) {

		if (reservedHotels == null || reservedHotels.isEmpty())
			return null;
		// Map to hold hotels list with hotel Item RPH as key
		HashMap<String, Hotel> hotelsMap = new HashMap<String, Hotel>();
		// Hotels list
		ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();

		// Hotel iterator
		Iterator<Yst_Ota_Res_HotelsType> itHotels = reservedHotels.iterator();

		while (itHotels.hasNext()) {
			Yst_Ota_Res_HotelsType hotelRow = itHotels.next();
			Hotel hotel = new Hotel();

			if (hotelsMap.containsKey(hotelRow.getItem_Rph())) {
				hotel = hotelsMap.get(hotelRow.getItem_Rph());
			} else {
				hotel.setHotelId(Integer.parseInt(hotelRow.getItem_Rph()));
				hotel.setHotelCode(hotelRow.getHotel_Code());
				hotel.setHotelCityCode(hotelRow.getHotel_City_Code());
				hotel.setHotelName(hotelRow.getHotel_Name());
				ResortArea resortArea = new ResortArea();
				resortArea.setResortAreaName(hotelRow.getResort_Area());
				hotel.setResortArea(resortArea);
				hotel.setAppleRating(hotelRow.getRating());
				hotel.setCheckInDate(hotelRow.getArr_Date());
				hotel.setCheckOutDate(hotelRow.getDep_Date());
				hotel.setOriginLocation(hotelRow.getOrigin_Location());
				hotel.setHbsiPNR(hotelRow.getSource_Pnrno());
				hotel.setHBSI(HotelConvertUtils.hbsiHotelDaoStatic.isHBSiHotel(hotel.getHotelCode()+""));
				hotelsList.add(hotel);
			}
			// Process Room category
			procesReservedRoomCategory(hotel, hotelRow);

			// Populate hotel occupancy
			populateHotelOccupancy(hotel, guestsList);
			
			//Populate Vendor Information
			populateHotelVendorInfo(hotel,vendorList);

			hotelsMap.put(hotelRow.getItem_Rph(), hotel);
		} // End of hotels loop

		// Set hotels list to itinerary
		return hotelsList;
	}

	/**
	 * @param hotel
	 * @param vendorList
	 */
	private static void populateHotelVendorInfo(Hotel hotel,Zapi_VendaddrType_List vendorList ){
		// Vendor iterator
		if(vendorList !=null && vendorList.size() !=0){
			Iterator<Zapi_VendaddrType> itVendors = vendorList.iterator();
			while (itVendors.hasNext()) {
				Zapi_VendaddrType vendorRow = itVendors.next();
				if(vendorRow.getLifnr().equals(hotel.getHotelCode())){
					Vendor vendor = new Vendor();
					vendor.setStreetAddrs(vendorRow.getStras());
					vendor.setCity(vendorRow.getOrt01());
					vendor.setRegion(vendorRow.getRegio());
					vendor.setCountry(vendorRow.getLand1());
					vendor.setPostalCode(vendorRow.getPstl2());
					vendor.setPhone(vendorRow.getTeltx());
					hotel.setVendor(vendor);
				}
			}
		}
	}
	/**
	 * Method parses the reserved hotels data in the booking
	 * 
	 * @param itinerary
	 * @param reservedHotels
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<Hotel> processQuotedHotels(
			Yst_Ota_Htl_ItemsType_List quotedHotels, List<GuestInfo> guestsList, 
				Map<String, Package> packagesMap) {

		if (quotedHotels == null || quotedHotels.isEmpty())
			return null;
		// Map to hold hotels list with hotel Item RPH as key
		HashMap<String, Hotel> hotelsMap = new HashMap<String, Hotel>();
		// Hotels list
		ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();

		// Hotel iterator
		Iterator<Yst_Ota_Htl_ItemsType> itHotels = quotedHotels.iterator();

		while (itHotels.hasNext()) {
			Yst_Ota_Htl_ItemsType hotelRow = itHotels.next();
			Hotel hotel = new Hotel();

			if (hotelsMap.containsKey(hotelRow.getItem_Rph())) {
				hotel = hotelsMap.get(hotelRow.getItem_Rph());
			} else {
				hotel.setHotelId(Integer.parseInt(hotelRow.getItem_Rph()));
				hotel.setHotelCode(hotelRow.getHotel_Code());
				hotel.setHotelCityCode(hotelRow.getHotel_City_Code());
				hotel.setHotelName(hotelRow.getHotel_Name());
				ResortArea resortArea = new ResortArea();
				resortArea.setResortAreaName(hotelRow.getResort_Area());
				hotel.setResortArea(resortArea);
				hotel.setAppleRating(hotelRow.getRating());
				hotel.setCheckInDate(hotelRow.getArr_Date());
				hotel.setCheckOutDate(hotelRow.getDep_Date());
				hotel.setOriginLocation(hotelRow.getOrigin_Location());
				if(hotelRow.getFlt_Item_Rph() != null && !"".equals(hotelRow.getFlt_Item_Rph()) 
						&& !"000".equals(hotelRow.getFlt_Item_Rph())) {
					Package eachPackage = new Package();
					eachPackage.setSelectedHotel(hotel);
					packagesMap.put(hotelRow.getFlt_Item_Rph(), eachPackage);
				} else {
					hotelsList.add(hotel);
				}
			}
			// Process Room category
			processQuotedRoomCategory(hotel, hotelRow);

			if (hotelRow.getPax_Alloc_Rph() != null
					&& !hotelRow.getPax_Alloc_Rph().equals("")) {
				// Populate hotel occupancy
				populateHotelOccupancy(hotel, guestsList);

			} else {
				// Populate Occupancy
				Occupancy occupancy = new Occupancy();
				List<Passenger> passengersList = new ArrayList<Passenger>();
				byte noOfAdults = Byte.parseByte(hotelRow.getNo_Adults());
				if (noOfAdults != 0) {
					occupancy.setNoOfAdults(noOfAdults);
					Passenger passenger = new Passenger();
					passenger.setAgeCode(AgeCode.ADULT);
					passenger.setGuestCount(noOfAdults);
					passenger.setRoomNumber((byte) 1);
					passengersList.add(passenger);
				}
				byte noOfInfants = Byte.parseByte(hotelRow.getNo_Infants());
				if (noOfInfants != 0) {
					occupancy.setNoOfInfants(noOfInfants);
					Passenger passenger = new Passenger();
					passenger.setAgeCode(AgeCode.INFANT);
					passenger.setGuestCount(noOfInfants);
					passenger.setRoomNumber((byte) 1);
					passengersList.add(passenger);
				}
				byte noOfLapChild = Byte.parseByte(hotelRow.getNo_Lapchild());
				if (noOfLapChild != 0) {
					occupancy.setNoOfLapChilds(noOfLapChild);
					Passenger passenger = new Passenger();
					passenger.setAgeCode(AgeCode.LAPCHILD);
					passenger.setGuestCount(noOfLapChild);
					passenger.setRoomNumber((byte) 1);
					passengersList.add(passenger);
				}
				byte noOfChilds = Byte.parseByte(hotelRow.getNo_Child());
				noOfChilds += Byte.parseByte(hotelRow.getNo_Juniors());
				noOfChilds += Byte.parseByte(hotelRow.getNo_Minors());
				if (noOfChilds != 0) {
					occupancy.setNoOfChilds(noOfChilds);
					for (byte paxIndex = 1; paxIndex <= noOfChilds; paxIndex++) {
						Passenger passenger = new Passenger();
						passenger.setAgeCode(AgeCode.CHILD);
						passenger.setGuestCount((byte) 1);
						passenger.setRoomNumber((byte) 1);
						switch (paxIndex) {
						case 1:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild1_Age()));
							break;
						case 2:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild2_Age()));
							break;
						case 3:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild3_Age()));
							break;
						case 4:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild4_Age()));
							break;
						case 5:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild5_Age()));
							break;
						case 6:
							passenger.setAge(Byte.parseByte(hotelRow
									.getChild6_Age()));
							break;
						}

						passengersList.add(passenger);
					}
				}
				occupancy.setPassengers(passengersList);
				hotel.setOccupancy(occupancy);
			}

			hotelsMap.put(hotelRow.getItem_Rph(), hotel);
		} // End of hotels loop

		// Set hotels list to itinerary
		return hotelsList;
	}

	/**
	 * Method processes current hotel row for room category & price details
	 * 
	 * @param hotel
	 *            Hotel
	 * @param hotelRow
	 *            Yst_Ota_Res_HotelsType
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	private static void procesReservedRoomCategory(Hotel hotel,
			Yst_Ota_Res_HotelsType hotelRow) {
		// Retrieve room category list for the hotel
		ArrayList<RoomCategory> roomCategories = (ArrayList<RoomCategory>) hotel
				.getRoomCategories();
		if (roomCategories == null) {
			roomCategories = new ArrayList<RoomCategory>();
		}
		// Prepare room category details
		RoomCategory roomCategory = new RoomCategory();
		roomCategory.setHotelId(hotel.getHotelId());
		roomCategory.setRoomCategoryId(roomCategories.size() + 1);
		roomCategory.setRoomTypeCode(hotelRow.getRoomtypecode());
		roomCategory.setRoomTypeDescription(hotelRow.getRoom_Type_Desc());
		roomCategory.setRatePlanId(hotelRow.getRate_Plan_Id());
		roomCategory.setRatePlanCode(hotelRow.getRateplancode());
		roomCategory.setRateIndicator(hotelRow.getRateindicator());
		roomCategory.setCorporateId(hotelRow.getCorpinfo_Code());
		roomCategory.setGuaranteeType(hotelRow.getGuarantee_Type());
		roomCategory.setGuaranteeMethod(hotelRow.getGuarantee_Method());
		roomCategory.setGuaranteeRequired(hotelRow.getGuarantee_Req());
		roomCategory.setRatePlanCategory(hotelRow.getRate_Plan_Catg());
		roomCategory.setStatus(hotelRow.getInvent_Status());
		
		// POSNR numbers for reserved room categories
		roomCategory.setPosnr(hotelRow.getPosnr());

		if (roomCategories.contains(roomCategory)) {
			roomCategory = roomCategories.get(roomCategories
					.indexOf(roomCategory));
		}

		processRoomPrice(roomCategory, hotel, hotelRow);
		
		// MealPlan Code
		if(hotelRow.getMeal_Info()!= null && !(hotelRow.getMeal_Info().trim().equals(""))){
		roomCategory.setMealPlanType(MealPlanType
				.getMealPlanType(hotelRow.getMeal_Info()));	
		roomCategory.setMealplanDesc(MealPlanType.getMealPlanType(hotelRow.getMeal_Info()).getDescription());
		}
		// Add or update room category to hotel room category list
		if (roomCategories.contains(roomCategory)) {
			if(roomCategory.getRoomTypeCode().equals(hotelRow.getRoomtypecode())){
				roomCategory.setStatus(hotelRow.getInvent_Status());
			}
			roomCategories.set(roomCategories.indexOf(roomCategory),
					roomCategory);
		} else {
			roomCategories.add(roomCategory);
		}
		hotel.setRoomCategories(roomCategories);
	}

	/**
	 * Method processes room price data for current hotel row
	 * 
	 * @param roomCategory
	 *            RoomCategory
	 * @param hotel
	 *            Hotel
	 * @param hotelRow
	 *            Yst_Ota_Res_HotelsType
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	private static void processRoomPrice(RoomCategory roomCategory,
			Hotel hotel, Yst_Ota_Res_HotelsType hotelRow) {
		// Retrieve rooms list for the room category
		ArrayList<RoomPrice> roomPrices = (ArrayList<RoomPrice>) roomCategory
				.getRoomPrices();
		if (roomPrices == null) {
			roomPrices = new ArrayList<RoomPrice>();
		}
		// Prepare room details
		RoomPrice roomPrice = new RoomPrice();
		roomPrice.setRoomCategoryId(roomCategory.getRoomCategoryId());
		roomPrice.setRoomId((byte) (roomPrices.size() + 1));
		roomPrice.setTotalAmount(hotelRow.getTotal().doubleValue());
		roomPrice.setTax(hotelRow.getTaxes().doubleValue());
		roomPrice.setFreeNights(new Integer(hotelRow.getFree_Nights())
				.intValue());
		roomPrice.setPromoSavingsAmount(hotelRow.getPromo_Savings()
				.doubleValue());
		roomPrice.setSavings(hotelRow.getSavings().doubleValue());
		roomPrice.setCurrency(hotelRow.getCurrency());
		roomPrice.setGuestAllocation(hotelRow.getPax_Alloc_Rph());
		// Parse guest allocation to set room number to PAX
		// parseGuestRoomAllocation(occupancy, roomPrice);

		// Add current room to rooms list
		roomPrices.add(roomPrice);
		// Set rooms list to room category
		roomCategory.setRoomPrices(roomPrices);

		if (hotel.getDisplayRoomCategory() == null) {
			try {
				hotel.setDisplayRoomCategory((RoomCategory) roomCategory
						.clone());
			} catch (CloneNotSupportedException e) {
			}
		}

		if (hotel.getDisplayRoomCategory().getDisplayRoomPrice() == null) {
			try {
				hotel.getDisplayRoomCategory().setDisplayRoomPrice(
						(RoomPrice) roomPrice.clone());
			} catch (CloneNotSupportedException e) {
			}
		} else {
			hotel.getDisplayRoomCategory().getDisplayRoomPrice()
					.setTotalAmount(
							hotel.getDisplayRoomCategory()
									.getDisplayRoomPrice().getTotalAmount()
									+ roomPrice.getTotalAmount());
			if (!hotel.getDisplayRoomCategory().getRoomTypeDescription()
					.equals(roomCategory.getRoomTypeDescription())) {
				hotel.getDisplayRoomCategory().setRoomTypeDescription("Mixed");
			}
		}

		// Update selected rooms list of the hotel with current room
		ArrayList<RoomPrice> selectedRooms = (ArrayList<RoomPrice>) hotel
				.getSelectedRooms();
		if (selectedRooms == null) {
			selectedRooms = new ArrayList<RoomPrice>();
		}
		selectedRooms.add(roomPrice);
		hotel.setSelectedRooms(selectedRooms);
	}

	/*
	 * Method processes current hotel row for room category & price details
	 * 
	 * @param hotel Hotel
	 * 
	 * @param hotelRow Yst_Ota_Res_HotelsType
	 * 
	 * @param occupancy
	 * 
	 * @see
	 * 
	 * @since
	 */
	private static void processQuotedRoomCategory(Hotel hotel,
			Yst_Ota_Htl_ItemsType hotelRow) {
		// Retrieve room category list for the hotel
		ArrayList<RoomCategory> roomCategories = (ArrayList<RoomCategory>) hotel
				.getRoomCategories();
		if (roomCategories == null) {
			roomCategories = new ArrayList<RoomCategory>();
		}
		// Prepare room category details
		RoomCategory roomCategory = new RoomCategory();
		roomCategory.setHotelId(hotel.getHotelId());
		roomCategory.setRoomCategoryId(roomCategories.size() + 1);
		roomCategory.setRoomTypeCode(hotelRow.getRoomtypecode());
		roomCategory.setRoomTypeDescription(hotelRow.getRoom_Type_Desc());
		roomCategory.setRatePlanId(hotelRow.getRate_Plan_Id());
		roomCategory.setRatePlanCode(hotelRow.getRateplancode());
		roomCategory.setRateIndicator(hotelRow.getRateindicator());
		roomCategory.setCorporateId(hotelRow.getCorpinfo_Code());
		roomCategory.setGuaranteeType(hotelRow.getGuarantee_Type());
		roomCategory.setGuaranteeMethod(hotelRow.getGuarantee_Method());
		roomCategory.setGuaranteeRequired(hotelRow.getGuarantee_Req());
		roomCategory.setRatePlanCategory(hotelRow.getRate_Plan_Catg());
		// POSNR numbers for reserved room categories
		roomCategory.setPosnr(hotelRow.getPosnr());
// Code for setting meal plan in quote is added for handling HBSi hotel
		roomCategory.setMealplanDesc(hotelRow.getMealplan_Code());
		
		

		if (roomCategories.contains(roomCategory)) {
			roomCategory = roomCategories.get(roomCategories
					.indexOf(roomCategory));
		}

		processQuotedRoomPrice(roomCategory, hotel, hotelRow);

		// Add or update room category to hotel room category list
		if (roomCategories.contains(roomCategory)) {
			roomCategories.set(roomCategories.indexOf(roomCategory),
					roomCategory);
		} else {
			roomCategories.add(roomCategory);
		}
		// Populate Occupancy
		Occupancy occupancy = new Occupancy();
		List<Passenger> passengersList = new ArrayList<Passenger>();
		byte noOfAdults = Byte.parseByte(hotelRow.getNo_Adults());
		if (noOfAdults != 0) {
			occupancy.setNoOfAdults(noOfAdults);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.ADULT);
			passenger.setGuestCount(noOfAdults);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfInfants = Byte.parseByte(hotelRow.getNo_Infants());
		if (noOfInfants != 0) {
			occupancy.setNoOfInfants(noOfInfants);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.INFANT);
			passenger.setGuestCount(noOfInfants);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfLapChild = Byte.parseByte(hotelRow.getNo_Lapchild());
		if (noOfLapChild != 0) {
			occupancy.setNoOfLapChilds(noOfLapChild);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.LAPCHILD);
			passenger.setGuestCount(noOfLapChild);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfChilds = Byte.parseByte(hotelRow.getNo_Child());
		if (noOfChilds != 0) {
			occupancy.setNoOfChilds(noOfChilds);
			for (byte paxIndex = 1; paxIndex <= noOfChilds; paxIndex++) {
				Passenger passenger = new Passenger();
				passenger.setAgeCode(AgeCode.CHILD);
				passenger.setGuestCount((byte) 1);
				passenger.setRoomNumber((byte) 1);
				passengersList.add(passenger);
			}
		}

		hotel.setRoomCategories(roomCategories);
	}

	/**
	 * Method processes room price data for current hotel row
	 * 
	 * @param roomCategory
	 *            RoomCategory
	 * @param hotel
	 *            Hotel
	 * @param hotelRow
	 *            Yst_Ota_Res_HotelsType
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	private static void processQuotedRoomPrice(RoomCategory roomCategory,
			Hotel hotel, Yst_Ota_Htl_ItemsType hotelRow) {
		// Retrieve rooms list for the room category
		ArrayList<RoomPrice> roomPrices = (ArrayList<RoomPrice>) roomCategory
				.getRoomPrices();
		if (roomPrices == null) {
			roomPrices = new ArrayList<RoomPrice>();
		}
		// Prepare room details
		RoomPrice roomPrice = new RoomPrice();
		roomPrice.setRoomCategoryId(roomCategory.getRoomCategoryId());
		roomPrice.setRoomId((byte) (roomPrices.size() + 1));
		roomPrice.setTotalAmount(hotelRow.getTotal().doubleValue());
		roomPrice.setTax(hotelRow.getTaxes().doubleValue());
		roomPrice.setFreeNights(new Integer(hotelRow.getFree_Nights())
				.intValue());
		roomPrice.setPromoSavingsAmount(hotelRow.getPromo_Savings()
				.doubleValue());
		roomPrice.setSavings(hotelRow.getSavings().doubleValue());
		roomPrice.setCurrency(hotelRow.getCurrency());
		roomPrice.setGuestAllocation(hotelRow.getPax_Alloc_Rph());
		// Parse guest allocation to set room number to PAX
		// parseGuestRoomAllocation(occupancy, roomPrice);

		// Add current room to rooms list
		roomPrices.add(roomPrice);
		// Set rooms list to room category
		roomCategory.setRoomPrices(roomPrices);

		if (hotel.getDisplayRoomCategory() == null) {
			try {
				hotel.setDisplayRoomCategory((RoomCategory) roomCategory
						.clone());
			} catch (CloneNotSupportedException e) {
			}
		}

		if (hotel.getDisplayRoomCategory().getDisplayRoomPrice() == null) {
			try {
				hotel.getDisplayRoomCategory().setDisplayRoomPrice(
						(RoomPrice) roomPrice.clone());
			} catch (CloneNotSupportedException e) {
			}
		} else {
			hotel.getDisplayRoomCategory().getDisplayRoomPrice()
					.setTotalAmount(
							hotel.getDisplayRoomCategory()
									.getDisplayRoomPrice().getTotalAmount()
									+ roomPrice.getTotalAmount());
			if (!hotel.getDisplayRoomCategory().getRoomTypeDescription()
					.equals(roomCategory.getRoomTypeDescription())) {
				hotel.getDisplayRoomCategory().setRoomTypeDescription("Mixed");
			}
		}

		// Update selected rooms list of the hotel with current room
		ArrayList<RoomPrice> selectedRooms = (ArrayList<RoomPrice>) hotel
				.getSelectedRooms();
		if (selectedRooms == null) {
			selectedRooms = new ArrayList<RoomPrice>();
		}
		selectedRooms.add(roomPrice);
		hotel.setSelectedRooms(selectedRooms);
	}

	/**
	 * Method to populate Occupancy of hotel
	 * 
	 * @param hotel
	 * @param guests
	 * 
	 * @see
	 * @since
	 */
	private static void populateHotelOccupancy(Hotel hotel,
			List<GuestInfo> guests) {
		if (hotel.getSelectedRooms() != null) {
			Occupancy occupancy = new Occupancy();
			ArrayList<Passenger> passengers = new ArrayList<Passenger>();
			for (RoomPrice roomPrice : hotel.getSelectedRooms()) {
				String guestIds[] = StringUtils
						.commaDelimitedListToStringArray(roomPrice
								.getGuestAllocation());
				for (byte index = 0; index < guestIds.length; index++) {
					byte guestId = Byte.parseByte(guestIds[index]);
					for (GuestInfo guestInfo : guests) {
						if (guestInfo.getGuestId().equals("" + guestId)) {
							Passenger passenger = new Passenger();
							passenger.setAgeCode(guestInfo.getAgeCode());
							passenger.setGuestCount((byte) 1);
							passenger.setPaxId(guestId);
							passenger.setRoomNumber((byte) roomPrice
									.getRoomId());
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
									occupancy
											.setNoOfLapChilds((byte) (occupancy
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
							break;
						}
					}
				}
			}
			occupancy.setPassengers(passengers);
			hotel.setOccupancy(occupancy);
		}
	}

	/**
	 * Method to populate the occupancy
	 * 
	 * @param roomId
	 * @param occupancy
	 * @param hotelItemsType
	 * 
	 * @see
	 * @since
	 */
	private static void populateOccupancyForHotelItem(byte roomId,
			Occupancy occupancy, Yst_Ota_Htl_ItemsType hotelItemsType) {
		if (occupancy.getPassengers() == null) {
			return;
		}
		byte adultCount = 0, childCount = 0, infantCount = 0, lapChildCount = 0;
		for (Passenger passenger : occupancy.getPassengers()) {
			if (passenger.getRoomNumber() == roomId) {
				if (passenger.getAgeCode().isAdult()) {
					adultCount += passenger.getGuestCount();
				} else if (passenger.getAgeCode().isChild()) {
					++childCount;
					switch (childCount) {
					case 1:
						hotelItemsType.setChild1_Age("" + passenger.getAge());
						break;
					case 2:
						hotelItemsType.setChild2_Age("" + passenger.getAge());
						break;
					case 3:
						hotelItemsType.setChild3_Age("" + passenger.getAge());
						break;
					case 4:
						hotelItemsType.setChild4_Age("" + passenger.getAge());
						break;
					case 5:
						hotelItemsType.setChild5_Age("" + passenger.getAge());
						break;
					case 6:
						hotelItemsType.setChild6_Age("" + passenger.getAge());
						break;
					}
				} else if (passenger.getAgeCode().isInfant()) {
					++infantCount;
				} else if (passenger.getAgeCode().isLapChild()) {
					++lapChildCount;
				}
			}
		}
		hotelItemsType.setNo_Adults("" + adultCount);
		hotelItemsType.setNo_Child("" + childCount);
		hotelItemsType.setNo_Infants("" + infantCount);
		hotelItemsType.setNo_Lapchild("" + lapChildCount);
	}
	/**
	 * 
	 * Method to add no of nights for a hotel to existing itinerary 
	 * for email and print purpose
	 *
	 * @param itinerary
	 * 
	 */
	public static void processNoOfNightsHotels(Itinerary itinerary) {

		if (itinerary.getPackages() != null && itinerary.getPackages().size()>0) 
		{
			List<Package> packages = itinerary.getPackages();
			Iterator<Package> iterator = packages.iterator();
			while (iterator.hasNext()) 
			{
				Package package1 = (Package) iterator.next();
				Hotel selectedHotel = package1.getSelectedHotel();
				selectedHotel.setNoOfNights(String.valueOf(DateUtils
						.dateDifferenceInDays(selectedHotel.getCheckInDate(),
								selectedHotel.getCheckOutDate())));
			}
		} else if (itinerary.getHotels() != null
				&& itinerary.getHotels().size() > 0) 
		{
			List<Hotel> hotels = itinerary.getHotels();
			Iterator<Hotel> iterator = hotels.iterator();
			while (iterator.hasNext()) 
			{
				Hotel hotel = iterator.next();
				hotel.setNoOfNights(String.valueOf(DateUtils
						.dateDifferenceInDays(hotel.getCheckInDate(), hotel
								.getCheckOutDate())));				
			}
		}

	}
	/**
	 * Method to prepare Hotel BAPI input for retrieving vendor information
	 * @param hotelList
	 */
	public static Yst_Htl_ItemsType_List prepareHotelInfo(List<Hotel> hotelList){
		Yst_Htl_ItemsType_List hotelInfoList = new Yst_Htl_ItemsType_List();
		Iterator<Hotel> iterator = hotelList.iterator();
		while (iterator.hasNext()) 
		{
			Hotel hotel = iterator.next();
			List<RoomCategory> roomCategoryList = hotel.getRoomCategories();
			Iterator<RoomCategory> roomCategoryItr = roomCategoryList.iterator();
			Yst_Htl_ItemsType hotelInfo = null;
			while(roomCategoryItr.hasNext()){
				RoomCategory roomCategory = roomCategoryItr.next();
				if(ABEConstants.RFA_HOTEL_STATUS.equals(roomCategory.getStatus())){
					hotelInfo = new Yst_Htl_ItemsType();
					hotelInfo.setRoomtypecode(roomCategory.getRoomTypeCode());
					hotelInfoList.add(hotelInfo);
					break;
				}
			}
		}
		return hotelInfoList;
		
	}
	/**
	 * Method to retrieve vendor information based on the Hotel's Room Category Type 
	 * @param hotelInputList
	 * @param vendorList
	 * @return List<Hotel>
	 */
	@SuppressWarnings("unchecked")
	public static List<Hotel> processHotelVendorDetails(List<Hotel> hotelInputList,YfrfacntType_List vendorList){
		Iterator<Hotel> iterator = hotelInputList.iterator();
		Iterator<YfrfacntType> hotelVendorDetails = null; 
		List<Hotel> hotelList = new ArrayList<Hotel>();
		while (iterator.hasNext()){
			Hotel hotel = iterator.next();
			Iterator<RoomCategory> roomCategoryItr = hotel.getRoomCategories().iterator();
			while(roomCategoryItr.hasNext()){
				RoomCategory roomCategory = roomCategoryItr.next();
				if (ABEConstants.RFA_HOTEL_STATUS.equals(roomCategory.getStatus())) {
					hotelVendorDetails = vendorList.iterator();
					while (hotelVendorDetails.hasNext()) {
						YfrfacntType vendorRow = hotelVendorDetails.next();
						if (roomCategory.getRoomTypeCode()
								.equals(vendorRow.getMatnr())) {
							Vendor vendor = new Vendor();
							vendor.setVendorId(vendorRow.getMfrnr());
							vendor.setFirstName(vendorRow.getZzqfn());
							vendor.setLastName(vendorRow.getZzqln());
							vendor.setMode(vendorRow.getZzqmd());
							vendor.setEmail(vendorRow.getZzqem());
							vendor.setPhone(vendorRow.getZzqp1());
							vendor.setFaxNo(vendorRow.getZzqfx());
							vendor.setStreetAddrs(vendorRow.getStras());
							vendor.setCity(vendorRow.getOrt01());
							vendor.setRegion(vendorRow.getRegio());
							vendor.setCountry(vendorRow.getLand1());
							vendor.setPostalCode(vendorRow.getPstlz());
							hotel.setVendor(vendor);
							if (vendorRow.getFlag().equals("Y")) {
								vendor.setVendorExist(Boolean.TRUE);
							}
							break;
						}
					}
				}
			}
			hotelList.add(hotel);
		}
		return hotelList;
	}
	
	public static String padString(String source,boolean padLeft,char padChar, int padLength){
		if(padLeft){
			return String.format("%1$" + padLength + "s", source).replace(' ', padChar);
		}else{
			return String.format("%1$-" + padLength + "s", source).replace(' ', padChar);
		}
	}
	
public static void formatHotelCode(Itinerary itinerary,HBSiHotelDao hbsiHotelDao){
		
		if(itinerary.getHotels()!=null){
			List<Hotel> hotelLs = itinerary.getHotels();
			for (Iterator iterator = hotelLs.iterator(); iterator.hasNext();) {
				Hotel hotel = (Hotel) iterator.next();
				String hotelCode = padString(hotel.getHotelCode(),true,'0',10);
				if(hbsiHotelDao.isHBSiHotelVendorCode(hotelCode)){
					hotel.setHotelCode(hotelCode);
					hotel.setHBSI(true);
				}
				
			}
		}		
		if(itinerary.getPackages()!=null){
			for(int pack=0;pack<itinerary.getPackages().size();pack++){		
				if(itinerary.getPackages().get(pack).getSelectedHotel()!=null){					
					Hotel hotel = itinerary.getPackages().get(pack).getSelectedHotel();					
					String hotelCode = padString(hotel.getHotelCode(),true,'0',10);
					if(hbsiHotelDao.isHBSiHotelVendorCode(hotelCode)){
					hotel.setHotelCode(hotelCode);
					hotel.setHBSI(true);
					}
				}
			}
		}		
		if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0){
			for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++){
				if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels()!=null){
					List<Hotel> hotelLs = itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels();					
					for (Iterator iterator = hotelLs.iterator(); iterator.hasNext();) {
						Hotel hotel = (Hotel) iterator.next();				
						String hotelCode = padString(hotel.getHotelCode(),true,'0',10);
						if(hbsiHotelDao.isHBSiHotelVendorCode(hotelCode)){
							hotel.setHotelCode(hotelCode);
							hotel.setHBSI(true);
						}
					}
				}
			}
		}
	}
	
	public static String getCancelCutOfDays(Date checkIndate ,String cuttofDays){
		// check if CHeckIndate Falls in
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(checkIndate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		try {
			int year = cal.get(cal.YEAR);
			if((cal.get(cal.MONTH) == cal.JANUARY ) && (cal.get(cal.DAY_OF_MONTH) == 1 )){
				year = year-1;
			}
			
			Date xmsStart = dateFormat.parse("12-24-"+year);
			Date xmsEnd = dateFormat.parse("01-02-"+(year+1));
			
			
			if(xmsStart.before(checkIndate) && xmsEnd.after(checkIndate) ){
				Date cutOfDate = dateFormat.parse("11-01-"+year);
				return String.valueOf(DateUtils.dateDifferenceInDays(cutOfDate, checkIndate));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cuttofDays;
	}
	
	
	public static Itinerary encodeHotelDesc(Itinerary itinerary) {

		if (null!=itinerary && itinerary.getHotels() != null) {
			List<Hotel> hotelLs = itinerary.getHotels();
			for (Iterator iterator = hotelLs.iterator(); iterator.hasNext();) {
				Hotel hotel = (Hotel) iterator.next();
				List<RoomCategory> roomCategory = hotel.getRoomCategories();
				if (hotel.getDisplayRoomCategory() != null) {
					String roomDescription = hotel.getDisplayRoomCategory().getRoomTypeDescription();
					if (roomDescription.contains(":")) {
						int firstColonIndex = roomDescription.indexOf(":");
						int lastCOlonIndex = roomDescription.lastIndexOf(":");
						String removedString = (roomDescription.substring(
								firstColonIndex, lastCOlonIndex + 1));
						String roomTypeToBediplayedonUI = roomDescription
								.replace(removedString, "");
						hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
						hotel.getDisplayRoomCategory().setRoomTypeDescription(roomTypeToBediplayedonUI);
					}
					else{
						//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
						hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
					}
					  //End the fix of HBSI 52 -Phase 1 
				}
				
				for (Iterator iterator2 = roomCategory.iterator(); iterator2
						.hasNext();) {
					RoomCategory roomCategory2 = (RoomCategory) iterator2
							.next();

					String roomDescription = roomCategory2
							.getRoomTypeDescription();
					if (roomDescription.contains(":")) {
						int firstColonIndex = roomDescription.indexOf(":");
						int lastCOlonIndex = roomDescription.lastIndexOf(":");
						String removedString = (roomDescription.substring(
								firstColonIndex, lastCOlonIndex + 1));
						String roomTypeToBediplayedonUI = roomDescription
								.replace(removedString, "");

						roomCategory2.setRoomTypeCode(roomCategory2
								.getRoomTypeCode() + "-RD-" + roomDescription);
						roomCategory2
								.setRoomTypeDescription(roomTypeToBediplayedonUI);
					}
					else{
						//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
						roomCategory2.setRoomTypeCode(roomCategory2
								.getRoomTypeCode() + "-RD-" + roomDescription);
					}
					  //End the fix of HBSI 52 -Phase 1

				}
			}
		}
		if (null!=itinerary && itinerary.getPackages() != null) {
			for (int pack = 0; pack < itinerary.getPackages().size(); pack++) {
				if (itinerary.getPackages().get(pack).getSelectedHotel() != null) {
					Hotel hotel = itinerary.getPackages().get(pack)
							.getSelectedHotel();
					
					if (hotel.getDisplayRoomCategory() != null) {
						String roomDescription = hotel.getDisplayRoomCategory().getRoomTypeDescription();
						if (roomDescription.contains(":")) {
							int firstColonIndex = roomDescription.indexOf(":");
							int lastCOlonIndex = roomDescription.lastIndexOf(":");
							String removedString = (roomDescription.substring(
									firstColonIndex, lastCOlonIndex + 1));
							String roomTypeToBediplayedonUI = roomDescription
									.replace(removedString, "");
							hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
							hotel.getDisplayRoomCategory().setRoomTypeDescription(roomTypeToBediplayedonUI);
						}
						else{
							//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
							hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
						}
						  //End the fix of HBSI 52 -Phase 1
					}


					List<RoomCategory> roomCategory = hotel.getRoomCategories();

					for (Iterator iterator2 = roomCategory.iterator(); iterator2
							.hasNext();) {
						RoomCategory roomCategory2 = (RoomCategory) iterator2
								.next();

						String roomDescription = roomCategory2
								.getRoomTypeDescription();
						if (roomDescription.contains(":")) {
							int firstColonIndex = roomDescription.indexOf(":");
							int lastCOlonIndex = roomDescription
									.lastIndexOf(":");
							String removedString = (roomDescription.substring(
									firstColonIndex, lastCOlonIndex + 1));
							String roomTypeToBediplayedonUI = roomDescription
									.replace(removedString, "");

							roomCategory2.setRoomTypeCode(roomCategory2
									.getRoomTypeCode()
									+ "-RD-"
									+ roomDescription);
							roomCategory2
									.setRoomTypeDescription(roomTypeToBediplayedonUI);
						}
						else{
							//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
							roomCategory2.setRoomTypeCode(roomCategory2
									.getRoomTypeCode() + "-RD-" + roomDescription);
						}
						  //End the fix of HBSI 52 -Phase 1

					}
				}
			}
		}
		if (null!=itinerary && itinerary.getMultiDestinationPackages() != null
				&& itinerary.getMultiDestinationPackages().size() > 0) {
			for (int multiDestPack = 0; multiDestPack < itinerary
					.getMultiDestinationPackages().size(); multiDestPack++) {
				if (itinerary.getMultiDestinationPackages().get(multiDestPack)
						.getSelectedHotels() != null) {
					List<Hotel> hotelLs = itinerary
							.getMultiDestinationPackages().get(multiDestPack)
							.getSelectedHotels();
					

					
					for (Iterator iterator = hotelLs.iterator(); iterator
							.hasNext();) {
						Hotel hotel = (Hotel) iterator.next();

						
						if (hotel.getDisplayRoomCategory() != null) {
							String roomDescription = hotel.getDisplayRoomCategory().getRoomTypeDescription();
							if (roomDescription.contains(":")) {
								int firstColonIndex = roomDescription.indexOf(":");
								int lastCOlonIndex = roomDescription.lastIndexOf(":");
								String removedString = (roomDescription.substring(
										firstColonIndex, lastCOlonIndex + 1));
								String roomTypeToBediplayedonUI = roomDescription
										.replace(removedString, "");
								hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
								hotel.getDisplayRoomCategory().setRoomTypeDescription(roomTypeToBediplayedonUI);
							}
							else{
								//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
								hotel.getDisplayRoomCategory().setRoomTypeCode(hotel.getDisplayRoomCategory().getRoomTypeCode() + "-RD-" + roomDescription);
							}
							  //End the fix of HBSI 52 -Phase 1
						}

						
						
						
						
						
						List<RoomCategory> roomCategory = hotel
								.getRoomCategories();

						for (Iterator iterator2 = roomCategory.iterator(); iterator2
								.hasNext();) {
							RoomCategory roomCategory2 = (RoomCategory) iterator2
									.next();

							String roomDescription = roomCategory2
									.getRoomTypeDescription();
							if (roomDescription.contains(":")) {
								int firstColonIndex = roomDescription
										.indexOf(":");
								int lastCOlonIndex = roomDescription
										.lastIndexOf(":");
								String removedString = (roomDescription
										.substring(firstColonIndex,
												lastCOlonIndex + 1));
								String roomTypeToBediplayedonUI = roomDescription
										.replace(removedString, "");

								roomCategory2.setRoomTypeCode(roomCategory2
										.getRoomTypeCode()
										+ "-RD-"
										+ roomDescription);
								roomCategory2
										.setRoomTypeDescription(roomTypeToBediplayedonUI);
							}
							else{
								//Start the fix of HBSI 52 - Phase 1 // Setting the default roomTypeCode and Description
								roomCategory2.setRoomTypeCode(roomCategory2
										.getRoomTypeCode() + "-RD-" + roomDescription);
							}
							  //End the fix of HBSI 52 -Phase 1
						}
					}
				}
			}
		}
		return itinerary;
	}
	
	public static Itinerary decodeHotelDesc(Itinerary itinerary) {
	
		// Start the AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		if (itinerary.getDeletedList() != null) {
			List<ABEDto> deletedList =itinerary.getDeletedList();
			for (ABEDto object : deletedList) 
			{
				if(object instanceof Hotel)
				{
					 Hotel hotel = (Hotel)object;
						List<RoomCategory> roomCategory = hotel.getRoomCategories();

						if (hotel.getDisplayRoomCategory() != null) {
							String roomTypeCode1 = hotel.getDisplayRoomCategory().getRoomTypeCode();
							 if(roomTypeCode1.contains("-RD-")) {
								 String [] splitRoomTypeCode = null;
								 splitRoomTypeCode = roomTypeCode1.split("-RD-");
								 hotel.getDisplayRoomCategory().setRoomTypeCode(splitRoomTypeCode[0].trim());
								 hotel.getDisplayRoomCategory().setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
							 }
							
						}
						
						for (Iterator iterator2 = roomCategory.iterator(); iterator2
								.hasNext();) {
							RoomCategory roomCategory2 = (RoomCategory) iterator2
									.next();
							 String roomTypeCode = roomCategory2.getRoomTypeCode();
							 if(roomTypeCode.contains("-RD-")) {
								 String [] splitRoomTypeCode = null;
								 splitRoomTypeCode = roomTypeCode.split("-RD-");
								 roomCategory2.setRoomTypeCode(splitRoomTypeCode[0].trim());
								 roomCategory2.setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
							 }
							
						}
				}
			}
		}
		
		
		if (itinerary.getHotels() != null) {
			List<Hotel> hotelLs = itinerary.getHotels();
			for (Iterator iterator = hotelLs.iterator(); iterator.hasNext();) {
				Hotel hotel = (Hotel) iterator.next();
				List<RoomCategory> roomCategory = hotel.getRoomCategories();

				if (hotel.getDisplayRoomCategory() != null) {
					String roomTypeCode1 = hotel.getDisplayRoomCategory().getRoomTypeCode();
					 if(roomTypeCode1.contains("-RD-")) {
					 String [] splitRoomTypeCode = null;
					 splitRoomTypeCode = roomTypeCode1.split("-RD-");
					 hotel.getDisplayRoomCategory().setRoomTypeCode(splitRoomTypeCode[0].trim());
					 hotel.getDisplayRoomCategory().setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
				}
					
				}
				
				for (Iterator iterator2 = roomCategory.iterator(); iterator2
						.hasNext();) {
					RoomCategory roomCategory2 = (RoomCategory) iterator2
							.next();
					 String roomTypeCode = roomCategory2.getRoomTypeCode();
					 if(roomTypeCode.contains("-RD-")) {
					 String [] splitRoomTypeCode = null;
					 splitRoomTypeCode = roomTypeCode.split("-RD-");
					 roomCategory2.setRoomTypeCode(splitRoomTypeCode[0].trim());
					 roomCategory2.setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
					 }
					
				}
			}
		}
		if (itinerary.getPackages() != null) {
			for (int pack = 0; pack < itinerary.getPackages().size(); pack++) {
				if (itinerary.getPackages().get(pack).getSelectedHotel() != null) {
					Hotel hotel = itinerary.getPackages().get(pack)
							.getSelectedHotel();

					List<RoomCategory> roomCategory = hotel.getRoomCategories();
					if (hotel.getDisplayRoomCategory() != null) {
						String roomTypeCode1 = hotel.getDisplayRoomCategory().getRoomTypeCode();
						 if(roomTypeCode1.contains("-RD-")) {
							 String [] splitRoomTypeCode = null;
							 splitRoomTypeCode = roomTypeCode1.split("-RD-");
							 hotel.getDisplayRoomCategory().setRoomTypeCode(splitRoomTypeCode[0].trim());
							 hotel.getDisplayRoomCategory().setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
					}
						
					}

					for (Iterator iterator2 = roomCategory.iterator(); iterator2
							.hasNext();) {
						RoomCategory roomCategory2 = (RoomCategory) iterator2
								.next();

						String roomDescription = roomCategory2
								.getRoomTypeDescription();
						 String roomTypeCode = roomCategory2.getRoomTypeCode();
						 if(roomTypeCode.contains("-RD-")) {
							 String [] splitRoomTypeCode = null;
							 splitRoomTypeCode = roomTypeCode.split("-RD-");
							 roomCategory2.setRoomTypeCode(splitRoomTypeCode[0].trim());
							 roomCategory2.setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
						}
						

					}
				}
			}
		}
		if (itinerary.getMultiDestinationPackages() != null
				&& itinerary.getMultiDestinationPackages().size() > 0) {
			for (int multiDestPack = 0; multiDestPack < itinerary
					.getMultiDestinationPackages().size(); multiDestPack++) {
				if (itinerary.getMultiDestinationPackages().get(multiDestPack)
						.getSelectedHotels() != null) {
					List<Hotel> hotelLs = itinerary
							.getMultiDestinationPackages().get(multiDestPack)
							.getSelectedHotels();
					for (Iterator iterator = hotelLs.iterator(); iterator
							.hasNext();) {
						Hotel hotel = (Hotel) iterator.next();

						List<RoomCategory> roomCategory = hotel
								.getRoomCategories();
						if (hotel.getDisplayRoomCategory() != null) {
							String roomTypeCode1 = hotel.getDisplayRoomCategory().getRoomTypeCode();
							 if(roomTypeCode1.contains("-RD-")) {
								 String [] splitRoomTypeCode = null;
								 splitRoomTypeCode = roomTypeCode1.split("-RD-");
								 hotel.getDisplayRoomCategory().setRoomTypeCode(splitRoomTypeCode[0].trim());
								 hotel.getDisplayRoomCategory().setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
						}
							
						}

						for (Iterator iterator2 = roomCategory.iterator(); iterator2
								.hasNext();) {
							RoomCategory roomCategory2 = (RoomCategory) iterator2
									.next();

							 String roomTypeCode = roomCategory2.getRoomTypeCode();
							 if(roomTypeCode.contains("-RD-")) {
							 String [] splitRoomTypeCode = null;
							 splitRoomTypeCode = roomTypeCode.split("-RD-");
							 roomCategory2.setRoomTypeCode(splitRoomTypeCode[0].trim());
							 roomCategory2.setRoomTypeDescription(splitRoomTypeCode.length>1?splitRoomTypeCode[1]:"");
							}
							
						}
					}
				}
			}
		}
		//End of AV-3749/HBsi 52 Enhancement of emergency info tab for passegner	
		return itinerary;
	}
	
	private static double returnOccupancyRoomWise(Hotel inHotelRequest, Byte roomId) {
		double totalCount=0.0;
		try {
			
			Occupancy occupancy = inHotelRequest.getOccupancy();
			List passengerLs = occupancy.getPassengers();
				for (Iterator iterator = passengerLs.iterator(); iterator.hasNext();) {
					Passenger psngr = (Passenger) iterator.next();
					if(roomId == psngr.getRoomNumber()){
						if (psngr.getAgeCode().getPaxTypeCode()=='C'){
							totalCount+=psngr.getGuestCount();
						}
						else if (psngr.getAgeCode().getPaxTypeCode()=='A'){
							totalCount+=psngr.getGuestCount();
						}
					}
				}
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return totalCount;
	}

}