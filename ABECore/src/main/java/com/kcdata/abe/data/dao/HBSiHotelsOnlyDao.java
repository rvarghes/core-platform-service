package com.kcdata.abe.data.dao;


import java.util.Map;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.dao.ABEDao;

public interface HBSiHotelsOnlyDao extends ABEDao {
	public HotelsResponse retrieveWesbHotels(Itinerary itinerary, Hotel hotel,HotelsRequest hotelsRequest,Map<String, HBSiHotelInfo> hbsiHotelList,String availibilitySource);
		
}