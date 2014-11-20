/*
 * PaxTypeBasePrices.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 29, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to hold the base prices of all the types of passages for each
 * component. This class is used as data carrier from One BAPI call to other.
 * Fields in these class will not be used by front end.
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PaxTypeBasePrices implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8057195998341958962L;

	private String noOfAdults;
	private String noOfChilds;
	private String noOfInfants;
	private String noOfLapChilds;
	private String noOfSeniors;
	private String child1Age;
	private String child2Age;
	private String child3Age;
	private String child4Age;
	private String child5Age;
	private String child6Age;
	private String noOfJuniors;
	private String noOfMinors;
	private String child1Type;
	private String child2Type;
	private String child3Type;
	private String child4Type;
	private String child5Type;
	private String child6Type;

	// Prices
	private double adultBasePrice;
	private double childBasePrice;
	private double seniorBasePrice;
	private double infantBasePrice;
	private double lapChildBasePrice;
	private double juniorBasePrice;
	private double minorBasePrice;

	/**
	 * @return the noOfAdults
	 */
	public String getNoOfAdults() {
		return noOfAdults;
	}

	/**
	 * @param noOfAdults
	 *            the noOfAdults to set
	 */
	public void setNoOfAdults(String noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	/**
	 * @return the noOfChilds
	 */
	public String getNoOfChilds() {
		return noOfChilds;
	}

	/**
	 * @param noOfChilds
	 *            the noOfChilds to set
	 */
	public void setNoOfChilds(String noOfChilds) {
		this.noOfChilds = noOfChilds;
	}

	/**
	 * @return the noOfInfants
	 */
	public String getNoOfInfants() {
		return noOfInfants;
	}

	/**
	 * @param noOfInfants
	 *            the noOfInfants to set
	 */
	public void setNoOfInfants(String noOfInfants) {
		this.noOfInfants = noOfInfants;
	}

	/**
	 * @return the noOfLapChilds
	 */
	public String getNoOfLapChilds() {
		return noOfLapChilds;
	}

	/**
	 * @param noOfLapChilds
	 *            the noOfLapChilds to set
	 */
	public void setNoOfLapChilds(String noOfLapChilds) {
		this.noOfLapChilds = noOfLapChilds;
	}

	/**
	 * @return the noOfSeniors
	 */
	public String getNoOfSeniors() {
		return noOfSeniors;
	}

	/**
	 * @param noOfSeniors
	 *            the noOfSeniors to set
	 */
	public void setNoOfSeniors(String noOfSeniors) {
		this.noOfSeniors = noOfSeniors;
	}

	/**
	 * @return the child1Age
	 */
	public String getChild1Age() {
		return child1Age;
	}

	/**
	 * @param child1Age
	 *            the child1Age to set
	 */
	public void setChild1Age(String child1Age) {
		this.child1Age = child1Age;
	}

	/**
	 * @return the child2Age
	 */
	public String getChild2Age() {
		return child2Age;
	}

	/**
	 * @param child2Age
	 *            the child2Age to set
	 */
	public void setChild2Age(String child2Age) {
		this.child2Age = child2Age;
	}

	/**
	 * @return the child3Age
	 */
	public String getChild3Age() {
		return child3Age;
	}

	/**
	 * @param child3Age
	 *            the child3Age to set
	 */
	public void setChild3Age(String child3Age) {
		this.child3Age = child3Age;
	}

	/**
	 * @return the child4Age
	 */
	public String getChild4Age() {
		return child4Age;
	}

	/**
	 * @param child4Age
	 *            the child4Age to set
	 */
	public void setChild4Age(String child4Age) {
		this.child4Age = child4Age;
	}

	/**
	 * @return the child5Age
	 */
	public String getChild5Age() {
		return child5Age;
	}

	/**
	 * @param child5Age
	 *            the child5Age to set
	 */
	public void setChild5Age(String child5Age) {
		this.child5Age = child5Age;
	}

	/**
	 * @return the child6Age
	 */
	public String getChild6Age() {
		return child6Age;
	}

	/**
	 * @param child6Age
	 *            the child6Age to set
	 */
	public void setChild6Age(String child6Age) {
		this.child6Age = child6Age;
	}

	/**
	 * @return the noOfJuniors
	 */
	public String getNoOfJuniors() {
		return noOfJuniors;
	}

	/**
	 * @param noOfJuniors
	 *            the noOfJuniors to set
	 */
	public void setNoOfJuniors(String noOfJuniors) {
		this.noOfJuniors = noOfJuniors;
	}

	/**
	 * @return the noOfMinors
	 */
	public String getNoOfMinors() {
		return noOfMinors;
	}

	/**
	 * @param noOfMinors
	 *            the noOfMinors to set
	 */
	public void setNoOfMinors(String noOfMinors) {
		this.noOfMinors = noOfMinors;
	}

	/**
	 * @return the child1Type
	 */
	public String getChild1Type() {
		return child1Type;
	}

	/**
	 * @param child1Type
	 *            the child1Type to set
	 */
	public void setChild1Type(String child1Type) {
		this.child1Type = child1Type;
	}

	/**
	 * @return the child2Type
	 */
	public String getChild2Type() {
		return child2Type;
	}

	/**
	 * @param child2Type
	 *            the child2Type to set
	 */
	public void setChild2Type(String child2Type) {
		this.child2Type = child2Type;
	}

	/**
	 * @return the child3Type
	 */
	public String getChild3Type() {
		return child3Type;
	}

	/**
	 * @param child3Type
	 *            the child3Type to set
	 */
	public void setChild3Type(String child3Type) {
		this.child3Type = child3Type;
	}

	/**
	 * @return the child4Type
	 */
	public String getChild4Type() {
		return child4Type;
	}

	/**
	 * @param child4Type
	 *            the child4Type to set
	 */
	public void setChild4Type(String child4Type) {
		this.child4Type = child4Type;
	}

	/**
	 * @return the child5Type
	 */
	public String getChild5Type() {
		return child5Type;
	}

	/**
	 * @param child5Type
	 *            the child5Type to set
	 */
	public void setChild5Type(String child5Type) {
		this.child5Type = child5Type;
	}

	/**
	 * @return the child6Type
	 */
	public String getChild6Type() {
		return child6Type;
	}

	/**
	 * @param child6Type
	 *            the child6Type to set
	 */
	public void setChild6Type(String child6Type) {
		this.child6Type = child6Type;
	}

	/**
	 * @return the adultBasePrice
	 */
	public double getAdultBasePrice() {
		return adultBasePrice;
	}

	/**
	 * @param adultBasePrice
	 *            the adultBasePrice to set
	 */
	public void setAdultBasePrice(double adultBasePrice) {
		this.adultBasePrice = adultBasePrice;
	}

	/**
	 * @return the childBasePrice
	 */
	public double getChildBasePrice() {
		return childBasePrice;
	}

	/**
	 * @param childBasePrice
	 *            the childBasePrice to set
	 */
	public void setChildBasePrice(double childBasePrice) {
		this.childBasePrice = childBasePrice;
	}

	/**
	 * @return the seniorBasePrice
	 */
	public double getSeniorBasePrice() {
		return seniorBasePrice;
	}

	/**
	 * @param seniorBasePrice
	 *            the seniorBasePrice to set
	 */
	public void setSeniorBasePrice(double seniorBasePrice) {
		this.seniorBasePrice = seniorBasePrice;
	}

	/**
	 * @return the infantBasePrice
	 */
	public double getInfantBasePrice() {
		return infantBasePrice;
	}

	/**
	 * @param infantBasePrice
	 *            the infantBasePrice to set
	 */
	public void setInfantBasePrice(double infantBasePrice) {
		this.infantBasePrice = infantBasePrice;
	}

	/**
	 * @return the lapChildBasePrice
	 */
	public double getLapChildBasePrice() {
		return lapChildBasePrice;
	}

	/**
	 * @param lapChildBasePrice
	 *            the lapChildBasePrice to set
	 */
	public void setLapChildBasePrice(double lapChildBasePrice) {
		this.lapChildBasePrice = lapChildBasePrice;
	}

	/**
	 * @return the juniorBasePrice
	 */
	public double getJuniorBasePrice() {
		return juniorBasePrice;
	}

	/**
	 * @param juniorBasePrice
	 *            the juniorBasePrice to set
	 */
	public void setJuniorBasePrice(double juniorBasePrice) {
		this.juniorBasePrice = juniorBasePrice;
	}

	/**
	 * @return the minorBasePrice
	 */
	public double getMinorBasePrice() {
		return minorBasePrice;
	}

	/**
	 * @param minorBasePrice
	 *            the minorBasePrice to set
	 */
	public void setMinorBasePrice(double minorBasePrice) {
		this.minorBasePrice = minorBasePrice;
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
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
