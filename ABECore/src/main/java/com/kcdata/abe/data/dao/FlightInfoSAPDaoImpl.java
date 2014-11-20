/*
 * FlightInfoSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.kcdata.abe.bapi.Y_Ota_Flight_Info_Input;
import com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output;
import com.kcdata.abe.bapi.Yst_Ota_Flight_LegType;
import com.kcdata.abe.bapi.Yst_Ota_FlightinfoType;
import com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List;
import com.kcdata.abe.business.response.FlightInfoResponse;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightInfoCriteria;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.FlightType;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.util.DateUtils;

/**
 * Dao implementation class to retrieve the flight information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightInfoSAPDaoImpl extends ABESAPDaoBase implements
		FlightInfoDao {

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
	 * Method to retrieve the flight information based on search criteria
	 * 
	 * @param criteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public FlightInfoResponse retrieveFlightInfo(FlightInfoCriteria criteria) {
		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss a");

		FlightInfoResponse response = new FlightInfoResponse();

		Y_Ota_Flight_Info_Input bapiInput = new Y_Ota_Flight_Info_Input();
		bapiInput.setIm_Matnr(criteria.getMaterial().getMaterialNo());
		bapiInput.setIm_Batch(criteria.getMaterial().getBatchNo());

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// execute the BAPI
		Y_Ota_Flight_Info_Output bapiOutput = (Y_Ota_Flight_Info_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Ota_Flight_Info",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), response);
		if (response.isBusinessErrorOccurred()) {
			return response;
		}
		Yst_Ota_FlightinfoType outboundFlightInfo = bapiOutput
				.getEx_Out_Flight_Info();
		Yst_Ota_FlightinfoType inboundFlightInfo = bapiOutput
				.getEx_In_Flight_Info();
		Yst_Ota_Flight_LegType_List legsList = bapiOutput
				.get_as_listIt_Flight_Leg();
		if (outboundFlightInfo == null || inboundFlightInfo == null
				|| legsList == null || legsList.size() == 0) {
			// Unable to retrieve flight details
			ABEBusinessError error = new ABEBusinessError(
					"FLIGHT_INFO_NOT_AVAILABLE",
					this.getMessageSource().getMessage(
							"FLIGHT_INFO_NOT_AVAILABLE", null, null));
			response.saveBusinessError(error);
		} else {
			Flight outBoundFlight = this.processFlightInfo(outboundFlightInfo);
			Flight inBoundFlight = this.processFlightInfo(inboundFlightInfo);
			if (legsList != null && !legsList.isEmpty()) {
				Iterator<Yst_Ota_Flight_LegType> iterator = legsList.iterator();
				while (iterator.hasNext()) {
					Yst_Ota_Flight_LegType legType = (Yst_Ota_Flight_LegType) iterator
							.next();
					FlightSegment segment = new FlightSegment();
					segment
							.setCarrier(new Carrier(legType.getAirlinecode(),
									(String) airlineNames.get(legType
											.getAirlinecode())));
					segment.setFlightNo(legType.getFlightnumber());
					segment.setRotation(legType.getRotation().charAt(0));
					segment.setGateway(legType.getGateway());
					segment.setDestination(legType.getDestination());
					if (legType.getStops() != null
							&& legType.getStops().length() > 0) {
						segment.setNoOfStops(Integer.parseInt(legType
								.getStops()));
					}
					segment.setMealsServed(legType.getMeals());
					//int materialLength = outboundFlightInfo.getMatnr().length();
					//segment.setClassOfService(outboundFlightInfo.getMatnr()
						//	.substring(materialLength - 1, materialLength));
					
					int batchLength = outboundFlightInfo.getCharg().length();
					segment.setClassOfService(outboundFlightInfo.getCharg()
							.substring(batchLength - 2, batchLength-1));
					try {
						if (legType.getMatnr().equals(
								outboundFlightInfo.getMatnr())) {
							segment
									.setDepartureDate(sdfDateTime
											.parse(outboundFlightInfo
													.getDeparturedate()
													+ " "
													+ legType
															.getDeparturetime()
													+ " "
													+ legType
															.getDep_Time_Units()));
							segment
									.setArrivalDate(sdfDateTime
											.parse(outboundFlightInfo
													.getDeparturedate()
													+ " "
													+ legType.getArrivaltime()
													+ " "
													+ legType
															.getArr_Time_Units()));
							segment.setAircraftType(outboundFlightInfo
									.getEquipment());
							segment.setTravelTime(DateUtils.timeDifference(
									segment.getDepartureDate(),
									(String) airportsTimeZones.get(segment
											.getGateway()), segment
											.getArrivalDate(),
									(String) airportsTimeZones.get(segment
											.getDestination())));
							if (outBoundFlight.getFlightSegments() == null) {
								outBoundFlight
										.setFlightSegments(new ArrayList<FlightSegment>());
							}
							outBoundFlight.getFlightSegments().add(segment);
						} else {
							segment
									.setDepartureDate(sdfDateTime
											.parse(inboundFlightInfo
													.getDeparturedate()
													+ " "
													+ legType
															.getDeparturetime()
													+ " "
													+ legType
															.getDep_Time_Units()));
							segment
									.setArrivalDate(sdfDateTime
											.parse(inboundFlightInfo
													.getDeparturedate()
													+ " "
													+ legType.getArrivaltime()
													+ " "
													+ legType
															.getArr_Time_Units()));
							segment.setAircraftType(inboundFlightInfo
									.getEquipment());
							segment.setTravelTime(DateUtils.timeDifference(
									segment.getDepartureDate(),
									(String) airportsTimeZones.get(segment
											.getGateway()), segment
											.getArrivalDate(),
									(String) airportsTimeZones.get(segment
											.getDestination())));
							if (inBoundFlight.getFlightSegments() == null) {
								inBoundFlight
										.setFlightSegments(new ArrayList<FlightSegment>());
							}
							inBoundFlight.getFlightSegments().add(segment);
						}
					} catch (ParseException ex) {
					}
				}
				if (outBoundFlight.getFlightSegments() != null) {
					outBoundFlight.setNoOfStops(""
							+ (outBoundFlight.getFlightSegments().size() - 1));
				} else {
					outBoundFlight.setNoOfStops("0");
				}
				if (inBoundFlight.getFlightSegments() != null) {
					inBoundFlight.setNoOfStops(""
							+ (inBoundFlight.getFlightSegments().size() - 1));
				} else {
					inBoundFlight.setNoOfStops("0");
				}
			}
			FlightConvertUtils.processFlightDetails(outBoundFlight,
					airportsTimeZones, airlineNames);
			FlightConvertUtils.processFlightDetails(inBoundFlight,
					airportsTimeZones, airlineNames);
			TripFlight tripFlight = new TripFlight();
			tripFlight.setOutboundFlight(outBoundFlight);
			tripFlight.setInboundFlight(inBoundFlight);
			tripFlight.setFlightType(FlightType.CHARTER);
			tripFlight.setTripType(FlightTripType.ROUNDTRIP);
			tripFlight.setCarrier(this.processTripFlightCarrier(tripFlight));
			response.setTripFlight(tripFlight);
		}
		return response;
	}

	/**
	 * Private method to covert the Yst_Ota_FlightinfoType structure to Flight
	 * object
	 * 
	 * @param infoType
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Flight processFlightInfo(Yst_Ota_FlightinfoType infoType) {
		SimpleDateFormat sdfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		Flight flight = new Flight();
		try {
			flight.setGateway(infoType.getDepartingairport());
			flight.setDestination(infoType.getArrivalairport());
			flight.setDepartureTime(sdfDateTime.parse(infoType
					.getDeparturedate()
					+ " " + infoType.getDeparturetime()));
			flight.setArrivalTime(sdfDateTime.parse(infoType.getArrivaldate()
					+ " " + infoType.getArrivaltime()));
			flight.setNoOfStops(infoType.getStops());
			Material material = new Material();
			material.setMaterialNo(infoType.getMatnr());
			material.setBatchNo(infoType.getCharg());
			flight.setMaterial(material);
		} catch (ParseException e) {
		}
		return flight;
	}

	/**
	 * Method to iterate through flight segments and create a carrier info for
	 * the TripFlight. Loop through the segments and see If codeshare is exist
	 * any of the segment. If exist, return carrier with codeshare flag true.
	 * 
	 * 
	 * @param tripFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Carrier processTripFlightCarrier(
			com.kcdata.abe.data.dto.TripFlight tripFlight) {
		Carrier carrier = null;
		if (tripFlight.getOutboundFlight() != null) {
			for (FlightSegment segment : tripFlight.getOutboundFlight()
					.getFlightSegments()) {
				carrier = segment.getCarrier();
				if (carrier != null && carrier.isCodeshareAvaialable()) {
					return carrier;
				}
			}
		}
		if (tripFlight.getInboundFlight() != null) {
			for (FlightSegment segment : tripFlight.getInboundFlight()
					.getFlightSegments()) {
				carrier = segment.getCarrier();
				if (carrier != null && carrier.isCodeshareAvaialable()) {
					return carrier;
				}
			}
		}
		return carrier;
	}
}
