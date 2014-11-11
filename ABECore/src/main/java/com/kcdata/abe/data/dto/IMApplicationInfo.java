/*
 * IMApplicationInfo.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * This transfer object has to be sent in every BAPI call to reduce
 * authentication process and agent information retrieve calls
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class IMApplicationInfo implements ABEDto {

	/**
	 * Field for serialization version ID
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = 6656731320641862323L;

	/**
	 * @return the requestorID
	 */
	public String getRequestorID() {
		return requestorID;
	}

	/**
	 * @param requestorID
	 *            the requestorID to set
	 */
	public void setRequestorID(String requestorID) {
		this.requestorID = requestorID;
	}

	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * @return the contextID
	 */
	public String getContextID() {
		return contextID;
	}

	/**
	 * @param contextID
	 *            the contextID to set
	 */
	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the agentNumber
	 */
	public String getAgentNumber() {
		return agentNumber;
	}

	/**
	 * @param agentNumber
	 *            the agentNumber to set
	 */
	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	/**
	 * @return the pseudoCityCode
	 */
	public String getPseudoCityCode() {
		return pseudoCityCode;
	}

	/**
	 * @param pseudoCityCode
	 *            the pseudoCityCode to set
	 */
	public void setPseudoCityCode(String pseudoCityCode) {
		this.pseudoCityCode = pseudoCityCode;
	}

	/**
	 * @return the isoCountry
	 */
	public String getIsoCountry() {
		return isoCountry;
	}

	/**
	 * @param isoCountry
	 *            the isoCountry to set
	 */
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

	/**
	 * @return the isoCurrency
	 */
	public String getIsoCurrency() {
		return isoCurrency;
	}

	/**
	 * @param isoCurrency
	 *            the isoCurrency to set
	 */
	public void setIsoCurrency(String isoCurrency) {
		this.isoCurrency = isoCurrency;
	}

	/**
	 * @return the selectedAgent
	 */
	public Agent getSelectedAgent() {
		return selectedAgent;
	}

	/**
	 * @param selectedAgent
	 *            the selectedAgent to set
	 */
	public void setSelectedAgent(Agent selectedAgent) {
		this.selectedAgent = selectedAgent;
	}

	/**
	 * @return the salesOrg
	 */
	public String getSalesOrg() {
		return salesOrg;
	}

	/**
	 * @param salesOrg
	 *            the salesOrg to set
	 */
	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	/**
	 * Method to return String form of IMApplicationInfo
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("## IMApplicationContext DUMP ##");
		sb.append("\n[REQUESTOR ID: ");
		sb.append(requestorID);
		sb.append("]\n[REQUESTOR TYPE: ");
		sb.append(type);
		sb.append("]\n[REQUESTOR CONTEXT ID: ");
		sb.append(contextID);
		sb.append("]\n[CREATED BY: ");
		sb.append(createdBy);
		sb.append("]\n[AGENT NUMBER: ");
		sb.append(agentNumber);
		sb.append("]\n[SELECTED AGENT: ");
		sb.append(selectedAgent);
		sb.append("]\n[SALES ORGANIZATION: ");
		sb.append(salesOrg);
		sb.append("]\n");
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
		IMApplicationInfo applicationInfo = (IMApplicationInfo) super.clone();
		if (selectedAgent != null) {
			applicationInfo.setSelectedAgent((Agent) selectedAgent.clone());
		}
		return applicationInfo;
	}

	/**
	 * @return the agentFirstName
	 */
	public String getAgentFirstName() {
		return agentFirstName;
	}

	/**
	 * @param agentFirstName the agentFirstName to set
	 */
	public void setAgentFirstName(String agentFirstName) {
		this.agentFirstName = agentFirstName;
	}

	/**
	 * @return the agentLastName
	 */
	public String getAgentLastName() {
		return agentLastName;
	}

	/**
	 * @param agentLastName the agentLastName to set
	 */
	public void setAgentLastName(String agentLastName) {
		this.agentLastName = agentLastName;
	}

	// IATA # / Customer #
	private String requestorID;
	private UserType type;
	// Calling application ID; “RS1” , “TA1” , “CBE” or “ABE”
	private String contextID;
	// ID of logged in user
	private String createdBy;
	// Contact person # at customer
	private String agentNumber;
	private String pseudoCityCode;
	private String isoCountry;
	private String isoCurrency;
	private Agent selectedAgent;
	private String salesOrg;
	private String agentFirstName;
	private String agentLastName;

}
