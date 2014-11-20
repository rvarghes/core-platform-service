/*
 * Agency.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for holding agency details
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class Agency implements ABEDto {

	/**
	 * Default serial UID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3163852124945307122L;

	/**
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * @param customerNo
	 *            the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * @return the iataNo
	 */
	public String getIataNo() {
		return iataNo;
	}

	/**
	 * @param iataNo
	 *            the iataNo to set
	 */
	public void setIataNo(String iataNo) {
		this.iataNo = iataNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the poBox
	 */
	public String getPoBox() {
		return poBox;
	}

	/**
	 * @param poBox
	 *            the poBox to set
	 */
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	/**
	 * @return the poBoxZipCode
	 */
	public String getPoBoxZipCode() {
		return poBoxZipCode;
	}

	/**
	 * @param poBoxZipCode
	 *            the poBoxZipCode to set
	 */
	public void setPoBoxZipCode(String poBoxZipCode) {
		this.poBoxZipCode = poBoxZipCode;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the primaryPhone
	 */
	public String getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * @param primaryPhone
	 *            the primaryPhone to set
	 */
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * @return the secondaryPhone
	 */
	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	/**
	 * @param secondaryPhone
	 *            the secondaryPhone to set
	 */
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	/**
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * @param faxNo
	 *            the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the agents
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	/**
	 * @param agents
	 *            the agents to set
	 */
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	/**
	 * @return the paymentMethods
	 */
	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	/**
	 * @param paymentMethods
	 *            the paymentMethods to set
	 */
	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	/**
	 * @return the creditCards
	 */
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	/**
	 * @param creditCards
	 *            the creditCards to set
	 */
	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	/**
	 * @return the agencyRatingCode
	 */
	public String getAgencyRatingCode() {
		return agencyRatingCode;
	}

	/**
	 * @param agencyRatingCode
	 *            the agencyRatingCode to set
	 */
	public void setAgencyRatingCode(String agencyRatingCode) {
		this.agencyRatingCode = agencyRatingCode;
	}

	/**
	 * Returns the String representation of agency object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Agency>\n");
		sb.append("customerNo: " + customerNo + "\n");
		sb.append("iataNo: " + iataNo + "\n");
		sb.append("name: " + name + "\n");
		sb.append("city: " + city + "\n");
		sb.append("poBox: " + poBox + "\n");
		sb.append("poBoxZipCode: " + poBoxZipCode + "\n");
		sb.append("zipCode: " + zipCode + "\n");
		sb.append("state: " + state + "\n");
		sb.append("street: " + street + "\n");
		sb.append("primaryPhone: " + primaryPhone + "\n");
		sb.append("secondaryPhone: " + secondaryPhone + "\n");
		sb.append("faxNo: " + faxNo + "\n");
		sb.append("country: " + country + "\n");
		sb.append("agents: " + agents + "\n");
		sb.append("paymentMethods: " + paymentMethods + "\n");
		sb.append("creditCards: " + creditCards + "\n");
		sb.append("agencyRatingCode: " + agencyRatingCode + "\n");
		sb.append("</Agency>");

		return sb.toString();
	}

	/**
	 * Clone method implementation
	 * 
	 * @return
	 * @throws CloneNotSupportedException
	 * 
	 * @see
	 * @since
	 */

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	private String customerNo;
	private String iataNo;
	private String name;
	private String city;
	private String poBox;
	private String poBoxZipCode;
	private String zipCode;
	private String state;
	private String street;
	private String primaryPhone;
	private String secondaryPhone;
	private String faxNo;
	private String country;
	private List<Agent> agents;
	private List<PaymentMethod> paymentMethods;
	private List<CreditCard> creditCards;
	private String agencyRatingCode;
}