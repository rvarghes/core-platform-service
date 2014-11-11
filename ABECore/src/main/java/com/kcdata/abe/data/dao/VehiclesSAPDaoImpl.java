/*
 * VehiclesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Sep 14, 2009  nvittal
 * Sep 22, 2009	 hguntupa	  Refactored the code and added new methods for Packages
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.bapi.Y_Ota_Vehicle_Availability_Input;
import com.kcdata.abe.bapi.Y_Ota_Vehicle_Availability_Output;
import com.kcdata.abe.business.request.VehiclesRequest;
import com.kcdata.abe.business.response.VehiclesResponse;
import com.kcdata.abe.data.util.VehicleConvertUtils;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for vehicles availability
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
public class VehiclesSAPDaoImpl extends ABESAPDaoBase implements VehiclesDao {

	ABELogger logger = ABELogger.getLogger(VehiclesSAPDaoImpl.class);

	/**
	 * Method for retrieving vehicle availability
	 * 
	 * @param vehiclesRequest
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public VehiclesResponse retrieveVehicles(VehiclesRequest vehiclesRequest) {
		VehiclesResponse vehiclesResponse = new VehiclesResponse();

		if (vehiclesRequest == null
				|| vehiclesRequest.getVehicleOptions() == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_VEHICLE_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_VEHICLE_SEARCH_CRITERIA", null, null));
			vehiclesResponse.saveBusinessError(businessError);
			return vehiclesResponse;
		}

		Y_Ota_Vehicle_Availability_Input bapiInput = new Y_Ota_Vehicle_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare and set header
		bapiInput.setIm_Req_Hdr(this.prepareHeader(vehiclesRequest));

		bapiInput.setIt_Veh_Req(VehicleConvertUtils
				.constructVehicleRequestList(vehiclesRequest));

		// Execute vehicle availability BAPI
		Y_Ota_Vehicle_Availability_Output bapiOutput = (Y_Ota_Vehicle_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Vehicle_Availability", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				vehiclesResponse);

		if (vehiclesResponse.isBusinessErrorOccurred())
			return vehiclesResponse;

		// Parse vehicle availability response
		vehiclesResponse.setVehicles(VehicleConvertUtils
				.parseVehicleResponse(bapiOutput.get_as_listIt_Veh_Availability(), vehiclesRequest));
		
		// Parse vehicle vendor details
		vehiclesResponse.setVendorDetails(VehicleConvertUtils
				.parseVehicleVendorDetails(bapiOutput.get_as_listIt_Veh_Info(), bapiOutput.get_as_listIt_Veh_Type()));

		return vehiclesResponse;
	}

	/**
	 * Method to retrieve vehicles for Packages
	 * 
	 * @param vehiclesRequest
	 *            Vehicles Request
	 * @return Vehicles response
	 * 
	 * @see
	 * @since
	 */
	public VehiclesResponse retrieveVehiclesForPackages(
			VehiclesRequest vehiclesRequest) {
		VehiclesResponse vehiclesResponse = new VehiclesResponse();
		if (vehiclesRequest == null
				|| vehiclesRequest.getVehicleOptions() == null) {
			// Invalid search options, return to presentation with error
			// message
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("INVALID_VEHICLE_SEARCH_CRITERIA");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("INVALID_VEHICLE_SEARCH_CRITERIA", null, null));
			vehiclesResponse.saveBusinessError(businessError);
			return vehiclesResponse;
		}

		Y_Ota_Vehicle_Availability_Input bapiInput = new Y_Ota_Vehicle_Availability_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// Prepare and set header
		bapiInput.setIm_Req_Hdr(this.prepareHeader(vehiclesRequest));

		bapiInput.setIt_Veh_Req(VehicleConvertUtils
				.constructVehicleRequestList(vehiclesRequest));

		// Execute vehicle availability BAPI
		Y_Ota_Vehicle_Availability_Output bapiOutput = (Y_Ota_Vehicle_Availability_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Ota_Vehicle_Availability", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				vehiclesResponse);

		if (vehiclesResponse.isBusinessErrorOccurred())
			return vehiclesResponse;

		// Set the vehicles response structure to response
		vehiclesResponse.setSapVehicleAvailabilityList(bapiOutput
				.get_as_listIt_Veh_Availability());

		return vehiclesResponse;
	}
}