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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.kcdata.abe.bapi.Y_Bapi_Room_Show_All_Pricing_Input;
import com.kcdata.abe.bapi.Y_Bapi_Room_Show_All_Pricing_Output;
import com.kcdata.abe.bapi.Y_Ota_Hotel_Availability_Input;
import com.kcdata.abe.bapi.Y_Ota_Hotel_Availability_Output;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Vendor_Info_Input;
import com.kcdata.abe.bapi.Y_Ota_Retrieve_Vendor_Info_Output;
import com.kcdata.abe.bapi.Yst_Bapi_All_PaxtypeType;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.Yst_Bapi_Show_AllType;
import com.kcdata.abe.bapi.Yst_Htl_ItemsType;
import com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Input;
import com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output;
import com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Input;
import com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output;
import com.kcdata.abe.bapi.Zmat_BatType;
import com.kcdata.abe.bapi.ZmatrecapType;
import com.kcdata.abe.bapi.util.Yst_Bapi_All_PaxtypeType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Zmat_BatType_List;
import com.kcdata.abe.bapi.util.ZmatrecapType_List;
import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dto.AllPricesBreakUp;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelOptions;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.PaxTypePriceBreakup;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.Vendor;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.DateUtils;

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
public class HotelsSAPDaoImpl extends ABESAPDaoBase implements HotelsDao {

	ABELogger logger = ABELogger.getLogger(HotelsSAPDaoImpl.class);

	/**
	 * Method to retrieve the hotels
	 * 
	 * @param hotelsRequest
	 *            - Hotels request object with search criteria
	 * @return Response object with hotels
	 * 
	 * @see
	 * @since
	 */
	public HotelsResponse retrieveHotels(HotelsRequest hotelsRequest) {
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
		// Bapi input object
		Y_Ota_Hotel_Availability_Input bapiInput = new Y_Ota_Hotel_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());
		// Prepare hotel request options
		bapiInput.setIt_Htl_Req(HotelConvertUtils
				.prepareRequestOptions(hotelsRequest));
		// Prepare request header
		Yst_Bapi_Req_HdrType requestHeader = this.prepareHeader(hotelsRequest);
		if (hotelsRequest.getHotelOptions() != null
				&& hotelsRequest.getHotelOptions().isShowAll()) {
			requestHeader.setShow_All("X");
		}
		bapiInput.setIm_Req_Hdr(requestHeader);
		if (hotelsRequest.isMultiDestinationRequest()) {
			bapiInput.setIm_Incl_Dummy_Hotels("0");
		}

		// Prepare & set room occupancy criteria to BAPI input
		bapiInput.setIt_Htl_Roomstaycandidates(HotelConvertUtils
				.prepareRoomOccupancy(hotelsRequest.getOccupancy()));
		// Prepare amenity request options
		bapiInput.setIt_Htl_Req_Amenity(HotelConvertUtils
				.prepareAmenityOptions(hotelsRequest.getHotelOptions()));

		// Execute hotel availability BAPI
		Y_Ota_Hotel_Availability_Output bapiOutput = (Y_Ota_Hotel_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Hotel_Availability", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), hotelResponse);
		// Return in case of any business error
		if (hotelResponse.isBusinessErrorOccurred())
			return hotelResponse;

		// Prepare hotel response data
		if (bapiOutput.get_as_listIt_Htl_Info() != null
				&& !bapiOutput.get_as_listIt_Htl_Info().isEmpty()) {
			hotelResponse.setHotelList(HotelConvertUtils
					.parseHotelAvailability(hotelsRequest,
							bapiOutput.get_as_listIt_Htl_Info(),
							bapiOutput.get_as_listIt_Htl_Availability(),
							bapiOutput.get_as_listIt_Htl_Pricing(),
							bapiOutput.get_as_listIt_Htl_Amenity(),
							bapiOutput.get_as_listIt_Htl_Vend_Services()));
			// Parse destination services data
			if (bapiOutput.get_as_listIt_Htl_Dest_Services() != null) {
				hotelResponse.setDestinations(HotelConvertUtils
						.processDestinationServices(bapiOutput
								.get_as_listIt_Htl_Dest_Services()));
			} // End of destn services if
		} else {
			// Unable to retrieve hotels, save error and return
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_HOTEL_AVAILABILITY_ERROR");
			businessError
					.setErrorDescription(this.getMessageSource().getMessage(
							"RETRIEVE_HOTEL_AVAILABILITY_ERROR", null, null));
			hotelResponse.saveBusinessError(businessError);
		}

		return hotelResponse;
	}

