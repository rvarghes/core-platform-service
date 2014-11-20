/*
 * AgenciesSearchSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Feb 21, 2011  kmadugul
 * 
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Z_Api_Agy_Search_Input;
import com.kcdata.abe.bapi.Z_Api_Agy_Search_Output;
import com.kcdata.abe.bapi.Zapi_Agency_Search1Type;
import com.kcdata.abe.bapi.util.Zapi_Agency_Search1Type_List;
import com.kcdata.abe.business.response.AgenciesSearchResponse;
import com.kcdata.abe.data.dto.Agency;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for fetching agencies search list
 * 
 * @author kmadugul
 * @version
 * 
 * @see
 * @since
 */
public class AgenciesSearchSAPDaoImpl extends ABESAPDaoBase implements
		AgenciesSearchDao {

	ABELogger logger = ABELogger.getLogger(AgenciesSearchSAPDaoImpl.class);

	/**
	 * Implementation to retrieve agency information
	 * 
	 * @return agency response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public AgenciesSearchResponse retrieveAgenciesSearchInfo(Agency agencyInfo) {

		AgenciesSearchResponse agenciesSearchResponse = new AgenciesSearchResponse();
		List<Agency> agenciesList = new ArrayList<Agency>();
		Z_Api_Agy_Search_Input bapiInput = new Z_Api_Agy_Search_Input();
		// set input
		bapiInput.setTravelagencyname(agencyInfo.getName());
		bapiInput.setCity(agencyInfo.getCity());
		bapiInput.setZipcode(agencyInfo.getZipCode());
		bapiInput.setZstate(agencyInfo.getState());
		// execute the BAPI
		Z_Api_Agy_Search_Output bapiOutput = (Z_Api_Agy_Search_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Agy_Search", bapiInput);

		// Check for any errors or warnings in BAPI execution
		 processWarningsErrors(bapiOutput.getReturn(), agenciesSearchResponse);

		// Return response in case of any business errors
		if (agenciesSearchResponse.isBusinessErrorOccurred())
			return agenciesSearchResponse;

		// Parse & Prepare agencies list
		Zapi_Agency_Search1Type_List agenciesInfoList = bapiOutput.get_as_listAgencyinfo();
		Iterator<Zapi_Agency_Search1Type> agenciesSearchTypes = agenciesInfoList.iterator();
		while(agenciesSearchTypes.hasNext())
		{
			Zapi_Agency_Search1Type agencySearchType = agenciesSearchTypes.next();
			Agency agency = new Agency();
			agency.setCustomerNo(agencySearchType.getCustomerno());
			agency.setIataNo(agencySearchType.getIatanumber());
			agency.setName(agencySearchType.getAgencyname());
			agency.setCity(agencySearchType.getCity());	
			agency.setZipCode(agencySearchType.getZipcode());
			agency.setState(agencySearchType.getState());	
			
			agenciesList.add(agency);
		}		
		agenciesSearchResponse.setAgenciesList(agenciesList);
		return agenciesSearchResponse;
	}
}