/*
 * AlertsSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 21, 2009  dmahanth
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType;
import com.kcdata.abe.bapi.Zsalert2Type;
import com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List;
import com.kcdata.abe.bapi.util.Zsalert2Type_List;
import com.kcdata.abe.business.response.AlertsResponse;
import com.kcdata.abe.data.dto.Alert;
import com.kcdata.abe.data.dto.AlertCriteria;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for Alerts retrieval
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AlertsSAPDaoImpl extends ABESAPDaoBase implements AlertsDao {

	ABELogger logger = ABELogger.getLogger(AlertsSAPDaoImpl.class);

	/**
	 * Implementation to retrieve Alert Ids and Messages
	 * 
	 * @return alerts response
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlertsOrAdvisory(
			ArrayList<AlertCriteria> alertCriteriaList, boolean advisory) {

		AlertsResponse alertResponse = new AlertsResponse();

		if (alertCriteriaList == null || alertCriteriaList.isEmpty()) {

			// Empty alert criteria list, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_ALERTS_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_ALERTS_CRITERIA", null, null));
			alertResponse.saveBusinessError(businessError);
			return alertResponse;
		}

		Y_Bapi_Get_Alerts_Input bapiInput = new Y_Bapi_Get_Alerts_Input();
		Yst_Bapi_Prd_AlertsType_List lstAlertSelectionCriteria = new Yst_Bapi_Prd_AlertsType_List();
		if (alertCriteriaList != null && alertCriteriaList.size() > 0) {
			for (AlertCriteria alertCriteria : alertCriteriaList) {
				if(alertCriteria != null) {
					Yst_Bapi_Prd_AlertsType ystAlertsType = new Yst_Bapi_Prd_AlertsType();
					ystAlertsType.setGateway(alertCriteria.getGateway());
					ystAlertsType.setDestination(alertCriteria.getDestination());
					if (alertCriteria.getBookingDate() != null) {
						ystAlertsType.setBookingdate(new java.sql.Date(
								alertCriteria.getBookingDate().getTime()));
					}
					if (alertCriteria.getTravelDate() != null) {
						ystAlertsType.setTraveldate(new java.sql.Date(alertCriteria
								.getTravelDate().getTime()));
					}
					ystAlertsType.setDuration(Integer.toString(alertCriteria
							.getDuration()));
					ystAlertsType.setMaterial(alertCriteria.getMaterial());

					lstAlertSelectionCriteria.add(ystAlertsType);
				}
			}
			bapiInput.setIt_Inputinfo(lstAlertSelectionCriteria);
		}

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// execute the BAPI
		Y_Bapi_Get_Alerts_Output bapiOutput = (Y_Bapi_Get_Alerts_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Get_Alerts",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), alertResponse);

		// Process alerts/Advisory
		alertResponse.setAlertList(this.processAlertsOrAdvisory(bapiOutput,
				advisory));

		return alertResponse;
	}

	/**
	 * Implementation to retrieve Alert Ids and Messages
	 * 
	 * @return alerts response
	 * 
	 * @see
	 * @since
	 */
	public AlertsResponse retrieveAlerts(String bookingNumber) {

		AlertsResponse alertResponse = new AlertsResponse();

		if (bookingNumber == null || "".equals(bookingNumber)) {

			// Empty alert criteria list, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_ALERTS_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_ALERTS_CRITERIA", null, null));
			alertResponse.saveBusinessError(businessError);
			return alertResponse;
		}

		Y_Bapi_Get_Alerts_Input bapiInput = new Y_Bapi_Get_Alerts_Input();
		bapiInput.setIm_Reservation_No(bookingNumber);

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// execute the BAPI
		Y_Bapi_Get_Alerts_Output bapiOutput = (Y_Bapi_Get_Alerts_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Get_Alerts",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), alertResponse);

		// Process alerts/Advisory
		alertResponse.setAlertList(this.processAlertsOrAdvisory(bapiOutput,
				false));

		return alertResponse;
	}

	/**
	 * Method to process the Alerts/Advisory
	 * 
	 * @param bapiOutput
	 * @param advisory
	 * @return
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings( { "unchecked" })
	private List<Alert> processAlertsOrAdvisory(
			Y_Bapi_Get_Alerts_Output bapiOutput, boolean advisory) {
		// Prepare alerts list
		Zsalert2Type_List bpAlertsList = null;
		if (advisory) {
			bpAlertsList = bapiOutput.get_as_listIt_Agent_Advisory();
		} else {
			bpAlertsList = bapiOutput.get_as_listIt_Alerts();
		}
		if (bpAlertsList != null && !bpAlertsList.isEmpty()) {
			Iterator<Zsalert2Type> itAlert = bpAlertsList.iterator();
			ArrayList<Alert> alertsList = new ArrayList<Alert>();
			while (itAlert.hasNext()) {
				Zsalert2Type alertObj = itAlert.next();
				// Alerts list
				if (alertObj != null) {
					Alert alert = new Alert();
					alert.setAlertLineNo(Integer.parseInt(alertObj.getZzno()));
					alert.setAlertLevel(alertObj.getZzalevel());
					alert.setAlertId(alertObj.getZzalertid());
					alert.setAlertSerialNo(Integer.parseInt(alertObj
							.getZzserialno()));
					alert.setAlertMessage(alertObj.getZzcoments());
					alertsList.add(alert);
				}
			} // End of alert while
			// Set alerts list to response
			return alertsList;
		} else {
			return null;
		}
	}
}
