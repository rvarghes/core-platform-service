/*
 * GatewayDestinationsDaoImpl.java
 * Copyright 2009 KCDATA Technologies, Inc. All rights reserved.
 ******************************************************************************
 *                     M A I N T E N A N C E    L O G
 ******************************************************************************
 * DATE          PROGRAMMER   DESCRIPTION
 * ------------  -----------  -------------------------------------------------
 * Jun 16, 2009  nvittal
 * Sep 24, 2009	 hguntupa	  Changes for IMApplicationInfo
 ******************************************************************************
 */

package com.kcdata.abe.data.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.StopWatch;

import com.kcdata.abe.bapi.Y_Bapi_Get_Gateway_Dest_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Gateway_Dest_Output;
import com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Input;
import com.kcdata.abe.bapi.Y_Bapi_Get_Nearby_Airports_Output;
import com.kcdata.abe.bapi.Ynearby_AirportType;
import com.kcdata.abe.bapi.Yst_LocinfoType;
import com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Input;
import com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Output;
import com.kcdata.abe.bapi.Zcharter_CityType;
import com.kcdata.abe.bapi.util.Ynearby_AirportType_List;
import com.kcdata.abe.bapi.util.Yst_LocinfoType_List;
import com.kcdata.abe.bapi.util.Zcharter_CityType_List;
import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.data.dto.Destination;
import com.kcdata.abe.data.dto.Gateway;
import com.kcdata.abe.data.dto.NearbyAirport;
import com.kcdata.abe.data.dto.NearbyGateway;
import com.kcdata.abe.framework.dao.ABESAPDaoBase;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.logging.ABELogger;

/**
 * DAO implementation class for gateway destination retrieval
 * 
 * @author nvittal
 * @version
 * 
 * 
 * @see
 * @since
 */
