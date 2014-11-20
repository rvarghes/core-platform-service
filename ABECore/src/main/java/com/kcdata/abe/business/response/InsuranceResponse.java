/*
 * InsuranceResponse.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 17, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.business.response;

import java.util.List;

import com.kcdata.abe.data.dto.InsuranceGroup;
import com.kcdata.abe.framework.response.ABEResponse;

public class InsuranceResponse extends ABEResponse {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 4134140100106966739L;

	/**
	 * Field to hold list of insurance groups
	 */
	private List<InsuranceGroup> insuranceGroupList;

	/**
	 * @return the insuranceGroupList
	 */
	public List<InsuranceGroup> getInsuranceGroupList() {
		return insuranceGroupList;
	}

	/**
	 * @param insuranceGroupList
	 *            the insuranceGroupList to set
	 */
	public void setInsuranceGroupList(List<InsuranceGroup> insuranceGroupList) {
		this.insuranceGroupList = insuranceGroupList;
	}

}
