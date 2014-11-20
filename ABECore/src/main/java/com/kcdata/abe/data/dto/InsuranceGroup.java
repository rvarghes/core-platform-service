/*
 * InsuranceGroup.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class to group the insurance based on insurance type
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class InsuranceGroup implements ABEDto {

	/**
	 * Auto generated serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7926026840686651652L;

	private String code;
	private String description;
	private List<Insurance> insuranceList;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the insuranceList
	 */
	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	/**
	 * @param insuranceList
	 *            the insuranceList to set
	 */
	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	/**
	 * Method to add insurance to the insurance list
	 * 
	 * @param insurance
	 * 
	 * @see
	 * @since
	 */
	public void addInsuranceToList(Insurance insurance) {
		if (insurance == null) {
			return;
		}
		if (insuranceList == null) {
			// list is null. Create and add it to the list
			insuranceList = new ArrayList<Insurance>();
			insuranceList.add(insurance);
		} else {
			// Components are allocated to the users. Merge the allocation
			Insurance existingInsurance = getInsuranceByMaterial(insurance
					.getMaterialNo());
			if (existingInsurance != null) {
				if (insurance.getGuestAllocationList() != null
						&& insurance.getGuestAllocationList().size() > 0) {
					existingInsurance.addInsuranceGuestAllocation(insurance
							.getGuestAllocationList().get(0));
					// Update Guest Allocation
					if (existingInsurance.getGuestAllocation() == null) {
						existingInsurance.setGuestAllocation(insurance
								.getGuestAllocation());
					} else if (insurance.getGuestAllocation() != null) {
						existingInsurance.setGuestAllocation(existingInsurance
								.getGuestAllocation()
								+ "," + insurance.getGuestAllocation());
					}
					// Update Disabled Guest Allocation
					if (existingInsurance.getDisabledGuestAllocation() == null) {
						existingInsurance.setDisabledGuestAllocation(insurance
								.getDisabledGuestAllocation());
					} else if (insurance.getDisabledGuestAllocation() != null) {
						existingInsurance
								.setDisabledGuestAllocation(existingInsurance
										.getDisabledGuestAllocation()
										+ ","
										+ insurance
												.getDisabledGuestAllocation());
					}
				}
			} else {
				insuranceList.add(insurance);
			}
		}
	}

	/**
	 * Method to retrieve the insurance by material ID
	 * 
	 * @param materialId
	 * @return
	 * 
	 * @see
	 * @since
	 */
	private Insurance getInsuranceByMaterial(String materialId) {
		if (insuranceList == null) {
			return null;
		}
		for (Insurance insurance : insuranceList) {
			if (materialId != null
					&& materialId.equals(insurance.getMaterialNo())) {
				return insurance;
			}
		}
		return null;
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
		InsuranceGroup insuranceGroup = (InsuranceGroup) super.clone();
		if (insuranceList != null) {
			ArrayList<Insurance> insurances = new ArrayList<Insurance>();
			for (Insurance insurance : insuranceList) {
				insurances.add((Insurance) insurance.clone());
			}
			insuranceGroup.setInsuranceList(insurances);
		}
		return insuranceGroup;
	}
}
