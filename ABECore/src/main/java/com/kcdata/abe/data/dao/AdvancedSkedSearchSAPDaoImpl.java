/*
 * AdvancedSkedSearchSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 10, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Input;
import com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Output;
import com.kcdata.abe.bapi.Yst_Air_SelectionType;
import com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType;
import com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType;
import com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List;
import com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List;
import com.kcdata.abe.business.response.AdvancedSkedSearchResponse;
import com.kcdata.abe.data.dto.Carrier;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.StopOver;
import com.kcdata.abe.data.dto.StopOverLocation;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * Class for retrieving advanced sked search options
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AdvancedSkedSearchSAPDaoImpl extends ABESAPDaoBase implements
		AdvancedSkedSearchDao {

	ABELogger logger = ABELogger.getLogger(AdvancedSkedSearchSAPDaoImpl.class);

	/**
	 * Method retrieves carrier & stop over details for a given advanced sked
	 * search options
	 * 
	 * @param searchCriteria
	 * @return advancedSkedSearchResponse
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public AdvancedSkedSearchResponse retrieveAdvancedSkedSearchOptions(
			SearchCriteria searchCriteria) {
		AdvancedSkedSearchResponse skedSearchResponse = new AdvancedSkedSearchResponse();
		if (searchCriteria == null
				|| searchCriteria.getDestinationOptions() == null) {
			// Invalid sked search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_SKED_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_SKED_SEARCH_CRITERIA", null, null));
			skedSearchResponse.saveBusinessError(businessError);
			return skedSearchResponse;
		}
		Calendar cal = Calendar.getInstance();

		Y_Bapi_Sked_Adv_Search_Details_Input bapiInput = new Y_Bapi_Sked_Adv_Search_Details_Input();
		Yst_Air_SelectionType_List lstAirSelectionCriteria = new Yst_Air_SelectionType_List();

		Iterator<DestinationOptions> itDestnOptions = searchCriteria
				.getDestinationOptions().iterator();
		Date departureDate = searchCriteria.getDepartureDate();
		String gateway = searchCriteria.getGateway();
		while (itDestnOptions.hasNext()) {
			DestinationOptions destinationOption = itDestnOptions.next();
			Yst_Air_SelectionType airSelectionTypeRow = new Yst_Air_SelectionType();
			if (departureDate != null) {
				airSelectionTypeRow.setDep_Dt(new java.sql.Date(departureDate
						.getTime()));
				if (destinationOption.getNoOfNights() > 0) {
					cal.setTime(departureDate);
					cal.add(Calendar.DATE, destinationOption.getNoOfNights());
					departureDate = cal.getTime();
				}
			}
			airSelectionTypeRow.setGateway(gateway);
			airSelectionTypeRow.setDestination(destinationOption
					.getDestination());
			airSelectionTypeRow.setNights(""
					+ destinationOption.getNoOfNights());
			// Current destination becomes gateway for next destination
			gateway = destinationOption.getDestination();
			lstAirSelectionCriteria.add(airSelectionTypeRow);
		}
		// Set selection search criteria to bapi input
		bapiInput.setIt_Select_Para(lstAirSelectionCriteria);

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Execute advanced SKED search BAPI
		Y_Bapi_Sked_Adv_Search_Details_Output bapiOutput = (Y_Bapi_Sked_Adv_Search_Details_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Sked_Adv_Search_Details", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				skedSearchResponse);

		// Return response in case of any business errors
		if (skedSearchResponse.isBusinessErrorOccurred())
			return skedSearchResponse;

		// Read Carrier data
		Yst_Bapi_Carri_InfoType_List lstFltCarrier = bapiOutput
				.get_as_listIt_Bapi_Carrinfo();
		if (lstFltCarrier != null && lstFltCarrier.size() > 0) {
			Iterator<Yst_Bapi_Carri_InfoType> itFltCarrier = lstFltCarrier
					.iterator();
			ArrayList<Carrier> lstCarrier = new ArrayList<Carrier>();
			while (itFltCarrier.hasNext()) {
				Yst_Bapi_Carri_InfoType carrierRow = itFltCarrier.next();
				Carrier carrier = new Carrier();
				carrier.setCarrierCode(carrierRow.getCarrier());
				carrier.setCarrierName(carrierRow.getCarrier_Name());
				lstCarrier.add(carrier);
			}
			// Set carrier list to response
			skedSearchResponse.setCarriers(lstCarrier);
		} else {
			// Carriers not found, prepare business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_SKED_SEARCH_CARRIERS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_SKED_SEARCH_CARRIERS_ERROR", null,
							null));
			skedSearchResponse.saveBusinessError(businessError);
		}
		// Read Stopover data
		Yst_Bapi_Stopover_InfoType_List outStopoversList = bapiOutput
				.get_as_listIt_Bapi_Stopover_Info();
		if (outStopoversList != null && outStopoversList.size() > 0) {
			Iterator<Yst_Bapi_Stopover_InfoType> itStopover = outStopoversList
					.iterator();
			ArrayList<StopOver> stopoversList = new ArrayList<StopOver>();
			while (itStopover.hasNext()) {
				Yst_Bapi_Stopover_InfoType stopoverRow = itStopover.next();
				// Stop over object
				StopOver stopover = new StopOver();
				stopover.setGateway(stopoverRow.getGateway());
				stopover.setDestination(stopoverRow.getDestination());
				// Stop over location object
				StopOverLocation stopOverLocation = new StopOverLocation();
				stopOverLocation.setStopoverCode(stopoverRow.getStopover());
				stopOverLocation.setStopoverName(stopoverRow.getDescription());
				// Prepare list of carriers for this stopover location
				ArrayList<Carrier> carrierList = new ArrayList<Carrier>();
				if (stopoverRow.getCarrier() != null) {
					String[] carrierArr = stopoverRow.getCarrier().split(",");
					for (int i = 0; i < carrierArr.length; i++) {
						Carrier carrier = new Carrier();
						carrier.setCarrierCode(carrierArr[i]);
						carrierList.add(carrier);
					}
				}
				// Set carrier list to stop over location
				stopOverLocation.setCarriers(carrierList);
				// Check if current stopover object already exists in list
				int index = stopoversList.indexOf(stopover);
				if (index != -1) {
					// Update stop over locations data for existing stopover
					// object
					StopOver stopoverObj = stopoversList.get(index);
					ArrayList<StopOverLocation> stopoverLocations = (ArrayList<StopOverLocation>) stopoverObj
							.getStopOverLocations();
					stopoverLocations.add(stopOverLocation);
					stopoverObj.setStopOverLocations(stopoverLocations);
					stopoversList.set(index, stopoverObj);
				} else {
					// Add current stopover object to list
					ArrayList<StopOverLocation> stopoverLocationList = new ArrayList<StopOverLocation>();
					stopoverLocationList.add(stopOverLocation);
					stopover.setStopOverLocations(stopoverLocationList);
					stopoversList.add(stopover);
				}
			}
			// Set stopover list to response
			skedSearchResponse.setStopovers(stopoversList);
		} else {
			// Carriers not found, prepare business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_SKED_SEARCH_STOPOVERS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_SKED_SEARCH_STOPOVERS_ERROR", null,
							null));
			skedSearchResponse.saveBusinessError(businessError);
		}
		return skedSearchResponse;
	}
}
