/*
 * PassportInfo.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import java.util.Date;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * DTO class to hold the Passport information
 *
 * @author hguntupa
 * @version
 *
 *
 * @see
 * @since
 */
public class PassportInfo implements ABEDto {
	
	/**
	 * Auto generated serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -3395208819739098160L;
	
	private String passportNumber;
	private String nationality;
	private String countryOfIssue;
	private Date expirationDate;
	private Address address;
	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}
	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the countryOfIssue
	 */
	public String getCountryOfIssue() {
		return countryOfIssue;
	}
	/**
	 * @param countryOfIssue the countryOfIssue to set
	 */
	public void setCountryOfIssue(String countryOfIssue) {
		this.countryOfIssue = countryOfIssue;
	}
	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * toString implementation
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<PassportInfo>\n");
		sb.append("passportNumber: " + passportNumber + "\n");
		sb.append("nationality: " + nationality + "\n");
		sb.append("countryOfIssue: " + countryOfIssue + "\n");
		sb.append("expirationDate: " + expirationDate + "\n");
		sb.append("address: " + address + "\n");
		sb.append("</PassportInfo>");

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
		PassportInfo passportInfo = (PassportInfo) super.clone();
		if(address != null) {
			passportInfo.address = (Address) this.address.clone();			
		}
		return passportInfo;
	}	
}
