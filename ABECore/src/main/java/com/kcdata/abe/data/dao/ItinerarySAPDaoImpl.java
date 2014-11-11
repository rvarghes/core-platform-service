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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import com.kcdata.abe.bapi.Y_Bapi_Extend_Opt_Date_Input;
import com.kcdata.abe.bapi.Y_Bapi_Extend_Opt_Date_Output;
import com.kcdata.abe.bapi.Y_Ota_Booking_Input;
import com.kcdata.abe.bapi.Y_Ota_Booking_Output;
import com.kcdata.abe.bapi.Y_Ota_Cancel_Reservation_Input;
import com.kcdata.abe.bapi.Y_Ota_Cancel_Reservation_Output;
import com.kcdata.abe.bapi.Y_Ota_Change_Booking_Input;
import com.kcdata.abe.bapi.Y_Ota_Change_Booking_Output;
import com.kcdata.abe.bapi.Y_Ota_Cid_Update_Input;
import com.kcdata.abe.bapi.Y_Ota_Cid_Update_Output;
import com.kcdata.abe.bapi.Y_Ota_Quote_Input;
import com.kcdata.abe.bapi.Y_Ota_Quote_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType;
import com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType;
import com.kcdata.abe.bapi.Yst_Bapi_Trn_ItemsType;
import com.kcdata.abe.bapi.Yst_FarerulesType;
import com.kcdata.abe.bapi.Yst_InfotextType;
import com.kcdata.abe.bapi.Yst_Order_HdrType;
import com.kcdata.abe.bapi.Yst_Ota_ChargesType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType;
import com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Input;
import com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output;
import com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Input;
import com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output;
import com.kcdata.abe.bapi.Zmat_BatType;
import com.kcdata.abe.bapi.ZmatrecapType;
import com.kcdata.abe.bapi.ZfbrapicType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_FarerulesType_List;
import com.kcdata.abe.bapi.util.Yst_InfotextType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List;
import com.kcdata.abe.bapi.util.Zmat_BatType_List;
import com.kcdata.abe.bapi.util.ZmatrecapType_List;
import com.kcdata.abe.bapi.util.Yzseat_Info_SType_List;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.HotelConfirmation;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Insurance;
import com.kcdata.abe.data.dto.InsuranceGuestAllocation;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.ItineraryCancellationRules;
import com.kcdata.abe.data.dto.ItineraryCharge;
import com.kcdata.abe.data.dto.ItineraryPrice;
import com.kcdata.abe.data.dto.MultiDestinationPackage;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.RequestedDatesForAvailability;
import com.kcdata.abe.data.dto.RFARequest;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.dto.Vehicle;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.data.util.GuestInfoConvertUtil;
import com.kcdata.abe.data.util.HotelConvertUtils;
import com.kcdata.abe.data.util.InsuranceConvertUtils;
import com.kcdata.abe.data.util.SeatMapUtils;
import com.kcdata.abe.data.util.ServicesConvertUtils;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.context.ABEApplicationContext;
import com.kcdata.abe.framework.context.ABERequestContext;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.dto.ABEDto;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.DateUtils;
import com.kcdata.abe.framework.util.ABEConstants;


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
public class ItinerarySAPDaoImpl extends ABESAPDaoBase implements ItineraryDao {

