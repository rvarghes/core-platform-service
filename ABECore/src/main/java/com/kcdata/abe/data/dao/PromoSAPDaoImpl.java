/*
 * PromoSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Oct 21, 2009  hguntupa
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Input;
import com.kcdata.abe.bapi.Y_Bapi_Validate_Promo_Code_Output;
import com.kcdata.abe.business.response.ValidatePromoResponse;
import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;

/**
 * Dao implementation class for Promo Codes
 * 
 * @author hguntupa
 * @version
 * 
 * 
 * @see
 * @since
 */
public class PromoSAPDaoImpl extends ABESAPDaoBase implements PromoDao {

	/**
	 * Method to validate the promo code
	 * 
	 * @param criteria
	 * @return
	 * 
	 * @see
	 * @since
	 */
	public ValidatePromoResponse validatePromo(SearchCriteria searchCriteria) {
		ValidatePromoResponse validatePromoResponse = new ValidatePromoResponse();

		Y_Bapi_Validate_Promo_Code_Input bapiInput = new Y_Bapi_Validate_Promo_Code_Input();

		// Set the IM application info structures
		bapiInput.setIm_St_Appli_Info(this.prepareIMApplicationInfo());

		// Prepare Input structures
		this.prepareInput(searchCriteria, bapiInput);

		// Execute the BAPI
		Y_Bapi_Validate_Promo_Code_Output bapiOutput = (Y_Bapi_Validate_Promo_Code_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Validate_Promo_Code", bapiInput);

		// Process the response of the BAPI
		this.processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				validatePromoResponse);

		return validatePromoResponse;
	}

	/**
	 * Method to prepare the input structures for Proimo code validation
	 * 
	 * @param searchCriteria
	 * @param bapiInput
	 * 
	 * @see
	 * @since
	 */
	private void prepareInput(SearchCriteria searchCriteria,
			Y_Bapi_Validate_Promo_Code_Input bapiInput) {
		bapiInput.setIm_Promo_Code(searchCriteria.getPromoCode());
		if (searchCriteria.getDepartureDate() != null) {
			bapiInput.setIm_Departure_Date(new java.sql.Date(searchCriteria
					.getDepartureDate().getTime()));
		}
		bapiInput.setIm_Gateway(searchCriteria.getGateway());
		if (searchCriteria.getDestinationOptions() != null
				&& searchCriteria.getDestinationOptions().size() > 0) {
			DestinationOptions destinationOptions = (DestinationOptions) searchCriteria
					.getDestinationOptions().get(0);
			bapiInput.setIm_Destination(destinationOptions.getDestination());
			bapiInput.setIm_Duration("" + destinationOptions.getNoOfNights());
		}
	}
}
