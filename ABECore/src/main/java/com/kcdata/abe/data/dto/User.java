/*
 * User.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 18, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Class for storing user details
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class User implements ABEDto {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -4807259492649444545L;

	public User() {
		this.userGroup = new UserGroup();
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordHint
	 */
	public String getPasswordHint() {
		return passwordHint;
	}

	/**
	 * @param passwordHint
	 *            the passwordHint to set
	 */
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	/**
	 * @return the passwordHintAnswer
	 */
	public String getPasswordHintAnswer() {
		return passwordHintAnswer;
	}

	/**
	 * @param passwordHintAnswer
	 *            the passwordHintAnswer to set
	 */
	public void setPasswordHintAnswer(String passwordHintAnswer) {
		this.passwordHintAnswer = passwordHintAnswer;
	}

	/**
	 * @return the sapId
	 */
	public String getSapId() {
		return sapId;
	}

	/**
	 * @param sapId
	 *            the sapId to set
	 */
	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	/**
	 * @return the iataNumber
	 */
	public String getIataNumber() {
		return iataNumber;
	}

	/**
	 * @param iataNumber
	 *            the iataNumber to set
	 */
	public void setIataNumber(String iataNumber) {
		this.iataNumber = iataNumber;
	}

	/**
	 * @return the userGroup
	 */
	public UserGroup getUserGroup() {
		return userGroup;
	}

	/**
	 * @param userGroup
	 *            the userGroup to set
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
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
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the allowABEAccess
	 */
	public String getAllowABEAccess() {
		return allowABEAccess;
	}

	/**
	 * @param allowABEAccess the allowABEAccess to set
	 */
	public void setAllowABEAccess(String allowABEAccess) {
		this.allowABEAccess = allowABEAccess;
	}

	/**
	 * String representation of User class
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<User>\n");
		sb.append("firstName: " + firstName + "\n");
		sb.append("middleName: " + middleName + "\n");
		sb.append("lastName: " + lastName + "\n");
		sb.append("loginId: " + loginId + "\n");
		sb.append("passwordHint: " + passwordHint + "\n");
		sb.append("passwordHintAnswer: " + passwordHintAnswer + "\n");
		sb.append("emailId: " + emailId + "\n");
		sb.append("sapId: " + sapId + "\n");
		sb.append("iataNumber: " + iataNumber + "\n");
		sb.append("organization: " + organization + "\n");
		sb.append("userGroup: " + userGroup.toString() + "\n");
		sb.append("userType: " + userType.toString() + "\n");
		sb.append("allowABEAccess: " + allowABEAccess.toString() + "\n");
		sb.append("</User>");

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

	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String loginId;
	private String password;
	private String newPassword;
	private String passwordHint;
	private String passwordHintAnswer;
	private String emailId;
	private String sapId;
	private String iataNumber;
	private String organization;
	private UserGroup userGroup;
	private UserType userType;
	private String allowABEAccess;
}
