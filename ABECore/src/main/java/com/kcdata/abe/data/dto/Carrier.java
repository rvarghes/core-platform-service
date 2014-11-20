/*
 * Carrier.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 23, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold gateway details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class Carrier implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 3007683681819710138L;
	
	/**
	 * Default Constructor
	 */
	public Carrier() {		
	}
	
	/**
	 * Overloaded constructor
	 * @param code
	 * @param name
	 */
	public Carrier(String code, String name) {
		super();
		this.carrierCode = code;
		this.carrierName = name;
		this.codeshareAvaialable = false;
	}

	/**
	 * Overloaded constructor
	 * @param code
	 * @param name
	 */
	public Carrier(String code, String name, boolean codeShareExist) {
		super();
		this.carrierCode = code;
		this.carrierName = name;
		this.codeshareAvaialable = codeShareExist;
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param code
	 * @param name
	 * @param codeShareExist
	 * @param codeShareInfo
	 */
	public Carrier(String code, String name, boolean codeShareExist, String codeShareInfo) {
		super();
		if(codeShareExist && codeShareInfo.indexOf("OPERATED BY") != -1)
			codeShareInfo = codeShareInfo.replaceAll("OPERATED BY", "");	
		this.carrierCode = code;
		this.carrierName = codeShareExist?codeShareInfo:name;
		this.codeshareAvaialable = codeShareExist;
		this.codeShareInfo = codeShareInfo;
	}
	
	/**
	 * @return the carrierCode
	 */
	public String getCarrierCode() {
		return carrierCode;
	}

	/**
	 * @param carrierCode
	 *            the carrierCode to set
	 */
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	/**
	 * @return the carrierName
	 */
	public String getCarrierName() {
		return carrierName;
	}

	/**
	 * @param carrierName
	 *            the carrierName to set
	 */
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	/**
	 * @return the codeshareAvaialable
	 */
	public boolean isCodeshareAvaialable() {
		return codeshareAvaialable;
	}

	/**
	 * @param codeshareAvaialable the codeshareAvaialable to set
	 */
	public void setCodeshareAvaialable(boolean codeshareAvaialable) {
		this.codeshareAvaialable = codeshareAvaialable;
	}
	
	/**
	 * @return the codeShareInfo
	 */
	public String getCodeShareInfo() {
		return codeShareInfo;
	}

	/**
	 * @param codeShareInfo the codeShareInfo to set
	 */
	public void setCodeShareInfo(String codeShareInfo) {
		this.codeShareInfo = codeShareInfo;		
	}

	/**
	 * Returns the String representation of Gateway object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Carrier>\n");
		sb.append("carrierCode: " + carrierCode + "\n");
		sb.append("carrierName: " + carrierName + "\n");
		sb.append("codeshareAvaialable: " + codeshareAvaialable + "\n");
		sb.append("codeShareInfo: " + codeShareInfo + "\n");
		sb.append("</Carrier>");

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
		return super.clone();
	}

	private String carrierCode;
	private String carrierName;
	private boolean codeshareAvaialable;
	private String codeShareInfo;
}