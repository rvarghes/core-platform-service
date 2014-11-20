/*
 * GuestBreakdownCommissionCharge.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

public class GuestBreakdownCommissionCharge implements ABEDto{

	/**
	 */
	private static final long serialVersionUID = 2395657859518795753L;
	
	private String materialGroupDescription;
	private String materialGroup;
	private double commissionableAmount;
	private double commissionAmount;
	private String commissionPercent;
	/**
	 * @return the materialGroupDescription
	 */
	public String getMaterialGroupDescription() {
		return materialGroupDescription;
	}
	/**
	 * @param materialGroupDescription the materialGroupDescription to set
	 */
	public void setMaterialGroupDescription(String materialGroupDescription) {
		this.materialGroupDescription = materialGroupDescription;
	}
	/**
	 * @return the materialGroup
	 */
	public String getMaterialGroup() {
		return materialGroup;
	}
	/**
	 * @param materialGroup the materialGroup to set
	 */
	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}
	/**
	 * @return the commissionableAmount
	 */
	public double getCommissionableAmount() {
		return commissionableAmount;
	}
	/**
	 * @param commissionableAmount the commissionableAmount to set
	 */
	public void setCommissionableAmount(double commissionableAmount) {
		this.commissionableAmount = commissionableAmount;
	}
	/**
	 * @return the commissionAmount
	 */
	public double getCommissionAmount() {
		return commissionAmount;
	}
	/**
	 * @param commissionAmount the commissionAmount to set
	 */
	public void setCommissionAmount(double commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	/**
	 * @return the commissionPercent
	 */
	public String getCommissionPercent() {
		return commissionPercent;
	}
	/**
	 * @param commissionPercent the commissionPercent to set
	 */
	public void setCommissionPercent(String commissionPercent) {
		this.commissionPercent = commissionPercent;
	}
	
}
