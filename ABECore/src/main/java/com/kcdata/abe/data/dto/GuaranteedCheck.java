/*
 * GuaranteedCheck.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 12, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for Guaranteed Check information
 *
 * @author dmahanth
 * @version
 *
 * @see
 * @since
 */
public class GuaranteedCheck implements ABEDto{

	/**
	 * Default serial UID.
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -6829582007905820099L;

	//Guaranteed Check Information
	private String checkNo;
	private double promisedAmount;
	private String remarks;	
	
	/**
	 * @return the checkNo
	 */
	public String getCheckNo() {
		return checkNo;
	}
	/**
	 * @param checkNo the checkNo to set
	 */
	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}
	
	/**
	 * @return the promisedAmount
	 */
	public double getPromisedAmount() {
		return promisedAmount;
	}
	/**
	 * @param promisedAmount the promisedAmount to set
	 */
	public void setPromisedAmount(double promisedAmount) {
		this.promisedAmount = promisedAmount;
	}
	
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
