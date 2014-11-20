/*
 * FlightUtils.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.data.dto.TripFlight;


/**
 * Class to hold the utility methods on flights
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightUtils {
	/**
	 * Utility method to generate the Flight Id
	 * 
	 * @param flight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static String generateFlightId(Flight flight) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmm");
		if (flight == null) {
			return null;
		}
		StringBuffer flightId = new StringBuffer();
		for (FlightSegment segment : flight.getFlightSegments()) {
			if (flightId.length() > 0) {
				flightId.append("$");
			}
			flightId.append(segment.getGateway());
			flightId.append(segment.getDestination());
			flightId.append(segment.getCarrier().getCarrierCode());
			flightId.append(sdf.format(segment.getDepartureDate()!=null ? segment.getDepartureDate(): 
											new java.sql.Date(Calendar.getInstance().getTimeInMillis())));
			flightId.append(segment.getClassOfService());
			flightId.append(segment.getRotation());
		}
		return flightId.toString();
	}

	/**
	 * Utility method to generate the Flight Id
	 * 
	 * @param flight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static String generateFlightIdFromFlight(Flight flight) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmm");
		if (flight == null) {
			return null;
		}
		StringBuffer flightId = new StringBuffer();
		FlightSegment segment = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
		if(segment != null)
		{
			flightId.append(flight.getGateway());
			flightId.append(flight.getDestination());
			flightId.append(segment.getCarrier().getCarrierCode());
			flightId.append(sdf.format(segment.getDepartureDate()));
			flightId.append(segment.getClassOfService());
			flightId.append(segment.getRotation());
		}
		return flightId.toString();
	}
	/**
	 * Method to sort flights
	 * 
	 * @param flightsList
	 * @param flightsRequest
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public static List<TripFlight> sortFlights(List<TripFlight> flightsList,
			FlightsRequest flightsRequest, boolean isPackage) {
		// Sort the flights based on business rules
		// Charter Flights should always come on top and then all
		// the flights based on price
		Collections.sort(flightsList, new TripFlightStopsComparator());
		Collections.sort(flightsList, new TripFlightPriceComparator(isPackage));
		Collections.sort(flightsList, new TripFlightTypeComparator());
		if (flightsRequest != null) {
			if (flightsRequest.isFlexiDateIndicator()) {
				Collections.sort(flightsList,
						new TripFlightDepartureDateComparator(flightsRequest
								.getDepartureDate()));
			}
			if (flightsRequest.getGateway() != null
					&& flightsRequest.getDestination() != null
					&& (flightsRequest.getNearByGateways() != null || flightsRequest
							.getNearByDestinations() != null)) {
				Collections.sort(flightsList, new TripFlightNearByComparator(
						flightsRequest.getGateway(), flightsRequest
								.getDestination()));
			}
		}
		return flightsList;
	}
	public static Date StrToDateConversion(String strDepartureDate, String format){
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date=new Date();
		try
			{
			 date=formatter.parse(strDepartureDate);
			
			}catch (ParseException ex){
				
			}
		return date;
	}
	
	public static String DateToStrConversion(Date date, String format){
		
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String strDate=new String();
		try
			{
			strDate=formatter.format(date);
			
			}catch (Exception ex){
				
			}
		return strDate;
	}
	
	/**
	 * Method to check whether gateway is charter.
	 * @param gatewayList
	 * @param gateway
	 * @return
	 */
	public static boolean isGatewayCharter(List<Gateway> gatewayList, String gateway){
		boolean result =false;
		for(Gateway gatewayObj : gatewayList){
			if(gatewayObj.getAirportCode().equalsIgnoreCase(gateway)){
				result = true;
				break;
			}
		}
		return result;
	}
}