public class GatewayDestinationsSAPDaoImpl extends ABESAPDaoBase implements
		GatewayDestinationsDao {

	ABELogger logger = ABELogger.getLogger(GatewayDestinationsSAPDaoImpl.class);
	
	/**
	 * List to maintain the valid charter gateway pairs
	 */
	private List<String> validCharterPairs;	
	private Properties countryCodeDescription;
	private Map<String, String> gatewayDestNameMap;
	private GatewayDestinationsResponse gtwyDestnResponse=null;

	public Properties getCountryCodeDescription() {
		return countryCodeDescription;
	}

	public void setCountryCodeDescription(Properties countryCodeDescription) {
		this.countryCodeDescription = countryCodeDescription;
	}

	/**
	 * Implementation to retrieve gateway, destination, nearby airport list
	 * 
	 * @return gateway destinations response
	 * 
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public GatewayDestinationsResponse retrieveGatewayDestinations() {
		 //Execute the bapi only when gatewayDestination response is null
		if(gtwyDestnResponse==null)
		{
		 gtwyDestnResponse = new GatewayDestinationsResponse();

		Y_Bapi_Get_Gateway_Dest_Input bapiInput = new Y_Bapi_Get_Gateway_Dest_Input();

		// Prepare & set application info object to input
		bapiInput.setIm_Application_Info(prepareIMApplicationInfo());
		
		// execute the BAPI
		Y_Bapi_Get_Gateway_Dest_Output bapiOutput = (Y_Bapi_Get_Gateway_Dest_Output) this
				.getBapiExecutionManager().executeBAPI(
						"Y_Bapi_Get_Gateway_Dest", bapiInput);
		
		// Check for any errors or warnings in BAPI execution
		processWarningsErrors(bapiOutput.get_as_listIt_Return(),
				gtwyDestnResponse);

		// Return response in case of any business errors
		if (gtwyDestnResponse.isBusinessErrorOccurred())
			return gtwyDestnResponse;

		// Prepare gateway list
		Yst_LocinfoType_List bpGatewayList = bapiOutput
				.get_as_listIt_Gateways();
		if (bpGatewayList != null && !bpGatewayList.isEmpty()) {
			gatewayDestNameMap = new HashMap<String, String>();
			Iterator<Yst_LocinfoType> itGateway = bpGatewayList.iterator();
			ArrayList<Gateway> gatewayList = new ArrayList<Gateway>();
			
			while (itGateway.hasNext()) {
				Yst_LocinfoType gatewayObj = itGateway.next();
				// Gateway list
				if (gatewayObj != null) {
					Gateway gateway = new Gateway();
					gateway.setAirportCode(gatewayObj.getLocid());
					gateway.setAirportName(gatewayObj.getName());
					gateway.setCityName(gatewayObj.getName());
					gateway.setCountryCode(gatewayObj.getCountry());
					gateway.setLanguageCode(gatewayObj.getSpras());
					gateway.setStateCode(gatewayObj.getRegion());
					gateway.setCountryDescription(countryCodeDescription.getProperty(gateway.getCountryCode()));
					gatewayList.add(gateway);
					//Add Airport code and city name to map
					gatewayDestNameMap.put(gatewayObj.getLocid(), gatewayObj.getName());
				}
			} // End of gateway while
			
			// Set gateway list to response
			gtwyDestnResponse.setGatewayList(gatewayList);
		} else {
			// Unable to retrieve gateways, set business error
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_GATEWAYS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_GATEWAYS_ERROR", null, null));
			gtwyDestnResponse.saveBusinessError(businessError);
		}

		// Prepare destination list
		Yst_LocinfoType_List bpDestinationList = bapiOutput
				.get_as_listIt_Destinations();
		if (bpDestinationList != null && !bpDestinationList.isEmpty()) {
			Iterator<Yst_LocinfoType> itDestination = bpDestinationList
					.iterator();
			ArrayList<Destination> destinationList = new ArrayList<Destination>();
			
			while (itDestination.hasNext()) {
				Yst_LocinfoType destinationObj = itDestination.next();

				// Destination list
				if (destinationObj != null) {
					Destination destination = new Destination();
					destination.setAirportCode(destinationObj.getLocid());
					destination.setAirportName(destinationObj.getName());
					destination.setCityName(destinationObj.getName());
					destination.setCountryCode(destinationObj.getCountry());
					destination.setLanguageCode(destinationObj.getSpras());
					destination.setStateCode(destinationObj.getRegion());
					destination.setCountryDescription(countryCodeDescription.getProperty(destination.getCountryCode()));
					// Set indicator flags
					if (destinationObj.getAir_Dest_Ind() != null
							&& "X".equalsIgnoreCase(destinationObj
									.getAir_Dest_Ind())) {
						destination.setAirDestination(true);
					}
					if (destinationObj.getHtl_Dest_Ind() != null
							&& "X".equalsIgnoreCase(destinationObj
									.getHtl_Dest_Ind())) {
						destination.setHotelDestination(true);
					}
					if (destinationObj.getVeh_Dest_Ind() != null
							&& "X".equalsIgnoreCase(destinationObj
									.getVeh_Dest_Ind())) {
						destination.setVehicleDestination(true);
					}
					destinationList.add(destination);
					//Add destination code and name in map
					gatewayDestNameMap.put(destinationObj.getLocid(), destinationObj.getName());
				}
			} // End of gateway while
			
			
			// Set destination list to response
			gtwyDestnResponse.setDestinationList(destinationList);
		} else {
			// Unable to retrieve destinations
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_DESTINATIONS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_DESTINATIONS_ERROR", null, null));
			gtwyDestnResponse.saveBusinessError(businessError);
		}

		// Prepare nearby airport list for gateway & destination
		Ynearby_AirportType_List bpAirportList = bapiOutput
				.get_as_listIt_Nearby_Airport();
		if (bpAirportList != null && !bpAirportList.isEmpty()) {
			ArrayList<Destination> destinationList = (ArrayList<Destination>) gtwyDestnResponse
					.getDestinationList();
			ArrayList<Gateway> gatewayList = (ArrayList<Gateway>) gtwyDestnResponse
					.getGatewayList();
			Iterator<Ynearby_AirportType> itAirport = bpAirportList.iterator();
			// Iterate nearby airport list
			while (itAirport.hasNext()) {
				Ynearby_AirportType airportObj = itAirport.next();

				if (airportObj != null) {
					String gtwyDestnCode = airportObj.getAirport_Code();
					String airportCode = airportObj.getNearby_Code();
					// Check if this is a gateway nearby airport
					if (gatewayList != null) {
						Gateway gtwy = new Gateway();
						gtwy.setAirportCode(gtwyDestnCode);
						int index = gatewayList.indexOf(gtwy);
						if (index != -1) {
							Gateway gateway = gatewayList.get(index);
							ArrayList<String> nearbyAirports = (ArrayList<String>) gateway
									.getNearbyAirports();
							if (nearbyAirports == null)
								nearbyAirports = new ArrayList<String>();
							nearbyAirports.add(airportCode);
							gateway.setNearbyAirports(nearbyAirports);
							gatewayList.set(index, gateway);
						}
					} // End of nearby gateway
					// Check if this is a destination nearby airport
					if (destinationList != null) {
						Destination destn = new Destination();
						destn.setAirportCode(gtwyDestnCode);
						int index = destinationList.indexOf(destn);
						if (index != -1) {
							Destination destination = destinationList
									.get(index);
							ArrayList<String> nearbyAirports = (ArrayList<String>) destination
									.getNearbyAirports();
							if (nearbyAirports == null)
								nearbyAirports = new ArrayList<String>();
							nearbyAirports.add(airportCode);
							destination.setNearbyAirports(nearbyAirports);
							destinationList.set(index, destination);
						}
					} // End of nearby destination
				}
			} // End of Nearby Airport while
			gtwyDestnResponse.setGatewayList(gatewayList);
			gtwyDestnResponse.setDestinationList(destinationList);
		} // End of nearby If
		else {
			// Unable to retrieve nearby airport data
			ABEBusinessError businessError = new ABEBusinessError();
			businessError.setErrorCode("RETRIEVE_NEARBYAIRPORTS_ERROR");
			businessError.setErrorDescription(this.getMessageSource()
					.getMessage("RETRIEVE_NEARBYAIRPORTS_ERROR", null, null));
			gtwyDestnResponse.saveBusinessError(businessError);
		}
		//Add populated list to response
		gtwyDestnResponse.setGatewayDestCodeAndNameMap(gatewayDestNameMap);
		}
		return gtwyDestnResponse;
	}
	
	/**
	 * Method to check whether charters are offered for the given gateway and destination
	 *
	 * @param gateway
	 * @param destination
	 * @return
	 *
	 * @see
	 * @since
	 */
	@SuppressWarnings("unchecked")
	public boolean isCharterOfferedGatewayDestination(String gateway, String destination) {
		if(validCharterPairs == null) {
			// Populate the validCharterPairs and then validate
			
			// Prepare input
			Z_Get_City_Pair_For_Charter_Input bapiInput = new Z_Get_City_Pair_For_Charter_Input();
			
			// Execute the BAPI
			Z_Get_City_Pair_For_Charter_Output bapiOutput = (Z_Get_City_Pair_For_Charter_Output) this
					.getBapiExecutionManager().executeBAPI(
							"Z_Get_City_Pair_For_Charter", bapiInput);
			
			// Check whether Gateway and destinations are retrieved
			if(bapiOutput.get_as_listIt_Chrtr_Out() != null && bapiOutput.get_as_listIt_Chrtr_Out().size() > 0) {
				validCharterPairs = new ArrayList<String>();
				Zcharter_CityType_List charterList = bapiOutput.get_as_listIt_Chrtr_Out();
				Iterator<Zcharter_CityType> iterator = charterList.iterator();
				while(iterator.hasNext()) {
					Zcharter_CityType charterPair = iterator.next();
					validCharterPairs.add(charterPair.getZgateway() + "#" + charterPair.getZdestination());
				}
			}
		}
		if(validCharterPairs != null) {
			return validCharterPairs.contains(gateway + "#" + destination);
		}
		return false;
	}
	
	/**
	 * 
	 */

	public List<NearbyGateway> getNearByGateways(String gateway,
			String gateWayRange) {
		
		final List<NearbyGateway> getwaysList = new ArrayList<NearbyGateway>();
		
		// Prepare input
		
		Y_Bapi_Get_Nearby_Airports_Input nearby_Airport_Input = new Y_Bapi_Get_Nearby_Airports_Input();
		nearby_Airport_Input.setIm_Application_Info(prepareIMApplicationInfo());
		nearby_Airport_Input.setIm_Miles(new Short(gateWayRange));
		nearby_Airport_Input.setIm_Gate_Dest(gateway);		
		nearby_Airport_Input.setIm_Type_Gd("G");
		
		
		// Execute the BAPI
		Y_Bapi_Get_Nearby_Airports_Output nearby_Airport_Output = (Y_Bapi_Get_Nearby_Airports_Output) this.
		getBapiExecutionManager().executeBAPI("Y_Bapi_Get_Nearby_Airports", nearby_Airport_Input);
		
		if( (null != nearby_Airport_Output) && ( nearby_Airport_Output.get_as_listTi_Ynearby_Airport().size() > 0)){
			Ynearby_AirportType_List airportType_List = nearby_Airport_Output.get_as_listTi_Ynearby_Airport();	
			for (Iterator iterator = airportType_List.iterator(); iterator
					.hasNext();) {
				NearbyGateway nearbyGateway = new NearbyGateway();
				Ynearby_AirportType  airportType = (Ynearby_AirportType) iterator.next();
				nearbyGateway.setGatewayCode(airportType.getAirport_Code());
				nearbyGateway.setNearbyGatewayCode(airportType.getNearby_Code());
				nearbyGateway.setDistanceFromGateway(Short.toString(airportType.getMiles()));
				getwaysList.add(nearbyGateway);								
			}	
		}	
		// Returning data				
		return getwaysList;
	}
}

