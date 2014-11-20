/*
 * Flight.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 26, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold flight details Retrieve Flights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Flight implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4904292203740601067L;
	private List<FlightSegment> flightSegments;
	private String gateway;
	private String destination;
	private Date departureTime;
	private Date arrivalTime;
	private String flightId;
	private String noOfStops;
	private Material material;
	private long travelTime;
	// overNight flight flag will be true if any flightSegment is overNight
	private boolean overNight;
	// POSNR numbers for reserved flights
	private String posnr;
	private String oldPosnr;
	private String flightIdForSeatMap;
	private String seatMapReqJson;
	private boolean seatMapAvailable;
	private Long contractId;

	/**
	 * @return the flightSegments
	 */
	public List<FlightSegment> getFlightSegments() {
		return flightSegments;
	}

	/**
	 * @param flightSegments
	 *            the flightSegments to set
	 */
	public void setFlightSegments(List<FlightSegment> flightSegments) {
		this.flightSegments = flightSegments;
	}

	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * @param gateway
	 *            the gateway to set
	 */

	public void setGateway(String gateway) {
		this.gateway = gateway;
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
	 * @return the departureTime
	 */
	public Date getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime
	 *            the departureTime to set
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime
	 *            the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId
	 *            the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the noOfStops
	 */
	public String getNoOfStops() {
		return noOfStops;
	}

	/**
	 * @param noOfStops
	 *            the noOfStops to set
	 */
	public void setNoOfStops(String noOfStops) {
		this.noOfStops = noOfStops;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the travelTime
	 */
	public long getTravelTime() {
		return travelTime;
	}

	/**
	 * @param travelTime
	 *            the travelTime to set
	 */
	public void setTravelTime(long travelTime) {
		this.travelTime = travelTime;
	}

	/**
	 * @return the overNight
	 */
	public boolean isOverNight() {
		return overNight;
	}

	/**
	 * @param overNight
	 *            the overNight to set
	 */
	public void setOverNight(boolean overNight) {
		this.overNight = overNight;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr
	 *            the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the oldPosnr
	 */
	public String getOldPosnr() {
		return oldPosnr;
	}

	/**
	 * @param oldPosnr
	 *            the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
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
		Flight clonedFlightObj = (Flight) super.clone();
		if (flightSegments != null) {
			ArrayList<FlightSegment> segments = new ArrayList<FlightSegment>();
			for (FlightSegment segment : flightSegments) {
				segments.add((FlightSegment) segment.clone());
			}
			clonedFlightObj.flightSegments = segments;
		}
		if (material != null) {
			clonedFlightObj.material = (Material) material.clone();
		}
		return clonedFlightObj;
	}

	/**
	 * @return the flightIdForSeatMap
	 */
	public String getFlightIdForSeatMap() {
		return flightIdForSeatMap;
	}

	/**
	 * @param flightIdForSeatMap the flightIdForSeatMap to set
	 */
	public void setFlightIdForSeatMap(String flightIdForSeatMap) {
		this.flightIdForSeatMap = flightIdForSeatMap;
	}

	/**
	 * @return the seatMapReqJson
	 */
	public String getSeatMapReqJson() {
		return seatMapReqJson;
	}

	/**
	 * @param seatMapReqJson the seatMapReqJson to set
	 */
	public void setSeatMapReqJson(String seatMapReqJson) {
		this.seatMapReqJson = seatMapReqJson;
	}

	/**
	 * @return the seatMapAvailable
	 */
	public boolean isSeatMapAvailable() {
		return seatMapAvailable;
	}

	/**
	 * @param seatMapAvailable the seatMapAvailable to set
	 */
	public void setSeatMapAvailable(boolean seatMapAvailable) {
		this.seatMapAvailable = seatMapAvailable;
	}

	/**
	 * @return the contractId
	 */
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}
	
}
