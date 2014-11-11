/**
 * Class used for fixing support Fix #3535943
 * 
 */

package com.kcdata.abe.business.service;

import java.util.List;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.framework.service.ABEService;

public interface PricingThreadService extends ABEService{

	public List<GroupedTripFlight>createItineraryForPricingOnFirstInstance(List<GroupedTripFlight> groupedTripFlightList, PackagesResponse packagesResponse, PackagesRequest packagesRequest);

	public List<GroupedTripFlight>createItineraryForPricingOnOtherInstance(List<GroupedTripFlight> groupedTripFlightList,Itinerary itinerary);

	public List<GroupedTripFlight>createItineraryForFlightOnlyPricingOnFirstInstance(List<GroupedTripFlight> groupedTripFlightList, FlightsResponse flightsResponse, FlightsRequest flightsRequest, Itinerary itin);

	public List<GroupedTripFlight>createItineraryForFlightOnlyPricingOnOtherInstance(List<GroupedTripFlight> groupedTripFlightList,Itinerary itinerary);

}
