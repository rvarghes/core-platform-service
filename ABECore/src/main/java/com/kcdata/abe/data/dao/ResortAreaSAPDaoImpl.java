/*
 * ResortAreaSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Z_Api_Resort_List_Input;
import com.kcdata.abe.bapi.Z_Api_Resort_List_Output;
import com.kcdata.abe.bapi.ZshcharType;
import com.kcdata.abe.bapi.util.ZshcharType_List;
import com.kcdata.abe.business.response.ResortAreaResponse;
import com.kcdata.abe.data.dto.ResortArea;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for resort area retrieval
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class ResortAreaSAPDaoImpl extends ABESAPDaoBase implements
		ResortAreaDao {

	ABELogger logger = ABELogger.getLogger(ResortAreaSAPDaoImpl.class);

	/**
	 * Implementation to retrieve resort area list
	 * 
	 * @return resort area response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	
	public ResortAreaResponse retrieveResortAreas(String destination) {

		ResortAreaResponse resortAreaResponse = new ResortAreaResponse();

		Z_Api_Resort_List_Input bapiInput = new Z_Api_Resort_List_Input();
		bapiInput.setDesitnation(destination);

		// execute the BAPI
		Z_Api_Resort_List_Output bapiOutput = (Z_Api_Resort_List_Output) this
				.getBapiExecutionManager().executeBAPI("Z_Api_Resort_List",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.getReturn(), resortAreaResponse);

		//Return response in case of any business errors
		if(resortAreaResponse.isBusinessErrorOccurred())
			return resortAreaResponse;
		
		// Prepare resort list
		ZshcharType_List bpResortList = bapiOutput.get_as_listResorts();
		if (bpResortList != null && !bpResortList.isEmpty()) {
			Iterator<ZshcharType> itResortList = bpResortList.iterator();
			ArrayList<ResortArea> resortAreaList = new ArrayList<ResortArea>();
			while (itResortList.hasNext()) {
				ZshcharType resortAreaRow = itResortList.next();
				if (resortAreaRow != null) {
					ResortArea resortArea = new ResortArea();
					resortArea.setResortAreaCode(resortAreaRow.getAtwrt());
					resortArea.setResortAreaName(resortAreaRow.getAtwtb());
					resortAreaList.add(resortArea);
				}
			} // End of gateway while

			// Set resort areas to response
			resortAreaResponse.setResortAreas(resortAreaList);
		} else {
			// Unable to retrieve resort area information
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_RESORT_AREAS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_RESORT_AREAS_ERROR", null, null));
			resortAreaResponse.saveBusinessError(businessError);
		}
		return resortAreaResponse;
	}
}