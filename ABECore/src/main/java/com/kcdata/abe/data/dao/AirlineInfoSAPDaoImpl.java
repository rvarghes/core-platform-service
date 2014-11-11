/*
 * AirlineInfoSAPDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jul 09, 2009  dmahanth
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Input;
import com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output;
import com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType;
import com.kcdata.abe.business.response.AirlineInfoResponse;
import com.kcdata.abe.data.dto.AirlineInfo;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for airline information
 * 
 * @author dmahanth
 * @version
 * 
 * 
 * @see
 * @since
 */
public class AirlineInfoSAPDaoImpl extends ABESAPDaoBase implements
		AirlineInfoDao {

	ABELogger logger = ABELogger.getLogger(AirlineInfoSAPDaoImpl.class);

	/**
	 * Implementation to retrieve airline info
	 * 
	 * @return airline info response
	 * 
	 * @see
	 * @since
	 */
	
	public AirlineInfoResponse retrieveAirlineInfo(String airlineCode) 
	{
		AirlineInfoResponse airlineResponse = new AirlineInfoResponse();
		AirlineInfo airlineInfo = new AirlineInfo();

		Z_Api_Prd_Airline_Info_Input bapiInput = new Z_Api_Prd_Airline_Info_Input();
		bapiInput.setAirlinecode(airlineCode);

		// execute the BAPI
		Z_Api_Prd_Airline_Info_Output bapiOutput = (Z_Api_Prd_Airline_Info_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Z_Api_Prd_Airline_Info", bapiInput);

		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.getReturn(), airlineResponse);

		//Return response in case of any business errors
		if (airlineResponse.isBusinessErrorOccurred())
			return airlineResponse;

		Zapi_Prd_Airline_InfoType infoType = bapiOutput.getAirlineinfo();

		if (infoType != null) {
			airlineInfo.setAirlineCode(airlineCode);
			airlineInfo.setAirlineEstablished(infoType.getAirlineestablished());
			airlineInfo.setAirlineName(infoType.getAirlinename());
			airlineInfo.setChildCarSeat(infoType.getChildcarseat());

			if (!(infoType.getExtrabaggagecost().equals("")))
				airlineInfo.setExtraBaggageCost(infoType.getExtrabaggagecost());
			else
				airlineInfo.setExtraBaggageCost("");

			airlineInfo.setFireArmsAndWeapons(infoType.getFirearmsweapon());
			airlineInfo.setGoldenAppleInflightServices(infoType
					.getGoldenappleserv());
			airlineInfo.setGolfClubs(infoType.getGolfclubs());
			airlineInfo.setHandicapInformation(infoType
					.getHandicapinformation());
			airlineInfo.setLostBaggageNo(infoType.getLostbaggagenumber());
			airlineInfo.setOxygen(infoType.getOxygen());
			airlineInfo.setScubaEquipment(infoType.getScubaequipment());
			airlineInfo.setSeatBeltExtension(infoType.getSeatbeltextension());
			airlineInfo.setSpecialMealRequest(infoType.getSpecialmealrequest());
			airlineInfo.setSurfBoard(infoType.getSurfboard());
			airlineInfo.setPhoneNo(infoType.getTelephonenumber());
			airlineInfo.setWeddingGown(infoType.getWeddinggown());
			airlineInfo.setWheelChair(infoType.getWheelchrair());
			airlineInfo.setBicycles(infoType.getBicycles());
			airlineInfo.setCarryOnBaggage(infoType.getCarryonbaggage());
			airlineInfo.setCheckedBaggage(infoType.getCheckedbaggage());
			airlineInfo.setPets(infoType.getPets());
			airlineInfo.setHeadQuarters(infoType.getHeadquarters());
			airlineInfo.setAirlineType(infoType.getAircrafttype());
		} else {
			// Unable to retrieve airline information
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_AIRLINE_INFO_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_AIRLINE_INFO_ERROR", null, null));
			airlineResponse.saveBusinessError(businessError);
		}

		// Set airline info to response
		airlineResponse.setAirlineInfo(airlineInfo);
		return airlineResponse;
	}
}