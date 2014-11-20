/*
 * Agent.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 17, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Value object for holding agent details
 *
 * @author nvittal
 * @version
 *
 * @see
 * @since
 */
public class Agent implements ABEDto {

	/**
	 * Default serial UID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -8262123793473100400L;

	/**
	 * @return the agentNo
	 */
	public String getAgentNo() {
		return agentNo;
	}
	/**
	 * @param agentNo the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the royaltyNo
	 */
	public String getRoyaltyNo() {
		return royaltyNo;
	}
	/**
	 * @param royaltyNo the royaltyNo to set
	 */
	public void setRoyaltyNo(String royaltyNo) {
		this.royaltyNo = royaltyNo;
	}

	/**
	 * @return the print
	 */
	public String getPrint() {
		return print;
	}
	/**
	 * @param print the print to set
	 */
	public void setPrint(String print) {
		this.print = print;
	}
	/**
	 * @return the faxInput
	 */
	public String getFaxInput() {
		return faxInput;
	}
	/**
	 * @param faxInput the faxInput to set
	 */
	public void setFaxInput(String faxInput) {
		this.faxInput = faxInput;
	}
	
	/**
	 * Returns the String representation of agent object
	 * 
	 * @return
	 * 
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Agent>\n");
		sb.append("agentNo: "+agentNo+"\n");
		sb.append("firstName: "+firstName+"\n");		
		sb.append("lastName: "+lastName+"\n");
		sb.append("fullName: "+fullName+"\n");
		sb.append("emailId: "+emailId+"\n");
		sb.append("royaltyNo: "+royaltyNo+"\n");
		sb.append("faxInput: "+faxInput+"\n");
		sb.append("print: "+print+"\n");
		sb.append("</Agent>");

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
	
	private String agentNo;
	private String firstName;
	private String lastName;
	private String fullName;
	private String emailId;
	private String royaltyNo;
	
	//Added for edocs
	private String print;
	private String faxInput;
}