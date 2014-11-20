/*
 * SpecialOptions.java
 * Copyright 2011 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jan 21, 2011  chazari
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Holds search criteria for specials
 * @author chazari
 * @version
 */
public class SpecialOptions implements ABEDto {

	/**
	 * Auto generated serial Id
	 */
	private static final long serialVersionUID = -3584260986826361855L;
	
	private SpecialRequestType specialRequestType;
	private SpecialType specialType;
	private String specialCategoryId;
	private String specialBatchId;
	// holds Package Id for charter or the value 'APPLEVAC' for sked
	// N.A for any retrieval only a place holder for front end
	private String specialId;
	
	/**
	 * @return the specialRequestType
	 */
	public SpecialRequestType getSpecialRequestType() {
		return specialRequestType;
	}
	/**
	 * @param specialRequestType the specialRequestType to set
	 */
	public void setSpecialRequestType(SpecialRequestType specialRequestType) {
		this.specialRequestType = specialRequestType;
	}
	/**
	 * @return the specialType
	 */
	public SpecialType getSpecialType() {
		return specialType;
	}
	/**
	 * @param specialType the specialType to set
	 */
	public void setSpecialType(SpecialType specialType) {
		this.specialType = specialType;
	}
	/**
	 * @return the specialCategoryId
	 */
	public String getSpecialCategoryId() {
		return specialCategoryId;
	}
	/**
	 * @param specialCategoryId the specialCategoryId to set
	 */
	public void setSpecialCategoryId(String specialCategoryId) {
		this.specialCategoryId = specialCategoryId;
	}
	/**
	 * @return the specialBatchId
	 */
	public String getSpecialBatchId() {
		return specialBatchId;
	}
	/**
	 * @param specialBatchId the specialBatchId to set
	 */
	public void setSpecialBatchId(String specialBatchId) {
		this.specialBatchId = specialBatchId;
	}
	
	/**
	 * @return the specialId
	 */
	public String getSpecialId() {
		return specialId;
	}
	/**
	 * @param specialId the specialId to set
	 */
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}
	/**
	 * Clone special options here
	 * @return SpecialOptions
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (SpecialOptions)super.clone();
	}

	
	
}