	/**
	 * Method to retrieve hotels for Packages
	 * 
	 * @param hotelsRequest
	 *            Hotel Request
	 * @return Hotels response
	 * 
	 * @see
	 * @since
	 */
	public HotelsResponse retrieveHotelsForPackages(HotelsRequest hotelsRequest) {
		HotelsResponse hotelResponse = new HotelsResponse();
		if (hotelsRequest == null || hotelsRequest.getHotelOptions() == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL_SEARCH_CRITERIA", null, null));
			hotelResponse.saveBusinessError(businessError);
			return hotelResponse;
		}
		// Bapi input object
		Y_Ota_Hotel_Availability_Input bapiInput = new Y_Ota_Hotel_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());
		// Prepare hotel request options
		bapiInput.setIt_Htl_Req(HotelConvertUtils
				.prepareRequestOptions(hotelsRequest));
		// Prepare request header
		Yst_Bapi_Req_HdrType requestHeader = this.prepareHeader(hotelsRequest);
		if (hotelsRequest.getHotelOptions() != null
				&& hotelsRequest.getHotelOptions().isShowAll()) {
			requestHeader.setShow_All("X");
		}
		bapiInput.setIm_Req_Hdr(requestHeader);

		// Prepare & set room occupancy criteria to BAPI input
		bapiInput.setIt_Htl_Roomstaycandidates(HotelConvertUtils
				.prepareRoomOccupancy(hotelsRequest.getOccupancy()));
		// Prepare amenity request options
		bapiInput.setIt_Htl_Req_Amenity(HotelConvertUtils
				.prepareAmenityOptions(hotelsRequest.getHotelOptions()));

		// Execute hotel availability BAPI
		Y_Ota_Hotel_Availability_Output bapiOutput = (Y_Ota_Hotel_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Hotel_Availability", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), hotelResponse);
		// Return in case of any business error
		if (hotelResponse.isBusinessErrorOccurred())
			return hotelResponse;

		// Prepare hotel response data
		if (bapiOutput.get_as_listIt_Htl_Info() != null
				&& !bapiOutput.get_as_listIt_Htl_Info().isEmpty()) {
			hotelResponse.setSapHotelInfoList(bapiOutput
					.get_as_listIt_Htl_Info());
			hotelResponse.setSapHotelAvailabilityList(bapiOutput
					.get_as_listIt_Htl_Availability());
			hotelResponse.setSapHotelAmenityList(bapiOutput
					.get_as_listIt_Htl_Amenity());
			hotelResponse.setSapRoomPricingList(bapiOutput
					.get_as_listIt_Htl_Pricing());
			hotelResponse.setSapRoomStayCandidatesList(bapiOutput
					.get_as_listIt_Htl_Roomstaycandidates());
			hotelResponse.setSapVendorServicesList(bapiOutput
					.get_as_listIt_Htl_Vend_Services());
			hotelResponse.setSapDestServicesList(bapiOutput
					.get_as_listIt_Htl_Dest_Services());
		} else {
			// Unable to retrieve hotels, save error and return
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_HOTEL_AVAILABILITY_ERROR");
			businessError
					.setErrorDescription(this.getMessageSource().getMessage(
							"RETRIEVE_HOTEL_AVAILABILITY_ERROR", null, null));
			hotelResponse.saveBusinessError(businessError);
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
		if (hotel == null) {
			// Return business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_HOTEL", null, null));
			response.saveBusinessError(businessError);
			return response;
		}
		// Prepare Input
		Y_Bapi_Room_Show_All_Pricing_Input bapiInput = new Y_Bapi_Room_Show_All_Pricing_Input();

		// Set ImApplicationInfo
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare request header
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		headerType.setHotels_Ind("1");
		// set the header
		bapiInput.setIm_Req_Hdr(headerType);

		Yst_Ota_Htl_ItemsType_List hotelsList = HotelConvertUtils
				.prepareHotelItemTypeList(hotel, (byte) 0, null,false);
		bapiInput.setIm_St_Htl_Item(hotelsList.getYst_Ota_Htl_ItemsType(0));

		Y_Bapi_Room_Show_All_Pricing_Output bapiOutput = (Y_Bapi_Room_Show_All_Pricing_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Room_Show_All_Pricing", bapiInput);
		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), response);
		// Return in case of any business error
		if (response.isBusinessErrorOccurred())
			return response;
		// Process BAPI Output
		AllPricesBreakUp pricesBreakUp = new AllPricesBreakUp();
		pricesBreakUp.setPaxTypePrices(parsePaxTypePriceBreakUp(bapiOutput
				.get_as_listIt_All_Paxtype()));
		if (bapiOutput.getEx_St_Show_All() != null) {
			Yst_Bapi_Show_AllType showAllType = bapiOutput.getEx_St_Show_All();
			pricesBreakUp.setFreeChildCount(Byte.parseByte(showAllType
					.getNo_Free_Child()));
			pricesBreakUp.setMaxPerRoom(Byte.parseByte(showAllType
					.getMax_Per_Room()));
			pricesBreakUp.setMinPerRoom(Byte.parseByte(showAllType
					.getMin_Per_Room()));
			pricesBreakUp.setMaxAdultCount(Byte.parseByte(showAllType
					.getMax_No_Adults()));
			pricesBreakUp.setMaxChildCount(Byte.parseByte(showAllType
					.getMax_No_Child()));
			pricesBreakUp.setChildRule(showAllType.getChild_Age_Rule());
		}
		response.setAllPricesBreakUp(pricesBreakUp);
		return response;
	}

