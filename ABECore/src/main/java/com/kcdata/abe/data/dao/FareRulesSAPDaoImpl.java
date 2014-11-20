/*
 * FareRulesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Aug 14, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Input;
import com.kcdata.abe.bapi.Y_Bapi_Flt_Farerules_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Farerules_HdrType;
import com.kcdata.abe.bapi.Yst_FarerulesType;
import com.kcdata.abe.bapi.util.Yst_FarerulesType_List;
import com.kcdata.abe.business.response.FareRulesResponse;
import com.kcdata.abe.data.dto.FareRule;
import com.kcdata.abe.data.dto.FlightRequestType;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.util.FlightConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for fare rules retrieval
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class FareRulesSAPDaoImpl extends ABESAPDaoBase implements FareRulesDao {

	ABELogger logger = ABELogger.getLogger(FareRulesSAPDaoImpl.class);

	/**
	 * Implementation to retrieve fare rules
	 * 
	 * @return fare rules response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public FareRulesResponse retrieveFareRules(TripFlight tripFlight,
			boolean fetchAdditionalRules) {

		FareRulesResponse fareRulesResponse = new FareRulesResponse();

		Y_Bapi_Flt_Farerules_Input bapiInput = new Y_Bapi_Flt_Farerules_Input();

		// Prepare and set fare rules header structure
		Yst_Bapi_Farerules_HdrType fareRulesHeader = new Yst_Bapi_Farerules_HdrType();
		if (!fetchAdditionalRules)
			fareRulesHeader.setFlight_Req_Type(""
					+ FlightRequestType.SCHEDULED.getType());
		fareRulesHeader.setGateway_Locid(tripFlight.getOutboundFlight()
				.getGateway());
		fareRulesHeader.setDest_Locid(tripFlight.getOutboundFlight()
				.getDestination());
		bapiInput.setIm_St_Farerules_Hdr(fareRulesHeader);

		byte flightItemRph = 1;

		// Prepare and set gateway, destination & flight type
		bapiInput.setIm_St_Ota_Flt_Orig_Dest(FlightConvertUtils
				.prepareFltOrigDestType(tripFlight, flightItemRph));

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare & set flight segment details
		bapiInput.setIt_Ota_Flt_Segments(FlightConvertUtils
				.prepareFltSegmentsTypeList(tripFlight, flightItemRph));

		// execute the BAPI
		Y_Bapi_Flt_Farerules_Output bapiOutput = (Y_Bapi_Flt_Farerules_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Flt_Farerules",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				fareRulesResponse);

		// Return response in case of any business errors
		if (fareRulesResponse.isBusinessErrorOccurred())
			return fareRulesResponse;

		// Prepare fare rules list
		Yst_FarerulesType_List bpFarerulesList = bapiOutput
				.get_as_listIt_Farerules();

		if (bpFarerulesList != null && !bpFarerulesList.isEmpty()) {
			Iterator<Yst_FarerulesType> itFareRules = bpFarerulesList
					.iterator();
			ArrayList<FareRule> fareRulesList = new ArrayList<FareRule>();
			while (itFareRules.hasNext()) {
				Yst_FarerulesType fareRulesRow = itFareRules.next();
				FareRule fareRule = new FareRule();
				fareRule.setGateway(fareRulesRow.getDep_Locid());
				fareRule.setDestination(fareRulesRow.getArr_Locid());
				fareRule.setFareRuleText(fareRulesRow.getText());
				fareRulesList.add(fareRule);
			} // End of gateway while

			// Set fare rules to response
			fareRulesResponse.setFareRules(fareRulesList);
		}
		return fareRulesResponse;
	}
}