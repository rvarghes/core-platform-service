/*
 * GuestInfo.java
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
 * DTO class to hold the Guest information
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class GuestInfo implements ABEDto {

	/**
	 * Auto generated serialization ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7950131400178964625L;

	// Flag to capture the check / uncheck of the particular pax in Ops Alert
	// Creation functionality
	private String selectedFlag;
	private String guestId;
	private AgeCode ageCode;
	private byte age;
	private boolean lapChild;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String phoneNumber;
	private String emailId;
	private String parentGuestId;
	private String emergencyContactName;
	private String emergencyContactPhone;
	private String frequentFlyerNo;
	private PassportInfo passportInfo;
	private String airRemarks;
	private String hotelRemarks;
	private String cruiseRemarks;
	private String mealRequest;
	private String airRequest;
	private String groundRequest;
	private String cateringRequest;
	private String seatPreference;
	private GuestPriceBreakup priceBreakup;
	private String pnrNumber;
	private String status;
	private String redressNumber;
	// Flag to hold the PAX change type in Change Booking Process.
	private String changeType;
	private String oldPaxId;
	private String paxWeight;
	//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--START
	//Field added for Issue # 3620558
	//private String paxDob;
	//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--END

	/**
	 * @return the paxWeight
	 */
	public String getPaxWeight() {
		return paxWeight;
	}

	/**
	 * @param paxWeight the paxWeight to set
	 */
	public void setPaxWeight(String paxWeight) {
		this.paxWeight = paxWeight;
	}

	/**
	 * @return the oldPaxId
	 */
	public String getOldPaxId() {
		return oldPaxId;
	}

	/**
	 * @param oldPaxId the oldPaxId to set
	 */
	public void setOldPaxId(String oldPaxId) {
		this.oldPaxId = oldPaxId;
	}

	/**
	 * @return the selectedFlag
	 */
	public String getSelectedFlag() {
		return selectedFlag;
	}

	/**
	 * @param selectedFlag
	 *            the selectedFlag to set
	 */
	public void setSelectedFlag(String selectedFlag) {
		this.selectedFlag = selectedFlag;
	}

	/**
	 * @return the guestId
	 */
	public String getGuestId() {
		return guestId;
	}

	/**
	 * @param guestId
	 *            the guestId to set
	 */
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	/**
	 * @return the ageCode
	 */
	public AgeCode getAgeCode() {
		return ageCode;
	}

	/**
	 * @param ageCode
	 *            the ageCode to set
	 */
	public void setAgeCode(AgeCode ageCode) {
		this.ageCode = ageCode;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}

	/**
	 * @return the lapChild
	 */
	public boolean isLapChild() {
		return lapChild;
	}

	/**
	 * @param lapChild
	 *            the lapChild to set
	 */
	public void setLapChild(boolean lapChild) {
		this.lapChild = lapChild;
	}

	/**
	 * @return the parentGuestId
	 */
	public String getParentGuestId() {
		return parentGuestId;
	}

	/**
	 * @param parentGuestId
	 *            the parentGuestId to set
	 */
	public void setParentGuestId(String parentGuestId) {
		this.parentGuestId = parentGuestId;
	}

	/**
	 * @return the passportInfo
	 */
	public PassportInfo getPassportInfo() {
		return passportInfo;
	}

	/**
	 * @param passportInfo
	 *            the passportInfo to set
	 */
	public void setPassportInfo(PassportInfo passportInfo) {
		this.passportInfo = passportInfo;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the emergencyContactName
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	/**
	 * @param emergencyContactName
	 *            the emergencyContactName to set
	 */
	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	/**
	 * @return the emergencyContactPhone
	 */
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}

	/**
	 * @param emergencyContactPhone
	 *            the emergencyContactPhone to set
	 */
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}

	/**
	 * @return the frequentFlyerNo
	 */
	public String getFrequentFlyerNo() {
		return frequentFlyerNo;
	}

	/**
	 * @param frequentFlyerNo
	 *            the frequentFlyerNo to set
	 */
	public void setFrequentFlyerNo(String frequentFlyerNo) {
		this.frequentFlyerNo = frequentFlyerNo;
	}

	/**
	 * @return the hotelRemarks
	 */
	public String getHotelRemarks() {
		return hotelRemarks;
	}

	/**
	 * @param hotelRemarks
	 *            the hotelRemarks to set
	 */
	public void setHotelRemarks(String hotelRemarks) {
		this.hotelRemarks = hotelRemarks;
	}

	/**
	 * @return the airRemarks
	 */
	public String getAirRemarks() {
		return airRemarks;
	}

	/**
	 * @param airRemarks
	 *            the airRemarks to set
	 */
	public void setAirRemarks(String airRemarks) {
		this.airRemarks = airRemarks;
	}

	/**
	 * @return the cruiseRemarks
	 */
	public String getCruiseRemarks() {
		return cruiseRemarks;
	}

	/**
	 * @param cruiseRemarks
	 *            the cruiseRemarks to set
	 */
	public void setCruiseRemarks(String cruiseRemarks) {
		this.cruiseRemarks = cruiseRemarks;
	}

	/**
	 * @return the mealRequest
	 */
	public String getMealRequest() {
		return mealRequest;
	}

	/**
	 * @param mealRequest
	 *            the mealRequest to set
	 */
	public void setMealRequest(String mealRequest) {
		this.mealRequest = mealRequest;
	}

	/**
	 * @return the airRequest
	 */
	public String getAirRequest() {
		return airRequest;
	}

	/**
	 * @param airRequest
	 *            the airRequest to set
	 */
	public void setAirRequest(String airRequest) {
		this.airRequest = airRequest;
	}

	/**
	 * @return the groundRequest
	 */
	public String getGroundRequest() {
		return groundRequest;
	}

	/**
	 * @param groundRequest
	 *            the groundRequest to set
	 */
	public void setGroundRequest(String groundRequest) {
		this.groundRequest = groundRequest;
	}

	/**
	 * @return the cateringRequest
	 */
	public String getCateringRequest() {
		return cateringRequest;
	}

	/**
	 * @param cateringRequest
	 *            the cateringRequest to set
	 */
	public void setCateringRequest(String cateringRequest) {
		this.cateringRequest = cateringRequest;
	}

	/**
	 * @return the seatPreference
	 */
	public String getSeatPreference() {
		return seatPreference;
	}

	/**
	 * @param seatPreference
	 *            the seatPreference to set
	 */
	public void setSeatPreference(String seatPreference) {
		this.seatPreference = seatPreference;
	}

	/**
	 * @return the priceBreakup
	 */
	public GuestPriceBreakup getPriceBreakup() {
		return priceBreakup;
	}

	/**
	 * @param priceBreakup
	 *            the priceBreakup to set
	 */
	public void setPriceBreakup(GuestPriceBreakup priceBreakup) {
		this.priceBreakup = priceBreakup;
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
		sb.append("\n<GuestInfo>\n");
		sb.append("guestId: " + guestId + "\n");
		sb.append("ageCode: " + ageCode + "\n");
		sb.append("age: " + age + "\n");
		sb.append("lapChild: " + lapChild + "\n");
		sb.append("title: " + title + "\n");
		sb.append("firstName: " + firstName + "\n");
		sb.append("lastName: " + lastName + "\n");
		sb.append("gender: " + gender + "\n");
		sb.append("dateOfBirth: " + dateOfBirth + "\n");
		sb.append("phoneNumber: " + phoneNumber + "\n");
		sb.append("emailId: " + emailId + "\n");
		sb.append("parentGuestId: " + parentGuestId + "\n");
		sb.append("emergencyContactName: " + emergencyContactName + "\n");
		sb.append("emergencyContactPhone: " + emergencyContactPhone + "\n");
		sb.append("frequentFlyerNo: " + frequentFlyerNo + "\n");
		sb.append("airRemarks: " + airRemarks + "\n");
		sb.append("hotelRemarks: " + hotelRemarks + "\n");
		sb.append("cruiseRemarks: " + cruiseRemarks + "\n");
		sb.append("mealRequest: " + mealRequest + "\n");
		sb.append("airRequest: " + airRequest + "\n");
		sb.append("groundRequest: " + groundRequest + "\n");
		sb.append("cateringRequest: " + cateringRequest + "\n");
		sb.append("seatPreference: " + seatPreference + "\n");
		sb.append("passportInfo: " + passportInfo + "\n");
		sb.append("priceBreakup: " + priceBreakup + "\n");
		sb.append("redressNumber: "+ redressNumber + "\n");
		sb.append("</GuestInfo>");
		return sb.toString();
	}

	/**
	 * @return the pnrNumber
	 */
	public String getPnrNumber() {
		return pnrNumber;
	}

	/**
	 * @param pnrNumber
	 *            the pnrNumber to set
	 */
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the redressNumber
	 */
	public String getRedressNumber() {
		return redressNumber;
	}

	/**
	 * @param redressNumber the redressNumber to set
	 */
	public void setRedressNumber(String redressNumber) {
		this.redressNumber = redressNumber;
	}

	/**
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType
	 *            the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
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
		GuestInfo guestInfo = (GuestInfo) super.clone();
		if (passportInfo != null) {
			guestInfo.passportInfo = (PassportInfo) passportInfo.clone();
		}
		if (priceBreakup != null) {
			guestInfo.priceBreakup = (GuestPriceBreakup) priceBreakup.clone();
		}
		return guestInfo;
	}
	//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--START
/*	*//**
	 * @return the paxDob
	 *//*
	public String getPaxDob() {
		return paxDob;
	}

	*//**
	 * @param paxDob the paxDob to set
	 *//*
	public void setPaxDob(String paxDob) {
		this.paxDob = paxDob;
	}*/
	//IGT-S---Ticket # 3620558a--Code Revoked--Code Before 3620558a changes--END
}
