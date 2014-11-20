package com.kcdata.abe.data.util;

import java.util.ArrayList;
import java.util.List;

import com.kcdata.abe.data.dto.DestinationOptions;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegment;
import com.kcdata.abe.data.dto.FlightTripType;
import com.kcdata.abe.data.dto.SearchCriteria;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.util.DateUtils;
import com.kcdata.sms.data.dto.SMLinkViewInfo;
import com.kcdata.sms.data.dto.SMLinkViewRequest;
import com.kcdata.sms.data.dto.SMLinkViewResponseType;
import com.kcdata.sms.data.dto.SMSearchCriteria;

/**
 * @author sbharti
 * Class having utility methods for seat map
 * availability
 */
public class SeatAvailResponseUtil {

	/**
	 * Method to populate Seat Map Link request from Search Criteria
	 * @return smLinkViewRequestDTO of type SMLinkViewRequest
	 */
	public SMLinkViewRequest populateSmAvailRequest(SearchCriteria searchCriteria, byte daysAhead, byte daysBehind) {
		SMLinkViewRequest smLinkViewRequest = new SMLinkViewRequest();
		List<SMSearchCriteria> smSearchCriteriaList = new ArrayList<SMSearchCriteria>();
		FlightTripType ftTripType = searchCriteria.getFlightTripType();
		setSmSearchCriteria(smSearchCriteriaList, false, searchCriteria, daysAhead, daysBehind);
		if(ftTripType != null && ftTripType.isRoundTrip())
		{
			setSmSearchCriteria(smSearchCriteriaList, true, searchCriteria, daysAhead, daysBehind);
		}
		
		smLinkViewRequest.setSmSearchCriteriaDTOList(smSearchCriteriaList);
		return smLinkViewRequest;
	}
	
	/**
	 * Method to populate SMSearchCriteria request for flight requested
	 * @param smSearchCriteriaList of type List<SMSearchCriteria>
	 * @param isRoundTrip of type  boolean
	 * @param searchCriteria of type SearchCriteria
	 * @param daysAhead of type byte
	 * @param daysBehind of type byte
	 */
	private void setSmSearchCriteria(List<SMSearchCriteria> smSearchCriteriaList, boolean isRoundTrip, SearchCriteria searchCriteria, byte daysAhead, byte daysBehind) {
		SMSearchCriteria smSearchCriteria = new SMSearchCriteria();
		DestinationOptions destOptions = null;
		List<DestinationOptions> destOptionsList = searchCriteria.getDestinationOptions();
		if(destOptionsList != null && destOptionsList.size() >= 0)
		{
			destOptions = (DestinationOptions)destOptionsList.get(0);
		}
		smSearchCriteria.setDaysAhead(daysAhead);
		smSearchCriteria.setDaysBehind(daysBehind);
		if(!isRoundTrip) {
			smSearchCriteria.setOrigin(searchCriteria.getGateway());
			smSearchCriteria.setDestination(destOptions.getDestination());
			smSearchCriteria.setDepartureDate(searchCriteria.getDepartureDate());
		} else {
			smSearchCriteria.setOrigin(destOptions.getDestination());
			smSearchCriteria.setDestination(searchCriteria.getGateway());
			smSearchCriteria.setDepartureDate(searchCriteria.getTripReturnDate());
		}
		smSearchCriteriaList.add(smSearchCriteria);
	}
	
	/**
	 * Method implementation to populate seat map availability
	 * @param linkViewResponseType of type List<SMLinkViewResponseType>
	 * @param tripFlightList of type List<TripFlight>
	 * @param isDefaultLinkShow of type boolean
	 */
	public void populateSeatMapAvailability(List<SMLinkViewResponseType> linkViewResponseType, 
			List<TripFlight> tripFlightList, boolean isDefaultLinkShow, boolean isFlightSearch) {
		if(tripFlightList != null)
		{
			for (TripFlight tripFlight : tripFlightList) {
				if(tripFlight.getFlightType() != null && tripFlight.getFlightType().isCharter())
				{
					Flight outboundFlight = tripFlight.getOutboundFlight();
					Flight inboundFlight = tripFlight.getInboundFlight();
					
					populateAvailabilityForSegments(outboundFlight, linkViewResponseType, outboundFlight.getFlightIdForSeatMap(), isDefaultLinkShow, isFlightSearch);
					if (inboundFlight != null)
					{
						populateAvailabilityForSegments(inboundFlight, linkViewResponseType, inboundFlight.getFlightIdForSeatMap(), isDefaultLinkShow, isFlightSearch);
					}
				}
			}
		}
	}
	
