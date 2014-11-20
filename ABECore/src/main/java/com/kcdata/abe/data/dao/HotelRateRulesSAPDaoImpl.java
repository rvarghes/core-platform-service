/*
 * HotelRateRulesSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Apr 25, 2009  nvittal
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.Calendar;

import com.kcdata.abe.bapi.Y_Bapi_Htl_Farerules_Input;
import com.kcdata.abe.bapi.Y_Bapi_Htl_Farerules_Output;
import com.kcdata.abe.bapi.Yst_Htl_FarerulesType;
import com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType;
import com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType;
import com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List;
import com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List;
import com.kcdata.abe.business.response.HotelRateRulesResponse;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.RateRule;
import com.kcdata.abe.data.dto.RoomPrice;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for hotel direct rate rules retrieval
 * 
 * @author nvittal
 * @version
 * 
 * @see
 * @since
 */
/**
 * TODO: Please insert a description of what this file does.
 * TODO: Please insert a description of Class related use cases.
 *
 * @author nvittal
 * @version
 *
 *
 * @see
 * @since
 */
public class HotelRateRulesSAPDaoImpl extends ABESAPDaoBase implements HotelRateRulesDao {

	ABELogger logger = ABELogger.getLogger(HotelRateRulesSAPDaoImpl.class);

	/**
	 * Implementation to retrieve hotel direct rate rules
	 * 
	 * @return fare rules response
	 * 
	 * @see
	 * @since
	 */
	public HotelRateRulesResponse retrieveRateRules(Hotel hotel) {

		HotelRateRulesResponse rateRulesResponse = new HotelRateRulesResponse();

		Y_Bapi_Htl_Farerules_Input bapiInput = new Y_Bapi_Htl_Farerules_Input();
		
		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());
		
		this.prepareRateRuleRequest(bapiInput, hotel);
		
		// execute the BAPI
		Y_Bapi_Htl_Farerules_Output bapiOutput = (Y_Bapi_Htl_Farerules_Output) this
				.getBapiExecutionManager().executeBAPI("Y_Bapi_Htl_Farerules",
						bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				rateRulesResponse);

		// Return response in case of any business errors
		if (rateRulesResponse.isBusinessErrorOccurred())
			return rateRulesResponse;
		
		this.prepareRateRuleResponse(bapiOutput, hotel);

		// Set fare rules to response
		rateRulesResponse.setHotel(hotel);
		return rateRulesResponse;
	}

	/**
	 * Method prepares hotel rate rules request options
	 *
	 * @param bapiInput
	 * @param hotel
	 *
	 * @see
	 * @since
	 */
	private void prepareRateRuleRequest(Y_Bapi_Htl_Farerules_Input bapiInput,
			Hotel hotel) {
		// Set hotel rate rules request
		Yst_Ws_Hotel_Dir_Rat_Rule_ReqType rateRuleRequest = new Yst_Ws_Hotel_Dir_Rat_Rule_ReqType();
		rateRuleRequest.setHotel_Code(hotel.getGdsHotelCode());
		rateRuleRequest.setHotel_Vendor(hotel.getHotelChain());
		rateRuleRequest.setNbr_Paying_People("1");
		rateRuleRequest.setNbr_Of_Rooms(""+hotel.getSearchCriteria().getHotelsRequest().getHotelOptions().getNoOfRooms());

		// Set check in, check out dates
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hotel.getCheckInDate());
		rateRuleRequest.setHtl_In_Date(new java.sql.Date(calendar.getTime().getTime()));

		calendar.setTime(hotel.getCheckOutDate());
		rateRuleRequest.setHtl_Out_Date(new java.sql.Date(calendar.getTime().getTime()));
		
		bapiInput.setIm_Htl_Rtrule_Req(rateRuleRequest);
		
		Yst_Htl_Room_Code_CatType_List roomCategoryList = new Yst_Htl_Room_Code_CatType_List();
		for(RoomPrice roomPrice: hotel.getSelectedRooms()) {
			Yst_Htl_Room_Code_CatType roomCodeCategory = new Yst_Htl_Room_Code_CatType();
			roomCodeCategory.setRoom_Id(""+roomPrice.getRoomCategoryId());
			roomCodeCategory.setRoomtypecode(hotel.getRoomCatgoryById(roomPrice.getRoomCategoryId()).getRoomTypeCode());
			roomCategoryList.add(roomCodeCategory);
		}
		bapiInput.setIt_Htl_Rm_Code_Cat(roomCategoryList);		
	}

	/**
	 * Method parses bapi output and prepares rate rule response
	 *
	 * @param bapiOutput
	 * @param hotel
	 *
	 * @see
	 * @since
	 */
	private void prepareRateRuleResponse(
			Y_Bapi_Htl_Farerules_Output bapiOutput, Hotel hotel) {
		// Prepare fare rules list
		Yst_Htl_FarerulesType_List bpRateRulesList = bapiOutput
				.get_as_listIt_Farerules();

		if (bpRateRulesList != null && !bpRateRulesList.isEmpty()) {
			for(Yst_Htl_FarerulesType hotelRateRule: bpRateRulesList.toArrayYst_Htl_FarerulesType()) {
				int roomCatId = new Integer(hotelRateRule.getRoom_Id()).intValue();
				RateRule rateRule = new RateRule(hotelRateRule.getText());
				hotel.getRoomCatgoryById(roomCatId).appendRateRule(rateRule);
			} //End of rate rules loop
		} //End of rate rule condition
	}
	
}