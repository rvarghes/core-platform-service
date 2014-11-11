/*
 * AirOptions.java
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

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object for holding air search options
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AirOptions implements ABEDto {

	/**
	 * Default serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3007649625572379560L;

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
	 * @return the departureTimeOfDay
	 */
	public TimeOfDay getDepartureTimeOfDay() {
		return departureTimeOfDay;
	}

	/**
	 * @param departureTimeOfDay the departureTimeOfDay to set
	 */
	public void setDepartureTimeOfDay(TimeOfDay departureTimeOfDay) {
		this.departureTimeOfDay = departureTimeOfDay;
	}

	/**
	 * @return the arrivaTimeOfDay
	 */
	public TimeOfDay getArrivaTimeOfDay() {
		return arrivaTimeOfDay;
	}

	/**
	 * @param arrivaTimeOfDay the arrivaTimeOfDay to set
	 */
	public void setArrivaTimeOfDay(TimeOfDay arrivaTimeOfDay) {
		this.arrivaTimeOfDay = arrivaTimeOfDay;
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
	 * @return the stopOverCity
	 */
	public String getStopOverCity() {
		return stopOverCity;
	}

	/**
	 * @param stopOverCity
	 *            the stopOverCity to set
	 */
	public void setStopOverCity(String stopOverCity) {
		this.stopOverCity = stopOverCity;
	}

	/**
	 * @return the stopOverDuration
	 */
	public String getStopOverDuration() {
		return stopOverDuration;
	}

	/**
	 * @param stopOverDuration
	 *            the stopOverDuration to set
	 */
	public void setStopOverDuration(String stopOverDuration) {
		this.stopOverDuration = stopOverDuration;
	}

	/**
	 * @return the connectingCity
	 */
	public String getConnectingCity() {
		return connectingCity;
	}

	/**
	 * @param connectingCity
	 *            the connectingCity to set
	 */
	public void setConnectingCity(String connectingCity) {
		this.connectingCity = connectingCity;
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
	 * Method to clone the object
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 *
	 * @see
	 * @since
	 */
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * @param outConnectionCity1 the outConnectionCity1 to set
	 */
	public void setConnectionCity1(String connectionCity1) {
		this.connectionCity1 = connectionCity1;
	}

	/**
	 * @return the outConnectionCity1
	 */
	public String getConnectionCity1() {
		return connectionCity1;
	}

	/**
	 * @param outConnectionCity2 the outConnectionCity2 to set
	 */
	public void setConnectionCity2(String connectionCity2) {
		this.connectionCity2 = connectionCity2;
	}

	/**
	 * @return the outConnectionCity2
	 */
	public String getConnectionCity2() {
		return connectionCity2;
	}
	
	/**
	 * @param excludeCity1 the excludeCity1 to set
	 */
	public void setExcludeCity1(String excludeCity1) {
		this.excludeCity1 = excludeCity1;
	}

	/**
	 * @return the excludeCity1
	 */
	public String getExcludeCity1() {
		return excludeCity1;
	}

	/**
	 * @param excludeCity2 the excludeCity2 to set
	 */
	public void setExcludeCity2(String excludeCity2) {
		this.excludeCity2 = excludeCity2;
	}

	/**
	 * @return the excludeCity2
	 */
	public String getExcludeCity2() {
		return excludeCity2;
	}

	/**
	 * @param excludeCity3 the excludeCity3 to set
	 */
	public void setExcludeCity3(String excludeCity3) {
		this.excludeCity3 = excludeCity3;
	}

	/**
	 * @return the excludeCity3
	 */
	public String getExcludeCity3() {
		return excludeCity3;
	}	
	private String noOfStops;
	// Mid night, Early morning, Morning, Evening, and Night
	private TimeOfDay departureTimeOfDay;
	// Mid night, Early morning, Morning, Evening, and Night
	private TimeOfDay arrivaTimeOfDay;
	// First Class, Business Class, Economy
	private CabinType cabinType;
	private String flightNo;
	private String classOfService;
	private String stopOverCity;
	private String stopOverDuration;
	private String connectingCity;
	private boolean showAll;
		
	private String connectionCity1;
	private String connectionCity2;	
	private String excludeCity1;
	private String excludeCity2;
	private String excludeCity3;
}