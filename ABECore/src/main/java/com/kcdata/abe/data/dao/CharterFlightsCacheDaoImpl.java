/*
 * CharterFlightsCacheDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  hguntupa
 * Sep 14, 2009	 hguntupa	  Added methods for flights availability of packages
 * Jul 11  2013  kahmed		  Fixed the late fee calculation issue against 3787402  	
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.springframework.util.StopWatch;

import com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Input;
import com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output;
import com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType;
import com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType;
import com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List;
import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.data.dto.AirOptions;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.CharterFlightsDates;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightOffer;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightStatus;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.FlightType;
import com.kcdata.abe.data.dto.Material;
import com.kcdata.abe.data.dto.NearbyGateway;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.PaxTypeBasePrices;
import com.kcdata.abe.data.dto.Price;
import com.kcdata.abe.data.util.CharterFlightClassComparator;
import com.kcdata.abe.data.util.FlightUtils;
import com.kcdata.abe.data.util.TripAvailabilityComparator;
import com.kcdata.abe.framework.dao.ABEDaoBase;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.util.DateUtils;
import com.kcdata.cache.application.service.CacheFlightsService;
import com.kcdata.cache.data.dto.SearchCriteria;
import com.kcdata.cache.data.dto.TripFlight;
import com.kcdata.cache.data.util.TripFlightPriceComparator;

/**
 * Dao class for retrieving Charter Flights from Cache
 * 
 * @author hguntupa
 * @version
 * @param <E>
 * 
 * 
 * @see
 * @since
 */
