/*
 * Price.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 13, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Dto object to hold the Price details
 * 
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Price implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1365895284129019385L;

	private double basePrice;
	private double usTax;
	private double foreignTax;
	private double airportFee;
	private double totalTax;
	private double occpancyBasedPrice;
	private double adultPrice;
	private double childPrice;
	private double infantPrice;
	private double lapchildPrice;
	private double promoSavings;
	private List<PaxTypePriceBreakup> paxTypePriceBreakups;
	// Fileds to be used during Pricing
	private boolean priceChanged;
	private Price initialPrice;
	private float commissionPercent;
	private double commissionAmount;
	private double packagePrice;
	private PaxTypeBasePrices paxBasePrices;
	private double perAdultBasePrice;
	private double lateFee;
	
	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	/**
	 * @return the basePrice
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * @param basePrice
	 *            the basePrice to set
	 */
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * @return the usTax
	 */
	public double getUsTax() {
		return usTax;
	}

	/**
	 * @param usTax
	 *            the usTax to set
	 */
	public void setUsTax(double usTax) {
		this.usTax = usTax;
	}

	/**
	 * @return the foreignTax
	 */
	public double getForeignTax() {
		return foreignTax;
	}

	/**
	 * @param foreignTax
	 *            the foreignTax to set
	 */
	public void setForeignTax(double foreignTax) {
		this.foreignTax = foreignTax;
	}

	/**
	 * @return the airportFee
	 */
	public double getAirportFee() {
		return airportFee;
	}

	/**
	 * @param airportFee
	 *            the airportFee to set
	 */
	public void setAirportFee(double airportFee) {
		this.airportFee = airportFee;
	}

	/**
	 * @return the totalTax
	 */
	public double getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax
	 *            the totalTax to set
	 */
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the occpancyBasedPrice
	 */
	public double getOccpancyBasedPrice() {
		return occpancyBasedPrice;
	}

	/**
	 * @param occpencyBasedPrice
	 *            the occpencyBasedPrice to set
	 */
	public void setOccpancyBasedPrice(double occpencyBasedPrice) {
		this.occpancyBasedPrice = occpencyBasedPrice;
	}

	/**
	 * @return the adultPrice
	 */
	public double getAdultPrice() {
		return adultPrice;
	}

	/**
	 * @param adultPrice
	 *            the adultPrice to set
	 */
	public void setAdultPrice(double adultPrice) {
		this.adultPrice = adultPrice;
	}

	/**
	 * @return the childPrice
	 */
	public double getChildPrice() {
		return childPrice;
	}

	/**
	 * @param childPrice
	 *            the childPrice to set
	 */
	public void setChildPrice(double childPrice) {
		this.childPrice = childPrice;
	}

	/**
	 * @return the infantPrice
	 */
	public double getInfantPrice() {
		return infantPrice;
	}

	/**
	 * @param infantPrice
	 *            the infantPrice to set
	 */
	public void setInfantPrice(double infantPrice) {
		this.infantPrice = infantPrice;
	}

	/**
	 * @return the lapchildPrice
	 */
	public double getLapchildPrice() {
		return lapchildPrice;
	}

	/**
	 * @param lapchildPrice
	 *            the lapchildPrice to set
	 */
	public void setLapchildPrice(double lapchildPrice) {
		this.lapchildPrice = lapchildPrice;
	}

	/**
	 * @return the promoSavings
	 */
	public double getPromoSavings() {
		return promoSavings;
	}

	/**
	 * @param promoSavings
	 *            the promoSavings to set
	 */
	public void setPromoSavings(double promoSavings) {
		this.promoSavings = promoSavings;
	}

	/**
	 * @return the paxTypePriceBreakups
	 */
	public List<PaxTypePriceBreakup> getPaxTypePriceBreakups() {
		return paxTypePriceBreakups;
	}

	/**
	 * @param paxTypePriceBreakups
	 *            the paxTypePriceBreakups to set
	 */
	public void setPaxTypePriceBreakups(
			List<PaxTypePriceBreakup> paxTypePriceBreakups) {
		this.paxTypePriceBreakups = paxTypePriceBreakups;
	}

	/**
	 * @return the priceChanged
	 */
	public boolean isPriceChanged() {
		return priceChanged;
	}

	/**
	 * @param priceChanged
	 *            the priceChanged to set
	 */
	public void setPriceChanged(boolean priceChanged) {
		this.priceChanged = priceChanged;
	}

	/**
	 * @return the initialPrice
	 */
	public Price getInitialPrice() {
		return initialPrice;
	}

	/**
	 * @param initialPrice
	 *            the initialPrice to set
	 */
	public void setInitialPrice(Price initialPrice) {
		this.initialPrice = initialPrice;
	}

	/**
	 * @return the commissionPercent
	 */
	public float getCommissionPercent() {
		return commissionPercent;
	}

	/**
	 * @param commissionPercent
	 *            the commissionPercent to set
	 */
	public void setCommissionPercent(float commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	/**
	 * @return the commissionAmount
	 */
	public double getCommissionAmount() {
		return commissionAmount;
	}

	/**
	 * @param commissionAmount
	 *            the commissionAmount to set
	 */
	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	/**
	 * @return the packagePrice
	 */
	public double getPackagePrice() {
		return packagePrice;
	}

	/**
	 * @param packagePrice
	 *            the packagePrice to set
	 */
	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}

	/**
	 * @return the paxBasePrices
	 */
	public PaxTypeBasePrices getPaxBasePrices() {
		return paxBasePrices;
	}

	/**
	 * @param paxBasePrices
	 *            the paxBasePrices to set
	 */
	public void setPaxBasePrices(PaxTypeBasePrices paxBasePrices) {
		this.paxBasePrices = paxBasePrices;
	}

	/**
	 * 
	 * @param perAdultBasePrice
	 * To set perAdultBasePrice
	 * @see
	 * @since
	 */
	public void setPerAdultBasePrice(double perAdultBasePrice){
		this.perAdultBasePrice = perAdultBasePrice;
	}
	
	/**
	 * 
	 * @return perAdultBasePrice
	 * to return perAdultBasePrice
	 * @see
	 * @since
	 */
	public double getPerAdultBasePrice(){
		return perAdultBasePrice;
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
		Price price = (Price) super.clone();
		if (paxTypePriceBreakups != null) {
			ArrayList<PaxTypePriceBreakup> paxTypePriceList = new ArrayList<PaxTypePriceBreakup>();
			for (PaxTypePriceBreakup typePrice : paxTypePriceBreakups) {
				paxTypePriceList.add((PaxTypePriceBreakup) typePrice.clone());
			}
			price.paxTypePriceBreakups = paxTypePriceList;
		}
		if (initialPrice != null) {
			price.initialPrice = (Price) initialPrice.clone();
		}
		if(paxBasePrices != null) {
			price.setPaxBasePrices((PaxTypeBasePrices) paxBasePrices.clone());
		}
		return price;
	}
}
