package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * @author atripath
 *
 */
public class Vendor implements ABEDto{

	private static final long serialVersionUID = 7578171717563427469L;
	private String vendorId;
	private String firstName;
	private String lastName;
	private String streetAddrs;
	private String city;
	private String region;
	private String country;
	private String postalCode;
	private String phone;
	private String email;
	private String faxNo;
	private String mode;
	private boolean vendorExist;
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getRegion() {
		return region;
	}

	public String getStreetAddrs() {
		return streetAddrs;
	}

	public void setCity(String string) {
		city = string;
	}

	public void setCountry(String string) {
		country = string;
	}

	public void setPhone(String string) {
		phone = string;
	}

	public void setPostalCode(String string) {
		postalCode = string;
	}

	public void setRegion(String string) {
		region = string;
	}

	public void setStreetAddrs(String string) {
		streetAddrs = string;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * @param faxNo the faxNo to set
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the isVendorExist
	 */
	public boolean isVendorExist() {
		return vendorExist;
	}

	/**
	 * @param isVendorExist the isVendorExist to set
	 */
	public void setVendorExist(boolean vendorExist) {
		this.vendorExist = vendorExist;
	}
}
