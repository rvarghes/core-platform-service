package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Input;
import com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output;
import com.kcdata.abe.bapi.Zcharter_CityType;
import com.kcdata.abe.bapi.util.Zcharter_CityType_List;
import com.kcdata.abe.business.response.CharterGatewayDestinationResponse;
import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.logging.ABELogger;

public class CharterGatewayDestinationsSAPDaoImpl extends ABESAPDaoBase implements CharterGatewayDestinationsDao {

	ABELogger logger = ABELogger.getLogger(GatewayDestinationsSAPDaoImpl.class);

	/**
	 * List to hold the charter gateways.
	 */
	private List<Gateway> charterGatewaysList;

	private CharterGatewayDestinationResponse chrtrGtwyDestnResponse;

	/**
	 * Method to get a list of charter gateways
	 * 
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public CharterGatewayDestinationResponse retrieveCharterGatewayDestinations() {
		if (charterGatewaysList == null) {
			chrtrGtwyDestnResponse = new CharterGatewayDestinationResponse();
			// Prepare input
			Z_Get_City_Pair_For_Charter_Input bapiInput = new Z_Get_City_Pair_For_Charter_Input();

			// Execute the BAPI
			Z_Get_City_Pair_For_Charter_Output bapiOutput = (Z_Get_City_Pair_For_Charter_Output) this.getBapiExecutionManager().executeBAPI("Z_Get_City_Pair_For_Charter", bapiInput);

			// Check whether Gateway and destinations are retrieved
			if (bapiOutput.get_as_listIt_Chrtr_Out() != null && bapiOutput.get_as_listIt_Chrtr_Out().size() > 0) {
				charterGatewaysList = new ArrayList<Gateway>();
				Zcharter_CityType_List charterList = bapiOutput.get_as_listIt_Chrtr_Out();
				Iterator<Zcharter_CityType> iterator = charterList.iterator();
				while (iterator.hasNext()) {
					Zcharter_CityType charterPair = iterator.next();
					Gateway gateway = new Gateway();
					gateway.setAirportCode(charterPair.getZgateway());
					charterGatewaysList.add(gateway);
				}
				if (charterList != null && charterList.size() > 0)
					chrtrGtwyDestnResponse.setGatewayList(charterGatewaysList);
			}
		}
		return chrtrGtwyDestnResponse;
	}

}