	/**
	 * Method to process the pax type list
	 * 
	 * @param paxTypeList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private List<PaxTypePriceBreakup> parsePaxTypePriceBreakUp(
			Yst_Bapi_All_PaxtypeType_List paxTypeList) {
		if (paxTypeList == null) {
			return null;
		}
		List<PaxTypePriceBreakup> breakUpList = new ArrayList<PaxTypePriceBreakup>();
		Iterator<Yst_Bapi_All_PaxtypeType> iterator = paxTypeList.iterator();
		while (iterator.hasNext()) {
			Yst_Bapi_All_PaxtypeType paxTypeBreakup = iterator.next();
			PaxTypePriceBreakup paxTypePriceBreakup = new PaxTypePriceBreakup();
			paxTypePriceBreakup.setPaxType(paxTypeBreakup.getPaxtype()
					.charAt(0));
			paxTypePriceBreakup.setCount(Integer.parseInt(paxTypeBreakup
					.getGuestcount()));
			paxTypePriceBreakup.setPrice(paxTypeBreakup.getTotal()
					.doubleValue());
			paxTypePriceBreakup.setSavings(paxTypeBreakup.getSavings()
					.doubleValue());
			breakUpList.add(paxTypePriceBreakup);
		}
		return breakUpList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.kcdata.abe.data.dao.HotelsDao#retrieveHotelVendor(java.util.List)
	 */
	public HotelsResponse retrieveHotelVendor(List<Hotel> hotelList) {

		HotelsResponse hotelResponse = new HotelsResponse();
		if (hotelList == null || hotelList.size() == 0) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_HOTEL_SEARCH_CRITERIA");
			businessError
					.setErrorDescription("No Hotel Data found to retrieve vendor details");
			hotelResponse.saveBusinessError(businessError);
			return hotelResponse;
		}
		Y_Ota_Retrieve_Vendor_Info_Input bapiInput = new Y_Ota_Retrieve_Vendor_Info_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare hotel input data
		bapiInput
				.setIm_Htl_Items(HotelConvertUtils.prepareHotelInfo(hotelList));

		if (bapiInput.get_as_listIm_Htl_Items() != null
				&& bapiInput.get_as_listIm_Htl_Items().size() == 0) {
			hotelResponse.setHotelList(hotelList);
			return hotelResponse;
		}
		// Execute hotel vendor BAPI
		Y_Ota_Retrieve_Vendor_Info_Output bapiOutput = (Y_Ota_Retrieve_Vendor_Info_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Retrieve_Vendor_Info", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), hotelResponse);

		// Return in case of any business error
		if (hotelResponse.isBusinessErrorOccurred())
			return hotelResponse;

		// Prepare hotel response data
		if (bapiOutput.get_as_listVendor_Info() != null
				&& !bapiOutput.get_as_listVendor_Info().isEmpty()) {
			// Populate Hotel vendor details
			hotelResponse.setHotelList(HotelConvertUtils
					.processHotelVendorDetails(hotelList,
							bapiOutput.get_as_listVendor_Info()));
		}
		return hotelResponse;
	}

