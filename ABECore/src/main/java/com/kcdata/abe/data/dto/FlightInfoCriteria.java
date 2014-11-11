/*
 * FlightInfoCriteria.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 22, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to request criteria for the flight information. As of now, it reflects
 * only the charter flights.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class FlightInfoCriteria implements ABEDto {

	/**
	 * Auto generated serialization version id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2536099669794757862L;

	private Material material;
	private Date departureDate;
	private String flightNumber;
	private byte duration;
	private String rotation;
	private String classOfService;
	private String outBoundFlightId;
	private String inBoundFlightId;

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
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * @param flightNumber
	 *            the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * @return the duration
	 */
	public byte getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(byte duration) {
		this.duration = duration;
	}

	/**
	 * @return the rotation
	 */
	public String getRotation() {
		return rotation;
	}

	/**
	 * @param rotation
	 *            the rotation to set
	 */
	public void setRotation(String rotation) {
		this.rotation = rotation;
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
	 * @return the outBoundFlightId
	 */
	public String getOutBoundFlightId() {
		return outBoundFlightId;
	}

	/**
	 * @param outBoundFlightId
	 *            the outBoundFlightId to set
	 */
	public void setOutBoundFlightId(String outBoundFlightId) {
		this.outBoundFlightId = outBoundFlightId;
	}

	/**
	 * @return the inBoundFlightId
	 */
	public String getInBoundFlightId() {
		return inBoundFlightId;
	}

	/**
	 * @param inBoundFlightId
	 *            the inBoundFlightId to set
	 */
	public void setInBoundFlightId(String inBoundFlightId) {
		this.inBoundFlightId = inBoundFlightId;
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
		FlightInfoCriteria infoCriteria = (FlightInfoCriteria) super.clone();
		if (material != null) {
			infoCriteria.material = (Material) material.clone();
		}
		return infoCriteria;
	}
}
