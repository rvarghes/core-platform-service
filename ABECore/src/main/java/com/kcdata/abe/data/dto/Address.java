/*
 * Address.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO to hold the address details
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class Address implements ABEDto {

	/**
	 * Auto generated serialization ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6650312022899585218L;

	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * toString implementation
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Address>\n");
		sb.append("streetAddress: " + streetAddress + "\n");
		sb.append("city: " + city + "\n");
		sb.append("state: " + state + "\n");
		sb.append("country: " + country + "\n");
		sb.append("zipCode: " + zipCode + "\n");
		sb.append("</Address>");

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
}
