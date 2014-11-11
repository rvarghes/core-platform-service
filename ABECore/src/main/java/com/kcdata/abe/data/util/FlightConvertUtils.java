/*
 * FlightConvertUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2009  nvittal
 * Sep 23, 2009	 hguntupa	  Added additional methods for Flights convertion
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_Orig_DestType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType;
import com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType;
import com.kcdata.abe.bapi.Yzseat_Info_SType;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_Orig_DestType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List;
import com.kcdata.abe.bapi.util.Yzseat_Info_SType_List;
import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.data.dto.AgeCode;
import com.kcdata.abe.data.dto.CabinType;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.FareBasisCode;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightStatus;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.FlightType;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PaxTypeBasePrices;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.SeatMapRequest;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.DateUtils;
import com.kcdata.sms.data.dto.SMLinkViewRequest;
import com.kcdata.sms.data.dto.SMSearchCriteria;

/**
 * Utility class for conversions between SAP and Java objects
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class FlightConvertUtils {

	private static Gson gson = new Gson();
	private static GatewayDestinationsResponse gatewayDestResponse;
	private static Map<String, String> gatewayDestMap;
	/**
	 * Method to process the flight details returned by the BAPI
	 * 
	 * @param priceType
	 *            Yst_Ota_Flt_Orig_DestType
	 * @return Price
	 * 
	 * @see
	 * @since
	 */
	public static Price processFlightPriceDetails(
			Yst_Ota_Flt_Orig_DestType priceType) {
		Price price = new Price();
		price.setUsTax(priceType.getUs_Tax().doubleValue());
		price.setForeignTax(priceType.getForeign_Tax().doubleValue());
		price.setTotalTax(priceType.getTotal_Tax().doubleValue());
		price.setAirportFee(priceType.getAirport_Tax().doubleValue());
		price.setOccpancyBasedPrice(priceType.getTotal().doubleValue()+calculateLate(priceType));
		price.setAdultPrice(priceType.getAdult_Price().doubleValue());
		price.setChildPrice(priceType.getChild_Price().doubleValue());
		price.setInfantPrice(priceType.getInfant_Price().doubleValue());
		price.setLapchildPrice(priceType.getLap_Child_Price().doubleValue());
		price.setPackagePrice(priceType.getPkg_Total().doubleValue());
		price.setPromoSavings(priceType.getPromo_Savings().doubleValue());
		price.setPerAdultBasePrice(priceType.getPer_Adult_Base_Price().doubleValue());
		price.setLateFee(calculateLate(priceType));
		// Set PaxTypeBasePrices
		PaxTypeBasePrices paxTypeBasePrices = new PaxTypeBasePrices();
		paxTypeBasePrices.setNoOfAdults(priceType.getNo_Adults());
		paxTypeBasePrices.setNoOfChilds(priceType.getNo_Child());
		paxTypeBasePrices.setNoOfInfants(priceType.getNo_Infants());
		paxTypeBasePrices.setNoOfLapChilds(priceType.getNo_Lapchild());
		paxTypeBasePrices.setChild1Age(priceType.getChild1_Age());
		paxTypeBasePrices.setChild2Age(priceType.getChild2_Age());
		paxTypeBasePrices.setChild3Age(priceType.getChild3_Age());
		paxTypeBasePrices.setChild4Age(priceType.getChild4_Age());
		paxTypeBasePrices.setChild5Age(priceType.getChild5_Age());
		paxTypeBasePrices.setChild6Age(priceType.getChild6_Age());
		paxTypeBasePrices.setAdultBasePrice(priceType.getAdult_Base_Price().doubleValue());
		paxTypeBasePrices.setChildBasePrice(priceType.getChild_Base_Price().doubleValue());
		paxTypeBasePrices.setInfantBasePrice(priceType.getInfant_Base_Price().doubleValue());
		paxTypeBasePrices.setLapChildBasePrice(priceType.getLapchild_Base_Price().doubleValue());
		price.setPaxBasePrices(paxTypeBasePrices);

		return price;
	}
	
	private static double calculateLate(Yst_Ota_Flt_Orig_DestType priceType){		
		double lateFee=0;		
		 Date departureDate=priceType.getOut_Dep_Date();
		 Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
		 long duration=(DateUtils.dateDifferenceInDays(currentDate,departureDate));
		 if(duration<14){
			 int passengerCount=Integer.parseInt(priceType.getNo_Adults())+Integer.parseInt(priceType.getNo_Child())+Integer.parseInt(priceType.getNo_Infants());
			 lateFee=passengerCount*10;
		 }
		
		return lateFee;
		
	}

	/**
	 * Method to process the flight details returned by the BAPI
	 * 
	 * @param priceType
	 *            Yst_Ota_Res_FlightsType
	 * @return Price
	 * 
	 * @see
	 * @since
	 */
	public static Price processFlightPriceDetails(Yst_Ota_Res_FlightsType priceType) {
		Price price = new Price();
		if (priceType.getUs_Tax() != null) {
			price.setUsTax(priceType.getUs_Tax().doubleValue());
		}
		if (priceType.getForeign_Tax() != null) {
			price.setForeignTax(priceType.getForeign_Tax().doubleValue());
		}
		if (priceType.getTotal_Tax() != null) {
			price.setTotalTax(priceType.getTotal_Tax().doubleValue());
		}
		if (priceType.getAirport_Tax() != null) {
			price.setAirportFee(priceType.getAirport_Tax().doubleValue());
		}
		if (priceType.getTotal() != null) {
			price.setOccpancyBasedPrice(priceType.getTotal().doubleValue());
		}
		if (priceType.getAdult_Price() != null) {
			price.setAdultPrice(priceType.getAdult_Price().doubleValue());
		}
		if (priceType.getChild_Price() != null) {
			price.setChildPrice(priceType.getChild_Price().doubleValue());
		}
		if (priceType.getInfant_Price() != null) {
			price.setInfantPrice(priceType.getInfant_Price().doubleValue());
		}
		return price;
	}

	/**
	 * Method to process the flight details returned by the BAPI
	 * 
	 * @param priceType
	 *            Yst_Ota_Res_FlightsType
	 * @return Price
	 * 
	 * @see
	 * @since
	 */
	public static Price processQuotedFlightPriceDetails(Yst_Ota_Flt_ItemsType priceType) {
		Price price = new Price();
		if (priceType.getUs_Tax() != null) {
			price.setUsTax(priceType.getUs_Tax().doubleValue());
		}
		if (priceType.getForeign_Tax() != null) {
			price.setForeignTax(priceType.getForeign_Tax().doubleValue());
		}
		if (priceType.getTotal_Tax() != null) {
			price.setTotalTax(priceType.getTotal_Tax().doubleValue());
		}
		if (priceType.getAirport_Tax() != null) {
			price.setAirportFee(priceType.getAirport_Tax().doubleValue());
		}
		if (priceType.getTotal() != null) {
			price.setOccpancyBasedPrice(priceType.getTotal().doubleValue());
		}
		if (priceType.getAdult_Price() != null) {
			price.setAdultPrice(priceType.getAdult_Price().doubleValue());
		}
		if (priceType.getChild_Price() != null) {
			price.setChildPrice(priceType.getChild_Price().doubleValue());
		}
		if (priceType.getInfant_Price() != null) {
			price.setInfantPrice(priceType.getInfant_Price().doubleValue());
		}
		return price;
	}

	/**
	 * Method to iterate through flight segments and create a carrier info for
	 * the TripFlight. Loop through the segments and see If codeshare is exist
	 * any of the segment. If exist, return carrier with codeshare flag true.
	 * 
	 * @param tripFlight
	 *            TripFlight
	 * @return Carrier
	 * 
	 * @see
	 * @since
	 */
	public static Carrier processTripFlightCarrier(TripFlight tripFlight, Properties airlineNames) {
		Carrier carrier = null;
		Carrier codeShareCarrier = null;
		boolean isDifferentCarrier = false;
		String carrierCode = null;
		if (tripFlight.getOutboundFlight() != null) {
			for (FlightSegment segment : tripFlight.getOutboundFlight()
					.getFlightSegments()) {
				carrier = segment.getCarrier();
				if (carrierCode == null) {
					carrierCode = carrier.getCarrierCode();
				} else if (!carrier.getCarrierCode().equals(carrierCode)) {
					isDifferentCarrier = true;
				}
				if (carrier != null && carrier.isCodeshareAvaialable()) {
					codeShareCarrier = carrier;
				}
			}
		}
		if (tripFlight.getInboundFlight() != null) {
			for (FlightSegment segment : tripFlight.getInboundFlight()
					.getFlightSegments()) {
				carrier = segment.getCarrier();
				if (carrierCode == null) {
					carrierCode = carrier.getCarrierCode();
				} else if (!carrier.getCarrierCode().equals(carrierCode)) {
					isDifferentCarrier = true;
				}
				if (carrier != null && carrier.isCodeshareAvaialable()) {
					codeShareCarrier = carrier;
				}
			}
		}
		if (isDifferentCarrier) {
			Carrier toReturnCarrier = new Carrier("**", airlineNames.getProperty("**"));
			if(codeShareCarrier != null) {
				toReturnCarrier.setCodeshareAvaialable(true);
			}
			return toReturnCarrier;
		} else if (codeShareCarrier != null) {
			return codeShareCarrier;
		}
		return carrier;
	}

	/**
	 * Prepares occupancy details for the flight
	 * 
	 * @param flightOccupancy
	 *            Yst_Ota_Res_FlightsType
	 * @return Occupancy
	 * 
	 * @see
	 * @since
	 */
	public static Occupancy processOccupancy(
			Yst_Ota_Res_FlightsType flightOccupancy) {
		Occupancy occupancy = new Occupancy();

		occupancy.setNoOfAdults(Byte.parseByte(""
				+ flightOccupancy.getNo_Adults()));
		if (flightOccupancy.getNo_Child() != null)
			occupancy.setNoOfChilds(Byte.parseByte(flightOccupancy
					.getNo_Child()));
		if (flightOccupancy.getNo_Infants() != null)
			occupancy.setNoOfInfants(Byte.parseByte(flightOccupancy
					.getNo_Infants()));
		if (flightOccupancy.getNo_Seniors() != null)
			occupancy.setNoOfSeniors(Byte.parseByte(flightOccupancy
					.getNo_Seniors()));

		return occupancy;
	}

	/**
	 * Prepares occupancy details for the flight
	 * 
	 * @param flightOccupancy
	 *            Yst_Ota_Res_FlightsType
	 * @return Occupancy
	 * 
	 * @see
	 * @since
	 */
	public static Occupancy processQuotedOccupancy(
			Yst_Ota_Flt_ItemsType flightOccupancy) {
		Occupancy occupancy = new Occupancy();
		List<Passenger> passengersList = new ArrayList<Passenger>();
		byte noOfAdults = (byte) flightOccupancy.getNo_Adults();
		if (noOfAdults != 0) {
			occupancy.setNoOfAdults(noOfAdults);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.ADULT);
			passenger.setGuestCount(noOfAdults);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfInfants = Byte.parseByte(flightOccupancy.getNo_Infants());
		if (noOfInfants != 0) {
			occupancy.setNoOfInfants(noOfInfants);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.INFANT);
			passenger.setGuestCount(noOfInfants);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfLapChild = Byte.parseByte(flightOccupancy.getNo_Lapchild());
		if (noOfLapChild != 0) {
			occupancy.setNoOfLapChilds(noOfLapChild);
			Passenger passenger = new Passenger();
			passenger.setAgeCode(AgeCode.LAPCHILD);
			passenger.setGuestCount(noOfLapChild);
			passenger.setRoomNumber((byte) 1);
			passengersList.add(passenger);
		}
		byte noOfChilds = Byte.parseByte(flightOccupancy.getNo_Child());
		if (noOfChilds != 0) {
			occupancy.setNoOfChilds(noOfChilds);
			for (byte paxIndex = 1; paxIndex <= noOfChilds; paxIndex++) {
				Passenger passenger = new Passenger();
				passenger.setAgeCode(AgeCode.CHILD);
				passenger.setGuestCount((byte) 1);
				passenger.setRoomNumber((byte) 1);
				switch (paxIndex) {
				case 1:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild1_Age()));
					break;
				case 2:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild2_Age()));
					break;
				case 3:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild3_Age()));
					break;
				case 4:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild4_Age()));
					break;
				case 5:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild5_Age()));
					break;
				case 6:
					passenger.setAge(Byte.parseByte(flightOccupancy
							.getChild6_Age()));
					break;
				}

				passengersList.add(passenger);
			}
		}
		occupancy.setPassengers(passengersList);
		return occupancy;
	}

	/**
	 * Sets flight type based on type of flight & type of air
	 * 
	 * @param tripFlight
	 *            TripFlight
	 * @param flightType
	 *            String
	 * @param typeOfAir
	 *            String
	 * 
	 * @see
	 * @since
	 */
	public static void processFlightType(TripFlight tripFlight,
			String flightType, String typeOfAir) {
		if (tripFlight == null)
			return;
		if (flightType != null && !flightType.equals("")
				&& (flightType.charAt(0) == FlightType.CHARTER.getType())) {
			tripFlight.setFlightType(FlightType.CHARTER);
		} else {
			if (typeOfAir != null && !typeOfAir.equals("")
					&& typeOfAir.charAt(0) == FlightType.CONTRACTED.getCode()) {
				tripFlight.setFlightType(FlightType.CONTRACTED);
			} else {
				tripFlight.setFlightType(FlightType.PUBLISHED);
			}
		}
	}

	/**
	 * Sets trip indicator to flight object
	 * 
	 * @param tripFlight
	 *            TripFlight
	 * @param tripIndicator
	 *            String
	 * 
	 * @see
	 * @since
	 */
	public static void processTripIndicator(TripFlight tripFlight,
			String tripIndicator) {
		if (FlightTripType.ANCHOR.getType().equals(tripIndicator)) {
			tripFlight.setTripType(FlightTripType.ANCHOR);
		} else if (FlightTripType.ONEWAY.getType().equals(tripIndicator)) {
			tripFlight.setTripType(FlightTripType.ONEWAY);
		} else {
			tripFlight.setTripType(FlightTripType.ROUNDTRIP);
		}
	}

	/**
	 * Method to convert the OTA Segment to FlightSegment
	 * 
	 * @param otaSegment
	 *            Yst_Ota_Flt_SegmentsType
	 * @param aiportsTimeZones
	 *            Properties
	 * @param airlineNames
	 *            Properties
	 * @return FlightSegment
	 * 
	 * @see
	 * @since
	 */
	public static FlightSegment processFlightSegmentDetails(
			Yst_Ota_Flt_SegmentsType otaSegment, Properties aiportsTimeZones,
			Properties airlineNames) {
		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		FlightSegment segment = new FlightSegment();
		segment.setGateway(otaSegment.getDep_Locid());
		segment.setDestination(otaSegment.getArr_Locid());
		try {
			segment.setDepartureDate(sdfDateTime.parse(otaSegment.getDep_Date()
					+ " " + otaSegment.getDep_Time()));
			segment.setRotation(otaSegment.getRotation().charAt(0));
			segment.setArrivalDate(sdfDateTime.parse(otaSegment.getArr_Date()
					+ " " + otaSegment.getArr_Time()));
			segment.setTravelTime(DateUtils.timeDifference(segment
					.getDepartureDate(), aiportsTimeZones.getProperty(segment
					.getGateway()), segment.getArrivalDate(), aiportsTimeZones
					.getProperty(segment.getDestination())));
			/*CQ8775 - PNRNumber set for FlightSegments*/
			segment.setPnrNumber(otaSegment.getPnrnumber());
			segment.setFlightInfo(otaSegment.getZzchininf());
			segment.setFlightPhone(otaSegment.getZzflcnfno());

		} catch (Exception e) {
		}
		// Process airline carrier
		if ((otaSegment.getCode_Share() != null && !"".equals(otaSegment.getCode_Share().trim())) || 
			(otaSegment.getZcod_Sha_Inf() != null && !"".equals(otaSegment.getZcod_Sha_Inf()))) 
		{
			segment.setCarrier(new Carrier(otaSegment.getAirline_Code(),
					(String) airlineNames.get(otaSegment.getAirline_Code()),
					true));
			segment.setCodeShareCarrier(new Carrier(otaSegment.getCode_Share(),
					(String) airlineNames
							.get(otaSegment.getCode_Share().trim()), true, otaSegment.getZcod_Sha_Inf()));
		} else {
			segment.setCarrier(new Carrier(otaSegment.getAirline_Code(),
					(String) airlineNames.get(otaSegment.getAirline_Code()),
					false));
		}
		segment.setFlightNo(otaSegment.getFlight_No());
		if (otaSegment.getRec_Loc() != null
				&& !"".equals(otaSegment.getRec_Loc().trim())) {
			segment.setRecordLocator(otaSegment.getRec_Loc().trim());
		}
		if (otaSegment.getOvernight() != null
				&& otaSegment.getOvernight().length() > 0) {
			segment.setOverNight(true);
		}
		if (otaSegment.getStops() != null && otaSegment.getStops().length() > 0) {
			segment.setNoOfStops(Integer.parseInt(otaSegment.getStops()));
		}
		segment.setAircraftType(otaSegment.getAircraft_Type());
		segment.setMealsServed(otaSegment.getMeal_Info());
		segment.setClassOfService(otaSegment.getFlight_Class());
		if (otaSegment.getRotation() != null
				&& otaSegment.getRotation().length() > 0) {
			segment.setRotation(otaSegment.getRotation().charAt(0));
		}
		// segment.setSeatsAvailable(otaSegment.getFlight_Avail_Qty() + "");
		if (otaSegment.getCabin() != null && otaSegment.getCabin().length() > 0) {
			char cabinType = otaSegment.getCabin().charAt(0);
			if (cabinType == CabinType.FIRST.getType()) {
				segment.setCabinType(CabinType.FIRST);
			} else if (cabinType == CabinType.BUSINESS.getType()) {
				segment.setCabinType(CabinType.BUSINESS);
			} else if (cabinType == CabinType.ECONOMY.getType()) {
				segment.setCabinType(CabinType.ECONOMY);
			} else {
				segment.setCabinType(CabinType.PREMIUM_ECONOMY);
			}
		}
		if (otaSegment.getElec_Ticket() != null
				&& !"".equals(otaSegment.getElec_Ticket())) {
			segment.setETicket(Boolean
					.parseBoolean(otaSegment.getElec_Ticket()));
		}
		// Process fare basis code
		FareBasisCode fareBasisCode = new FareBasisCode();
		fareBasisCode.setAdultCode(otaSegment.getFare_Base_Code_Adult());
		fareBasisCode.setChildCode(otaSegment.getFare_Base_Code_Child());
		fareBasisCode.setInfantCode(otaSegment.getFare_Base_Code_Infant());
		segment.setFareBasisCode(fareBasisCode);

		segment.setSeatsAvailable(Byte.parseByte(otaSegment.getAvail_Seats()));
		return segment;
	}

	/**
	 * Private method to process the Flight Segments and prepare flight object
	 * 
	 * @param flight
	 *            Flight
	 * @param airportsTimeZones
	 *            Properties
	 * @param airlineNames
	 *            Properties
	 * 
	 * @see
	 * @since
	 */
	public static void processFlightDetails(Flight flight,
			Properties airportsTimeZones, Properties airlineNames) {
		List<FlightSegment> segmentsList = flight.getFlightSegments();
		FlightSegment firstSegment = segmentsList.get(0);
		FlightSegment lastSegment = segmentsList.get(segmentsList.size() - 1);
		flight.setDepartureTime(firstSegment.getDepartureDate());
		flight.setArrivalTime(lastSegment.getArrivalDate());
		flight.setDestination(lastSegment.getDestination());
		flight.setGateway(firstSegment.getGateway());
		flight.setFlightId(FlightUtils.generateFlightId(flight));
		flight.setFlightIdForSeatMap(FlightUtils.generateFlightIdFromFlight(flight));
		flight.setTravelTime(DateUtils.timeDifference(firstSegment
				.getDepartureDate(), airportsTimeZones.getProperty(firstSegment
				.getGateway().toUpperCase()), lastSegment.getArrivalDate(),
				airportsTimeZones.getProperty(lastSegment.getDestination()
						.toUpperCase())));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String departureDate = sdf.format(firstSegment.getDepartureDate());
		String arrivalDate = sdf.format(lastSegment.getArrivalDate());
		if (departureDate != null && !departureDate.equals(arrivalDate)) {
			flight.setOverNight(true);
		}
	}

	/**
	 * Method to process the Flight Segment details
	 * 
	 * @param segments
	 * @param flightItemRph
	 * @param segmentsList
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Flt_SegmentsType_List prepareFltSegmentsTypeList(
			TripFlight tripFlight, byte flightItemRph) {
		Yst_Ota_Flt_SegmentsType_List segmentsList = new Yst_Ota_Flt_SegmentsType_List();
		byte flightRph = 1;
		flightRph = prepareFlightSegmentsByDirection(tripFlight
				.getOutboundFlight().getFlightSegments(), flightItemRph,
				ABEConstants.OUTBOUND_DIRECTION, segmentsList, flightRph);
		if (!tripFlight.getTripType().isOnewayTrip()
				&& tripFlight.getInboundFlight() != null) {
			flightRph = prepareFlightSegmentsByDirection(tripFlight
					.getInboundFlight().getFlightSegments(), flightItemRph,
					ABEConstants.INBOUND_DIRECTION, segmentsList, flightRph);
		}
		return segmentsList;
	}

	/**
	 * Method to process the Flight Segment details based on direction
	 * 
	 * @param segments
	 * @param flightItemRph
	 * @param segmentsList
	 * 
	 * @see
	 * @since
	 */
	private static byte prepareFlightSegmentsByDirection(
			List<FlightSegment> segments, byte flightItemRph, String direction,
			Yst_Ota_Flt_SegmentsType_List segmentsList, byte flightRph) {
		if (segments == null) {
			return flightRph;
		}
		for (FlightSegment segment : segments) {
			Yst_Ota_Flt_SegmentsType segmentType = new Yst_Ota_Flt_SegmentsType();
			segmentType.setItem_Rph(flightItemRph + "");
			segmentType.setFlight_Rph(flightRph + "");
			segmentType.setDirection(direction);
			segmentType.setDep_Locid(segment.getGateway());
			segmentType.setArr_Locid(segment.getDestination());
			segmentType.setDep_Date(new java.sql.Date(segment
					.getDepartureDate().getTime()));
			segmentType.setDep_Time(new Time(segment.getDepartureDate()
					.getTime()));
			segmentType.setArr_Date(new java.sql.Date(segment.getArrivalDate()
					.getTime()));
			segmentType
					.setArr_Time(new Time(segment.getArrivalDate().getTime()));
			if (segment.getCarrier() != null) {
				segmentType.setAirline_Code(segment.getCarrier()
						.getCarrierCode());
			}
			segmentType.setFlight_No(segment.getFlightNo());
			if (segment.getCodeShareCarrier() != null) {
				segmentType.setCode_Share(segment.getCodeShareCarrier()
						.getCarrierCode());
				segmentType.setZcod_Sha_Inf(segment.getCodeShareCarrier().getCodeShareInfo());
			}
			segmentType.setOvernight(segment.isOverNight() ? "X" : "");
			segmentType.setStops("" + segment.getNoOfStops());
			segmentType.setAircraft_Type(segment.getAircraftType());
			segmentType.setMeal_Info(segment.getMealsServed());
			if (segment.getFareBasisCode() != null) {
				FareBasisCode farebasis = segment.getFareBasisCode();
				segmentType.setFare_Base_Code_Adult(farebasis.getAdultCode());
				segmentType.setFare_Base_Code_Child(farebasis.getChildCode());
				segmentType.setFare_Base_Code_Infant(farebasis.getInfantCode());
			}
			segmentType.setElapsed_Time(segment.getTravelTime() + "");
			segmentType.setFlight_Class(segment.getClassOfService());
			// if (segment.getSeatsAvailable() != null
			// && !segment.getSeatsAvailable().equals("")) {
			// segmentType.setFlight_Avail_Qty(new BigDecimal(segment
			// .getSeatsAvailable()));
			// }
			if (segment.getCabinType() != null) {
				segmentType.setCabin(segment.getCabinType().getType() + "");
			}
			segmentType.setElec_Ticket(segment.isETicket() + "");
			// Rotation should be from 0-9
			if (segment.getRotation() >= 48 && segment.getRotation() <= 57) {
				segmentType.setRotation(segment.getRotation() + "");
			}

			segmentType.setAvail_Seats("" + segment.getSeatsAvailable());
			segmentsList.add(segmentType);
			flightRph++;
		}
		return flightRph;
	}

	/**
	 * Method to prepare the flight items list
	 * 
	 * @param tripFlight
	 * @param flightItemRph
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Flt_ItemsType prepareFlightItemTypeList(
			TripFlight tripFlight, byte flightItemRph) {
		Yst_Ota_Flt_ItemsType flightItem = new Yst_Ota_Flt_ItemsType();
		//flightItemRPH is set in TripFlight for ASA 20 Seat Selection not printing on paper docs
		tripFlight.setFlightItemRPH(flightItemRph);
		flightItem.setItem_Rph(flightItemRph + "");
		// Set Flight outbound fields
		flightItem.setOut_Gateway(tripFlight.getOutboundFlight().getGateway());
		flightItem.setOut_Dest(tripFlight.getOutboundFlight().getDestination());
		if (tripFlight.getOutboundFlight().getDepartureTime() != null) {
			flightItem.setOut_Dep_Date(new java.sql.Date(tripFlight
					.getOutboundFlight().getDepartureTime().getTime()));
		}
		// Out-Bound POSNR numbers
		flightItem.setOut_Posnr(tripFlight.getOutboundFlight().getPosnr());
		flightItem.setOut_Old_Posnr(tripFlight.getOutboundFlight()
				.getOldPosnr());
		flightItem.setDuration(tripFlight.getDuration() + "");
		// Set Flight inbound fields
		if (tripFlight.getInboundFlight() != null) {
			flightItem
					.setIn_Gateway(tripFlight.getInboundFlight().getGateway());
			flightItem.setIn_Dest(tripFlight.getInboundFlight()
					.getDestination());
			if (tripFlight.getInboundFlight().getDepartureTime() != null) {
				flightItem.setIn_Dep_Date(new java.sql.Date(tripFlight
						.getInboundFlight().getDepartureTime().getTime()));
			}
			// InBound POSNR numbers
			flightItem.setIn_Posnr(tripFlight.getInboundFlight().getPosnr());
			flightItem.setIn_Old_Posnr(tripFlight.getInboundFlight()
					.getOldPosnr());
		}
		// Set class of service. Required for Charter flights
		if (tripFlight.getFlightType().isCharter()) {
			// Outbound class of service
			flightItem.setOut_Class(tripFlight.getOutboundFlight()
					.getFlightSegments().get(0).getClassOfService());
			// Inbound class of service
			if (!tripFlight.getTripType().isOnewayTrip()) {
				flightItem.setIn_Class(tripFlight.getInboundFlight()
						.getFlightSegments().get(0).getClassOfService());
			}
		}
		// Price structure details
		if (tripFlight.getPrice() != null) {
			Price flightPrice = tripFlight.getPrice();
			flightItem.setUs_Tax(new BigDecimal(flightPrice.getUsTax()));
			flightItem.setForeign_Tax(new BigDecimal(flightPrice
					.getForeignTax()));
			flightItem.setTotal_Tax(new BigDecimal(flightPrice.getTotalTax()));
			flightItem.setAirport_Tax(new BigDecimal(flightPrice
					.getAirportFee()));
			flightItem.setTotal(new BigDecimal(flightPrice
					.getOccpancyBasedPrice()-flightPrice.getLateFee()));
			flightItem.setAdult_Price(new BigDecimal(flightPrice
					.getAdultPrice()));
			flightItem.setChild_Price(new BigDecimal(flightPrice
					.getChildPrice()));
			flightItem.setInfant_Price(new BigDecimal(flightPrice
					.getInfantPrice()));
			flightItem.setLap_Child_Price(new BigDecimal(flightPrice
					.getLapchildPrice()));
			flightItem.setPromo_Savings(new BigDecimal(flightPrice
					.getPromoSavings()));
			flightItem.setPer_Adult_Base_Price(new BigDecimal(flightPrice
					.getPerAdultBasePrice()));
			// Set the PaxTypeBasePrices

			if (flightPrice.getPaxBasePrices() != null) {
				PaxTypeBasePrices paxTypeBasePrices = flightPrice
						.getPaxBasePrices();
				if (paxTypeBasePrices.getNoOfAdults() != null) {
					flightItem.setNo_Adults(Short.parseShort(paxTypeBasePrices
							.getNoOfAdults()));
				}
				flightItem.setNo_Child(paxTypeBasePrices.getNoOfChilds());
				flightItem.setNo_Infants(paxTypeBasePrices.getNoOfInfants());
				flightItem.setNo_Lapchild(paxTypeBasePrices.getNoOfLapChilds());
				flightItem.setChild1_Age(paxTypeBasePrices.getChild1Age());
				flightItem.setChild2_Age(paxTypeBasePrices.getChild2Age());
				flightItem.setChild3_Age(paxTypeBasePrices.getChild3Age());
				flightItem.setChild4_Age(paxTypeBasePrices.getChild4Age());
				flightItem.setChild5_Age(paxTypeBasePrices.getChild5Age());
				flightItem.setChild6_Age(paxTypeBasePrices.getChild6Age());
				flightItem.setAdult_Base_Price(new BigDecimal(paxTypeBasePrices
						.getAdultBasePrice()));
				flightItem.setChild_Base_Price(new BigDecimal(paxTypeBasePrices
						.getChildBasePrice()));
				flightItem.setInfant_Base_Price(new BigDecimal(
						paxTypeBasePrices.getInfantBasePrice()));
				flightItem.setLapchild_Base_Price(new BigDecimal(
						paxTypeBasePrices.getLapChildBasePrice()));
			} else {
				if (flightPrice.getInitialPrice() != null
						&& flightPrice.getInitialPrice().getPaxBasePrices() != null) {
					PaxTypeBasePrices paxTypeBasePrices = flightPrice
							.getInitialPrice().getPaxBasePrices();
					if (paxTypeBasePrices.getNoOfAdults() != null) {
						flightItem.setNo_Adults(Short
								.parseShort(paxTypeBasePrices.getNoOfAdults()));
					}
					flightItem.setNo_Child(paxTypeBasePrices.getNoOfChilds());
					flightItem
							.setNo_Infants(paxTypeBasePrices.getNoOfInfants());
					flightItem.setNo_Lapchild(paxTypeBasePrices
							.getNoOfLapChilds());
					flightItem.setChild1_Age(paxTypeBasePrices.getChild1Age());
					flightItem.setChild2_Age(paxTypeBasePrices.getChild2Age());
					flightItem.setChild3_Age(paxTypeBasePrices.getChild3Age());
					flightItem.setChild4_Age(paxTypeBasePrices.getChild4Age());
					flightItem.setChild5_Age(paxTypeBasePrices.getChild5Age());
					flightItem.setChild6_Age(paxTypeBasePrices.getChild6Age());
					flightItem.setAdult_Base_Price(new BigDecimal(
							paxTypeBasePrices.getAdultBasePrice()));
					flightItem.setChild_Base_Price(new BigDecimal(
							paxTypeBasePrices.getChildBasePrice()));
					flightItem.setInfant_Base_Price(new BigDecimal(
							paxTypeBasePrices.getInfantBasePrice()));
					flightItem.setLapchild_Base_Price(new BigDecimal(
							paxTypeBasePrices.getLapChildBasePrice()));
				}
			}
		}
		// Process Occupancy
		if (tripFlight.getOccupancy() != null) {
			Occupancy occupancy = tripFlight.getOccupancy();
			flightItem.setNo_Adults(occupancy.getNoOfAdults());
			flightItem.setNo_Child(occupancy.getNoOfChilds() + "");
			flightItem.setNo_Infants(occupancy.getNoOfInfants() + "");
			flightItem.setNo_Lapchild(occupancy.getNoOfLapChilds() + "");
			flightItem.setNo_Seniors(occupancy.getNoOfSeniors() + "");
			if (occupancy.getNoOfChilds() > 0) {
				setChildAges(flightItem, occupancy.getPassengers());
			}
		}
		// Set PAX allocation RPH
		flightItem.setPax_Alloc_Rph(tripFlight.getGuestAllocation());
		// Set flight request type
		flightItem
				.setFlight_Req_Type(tripFlight.getFlightType().getType() + "");
		flightItem.setType_Of_Air(tripFlight.getFlightType().getCode() + "");
		flightItem.setTrip_Ind(tripFlight.getTripType().getType());
		flightItem.setContract_No(tripFlight.getContractDocumentNo());
		flightItem.setRevision_No(tripFlight.getRevisionNo());
		flightItem.setLine_No(tripFlight.getLineNo());
		// Set the negotiated fare code
		flightItem.setNegotiatedfarecode(tripFlight.getNegotiatedFareCode());
		if (tripFlight.isPackageFlightNoChange()) {
			flightItem.setPkg_Flt_Nochange("X");
		}
		return flightItem;
	}

	/**
	 * Private method to set the child ages to Air Request
	 * 
	 * @param airRequest
	 * @param passList
	 * 
	 * @see
	 * @since
	 */
	private static void setChildAges(Yst_Ota_Flt_ItemsType itemType,
			List<Passenger> passList) {
		if (passList == null) {
			return;
		}
		byte childCount = 0;
		for (Passenger passenger : passList) {
			if (passenger.getAgeCode().isChild()) {
				childCount++;
				switch (childCount) {
				case 1:
					itemType.setChild1_Age(passenger.getAge() + "");
					break;
				case 2:
					itemType.setChild2_Age(passenger.getAge() + "");
					break;
				case 3:
					itemType.setChild3_Age(passenger.getAge() + "");
					break;
				case 4:
					itemType.setChild4_Age(passenger.getAge() + "");
					break;
				case 5:
					itemType.setChild5_Age(passenger.getAge() + "");
					break;
				case 6:
					itemType.setChild6_Age(passenger.getAge() + "");
					break;
				}
			}
		}
	}

	/**
	 * Method to prepare Yst_Ota_Flt_Orig_DestType from TripFlight object
	 * 
	 * @param tripFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static Yst_Ota_Flt_Orig_DestType prepareFltOrigDestType(
			TripFlight tripFlight, byte flightItemRph) {
		Yst_Ota_Flt_Orig_DestType origdestType = new Yst_Ota_Flt_Orig_DestType();
		origdestType.setItem_Rph("" + flightItemRph);
		if (tripFlight.getOutboundFlight() != null) {
			origdestType.setOut_Gateway(tripFlight.getOutboundFlight()
					.getGateway());
			origdestType.setOut_Dest(tripFlight.getOutboundFlight()
					.getDestination());
			origdestType.setOut_Dep_Date(new Date(tripFlight
					.getOutboundFlight().getDepartureTime().getTime()));
			origdestType.setOut_Dep_Time(new Time(tripFlight
					.getOutboundFlight().getDepartureTime().getTime()));
		}
		if (tripFlight.getInboundFlight() != null) {
			origdestType.setIn_Gateway(tripFlight.getInboundFlight()
					.getGateway());
			origdestType.setIn_Dest(tripFlight.getInboundFlight()
					.getDestination());
			origdestType.setIn_Dep_Date(new Date(tripFlight.getInboundFlight()
					.getDepartureTime().getTime()));
			origdestType.setIn_Dep_Time(new Time(tripFlight.getInboundFlight()
					.getDepartureTime().getTime()));
		}
		origdestType.setDuration("" + tripFlight.getDuration());
		// Set the price details
		Price price = tripFlight.getPrice();
		if (price != null) {
			origdestType.setUs_Tax(new BigDecimal(price.getUsTax()));
			origdestType.setForeign_Tax(new BigDecimal(price.getForeignTax()));
			origdestType.setTotal_Tax(new BigDecimal(price.getTotalTax()));
			origdestType.setAirport_Tax(new BigDecimal(price.getAirportFee()));
			origdestType
					.setTotal(new BigDecimal(price.getOccpancyBasedPrice()));
			origdestType.setAdult_Price(new BigDecimal(price.getAdultPrice()));
			origdestType.setChild_Price(new BigDecimal(price.getChildPrice()));
			origdestType
					.setInfant_Price(new BigDecimal(price.getInfantPrice()));
			origdestType.setLap_Child_Price(new BigDecimal(price
					.getLapchildPrice()));
			origdestType.setPromo_Savings(new BigDecimal(price
					.getPromoSavings()));
			origdestType.setPer_Adult_Base_Price(new BigDecimal(price
					.getPerAdultBasePrice()));
			// Set the PaxTypeBasePrices
			if (price.getPaxBasePrices() != null) {
				PaxTypeBasePrices paxTypeBasePrices = price.getPaxBasePrices();
				origdestType.setNo_Adults(paxTypeBasePrices.getNoOfAdults());
				origdestType.setNo_Child(paxTypeBasePrices.getNoOfChilds());
				origdestType.setNo_Infants(paxTypeBasePrices.getNoOfInfants());
				origdestType.setNo_Lapchild(paxTypeBasePrices
						.getNoOfLapChilds());
				origdestType.setChild1_Age(paxTypeBasePrices.getChild1Age());
				origdestType.setChild2_Age(paxTypeBasePrices.getChild2Age());
				origdestType.setChild3_Age(paxTypeBasePrices.getChild3Age());
				origdestType.setChild4_Age(paxTypeBasePrices.getChild4Age());
				origdestType.setChild5_Age(paxTypeBasePrices.getChild5Age());
				origdestType.setChild6_Age(paxTypeBasePrices.getChild6Age());
				origdestType.setAdult_Base_Price(new BigDecimal(
						paxTypeBasePrices.getAdultBasePrice()));
				origdestType.setChild_Base_Price(new BigDecimal(
						paxTypeBasePrices.getChildBasePrice()));
				origdestType.setInfant_Base_Price(new BigDecimal(
						paxTypeBasePrices.getInfantBasePrice()));
				origdestType.setLapchild_Base_Price(new BigDecimal(
						paxTypeBasePrices.getLapChildBasePrice()));
			}
		}
		// Process Occupancy
		if (tripFlight.getOccupancy() != null) {
			Occupancy occupancy = tripFlight.getOccupancy();
			origdestType.setNo_Adults(occupancy.getNoOfAdults() + "");
			origdestType.setNo_Child(occupancy.getNoOfChilds() + "");
			origdestType.setNo_Infants(occupancy.getNoOfInfants() + "");
			origdestType.setNo_Lapchild(occupancy.getNoOfLapChilds() + "");
			if (occupancy.getNoOfChilds() > 0) {
				setChildAges(origdestType, occupancy.getPassengers());
			}
		}

		// Set flight request type and type of air
		origdestType.setFlight_Req_Type(""
				+ tripFlight.getFlightType().getType());
		origdestType.setType_Of_Air("" + tripFlight.getFlightType().getCode());
		// Set the contract document details
		origdestType.setContract_No(tripFlight.getContractDocumentNo());
		origdestType.setRevision_No(tripFlight.getRevisionNo());
		origdestType.setLine_No(tripFlight.getLineNo());
		return origdestType;
	}

	/**
	 * Method to convert the flights list from SAP to Dto objects
	 * 
	 * @param segmentsList
	 * @param origDestList
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<TripFlight> convertFlightsResponse(
			Yst_Ota_Flt_SegmentsType_List segmentsList,
			Yst_Ota_Flt_Orig_DestType_List origDestList,
			FlightsRequest flightsRequest, Properties airportsTimeZones,
			Properties airlineNames) {
		if (segmentsList == null || segmentsList.isEmpty()
				|| origDestList == null || origDestList.isEmpty()
				|| flightsRequest == null) {
			return null;
		}
		List<TripFlight> flightsList = new ArrayList<TripFlight>();
		Iterator<Yst_Ota_Flt_SegmentsType> segmentsIterator = segmentsList
				.iterator();
		Iterator<Yst_Ota_Flt_Orig_DestType> origDestIterator = origDestList
				.iterator();

		String currentItemRph = null;
		String currentDirection = null;
		TripFlight currentTripFlight = null;
		Flight currentFlight = null;

		while (segmentsIterator.hasNext()) {
			Yst_Ota_Flt_SegmentsType otaSegment = segmentsIterator.next();
			if (currentItemRph == null) {
				currentItemRph = otaSegment.getItem_Rph();
				currentDirection = otaSegment.getDirection();
				currentTripFlight = new TripFlight();
				currentTripFlight.setOccupancy(flightsRequest.getOccupancy());
				currentTripFlight.setTripType(flightsRequest.getTripType());
				currentTripFlight.setStatus(FlightStatus.AVAILABLE);
				currentFlight = new Flight();
			} else {
				if (!currentItemRph.equals(otaSegment.getItem_Rph())) {
					// Assign currentFlight object as a Inbound flight to
					// currentTripFlight
					FlightConvertUtils.processFlightDetails(currentFlight,
							airportsTimeZones, airlineNames);
					if (flightsRequest.getTripType().isOnewayTrip()) {
						currentTripFlight.setOutboundFlight(currentFlight);
					} else {
						currentTripFlight.setInboundFlight(currentFlight);
					}
					// Need to process the pricing information for the
					// currentTripFlight
					Yst_Ota_Flt_Orig_DestType origDestType = origDestIterator
							.next();
					// Populate flight price details
					currentTripFlight.setPrice(FlightConvertUtils
							.processFlightPriceDetails(origDestType));
					// Populate air type
					FlightConvertUtils.processFlightType(currentTripFlight,
							origDestType.getFlight_Req_Type(), origDestType
									.getType_Of_Air());
					// Populate Carrier info for the Trip Flight
					currentTripFlight.setCarrier(FlightConvertUtils
							.processTripFlightCarrier(currentTripFlight, airlineNames));
					// Populate contact details
					currentTripFlight.setContractDocumentNo(origDestType
							.getContract_No());
					currentTripFlight.setRevisionNo(origDestType
							.getRevision_No());
					currentTripFlight.setLineNo(origDestType.getLine_No());
					currentTripFlight.setNegotiatedFareCode(origDestType
							.getNegotiatedfarecode());
					if (origDestType.getDuration() != null) {
						currentTripFlight.setDuration(Integer
								.parseInt(origDestType.getDuration()));
					} else {
						currentTripFlight.setDuration(flightsRequest
								.getNoOfNights());
					}
					currentTripFlight = updateTripFlightStops(currentTripFlight);
					// Add the currentTripFlight to the TripFlights list
					flightsList.add(currentTripFlight);
					// Prepare a new TripFlight object and assign to
					// currentTripFlight
					currentTripFlight = new TripFlight();
					currentTripFlight.setTripType(flightsRequest.getTripType());
					currentTripFlight.setStatus(FlightStatus.AVAILABLE);
					currentTripFlight.setOccupancy(flightsRequest
							.getOccupancy());
					currentFlight = new Flight();
					// reset currentItemRph value to new value
					currentItemRph = otaSegment.getItem_Rph();
					currentDirection = otaSegment.getDirection();
				} else {
					if (!flightsRequest.getTripType().isOnewayTrip()
							&& !currentDirection.equals(otaSegment
									.getDirection())) {
						// Set the current Flight as a Outbound flight of
						// currentTripFlight.
						FlightConvertUtils.processFlightDetails(currentFlight,
								airportsTimeZones, airlineNames);
						currentTripFlight.setOutboundFlight(currentFlight);
						// Then create new Flight object and assign it to the
						// currentFlight.
						currentFlight = new Flight();
						// reset the currentDirection value to a new value
						currentDirection = otaSegment.getDirection();
					}
				}
			}
			// Process the segment and create FlightSegment
			FlightSegment flightSegment = FlightConvertUtils
					.processFlightSegmentDetails(otaSegment, airportsTimeZones,
							airlineNames);
			// Add the newly created segment to the currentFlight
			if (currentFlight.getFlightSegments() == null) {
				List<FlightSegment> segmentList = new ArrayList<FlightSegment>();
				currentFlight.setFlightSegments(segmentList);
			}
			currentFlight.getFlightSegments().add(flightSegment);
		}
		// Process the last TripFlight
		// Assign currentFlight object as a Inbound flight to
		// currentTripFlight
		FlightConvertUtils.processFlightDetails(currentFlight,
				airportsTimeZones, airlineNames);
		if (flightsRequest.getTripType().isOnewayTrip()) {
			currentTripFlight.setOutboundFlight(currentFlight);
		} else {
			currentTripFlight.setInboundFlight(currentFlight);
		}
		// Need to process the pricing information for the
		// currentTripFlight
		Yst_Ota_Flt_Orig_DestType origDestType = origDestIterator.next();
		currentTripFlight.setPrice(FlightConvertUtils
				.processFlightPriceDetails(origDestType));

		// Set flight type - Chartered / Contracted Sked / Published Sked
		FlightConvertUtils.processFlightType(currentTripFlight, origDestType
				.getFlight_Req_Type(), origDestType.getType_Of_Air());

		// Populate Carrier info for the Trip Flight
		currentTripFlight.setCarrier(FlightConvertUtils
				.processTripFlightCarrier(currentTripFlight, airlineNames));

		// Populate contact details
		currentTripFlight.setContractDocumentNo(origDestType.getContract_No());
		currentTripFlight.setRevisionNo(origDestType.getRevision_No());
		currentTripFlight.setLineNo(origDestType.getLine_No());
		currentTripFlight.setNegotiatedFareCode(origDestType
				.getNegotiatedfarecode());
		if (origDestType.getDuration() != null) {
			currentTripFlight.setDuration(Integer.parseInt(origDestType
					.getDuration()));
		} else {
			currentTripFlight.setDuration(flightsRequest.getNoOfNights());
		}
		currentTripFlight = updateTripFlightStops(currentTripFlight);
		// Add the currentTripFlight to the TripFlights list
		flightsList.add(currentTripFlight);

		return flightsList;
	}

	/**
	 * Method parses the reserved flights data in the booking
	 * 
	 * @param get_as_listIt_Res_Flights
	 * @param get_as_listIt_Flight_Segments
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<TripFlight> processReservedFlights(
			Yst_Ota_Res_FlightsType_List reservedFlights,
			Yst_Ota_Flt_SegmentsType_List flightSegments,
			Properties aiportsTimeZones, Properties airlineNames,
			List<GuestInfo> guests) {
		if (reservedFlights == null || reservedFlights.isEmpty()) {
			return null;
		}
		// Map to hold trip flights list with flight itemRPH as key
		HashMap<String, TripFlight> tripFlightsMap = new HashMap<String, TripFlight>();
		// Flights list
		List<TripFlight> flightsList = new ArrayList();

		// Flights iterator
		Iterator<Yst_Ota_Res_FlightsType> itFlights = reservedFlights
				.iterator();
		// Parse through flights data
		while (itFlights.hasNext()) {
			Yst_Ota_Res_FlightsType tripFlightRow = itFlights.next();
			TripFlight tripFlight = new TripFlight();
			tripFlight.setDuration(Integer
					.parseInt(tripFlightRow.getDuration()));

			// Set price data to trip flight
			tripFlight.setPrice(FlightConvertUtils
					.processFlightPriceDetails(tripFlightRow));

			// Set occupancy details to trip flight
			tripFlight.setOccupancy(FlightConvertUtils
					.processOccupancy(tripFlightRow));

			// Set the ticketed date
			tripFlight.setTicketedDate(tripFlightRow.getTicketed_Date());

			tripFlight.setGuestAllocation(tripFlightRow.getPax_Alloc_Rph());

			// Set flight type - Chartered / Contracted Sked / Published Sked
			FlightConvertUtils.processFlightType(tripFlight, tripFlightRow
					.getFlight_Req_Type(), tripFlightRow.getType_Of_Air());

			// Set trip indicator
			FlightConvertUtils.processTripIndicator(tripFlight, tripFlightRow
					.getTrip_Ind());

			// Place trip flight object in hash map
			tripFlightsMap.put(tripFlightRow.getItem_Rph(), tripFlight);
			flightsList.add(tripFlight);
		} // End of trip flights loop
		// Process flight segments list
		processReservedFlightSegments(tripFlightsMap, flightSegments,
				aiportsTimeZones, airlineNames);

		// Parse logic for POSNR numbers
		itFlights = reservedFlights.iterator();
		// Parse through flights data
		while (itFlights.hasNext()) {
			Yst_Ota_Res_FlightsType tripFlightRow = itFlights.next();
			TripFlight tripFlight = tripFlightsMap.get(tripFlightRow
					.getItem_Rph());
			if (tripFlight.getOutboundFlight() != null) {
				tripFlight.getOutboundFlight().setPosnr(
						tripFlightRow.getOut_Posnr());
			}
			if (tripFlight.getInboundFlight() != null) {
				tripFlight.getInboundFlight().setPosnr(
						tripFlightRow.getIn_Posnr());
			}
		}

		for (TripFlight tripFlight : flightsList) {
			// Populate Occupancy for the flight
			populateFlightOccupancy(tripFlight, guests);

			tripFlight = updateTripFlightStops(tripFlight);

			// Populate Carrier info for the Trip Flight
			tripFlight.setCarrier(FlightConvertUtils
					.processTripFlightCarrier(tripFlight, airlineNames));
		}
		return flightsList;
	}

	/**
	 * Method parses the reserved flights data in the booking
	 * 
	 * @param get_as_listIt_Res_Flights
	 * @param get_as_listIt_Flight_Segments
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public static List<TripFlight> processQuotedFlights(
			Yst_Ota_Flt_ItemsType_List quotedFlights,
			Yst_Ota_Flt_SegmentsType_List flightSegments,
			Properties aiportsTimeZones, Properties airlineNames,
			List<GuestInfo> guests, Map<String, Package> packagesMap) {
		if (quotedFlights == null || quotedFlights.isEmpty()) {
			return null;
		}
		// Map to hold trip flights list with flight itemRPH as key
		HashMap<String, TripFlight> tripFlightsMap = new HashMap<String, TripFlight>();
		// Flights list
		List<TripFlight> flightsList = new ArrayList();

		// Flights iterator
		Iterator<Yst_Ota_Flt_ItemsType> itFlights = quotedFlights.iterator();
		// Parse through flights data
		while (itFlights.hasNext()) {
			Yst_Ota_Flt_ItemsType tripFlightRow = itFlights.next();
			TripFlight tripFlight = new TripFlight();
			tripFlight.setDuration(Integer
					.parseInt(tripFlightRow.getDuration()));

			// Set price data to trip flight
			tripFlight.setPrice(FlightConvertUtils
					.processQuotedFlightPriceDetails(tripFlightRow));

			tripFlight.setGuestAllocation(tripFlightRow.getPax_Alloc_Rph());

			if (tripFlightRow.getPax_Alloc_Rph() != null
					&& !"".equals(tripFlightRow.getPax_Alloc_Rph())) {
				// Populate Occupancy for the flight
				populateFlightOccupancy(tripFlight, guests);
			} else {
				// Set occupancy details to trip flight
				tripFlight.setOccupancy(FlightConvertUtils
						.processQuotedOccupancy(tripFlightRow));
			}

			// Set flight type - Chartered / Contracted Sked / Published Sked
			FlightConvertUtils.processFlightType(tripFlight, tripFlightRow
					.getFlight_Req_Type(), tripFlightRow.getType_Of_Air());

			// Set trip indicator
			FlightConvertUtils.processTripIndicator(tripFlight, tripFlightRow
					.getTrip_Ind());

			// Place trip flight object in hash map
			tripFlightsMap.put(tripFlightRow.getItem_Rph(), tripFlight);
			flightsList.add(tripFlight);
		} // End of trip flights loop
		// Process flight segments list
		processReservedFlightSegments(tripFlightsMap, flightSegments,
				aiportsTimeZones, airlineNames);

		// Parse logic for POSNR numbers
		itFlights = quotedFlights.iterator();
		// Parse through flights data
		for (TripFlight tripFlight : flightsList) {
			// Populate Carrier info for the Trip Flight
			tripFlight.setCarrier(FlightConvertUtils
					.processTripFlightCarrier(tripFlight, airlineNames));
		}
		
		while (itFlights.hasNext()) {
			Yst_Ota_Flt_ItemsType tripFlightRow = itFlights.next();
			TripFlight tripFlight = tripFlightsMap.get(tripFlightRow
					.getItem_Rph());
			if (tripFlight.getOutboundFlight() != null) {
				tripFlight.getOutboundFlight().setPosnr(
						tripFlightRow.getOut_Posnr());
			}
			if (tripFlight.getInboundFlight() != null) {
				tripFlight.getInboundFlight().setPosnr(
						tripFlightRow.getIn_Posnr());
			}
			Set<String> flightItemRPHList = packagesMap.keySet();
			if(flightItemRPHList.contains(tripFlightRow.getItem_Rph())) {
				Package selectedPackage = packagesMap.get(tripFlightRow.getItem_Rph());
				selectedPackage.setSelectedFlight(tripFlight);
				flightsList.remove(tripFlight);
			}	
		}
		
		return flightsList;
	}

	/**
	 * Method processes flight segments list
	 * 
	 * @param tripFlightsMap
	 *            HashMap
	 * @param flightSegmentsList
	 *            Yst_Ota_Flt_SegmentsType_List
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private static void processReservedFlightSegments(
			HashMap<String, TripFlight> tripFlightsMap,
			Yst_Ota_Flt_SegmentsType_List flightSegmentsList,
			Properties airportsTimeZones, Properties airlineNames) {
		if (tripFlightsMap.isEmpty() || flightSegmentsList == null)
			return;

		Iterator<Yst_Ota_Flt_SegmentsType> itSegments = flightSegmentsList
				.iterator();
		// Parse the segments list
		while (itSegments.hasNext()) {
			Yst_Ota_Flt_SegmentsType segmentRow = itSegments.next();

			FlightSegment flightSegment = FlightConvertUtils
					.processFlightSegmentDetails(segmentRow, airportsTimeZones,
							airlineNames);
			// Retrieve respective trip flight object from map
			TripFlight tripFlight = tripFlightsMap
					.get(segmentRow.getItem_Rph());
			if (tripFlight != null) {
				if (segmentRow.getDirection() != null) {
					Flight flight = new Flight();
					boolean isOutbound = true;
					// Outbound flight
					if (segmentRow.getDirection().charAt(0) == '1') {
						if (tripFlight.getOutboundFlight() != null)
							flight = tripFlight.getOutboundFlight();
					} else {
						if (tripFlight.getInboundFlight() != null) {
							flight = tripFlight.getInboundFlight();
						}
						isOutbound = false;
					}
					// Get the segments list for current flight
					ArrayList<FlightSegment> flightSegments = (ArrayList<FlightSegment>) flight
							.getFlightSegments();

					if (flight.getFlightSegments() == null) {
						flightSegments = new ArrayList<FlightSegment>();
					}
					// Add new flight segment to list
					flightSegments.add(flightSegment);
					flight.setFlightSegments(flightSegments);

					// Process flight segment details to prepare flight object
					FlightConvertUtils.processFlightDetails(flight,
							airportsTimeZones, airlineNames);
					// Set flight object back to trip flight
					if (isOutbound) {
						tripFlight.setOutboundFlight(flight);
					} else {
						tripFlight.setInboundFlight(flight);
					}
				} // End of segment direction condition
			} // End of trip flight condition
		} // End of segments loop
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
	private static void populateFlightOccupancy(TripFlight tripFlight,
			List<GuestInfo> guests) {
		Occupancy occupancy = new Occupancy();
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		String guestIds[] = StringUtils
				.commaDelimitedListToStringArray(tripFlight
						.getGuestAllocation());
		for (byte index = 0; index < guestIds.length; index++) {
			byte guestId = Byte.parseByte(guestIds[index]);
			for (GuestInfo guestInfo : guests) {
				if (guestInfo.getGuestId().equals("" + guestId)) {
					Passenger passenger = new Passenger();
					passenger.setAgeCode(guestInfo.getAgeCode());
					passenger.setGuestCount((byte) 1);
					passenger.setPaxId(guestId);
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
			}
		}
		occupancy.setPassengers(passengers);
		tripFlight.setOccupancy(occupancy);
	}

	/**
	 * Private method to set the child ages to Flight origin and destination
	 * 
	 * @param flightOrigDestType
	 * @param passList
	 * 
	 * @see
	 * @since
	 */
	private static void setChildAges(
			Yst_Ota_Flt_Orig_DestType flightOrigDestType,
			List<Passenger> passList) {
		byte childCount = 0;
		for (Passenger passenger : passList) {
			if (passenger.getAgeCode().isChild()) {
				childCount++;
				switch (childCount) {
				case 1:
					flightOrigDestType.setChild1_Age(passenger.getAge() + "");
					break;
				case 2:
					flightOrigDestType.setChild2_Age(passenger.getAge() + "");
					break;
				case 3:
					flightOrigDestType.setChild3_Age(passenger.getAge() + "");
					break;
				case 4:
					flightOrigDestType.setChild4_Age(passenger.getAge() + "");
					break;
				case 5:
					flightOrigDestType.setChild5_Age(passenger.getAge() + "");
					break;
				case 6:
					flightOrigDestType.setChild6_Age(passenger.getAge() + "");
					break;
				}
			}
		}
	}

	/**
	 * Method to update no. of stops for flights because stops information for
	 * some flights is not available during the availability
	 * 
	 * @param tripFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static TripFlight updateTripFlightStops(TripFlight tripFlight) {
		tripFlight.setOutboundFlight(updateFlightStops(tripFlight
				.getOutboundFlight()));
		tripFlight.setInboundFlight(updateFlightStops(tripFlight
				.getInboundFlight()));
		return tripFlight;
	}

	/**
	 * Method to update no. of stops for charter flight because stops
	 * information for charters is not available during the availability
	 * 
	 * @param tripFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private static Flight updateFlightStops(Flight flight) {
		if (flight == null) {
			return null;
		}
		byte stops = 0;
		for (FlightSegment flightSegment : flight.getFlightSegments()) {
			stops += flightSegment.getNoOfStops();
		}
		stops = (byte) (stops + flight.getFlightSegments().size() - 1);
		flight.setNoOfStops("" + stops);
		return flight;
	}

	/**
	 * Method to validate the islandCity pair
	 * 
	 * @param tripFlight
	 * @param islandCityList
	 * @return
	 */
	public static boolean isIslandCityPair(TripFlight tripFlight, final List<String> islandCityList){
		String gateway = tripFlight.getOutboundFlight().getGateway();
		String destination = tripFlight.getOutboundFlight().getDestination();
		boolean isGatewayStopover = false;
		boolean isDestStopover = false;
		if(islandCityList!=null && islandCityList.size()>0){
			Iterator<String> cityPairItr = islandCityList.iterator();
			while(cityPairItr.hasNext()){
				String city = cityPairItr.next();
				if(gateway!=null && gateway.equals(city)){
					isGatewayStopover=true;
				}
				if(destination!=null && destination.equals(city)){
					isDestStopover=true;
				}
				if(isGatewayStopover && isDestStopover){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Methods to modify Trip Indicator for Fights Information
	 * @param flightList
	 * @return
	 */
	public static List<TripFlight> modifyTripIndInFlights(List<TripFlight> flightList){
		List<TripFlight> modifiedFlightList = new ArrayList<TripFlight>();
		if(flightList!=null && flightList.size() !=0){
			Iterator<TripFlight> flightsItr = flightList.iterator();
			while(flightsItr.hasNext()){
				TripFlight tripFlight = flightsItr.next();
				
				if(tripFlight.getTripType().isAnchorTrip()){
					tripFlight.setTripType(FlightTripType.ROUNDTRIP);
				}//End
				modifiedFlightList.add(tripFlight);
			}
		}
		return modifiedFlightList;
	}
	
	/**
	 * Method to populate Seat map request at segment level and TripFlight level
	 * @param flightList of type List<TripFlight>
	 * @param gatewayDestinationsService of type GatewayDestinationsService
	 * @param itin of type Itinerary
	 */
	public static void populateSeatMapJsonReq(List<TripFlight> flightList, GatewayDestinationsService gatewayDestinationsService, Itinerary itin)
	{
		if(itin != null) 
		{
			flightList = SeatMapUtils.getTripFlights(itin);
		}
		if(flightList != null && flightList.size() >0) 
		{
			String isGroupRequest="N";
			if(itin!=null && itin.getBookingHeader()!=null){
				isGroupRequest="ZGR".equalsIgnoreCase(itin.getBookingHeader().getBookingDocumentType())?"Y":"N";
			}
			String seatMapConcatReq;
			for (TripFlight tripFlight : flightList) {
				String legIdConcat = ABEConstants.BLANK;
				seatMapConcatReq = ABEConstants.BLANK;
				if(tripFlight.getFlightType() != null && tripFlight.getFlightType().isCharter())
				{
					if(gatewayDestResponse == null)
					{
						gatewayDestResponse = gatewayDestinationsService.retrieveGatewayDestinations();
						gatewayDestMap = gatewayDestResponse.getGatewayDestCodeAndNameMap();
					}
					Flight outboundFlight = tripFlight.getOutboundFlight();
					Flight inboundFlight = tripFlight.getInboundFlight();
					
					seatMapConcatReq = populateSeatMapRequestJson(outboundFlight,isGroupRequest);
					legIdConcat = outboundFlight.getFlightIdForSeatMap();
					if (inboundFlight != null)
					{
						seatMapConcatReq = seatMapConcatReq +ABEConstants.DOLLAR + populateSeatMapRequestJson(inboundFlight,isGroupRequest);
						legIdConcat += ABEConstants.DOLLAR+inboundFlight.getFlightIdForSeatMap();
					}
				}
				tripFlight.setLegIdConcat(legIdConcat);
				tripFlight.setSeatMapConcatReq(seatMapConcatReq);				
			}
		}
		
	}
	 //Method added for setting GroupBooking Request while pricing

	/**
	 * Method to populate Seat map request at segment level and TripFlight level
	 * @param flightList of type List<TripFlight>
	 * @param gatewayDestinationsService of type GatewayDestinationsService
	 * @param itin of type Itinerary
	 */
	public static void populateSeatMapJsonReq(List<TripFlight> flightList, GatewayDestinationsService gatewayDestinationsService, boolean isGroupRequestFlag)
	{
		if(flightList != null && flightList.size() >0) 
		{
			String isGroupRequest="N";
			if(isGroupRequestFlag){
				isGroupRequest="Y";
			}
			String seatMapConcatReq;
			for (TripFlight tripFlight : flightList) {
				String legIdConcat = ABEConstants.BLANK;
				seatMapConcatReq = ABEConstants.BLANK;
				if(tripFlight.getFlightType() != null && tripFlight.getFlightType().isCharter())
				{
					if(gatewayDestResponse == null)
					{
						gatewayDestResponse = gatewayDestinationsService.retrieveGatewayDestinations();
						gatewayDestMap = gatewayDestResponse.getGatewayDestCodeAndNameMap();
					}
					Flight outboundFlight = tripFlight.getOutboundFlight();
					Flight inboundFlight = tripFlight.getInboundFlight();
					
					seatMapConcatReq = populateSeatMapRequestJson(outboundFlight,isGroupRequest);
					legIdConcat = outboundFlight.getFlightIdForSeatMap();
					if (inboundFlight != null)
					{
						seatMapConcatReq = seatMapConcatReq +ABEConstants.DOLLAR + populateSeatMapRequestJson(inboundFlight,isGroupRequest);
						legIdConcat += ABEConstants.DOLLAR+inboundFlight.getFlightIdForSeatMap();
					}
				}
				tripFlight.setLegIdConcat(legIdConcat);
				tripFlight.setSeatMapConcatReq(seatMapConcatReq);				
			}
		}
	}
	
	
	/**
	 * Method to populate seat map request at FlightSegment level
	 * @param flightSegments of type List<FlightSegment>
	 * @param flightSegId of type String
	 * @param seatMapConcatReq of type String
	 * @return String type
	 */
	/*private static String populateSeatMapJsonForSegments(List<FlightSegment> flightSegments, String flightSegId)
	{
		String seatMapConcatReq = ABEConstants.BLANK;
		if(flightSegments != null && flightSegments.size() > 0)
		{
			for (FlightSegment flightSegment : flightSegments) {
				String flightSeg = SeatMapUtils.getFlightSegArray(flightSegId, flightSegment.getGateway()+flightSegment.getDestination());
				if(StringUtils.hasText(seatMapConcatReq))
				{
					seatMapConcatReq = seatMapConcatReq + ABEConstants.FRONT_SLASH_DOLLAR + populateSeatMapRequestJson(flightSegment, flightSeg);
				} else {
					seatMapConcatReq = populateSeatMapRequestJson(flightSegment, flightSeg);
				}
				flightSegment.setSeatMapReqJson(seatMapConcatReq);
			}
		}
		return seatMapConcatReq;
	}*/
	
	/**
	 * Method to create JSON request
	 * @param flightSeg of type FlightSegment
	 * @param flightSegId of type String
	 * @return String type
	 */
	public static String populateSeatMapRequestJson(Flight flight,String isGroupRequest) {
		
		FlightSegment flightSeg = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
		SeatMapRequest seatMapRequest = new SeatMapRequest();
		seatMapRequest.setGatewayCode(flight.getGateway());
		seatMapRequest.setCarrier(flightSeg.getCarrier().getCarrierCode());
		seatMapRequest.setDestinationCode(flight.getDestination());
		seatMapRequest.setRotation(String.valueOf(flightSeg.getRotation()));
		seatMapRequest.setSegmentId(flight.getFlightIdForSeatMap());
		seatMapRequest.setCabinClass(flightSeg.getClassOfService());
		seatMapRequest.setDate(flightSeg.getDepartureDate().toString()); //TODO: Need to change as per format provided
		seatMapRequest.setGatewayName(retrieveLocationName(flight.getGateway(), gatewayDestMap));
		seatMapRequest.setDestinationName(retrieveLocationName(flight.getDestination(), gatewayDestMap));
		if(flight.getContractId() != null) {
			seatMapRequest.setContractId(flight.getContractId());
		}
		seatMapRequest.setGroupBlockedRequest(isGroupRequest);
		return gson.toJson(seatMapRequest);
	}

	/**
	 * Returns the gateway or destination name from code
	 *  
	 * @param locationId String type
	 * @return name of String type
	 */
	public static String retrieveLocationName(String locationId, Map<String, String> gatewayDestMap) {
		String locationStr = null;
		if(gatewayDestMap != null && gatewayDestMap.containsKey(locationId)) {
			locationStr = gatewayDestMap.get(locationId);
		}
		if(locationStr != null) {
			return locationStr;
		} else {
			return locationId;
		}
	}
	
	/**
	 * Method which populates SMLinkViewRequest while retrieve booking
	 * @param itin of type Itinerary
	 * @return SMLinkViewRequest type
	 */
	public static SMLinkViewRequest populateSmAvailRequestForRetrieveBooking(Itinerary itin) {
		SMLinkViewRequest smLinkViewRequest = new SMLinkViewRequest();
		List<SMSearchCriteria> smSearchCriteriaList = new ArrayList<SMSearchCriteria>();
		List<SeatAllocations> seatAllocations =  itin.getSeatAllocationList();
		Map<String, String> seatAllocMap = new HashMap<String, String>();
		if(seatAllocations != null && seatAllocations.size() > 0)
		{
			for (SeatAllocations seatAlloc : seatAllocations) {
				seatAllocMap.put(seatAlloc.getSegmentID(), seatAlloc.getSegmentID());				
			}
		}
		List<TripFlight> tripFlightList = SeatMapUtils.getTripFlights(itin);
		for (TripFlight tripFlight : tripFlightList) {
			if(tripFlight.getFlightType().isCharter())
			{
				Flight flight = tripFlight.getOutboundFlight();
				if(seatAllocMap.containsKey(flight.getFlightIdForSeatMap()))
				{
					//Set seat map available true
//					setSeatMapAvailable(flight);
					flight.setSeatMapAvailable(true);
				} else {
					populateSmAvailReq(smSearchCriteriaList, tripFlight);
				}
			}			
		}
		smLinkViewRequest.setSmSearchCriteriaDTOList(smSearchCriteriaList);
		return smLinkViewRequest;
	}
	
	/**
	 * Method which populates SmAvailRequest while reterieve booking
	 * @param smSearchCriteriaList of type List<SMSearchCriteria>
	 * @param tripFlight of type TripFlight
	 */
	private static void populateSmAvailReq(List<SMSearchCriteria> smSearchCriteriaList, TripFlight tripFlight)
	{
		Flight flight;
		List<FlightSegment> flightSegList;
		FlightTripType tripType = tripFlight.getTripType();
		if(tripType != null)
		{
			flight = tripFlight.getOutboundFlight();
			FlightSegment flightSeg = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
//			flightSegList = flight.getFlightSegments();
//			for (FlightSegment flightSegment : flightSegList) {
				smSearchCriteriaList.add(createSearchCriteriaRequest(flight, flightSeg));				
//			}
			if(tripType.isRoundTrip())
			{
				flight = tripFlight.getInboundFlight();
				flightSeg = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
//				flightSegList = flight.getFlightSegments();
//				for (FlightSegment flightSegment : flightSegList) {
					smSearchCriteriaList.add(createSearchCriteriaRequest(flight, flightSeg));
//				}
			}
		}
	}
	
	/**
	 * Method to create SMSearchCriteria type of criteria
	 * @param flightSegment of type FlightSegment
	 * @return searchCriteria of type SMSearchCriteria
	 */
	private static SMSearchCriteria createSearchCriteriaRequest(Flight flight, FlightSegment flightSegment)
	{
		SMSearchCriteria searchCriteria = new SMSearchCriteria();
		searchCriteria.setDaysAhead(0);
		searchCriteria.setDaysBehind(0);
		searchCriteria.setOrigin(flight.getGateway());
		searchCriteria.setDestination(flight.getDestination());
		searchCriteria.setDepartureDate(flightSegment.getDepartureDate());
		searchCriteria.setAirlineCode(flightSegment.getCarrier().getCarrierCode());
		searchCriteria.setRotation(Character.getNumericValue(flightSegment.getRotation()));
		return searchCriteria;
	}
	
	/**
	 * Method to set seat map available true
	 * @param flight of type Flight
	 */
//	private static void setSeatMapAvailable(Flight flight)
//	{
//		List<FlightSegment> flightSegList =  flight.getFlightSegments();
//		for (FlightSegment flightSeg : flightSegList) {
//			flightSeg.setSeatMapAvailable(true);
//			break;
//		}
//	}
	

	/**
	 * Method to populate SeatAllocations list from Yzseat_Info_SType_List
	 * @param seatInfoTypeList of type Yzseat_Info_SType_List
	 * @param itin of type Itinerary
	 * @return seatAllocList of type List<SeatAllocations>
	 */
	public static List<SeatAllocations> processSeatAllocations(Yzseat_Info_SType_List seatInfoTypeList, Itinerary itin)
	{
		List<SeatAllocations> seatAllocList = new ArrayList<SeatAllocations>();
		if(seatInfoTypeList != null)
		{
			Iterator<Yzseat_Info_SType> seatInfoTypeItr = seatInfoTypeList.iterator();
			while(seatInfoTypeItr.hasNext())
			{
				Yzseat_Info_SType seatInfoType = seatInfoTypeItr.next();
				SeatAllocations seatAlloc = new SeatAllocations();
				if (StringUtils.hasText(seatInfoType.getPax_Id())) {
					seatAlloc.setSNo(Integer.valueOf(seatInfoType.getPax_Id()).toString());
				}
				seatAlloc.setPaxNo(seatInfoType.getPax_Id());
				seatAlloc.setPaxName(getPaxName(seatInfoType.getPax_Id(), itin.getGuests()));
				if(seatInfoType.getZzprice() != null)
				{
					seatAlloc.setSeatPrice(new Double(seatInfoType.getZzprice().doubleValue()));
				}
				seatAlloc.setSeatNo(seatInfoType.getZztstno());
				seatAlloc.setCabinClass(seatInfoType.getYzcstno());
				if(seatInfoType.getYzcost() != null)
				{
					seatAlloc.setSeatCost(new Double(seatInfoType.getYzcost().doubleValue()));
				}
				seatAlloc.setSeatDescription(seatInfoType.getYzltxt());
				seatAlloc.setSelectedDate(seatInfoType.getYzssdt());
				seatAlloc.setSeatType(seatInfoType.getYzstty());
				seatAlloc.setParentItemRph(seatInfoType.getParent_Item_Rph());
//				seatAlloc.setSegmentID(seatInfoType.getYzltxt());
				setSegmentIdAndDepDate(seatInfoType.getYzstmat(), itin, seatInfoType.getPax_Id(), seatInfoType.getYzssdt(), seatAlloc);
				if(!StringUtils.hasText(seatAlloc.getSegmentID()))
				{
					seatAlloc.setSegmentID(seatAlloc.getSeatDescription());
				}
				seatAllocList.add(seatAlloc);
			}
		}
		return seatAllocList;
	}
	
	/**
	 * Method to get segId on the basis of seat material code
	 * @param seatMaterialCode of type String
	 * @param itin of type Itinerary
	 * @return flightSeg of type String 
	 */
	private static void setSegmentIdAndDepDate(String seatMaterialCode, Itinerary itin,String paxdId, String departureDate , SeatAllocations seatAllocations)
	{
		String flightSeg = ABEConstants.BLANK;
		String departDate = ABEConstants.BLANK;
		SimpleDateFormat sdfFormat = new SimpleDateFormat(ABEConstants.SEAT_SELECTED_DATE_FORMAT);
		if(seatMaterialCode != null)
		{
			seatMaterialCode = seatMaterialCode.substring(0, 6);
			List<TripFlight> flights = itin.getFlights();
			for (TripFlight tripFlight : flights) {
				Flight outboundFlight = tripFlight.getOutboundFlight();
				Flight inboundFlight = tripFlight.getInboundFlight();
				//String[] segIdArr = null;
				String[] guestAllocaitonsArray = tripFlight.getGuestAllocation().split(ABEConstants.COMMA);
				if(outboundFlight != null && outboundFlight.getFlightIdForSeatMap() != null)
				{
					for (String string : guestAllocaitonsArray) {
						if(outboundFlight.getFlightIdForSeatMap().contains(seatMaterialCode) && string.equalsIgnoreCase(paxdId)
								&& departureDate.equalsIgnoreCase(sdfFormat.format(outboundFlight.getDepartureTime())))
						{
							flightSeg = outboundFlight.getFlightIdForSeatMap();
							departDate = outboundFlight.getDepartureTime().toString();
							break;
						}
					}
				}
				if(inboundFlight != null && inboundFlight.getFlightIdForSeatMap() != null)
				{
					for (String string : guestAllocaitonsArray) {
						if(inboundFlight.getFlightIdForSeatMap().contains(seatMaterialCode)&& string.equalsIgnoreCase(paxdId)
								&& departureDate.equalsIgnoreCase(sdfFormat.format(inboundFlight.getDepartureTime())))
						{
							flightSeg = inboundFlight.getFlightIdForSeatMap();
							departDate = inboundFlight.getDepartureTime().toString();
							break;
						}
					}
				}
			}
		}
		seatAllocations.setSegmentID(flightSeg);
		seatAllocations.setDepartDate(departDate);
		
	}
	
	/**
	 * Method to get pax name from guest info list
	 * @param paxId of type String
	 * @param gusetInfoList of type List<GuestInfo>
	 * @return of type String
	 */
	private static String getPaxName(String paxId, List<GuestInfo> gusetInfoList)
	{
		String paxName = ABEConstants.BLANK;
		if(gusetInfoList != null && gusetInfoList.size() > 0)
		{
			for (GuestInfo guestInfo : gusetInfoList) {
				if(StringUtils.hasText(paxId) && StringUtils.hasText(guestInfo.getGuestId())
						&& Integer.parseInt(paxId) == Integer.parseInt(guestInfo.getGuestId()))
				{
					paxName = guestInfo.getFirstName()+ABEConstants.BLANK_SPACE+guestInfo.getLastName();
					break;
				}
			}
		}
		return paxName;
	}
	
	/**
	 * Method to populate seat map seg id in case the results are not comming from SAP 
	 * @param tripFlightsList of type List<TripFlight>
	 */
	public static void populateSeatMapSegId(List<TripFlight> tripFlightsList) {
		Flight outboundFlight = null;
		Flight inboundFlight = null;
		for (TripFlight tripFlight : tripFlightsList) {
			outboundFlight = tripFlight.getOutboundFlight();
			inboundFlight = tripFlight.getInboundFlight();
			if(outboundFlight != null) {
				outboundFlight.setFlightIdForSeatMap(FlightUtils.generateFlightIdFromFlight(outboundFlight));
			}
			if(inboundFlight != null) {
				inboundFlight.setFlightIdForSeatMap(FlightUtils.generateFlightIdFromFlight(inboundFlight));
			}
		}
	}
}
