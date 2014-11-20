/*
 * RoomCategory.java
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
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold hotel room category data
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class RoomCategory implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3811159733386765966L;

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
	 * @return the roomTypeCode
	 */
	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	/**
	 * @param roomTypeCode
	 *            the roomTypeCode to set
	 */
	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	/**
	 * @return the roomTypeDescription
	 */
	public String getRoomTypeDescription() {
		return roomTypeDescription;
	}

	/**
	 * @param roomTypeDescription
	 *            the roomTypeDescription to set
	 */
	public void setRoomTypeDescription(String roomTypeDescription) {
		this.roomTypeDescription = roomTypeDescription;
	}

	/**
	 * @return the ratePlanId
	 */
	public String getRatePlanId() {
		return ratePlanId;
	}

	/**
	 * @param ratePlanId the ratePlanId to set
	 */
	public void setRatePlanId(String ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	/**
	 * @return the ratePlanCode
	 */
	public String getRatePlanCode() {
		return ratePlanCode;
	}

	/**
	 * @param ratePlanCode
	 *            the ratePlanCode to set
	 */
	public void setRatePlanCode(String ratePlanCode) {
		this.ratePlanCode = ratePlanCode;
	}

	/**
	 * @return the ratePlanDescription
	 */
	public String getRatePlanDescription() {
		return ratePlanDescription;
	}

	/**
	 * @param ratePlanDescription
	 *            the ratePlanDescription to set
	 */
	public void setRatePlanDescription(String ratePlanDescription) {
		this.ratePlanDescription = ratePlanDescription;
	}

	/**
	 * @return the rateIndicator
	 */
	public String getRateIndicator() {
		return rateIndicator;
	}

	/**
	 * @param rateIndicator
	 *            the rateIndicator to set
	 */
	public void setRateIndicator(String rateIndicator) {
		this.rateIndicator = rateIndicator;
	}

	/**
	 * @return the corporateId
	 */
	public String getCorporateId() {
		return corporateId;
	}

	/**
	 * @param corporateId
	 *            the corporateId to set
	 */
	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	/**
	 * @return the guaranteeType
	 */
	public String getGuaranteeType() {
		return guaranteeType;
	}

	/**
	 * @param guaranteeType
	 *            the guaranteeType to set
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	/**
	 * @return the guaranteeMethod
	 */
	public String getGuaranteeMethod() {
		return guaranteeMethod;
	}

	/**
	 * @param guaranteeMethod
	 *            the guaranteeMethod to set
	 */
	public void setGuaranteeMethod(String guaranteeMethod) {
		this.guaranteeMethod = guaranteeMethod;
	}

	/**
	 * @return the guaranteeRequired
	 */
	public String getGuaranteeRequired() {
		return guaranteeRequired;
	}

	/**
	 * @param guaranteeRequired
	 *            the guaranteeRequired to set
	 */
	public void setGuaranteeRequired(String guaranteeRequired) {
		this.guaranteeRequired = guaranteeRequired;
	}

	/**
	 * @return the guaranteeAmount
	 */
	public double getGuaranteeAmount() {
		return guaranteeAmount;
	}

	/**
	 * @param guaranteeAmount
	 *            the guaranteeAmount to set
	 */
	public void setGuaranteeAmount(double guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	/**
	 * @return the ratePlanCategory
	 */
	public String getRatePlanCategory() {
		return ratePlanCategory;
	}

	/**
	 * @param ratePlanCategory
	 *            the ratePlanCategory to set
	 */
	public void setRatePlanCategory(String ratePlanCategory) {
		this.ratePlanCategory = ratePlanCategory;
	}

	/**
	 * @return the noOfRoomsAvailable
	 */
	public int getNoOfRoomsAvailable() {
		return noOfRoomsAvailable;
	}

	/**
	 * @param noOfRoomsAvailable
	 *            the noOfRoomsAvailable to set
	 */
	public void setNoOfRoomsAvailable(int noOfRoomsAvailable) {
		this.noOfRoomsAvailable = noOfRoomsAvailable;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the amenities
	 */
	public List<Amenity> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities
	 *            the amenities to set
	 */
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the roomPrices
	 */
	public List<RoomPrice> getRoomPrices() {
		return roomPrices;
	}

	/**
	 * @param roomPrices
	 *            the roomPrices to set
	 */
	public void setRoomPrices(List<RoomPrice> roomPrices) {
		this.roomPrices = roomPrices;
	}

	/**
	 * @return the displayRoomPrice
	 */
	public RoomPrice getDisplayRoomPrice() {
		return displayRoomPrice;
	}

	/**
	 * @param displayRoomPrice
	 *            the displayRoomPrice to set
	 */
	public void setDisplayRoomPrice(RoomPrice displayRoomPrice) {
		this.displayRoomPrice = displayRoomPrice;
	}

	/**
	 * @return the mealPlanType
	 */
	public MealPlanType getMealPlanType() {
		return mealPlanType;
	}

	/**
	 * @param mealPlanType the mealPlanType to set
	 */
	public void setMealPlanType(MealPlanType mealPlanType) {
		this.mealPlanType = mealPlanType;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr the posnr to set
	 */
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	/**
	 * @return the oldPosnr
	 */
	public String getOldPosnr() {
		return oldPosnr;
	}

	/**
	 * @param oldPosnr the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
	}

	/**
	 * @return the riskRoomCategory
	 */
	public boolean isRiskRoomCategory() {
		return riskRoomCategory;
	}

	/**
	 * @param riskRoomCategory the riskRoomCategory to set
	 */
	public void setRiskRoomCategory(boolean riskRoomCategory) {
		this.riskRoomCategory = riskRoomCategory;
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
		sb.append("\n<RoomCategory>\n");
		sb.append("hotelId: " + hotelId + "\n");
		sb.append("roomCategoryId: " + roomCategoryId + "\n");
		sb.append("ratePlanId: " + ratePlanId + "\n");
		sb.append("roomTypeCode: " + roomTypeCode + "\n");
		sb.append("roomTypeDescription: " + roomTypeDescription + "\n");
		sb.append("ratePlanCode: " + ratePlanCode + "\n");
		sb.append("ratePlanDescription: " + ratePlanDescription + "\n");
		sb.append("rateIndicator: " + rateIndicator + "\n");
		sb.append("corporateId: " + corporateId + "\n");
		sb.append("guaranteeType: " + guaranteeType + "\n");
		sb.append("guaranteeMethod: " + guaranteeMethod + "\n");
		sb.append("guaranteeRequired: " + guaranteeRequired + "\n");
		sb.append("guaranteeAmount: " + guaranteeAmount + "\n");
		sb.append("ratePlanCategory: " + ratePlanCategory + "\n");
		sb.append("noOfRoomsAvailable: " + noOfRoomsAvailable + "\n");
		sb.append("status: " + status + "\n");
		sb.append("currency: " + currency + "\n");
		sb.append("roomPrices: " + roomPrices + "\n");
		sb.append("amenities: " + amenities + "\n");
		sb.append("displayRoomPrice: " + displayRoomPrice + "\n");
		sb.append("posnr: " + posnr + "\n");
		sb.append("oldPosnr: " + oldPosnr + "\n");
		sb.append("</RoomCategory>");

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
		RoomCategory roomCategory = (RoomCategory) super.clone();
		if (roomPrices != null) {
			ArrayList<RoomPrice> prices = new ArrayList<RoomPrice>();
			for (RoomPrice price : prices) {
				prices.add((RoomPrice) price.clone());
			}
			roomCategory.roomPrices = prices;
		}
		if (amenities != null) {
			ArrayList<Amenity> amenitiesList = new ArrayList<Amenity>();
			for (Amenity price : amenities) {
				amenitiesList.add((Amenity) price.clone());
			}
			roomCategory.amenities = amenitiesList;
		}
		if(displayRoomPrice != null) {
			roomCategory.displayRoomPrice = (RoomPrice) displayRoomPrice.clone();
		}
		return roomCategory;
	}
	/**
	 * @return the appleChoice
	 */
	public boolean getAppleChoice() {
		return appleChoice;
	}

	/**
	 * @param appleChoice the appleChoice to set
	 */
	public void setAppleChoice(boolean appleChoice) {
		this.appleChoice = appleChoice;
	} 

	/**
	 * @return the mealplanDesc
	 */
	public String getMealplanDesc() {
		return mealplanDesc;
	}

	/**
	 * @param mealplanDesc the mealplanDesc to set
	 */
	public void setMealplanDesc(String mealplanDesc) {
		this.mealplanDesc = mealplanDesc;
	}
	
	/**
	 * @return the rateRules
	 */
	public List<RateRule> getRateRules() {
		return rateRules;
	}

	/**
	 * @param rateRules the rateRules to set
	 */
	public void setRateRules(List<RateRule> rateRules) { 
		this.rateRules = rateRules;
	}
	
	public void appendRateRule(RateRule rateRule) {
		if(this.rateRules == null)
			this.rateRules = new ArrayList<RateRule>();
		this.rateRules.add(rateRule);
	}
	/**
	 * @return the hbsiRates
	 */
	public List<HBSiRates> getHbsiRates() {
		return hbsiRates;
	}

	/**
	 * @param hbsiRates the hbsiRates to set
	 */
	public void setHbsiRates(List<HBSiRates> hbsiRates) {
		this.hbsiRates = hbsiRates;
	}
	
	private int hotelId;
	private int roomCategoryId;
	private String roomTypeCode;
	private String roomTypeDescription;
	/*
	 * Corresponds to SAP cost type - S (SKED), C(Charter), L(Land)
	 * This need to be passed back during pricing & booking calls
	 */
	private String ratePlanId;
	private String ratePlanCode;
	private String ratePlanDescription;
	private String rateIndicator;
	// Company identification for room reservation
	private String corporateId;
	// Guarantee for room reservation at booking
	private String guaranteeType;
	private String guaranteeMethod;
	private String guaranteeRequired;
	private double guaranteeAmount;
	// Rate Plan Category ( Material Group )
	private String ratePlanCategory;
	private int noOfRoomsAvailable;
	// Hotel status
	private String status;
	private String currency;
	private List<RoomPrice> roomPrices;
	private List<Amenity> amenities;
	private RoomPrice displayRoomPrice;
	private MealPlanType mealPlanType;
	// POSNR numbers for reserved hotels
	private String posnr;
	private String oldPosnr;
	private boolean riskRoomCategory;
	private boolean appleChoice;
	private String mealplanDesc;
	private List<RateRule> rateRules;

	private List<String> roomPrices2;

	public List<String> getRoomPrices2() {
		return roomPrices2;
	}

	public void setRoomPrices2(List<String> roomPrices2) {
		this.roomPrices2 = roomPrices2;
	}

	private List<HBSiRates> hbsiRates;
	private List<CancelPolicy> cancelPolicy;

	/**
	 * @return the cancelPolicy
	 */
	public List<CancelPolicy> getCancelPolicy() {
		return cancelPolicy;
	}

	/**
	 * @param cancelPolicy the cancelPolicy to set
	 */
	public void setCancelPolicy(List<CancelPolicy> cancelPolicy) {
		this.cancelPolicy = cancelPolicy;
	}

}