	public List<RequestedDatesForAvailability> getRequestedDatesForAvailability(
			Hotel hotel) {

		List<RequestedDatesForAvailability> requestedDatesForAvailabilities = new ArrayList<RequestedDatesForAvailability>();
		List<RequestedDatesForAvailability> tempDtsforAvl = new ArrayList<RequestedDatesForAvailability>();

		final List<RoomPrice> roomPrices = hotel.getSelectedRooms();
		if ((null != roomPrices) && (!roomPrices.isEmpty())) {
			for (RoomPrice roomPrice : roomPrices) {
				int roomCategoryId = roomPrice.getRoomCategoryId();
				final List<RoomCategory> categories = hotel.getRoomCategories();
				if(null != categories){
					for (RoomCategory roomCategory : categories) {
						if ((roomCategory.getRoomCategoryId() == roomCategoryId)&& (null != roomCategory.getStatus())
								&& (roomCategory.getStatus().equalsIgnoreCase("Q"))) {
							long daysDifference = DateUtils
									.dateDifferenceInDays(hotel.getCheckInDate(),
											hotel.getCheckOutDate());
	
							// Making Request
							Z_Get_Mat_Bat_Availability_Input availability_Input = new Z_Get_Mat_Bat_Availability_Input();
							availability_Input.setInv_Sts_Req("X");
							Zmat_BatType_List It_Mat_Batlist = new Zmat_BatType_List();
							for (int i = 0; i < daysDifference; i++) {
	
								Zmat_BatType item = new Zmat_BatType();
								item.setMatnr(roomCategory.getRoomTypeCode());
								Date date = DateUtils.addDaysToDate(
										hotel.getCheckInDate(), i);
								item.setCharg(DateUtils.reformatDate(
										date.toString(),
										"E MMM dd HH:mm:ss Z yyyy", "MMddyy") + "X");
								item.setWerks("1000");
								item.setLgort("1000");
								It_Mat_Batlist.addZmat_BatType(item);
							}
							availability_Input.setIt_Mat_Bat(It_Mat_Batlist);
	
							// Execute the BAPI
							Z_Get_Mat_Bat_Availability_Output bapiOutput = (Z_Get_Mat_Bat_Availability_Output) this
									.getBapiExecutionManager().executeBAPI(
											"Z_Get_Mat_Bat_Availability",
											availability_Input);
							Zmat_BatType_List zmat_BatType_List = bapiOutput
									.get_as_listIt_Mat_Bat();
	
							RequestedDatesForAvailability datesForAvailability = new RequestedDatesForAvailability();
							datesForAvailability.setBookingDate(hotel
									.getCheckInDate().toString()); // yyyy-MM-dd
																	// format
							datesForAvailability.setBookingDuration(Long
									.toString(daysDifference));
							datesForAvailability.setRoomDescription(roomCategory
									.getRatePlanDescription());
							datesForAvailability.setRoomStatus("Q");
							datesForAvailability.setMaterialNumber(roomCategory
									.getRoomTypeCode());
							List<String> dates = new ArrayList<String>();
							int count = 0;
							if ((null == zmat_BatType_List)
									|| (zmat_BatType_List.size() < 1)) {
								continue;
							}
							for (Object object : zmat_BatType_List) {
	
								Zmat_BatType zmat_BatType = (Zmat_BatType) object;
								if (zmat_BatType.getInv_Sts().equalsIgnoreCase("Q")) {
									Date date = DateUtils.addDaysToDate(
											hotel.getCheckInDate(), count);
									dates.add(DateUtils.reformatDate(
											date.toString(),
											"E MMM dd HH:mm:ss Z yyyy",
											"MM/dd/yyyy"));
								}
								++count;
							}
							datesForAvailability.setReqDates(dates);
							tempDtsforAvl.add(datesForAvailability);
	
						}
					}
				}
			}
		}
		final Set<RequestedDatesForAvailability> treeSetReqDtsAvl = new TreeSet<RequestedDatesForAvailability>();
		treeSetReqDtsAvl.addAll(tempDtsforAvl);
		for (final RequestedDatesForAvailability requestedDatesForAvailability : treeSetReqDtsAvl) {

			Integer noOfRooms = 0;
			for (RequestedDatesForAvailability allDtsforAvl : tempDtsforAvl) {
				if (((null != requestedDatesForAvailability.getMaterialNumber()) && (!""
						.equals(requestedDatesForAvailability
								.getMaterialNumber().trim())))
						&& ((null != allDtsforAvl.getMaterialNumber()) && (!""
								.equals(allDtsforAvl.getMaterialNumber().trim())))
						&& (requestedDatesForAvailability.getMaterialNumber()
								.trim().equalsIgnoreCase(allDtsforAvl
								.getMaterialNumber().trim()))) {
					++noOfRooms;
				}

			}
			if (noOfRooms > 1) {
				requestedDatesForAvailability
						.setNoOfRooms(noOfRooms.toString());
			}
		}
		requestedDatesForAvailabilities.addAll(treeSetReqDtsAvl);
		return requestedDatesForAvailabilities;
	}