	/**
	 * Method to return SMLinkViewResponseType for corresponding gateway and destination match
	 * @param linkViewResponseType of type List<SMLinkViewResponseType>
	 * @param flightSegment of type FlightSegment
	 * @return linkResponseType of type SMLinkViewResponseType
	 */
	private SMLinkViewResponseType populateLinkResponseType(List<SMLinkViewResponseType> linkViewResponseType, Flight flight, boolean isFlightSearch)
	{
		if(linkViewResponseType != null)
		{
			FlightSegment flightSegment = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
			for (SMLinkViewResponseType linkResponseType : linkViewResponseType) {
				SMSearchCriteria smSearchCriteria = linkResponseType.getSmSearchCriteria();
				if(smSearchCriteria.getOrigin()!=null&& smSearchCriteria.getOrigin().equalsIgnoreCase(flight.getGateway()) &&
						 smSearchCriteria.getDestination()!=null && smSearchCriteria.getDestination().equalsIgnoreCase(flight.getDestination())
						&& (isFlightSearch || smSearchCriteria.getAirlineCode() == null || smSearchCriteria.getAirlineCode().equalsIgnoreCase(flightSegment.getCarrier().getCarrierCode()))
						&& (isFlightSearch || DateUtils.dateDifferenceInDays(smSearchCriteria.getDepartureDate(), flight.getDepartureTime()) == 0)
						&& (isFlightSearch || smSearchCriteria.getRotation() == 0 || ((smSearchCriteria.getRotation() == 99) 
								|| String.valueOf(smSearchCriteria.getRotation()).contains(String.valueOf(flightSegment.getRotation())))))
				{
					return linkResponseType;
				}
			}
		}
		return null;
	}
	
	/**
	 * Method to populate seat map availability at flight segment level
	 * @param flightSegments of type List<FlightSegment>
	 * @param seatMapAvailabilityList of type List<SeatMapAvailableInfo>
	 * @param flightSegId of type String
	 * @param isDefaultLinkShow of type boolean
	 */
	private void populateAvailabilityForSegments(Flight flight, List<SMLinkViewResponseType> linkViewResponseTypeList,
			String flightSegId, boolean isDefaultLinkShow, boolean isFlightSearch)
	{
		SMLinkViewResponseType smLinkViewResponseType;
		if(flight != null)
		{
			FlightSegment flightSegment = flight.getFlightSegments().size() > 0?flight.getFlightSegments().get(0):null;
				if(isDefaultLinkShow)
				{
					flight.setSeatMapAvailable(isDefaultLinkShow);
	
				} else {
					if(linkViewResponseTypeList != null)
					{
						smLinkViewResponseType = populateLinkResponseType(linkViewResponseTypeList, flight, isFlightSearch);
						if(smLinkViewResponseType != null)
						{
							List<SMLinkViewInfo> linkViewInfoList = smLinkViewResponseType.getSmLinkViewInfoList();
							if(linkViewInfoList != null)
							{
								for (SMLinkViewInfo linkViewInfo : linkViewInfoList) {
									if(linkViewInfo != null && linkViewInfo.getAirlineCode().equalsIgnoreCase(flightSegment.getCarrier().getCarrierCode())
											&& (DateUtils.dateDifferenceInDays(flightSegment.getDepartureDate(), linkViewInfo.getDate()) == 0)
											&& linkViewInfo.getOrigin().equalsIgnoreCase(flight.getGateway())
											&& linkViewInfo.getDestination().equalsIgnoreCase(flight.getDestination())
											&& (linkViewInfo.getRotation().contains("99") 
													|| linkViewInfo.getRotation().contains(String.valueOf(flightSegment.getRotation()))))
									{
										flight.setSeatMapAvailable(true);
										flight.setContractId(linkViewInfo.getContractId());
										break;
									}
								}
							}
						}
					}
				}
			
		}
	}
	
}
