package com.kcdata.abe.data.dao;

import java.util.List;
import java.util.Map;

import com.kcdata.abe.business.response.ItineraryResponse;
import com.kcdata.abe.data.dto.HBSiHotelInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.Itinerary;

public interface WesbBookingDao
{
public ItineraryResponse bookHotelItinerary(Itinerary itinerary,boolean isHBSi,Map<String,HBSiHotelInfo> hbsiHoteList);

public ItineraryResponse bookPackageItinerary(Itinerary itinerary,List<Hotel> hbsiHotelList,String bookingNumberSAP);
}