	public List<RequestedDatesForAvailability> getRequestedDatesForAvailability(
			String bookingNo) {

		Z_Api_Change_Get_Sb_Input bapiInput = new Z_Api_Change_Get_Sb_Input();
		List<RequestedDatesForAvailability> requestedDatesForAvailabilities = new ArrayList<RequestedDatesForAvailability>();
		List<RequestedDatesForAvailability> tempDtsforAvl = new ArrayList<RequestedDatesForAvailability>();
		bapiInput.setBookingno(bookingNo);
		// Execute the BAPI
		Z_Api_Change_Get_Sb_Output bapiOutput = (Z_Api_Change_Get_Sb_Output) this
				.getBapiExecutionManager().executeBAPI("Z_Api_Change_Get_Sb",
						bapiInput);

		// Process the response of the BAPI
		ZmatrecapType_List zmatrecapType_List = bapiOutput
				.get_as_listR_It_Matrecap();
		for (Object object : zmatrecapType_List) {
			ZmatrecapType zmatrecapType = (ZmatrecapType) object;
			String stringDates = zmatrecapType.getZzrqdts().toString();
			if ((null != zmatrecapType.getZzproduct())
					&& (!"".equals(zmatrecapType.getZzproduct().trim()))
					&& (zmatrecapType.getZzproduct().equalsIgnoreCase("Hotel"))
					&& (null != stringDates)
					&& (!"".equalsIgnoreCase(stringDates.trim()))) {
				RequestedDatesForAvailability datesForAvailability = new RequestedDatesForAvailability();
				datesForAvailability.setBookingDate(zmatrecapType.getZzdate()
						.toString()); // yyyy-MM-dd format
				datesForAvailability.setBookingDuration(zmatrecapType
						.getZzduration());
				datesForAvailability.setRoomDescription(zmatrecapType
						.getZzdesc());
				datesForAvailability.setRoomStatus(zmatrecapType
						.getZzmatstatus());
				datesForAvailability
						.setMaterialNumber(zmatrecapType.getMatnr());
				String[] requiredDates = stringDates.split(",");
				List<String> dates = new ArrayList<String>();
				for (String date : requiredDates) {
					dates.add(date);
				}
				datesForAvailability.setReqDates(dates);
				tempDtsforAvl.add(datesForAvailability);
			}
		}
		final Set<RequestedDatesForAvailability> treeSetReqDtsAvl = new TreeSet<RequestedDatesForAvailability>();
		treeSetReqDtsAvl.addAll(tempDtsforAvl);
		for (final RequestedDatesForAvailability requestedDatesForAvailability : treeSetReqDtsAvl) {

			Integer noOfRooms = 0;
			for (RequestedDatesForAvailability allDtsforAvl : tempDtsforAvl) {
				if (((null != requestedDatesForAvailability.getMaterialNumber()) && (!""
						.equals(requestedDatesForAvailability
								.getMaterialNumber().trim())))
						&& ((null != allDtsforAvl.getMaterialNumber()) && (!""
								.equals(allDtsforAvl.getMaterialNumber().trim())))
						&& (requestedDatesForAvailability.getMaterialNumber()
								.trim().equalsIgnoreCase(allDtsforAvl
								.getMaterialNumber().trim()))) {
					++noOfRooms;
				}

			}
			if (noOfRooms > 1) {
				requestedDatesForAvailability
						.setNoOfRooms(noOfRooms.toString());
			}
		}

		requestedDatesForAvailabilities.addAll(treeSetReqDtsAvl);
		return requestedDatesForAvailabilities;
	}
	
	
	public  boolean checkisStatusValid(Itinerary itinerary) {
		// TODO Auto-generated method stub
		
		List<Hotel> hotelsList=new ArrayList<Hotel>();
		if(itinerary.getHotels()!=null)
		hotelsList.addAll(itinerary.getHotels());
		
		List<Package> packageList= itinerary.getPackages();
		if(packageList!=null){						
			for (Iterator iterator = packageList.iterator(); iterator.hasNext();) {
				Package eachePackage = (Package) iterator.next();
				if(eachePackage.getSelectedHotel()!=null)
					hotelsList.add(eachePackage.getSelectedHotel());
			}
		}
		
		
		for (Iterator hotelList = hotelsList.iterator(); hotelList.hasNext();) {			
			Hotel hotel = (Hotel) hotelList.next();
			return checkHotelStatus(hotel);			
		}
		return true;
	}
		
				
	
	
	private boolean checkRoomCategoryBookable(RoomCategory roomCategory, Itinerary itinerary){
		
		boolean bookable=true;
		boolean customer=this.getApplicationContextFactory().getApplicationContext().getRequestContext().getIMApplicationInfo().getType().isCustomer();		
		String roomStatus=roomCategory.getStatus();
		if( customer && roomStatus=="Q")
			bookable=false;
		return bookable;
		
	}

