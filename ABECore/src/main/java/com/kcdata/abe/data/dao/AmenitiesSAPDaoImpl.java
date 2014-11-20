/*
 * AmenitiesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 16, 2009  dmahanth
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Amenity_Codes_Names_Output;
import com.kcdata.abe.bapi.Yst_Bapi_Amenity_CodesType;
import com.kcdata.abe.bapi.util.Yst_Bapi_Amenity_CodesType_List;
import com.kcdata.abe.business.response.AmenitiesResponse;
import com.kcdata.abe.data.dto.Amenity;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for amenity codes and names retrieval
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */

public class AmenitiesSAPDaoImpl extends ABESAPDaoBase implements AmenitiesDao {

	ABELogger logger = ABELogger.getLogger(AmenitiesSAPDaoImpl.class);

	/**
	 * Implementation to retrieve amenity codes and names
	 * 
	 * @return amenities response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public AmenitiesResponse retrieveAmenities() {
		AmenitiesResponse amenityResponse = new AmenitiesResponse();
		Y_Bapi_Get_Amenity_Codes_Names_Input bapiInput = new Y_Bapi_Get_Amenity_Codes_Names_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());

		// execute the BAPI
		Y_Bapi_Get_Amenity_Codes_Names_Output bapiOutput = (Y_Bapi_Get_Amenity_Codes_Names_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Get_Amenity_Codes_Names", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				amenityResponse);

		// Return response in case of any business errors
		if (amenityResponse.isBusinessErrorOccurred())
			return amenityResponse;

		// Prepare amenity list
		Yst_Bapi_Amenity_CodesType_List bpAmenityList = bapiOutput
				.get_as_listIt_Htl_Amenity();

		if (bpAmenityList != null && !bpAmenityList.isEmpty()) {
			Iterator<Yst_Bapi_Amenity_CodesType> itAmenity = bpAmenityList
					.iterator();
			ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
			while (itAmenity.hasNext()) {
				Yst_Bapi_Amenity_CodesType amentiyObj = itAmenity.next();
				// amenity list
				if (amentiyObj != null) {
					Amenity amenity = new Amenity();
					amenity.setAmenityCode(amentiyObj.getAmenity_Code());
					amenity.setAmenityName(amentiyObj.getAmenity_Name());
					amenityList.add(amenity);
				}
			} // End of amenity while
			// Set amentiy list to response
			amenityResponse.setAmenities(amenityList);
		} else {
			// Unable to retrieve amenities
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_AMENITIES_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_AMENITIES_ERROR", null, null));
			amenityResponse.saveBusinessError(businessError);
		}
		return amenityResponse;
	}
}