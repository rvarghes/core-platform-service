/*
 * Insurance.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

public class Insurance implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9195875259606121505L;

	// Using this itemRPH while matching the option description from ABAP other
	// table
	private int itemRPH;
	private String materialNo;
	private String materailDesc;
	private Date validDateFrom;
	private Date validDateTo;
	private String vacationType;
	private String vacationDescription;
	private double adultPrice;
	private double childPrice;
	private String childRuleDesc;
	private int childMinAge;
	private int childMaxAge;
	private String optionIns;
	// variable to hold the full description of the insurance option
	private String optionDesc;
	// Variable to hold the purchased passenger Information
	private String guestAllocation;
	// Selected quantity and ages for Pricing the Insurance
	private byte adultsQty;
	private byte childsQty;
	private byte infantsQty;
	private byte lapChildQty;
	private byte seniorsQty;
	private List<Integer> childAges;
	private double totalPrice;

	// POSNR numbers for reserved insurance
	private String posnr;
	private String oldPosnr;
	private byte maxQuantity;
	private String disabledGuestAllocation;
	private List<InsuranceGuestAllocation> guestAllocationList;

	/**
	 * @return the itemRPH
	 */
	public int getItemRPH() {
		return itemRPH;
	}

	/**
	 * @param itemRPH
	 *            the itemRPH to set
	 */
	public void setItemRPH(int itemRPH) {
		this.itemRPH = itemRPH;
	}

	/**
	 * @return the materialNo
	 */
	public String getMaterialNo() {
		return materialNo;
	}

	/**
	 * @param materialNo
	 *            the materialNo to set
	 */
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	/**
	 * @return the materailDesc
	 */
	public String getMaterailDesc() {
		return materailDesc;
	}

	/**
	 * @param materailDesc
	 *            the materailDesc to set
	 */
	public void setMaterailDesc(String materailDesc) {
		this.materailDesc = materailDesc;
	}

	/**
	 * @return the validDateFrom
	 */
	public Date getValidDateFrom() {
		return validDateFrom;
	}

	/**
	 * @param validDateFrom
	 *            the validDateFrom to set
	 */
	public void setValidDateFrom(Date validDateFrom) {
		this.validDateFrom = validDateFrom;
	}

	/**
	 * @return the validDateTo
	 */
	public Date getValidDateTo() {
		return validDateTo;
	}

	/**
	 * @param validDateTo
	 *            the validDateTo to set
	 */
	public void setValidDateTo(Date validDateTo) {
		this.validDateTo = validDateTo;
	}

	/**
	 * @return the vacationType
	 */
	public String getVacationType() {
		return vacationType;
	}

	/**
	 * @param vacationType
	 *            the vacationType to set
	 */
	public void setVacationType(String vacationType) {
		this.vacationType = vacationType;
	}

	/**
	 * @return the vacationDescription
	 */
	public String getVacationDescription() {
		return vacationDescription;
	}

	/**
	 * @param vacationDescription
	 *            the vacationDescription to set
	 */
	public void setVacationDescription(String vacationDescription) {
		this.vacationDescription = vacationDescription;
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
	 * @return the childRuleDesc
	 */
	public String getChildRuleDesc() {
		return childRuleDesc;
	}

	/**
	 * @param childRuleDesc
	 *            the childRuleDesc to set
	 */
	public void setChildRuleDesc(String childRuleDesc) {
		this.childRuleDesc = childRuleDesc;
	}

	/**
	 * @return the childMinAge
	 */
	public int getChildMinAge() {
		return childMinAge;
	}

	/**
	 * @param childMinAge
	 *            the childMinAge to set
	 */
	public void setChildMinAge(int childMinAge) {
		this.childMinAge = childMinAge;
	}

	/**
	 * @return the childMaxAge
	 */
	public int getChildMaxAge() {
		return childMaxAge;
	}

	/**
	 * @param childMaxAge
	 *            the childMaxAge to set
	 */
	public void setChildMaxAge(int childMaxAge) {
		this.childMaxAge = childMaxAge;
	}

	/**
	 * @return the optionIns
	 */
	public String getOptionIns() {
		return optionIns;
	}

	/**
	 * @param optionIns
	 *            the optionIns to set
	 */
	public void setOptionIns(String optionIns) {
		this.optionIns = optionIns;
	}

	/**
	 * @return the optionDesc
	 */
	public String getOptionDesc() {
		return optionDesc;
	}

	/**
	 * @param optionDesc
	 *            the optionDesc to set
	 */
	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
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
	 * @return the adultsQty
	 */
	public byte getAdultsQty() {
		return adultsQty;
	}

	/**
	 * @param adultsQty
	 *            the adultsQty to set
	 */
	public void setAdultsQty(byte adultsQty) {
		this.adultsQty = adultsQty;
	}

	/**
	 * @return the childsQty
	 */
	public byte getChildsQty() {
		return childsQty;
	}

	/**
	 * @param childsQty
	 *            the childsQty to set
	 */
	public void setChildsQty(byte childsQty) {
		this.childsQty = childsQty;
	}

	/**
	 * @return the infantsQty
	 */
	public byte getInfantsQty() {
		return infantsQty;
	}

	/**
	 * @param infantsQty
	 *            the infantsQty to set
	 */
	public void setInfantsQty(byte infantsQty) {
		this.infantsQty = infantsQty;
	}

	/**
	 * @return the lapChildQty
	 */
	public byte getLapChildQty() {
		return lapChildQty;
	}

	/**
	 * @param lapChildQty
	 *            the lapChildQty to set
	 */
	public void setLapChildQty(byte lapChildQty) {
		this.lapChildQty = lapChildQty;
	}

	/**
	 * @return the seniorsQty
	 */
	public byte getSeniorsQty() {
		return seniorsQty;
	}

	/**
	 * @param seniorsQty
	 *            the seniorsQty to set
	 */
	public void setSeniorsQty(byte seniorsQty) {
		this.seniorsQty = seniorsQty;
	}

	/**
	 * @return the childAges
	 */
	public List<Integer> getChildAges() {
		return childAges;
	}

	/**
	 * @param childAges
	 *            the childAges to set
	 */
	public void setChildAges(List<Integer> childAges) {
		this.childAges = childAges;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the posnr
	 */
	public String getPosnr() {
		return posnr;
	}

	/**
	 * @param posnr
	 *            the posnr to set
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
	 * @param oldPosnr
	 *            the oldPosnr to set
	 */
	public void setOldPosnr(String oldPosnr) {
		this.oldPosnr = oldPosnr;
	}

	/**
	 * @return the maxQuantity
	 */
	public byte getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * @param maxQuantity
	 *            the maxQuantity to set
	 */
	public void setMaxQuantity(byte maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	/**
	 * @return the disabledGuestAllocation
	 */
	public String getDisabledGuestAllocation() {
		return disabledGuestAllocation;
	}

	/**
	 * @param disabledGuestAllocation
	 *            the disabledGuestAllocation to set
	 */
	public void setDisabledGuestAllocation(String disabledGuestAllocation) {
		this.disabledGuestAllocation = disabledGuestAllocation;
	}

	/**
	 * @return the guestAllocationList
	 */
	public List<InsuranceGuestAllocation> getGuestAllocationList() {
		return guestAllocationList;
	}

	/**
	 * @param guestAllocationList
	 *            the guestAllocationList to set
	 */
	public void setGuestAllocationList(
			List<InsuranceGuestAllocation> guestAllocationList) {
		this.guestAllocationList = guestAllocationList;
	}

	/**
	 * Method to add insurance guest allocation to the insurance
	 * 
	 * @param insuranceGuestAllocation
	 * 
	 * @see
	 * @since
	 */
	public void addInsuranceGuestAllocation(
			InsuranceGuestAllocation insuranceGuestAllocation) {
		if (insuranceGuestAllocation != null) {
			if (guestAllocationList == null) {
				guestAllocationList = new ArrayList<InsuranceGuestAllocation>();
			}
			guestAllocationList.add(insuranceGuestAllocation);
		}
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
		Insurance insurance = (Insurance) super.clone();
		if (insurance.getGuestAllocationList() != null) {
			List<InsuranceGuestAllocation> insGuestList = new ArrayList<InsuranceGuestAllocation>();
			for (InsuranceGuestAllocation insGuestAllocation : insurance
					.getGuestAllocationList()) {
				insGuestList.add((InsuranceGuestAllocation) insGuestAllocation
						.clone());
			}
			insurance.setGuestAllocationList(insGuestList);
		}
		return insurance;
	}
}
