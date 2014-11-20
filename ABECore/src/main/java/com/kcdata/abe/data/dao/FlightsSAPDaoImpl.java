/*
 * FlightsSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 23, 2009  hguntupa
 * Sep 14, 2009	 hguntupa	  Added methods for flights availability of packages
 * Sep 24, 2009	 hguntupa	  Refactored the code. Moved conversion code to 
 * 							  FlightConvertUtils
 * Jan 05, 2011	 hguntupa	  Refactored BAPI to retrieve both charter and SKED
 * 							  flights from R/3
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.List;
import java.util.Properties;

import com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Input;
import com.kcdata.abe.bapi.Y_Ota_Flight_Availability_Output;
import com.kcdata.abe.bapi.Yst_Ota_Flt_PrefsType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_Orig_DestType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_PrefsType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List;
/*Code commented for revocation of 3620608 on 04/05/2013*/
//import com.kcdata.abe.bapi.util.Yzst_Ota_Flt_Segments_CpyType_List;
import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dto.AirOptions;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

/**
 * Dao class to retrieve the flights availability
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightsSAPDaoImpl extends ABESAPDaoBase implements FlightsDao {

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
	 * Method to retrieve the SKED flights
	 * 
	 * @param request
	 *            - flights request details
	 * @return FlightsResponse object with flights
	 * 
	 * @see
	 * @since
	 */

	public FlightsResponse retrieveFlights(FlightsRequest request) {
		FlightsResponse flightsResponse = new FlightsResponse();
		// Create the input for BAPI
		Y_Ota_Flight_Availability_Input bapiInput = new Y_Ota_Flight_Availability_Input();
		// construct the air request
		bapiInput.setIt_Ota_Flt_Req(this.constructAirRequestList(request));

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare and set header
		bapiInput.setIm_Bapi_Req_Hdr(this.prepareHeader(request));

		// Prepare & set carriers list
		Yst_Ota_Flt_PrefsType_List airPreferences = this
				.prepareAirPreferences(request);
		if (airPreferences != null) {
			bapiInput.setIt_Ota_Flt_Prefs(airPreferences);
		}

		// Execute the BAPI
		Y_Ota_Flight_Availability_Output bapiOutput = (Y_Ota_Flight_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Flight_Availability", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				flightsResponse, true);

		// Check for any business errors from BAPI
		if (flightsResponse.isErrorsOccurred()) {
			return flightsResponse;
		}
/*Code commented for revocation of 3620608 on 04/05/2013*/
		// Check whether flights are available or not
		/*Yzst_Ota_Flt_Segments_CpyType_List flightSegmentsList = bapiOutput
				.get_as_listEx_Ota_Flt_Segments_Cpy();*/
		Yst_Ota_Flt_SegmentsType_List flightSegmentsList = bapiOutput
		.get_as_listIt_Ota_Flt_Segments();
		Yst_Ota_Flt_Orig_DestType_List flightPriceList = bapiOutput
				.get_as_listIt_Ota_Flt_Orig_Dest();
		/*Yzst_Ota_Flt_Segments_CpyType_List flightSegmentsStopOverList = bapiOutput
			     .get_as_listEx_Ota_Flt_Segments_Cpy();*/
		if (flightSegmentsList == null || flightSegmentsList.isEmpty()
				|| flightPriceList == null || flightPriceList.isEmpty()) {
			String flightTypeString = "";
			if (request.getFlightRequestType().isCharter()) {
				flightTypeString = this.getMessageSource().getMessage(
						"BEST_VALUED_FLIGHT", null, null);
			} else {
				flightTypeString = this.getMessageSource().getMessage(
						"SKED_FLIGHT", null, null);
			}
			// Throw a business error
			ABEBusinessError error = new ABEBusinessError(
					"FLIGHTS_NOT_AVAILABLE", this.getMessageSource()
							.getMessage("FLIGHTS_NOT_AVAILABLE",
									new Object[] { flightTypeString }, null));
			flightsResponse.saveBusinessError(error);
			return flightsResponse;
		}

		// Process the flights: Convert the structures to flight objects
		flightsResponse.setFlightList(FlightConvertUtils
				.convertFlightsResponse(flightSegmentsList, flightPriceList,
						request, airportsTimeZones, airlineNames));
		return flightsResponse;
	}

	/**
	 * Method to construct the BAPI AirRequest objects from Flight Request
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Yst_Ota_Flt_ReqType_List constructAirRequestList(
			FlightsRequest request) {		
		
		//Fixed CQ #8952
		String bookingNumber = request.getBookingNo();
		if(bookingNumber == null){
			bookingNumber="".trim();
		}
		if((!"".equalsIgnoreCase(bookingNumber.trim()))&&(request.getPreferredCarriersList()!= null) &&(!request.getPreferredCarriersList().isEmpty()) && (request.getPreferredCarriersList().size()==1)){
			
			Carrier carrier = request.getPreferredCarriersList().get(0);
			if((carrier.getCarrierCode()!=null) && (carrier.getCarrierCode().equalsIgnoreCase("**"))){
				request.setPreferredCarriersList(null);
				request.setMultiCarrierFlights(true);
				request.setShowAll(true);
			}		
		}
		//End
		
		Yst_Ota_Flt_ReqType_List requestList = new Yst_Ota_Flt_ReqType_List();
		Yst_Ota_Flt_ReqType airRequest = new Yst_Ota_Flt_ReqType();

		airRequest.setItem_Rph("1");
		airRequest.setOut_Gateway(request.getGateway());
		airRequest.setOut_Dest(request.getDestination());
		airRequest.setOut_Dep_Date(new java.sql.Date(request.getDepartureDate()
				.getTime()));

		airRequest.setNo_Adults((short) request.getOccupancy().getNoOfAdults());
		airRequest.setNo_Child(request.getOccupancy().getNoOfChilds() + "");
		airRequest.setNo_Infants(request.getOccupancy().getNoOfInfants() + "");
		airRequest.setNo_Lapchild(request.getOccupancy().getNoOfLapChilds()
				+ "");
		airRequest.setNo_Seniors(request.getOccupancy().getNoOfSeniors() + "");
		if (request.getOccupancy().getNoOfChilds() > 0) {
			this.setChildAges(airRequest, request.getOccupancy()
					.getPassengers());
		}
		airRequest.setNo_Flight_Alt("" + request.getNoOfAirOptions());
		if (request.getNonStopFlights()) {
			airRequest.setNon_Stop_Flights("1");

		} else {
			airRequest.setNon_Stop_Flights("0");

		}
		if (request.getDoubleConnections()) {
			airRequest.setDouble_Connections("1");

		} else {
			airRequest.setDouble_Connections("0");

		}
		if (request.getMultiCarrierFlights()) {
			airRequest.setMulti_Carr_Flts("1");

		} else {
			airRequest.setMulti_Carr_Flts("0");

		}
		if (request.getOutboundAirOptions() != null) {
			AirOptions options = request.getOutboundAirOptions();
			if (options.getDepartureTimeOfDay() != null) {
				airRequest.setOut_Time_Dep(options.getDepartureTimeOfDay()
						.getCode());
			}
			if (options.getArrivaTimeOfDay() != null) {
				airRequest.setOut_Time_Arr(options.getArrivaTimeOfDay()
						.getCode());
			}
			if (options.getCabinType() != null) {
				airRequest.setOut_Cabin(options.getCabinType().getType() + "");
			}
			airRequest.setOut_Classof_Service(options.getClassOfService());
			airRequest.setOut_Connection_Locid(options.getConnectingCity());
			airRequest.setOut_Flight_No(options.getFlightNo());
			if (options.getNoOfStops() != null) {
				airRequest.setOut_Stops(options.getNoOfStops() + "");
			}
			airRequest.setOut_Stop_Locid(options.getStopOverCity());
			if (options.getStopOverDuration() != null) {
				airRequest.setOut_Stop_Duration(options.getStopOverDuration()
						+ "");
			}
			if (options.getConnectionCity1() != null
					&& options.getConnectionCity1().length() > 0) {
				airRequest.setOut_Conn_City1(options.getConnectionCity1());

			}
			if (options.getConnectionCity2() != null
					&& options.getConnectionCity2().length() > 0) {
				airRequest.setOut_Conn_City2(options.getConnectionCity2());

			}
			if (options.getExcludeCity1() != null
					&& options.getExcludeCity1().length() > 0) {
				airRequest.setExclude_City1(options.getExcludeCity1());

			}
			if (options.getExcludeCity2() != null
					&& options.getExcludeCity2().length() > 0) {
				airRequest.setExclude_City2(options.getExcludeCity2());

			}
			if (options.getExcludeCity3() != null
					&& options.getExcludeCity3().length() > 0) {
				airRequest.setExclude_City3(options.getExcludeCity3());

			}
		}
		airRequest.setTrip_Ind(request.getTripType().getType());
		if (request.getTripType().isRoundTrip()) {
			airRequest.setDuration(request.getNoOfNights() + "");
			this.processInboundAirOptions(airRequest, request
					.getInboundAirOptions());
		}
		airRequest.setFlight_Req_Type(request.getFlightRequestType().getType()
				+ "");
		requestList.addYst_Ota_Flt_ReqType(airRequest);
		if (request.getTripType().isAnchorTrip()) {
			// clone() method is not available on BAPI proxies. So create a new
			// object
			airRequest = new Yst_Ota_Flt_ReqType();
			airRequest.setItem_Rph("1");
			airRequest.setOut_Gateway(request.getAnchorGateway());
			airRequest.setOut_Dest(request.getGateway());
			airRequest.setOut_Dep_Date(new java.sql.Date(request
					.getAnchorDepartureDate().getTime()));
			airRequest.setNo_Adults((short) request.getOccupancy()
					.getNoOfAdults());
			airRequest.setNo_Child(request.getOccupancy().getNoOfChilds() + "");
			airRequest.setNo_Infants(request.getOccupancy().getNoOfInfants()
					+ "");
			airRequest.setNo_Lapchild(request.getOccupancy().getNoOfLapChilds()
					+ "");
			airRequest.setNo_Seniors(request.getOccupancy().getNoOfSeniors()
					+ "");
			if (request.getOccupancy().getNoOfChilds() > 0) {
				this.setChildAges(airRequest, request.getOccupancy()
						.getPassengers());
			}
			airRequest.setTrip_Ind(request.getTripType().getType());
			airRequest.setFlight_Req_Type(request.getFlightRequestType()
					.getType()
					+ "");
			this.processInboundAirOptions(airRequest, request
					.getInboundAirOptions());
			requestList.addYst_Ota_Flt_ReqType(airRequest);
		}
		return requestList;
	}

	/**
	 * Private method to process the air options
	 * 
	 * @param airRequest
	 * @param options
	 * 
	 * @see
	 * @since
	 */
	private void processInboundAirOptions(Yst_Ota_Flt_ReqType airRequest,
			AirOptions options) {
		if (options != null) {
			if (options.getDepartureTimeOfDay() != null) {
				airRequest.setIn_Time_Dep(options.getDepartureTimeOfDay()
						.getCode());
			}
			if (options.getArrivaTimeOfDay() != null) {
				airRequest.setIn_Time_Arr(options.getArrivaTimeOfDay()
						.getCode());
			}
			if (options.getCabinType() != null) {
				airRequest.setIn_Cabin(options.getCabinType().getType() + "");
			}
			airRequest.setIn_Classof_Service(options.getClassOfService());
			airRequest.setIn_Connection_Locid(options.getConnectingCity());
			airRequest.setIn_Flight_No(options.getFlightNo());
			if (options.getNoOfStops() != null) {
				airRequest.setIn_Stops(options.getNoOfStops() + "");
			}
			airRequest.setIn_Stop_Locid(options.getStopOverCity());
			if (options.getStopOverDuration() != null) {
				airRequest.setIn_Stop_Duration(options.getStopOverDuration()
						+ "");
			}
			if (options.getConnectionCity1() != null
					&& options.getConnectionCity1().length() > 0) {
				airRequest.setIn_Conn_City1(options.getConnectionCity1());

			}
			if (options.getConnectionCity2() != null
					&& options.getConnectionCity2().length() > 0) {
				airRequest.setIn_Conn_City2(options.getConnectionCity2());

			}
			if (options.getExcludeCity1() != null
					&& options.getExcludeCity1().length() > 0) {
				airRequest.setExclude_City1(options.getExcludeCity1());

			}
			if (options.getExcludeCity2() != null
					&& options.getExcludeCity2().length() > 0) {
				airRequest.setExclude_City2(options.getExcludeCity2());

			}
			if (options.getExcludeCity3() != null
					&& options.getExcludeCity3().length() > 0) {
				airRequest.setExclude_City3(options.getExcludeCity3());

			}
		}
	}

	/**
	 * Method to prepare the Air preferences structure
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Yst_Ota_Flt_PrefsType_List prepareAirPreferences(
			FlightsRequest request) {
		if (request.getPreferredCarriersList() == null
				|| request.getPreferredCarriersList().size() == 0) {
			return null;
		}
		Yst_Ota_Flt_PrefsType_List airPrefsList = new Yst_Ota_Flt_PrefsType_List();
		for (Carrier carrier : request.getPreferredCarriersList()) {
			Yst_Ota_Flt_PrefsType airPreference = new Yst_Ota_Flt_PrefsType();
			airPreference.setItem_Rph(1 + "");
			airPreference.setAirline_Code(carrier.getCarrierCode());
			airPrefsList.add(airPreference);
		}
		return airPrefsList;
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
	private void setChildAges(Yst_Ota_Flt_ReqType airRequest,
			List<Passenger> passList) {
		byte childCount = 0;
		for (Passenger passenger : passList) {
			if (passenger.getAgeCode().isChild()) {
				childCount++;
				switch (childCount) {
				case 1:
					airRequest.setChild1_Age(passenger.getAge() + "");
					break;
				case 2:
					airRequest.setChild2_Age(passenger.getAge() + "");
					break;
				case 3:
					airRequest.setChild3_Age(passenger.getAge() + "");
					break;
				case 4:
					airRequest.setChild4_Age(passenger.getAge() + "");
					break;
				case 5:
					airRequest.setChild5_Age(passenger.getAge() + "");
					break;
				case 6:
					airRequest.setChild6_Age(passenger.getAge() + "");
					break;
				}
			}
		}
	}

	/**
	 * Method to retrieve flights for package availability
	 * 
	 * @param request
	 *            - request for flights
	 * @return FlightsResponse object with flights
	 * 
	 * @see
	 * @since
	 */
	public FlightsResponse retrieveFlightsForPackage(FlightsRequest request) {
		FlightsResponse flightsResponse = new FlightsResponse();
		// Create the input for BAPI
		Y_Ota_Flight_Availability_Input bapiInput = new Y_Ota_Flight_Availability_Input();
		// construct the air request
		bapiInput.setIt_Ota_Flt_Req(this.constructAirRequestList(request));

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare and set header
		bapiInput.setIm_Bapi_Req_Hdr(this.prepareHeader(request));

		// Prepare & set carriers list
		Yst_Ota_Flt_PrefsType_List airPreferences = this
				.prepareAirPreferences(request);
		if (airPreferences != null) {
			bapiInput.setIt_Ota_Flt_Prefs(airPreferences);
		}

		// Execute the BAPI
		Y_Ota_Flight_Availability_Output bapiOutput = (Y_Ota_Flight_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Flight_Availability", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				flightsResponse);

		// Check for any business errors from BAPI
		if (flightsResponse.isErrorsOccurred()) {
			return flightsResponse;
		}

		if (bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest() == null
				|| bapiOutput.get_as_listIt_Ota_Flt_Orig_Dest().isEmpty()
				|| bapiOutput.get_as_listIt_Ota_Flt_Segments() == null
				|| bapiOutput.get_as_listIt_Ota_Flt_Segments().isEmpty()) {
			String flightTypeString = "";
			if (request.getFlightRequestType().isCharter()) {
				flightTypeString = this.getMessageSource().getMessage(
						"BEST_VALUED_FLIGHT", null, null);
			} else {
				flightTypeString = this.getMessageSource().getMessage(
						"SKED_FLIGHT", null, null);
			}
			// Throw a business error
			ABEBusinessError error = new ABEBusinessError(
					"FLIGHTS_NOT_AVAILABLE", this.getMessageSource()
							.getMessage("FLIGHTS_NOT_AVAILABLE",
									new Object[] { flightTypeString }, null));
			flightsResponse.saveBusinessError(error);
			return flightsResponse;
		}

		// Set the flights structures
		flightsResponse.setSapOrigDestOptionsList(bapiOutput
				.get_as_listIt_Ota_Flt_Orig_Dest());
		flightsResponse.setSapSegmentsList(bapiOutput
				.get_as_listIt_Ota_Flt_Segments());
				/*Code commented for revocation of 3620608 on 04/05/2013*/
		/*//Added segment set in FlightsResponse for #3620608
		flightsResponse.setSapAddedSegmentsList(bapiOutput
				.get_as_listEx_Ota_Flt_Segments_Cpy());*/

		return flightsResponse;
	}

	public FlightsResponse retrieveCharterOperatingDates(FlightsRequest request) {

		return null;
	}

	//@Override
	public FlightsResponse retrieveFlightOffer(FlightsRequest flightsRequest) {
		return null;
	}
}
