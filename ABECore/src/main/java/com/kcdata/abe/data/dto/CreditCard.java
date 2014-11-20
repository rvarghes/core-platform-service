/*
 * CreditCard.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 *************************************************************************************************
 *                     M A I N T E N A N C E    L O G
 *************************************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  --------------------------------------------------------------------
 * Aug 17, 2009  nvittal
 * Oct 12, 2009	 dmahanth	  Added new fields to capture credit card information for apply payment
 *************************************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for credit cards accepted for agency
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class CreditCard implements ABEDto {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6846618803863935939L;

	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	
	
	
	
	/**
	 * @param last four digits of the card number to set
	 */
	public void setLastFourDigits(String lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}
	/**
	 * @return the last four digits
	 */
	public String getLastFourDigits() {
		return lastFourDigits;
	}
	
	/**
	 * @param token associated with the card to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	/**
	 * @return the expiryMonth
	 */
	public String getExpiryMonth() {
		return expiryMonth;
	}
	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	
	/**
	 * @return the expiryYear
	 */
	public String getExpiryYear() {
		return expiryYear;
	}
	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * @return the amountUSD
	 */
	public double getAmountUSD() {
		return amountUSD;
	}
	/**
	 * @param amountUSD the amountUSD to set
	 */
	public void setAmountUSD(double amountUSD) {
		this.amountUSD = amountUSD;
	}
	
	/**
	 * @return the passengerId
	 */
	public String getPassengerId() {
		return passengerId;
	}
	/**
	 * @param passengerId the passengerId to set
	 */
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	
	/**
	 * @return the CVVCode
	 */
	public String getCVVCode() {
		return CVVCode;
	}
	/**
	 * @param CVVCode the CVVCode to set
	 */
	public void setCVVCode(String CVVCode) {
		this.CVVCode = CVVCode;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the useSameCard
	 */
	public char getUseSameCard() {
		return useSameCard;
	}
	/**
	 * @param useSameCard the useSameCard to set
	 */
	public void setUseSameCard(char useSameCard) {
		this.useSameCard = useSameCard;
	}
	
	
	/**
	 * Returns the String representation of credit card object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<CreditCard>\n");
		sb.append("cardType: "+cardType+"\n");
		sb.append("name: "+name+"\n");	
		sb.append("cardNo: "+cardNo+"\n");	
		sb.append("expiryMonth: "+expiryMonth+"\n");	
		sb.append("expiryYear: "+expiryYear+"\n");	
		sb.append("amount: "+amount+"\n");	
		sb.append("lastName: "+lastName+"\n");	
		sb.append("firstName: "+firstName+"\n");	
		sb.append("street: "+street+"\n");	
		sb.append("city: "+city+"\n");	
		sb.append("state: "+state+"\n");	
		sb.append("postalCode: "+postalCode+"\n");	
		sb.append("district: "+district+"\n");	
		sb.append("countryCode: "+countryCode+"\n");	
		sb.append("telephone: "+telephone+"\n");	
		sb.append("amountUSD: "+amountUSD+"\n");	
		sb.append("passengerId: "+passengerId+"\n");	
		sb.append("CVVCode: "+CVVCode+"\n");	
		sb.append("description: "+description+"\n");	
		sb.append("useSameCard: "+useSameCard+"\n");	
		sb.append("</CreditCard>");

		return sb.toString();
	}
	
	/**
	 * Clone method implementation
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 *
	 * @see
	 * @since
	 */
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private String cardType;
	private String name;
	
	//Card Details
	private String cardNo;
	private String lastFourDigits;
	private String expiryMonth;
	private String expiryYear;
	private double amount;
	private String lastName;	//CardHolder's LastName
	

	private String firstName;	//CardHolder's FirstName
	private String paymentDate;
	private String token;//token associated with the credit card
	

	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the otherCardHolderFlag
	 */
	public char getOtherCardHolderFlag() {
		return otherCardHolderFlag;
	}
	/**
	 * @param otherCardHolderFlag the otherCardHolderFlag to set
	 */
	public void setOtherCardHolderFlag(char otherCardHolderFlag) {
		this.otherCardHolderFlag = otherCardHolderFlag;
	}

	/**
	 * @return the otherCardHolderEmail
	 */
	public String getOtherCardHolderEmail() {
		return otherCardHolderEmail;
	}
	/**
	 * @param otherCardHolderEmail the otherCardHolderEmail to set
	 */
	public void setOtherCardHolderEmail(String otherCardHolderEmail) {
		this.otherCardHolderEmail = otherCardHolderEmail;
	}

	//Address Details
	private String street;
	private String city;
	private String state;
	private String postalCode; // 10 digit 
	private String  district="";
	private String countryCode="";  // 3 digit
	private String telephone;
	private double amountUSD;
	private String passengerId;
	private String CVVCode;

	//Other Details
	private String description;
	private char useSameCard;
	private char otherCardHolderFlag;
	private String otherCardHolderEmail;
}