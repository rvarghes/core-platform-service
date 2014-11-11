/*
 * DestinationOptions.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 9, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold destination based search criteria options
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class DestinationOptions implements ABEDto {

	/**
	 * Default serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 7888151811728614019L;

	/**
	 * @return the destinationId
	 */
	public int getDestinationId() {
		return destinationId;
	}

	/**
	 * @param destinationId
	 *            the destinationId to set
	 */
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the noOfNights
	 */
	public short getNoOfNights() {
		return noOfNights;
	}

	/**
	 * @param noOfNights
	 *            the noOfNights to set
	 */
	public void setNoOfNights(short noOfNights) {
		this.noOfNights = noOfNights;
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
	 * @return the hotelOptions
	 */
	public HotelOptions getHotelOptions() {
		return hotelOptions;
	}

	/**
	 * @param hotelOptions
	 *            the hotelOptions to set
	 */
	public void setHotelOptions(HotelOptions hotelOptions) {
		this.hotelOptions = hotelOptions;
	}

	/**
	 * @return the specialOptions
	 */
	public SpecialOptions getSpecialOptions() {
		return specialOptions;
	}

	/**
	 * @param specialOptions
	 *            the specialOptions to set
	 */
	public void setSpecialOptions(SpecialOptions specialOptions) {
		this.specialOptions = specialOptions;
	}

	/**
	 * @return the vehicleOptions
	 */
	public VehicleOptions getVehicleOptions() {
		return vehicleOptions;
	}

	/**
	 * @param vehicleOptions
	 *            the vehicleOptions to set
	 */
	public void setVehicleOptions(VehicleOptions vehicleOptions) {
		this.vehicleOptions = vehicleOptions;
	}

	/**
	 * @return the airRequested
	 */
	public boolean isAirRequested() {
		return airRequested;
	}

	/**
	 * @param airRequested
	 *            the airRequested to set
	 */
	public void setAirRequested(boolean airRequested) {
		this.airRequested = airRequested;
	}

	/**
	 * @return the hotelRequested
	 */
	public boolean isHotelRequested() {
		return hotelRequested;
	}

	/**
	 * @param hotelRequested
	 *            the hotelRequested to set
	 */
	public void setHotelRequested(boolean hotelRequested) {
		this.hotelRequested = hotelRequested;
	}

	/**
	 * @return the vehicleRequested
	 */
	public boolean isVehicleRequested() {
		return vehicleRequested;
	}

	/**
	 * @param vehicleRequested
	 *            the vehicleRequested to set
	 */
	public void setVehicleRequested(boolean vehicleRequested) {
		this.vehicleRequested = vehicleRequested;
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
	 * Method to clone the object
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */
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

	public Object clone() throws CloneNotSupportedException {
		DestinationOptions destOptions = (DestinationOptions) super.clone();
		if (outboundAirOptions != null) {
			destOptions.outboundAirOptions = (AirOptions) this.outboundAirOptions
					.clone();
		}
		if (inboundAirOptions != null) {
			destOptions.inboundAirOptions = (AirOptions) this.inboundAirOptions
					.clone();
		}
		if (hotelOptions != null) {
			destOptions.hotelOptions = (HotelOptions) this.hotelOptions.clone();
		}
		if (specialOptions != null) {
			destOptions.specialOptions = (SpecialOptions) this.specialOptions
					.clone();
		}
		if (vehicleOptions != null) {
			destOptions.vehicleOptions = (VehicleOptions) this.vehicleOptions
					.clone();
		}
		if (preferredCarriersList != null) {
			ArrayList<Carrier> carriersList = new ArrayList<Carrier>();
			for (Carrier carrier : preferredCarriersList) {
				carriersList.add((Carrier) carrier.clone());
			}
			destOptions.preferredCarriersList = carriersList;
		}
		return destOptions;
	}

	public void setAlternateGatewayMiles(int alternateGatewayMiles) {
		this.alternateGatewayMiles = alternateGatewayMiles;
	}

	public int getAlternateGatewayMiles() {
		return alternateGatewayMiles;
	}

	/**
	 * @return the soldOutFlight
	 */
	public boolean isSoldOutFlight() {
		return soldOutFlight;
	}

	/**
	 * @param soldOutFlight the soldOutFlight to set
	 */
	public void setSoldOutFlight(boolean soldOutFlight) {
		this.soldOutFlight = soldOutFlight;
	}

	private int destinationId;
	private String destination;
	private short noOfNights;
	private AirOptions outboundAirOptions;
	private AirOptions inboundAirOptions;
	private HotelOptions hotelOptions;
	private SpecialOptions specialOptions;
	private VehicleOptions vehicleOptions;
	private boolean airRequested;
	private boolean hotelRequested;
	private boolean vehicleRequested;
	private boolean nearbyAirportIndicator;
	private boolean flexiDateIndicator;
	private List<String> nearByDestinations;
	private boolean charterOnly;
	private boolean skedOnly;
	private List<Carrier> preferredCarriersList;
	private boolean nonStopFlights;
	private boolean doubleConnections;
	private boolean multiCarrierFlights;
	private byte noOfAirOptions;
	private int alternateGatewayMiles;
	//retrieve soldout charter air
	private boolean soldOutFlight;
}