public class CharterFlightsCacheDaoImpl<E> extends ABESAPDaoBase implements
		FlightsDao {
	/**
	 * Logger Initialization
	 */
	ABELogger logger = ABELogger.getLogger("bapi.performance.log");

	private CacheFlightsService cacheFlightsService;
	private byte daysAhead;
	private byte daysBehind;
	private Properties airportsTimeZones;
	private Properties airlineNames;

	/**
	 * Dao for calling charters from SAP
	 */
	private FlightsDao flightsDao;
	
	/**
	 * DAO for gateway destinations
	 */
	
	private GatewayDestinationsDao gatewayDestinationsDao;

	/**
	 * @param gatewayDestinationsDao the gatewayDestinationsDao to set
	 */
	public void setGatewayDestinationsDao(
			GatewayDestinationsDao gatewayDestinationsDao) {
		this.gatewayDestinationsDao = gatewayDestinationsDao;
	}

	/**
	 * @return the cacheFlightsService
	 */
	public CacheFlightsService getCacheFlightsService() {
		return cacheFlightsService;
	}

	/**
	 * @param cacheFlightsService
	 *            the cacheFlightsService to set
	 */
	public void setCacheFlightsService(CacheFlightsService cacheFlightsService) {
		this.cacheFlightsService = cacheFlightsService;
	}

	/**
	 * @return the daysAhead
	 */
	public byte getDaysAhead() {
		return daysAhead;
	}

	/**
	 * @param daysAhead
	 *            the daysAhead to set
	 */
	public void setDaysAhead(byte daysAhead) {
		this.daysAhead = daysAhead;
	}

	/**
	 * @return the daysBehind
	 */
	public byte getDaysBehind() {
		return daysBehind;
	}

	/**
	 * @param daysBehind
	 *            the daysBehind to set
	 */
	public void setDaysBehind(byte daysBehind) {
		this.daysBehind = daysBehind;
	}

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
	 * @return the flightsDao
	 */
	public FlightsDao getFlightsDao() {
		return flightsDao;
	}

	/**
	 * @param flightsDao
	 *            the flightsDao to set
	 */
	public void setFlightsDao(FlightsDao flightsDao) {
		this.flightsDao = flightsDao;
	}

	/**
	 * Method to retrieve Charter Flights from Cache
	 * 
	 * @param request
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public FlightsResponse retrieveFlights(FlightsRequest request) {
		FlightsResponse response = new FlightsResponse();
		// Convert the flight request into the SearchCriteria
		SearchCriteria searchCriteria = new SearchCriteria();
		if (!"".equals(request.getGateway())) {
			searchCriteria.setGateway(request.getGateway());
		}
		searchCriteria.setDestination(request.getDestination());
		Calendar cal = Calendar.getInstance();
		cal.setTime(request.getDepartureDate());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		searchCriteria.setDepartureDate(cal.getTime());
		searchCriteria.setDuration((byte)request.getNoOfNights());
		searchCriteria.setNoOfSeats(this.caculateNoOfPassangers(request
				.getOccupancy()));
		if (request.isNearbyAirportIndicator() && request.getAlternateGatewayMiles() > 0) {
			searchCriteria
					.setNearByAirports(request.isNearbyAirportIndicator());
			
			// Alternate gateways list
			String souceGateway = request.getGateway();
			Integer gatewayRange = request.getAlternateGatewayMiles();
			
			// Calling getNearByGateways
			List<NearbyGateway> nearbyGatewaysList = gatewayDestinationsDao.getNearByGateways(souceGateway,gatewayRange.toString() );
			List<String> gateways = new ArrayList<String>();
			if(!nearbyGatewaysList.isEmpty()){
				for (NearbyGateway nearbyGateway : nearbyGatewaysList) {
					gateways.add(nearbyGateway.getNearbyGatewayCode());				
				}
			}
			// Set nearby gateways in search criteria
			if(gateways.isEmpty()){
				searchCriteria.setNearByGateways(request.getNearByGateways());
			}else{
				searchCriteria.setNearByGateways(gateways);
			}					
			searchCriteria.setNearByDestinations(request
					.getNearByDestinations());
		}
		searchCriteria.setShowAllFlights(request.isShowAll());
		if (request.isFlexiDateIndicator()) {
			searchCriteria.setDaysAhead(this.getDaysAhead());
			searchCriteria.setDaysBehind(this.getDaysBehind());
		} else {
			// Retrieve flights for the specific date only
			searchCriteria.setDaysAhead((byte) 0);
			searchCriteria.setDaysBehind((byte) 0);
		}
		List<TripFlight> cacheFlightsList = null;
		try {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start("CHARTER_FLIGHTS");
			// Invoke the service
			cacheFlightsList = this.cacheFlightsService
					.retrieveFlights(searchCriteria);
			stopWatch.stop();
			logger.debug("Execution of Command: CHARETR_CACHE_AVAILABILITY "
					+ " completed. Total time for execution(in milliSeconds):"
					+ stopWatch.getTotalTimeMillis());

		} catch (Exception ex) {
			ABESystemError systemError;
			if (ex instanceof IOException) {
				systemError = new ABESystemError(
						"UNABLE_TO_CONNECT_TO_CACHE_FOR_FLIGHTS",
						this.getMessageSource().getMessage(
								"UNABLE_TO_CONNECT_TO_CACHE_FOR_FLIGHTS", null,
								null));
			} else {
				systemError = new ABESystemError(
						"UNABLE_TO_RETRIEVE_CHARTER_FLIGHTS_FROM_CACHE",
						this
								.getMessageSource()
								.getMessage(
										"UNABLE_TO_RETRIEVE_CHARTER_FLIGHTS_FROM_CACHE",
										null, null));
			}
			systemError.setDebugMessage(ex.getMessage());
			// If Cache is down or facing connectivity issues, then system
			// should fall back to SAP to retrieve charter flights.
			response = flightsDao.retrieveFlights(request);
			response.saveSystemError(systemError);
			return response;
		}
		List<TripFlight> filteredList = this.filterCharterFlights(
				cacheFlightsList, searchCriteria, request, response);
		if (filteredList == null || filteredList.size() == 0) {
			ABEBusinessError error = new ABEBusinessError(
					"NO_CHARTER_FLIGHTS_FOUND", this.getMessageSource()
							.getMessage("NO_CHARTER_FLIGHTS_FOUND", null, null));
			response.saveBusinessError(error);
		} else {
			List<com.kcdata.abe.data.dto.TripFlight> tripFlightsList = this
					.convertFlightsList(filteredList, request);
			response.setFlightList(tripFlightsList);
		}
		return response;
	}

	/**
	 * Method to filter the Charter flights from Grid based on ABE business
	 * rules
	 * 
	 * @param flightsList
	 * @param searchCriteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<TripFlight> filterCharterFlights(List<TripFlight> flightsList,
			SearchCriteria searchCriteria, FlightsRequest request,
			FlightsResponse response) {
		if (flightsList == null || flightsList.size() == 0) {
			return null;
		}
		List<TripFlight> toReturn = new ArrayList<TripFlight>();
		// Process the flights and filter them for ABE
		// Group the flights based on: Gateway, Destination, Departure Date,
		// Duration, and Rotation
		HashMap<String, List<TripFlight>> flightGroups = new HashMap<String, List<TripFlight>>();
		if (request.getOutboundAirOptions() != null
				&& request.getOutboundAirOptions().getCabinType() != null
				&& request.getOutboundAirOptions().getCabinType().getType() == 'F') {
			for (TripFlight tripFlight : flightsList) {
				if (tripFlight.getOutboundFlight().getClassOfService() == request
						.getOutboundAirOptions().getCabinType().getType()) {
					String key = generateKey(tripFlight);
					if (flightGroups.get(key) != null) {
						List<TripFlight> groupFlightList = flightGroups
								.get(key);
						groupFlightList.add(tripFlight);
					} else {
						List<TripFlight> groupFlightList = new ArrayList<TripFlight>();
						groupFlightList.add(tripFlight);
						flightGroups.put(key, groupFlightList);
					}
				}
			}
			if (flightGroups.values() != null
					|| flightGroups.values().size() == 0) {
				ABEBusinessError error = new ABEBusinessError(
						"NO_FIRST_CLASS_FLIGHTS_FOUND", this.getMessageSource()
								.getMessage("NO_FIRST_CLASS_FLIGHTS_FOUND",
										null, null));
				response.saveBusinessError(error);
				return null;
			}
		} else {
			for (TripFlight tripFlight : flightsList) {
				String key = generateKey(tripFlight);
				if (flightGroups.get(key) != null) {
					List<TripFlight> groupFlightList = flightGroups.get(key);
					groupFlightList.add(tripFlight);
				} else {
					List<TripFlight> groupFlightList = new ArrayList<TripFlight>();
					groupFlightList.add(tripFlight);
					flightGroups.put(key, groupFlightList);
				}
			}
		}

		Collection<List<TripFlight>> flightGroupsList = flightGroups.values();
		//used for setting availability of selected date of flight
		boolean noAvailable = true;
		// From each group pick the cheapest class which fits the given
		// occupancy
		for (List<TripFlight> flightsGroup : flightGroupsList) {
			// Sort the trip based on class
			Collections.sort(flightsGroup, new CharterFlightClassComparator());
			// Sort the trip flight list based on price
			Collections.sort(flightsGroup, new TripFlightPriceComparator());

			if (searchCriteria.isShowAllFlights()) {
				// Show all flights
				for (TripFlight tripFlight : flightsGroup) {
					double occupencyBasedPrice = tripFlight.getPrice()
							.getBasePrice()
							* searchCriteria.getNoOfSeats()
							+ tripFlight.getPrice().getTotalTax()
							* searchCriteria.getNoOfSeats();
					tripFlight.getPrice().setOccpancyBasedPrice(
							occupencyBasedPrice);
					if (tripFlight.getOutboundFlight().getAvailableSeats() >= searchCriteria
							.getNoOfSeats()) {
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.AVAILABLE);
					} else if (tripFlight.getOutboundFlight()
							.getAvailableSeats() == 0) {
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.NOTAVAILABLE);
					} else {
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.ONREQUEST);
					}
					toReturn.add(tripFlight);
				}
			} else if (request.isSoldOutFlight()){
				for (TripFlight tripFlight : flightsGroup) {
					double occupencyBasedPrice = tripFlight.getPrice()
							.getBasePrice()
							* searchCriteria.getNoOfSeats()
							+ tripFlight.getPrice().getTotalTax()
							* searchCriteria.getNoOfSeats();
					tripFlight.getPrice().setOccpancyBasedPrice(
							occupencyBasedPrice);					
					if (tripFlight.getOutboundFlight().getAvailableSeats() == 0) {
						tripFlight.setStatus(com.kcdata.cache.data.dto.FlightStatus.NOTAVAILABLE);
						toReturn.add(tripFlight);
					}
				}
			} else {
				// Pick only the lowest fare flight with enough number of seats
				int seatsAvailable = 0;
				boolean flightAdded = false;
				// Select the cheapest class of service which fits the required
				// occupancy
				for (TripFlight tripFlight : flightsGroup) {
					if (searchCriteria.getDepartureDate().equals(tripFlight.getDepartureDate()) && searchCriteria.getNoOfSeats() <= tripFlight.getOutboundFlight().getAvailableSeats()) {
						noAvailable = false;
					}
					if (tripFlight.getOutboundFlight().getAvailableSeats() >= searchCriteria
							.getNoOfSeats()) {
						double occupencyBasedPrice = tripFlight.getPrice()
								.getBasePrice()
								* searchCriteria.getNoOfSeats()
								+ tripFlight.getPrice().getTotalTax()
								* searchCriteria.getNoOfSeats();
						tripFlight.getPrice().setOccpancyBasedPrice(
								occupencyBasedPrice);
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.AVAILABLE);
						toReturn.add(tripFlight);
						flightAdded = true;
						//break;
					} else {
						seatsAvailable += tripFlight.getOutboundFlight()
								.getAvailableSeats();
					}
					//Flight will be added even if not available for specific class to allow pricing
					if(tripFlight.getOutboundFlight().getAvailableSeats() == 0){
						double occupencyBasedPrice = tripFlight.getPrice()
						.getBasePrice()
						* searchCriteria.getNoOfSeats()
						+ tripFlight.getPrice().getTotalTax()
						* searchCriteria.getNoOfSeats();
						tripFlight.getPrice().setOccpancyBasedPrice(
								occupencyBasedPrice);
						tripFlight
						.setStatus(com.kcdata.cache.data.dto.FlightStatus.NOTAVAILABLE);
						toReturn.add(tripFlight);
					}
				}
				if (!flightAdded) {
					TripFlight tripFlight = flightsGroup.get(flightsGroup
							.size() - 1);
					if (seatsAvailable >= searchCriteria.getNoOfSeats()) {
						double occupencyBasedPrice = tripFlight.getPrice()
								.getBasePrice()
								* searchCriteria.getNoOfSeats()
								+ tripFlight.getPrice().getTotalTax()
								* searchCriteria.getNoOfSeats();
						tripFlight.getPrice().setOccpancyBasedPrice(
								occupencyBasedPrice);
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.ONREQUEST);
						toReturn.add(tripFlight);
					} else if (searchCriteria.isShowAllFlights()) {
						double occupencyBasedPrice = tripFlight.getPrice()
								.getBasePrice()
								* searchCriteria.getNoOfSeats()
								+ tripFlight.getPrice().getTotalTax()
								* searchCriteria.getNoOfSeats();
						tripFlight.getPrice().setOccpancyBasedPrice(
								occupencyBasedPrice);
						tripFlight
								.setStatus(com.kcdata.cache.data.dto.FlightStatus.NOTAVAILABLE);
						toReturn.add(tripFlight);
					}
				}
			}
		}
		
		/**
		 * clear the return queue if all of the flights are not available and sold out flight is not 
		 * yet requested by the user so that popup will be triggered first to notify the user
		 */
		boolean allSoldOut = true;
		if (!request.isSoldOutFlight()){
			for (TripFlight tripFlight : toReturn) {
				if (tripFlight.getOutboundFlight().getAvailableSeats() > 0){
					allSoldOut = false;
					break;
				}
			}
			if(allSoldOut)
				toReturn.clear();
		}
		
		//sort flight result based on availability
		if (toReturn != null && !toReturn.isEmpty())
			Collections.sort(toReturn, new TripAvailabilityComparator());
		
		/***
		 * Auto unset this flag if the request is to retrieve soldout charter flights
		 * to avoid infinite display of popup.
		 * Otherwise, set the flag according to result:
		 * 		empty toReturn queue means flights are all soldout
		 * 		toReturn queue is not empty however flights are all alternate dates instead
		 */
		
		if (request.isSoldOutFlight()){
			response.setSoldOutFlights(false);
		}
		else if (toReturn.isEmpty()){
			response.setSoldOutFlights(true);
		}
		else{
			response.setSoldOutFlights(noAvailable);
		}
		return toReturn;
	}

	/**
	 * Method to generate the key based on flight details
	 * 
	 * @param tripFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private String generateKey(TripFlight tripFlight) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(tripFlight.getOutboundFlight().getGateway());
		stringBuffer.append(tripFlight.getOutboundFlight().getDestination());
		stringBuffer.append(sdf.format(tripFlight.getDepartureDate()));
		stringBuffer.append(tripFlight.getDuration());
		stringBuffer.append(tripFlight.getOutboundFlight().getRotation());
		return stringBuffer.toString();
	}

	/**
	 * Method to convert the Cache Flights to the Flights
	 * 
	 * @param flights
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private List<com.kcdata.abe.data.dto.TripFlight> convertFlightsList(
			List<TripFlight> cacheFlightsList, FlightsRequest request) {
		List<com.kcdata.abe.data.dto.TripFlight> flightsList = new ArrayList<com.kcdata.abe.data.dto.TripFlight>();
		for (TripFlight cacheTripFlight : cacheFlightsList) {
			com.kcdata.abe.data.dto.TripFlight abeTripFlight = new com.kcdata.abe.data.dto.TripFlight();
			Price price = new Price();
			org.springframework.beans.BeanUtils.copyProperties(cacheTripFlight
					.getPrice(), price);
			abeTripFlight.setPrice(price);
			
			abeTripFlight.setDuration(cacheTripFlight.getDuration());
			// Construct Outbound flight
			abeTripFlight.setOutboundFlight(this.convertFlight(cacheTripFlight
					.getOutboundFlight()));
			// Construct Inbound flight
			abeTripFlight.setInboundFlight(this.convertFlight(cacheTripFlight
					.getInboundFlight()));
			boolean isAirOnly = false;
			if (request.isAirRequested()==true && request.isVehicleRequested()==false && request.isHotelRequested()==false){
				isAirOnly=true;
			}
			this.updatePrices(abeTripFlight, request.getOccupancy(),isAirOnly);
			abeTripFlight.setFlightType(FlightType.CHARTER);
			abeTripFlight.setTripType(FlightTripType.ROUNDTRIP);
			abeTripFlight.setStatus(this.retrieveFlightStatus(cacheTripFlight
					.getStatus()));
			abeTripFlight.setCarrier(this
					.processTripFlightCarrier(abeTripFlight));
			abeTripFlight.setOccupancy(request.getOccupancy());
			flightsList.add(abeTripFlight);
		}
		return flightsList;
	}

	/**
	 * Method to convert the flights
	 * 
	 * @param cacheFlight
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Flight convertFlight(com.kcdata.cache.data.dto.Flight cacheFlight) {
		Flight flight = new Flight();
		flight.setArrivalTime(cacheFlight.getArrivalDate());
		flight.setDepartureTime(cacheFlight.getDepartureDate());
		flight.setDestination(cacheFlight.getDestination());
		flight.setGateway(cacheFlight.getGateway());
		Material material = new Material();
		org.springframework.beans.BeanUtils.copyProperties(cacheFlight
				.getMaterial(), material);
		flight.setMaterial(material);
		flight.setNoOfStops("" + cacheFlight.getNoOfStops());
		Date arrivalDate = flight.getArrivalTime();
		if (flight.getDepartureTime() != null && arrivalDate != null) {
			if (flight.getDepartureTime().after(arrivalDate)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(arrivalDate);
				cal.add(Calendar.DAY_OF_MONTH, 1);
				arrivalDate=cal.getTime();
				flight.setArrivalTime(arrivalDate);
			}
		}
		long travelTime = DateUtils.timeDifference(flight.getDepartureTime(),
				(String) airportsTimeZones.get(flight.getGateway()), 
						arrivalDate, (String) airportsTimeZones
						.get(flight.getDestination()));
		flight.setTravelTime(travelTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String departureDate = sdf.format(flight.getDepartureTime());
		String arrivalDate1 = sdf.format(arrivalDate);
		if (departureDate != null && !departureDate.equals(arrivalDate1)) {
			flight.setOverNight(true);
		}
		// Need to add Travel time computation logic
	//	flight.setTravelTime(cacheFlight.getFlightAirTime());
		FlightSegment segment = new FlightSegment();
		segment.setArrivalDate(arrivalDate);
		segment.setCarrier(new Carrier(cacheFlight.getAirlineCode(),
				(String) airlineNames.get(cacheFlight.getAirlineCode())));
		segment.setClassOfService("" + cacheFlight.getClassOfService());
		segment.setDepartureDate(cacheFlight.getDepartureDate());
		segment.setDestination(cacheFlight.getDestination());
		segment.setFlightNo(cacheFlight.getFlightNumber());
		segment.setGateway(cacheFlight.getGateway());
		segment.setNoOfStops(cacheFlight.getNoOfStops());
		segment.setRotation(cacheFlight.getRotation());
		segment.setSeatsAvailable((byte) cacheFlight.getAvailableSeats());
		segment.setTravelTime(travelTime);
		List<FlightSegment> segmentsList = new ArrayList<FlightSegment>();
		segmentsList.add(segment);
		flight.setFlightSegments(segmentsList);
		// Generate Flight ID
		flight.setFlightId(FlightUtils.generateFlightId(flight));
		flight.setFlightIdForSeatMap(FlightUtils.generateFlightIdFromFlight(flight));
		return flight;
	}

	/**
	 * Method to retrieve the Flight Status
	 * 
	 * @param status
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private FlightStatus retrieveFlightStatus(
			com.kcdata.cache.data.dto.FlightStatus status) {
		if (status.isOnRequest()) {
			return FlightStatus.ONREQUEST;
		} else if (status.isNotAvailable()) {
			return FlightStatus.NOTAVAILABLE;
		}
		return FlightStatus.AVAILABLE;
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

	/**
	 * Method to calculate no of passangers in the given occupancy
	 * 
	 * @param occupancy
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private byte caculateNoOfPassangers(Occupancy occupancy) {
		byte noOfPassangers = (byte) 0;
		noOfPassangers = (byte) (occupancy.getNoOfAdults()
				+ occupancy.getNoOfChilds() + occupancy.getNoOfInfants() + occupancy
				.getNoOfSeniors());
		return noOfPassangers;
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
		return this.retrieveFlights(request);
	}

	/**
	 * Method update the Price details of a charter flight
	 * 
	 * @param tripFlight
	 * @param occupancy
	 * 
	 * @see
	 * @since
	 */
	private void updatePrices(com.kcdata.abe.data.dto.TripFlight tripFlight,
			Occupancy occupancy,boolean isAirOnly) {
		if (tripFlight.getPrice() == null) {
			return;
		}
		Price price = tripFlight.getPrice();

		PaxTypeBasePrices paxTypeBasePrices = new PaxTypeBasePrices();
		paxTypeBasePrices.setAdultBasePrice(price.getBasePrice()
				* occupancy.getNoOfAdults());
		paxTypeBasePrices.setChildBasePrice(price.getBasePrice()
				* occupancy.getNoOfChilds());
		paxTypeBasePrices.setInfantBasePrice(price.getBasePrice()
				* occupancy.getNoOfInfants());
		paxTypeBasePrices.setSeniorBasePrice(price.getBasePrice()
				* occupancy.getNoOfSeniors());
		paxTypeBasePrices.setNoOfAdults("" + occupancy.getNoOfAdults());
		paxTypeBasePrices.setNoOfChilds("" + occupancy.getNoOfChilds());
		paxTypeBasePrices.setNoOfInfants("" + occupancy.getNoOfInfants());
		paxTypeBasePrices.setNoOfLapChilds("" + occupancy.getNoOfLapChilds());
		paxTypeBasePrices.setNoOfSeniors("" + occupancy.getNoOfSeniors());
		byte childCount = 0;
		if (occupancy.getPassengers() != null) {
			for (Passenger passenger : occupancy.getPassengers()) {
				if (passenger.getAgeCode().isChild()) {
					switch (++childCount) {
					case 1:
						paxTypeBasePrices.setChild1Age("" + passenger.getAge());
						break;
					case 2:
						paxTypeBasePrices.setChild2Age("" + passenger.getAge());
						break;
					case 3:
						paxTypeBasePrices.setChild3Age("" + passenger.getAge());
						break;
					case 4:
						paxTypeBasePrices.setChild4Age("" + passenger.getAge());
						break;
					case 5:
						paxTypeBasePrices.setChild5Age("" + passenger.getAge());
						break;
					case 6:
						paxTypeBasePrices.setChild6Age("" + passenger.getAge());
						break;
					}
				}
			}
		}
		price.setPaxBasePrices(paxTypeBasePrices);
		price.setAdultPrice((price.getBasePrice() + price.getTotalTax())
				* occupancy.getNoOfAdults());
		price.setChildPrice((price.getBasePrice() + price.getTotalTax())
				* occupancy.getNoOfChilds());
		price.setInfantPrice((price.getBasePrice() + price.getTotalTax())
				* occupancy.getNoOfInfants());
		double lateFee= calculateLate(tripFlight, occupancy);
		price.setOccpancyBasedPrice(price.getOccpancyBasedPrice());
		//Start the fix of 3787402 (Late fee calculation issue).
		//If DepartureDate diff with CurrentDate < 14 then lateFee should be deducted. (Each passenger =10.0 $ )
		int passengerCount=occupancy
							.getNoOfAdults()+(occupancy
							.getNoOfChilds())+occupancy
							.getNoOfInfants();
		if (passengerCount>=1 && lateFee>0.0){
			lateFee=10;
			price.setLateFee(lateFee);
		}
		//End of fix 3787402
		price.setPerAdultBasePrice(price.getBasePrice());
	}
	
	private  double calculateLate(com.kcdata.abe.data.dto.TripFlight tripFlight,Occupancy occupancy){		
		double lateFee=0;		
		 Date departureDate=tripFlight.getOutboundFlight().getDepartureTime();
		 Date currentDate= new Date(Calendar.getInstance().getTime().getTime());
		 long duration=(DateUtils.dateDifferenceInDays(currentDate,departureDate));
		 //fix for issue#3924081 LBF Availability  Pricing Defect
		 //apply late booking fee for 14 days or less than 14 days
		 if(duration<=14){
			 int passengerCount=occupancy.getNoOfAdults()+(occupancy.getNoOfChilds())+occupancy.getNoOfInfants();
			 lateFee=passengerCount*10;
		 }
		
		return lateFee;
		
	}


	public FlightsResponse retrieveCharterOperatingDates(FlightsRequest request) {
		FlightsResponse response = new FlightsResponse();
		// Convert the flight request into the SearchCriteria
		SearchCriteria searchCriteria = new SearchCriteria();
		if (!"".equals(request.getGateway())) {
			searchCriteria.setGateway(request.getGateway());
		}
		searchCriteria.setDestination(request.getDestination());
		searchCriteria.setDuration((byte)request.getNoOfNights());
		int duration = request.getNoOfNights();
		Calendar cal = Calendar.getInstance();
		cal.setTime(request.getDepartureDate());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		searchCriteria.setDepartureDate(cal.getTime());
		// need to set days ahead and behind days based on departure month only
		Calendar reference = Calendar.getInstance();
		reference.setTime(searchCriteria.getDepartureDate());
		reference.set(Calendar.HOUR, 0);
		reference.set(Calendar.MINUTE, 0);
		reference.set(Calendar.SECOND, 0);
		reference.set(Calendar.MILLISECOND, 0);
		Calendar startDate = (Calendar) reference.clone();
		// first date of the month
		startDate.set(Calendar.DATE, 1);
		searchCriteria
				.setDaysAhead((startDate.getActualMaximum(Calendar.DATE) - cal
						.get(Calendar.DATE)) + 7);
		searchCriteria.setDaysBehind(cal.get(Calendar.DATE)
				- startDate.get(Calendar.DATE));

		List<TripFlight> cacheFlightsList = null;
		try {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start("CHARTER_FLIGHTS");
			// Invoke the service
			cacheFlightsList = this.cacheFlightsService
					.retrieveFlights(searchCriteria);
			stopWatch.stop();
			logger.debug("Execution of Command: CHARETR_CACHE_AVAILABILITY "
					+ " completed. Total time for execution(in milliSeconds):"
					+ stopWatch.getTotalTimeMillis());
			List<CharterFlightsDates> charterDates = new ArrayList<CharterFlightsDates>();
			List<java.util.Date> cDates = new ArrayList<java.util.Date>();
			List<java.util.Date> nonCDates = new ArrayList<java.util.Date>();
			
			List<CharterFlightsDates> charterNotAvailDates = new ArrayList<CharterFlightsDates>();
			List<java.util.Date> cNotAvailDates = new ArrayList<java.util.Date>();			
			Set<java.util.Date> cAvailDates	= new LinkedHashSet<java.util.Date>();
			
			List<Integer> cDatesOnly = new ArrayList<Integer>();
			if (cacheFlightsList != null) {
				Iterator<TripFlight> iterator = cacheFlightsList.iterator();
				while (iterator.hasNext()) {
					TripFlight next = iterator.next();
					com.kcdata.cache.data.dto.Flight outboundFlight = next
							.getOutboundFlight();
					com.kcdata.cache.data.dto.Flight inboundFlight = next
							.getInboundFlight();
					Date departureDate = outboundFlight.getDepartureDate();

					Calendar deptDate = Calendar.getInstance();
					deptDate.setTime(departureDate);
					deptDate.set(Calendar.HOUR, 0);
					deptDate.set(Calendar.MINUTE, 0);
					deptDate.set(Calendar.SECOND, 0);
					deptDate.set(Calendar.MILLISECOND, 0);

					if((outboundFlight.getAvailableSeats() > 0 )&&( cal.get(Calendar.MONTH) == deptDate
							.get(Calendar.MONTH))){
						cAvailDates.add((Date) deptDate.getTime().clone());
					}

					Calendar retDate = Calendar.getInstance();
					retDate.setTime(inboundFlight.getDepartureDate());
					retDate.set(Calendar.HOUR, 0);
					retDate.set(Calendar.MINUTE, 0);
					retDate.set(Calendar.SECOND, 0);
					retDate.set(Calendar.MILLISECOND, 0);

					if (duration != 0) {
						Calendar durDate = Calendar.getInstance();
						durDate.setTime(deptDate.getTime());
						durDate.set(Calendar.HOUR, 0);
						durDate.set(Calendar.MINUTE, 0);
						durDate.set(Calendar.SECOND, 0);
						durDate.set(Calendar.MILLISECOND, 0);
						durDate.add(Calendar.DATE, duration);
						if (durDate.get(Calendar.DATE) == retDate
								.get(Calendar.DATE)) {
							if (!cDates.contains(deptDate.getTime())
									&& (cal.get(Calendar.MONTH) == deptDate
											.get(Calendar.MONTH))) {
								cDates.add(deptDate.getTime());
								cDatesOnly.add(deptDate.get(Calendar.DATE));
								
							}
						}
					} else if (duration == 0) {
						if (!cDates.contains(deptDate.getTime())
								&& (cal.get(Calendar.MONTH) == deptDate
										.get(Calendar.MONTH))) {
							cDates.add(deptDate.getTime());
							cDatesOnly.add(deptDate.get(Calendar.DATE));
							
						}
					}
				}
			}
			if (cDates != null && cDates.size() > 0) {
				Collections.sort(cDates);
				Iterator<Date> cIterator = cDates.iterator();
				while (cIterator.hasNext()) {
					CharterFlightsDates charterDatesVO = new CharterFlightsDates();
					Date cNext = cIterator.next();
					charterDatesVO.setCharterDate(cNext);
					charterDates.add(charterDatesVO);
				}
			}
			
			if (cAvailDates != null && cAvailDates.size() > 0) {
				List<java.util.Date> cDatesTemp = new ArrayList<java.util.Date>();
				cDatesTemp.addAll(cDates);
				cDatesTemp.removeAll(cAvailDates);
				cNotAvailDates.addAll(cDatesTemp);	
				
				if(!cDatesTemp.isEmpty()){
					Collections.sort(cNotAvailDates);
					Iterator<Date> cNotIterator = cNotAvailDates.iterator();
					while (cNotIterator.hasNext()) {
						CharterFlightsDates charterNotDatesVO = new CharterFlightsDates();
						Date cNext = cNotIterator.next();
						charterNotDatesVO.setCharterDate(cNext);
						charterNotAvailDates.add(charterNotDatesVO);
					}
				}
				
			}
			
			for (int i = startDate.get(Calendar.DATE); i <= startDate
					.getActualMaximum(Calendar.DATE); i++) {
				if (!cDatesOnly.contains(i)) {
					Calendar caln = Calendar.getInstance();
					caln.set(startDate.get(Calendar.YEAR), startDate
							.get(Calendar.MONTH), i);
					caln.set(Calendar.HOUR, 0);
					caln.set(Calendar.MINUTE, 0);
					caln.set(Calendar.SECOND, 0);
					caln.set(Calendar.MILLISECOND, 0);
					nonCDates.add(caln.getTime());
				}
			}
			if (charterDates != null && charterDates.size() > 0) {
				response.setCharterDates(charterDates);
			}
			if (nonCDates != null && nonCDates.size() > 0) {
				response.setNonCharterDates(nonCDates);
			}
			
			if(!charterNotAvailDates.isEmpty()){
				response.setCharterNotAvailDates(charterNotAvailDates);
			}

		} catch (Exception ex) {
			ABESystemError systemError;
			if (ex instanceof IOException) {
				systemError = new ABESystemError(
						"UNABLE_TO_CONNECT_TO_CACHE_FOR_FLIGHTS",
						this.getMessageSource().getMessage(
								"UNABLE_TO_CONNECT_TO_CACHE_FOR_FLIGHTS", null,
								null));
			} else {
				systemError = new ABESystemError(
						"UNABLE_TO_RETRIEVE_CHARTER_FLIGHTS_FROM_CACHE",
						this
								.getMessageSource()
								.getMessage(
										"UNABLE_TO_RETRIEVE_CHARTER_FLIGHTS_FROM_CACHE",
										null, null));
			}
			systemError.setDebugMessage(ex.getMessage());
			response.saveSystemError(systemError);
			return response;
		}

		return response;
	}
	
	public FlightsResponse retrieveFlightOffer(FlightsRequest flightsRequest){
		FlightsResponse response = new FlightsResponse();
		boolean isValidCharterPair = gatewayDestinationsDao.isCharterOfferedGatewayDestination(
				flightsRequest.getGateway(), flightsRequest.getDestination());
		if (isValidCharterPair){
			//prepare input an invoke new bapi
			Y_Ota_Alt_Duration_Charter_Input bapiInput = new Y_Ota_Alt_Duration_Charter_Input();
			// Prepare & set application info object to input
			bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());
			// construct the air request
			bapiInput.setIt_Ota_Flt_Req(this.constructAirRequestList(flightsRequest));
			
			// Execute the BAPI
			Y_Ota_Alt_Duration_Charter_Output bapiOutput = (Y_Ota_Alt_Duration_Charter_Output) this
			.getBapiExecutionManager().executeBAPI(
					"Y_Ota_Alt_Duration_Charter", bapiInput);
			
			//parse the result
			response = parseOfferResult(bapiOutput.getEx_Alt_Charter_Duration());
			response.getFlightOffer().setDurationToBeChange(flightsRequest.getNoOfNights());
		}
		return response;
	}
	
	//parse the bapi output result and return
	
	/***
	 * Parse the bapi output for availability of flight offer
	 * 
	 */
	private FlightsResponse parseOfferResult(Yst_Ota_Alt_Dur_CharterType alternateDuration){
		FlightsResponse response = new FlightsResponse();
		FlightOffer  offerResponse = new FlightOffer();
		String hasFlightOffer = alternateDuration.getYaltdurcharter_Ind();
		offerResponse.setCharterFlightOffer(hasFlightOffer!= null && hasFlightOffer.equals("1")?true:false);//has alternate duration
		offerResponse.setDayOfTheWeek(alternateDuration.getYdweek());//day of the week
		offerResponse.setVerbiage(alternateDuration.getYmessage());//verbiage
		String newDuration = alternateDuration.getYaltdur();
		if(newDuration != null && !newDuration.isEmpty())
			offerResponse.setDurationToChangeTo(Integer.parseInt(newDuration));
		response.setFlightOffer(offerResponse);
		return response;
	}
	
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
}