	private boolean  checkHotelStatus(Hotel hotel) {
		
		final List<RoomPrice> roomPrices = hotel.getSelectedRooms();
		if ((null != roomPrices) && (!roomPrices.isEmpty())) {
			for (RoomPrice roomPrice : roomPrices) {
				int roomCategoryId = roomPrice.getRoomCategoryId();
				final List<RoomCategory> categories = hotel.getRoomCategories();
				if(null != categories){
					for (RoomCategory roomCategory : categories) {
						if ((roomCategory.getRoomCategoryId() == roomCategoryId)) {
							long daysDifference = DateUtils	.dateDifferenceInDays(hotel.getCheckInDate(),hotel.getCheckOutDate());
							
							// Making Request
							Z_Get_Mat_Bat_Availability_Input availability_Input = new Z_Get_Mat_Bat_Availability_Input();
							availability_Input.setInv_Sts_Req("X");
							Zmat_BatType_List It_Mat_Batlist = new Zmat_BatType_List();
							for (int i = 0; i < daysDifference; i++) {	
								Zmat_BatType item = new Zmat_BatType();
								item.setMatnr(roomCategory.getRoomTypeCode());
								Date date = DateUtils.addDaysToDate(hotel.getCheckInDate(), i);
								item.setCharg(DateUtils.reformatDate(date.toString(),
										"E MMM dd HH:mm:ss Z yyyy", "MMddyy") + "X");
								item.setWerks("1000");
								item.setLgort("1000");
								It_Mat_Batlist.addZmat_BatType(item);
							}
							availability_Input.setIt_Mat_Bat(It_Mat_Batlist);
	
							// Execute the BAPI
							Z_Get_Mat_Bat_Availability_Output bapiOutput = (Z_Get_Mat_Bat_Availability_Output) this
									.getBapiExecutionManager().executeBAPI("Z_Get_Mat_Bat_Availability",availability_Input);
							Zmat_BatType_List zmat_BatType_List = bapiOutput.get_as_listIt_Mat_Bat();							
							for (Object object : zmat_BatType_List) {	
								Zmat_BatType zmat_BatType = (Zmat_BatType) object;
								if (zmat_BatType.getInv_Sts().equalsIgnoreCase("Q")) {
									return false;
								}
	
						}
					}
				}
			}
		}
		
	}
		return true;
	}

	
}