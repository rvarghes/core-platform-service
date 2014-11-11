/*
 * RetrieveAlertsCommandHandler.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 24, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command.handler;

import com.kcdata.abe.application.command.RetrieveAlertsCommand;
import com.kcdata.abe.business.response.AlertsResponse;
import com.kcdata.abe.business.service.AlertsService;
import com.kcdata.abe.framework.command.ABECommand;
import com.kcdata.abe.framework.command.handler.ABECommandHandlerBase;
import com.kcdata.abe.framework.env.ABETier;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;

/**
 * Command handler class for alerts
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class RetrieveAlertsCommandHandler extends ABECommandHandlerBase {

	/**
	 * Service class for the command
	 */
	private AlertsService alertsService;

	/**
	 * @return the alertsService
	 */
	public AlertsService getAlertsService() {
		return alertsService;
	}

	/**
	 * @param alertsService
	 *            the alertsService to set
	 */
	public void setAlertsService(AlertsService alertsService) {
		this.alertsService = alertsService;
	}

	/**
	 * Base class implementation method
	 * 
	 * @param command
	 * @return
	 * 
	 * @see
	 * @since
	 */

	public ABECommand handle(ABECommand command) {
		if (!(command instanceof RetrieveAlertsCommand)) {
			String message = this.getMessageSource().getMessage(
					"ILLEAGAL_COMMAND_ERROR",
					new Object[] { "RetrieveAlertsCommand",
							command.getClass().getName() }, null);
			ABESystemError systemError = new ABESystemError(
					"ILLEAGAL_COMMAND_ERROR", message);
			throw new ABESystemException(systemError, ABETier.APPLICATION,
					new IllegalArgumentException(message));
		}
		RetrieveAlertsCommand retrieveAlertsCommand = (RetrieveAlertsCommand) command;
		AlertsResponse alertsResponse = null;
		if (retrieveAlertsCommand.getBookingNumber() != null
				&& !"".equals(retrieveAlertsCommand.getBookingNumber())) {
			alertsResponse = alertsService.retrieveAlerts(retrieveAlertsCommand
					.getBookingNumber());
		} else {
			alertsResponse = alertsService.retrieveAlertsOrAdvisory(
				retrieveAlertsCommand.getAlertCriteriaList(),
				retrieveAlertsCommand.isAdvisory());
		}

		// Process response and set the business errors, warnings, and info
		// messages to command
		this.processResponse(retrieveAlertsCommand, alertsResponse);
		retrieveAlertsCommand.setAlerts(alertsResponse.getAlertList());
		return retrieveAlertsCommand;
	}

}
