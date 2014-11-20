/*
 * FlightSegment.java
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

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold flight segment details RetrieveFlights usecase
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightSegment implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6807485124226682982L;
	private String flightNo;
	private String gateway;
	private String destination;
	private Date departureDate;
	private Date arrivalDate;
	private Carrier codeShareCarrier;
	private String classOfService;
	private byte seatsAvailable;
	private Carrier carrier;
	private char rotation;
	private int noOfStops;
	private long travelTime;
	private String mealsServed;
	private String aircraftType;
	private CabinType cabinType;
	private boolean overNight;
	private boolean eTicket;
	private FareBasisCode fareBasisCode;
	private String recordLocator;
	private String pnrNumber;
	
	/*CQ8775 - FlightPhone & FlightInfo fields added*/
	private String flightPhone;
	private String flightInfo;
	
	//Need to embed in as file also sanoop
	private boolean seatMapAvailable;
	private String seatMapReqJson;
	private Long contractId;
	
	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * @param flightNo
	 *            the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
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
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 *            the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the codeShareCarrier
	 */
	public Carrier getCodeShareCarrier() {
		return codeShareCarrier;
	}

	/**
	 * @param codeShareCarrier the codeShareCarrier to set
	 */
	public void setCodeShareCarrier(Carrier codeShareCarrier) {
		this.codeShareCarrier = codeShareCarrier;
	}

	/**
	 * @return the classOfService
	 */
	public String getClassOfService() {
		return classOfService;
	}

	/**
	 * @param classOfService
	 *            the classOfService to set
	 */
	public void setClassOfService(String classOfService) {
		this.classOfService = classOfService;
	}

	/**
	 * @return the seatsAvailable
	 */
	public byte getSeatsAvailable() {
		return seatsAvailable;
	}

	/**
	 * @param seatsAvailable
	 *            the seatsAvailable to set
	 */
	public void setSeatsAvailable(byte seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	/**
	 * @return the carrier
	 */
	public Carrier getCarrier() {
		return carrier;
	}

	/**
	 * @param carrier
	 *            the carrier to set
	 */
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	/**
	 * @return the rotation
	 */
	public char getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(char rotation) {
		this.rotation = rotation;
	}

	/**
	 * @return the noOfStops
	 */
	public int getNoOfStops() {
		return noOfStops;
	}

	/**
	 * @param noOfStops the noOfStops to set
	 */
	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}

	/**
	 * @return the travelTime
	 */
	public long getTravelTime() {
		return travelTime;
	}

	/**
	 * @param travelTime the travelTime to set
	 */
	public void setTravelTime(long travelTime) {
		this.travelTime = travelTime;
	}

	/**
	 * @return the mealsServed
	 */
	public String getMealsServed() {
		return mealsServed;
	}

	/**
	 * @param mealsServed the mealsServed to set
	 */
	public void setMealsServed(String mealsServed) {
		this.mealsServed = mealsServed;
	}

	/**
	 * @return the aircraftType
	 */
	public String getAircraftType() {
		return aircraftType;
	}

	/**
	 * @param aircraftType the aircraftType to set
	 */
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	/**
	 * @return the overNight
	 */
	public boolean isOverNight() {
		return overNight;
	}

	/**
	 * @param overNight the overNight to set
	 */
	public void setOverNight(boolean overNight) {
		this.overNight = overNight;
	}

	/**
	 * @return the cabinType
	 */
	public CabinType getCabinType() {
		return cabinType;
	}

	/**
	 * @param cabinType the cabinType to set
	 */
	public void setCabinType(CabinType cabinType) {
		this.cabinType = cabinType;
	}

	/**
	 * @return the eTicket
	 */
	public boolean isETicket() {
		return eTicket;
	}

	/**
	 * @param ticket the eTicket to set
	 */
	public void setETicket(boolean ticket) {
		eTicket = ticket;
	}
	
	/**
	 * @return the fareBasisCode
	 */
	public FareBasisCode getFareBasisCode() {
		return fareBasisCode;
	}

	/**
	 * @param fareBasisCode the fareBasisCode to set
	 */
	public void setFareBasisCode(FareBasisCode fareBasisCode) {
		this.fareBasisCode = fareBasisCode;
	}
	
	/**
	 * @return the recordLocator
	 */
	public String getRecordLocator() {
		return recordLocator;
	}

	/**
	 * @param recordLocator the recordLocator to set
	 */
	public void setRecordLocator(String recordLocator) {
		this.recordLocator = recordLocator;
	}

	/**
	 * @return the pnrNumber
	 */
	public String getPnrNumber() {
		return pnrNumber;
	}

	/**
	 * @param pnrNumber the pnrNumber to set
	 */
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	/**
	 * @return the flightPhone
	 */
	public String getFlightPhone() {
		return flightPhone;
	}

	/**
	 * @param flightPhone the flightPhone to set
	 */
	public void setFlightPhone(String flightPhone) {
		this.flightPhone = flightPhone;
	}

	/**
	 * @return the flightInfo
	 */
	public String getFlightInfo() {
		return flightInfo;
	}

	/**
	 * @param flightInfo the flightInfo to set
	 */
	public void setFlightInfo(String flightInfo) {
		this.flightInfo = flightInfo;
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
		FlightSegment clonedSegment = (FlightSegment) super.clone();
		if(fareBasisCode != null) {
			clonedSegment.fareBasisCode = (FareBasisCode) fareBasisCode.clone();
		}
		return clonedSegment;
	}

	public boolean isSeatMapAvailable() {
		return seatMapAvailable;
	}

	public void setSeatMapAvailable(boolean seatMapAvailable) {
		this.seatMapAvailable = seatMapAvailable;
	}

	public String getSeatMapReqJson() {
		return seatMapReqJson;
	}

	public void setSeatMapReqJson(String seatMapReqJson) {
		this.seatMapReqJson = seatMapReqJson;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}


	
}
