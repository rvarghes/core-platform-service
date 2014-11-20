/*
 * RoomPrice.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 29, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold room price details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RoomPrice implements ABEDto {

	/**
	 * Default Serial UID
	 * 
	 * @see
	 * @since
	 */
	private static long serialVersionUID = 6443852347039927833L;

	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId
	 *            the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the roomCategoryId
	 */
	public int getRoomCategoryId() {
		return roomCategoryId;
	}

	/**
	 * @param roomCategoryId
	 *            the roomCategoryId to set
	 */
	public void setRoomCategoryId(int roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}

	/**
	 * @return the roomId
	 */
	public byte getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setRoomId(byte roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount
	 *            the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
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
	 * @return the commissionPercent
	 */
	public double getCommissionPercent() {
		return commissionPercent;
	}

	/**
	 * @param commissionPercent
	 *            the commissionPercent to set
	 */
	public void setCommissionPercent(double commissionPercent) {
		this.commissionPercent = commissionPercent;
	}

	/**
	 * @return the lateFee
	 */
	public double getLateFee() {
		return lateFee;
	}

	/**
	 * @param lateFee
	 *            the lateFee to set
	 */
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	/**
	 * @return the freeNights
	 */
	public int getFreeNights() {
		return freeNights;
	}

	/**
	 * @param freeNights
	 *            the freeNights to set
	 */
	public void setFreeNights(int freeNights) {
		this.freeNights = freeNights;
	}

	/**
	 * @return the promoSavingsAmount
	 */
	public double getPromoSavingsAmount() {
		return promoSavingsAmount;
	}

	/**
	 * @param promoSavingsAmount
	 *            the promoSavingsAmount to set
	 */
	public void setPromoSavingsAmount(double promoSavingsAmount) {
		this.promoSavingsAmount = promoSavingsAmount;
	}

	/**
	 * @return the savings
	 */
	public double getSavings() {
		return savings;
	}

	/**
	 * @param savings
	 *            the savings to set
	 */
	public void setSavings(double savings) {
		this.savings = savings;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
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
	public RoomPrice getInitialPrice() {
		return initialPrice;
	}

	/**
	 * @param initialPrice
	 *            the initialPrice to set
	 */
	public void setInitialPrice(RoomPrice initialPrice) {
		this.initialPrice = initialPrice;
	}

	/**
	 * @return the guestAllocation
	 */
	public String getGuestAllocation() {
		return guestAllocation;
	}

	/**
	 * @param guestAllocation
	 *            the guestAllocation to set
	 */
	public void setGuestAllocation(String guestAllocation) {
		this.guestAllocation = guestAllocation;
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
	 *  To set perAdultBasePrice
	 * @see
	 * @since
	 */
	public void setPerAdultBasePrice(double perAdultBasePrice){
		this.perAdultBasePrice = perAdultBasePrice;
	}
	
	/**
	 * @return the perAdultBasePriceSavings
	 */
	public double getPerAdultBasePriceSavings() {
		return perAdultBasePriceSavings;
	}

	/**
	 * @param perAdultBasePriceSavings the perAdultBasePriceSavings to set
	 */
	public void setPerAdultBasePriceSavings(double perAdultBasePriceSavings) {
		this.perAdultBasePriceSavings = perAdultBasePriceSavings;
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
	 * Returns the String representation of Room object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<RoomPrice>\n");
		sb.append("hotelId: " + hotelId + "\n");
		sb.append("roomCategoryId: " + roomCategoryId + "\n");
		sb.append("roomId: " + roomId + "\n");
		sb.append("totalAmount: " + totalAmount + "\n");
		sb.append("tax: " + tax + "\n");
		sb.append("commission: " + commissionAmount + "\n");
		sb.append("commissionPercent: " + commissionPercent + "\n");
		sb.append("lateFee: " + lateFee + "\n");
		sb.append("freeNights: " + freeNights + "\n");
		sb.append("promoSavingsAmount: " + promoSavingsAmount + "\n");
		sb.append("savings: " + savings + "\n");
		sb.append("currency: " + currency + "\n");
		sb.append("paxTypePriceBreakups: " + paxTypePriceBreakups + "\n");
		sb.append("perAdultBasePrice: " + perAdultBasePrice + "\n");
		sb.append("</RoomPrice>");

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
		RoomPrice roomPrice = (RoomPrice) super.clone();
		if (paxTypePriceBreakups != null) {
			ArrayList<PaxTypePriceBreakup> priceBreakupList = new ArrayList<PaxTypePriceBreakup>();
			for (PaxTypePriceBreakup priceBreakUp : paxTypePriceBreakups) {
				priceBreakupList
						.add((PaxTypePriceBreakup) priceBreakUp.clone());
			}
			roomPrice.setPaxTypePriceBreakups(priceBreakupList);
		}
		if (initialPrice != null) {
			roomPrice.setInitialPrice((RoomPrice) initialPrice.clone());
		}
		if (paxBasePrices != null) {
			roomPrice.setPaxBasePrices((PaxTypeBasePrices) paxBasePrices.clone());
		}
		return roomPrice;
	}

	private int hotelId;
	private int roomCategoryId;
	private byte roomId;
	private double totalAmount;
	private double tax;
	private double commissionAmount;
	private double commissionPercent;
	private double lateFee;
	private int freeNights;
	private double promoSavingsAmount;
	private double savings;
	private String currency;
	private List<PaxTypePriceBreakup> paxTypePriceBreakups;
	// Fields to be used for pricing
	private boolean priceChanged;
	private RoomPrice initialPrice;
	private String guestAllocation;
	private double packagePrice;
	private PaxTypeBasePrices paxBasePrices;
	private double perAdultBasePrice;
	private double perAdultBasePriceSavings;
	private Date checkInDate;
	//IGT--3620582---Nov02,2012--Sked flights showing allocated to the wrong passengers. Shows switched in ABE - E-Docs Display incorrectly
	/*code commented for revocation of 3620582 and it's setter & getter
	private String allocatedGuestNames;*/
	//Added 2 new attributes to hold hotel cost and transfer cost
	private Double hotelCost;
	private Double transferCost;
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param serialversionuid the serialversionuid to set
	 */
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	/**
	 * @return the hotelCost
	 */
	public Double getHotelCost() {
		return hotelCost;
	}

	/**
	 * @param hotelCost the hotelCost to set
	 */
	public void setHotelCost(Double hotelCost) {
		this.hotelCost = hotelCost;
	}

	/**
	 * @return the transferCost
	 */
	public Double getTransferCost() {
		return transferCost;
	}

	/**
	 * @param transferCost the transferCost to set
	 */
	public void setTransferCost(Double transferCost) {
		this.transferCost = transferCost;
	}



	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	/**
	 * @return the allocatedGuestNames
	 */
/*	public String getAllocatedGuestNames() {
		return allocatedGuestNames;
	}*/

	/**
	 * @param allocatedGuestNames the allocatedGuestNames to set
	 */
/*	public void setAllocatedGuestNames(String allocatedGuestNames) {
		this.allocatedGuestNames = allocatedGuestNames;
	}*/
}
