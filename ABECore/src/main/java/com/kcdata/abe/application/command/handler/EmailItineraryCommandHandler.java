/*
 * EmailItineraryCommandHandler.java
 * Copyright 2010 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * May 3, 2010  vgandrap
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.application.command.EmailItineraryCommand;
import com.kcdata.abe.business.response.AgencyResponse;
import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.business.service.AgencyInfoService;
import com.kcdata.abe.business.service.ItineraryService;
import com.kcdata.abe.data.dto.BookingHeader;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

public class EmailItineraryCommandHandler extends ABECommandHandlerBase {

	/**
	 * Itinerary booking service
	 */
	private ItineraryService itineraryService;

	/**
	 * @return the itineraryService
	 */
	public ItineraryService getItineraryService() {
		return itineraryService;
	}

	/**
	 * @param itineraryService
	 *            the itineraryService to set
	 */
	public void setItineraryService(ItineraryService itineraryService) {
		this.itineraryService = itineraryService;
	}

	/**
	 * Service class for the command
	 */
	private AgencyInfoService agencyInfoService;

	/**
	 * @return the agencyInfoService
	 */
	public AgencyInfoService getAgencyInfoService() {
		return agencyInfoService;
	}

	/**
	 * @param agencyInfoService
	 *            the agencyInfoService to set
	 */
	public void setAgencyInfoService(AgencyInfoService agencyInfoService) {
		this.agencyInfoService = agencyInfoService;
	}

	/**
	 * Method to handle the EmailItineraryCommand
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof EmailItineraryCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "EmailItineraryCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}

		EmailItineraryCommand emailItineraryCommand = (EmailItineraryCommand) command;
		ItineraryResponse itineraryResponse = null;
		if (EmailItineraryCommand.EMAIL_ITINERARY_COMPARISON
				.equals(emailItineraryCommand.getSubCommand())) {

			itineraryResponse = itineraryService.emailItinerary(
					emailItineraryCommand.getItineraries(),
					emailItineraryCommand.getImgByteArray(),
					emailItineraryCommand.getEmailId());

		} else {
			itineraryResponse = itineraryService.emailItinerary(
					emailItineraryCommand.getItinerary(),
					emailItineraryCommand.getEmailFormat(),
					emailItineraryCommand.getEmailId(),
					emailItineraryCommand.getMessages(),
					emailItineraryCommand.getFromEmailId());
		}
		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(emailItineraryCommand, itineraryResponse);
		emailItineraryCommand.setItinerary(itineraryResponse.getItinerary());
		emailItineraryCommand
				.setItineraries(itineraryResponse.getItineraries());
		return emailItineraryCommand;
	}

}
