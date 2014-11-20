/*
 * StopOver.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold stop over details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class StopOver implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;

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
	 * @return the stopOverLocations
	 */
	public List<StopOverLocation> getStopOverLocations() {
		return stopOverLocations;
	}

	/**
	 * @param stopOverLocations
	 *            the stopOverLocations to set
	 */
	public void setStopOverLocations(List<StopOverLocation> stopOverLocations) {
		this.stopOverLocations = stopOverLocations;
	}

	/**
	 * Equals method implementation for comparing stopover objects
	 * 
	 * @param o
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof StopOver))
			return false;
		StopOver stopover = (StopOver) obj;
		if (this.getGateway().equalsIgnoreCase(stopover.getGateway())
				&& this.getDestination().equalsIgnoreCase(
						stopover.getDestination()))
			return true;

		return false;
	}

	/**
	 * Returns the String representation of StopOver object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<StopOver>\n");
		sb.append("gateway: " + gateway + "\n");
		sb.append("destination: " + destination + "\n");
		sb.append("stopOverLocations: " + stopOverLocations + "\n");
		sb.append("</StopOver>");

		return sb.toString();
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
		StopOver stopOver = (StopOver) super.clone();
		if(stopOverLocations != null) {
			ArrayList<StopOverLocation> stopLocationsList = new ArrayList<StopOverLocation>();
			for(StopOverLocation stopOverLocation: stopOverLocations) {
				stopLocationsList.add((StopOverLocation) stopOverLocation.clone());
			}
			stopOver.stopOverLocations = stopLocationsList;
		}
		return stopOver;
	}

	private String gateway;
	private String destination;
	private List<StopOverLocation> stopOverLocations;
}