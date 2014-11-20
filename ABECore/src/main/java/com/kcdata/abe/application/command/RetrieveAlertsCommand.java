/*
 * RetrieveAlertsCommand.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 24, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.application.command;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.framework.command.ABECommandBase;

/**
 * Alerts command class
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class RetrieveAlertsCommand extends ABECommandBase {

	/**
	 * Default serialization version Id
	 * 
	 * @see
	 * @since
	 */
	private static final long serialVersionUID = -1415878217128003518L;

	/**
	 * Name of the command handler, which handles this command
	 */
	private static final String COMMAND_HANDLER_NAME = "retrieveAlertsCommandHandler";

	/**
	 * Returns command handler class name
	 * 
	 * @return Command Handler string
	 * 
	 * @see
	 * @since
	 */

	public String getCommandHandlerName() {
		return COMMAND_HANDLER_NAME;
	}

	/**
	 * Field to hold list of AlertCriteria
	 */
	private ArrayList<AlertCriteria> alertCriteriaList;

	/**
	 * Field to hold list of alerts
	 */
	private List<Alert> alerts;

	/**
	 * Field to determine whether to read alerts or advisory
	 */
	private boolean advisory;

	/**
	 * Field to retrieve Alerts based on booking number
	 */
	private String bookingNumber;

	/**
	 * @return the alertCriteriaList
	 */
	public ArrayList<AlertCriteria> getAlertCriteriaList() {
		return alertCriteriaList;
	}

	/**
	 * @param alertCriteriaList
	 *            the alertCriteriaList to set
	 */
	public void setAlertCriteriaList(ArrayList<AlertCriteria> alertCriteriaList) {
		this.alertCriteriaList = alertCriteriaList;
	}

	/**
	 * @return the alerts
	 */
	public List<Alert> getAlerts() {
		return alerts;
	}

	/**
	 * @param alerts
	 *            the alerts to set
	 */
	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	/**
	 * @return the advisory
	 */
	public boolean isAdvisory() {
		return advisory;
	}

	/**
	 * @param advisory
	 *            the advisory to set
	 */
	public void setAdvisory(boolean advisory) {
		this.advisory = advisory;
	}

	/**
	 * @return the bookingNumber
	 */
	public String getBookingNumber() {
		return bookingNumber;
	}

	/**
	 * @param bookingNumber
	 *            the bookingNumber to set
	 */
	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

}
