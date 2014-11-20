/*
 * BreakdownChargesCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Dec 2, 2010  chazari
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.application.command.BreakdownChargesCommand;
import com.kcdata.abe.business.response.BreakdownChargesResponse;
import com.kcdata.abe.business.service.BreakdownChargesService;
import com.kcdata.abe.data.dto.GuestBreakdownCharge;
import com.kcdata.abe.data.util.XMLConvertUtils;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class BreakdownChargesCommandHandler extends ABECommandHandlerBase {

	private static final String XML_MARSHAL_EXCEPTION = "XML_MARSHAL_EXCEPTION";
	private static final String XSLT_TRANSFORMATION_EXCEPTION = "XSLT_TRANSFORMATION_EXCEPTION";
	private BreakdownChargesService breakdownChargesService;
	private XMLConvertUtils xmlConverter;

	/**
	 * @return the xmlConverter
	 */
	public XMLConvertUtils getXmlConverter() {
		return xmlConverter;
	}

	/**
	 * @param xmlConverter
	 *            the xmlConverter to set
	 */
	public void setXmlConverter(XMLConvertUtils xmlConverter) {
		this.xmlConverter = xmlConverter;
	}

	/**
	 * @return the breakdownChargesService
	 */
	public BreakdownChargesService getBreakdownChargesService() {
		return breakdownChargesService;
	}

	/**
	 * @param breakdownChargesService
	 *            the breakdownChargesService to set
	 */
	public void setBreakdownChargesService(
			BreakdownChargesService breakdownChargesService) {
		this.breakdownChargesService = breakdownChargesService;
	}

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof BreakdownChargesCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "BreakdownChargesCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		BreakdownChargesCommand breakdownChargesCommand = (BreakdownChargesCommand) command;
		BreakdownChargesResponse breakdownChargesResponse = breakdownChargesService
				.retrievePriceBreakdown(breakdownChargesCommand.getBookingNo());
		// for display purpose
		processGuestBreakDownCharges(breakdownChargesResponse);
		breakdownChargesResponse.setGuests(breakdownChargesCommand.getGuests());
		breakdownChargesResponse.setBookingHeader(breakdownChargesCommand
				.getBookingHeader());
		breakdownChargesResponse.setApplicationInfo(breakdownChargesCommand.getApplicationInfo());		
		generateDisplayHTML(breakdownChargesCommand, breakdownChargesResponse);

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(breakdownChargesCommand, breakdownChargesResponse);
		return breakdownChargesCommand;
	}
	
	/**
	 * 
	 * Medhod generates the HTML string for display parsing the XSLT
	 *
	 * @param breakdownChargesCommand
	 * @param breakdownChargesResponse
	 * @return
	 *
	 * @see
	 * @since
	 */
	private BreakdownChargesCommand generateDisplayHTML(
			BreakdownChargesCommand breakdownChargesCommand,
			BreakdownChargesResponse breakdownChargesResponse) {
		try {
			String strXML = xmlConverter.marshal(breakdownChargesResponse);
			String strHTML = xmlConverter.transformBreakdownChargesXML(strXML);
			breakdownChargesCommand.setBreakdownchargesHTML(strHTML);
		} catch (Exception e) {
			String debugMessage = "";
			if (XML_MARSHAL_EXCEPTION.equalsIgnoreCase(e.getMessage())) {
				debugMessage = "Break Down Charges: Error converting BreakdownChargesResponse object to XML";
			}
			if (XSLT_TRANSFORMATION_EXCEPTION.equalsIgnoreCase(e.getMessage())) {
				debugMessage = "Break Down Charges: Error Transforming XSLT-HTML";
			} else {
				debugMessage = "Break Down Charges: Error Displaying BreakdownCharges";
			}
			ABESystemError systemError = new ABESystemError("101", e
					.getMessage(), debugMessage);
			breakdownChargesCommand.addSystemError(systemError);
		}
		return breakdownChargesCommand;
	}
	
	/**
	 * 
	 * Method manipulates the response object for display purpose
	 * Ideal to manage this in XSLT template instead.
	 * @param breakdownChargesResponse
	 * @return
	 *
	 * @see
	 * @since
	 */
	private BreakdownChargesResponse processGuestBreakDownCharges(
			BreakdownChargesResponse breakdownChargesResponse) {

		List<GuestBreakdownCharge> guestBreakdownCharges = breakdownChargesResponse
				.getBreakdownCharges();
		Iterator<GuestBreakdownCharge> itrGuestBreakdownCharge = guestBreakdownCharges
				.iterator();
		String prevPaxIdStr = "";
		while (itrGuestBreakdownCharge.hasNext()) {
			GuestBreakdownCharge guestBreakdownCharge = itrGuestBreakdownCharge
					.next();
			if (!prevPaxIdStr.equalsIgnoreCase(guestBreakdownCharge.getPaxId())) {
				prevPaxIdStr = guestBreakdownCharge.getPaxId();
			} else {
				guestBreakdownCharge.setPaxId("");
				guestBreakdownCharge.setFirstName("");
				guestBreakdownCharge.setLastName("");
			}
		}
		breakdownChargesResponse.setBreakdownCharges(guestBreakdownCharges);
		return breakdownChargesResponse;
	}
}
