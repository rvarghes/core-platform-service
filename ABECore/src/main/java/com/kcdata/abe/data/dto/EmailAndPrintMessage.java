/*
 * EmailAndPrintMessage.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 24, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.data.dto;

import com.kcdata.abe.framework.dto.ABEDto;

public class EmailAndPrintMessage implements ABEDto{

	/**
	 * Auto generated serial id
	 *
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -7509904937988233620L;
	
	private String openingMessage;
	/**
	 * @return the openingMessage
	 */
	public String getOpeningMessage() {
		return openingMessage;
	}
	/**
	 * @param openingMessage the openingMessage to set
	 */
	public void setOpeningMessage(String openingMessage) {
		this.openingMessage = openingMessage;
	}
	/**
	 * @return the closingMessage
	 */
	public String getClosingMessage() {
		return closingMessage;
	}
	/**
	 * @param closingMessage the closingMessage to set
	 */
	public void setClosingMessage(String closingMessage) {
		this.closingMessage = closingMessage;
	}
	/**
	 * @return the openingMessageText
	 */
	public String getOpeningMessageText() {
		return openingMessageText;
	}
	/**
	 * @param openingMessageText the openingMessageText to set
	 */
	public void setOpeningMessageText(String openingMessageText) {
		this.openingMessageText = openingMessageText;
	}
	private String closingMessage;
	private String openingMessageText;

}
