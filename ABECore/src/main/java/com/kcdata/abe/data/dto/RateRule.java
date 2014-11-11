/*
 * RateRule.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 29, 2011  nvittal	  Initial creation
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object for holding rate rules
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class RateRule implements ABEDto {
	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 1677939272580307608L;
	
	public RateRule() {
		super();
	}

	public RateRule(String rateRuleText) {
		super();
		this.rateRuleText = rateRuleText;
	}

	/**
	 * @return the rateRuleText
	 */
	public String getRateRuleText() {
		return rateRuleText;
	}

	/**
	 * @param rateRuleText the rateRuleText to set
	 */
	public void setRateRuleText(String rateRuleText) {
		this.rateRuleText = rateRuleText;
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
		sb.append("\n<RateRule>\n");
		sb.append("rateRuleText: "+rateRuleText+"\n");
		sb.append("</RateRule>");

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
	
	private String rateRuleText;
}