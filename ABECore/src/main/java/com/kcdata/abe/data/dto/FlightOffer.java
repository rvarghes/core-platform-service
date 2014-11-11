/*
 * FlightOffer.java
 * Copyright 2014 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 12, 2014  jmondigo
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;


/**
 * Class containing needed data for flight offers
 * 
 * @author jmondigo
 */
public class FlightOffer {
	private boolean charterFlightOffer;
	private String verbiage;
	private String dayOfTheWeek;
	private int durationToBeChange;
	private int durationToChangeTo;
	
	/**
	 * @return the charterFlightOffer
	 */
	public boolean isCharterFlightOffer() {
		return charterFlightOffer;
	}
	/**
	 * @param charterFlightOffer the charterFlightOffer to set
	 */
	public void setCharterFlightOffer(boolean charterFlightOffer) {
		this.charterFlightOffer = charterFlightOffer;
	}	
	/**
	 * @return the verbiage
	 */
	public String getVerbiage() {
		return verbiage;
	}
	/**
	 * @param verbiage the verbiage to set
	 */
	public void setVerbiage(String verbiage) {
		this.verbiage = verbiage;
	}
	/**
	 * @return the dayOfTheWeek
	 */
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	/**
	 * @param dayOfTheWeek the dayOfTheWeek to set
	 */
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	/**
	 * @return the durationToBeChange
	 */
	public int getDurationToBeChange() {
		return durationToBeChange;
	}
	/**
	 * @param durationToBeChange the durationToBeChange to set
	 */
	public void setDurationToBeChange(int durationToBeChange) {
		this.durationToBeChange = durationToBeChange;
	}
	/**
	 * @return the durationToChangeTo
	 */
	public int getDurationToChangeTo() {
		return durationToChangeTo;
	}
	/**
	 * @param durationToChangeTo the durationToChangeTo to set
	 */
	public void setDurationToChangeTo(int durationToChangeTo) {
		this.durationToChangeTo = durationToChangeTo;
	}

}
