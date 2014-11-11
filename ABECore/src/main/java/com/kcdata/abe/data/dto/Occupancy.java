/*
 * Occupancy.java
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
 * Transfer object to hold occupancy details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Occupancy implements ABEDto {

	/**
	 * Default serial ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 2276313013397205296L;

	/**
	 * @return the noOfAdults
	 */
	public byte getNoOfAdults() {
		return noOfAdults;
	}

	/**
	 * @param noOfAdults
	 *            the noOfAdults to set
	 */
	public void setNoOfAdults(byte noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	/**
	 * @return the noOfSeniors
	 */
	public byte getNoOfSeniors() {
		return noOfSeniors;
	}

	/**
	 * @param noOfSeniors
	 *            the noOfSeniors to set
	 */
	public void setNoOfSeniors(byte noOfSeniors) {
		this.noOfSeniors = noOfSeniors;
	}

	/**
	 * @return the noOfChilds
	 */
	public byte getNoOfChilds() {
		return noOfChilds;
	}

	/**
	 * @param noOfChilds
	 *            the noOfChilds to set
	 */
	public void setNoOfChilds(byte noOfChilds) {
		this.noOfChilds = noOfChilds;
	}

	/**
	 * @return the noOfLapChilds
	 */
	public byte getNoOfLapChilds() {
		return noOfLapChilds;
	}

	/**
	 * @param noOfLapChilds the noOfLapChilds to set
	 */
	public void setNoOfLapChilds(byte noOfLapChilds) {
		this.noOfLapChilds = noOfLapChilds;
	}

	/**
	 * @return the noOfInfants
	 */
	public byte getNoOfInfants() {
		return noOfInfants;
	}

	/**
	 * @param noOfInfants
	 *            the noOfInfants to set
	 */
	public void setNoOfInfants(byte noOfInfants) {
		this.noOfInfants = noOfInfants;
	}

	/**
	 * @return the passengers
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers
	 *            the passengers to set
	 */
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
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
		Occupancy occupancy = (Occupancy) super.clone();
		if(passengers != null) {
			ArrayList<Passenger> passList = new ArrayList<Passenger>();
			for(Passenger passenger: passList) {
				passList.add((Passenger) passenger.clone());
			}
			occupancy.passengers = passList;
		}
		return occupancy;
	}

	private byte noOfAdults;
	private byte noOfSeniors;
	private byte noOfChilds;
	private byte noOfLapChilds;
	private byte noOfInfants;
	private List<Passenger> passengers;
}