	ABELogger bookingLogger = ABELogger.getLogger("bookings.log");

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
	 * Method to book the given itinerary
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ItineraryResponse bookItinerary(Itinerary itinerary, ServicesResponse servicesResponse) {
		ItineraryResponse bookingResponse = new ItineraryResponse();
		// Create Input for BAPI
		Y_Ota_Booking_Input bapiInput = new Y_Ota_Booking_Input();
		HashMap<Byte, Object> itemsMap = new HashMap<Byte, Object>();
		boolean isSeatMapServiceAvailable = false;
		byte itemRPH = 0;

		// Flights Input for Booking
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemsMap, itemRPH);
		}

		// Hotels Input for Booking
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemsMap, itemRPH, null);
		}

		// Cars Input for Booking
		if (itinerary.getVehicles() != null) {
			itemRPH = this.prepareVehiclesInput(itinerary.getVehicles(),
					bapiInput, itemsMap, itemRPH);
		}

		// Packages Input for Booking
		if (itinerary.getPackages() != null) {
			itemRPH = this.preparePackagesInput(itinerary.getPackages(),
					bapiInput, itemsMap, itemRPH, null, null);
		}

		// Packages Input for Booking
		if (itinerary.getMultiDestinationPackages() != null) {
			itemRPH = this.prepareMultiDestPackagesInput(itinerary
					.getMultiDestinationPackages(), bapiInput, itemsMap,
					itemRPH);
		}
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			if(servicesResponse != null) {
				isSeatMapServiceAvailable = SeatMapUtils.isSeatMapServiceAvailable(servicesResponse);
			}
		}
		// Services input for Booking
		if(itinerary.getServices() == null)
		{
			itinerary.setServices(new ArrayList<Service>());
		}
		
			itemRPH = this.prepareServicesInput(itinerary, bapiInput, itemsMap,
					itemRPH, servicesResponse, null);
		

		// Seats Input for Booking
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0
				&& isSeatMapServiceAvailable)
		{
			this.prepareSeatsInput(itinerary, bapiInput, itemsMap,
					itemRPH, servicesResponse);
		}

		// Insurance input for Booking
		if (itinerary.getInsurances() != null) {
			itemRPH = this.prepareInsuranceInput(itinerary.getInsurances(),
					bapiInput, itemsMap, itemRPH);
		}

		// Guest Info input for Booking
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Transfer Info input for Booking
		if (itinerary.getTransferInfo() != null) {
			this.prepareTranseferInfoInput(itinerary.getTransferInfo(),
					bapiInput);
		}

		// Set IMApplication info
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());

		// Populate header type
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		if (itinerary.getSearchCriteria() != null
				&& itinerary.getSearchCriteria().getPromoCode() != null) {
			headerType.setPromo_Code(itinerary.getSearchCriteria()
					.getPromoCode());
		}
		if (itinerary.getItineraryPrice() != null) {
			headerType.setTotal(new BigDecimal(itinerary.getItineraryPrice()
					.getTotalPrice()));
			headerType.setCurrency(itinerary.getItineraryPrice().getCurrency());
		}
		if (itinerary.getBookingHeader() != null) {
			headerType.setCall_Center(itinerary.getBookingHeader()
					.getCallCenter());
		}
		bapiInput.setIm_Bapi_Req_Hdr(headerType);

		// Execute the BAPI
		Y_Ota_Booking_Output bapiOutput = (Y_Ota_Booking_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Ota_Booking",
						bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				bookingResponse);
		// Check for any business errors from BAPI
		if (bookingResponse.isBusinessErrorOccurred()) {
			return bookingResponse;
		}
		if(!isSeatMapServiceAvailable && itinerary.getSeatAllocationList() != null
				&& itinerary.getSeatAllocationList().size() > 0) {
			ABEWarning warning = new ABEWarning();
			warning.setErrorDescription("Sorry, No Seat Map service have been configured for this sector. Please contact Apple Vacations at 1-800-517-2000 to choose seats for this flight.");
			warning.setErrorCode("SEAT_SAP");
			bookingResponse.saveWarning(warning);
		}
		if (bapiOutput.getEx_St_Booking_Hdr() != null) {
			// Log booking number
			logBookingNumber(
					bapiOutput.getEx_St_Booking_Hdr().getBooking_Num(), false);
			itinerary.setBookingNo(bapiOutput.getEx_St_Booking_Hdr()
					.getBooking_Num());

			// Set the EDocs flag for the booking
			if ("1".equals(bapiOutput.getEx_St_Booking_Hdr().getEdoc())) {
				itinerary.setAllowEdocs(true);
			}

		}
		// set the itinerary
		bookingResponse.setItinerary(itinerary);
		return bookingResponse;
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
	private byte prepareFlightsInput(List<TripFlight> flights, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH) {
		Yst_Ota_Flt_ItemsType_List flightItemsList = null;
		Yst_Ota_Flt_SegmentsType_List segmentsList = null;
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			flightItemsList = bapiInput.get_as_listIt_Flt_Items();
			segmentsList = bapiInput.get_as_listIt_Flt_Segments();
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			flightItemsList = bapiInput.get_as_listIt_Flt_Items();
			segmentsList = bapiInput.get_as_listIt_Flt_Segments();
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			flightItemsList = bapiInput.get_as_listIt_Flt_Items();
			segmentsList = bapiInput.get_as_listIt_Flt_Segments();
		}
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
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			bapiInput.setIt_Flt_Items(flightItemsList);
			bapiInput.setIt_Flt_Segments(segmentsList);
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIt_Flt_Items(flightItemsList);
			bapiInput.setIt_Flt_Segments(segmentsList);
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			bapiInput.setIt_Flt_Items(flightItemsList);
			bapiInput.setIt_Flt_Segments(segmentsList);
		}
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
	private byte prepareHotelsInput(List<Hotel> hotels, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH, String flightType) {

		Yst_Ota_Htl_ItemsType_List itemsTypeList = null;
		Yst_Ota_RoomstaycandidatesType_List roomStayList = null;
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
			roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
			roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
			roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
		}

		if (itemsTypeList == null) {
			itemsTypeList = new Yst_Ota_Htl_ItemsType_List();
			roomStayList = new Yst_Ota_RoomstaycandidatesType_List();
		}
		for (Hotel hotel : hotels) {
			Yst_Ota_Htl_ItemsType_List hotelItemsList = HotelConvertUtils
					.prepareHotelItemTypeList(hotel, itemRPH, flightType,false);
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
						// Prepare room stay candidates
						if (hotel.getOccupancy() != null && hotel.getOccupancy().getPassengers() != null) {
							roomStayList.addAll(HotelConvertUtils
								.prepareRoomStayCandidates(
										hotel.getOccupancy(), roomPrice
												.getRoomId(), itemRPH));
						}
					}
				}
			}
		}
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
			bapiInput.setIt_Htl_Items(itemsTypeList);
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
			bapiInput.setIt_Htl_Items(itemsTypeList);
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
			bapiInput.setIt_Htl_Items(itemsTypeList);
		}
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
	private byte prepareVehiclesInput(List<Vehicle> vehicles, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH) {

		Yst_Ota_Veh_ItemsType_List vehicleItemsList = null;
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
		}

		if (vehicleItemsList == null) {
			vehicleItemsList = new Yst_Ota_Veh_ItemsType_List();
		}
		for (Vehicle vehicle : vehicles) {
			vehicleItemsList.add(VehicleConvertUtils.prepareVehItemType(
					vehicle, ++itemRPH));
			itemsMap.put(itemRPH, vehicle);
		}
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			bapiInput.setIt_Veh_Items(vehicleItemsList);
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIt_Veh_Items(vehicleItemsList);
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			bapiInput.setIt_Veh_Items(vehicleItemsList);
		}

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
	private byte preparePackagesInput(List<Package> packages, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH, Itinerary oldItinerary,
			List<SeatAllocations> curSeatAllocList) {
		boolean isHotelModify = ABEConstants.False;
		for (Package availablePackage : packages) {
			isHotelModify = ABEConstants.False;
			isHotelModify = SeatMapUtils.isHotelModified(availablePackage);
			if(isHotelModify && availablePackage.getSelectedFlight() != null) {
				availablePackage.getSelectedFlight().setHotelModified(isHotelModify);
			}
			if(availablePackage.getSelectedFlight() != null) {
				availablePackage.getSelectedFlight().setCpPackage(ABEConstants.TRUE);
			}
			itemRPH = preparePackageInput(availablePackage, input, itemsMap,
					itemRPH);
		}
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
	private byte preparePackageInput(Package availablePackage, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH) {
		byte vehicleRph = 0;
		byte flightRph = 0;
		Yst_Ota_Veh_ItemsType_List vehicleItemsList = null;

		if (availablePackage.getSelectedVehicle() != null) {
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				vehicleItemsList = bapiInput.get_as_listIt_Veh_Items();
			}
			if (vehicleItemsList == null) {
				vehicleItemsList = new Yst_Ota_Veh_ItemsType_List();
			}
			Vehicle vehicle = availablePackage.getSelectedVehicle();
			vehicleItemsList.add(VehicleConvertUtils.prepareVehItemType(
					vehicle, ++itemRPH));
			itemsMap.put(itemRPH, vehicle);
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				bapiInput.setIt_Veh_Items(vehicleItemsList);
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				bapiInput.setIt_Veh_Items(vehicleItemsList);
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				bapiInput.setIt_Veh_Items(vehicleItemsList);
			}

			vehicleRph = itemRPH;
		}

		if (availablePackage.getSelectedFlight() != null) {
			Yst_Ota_Flt_ItemsType_List flightItemsList = null;
			Yst_Ota_Flt_SegmentsType_List segmentsList = null;
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				flightItemsList = bapiInput.get_as_listIt_Flt_Items();
				segmentsList = bapiInput.get_as_listIt_Flt_Segments();
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				flightItemsList = bapiInput.get_as_listIt_Flt_Items();
				segmentsList = bapiInput.get_as_listIt_Flt_Segments();
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				flightItemsList = bapiInput.get_as_listIt_Flt_Items();
				segmentsList = bapiInput.get_as_listIt_Flt_Segments();
			}

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

			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				bapiInput.setIt_Flt_Items(flightItemsList);
				bapiInput.setIt_Flt_Segments(segmentsList);
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				bapiInput.setIt_Flt_Items(flightItemsList);
				bapiInput.setIt_Flt_Segments(segmentsList);
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				bapiInput.setIt_Flt_Items(flightItemsList);
				bapiInput.setIt_Flt_Segments(segmentsList);
			}
			flightRph = itemRPH;
		}

		if (availablePackage.getSelectedHotel() != null) {
			Yst_Ota_Htl_ItemsType_List itemsTypeList = null;
			Yst_Ota_RoomstaycandidatesType_List roomStayList = null;

			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
				roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
				roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				itemsTypeList = bapiInput.get_as_listIt_Htl_Items();
				roomStayList = bapiInput.get_as_listIt_Htl_Roomstaycandidates();
			}

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
						// Prepare room stay candidates
						if (hotel.getOccupancy() != null && hotel.getOccupancy().getPassengers() != null) {
							roomStayList.addAll(HotelConvertUtils
								.prepareRoomStayCandidates(
										hotel.getOccupancy(), roomPrice
												.getRoomId(), itemRPH));
						}
					}
				}
			}
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
				bapiInput.setIt_Htl_Items(itemsTypeList);
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
				bapiInput.setIt_Htl_Items(itemsTypeList);
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				bapiInput.setIt_Htl_Roomstaycandidates(roomStayList);
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
			List<MultiDestinationPackage> multiDestPkgs, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH) {

		for (MultiDestinationPackage multiDestPkg : multiDestPkgs) {
			// Flights Input for pricing
			if (multiDestPkg.getSelectedFlights() != null) {
				//CQ7968 - changing Trip_Ind "A" , "B"
				multiDestPkg.setSelectedFlights(FlightConvertUtils.modifyTripIndInFlights(multiDestPkg.getSelectedFlights()));
				itemRPH = this.prepareFlightsInput(multiDestPkg
						.getSelectedFlights(), input, itemsMap, itemRPH);
			}

			// Hotels Input for Pricing
			if (multiDestPkg.getSelectedHotels() != null) {
				String flightType = multiDestPkg.getSelectedFlights() != null ? "S"
						: null;
				itemRPH = this.prepareHotelsInput(multiDestPkg
						.getSelectedHotels(), input, itemsMap, itemRPH,
						flightType);
			}

			// Cars Input for Pricing
			if (multiDestPkg.getSelectedVehicles() != null) {
				itemRPH = this.prepareVehiclesInput(multiDestPkg
						.getSelectedVehicles(), input, itemsMap, itemRPH);
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
	private byte prepareServicesInput(Itinerary itinerary, Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH, ServicesResponse servicesResponse, Itinerary oldItinerary) {
		Yst_Ota_Ser_ItemsType_List serviceItemsList = new Yst_Ota_Ser_ItemsType_List();
		// Temporary variable
		HashMap<Service, List<Byte>> servicesMap = new HashMap<Service, List<Byte>>();
		
		boolean isHBSi = false;
		
		isHBSi= isItineraryHasHbsiHotel(itinerary);
		
		for (Service service : itinerary.getServices()) {
			// If the Service is free and mandatory, then we need not send them
			// for pricing and booking.
			
//			if (service.isMandatory() && service.isFree()) {
			// uncommented the code for mantis 279
			if (service.isMandatory() && service.isFree() && isHBSi == false) {
					itemRPH++;
					continue;
			}
			 
			
			// In multi-room bookings, if a supplement is linked with two rooms,
			// then we need to split the supplement to two line items.
			// And then attach assign the pax accordingly
			if (service.getGuestAllocation() != null) {
				if (service.getFlightMaterialCode() != null
						&& !"".equals(service.getFlightMaterialCode())) {
					// Process Flight specific supplements
					itemRPH = ServicesConvertUtils
							.processFlightSpecificSupplements(service,
									itinerary, itemsMap, serviceItemsList,
									itemRPH, servicesMap);
				} else if (service.getHotelMaterialCode() != null
						&& !"".equals(service.getHotelMaterialCode())) {
					// Process Hotel specific supplements
					itemRPH = ServicesConvertUtils
							.processHotelSpecificSupplements(service,
									itinerary, itemsMap, serviceItemsList,
									itemRPH, servicesMap);
				} else if (service.getDestination() != null
						&& !"".equals(service.getDestination())) {
					// Process destination specific supplements
					itemRPH = ServicesConvertUtils
							.processDestinationSpecificSupplements(service,
									itinerary, itemsMap, serviceItemsList,
									itemRPH, servicesMap);
				} else if (service.getGateway() != null
						&& !"".equals(service.getGateway())) {
					// Process gateway specific supplements
					itemRPH = ServicesConvertUtils
							.processGatewaySpecificSupplements(service,
									itinerary, itemsMap, serviceItemsList,
									itemRPH, servicesMap);
				}
			} else {
				serviceItemsList.add(ServicesConvertUtils
						.prepareServiceItemType(service, ++itemRPH));
				itemsMap.put(itemRPH, service);
			}
		}
		//Add seat map service here
		if(itinerary.getSeatAllocationList() != null && servicesResponse!= null 
				&& !servicesResponse.isErrorsOccurred() && SeatMapUtils.isSeatMapServiceAvailable(servicesResponse))
		{
			itemRPH = ServicesConvertUtils
				.processSeatSpecificServices(itinerary, serviceItemsList,
						itemRPH, servicesResponse, input, input instanceof Y_Ota_Change_Booking_Input, oldItinerary);
		}
		
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			bapiInput.setIt_Ser_Items(serviceItemsList);
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIt_Ser_Items(serviceItemsList);
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			bapiInput.setIt_Ser_Items(serviceItemsList);
		}
		return itemRPH;
	}

	
	private void prepareSeatsInput(Itinerary itin,  Object input,
			HashMap<Byte, Object> itemsMap, byte itemRPH, ServicesResponse servicesResponse)
	{
		Yzseat_Info_SType_List seatItemsList = new Yzseat_Info_SType_List();
		if(servicesResponse != null && !servicesResponse.isErrorsOccurred())
		{
			// Process Seat information
			ServicesConvertUtils
					.processSeatSpecificInformation(servicesResponse.getSeatServiceGroups(), itin.getSeatAllocationList(),
							seatItemsList);
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				bapiInput.setIt_Seatmap(seatItemsList);
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				bapiInput.setIt_Seatmap(seatItemsList);
			}		


		}
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
			Object input, HashMap<Byte, Object> itemsMap, byte itemRPH) {
		Yst_Bapi_Ins_ItemsType_List insuranceItemTypeList = null;
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			insuranceItemTypeList = bapiInput.get_as_listIt_Ins_Items();
			if (insuranceItemTypeList == null) {
				insuranceItemTypeList = new Yst_Bapi_Ins_ItemsType_List();
				bapiInput.setIt_Ins_Items(insuranceItemTypeList);
			}
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			insuranceItemTypeList = bapiInput.get_as_listIt_Ins_Items();
			if (insuranceItemTypeList == null) {
				insuranceItemTypeList = new Yst_Bapi_Ins_ItemsType_List();
				bapiInput.setIt_Ins_Items(insuranceItemTypeList);
			}
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			insuranceItemTypeList = bapiInput.get_as_listIt_Ins_Items();
			if (insuranceItemTypeList == null) {
				insuranceItemTypeList = new Yst_Bapi_Ins_ItemsType_List();
				bapiInput.setIt_Ins_Items(insuranceItemTypeList);
			}
		}
		// Loop through the insurance and check whether insurance is allocated.
		for (Insurance insurance : insuranceList) {
			if (insurance.getGuestAllocationList() != null) {
				// Insurance is allocated
				List<InsuranceGuestAllocation> allocationList = insurance
						.getGuestAllocationList();
				insurance.setGuestAllocationList(null);
				for (InsuranceGuestAllocation guestAllocation : allocationList) {
					insurance.setGuestAllocation(guestAllocation.getGuestID());
					insurance.setPosnr(guestAllocation.getPosnr());
					insurance.setOldPosnr(guestAllocation.getOldPosnr());
					insurance.setTotalPrice(guestAllocation.getPrice());
					insuranceItemTypeList.add(InsuranceConvertUtils
							.prepareInsuranceType(insurance, ++itemRPH));
				}
			} else {
				// Insurance is not allocated. Quantity based
				insuranceItemTypeList.add(InsuranceConvertUtils
						.prepareInsuranceType(insurance, ++itemRPH));
			}
		}
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
	private void prepareGuestsInput(List<GuestInfo> guests, Object input) {
		Yst_Ota_GuestinfoType_List guestInfoList = GuestInfoConvertUtil
				.prepareGuestInfoTypeList(guests);
		if (guestInfoList != null) {
			if (input instanceof Y_Ota_Booking_Input) {
				Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
				bapiInput.setIt_Guestinfo(guestInfoList);
			} else if (input instanceof Y_Ota_Change_Booking_Input) {
				Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
				bapiInput.setIt_Guestinfo(guestInfoList);
			} else if (input instanceof Y_Ota_Quote_Input) {
				Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
				bapiInput.setIt_Guestinfo(guestInfoList);
			}
		}
	}

	/**
	 * 
	 * Method to input transfer information to Booking
	 * 
	 * @param transferInfo
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareTranseferInfoInput(OpsAlert transfereInfo, Object input) {
		Yst_Bapi_Trn_ItemsType_List trasfersList = new Yst_Bapi_Trn_ItemsType_List();
		Yst_Bapi_Trn_ItemsType transferInfoItemType = new Yst_Bapi_Trn_ItemsType();
		if (transfereInfo.getInFlightInfo() != null
				&& transfereInfo.getOutFlightInfo() != null) {

			transferInfoItemType.setZzgateway(transfereInfo.getInFlightInfo()
					.getGateway());
			transferInfoItemType.setZzdestn(transfereInfo.getInFlightInfo()
					.getDestination());
			transferInfoItemType.setZzflt_No(transfereInfo.getInFlightInfo()
					.getFlightNo());
			transferInfoItemType.setZzal_Code(transfereInfo.getInFlightInfo()
					.getCarrier().getCarrierCode());
			transferInfoItemType.setZzarr_Date(new java.sql.Date(transfereInfo
					.getInFlightInfo().getArrivalDate().getTime()));

			transferInfoItemType.setZzgateway_2(transfereInfo
					.getOutFlightInfo().getGateway());
			transferInfoItemType.setZzdestn_2(transfereInfo.getOutFlightInfo()
					.getDestination());
			transferInfoItemType.setZzflt_No_2(transfereInfo.getOutFlightInfo()
					.getFlightNo());
			transferInfoItemType.setZzal_Code_2(transfereInfo
					.getOutFlightInfo().getCarrier().getCarrierCode());
			transferInfoItemType.setZzarr_Date2(new java.sql.Date(transfereInfo
					.getOutFlightInfo().getDepartureDate().getTime()));

		}
		transferInfoItemType.setZzdservice(transfereInfo.getService());
		transferInfoItemType.setZzhotel(transfereInfo.getHotelName());
		transferInfoItemType.setZzloctel(transfereInfo.getLocaltelephNo());
		transferInfoItemType.setZznames(transfereInfo.getUserName());
		transferInfoItemType.setZzstaddress(transfereInfo.getDocumentAddress()
				.getStreetAddress());
		transferInfoItemType.setZzcity(transfereInfo.getDocumentAddress()
				.getCity());
		transferInfoItemType.setZzstate(transfereInfo.getDocumentAddress()
				.getState());
		transferInfoItemType.setZzzip_Code(transfereInfo.getDocumentAddress()
				.getZipCode());
		transferInfoItemType.setZzta_Acnt(transfereInfo.getImApplicationInfo()
				.getAgentNumber());
		trasfersList.add(transferInfoItemType);
		if (input instanceof Y_Ota_Booking_Input) {
			Y_Ota_Booking_Input bapiInput = (Y_Ota_Booking_Input) input;
			bapiInput.setIt_Trn_Items(trasfersList);
		} else if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIt_Trn_Items(trasfersList);
		} else if (input instanceof Y_Ota_Quote_Input) {
			Y_Ota_Quote_Input bapiInput = (Y_Ota_Quote_Input) input;
			bapiInput.setIt_Trn_Items(trasfersList);
		}
	}

	/**
	 * Method to process and input deleted items for changed itinerary
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
			List<ABEDto> deletedList, Y_Ota_Change_Booking_Input bapiInput,
			HashMap<Byte, Object> itemsMap, byte itemRPH) {
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
							itemsMap, itemRPH, null);
				}
				if (object instanceof Vehicle) {
					// Process as a Vehicle
					List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
					vehiclesList.add((Vehicle) object);
					itemRPH = this.prepareVehiclesInput(vehiclesList,
							bapiInput, itemsMap, itemRPH);
				}
				if (object instanceof Service) {
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
				}
				if (object instanceof Insurance) {
					// Process as a Insurance
					List<Insurance> insuranceList = new ArrayList<Insurance>();
					insuranceList.add((Insurance) object);
					itemRPH = this.prepareInsuranceInput(insuranceList,
							bapiInput, itemsMap, itemRPH);
				} else if (object instanceof Package) {
					// Process as a Package
					Package availablePackage = (Package) object;
					itemRPH = preparePackageInput(availablePackage, bapiInput,
							itemsMap, itemRPH);
				}
			}
		}
		return itemRPH;
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
	public ItineraryResponse saveItineraryChanges(Itinerary itinerary, Itinerary oldItinerary, ServicesResponse servicesResponse) {
		ItineraryResponse bookingResponse = new ItineraryResponse();
		// Create Input for BAPI
		Y_Ota_Change_Booking_Input bapiInput = new Y_Ota_Change_Booking_Input();
		boolean isSeatMapServiceAvailable = false;
		List<SeatAllocations> curSeatAllocList = null;
		HashMap<Byte, Object> itemsMap = new HashMap<Byte, Object>();
		byte itemRPH = 0;

		// Flights Input
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemsMap, itemRPH);
		}

		// Hotels Input
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemsMap, itemRPH, null);
		}

		// Cars Input
		if (itinerary.getVehicles() != null) {
			itemRPH = this.prepareVehiclesInput(itinerary.getVehicles(),
					bapiInput, itemsMap, itemRPH);
		}

		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0)
		{
			if(servicesResponse != null) {
				isSeatMapServiceAvailable = SeatMapUtils.isSeatMapServiceAvailable(servicesResponse);
			}
		}
		if(isSeatMapServiceAvailable) {
			curSeatAllocList = itinerary.getSeatAllocationList();
		}

		// Packages Input
		if (itinerary.getPackages() != null) {
			itemRPH = this.preparePackagesInput(itinerary.getPackages(),
					bapiInput, itemsMap, itemRPH, oldItinerary, curSeatAllocList);
		}

		// Packages Input
		if (itinerary.getMultiDestinationPackages() != null) {
			itemRPH = this.prepareMultiDestPackagesInput(itinerary
					.getMultiDestinationPackages(), bapiInput, itemsMap,
					itemRPH);
		}

		// Services input
		if (itinerary.getServices() != null) {
			itemRPH = this.prepareServicesInput(itinerary, bapiInput, itemsMap,
					itemRPH, servicesResponse, oldItinerary);
		}

		// Insurance input
		if (itinerary.getInsurances() != null) {
			itemRPH = this.prepareInsuranceInput(itinerary.getInsurances(),
					bapiInput, itemsMap, itemRPH);
		}

		// Guest Info input
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Seats Input for Booking
		if(itinerary.getSeatAllocationList() != null && itinerary.getSeatAllocationList().size() > 0
				&& isSeatMapServiceAvailable && !itinerary.isBookingCancelled())
		{
			this.prepareSeatsInput(itinerary, bapiInput, itemsMap,
					itemRPH, servicesResponse);
		}
		
		// Changed Transfer Info input
		if (itinerary.getTransferInfo() != null) {
			this.prepareTranseferInfoInput(itinerary.getTransferInfo(),
					bapiInput);
		}
		
		//Prepare RFA Request Input
		if (itinerary.getRfaRequest() != null) {
			this.prepareRFARequestInput(bapiInput, itinerary.getRfaRequest());
		}
		// Deleted items list after change
		this.prepareDeletetedList(itinerary, itinerary.getDeletedList(),
				bapiInput, itemsMap, itemRPH);

		// Set IMApplication info
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());

		// Populate header type
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		if (itinerary.getSearchCriteria() != null
				&& itinerary.getSearchCriteria().getPromoCode() != null) {
			headerType.setPromo_Code(itinerary.getSearchCriteria()
					.getPromoCode());
		}
		if (itinerary.isBookingCancelled()) {
			headerType.setCancel_Booking_Ind("1");
		}
		if (itinerary.getItineraryPrice() != null) {
			headerType.setTotal(new BigDecimal(itinerary.getItineraryPrice()
					.getTotalPrice()));
			headerType.setCurrency(itinerary.getItineraryPrice().getCurrency());
		}
		if (itinerary.getBookingHeader() != null) {
			headerType.setCall_Center(itinerary.getBookingHeader()
					.getCallCenter());
		}
		headerType.setBooking_Num(itinerary.getBookingNo().trim());
		// BPG Indicator
		if (itinerary.isAllowBPG()) {
			headerType.setBpg_Ind("1");
		}
		bapiInput.setIm_Bapi_Req_Hdr(headerType);
		
		
		// Execute the BAPI 
		Y_Ota_Change_Booking_Output bapiOutput = (Y_Ota_Change_Booking_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Ota_Change_Booking",
						bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				bookingResponse);
		// Check for any business errors from BAPI
		if (bookingResponse.isBusinessErrorOccurred()) {
			return bookingResponse;
		}
		// Log Booking Number
		logBookingNumber(itinerary.getBookingNo(), true);

		// set the itinerary
		bookingResponse.setItinerary(itinerary);
		return bookingResponse;

	}

	/**
	 * 
	 * Method to save the itinerary or rather create a Quote
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ItineraryResponse saveItinerary(Itinerary itinerary) {

		ItineraryResponse bookingResponse = new ItineraryResponse();
		// Create Input for BAPI
		Y_Ota_Quote_Input bapiInput = new Y_Ota_Quote_Input();
		HashMap<Byte, Object> itemsMap = new HashMap<Byte, Object>();
		byte itemRPH = 0;

		// Flights Input for Booking
		if (itinerary.getFlights() != null) {
			itemRPH = this.prepareFlightsInput(itinerary.getFlights(),
					bapiInput, itemsMap, itemRPH);
		}

		// Hotels Input for Booking
		if (itinerary.getHotels() != null) {
			itemRPH = this.prepareHotelsInput(itinerary.getHotels(), bapiInput,
					itemsMap, itemRPH, null);
		}

		// Cars Input for Booking
		if (itinerary.getVehicles() != null) {
			itemRPH = this.prepareVehiclesInput(itinerary.getVehicles(),
					bapiInput, itemsMap, itemRPH);
		}

		// Packages Input for Booking
		if (itinerary.getPackages() != null) {
			itemRPH = this.preparePackagesInput(itinerary.getPackages(),
					bapiInput, itemsMap, itemRPH, null, null);
		}

		// Packages Input for Booking
		if (itinerary.getMultiDestinationPackages() != null) {
			itemRPH = this.prepareMultiDestPackagesInput(itinerary
					.getMultiDestinationPackages(), bapiInput, itemsMap,
					itemRPH);
		}
		ServicesResponse servicesResponse = null;
		// Services input for Booking
		if (itinerary.getServices() != null) {
			itemRPH = this.prepareServicesInput(itinerary, bapiInput, itemsMap,
					itemRPH, servicesResponse, null);
		}

		// Insurance input for Booking
		if (itinerary.getInsurances() != null) {
			itemRPH = this.prepareInsuranceInput(itinerary.getInsurances(),
					bapiInput, itemsMap, itemRPH);
		}

		// Guest Info input for Booking
		if (itinerary.getGuests() != null) {
			this.prepareGuestsInput(itinerary.getGuests(), bapiInput);
		}

		// Transfer Info input for Booking
		if (itinerary.getTransferInfo() != null) {
			this.prepareTranseferInfoInput(itinerary.getTransferInfo(),
					bapiInput);
		}

		// Set IMApplication info
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());

		// Populate header type
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		if (itinerary.getSearchCriteria() != null
				&& itinerary.getSearchCriteria().getPromoCode() != null) {
			headerType.setPromo_Code(itinerary.getSearchCriteria()
					.getPromoCode());
		}
		if (itinerary.getItineraryPrice() != null) {
			headerType.setTotal(new BigDecimal(itinerary.getItineraryPrice()
					.getTotalPrice()));
			headerType.setCurrency(itinerary.getItineraryPrice().getCurrency());
		}
		if (itinerary.getBookingHeader() != null) {
			headerType.setCall_Center(itinerary.getBookingHeader()
					.getCallCenter());
		}
		// set the user defined name for the quote
		if (itinerary.isTabUpdated() && itinerary.getName() != null) {
			headerType.setName(itinerary.getName());
		}

		bapiInput.setIm_Bapi_Req_Hdr(headerType);

		// Execute the BAPI
		Y_Ota_Quote_Output bapiOutput = (Y_Ota_Quote_Output) this
				.getBapiExecutionManager()
				.executeBAPI("Y_Ota_Quote", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				bookingResponse);
		// Check for any business errors from BAPI
		if (bookingResponse.isBusinessErrorOccurred()) {
			return bookingResponse;
		}
		if (bapiOutput.getEx_St_Booking_Hdr() != null) {
			itinerary.setQuoteNo(bapiOutput.getEx_St_Booking_Hdr()
					.getBooking_Num());
		}
		// set the itinerary
		bookingResponse.setItinerary(itinerary);
		return bookingResponse;
	}

	/**
	 * Method to display the booking log
	 * 
	 * @param bookingNumber
	 * @param changeBooking
	 * 
	 * @see
	 * @since
	 */
	private void logBookingNumber(String bookingNumber, boolean changeBooking) {
		StringBuffer sb = new StringBuffer();
		sb.append(bookingNumber);
		sb.append(" ");
		ABEApplicationContext context = this.getApplicationContextFactory()
				.getApplicationContext();
		ABERequestContext requestContext = context.getRequestContext();
		IMApplicationInfo imApplicationInfo = requestContext
				.getIMApplicationInfo();
		if (imApplicationInfo != null) {
			if (imApplicationInfo.getType().isTravelAgent()) {
				sb.append("TRAVEL_AGENT");
			} else {
				sb.append("RESGROUP");
			}
			sb.append(" ");
			sb.append(imApplicationInfo.getCreatedBy());
		}
		if (changeBooking) {
			sb.append(" CHANGE_BOOKING");
		}
		bookingLogger.debug(sb.toString());
	}

	public ItineraryResponse extendOptionDateOfItinerary(Itinerary itinerary) {
		ItineraryResponse extendOptionDateResponse = new ItineraryResponse();
		// Create Input for BAPI
		Y_Bapi_Extend_Opt_Date_Input bapiInput = new Y_Bapi_Extend_Opt_Date_Input();
		
		bapiInput.setIm_Application_Info(this.prepareIMApplicationInfo());
		bapiInput.setIm_Booking_Num(itinerary.getBookingHeader().getBookingNo());
		bapiInput.setIm_New_Suggested_Date(new java.sql.Date(itinerary.getExtendOptionDate().getTime()));
		// Execute the BAPI
		Y_Bapi_Extend_Opt_Date_Output bapiOutput = (Y_Bapi_Extend_Opt_Date_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Extend_Opt_Date", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				extendOptionDateResponse);
		// Check for any business errors from BAPI
		if (extendOptionDateResponse.isBusinessErrorOccurred()) {
			return extendOptionDateResponse;
		}
		extendOptionDateResponse.setItineraryExtendDate(bapiOutput
				.getEx_New_Date());
		return extendOptionDateResponse;
	}

	/**
	 * Method to price and cancel the itinerary of given booking no.
	 * 
	 * @param bookingNo
	 *            - Booking number of the itinerary to be canceled
	 * @param cancelItinerary
	 *            - If the flag is true, price and cancel the itinerary. If the
	 *            flag is false, then only price the itinerary for cancellation.
	 *            Do not cancel it.
	 * @return
	 */
	public ItineraryResponse priceAndCancelItinerary(String bookingNo,
			boolean cancelItinerary) {
		ItineraryResponse response = new ItineraryResponse();

		Y_Ota_Cancel_Reservation_Input bapiInput = new Y_Ota_Cancel_Reservation_Input();

		// Set ImApplicationInfo
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());
		Yst_Bapi_Req_HdrType headerType = new Yst_Bapi_Req_HdrType();
		headerType.setBooking_Num(bookingNo);
		if (cancelItinerary) {
			headerType.setCancel_Booking_Ind("1");
		}
		bapiInput.setIm_Bapi_Req_Hdr(headerType);
		
		// Execute the BAPI
		Y_Ota_Cancel_Reservation_Output bapiOutput = (Y_Ota_Cancel_Reservation_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Cancel_Reservation", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(), response);

		response.setItinerary(this.processItineraryDetails(bookingNo,
				bapiOutput));
		return response;
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
	private Itinerary processItineraryDetails(String bookingNo,
			Y_Ota_Cancel_Reservation_Output bapiOutput) {
		Itinerary itinerary = new Itinerary();
		itinerary.setBookingNo(bookingNo);

		// Parse guest info data in booking
		itinerary.setGuests(GuestInfoConvertUtil
				.processQuotedGuestInfo(bapiOutput.get_as_listIt_Guestinfo()));
		Map<String, Package> packagesMap = new HashMap<String, Package>();
		// Parse hotels data in booking
		itinerary
				.setHotels(HotelConvertUtils.processQuotedHotels(bapiOutput
						.get_as_listIt_Htl_Items(), itinerary.getGuests(),
						packagesMap));

		// Parse flights data in booking
		itinerary.setFlights(FlightConvertUtils.processQuotedFlights(bapiOutput
				.get_as_listIt_Flt_Items(), bapiOutput
				.get_as_listIt_Flt_Segments(), this.getAirportsTimeZones(),
				this.getAirlineNames(), itinerary.getGuests(), packagesMap));

		if (packagesMap.values() != null && packagesMap.values().size() != 0) {
			itinerary.setPackages(new ArrayList<Package>(packagesMap.values()));
			if (itinerary.getFlights().size() == 0) {
				itinerary.setFlights(null);
			}
			if (itinerary.getHotels().size() == 0) {
				itinerary.setHotels(null);
			}
		}

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

		// Set IMApplicationInfo back to Itinerary as it is required in
		// front-end
		IMApplicationInfo imApplicationInfo = this
				.getApplicationContextFactory().getApplicationContext()
				.getRequestContext().getIMApplicationInfo();
		itinerary.setImApplicationInfo(imApplicationInfo);

		// Set the cancellation rules
		itinerary.setCancellationRules(this
				.parseCancellationRules(bapiOutput.get_as_listIt_Infotext(),
						bapiOutput.get_as_listIt_Skedrules()));

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

		return itinerary;
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
		if (infoTypeList != null) {
			Iterator<Yst_InfotextType> infoIterator = infoTypeList.iterator();
			while (infoIterator.hasNext()) {
				Yst_InfotextType infoText = infoIterator.next();
				cancellationRules.addSkedInfoRules(infoText.getZzruletxt());
			}
		}

		if (skedRulesTypeList != null) {
			Iterator<Yst_FarerulesType> skedRulesIterator = skedRulesTypeList
					.iterator();
			while (skedRulesIterator.hasNext()) {
				Yst_FarerulesType skedRule = skedRulesIterator.next();
				cancellationRules.addSkedCancellationRules(skedRule.getText());
			}
		}
		return cancellationRules;
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
	 * Method to prepare RFARequest information
	 * 
	 * @param bapiInput
	 * @param rfaRequest
	 */
	private void prepareRFARequestInput(Object input,RFARequest rfaRequest){
		
		ZfbrapicType roomReqData = new ZfbrapicType();
		roomReqData.setVbeln(rfaRequest.getBookingNumber());
		roomReqData.setPosnr(rfaRequest.getPosnr());
		roomReqData.setZzcmd(rfaRequest.getVendorMode()); //VendorMode through which confirmationNo received
		roomReqData.setZzcno(rfaRequest.getConfirmationNumber());
		roomReqData.setZzrmode(rfaRequest.getRequestMode()); //RFARequest Mode CF/DL
		if(rfaRequest.getRequestMode()!=null && rfaRequest.getRequestMode().equals("CF")){
			roomReqData.setZzuser(rfaRequest.getRequestConfirmBy());
		}else if(rfaRequest.getRequestMode()!=null && rfaRequest.getRequestMode().equals("DL")){
            roomReqData.setZzuser(rfaRequest.getRequestDeclineBy());
        }
		roomReqData.setZztmd(rfaRequest.getAgentMode());
		roomReqData.setZztem(rfaRequest.getAgentEmailId());
		roomReqData.setZztfx(rfaRequest.getAgentFaxNo());
		roomReqData.setZztph(rfaRequest.getAgentPhoneNo());
		
		if (input instanceof Y_Ota_Change_Booking_Input) {
			Y_Ota_Change_Booking_Input bapiInput = (Y_Ota_Change_Booking_Input) input;
			bapiInput.setIm_Rfa_Cf_Dl_Flg(rfaRequest.getRequestMode());
			bapiInput.setRoom_Req_Data(roomReqData);
		}
		
	}
	
	private boolean isItineraryHasHbsiHotel(Itinerary itinerary)
	{
		if(itinerary.getHotels()!=null && itinerary.getHotels().size()>0)
		{
		for(int k=0;k<itinerary.getHotels().size();k++)
		{
			if(!itinerary.getHotels().get(k).isHBSI())
			{
				return false;
			}
				
		}
		}
		if(itinerary.getPackages()!=null && itinerary.getPackages().size()>0)
		{
			for(int k=0;k<itinerary.getPackages().size();k++)
			{
				if(itinerary.getPackages().get(k).getSelectedHotel()!=null && !itinerary.getPackages().get(k).getSelectedHotel().isHBSI())
				{
					return false;
				}
			}
		}
		
		if(itinerary.getMultiDestinationPackages()!=null && itinerary.getMultiDestinationPackages().size()>0)
		{
			for(int multiDestPack=0;multiDestPack<itinerary.getMultiDestinationPackages().size();multiDestPack++)
			{
				
				if(itinerary.getMultiDestinationPackages().get(multiDestPack)!=null && itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels()!=null)
				{
					for(int hbsiHotel=0;hbsiHotel<itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().size();hbsiHotel++)
					{
						if(itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel)!=null 
					&& !itinerary.getMultiDestinationPackages().get(multiDestPack).getSelectedHotels().get(hbsiHotel).isHBSI())
						
						{
							
							return false;
						}
					}
				}
				
				
			}
		}
		return true;
	}
	public ItineraryResponse updateSupplierConfirmation(HotelConfirmation hotelConfirmation) {
		ItineraryResponse updateZhpnrResponse = new ItineraryResponse();
		String sapBookingNumber = hotelConfirmation.getSapBookingNo();
		String pnrNumber = hotelConfirmation.getHotelPNRNo();
		String pmsConfirmation = hotelConfirmation.getHotelPMSConfirmationNo();
		Y_Ota_Cid_Update_Input bapiInput = new Y_Ota_Cid_Update_Input();
		Yst_Bapi_Appli_InfoType imAppliInfoType = new Yst_Bapi_Appli_InfoType();
		imAppliInfoType.setId_Context(ABE);
		imAppliInfoType.setCreatedby("OpsUser");
		bapiInput.setIm_St_Appli_Info(imAppliInfoType);
		Yst_Bapi_Req_HdrType bapiHeader = new Yst_Bapi_Req_HdrType();
		bapiHeader.setBooking_Num(sapBookingNumber);
		Yst_Ota_Htl_ItemsType_List htlItems_lst = new Yst_Ota_Htl_ItemsType_List();
		Yst_Ota_Htl_ItemsType htlItems = new Yst_Ota_Htl_ItemsType();
		htlItems.setSource_Partner("HBSI");
		htlItems.setSource_Pnrno(pnrNumber);
		htlItems.setHotel_Confirmno(pmsConfirmation);
		htlItems_lst.add(htlItems);
		bapiInput.setIm_Bapi_Req_Hdr(bapiHeader);
		bapiInput.setIt_Htl_Items(htlItems_lst);
		// Execute the BAPI
		Y_Ota_Cid_Update_Output bapiOutput = (Y_Ota_Cid_Update_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Ota_Cid_Update",
						bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				updateZhpnrResponse);
		// Check for any business errors from BAPI
		if (updateZhpnrResponse.isBusinessErrorOccurred()) {
			return updateZhpnrResponse;
		}
		return updateZhpnrResponse;
	}
}
