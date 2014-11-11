/*
 * OpsAlertActionCodesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 7, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output;
import com.kcdata.abe.bapi.Zact_TypType;
import com.kcdata.abe.bapi.Zalert_TypType;
import com.kcdata.abe.bapi.util.Zact_TypType_List;
import com.kcdata.abe.bapi.util.Zalert_TypType_List;
import com.kcdata.abe.business.response.OpsAlertResponse;
import com.kcdata.abe.data.dto.ActionType;
import com.kcdata.abe.data.dto.AlertType;
import com.kcdata.abe.data.dto.OpsAlert;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;

/**
 * Ops Alerts and Actions Codes DAO implementation class
 * 
 * @author dmahanth
 * @version
 * 
 * @see
 * @since
 */
public class OpsAlertActionCodesSAPDaoImpl extends ABESAPDaoBase implements
		OpsAlertActionCodesDao {

	/**
	 * Method to get the available ops alert and action codes
	 * 
	 * @param itinerary
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public OpsAlertResponse retrieveOpsAlertActionCodes() {

		OpsAlertResponse opsAlertResponse = new OpsAlertResponse();

		// Create Input for BAPI
		Y_Bapi_Get_Ops_Alert_Codes_Input bapiInput = new Y_Bapi_Get_Ops_Alert_Codes_Input();

		// Execute the BAPI
		Y_Bapi_Get_Ops_Alert_Codes_Output bapiOutput = (Y_Bapi_Get_Ops_Alert_Codes_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Get_Ops_Alert_Codes", bapiInput);
		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.getEx_St_Return(),
				opsAlertResponse);
		// Check for any business errors from BAPI
		if (opsAlertResponse.isBusinessErrorOccurred()) {
			return opsAlertResponse;
		}

		// creating Ops Alert Object
		OpsAlert opsAlert = new OpsAlert();

		// Prepare alert codes
		Zalert_TypType_List alertTypeCodesList = bapiOutput
				.get_as_listIt_Alert_Types();

		// Prepare action codes
		Zact_TypType_List actionTypeCodesList = bapiOutput
				.get_as_listIt_Action_Types();

		if (alertTypeCodesList != null && !alertTypeCodesList.isEmpty()) {
			setAlertActionTypeCodes(alertTypeCodesList, actionTypeCodesList,
					opsAlert);

			// Set insurance options to response
			opsAlertResponse.setOpsAlert(opsAlert);
		} else {
			// Unable to retrieve resort area information
			ABEBusinessError businessError = new ABEBusinessError();
			businessError
					.setErrorCode("RETRIEVE_OPS_ALERTS_ACTIONS_CODES_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_OPS_ALERTS_ACTIONS_CODES_ERROR",
							null, null));
			opsAlertResponse.saveBusinessError(businessError);
		}

		return opsAlertResponse;
	}

	/**
	 * Method to set the the alerty and action type codes from BAPI output
	 * 
	 * @param Y_Bapi_Get_Ops_Alert_Codes_Output
	 *            bapiOutput, OpsAlert opsAlert
	 * @return void
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	private void setAlertActionTypeCodes(
			Zalert_TypType_List alertTypeCodesList,
			Zact_TypType_List actionTypeCodesList, OpsAlert opsAlert) {

		Iterator<Zalert_TypType> itAlertTypeCodes = alertTypeCodesList
				.iterator();
		ArrayList<AlertType> alertTypeCodes = new ArrayList<AlertType>();
		while (itAlertTypeCodes.hasNext()) {
			Zalert_TypType alertTypeRow = itAlertTypeCodes.next();
			if (alertTypeRow != null) {
				AlertType alertType = new AlertType();
				alertType.setAlertCode(alertTypeRow.getZzalert_Code());
				alertType.setActionCode(alertTypeRow.getZzact_Code());
				alertType.setDescription(alertTypeRow.getZzalert_Desc());
				alertTypeCodes.add(alertType);
			}
		} // End of alert type codes list
		opsAlert.setAlertTypes(alertTypeCodes);

		if (actionTypeCodesList != null && !actionTypeCodesList.isEmpty()) {
			Iterator<Zact_TypType> itActionTypeCodes = actionTypeCodesList
					.iterator();
			ArrayList<ActionType> actionTypeCodes = new ArrayList<ActionType>();
			while (itActionTypeCodes.hasNext()) {
				Zact_TypType actionTypeRow = itActionTypeCodes.next();
				if (actionTypeRow != null) {
					ActionType actionType = new ActionType();
					actionType.setActionCode(actionTypeRow.getZzact_Code());
					actionType.setDescription(actionTypeRow.getZzact_Desc());
					actionTypeCodes.add(actionType);
				}
			} // End of action type codes list
			opsAlert.setActionTypes(actionTypeCodes);
		}
	}

}
