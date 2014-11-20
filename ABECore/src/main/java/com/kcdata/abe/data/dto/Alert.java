/*
 * Alert.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

/**
 * Transfer object to hold Alert Ids and messages
 *
 * @author dmahanth
 * @version
 *
 *
 * @see
 * @since
 */

public class Alert implements ABEDto{

	/**
	 * Field for serialization version ID
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -9002859036277905303L;
	
	/**
	 * @return the alertLineNo
	 */
	public int getAlertLineNo() {
		return alertLineNo;
	}

	/**
	 * @param alertLineNo
	 *            the alertLineNo to set
	 */
	public void setAlertLineNo(int alertLineNo) {
		this.alertLineNo = alertLineNo;
	}

	/**
	 * @return the alertLevel
	 */
	public String getAlertLevel() {
		return alertLevel;
	}
	/**
	 * @param alertLevel the alertLevel to set
	 */
	public void setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
	}
	
	/**
	 * @return the alertId
	 */
	public String getAlertId() {
		return alertId;
	}
	/**
	 * @param alertId the alertId to set
	 */
	public void setAlertId(String alertId) {
		this.alertId = alertId;
	}
	
	/**
	 * @return the alertSerialNo
	 */
	public int getAlertSerialNo() {
		return alertSerialNo;
	}

	/**
	 * @param alertSerialNo
	 *            the alertSerialNo to set
	 */
	public void setAlertSerialNo(int alertSerialNo) {
		this.alertSerialNo = alertSerialNo;
	}
	
	/**
	 * @return the alertMessage
	 */
	public String getAlertMessage() {
		return alertMessage;
	}
	/**
	 * @param alertMessage the alertMessage to set
	 */
	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	/**
	 * @return the alertType
	 */
	public String getAlertType() {
		return alertType;
	}

	/**
	 * @param alertType the alertType to set
	 */
	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	
	/**
	 * @return the text
	 */
	public String getText() {
		return text.toString();
	}

	/**
	 * @param text the text to set
	 */
	public void appendText(String string) {
		if(text.length() ==0 && alertMessage !=null){
			text.append(alertMessage);
		}
		text.append(string);
	}
	
	/**
	 * Returns the String representation of Alert object
	 *
	 * @return
	 *
	 * @see
	 * @since
	 */
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n<Alert>\n");
		sb.append("alertLineNo: "+alertLineNo+"\n");
		sb.append("alertLevel: "+alertLevel+"\n");
		sb.append("alertId: "+alertId+"\n");
		sb.append("alertSerialNo: "+alertSerialNo+"\n");
		sb.append("alertMessage: "+alertMessage+"\n");		
		sb.append("</Alert>");

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
		return this.clone();
	}

	private int alertLineNo;
	private String alertLevel;
	private String alertId;
	private int alertSerialNo;
	private String alertMessage;
	/*CQ#8775- Fields added for Edocs implementation*/
	private String alertType;
	private StringBuffer text = new StringBuffer();
}
