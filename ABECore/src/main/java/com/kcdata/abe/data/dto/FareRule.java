/*
 * FareRule.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object for holding fare rules
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class FareRule implements ABEDto {
	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1677939272580307608L;
	
	/**
	 * @return the gateway
	 */
	public String getGateway() {
		return gateway;
	}
	/**
	 * @param gateway the gateway to set
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
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the fareRuleText
	 */
	public String getFareRuleText() {
		return fareRuleText;
	}
	/**
	 * @param fareRuleText the fareRuleText to set
	 */
	public void setFareRuleText(String fareRuleText) {
		this.fareRuleText = fareRuleText;
	}
	
	/**
	 * Returns the String representation of Farerule object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<FareRule>\n");
		sb.append("gateway: "+gateway+"\n");
		sb.append("destination: "+destination+"\n");		
		sb.append("fareRuleText: "+fareRuleText+"\n");
		sb.append("</FareRule>");

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
		return super.clone();
	}
	
	private String gateway;
	private String destination;
	private String fareRuleText;
}