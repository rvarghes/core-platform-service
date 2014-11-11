/*
 * FlightsRequest.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  hguntupa
 * Sep 24, 2009	 hguntupa	  Added new fields for Charter and Sked
 ******************************************************************************
 */

package com.kcdata.abe.business.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.data.dto.AirOptions;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.FlightRequestType;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.framework.request.ABERequest;

/**
 * Holds the search criteria for Flights
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightsRequest extends ABERequest {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3182222544371674290L;

	private String anchorGateway;
	private Date anchorDepartureDate;
	private boolean nearbyAirportIndicator;
	private boolean flexiDateIndicator;
	private AirOptions outboundAirOptions;
	private AirOptions inboundAirOptions;
	private FlightRequestType flightRequestType;
	private FlightTripType tripType;
	private boolean showAll;
	private List<Carrier> preferredCarriersList;
	private List<String> nearByGateways;
	private List<String> nearByDestinations;
	private boolean charterOnly;
	private boolean skedOnly;
	private boolean nonStopFlights;
	private boolean doubleConnections;
	private boolean multiCarrierFlights;
	private byte noOfAirOptions;
	private int alternateGatewayMiles;
	//retrieve sold out charter flights
	private boolean soldOutFlight;
	private boolean checkCharterOfferFlight;

	/**
	 * @return the anchorGateway
	 */
	public String getAnchorGateway() {
		return anchorGateway;
	}

	/**
	 * @param anchorGateway
	 *            the anchorGateway to set
	 */
	public void setAnchorGateway(String anchorGateway) {
		this.anchorGateway = anchorGateway;
	}

	/**
	 * @return the anchorDepartureDate
	 */
	public Date getAnchorDepartureDate() {
		return anchorDepartureDate;
	}

	/**
	 * @param anchorDepartureDate
	 *            the anchorDepartureDate to set
	 */
	public void setAnchorDepartureDate(Date anchorDepartureDate) {
		this.anchorDepartureDate = anchorDepartureDate;
	}

	/**
	 * @return the nearbyAirportIndicator
	 */
	public boolean isNearbyAirportIndicator() {
		return nearbyAirportIndicator;
	}

	/**
	 * @param nearbyAirportIndicator
	 *            the nearbyAirportIndicator to set
	 */
	public void setNearbyAirportIndicator(boolean nearbyAirportIndicator) {
		this.nearbyAirportIndicator = nearbyAirportIndicator;
	}

	/**
	 * @return the flexiDateIndicator
	 */
	public boolean isFlexiDateIndicator() {
		return flexiDateIndicator;
	}

	/**
	 * @param flexiDateIndicator
	 *            the flexiDateIndicator to set
	 */
	public void setFlexiDateIndicator(boolean flexiDateIndicator) {
		this.flexiDateIndicator = flexiDateIndicator;
	}

	/**
	 * @return the outboundAirOptions
	 */
	public AirOptions getOutboundAirOptions() {
		return outboundAirOptions;
	}

	/**
	 * @param outboundAirOptions
	 *            the outboundAirOptions to set
	 */
	public void setOutboundAirOptions(AirOptions outboundAirOptions) {
		this.outboundAirOptions = outboundAirOptions;
	}

	/**
	 * @return the inboundAirOptions
	 */
	public AirOptions getInboundAirOptions() {
		return inboundAirOptions;
	}

	/**
	 * @param inboundAirOptions
	 *            the inboundAirOptions to set
	 */
	public void setInboundAirOptions(AirOptions inboundAirOptions) {
		this.inboundAirOptions = inboundAirOptions;
	}

	/**
	 * @return the flightRequestType
	 */
	public FlightRequestType getFlightRequestType() {
		return flightRequestType;
	}

	/**
	 * @param flightRequestType
	 *            the flightRequestType to set
	 */
	public void setFlightRequestType(FlightRequestType flightRequestType) {
		this.flightRequestType = flightRequestType;
	}

	/**
	 * @return the tripType
	 */
	public FlightTripType getTripType() {
		return tripType;
	}

	/**
	 * @param tripType
	 *            the tripType to set
	 */
	public void setTripType(FlightTripType tripType) {
		this.tripType = tripType;
	}

	/**
	 * @return the showAll
	 */
	public boolean isShowAll() {
		return showAll;
	}

	/**
	 * @param showAll
	 *            the showAll to set
	 */
	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	/**
	 * @return the preferredCarriersList
	 */
	public List<Carrier> getPreferredCarriersList() {
		return preferredCarriersList;
	}

	/**
	 * @param preferredCarriersList
	 *            the preferredCarriersList to set
	 */
	public void setPreferredCarriersList(List<Carrier> preferredCarriersList) {
		this.preferredCarriersList = preferredCarriersList;
	}

	/**
	 * @return the nearByGateways
	 */
	public List<String> getNearByGateways() {
		return nearByGateways;
	}

	/**
	 * @param nearByGateways
	 *            the nearByGateways to set
	 */
	public void setNearByGateways(List<String> nearByGateways) {
		this.nearByGateways = nearByGateways;
	}

	/**
	 * @return the nearByDestinations
	 */
	public List<String> getNearByDestinations() {
		return nearByDestinations;
	}

	/**
	 * @param nearByDestinations
	 *            the nearByDestinations to set
	 */
	public void setNearByDestinations(List<String> nearByDestinations) {
		this.nearByDestinations = nearByDestinations;
	}

	/**
	 * @return the charterOnly
	 */
	public boolean isCharterOnly() {
		return charterOnly;
	}

	/**
	 * @param charterOnly
	 *            the charterOnly to set
	 */
	public void setCharterOnly(boolean charterOnly) {
		this.charterOnly = charterOnly;
	}

	/**
	 * @return the skedOnly
	 */
	public boolean isSkedOnly() {
		return skedOnly;
	}

	/**
	 * @param skedOnly
	 *            the skedOnly to set
	 */
	public void setSkedOnly(boolean skedOnly) {
		this.skedOnly = skedOnly;
	}

	/**
	 * @param nonStopFlights
	 *            the nonStopFlights to set
	 */
	public void setNonStopFlights(boolean nonStopFlights) {
		this.nonStopFlights = nonStopFlights;
	}

	/**
	 * @return the nonStopFlights
	 */
	public boolean getNonStopFlights() {
		return nonStopFlights;
	}

	/**
	 * @param doubleConnections
	 *            the doubleConnections to set
	 */
	public void setDoubleConnections(boolean doubleConnections) {
		this.doubleConnections = doubleConnections;
	}

	/**
	 * @return the doubleConnections
	 */
	public boolean getDoubleConnections() {
		return doubleConnections;
	}

	/**
	 * @param multiCarrierFlights
	 *            the multiCarrierFlights to set
	 */
	public void setMultiCarrierFlights(boolean multiCarrierFlights) {
		this.multiCarrierFlights = multiCarrierFlights;
	}

	/**
	 * @return the multiCarrierFlights
	 */
	public boolean getMultiCarrierFlights() {
		return multiCarrierFlights;
	}

	/**
	 * @return the noOfAirOptions
	 */
	public byte getNoOfAirOptions() {
		return noOfAirOptions;
	}

	/**
	 * @param noOfAirOptions
	 *            the noOfAirOptions to set
	 */
	public void setNoOfAirOptions(byte noOfAirOptions) {
		this.noOfAirOptions = noOfAirOptions;
	}

	/**
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
	public Object clone() throws CloneNotSupportedException {
		FlightsRequest flightRequest = (FlightsRequest) super.clone();
		if (outboundAirOptions != null) {
			flightRequest.outboundAirOptions = (AirOptions) this.outboundAirOptions
					.clone();
		}
		if (inboundAirOptions != null) {
			flightRequest.inboundAirOptions = (AirOptions) this.inboundAirOptions
					.clone();
		}
		if (preferredCarriersList != null) {
			ArrayList<Carrier> carriersList = new ArrayList<Carrier>();
			for (Carrier carrier : preferredCarriersList) {
				carriersList.add((Carrier) carrier.clone());
			}
			flightRequest.preferredCarriersList = carriersList;
		}
		return flightRequest;
	}

	/**
	 * @param alternateGatewayMiles the alternateGatewayMiles to set
	 */
	public void setAlternateGatewayMiles(int alternateGatewayMiles) {
		this.alternateGatewayMiles = alternateGatewayMiles;
	}

	/**
	 * @return the alternateGatewayMiles
	 */
	public int getAlternateGatewayMiles() {
		return alternateGatewayMiles;
	}

	public boolean isSoldOutFlight() {
		return soldOutFlight;
	}

	public void setSoldOutFlight(boolean soldOutFlight) {
		this.soldOutFlight = soldOutFlight;
	}

	/**
	 * @return the checkCharterOfferFlight
	 */
	public boolean isCheckCharterOfferFlight() {
		return checkCharterOfferFlight;
	}

	/**
	 * @param checkCharterOfferFlight the checkCharterOfferFlight to set
	 */
	public void setCheckCharterOfferFlight(boolean checkCharterOfferFlight) {
		this.checkCharterOfferFlight = checkCharterOfferFlight;
	}
}
