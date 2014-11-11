package com.kcdata.abe.data.dao;

import java.util.Map;

import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Itinerary;

/**
 * WESB Services DAO interface
 * @author vhalaki
 *
 */
public interface WesbServicesDao 
{
	/**
	 * Method to retrieve supplements from WESB
	 * 
	 * @param itinerary
	 * @return ServicesResponse
	 */
public ServicesResponse retrieveWESBSupplements(Itinerary itinerary,boolean isHbsi,Map<String,HBSiHotelInfo> hbsiHotelList);
}
