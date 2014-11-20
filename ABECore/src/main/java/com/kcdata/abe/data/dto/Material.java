/*
 * Material.java
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

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO class to hold the material details
 * 
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Material implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 9166031011841883296L;

	private String materialNo;
	private String batchNo;
	private String plant;
	private String storageLocation;

	/**
	 * Default Constructor
	 */
	public Material() {
	}

	/**
	 * Constructor
	 * 
	 * @param materialNo
	 * @param batchNo
	 * @param plant
	 * @param storageLocation
	 */
	public Material(String materialNo, String batchNo, String plant,
			String storageLocation) {
		this.materialNo = materialNo;
		this.batchNo = batchNo;
		this.plant = plant;
		this.storageLocation = storageLocation;
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
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo
	 *            the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}

	/**
	 * @param plant
	 *            the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
	 * @return the storageLocation
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * @param storageLocation
	 *            the storageLocation to set
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
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
