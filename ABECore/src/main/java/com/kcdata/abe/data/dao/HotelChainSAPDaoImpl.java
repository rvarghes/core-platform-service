/*
 * HotelChainSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Nov 09, 2010  Kishore Madugula
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Input;
import com.kcdata.abe.bapi.Y_Bapi_Hotel_Info_By_Dest_Output;
import com.kcdata.abe.bapi.Yst_Htl_ChainType;
import com.kcdata.abe.bapi.util.Yst_Htl_ChainType_List;
import com.kcdata.abe.business.response.HotelChainResponse;
import com.kcdata.abe.data.dto.HotelChain;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for hotel chain retrieval
 * 
 * @author kmadugul
 * @version
 * 
 * 
 * @see
 * @since
 */
public class HotelChainSAPDaoImpl extends ABESAPDaoBase implements
		HotelChainDao {

	ABELogger logger = ABELogger.getLogger(HotelChainSAPDaoImpl.class);

	/**
	 * Implementation to retrieve hotel chain list
	 * 
	 * @return hotel chain response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	
	public HotelChainResponse retrieveHotelChain(String destination) 
	{

		HotelChainResponse hotelChainResponse = new HotelChainResponse();

		Y_Bapi_Hotel_Info_By_Dest_Input bapiInput = new Y_Bapi_Hotel_Info_By_Dest_Input();
		bapiInput.setIm_Dest(destination);

		// execute the BAPI
		Y_Bapi_Hotel_Info_By_Dest_Output bapiOutput = (Y_Bapi_Hotel_Info_By_Dest_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Hotel_Info_By_Dest",	bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(), hotelChainResponse);

		//Return response in case of any business errors
		if(hotelChainResponse.isBusinessErrorOccurred())
			return hotelChainResponse;
		
		// Prepare hotel chain list
		 Yst_Htl_ChainType_List get_as_listIt_Hl_Chain = bapiOutput.get_as_listIt_Hl_Chain();
		// Prepare hotel code,name list for future purpose
		// Yst_Htl_DataType_List get_as_listIt_Htl_Info = bapiOutput.get_as_listIt_Htl_Info();
		if (get_as_listIt_Hl_Chain != null && !get_as_listIt_Hl_Chain.isEmpty()) 
		{
			Iterator<Yst_Htl_ChainType> itHotelChainList = get_as_listIt_Hl_Chain.iterator();
			ArrayList<HotelChain> hotelChainList = new ArrayList<HotelChain>();			
			while (itHotelChainList.hasNext()) 
			{
				Yst_Htl_ChainType hotelChainRow = itHotelChainList.next();
				if (hotelChainRow != null) 
				{
					HotelChain hotelChain = new HotelChain();				
					hotelChain.setHotelChainCode(hotelChainRow.getHotel_Chain());
					hotelChain.setHotelChainName(hotelChainRow.getHotel_Chain());						
					hotelChainList.add(hotelChain);										
				}
			} // End of gateway while

			// Set hotel chain to response			
			hotelChainResponse.setHotelChain(hotelChainList);
		} else 
		{
			// Unable to retrieve hotel chain information
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_HOTEL_CHAIN_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_HOTEL_CHAIN_ERROR", null, null));
			hotelChainResponse.saveBusinessError(businessError);
		}
		//in future if search depends on hotel code and name uncomment
		/*if (get_as_listIt_Htl_Info != null && !get_as_listIt_Htl_Info.isEmpty()) 
		{
			Iterator<Yst_Htl_DataType> itHotelDataList = get_as_listIt_Htl_Info.iterator();
			ArrayList<Hotel> hotelList = new ArrayList<Hotel>();			
			while (itHotelDataList.hasNext()) 
			{
				Yst_Htl_DataType hotelDataRow = itHotelDataList.next();
				if (hotelDataRow != null) 
				{
					Hotel hotel = new Hotel();				
					hotel.setHotelCode(hotelDataRow.getHotel_Code());
					hotel.setHotelName(hotelDataRow.getName());						
					hotelList.add(hotel);										
				}
			} // End of gateway while			
		}*/
		return hotelChainResponse;
	}

	
}