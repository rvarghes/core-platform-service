package com.kcdata.abe.data.dao;


import java.util.Map;

import com.kcdata.abe.business.request.HotelsRequest;
import com.kcdata.abe.business.response.AllPriceBreakUpResponse;
import com.kcdata.abe.business.response.HotelsResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.framework.dao.ABEDao;

public interface WesbHotelDao extends ABEDao {
	public HotelsResponse retrieveWesbHotels(HotelsRequest hotelsRequest,Map<String,HBSiHotelInfo> hbsiHotelsList);
	
	public AllPriceBreakUpResponse retrievePriceBreakUp(Hotel hotel);
}