package com.kcdata.abe.data.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.kcdata.abe.business.response.GatewayDestinationsResponse;
import com.kcdata.abe.business.response.ServicesResponse;
import com.kcdata.abe.business.service.GatewayDestinationsService;
import com.kcdata.abe.data.dto.Comment;
import com.kcdata.abe.data.dto.CommentType;
import com.kcdata.abe.data.dto.Flight;
import com.kcdata.abe.data.dto.FlightSegmentUniqueCriteria;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Hotel;
import com.kcdata.abe.data.dto.IMApplicationInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.SeatAllocations;
import com.kcdata.abe.data.dto.SeatMapRequest;
import com.kcdata.abe.data.dto.Service;
import com.kcdata.abe.data.dto.ServiceGroup;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.framework.errorhandling.exception.ABEWarning;
import com.kcdata.abe.framework.util.ABEConstants;
import com.kcdata.abe.framework.util.DateUtils;
import com.kcdata.sms.data.dto.SMAvailPricingResponse;
import com.kcdata.sms.data.dto.SMBookCancRequest;
import com.kcdata.sms.data.dto.SMBookCancRequestType;
import com.kcdata.sms.data.dto.SMBookCancResponse;
import com.kcdata.sms.data.dto.SMBookCancResponseType;
import com.kcdata.sms.data.dto.SMSearchCriteria;
import com.kcdata.sms.data.dto.SeatInfo;
import com.kcdata.sms.data.dto.SmAvailPricingRequest;
import com.kcdata.sms.data.dto.SmAvailPricingRequestType;
import com.kcdata.sms.data.dto.SmAvailPricingResponseType;

/**
 * This Utility class consist methods needed during seat modification,cancellation and booking.
 * @author sverma
 *
 */
public class SeatMapUtils {

	public static final String DATE_FORMAT = "EEE MMM dd HH:mm:ss z yyyy";
	private static Map<String, String> gatewayDestMap;
	
	/**
	 * Method to generate JSON from Object.
	 * @param obj
	 * @return JSON
	 */
	public static String getToJson(Object obj)
	{
		Gson gson = new Gson();
		String jsonString = ABEConstants.BLANK;
		if(obj != null)
		{
			jsonString = gson.toJson(obj);
		}
		return jsonString;
	}

	
	/**
	 * Method to remove seat map service from the services retrieved
	 * @param serviceGroups of type List<ServiceGroup>
	 */
	public static void removeSeatMapServices(List<ServiceGroup> serviceGroups)
	{
		if(serviceGroups != null && serviceGroups.size() > 0)
		{
			for (ServiceGroup serviceGroup : serviceGroups) {
				if(ABEConstants.MISC_SUPPLEMENT_CODE.equalsIgnoreCase(serviceGroup.getCode()))
				{
					List<Service> servicesList = serviceGroup.getServices();
					if(servicesList != null && servicesList.size() > 0)
					{
						List<Service> newServiceList = new ArrayList<Service>();
						for (Service service : servicesList) {
							if(StringUtils.hasText(service.getServiceCode()) 
									&& !(service.getServiceCode().contains(ABEConstants.SEAT_MATERIAL_CODE)))
							{
								newServiceList.add(service);
							}
						}
						serviceGroup.setServices(newServiceList);
					}
				}
			}
		}
	}

	/**
	 * Method to remove seat map service from the services retrieved
	 * @param serviceGroups of type List<ServiceGroup>
	 */
	public static void removeSeatServicesWhileRetrieve(List<Service> servicesList)
	{
		List<Service> newServiceList = new ArrayList<Service>();
		if(servicesList != null && servicesList.size() > 0)
		{
			for (Service service : servicesList) {
				if(StringUtils.hasText(service.getServiceCode()) 
						&& !(service.getServiceCode().contains(ABEConstants.SEAT_MATERIAL_CODE)))
				{
					newServiceList.add(service);
				}
			}
		}
		servicesList.clear();
		servicesList.addAll(newServiceList);
	}

	/**
	 * Method to insert seat selection/modification/deletion comments
	 * @param itin of type Itinerary
	 * @param gatewayDestinationsService of type GatewayDestinationsService
	 * @param gatewayDestMap of type Map<String, String>
	 * @param imApplicationInfo of type IMApplicationInfo
	 * @param isFreshBooking of type boolean
	 * @return commentList of type List<Comment>
	 */
	public static List<Comment> updateComments(Itinerary itin, GatewayDestinationsService gatewayDestinationsService, Map<String, String> gatewayDestMap,
			IMApplicationInfo imApplicationInfo, boolean isFreshBooking, boolean isCancelBooking, List<String> seatMaterialSegIds)
	{
		List<Comment> commentList = new ArrayList<Comment>();
		List<SeatAllocations> seatAllocList = itin.getSeatAllocationList();
		List<TripFlight> tripFlightList =  SeatMapUtils.getTripFlights(itin);
		if(seatAllocList != null && seatAllocList.size() > 0 &&
				tripFlightList != null && tripFlightList.size() > 0)
		{
			for (SeatAllocations seatAlloc : seatAllocList) {
				if(isCancelBooking || seatMaterialSegIds.contains(seatAlloc.getSegmentID().substring(0, 6))) {
					boolean matchFound = false;
					for (TripFlight tripFlight : tripFlightList) {
						Flight outBoundFlight = tripFlight.getOutboundFlight();
						Flight inBoundFlight = tripFlight.getInboundFlight();
						if(outBoundFlight != null)
						{
							matchFound = populateCommentForFlight(itin, commentList, outBoundFlight, seatAlloc, imApplicationInfo,
									gatewayDestinationsService, isFreshBooking, isCancelBooking);
							if(matchFound)
								break;
						}
						if(inBoundFlight != null)
						{
							matchFound = populateCommentForFlight(itin, commentList, inBoundFlight, seatAlloc, imApplicationInfo,
									gatewayDestinationsService, isFreshBooking, isCancelBooking);
							if(matchFound)
								break;
						}
					}
				}
			}
		}
		return commentList;
	}

	/**
	 * Method to calculate comments to be inserted during seat selection/modification/remove
	 * @param commentList of type List<Comment>
	 * @param flight of type Flight
	 * @param seatAlloc of type SeatAllocations
	 * @param bookingNo of type String
	 * @param imApplicationInfo of type IMApplicationInfo
	 * @param bookingHdr of type BookingHeader
	 * @param gatewayDestinationsService of type GatewayDestinationsService
	 * @param isFreshBooking of type boolean
	 * @return matchFound of type boolean
	 */
	private static boolean populateCommentForFlight(Itinerary itin, List<Comment> commentList, Flight flight, SeatAllocations seatAlloc,
			IMApplicationInfo imApplicationInfo, GatewayDestinationsService gatewayDestinationsService, boolean isFreshBooking, boolean isCancelBooking)
	{
		boolean matchFound = false;
		String flightSegStartString;
		Comment comment = null;
		String commentType = ABEConstants.BLANK;
		flightSegStartString = flight.getGateway().toUpperCase()+flight.getDestination().toUpperCase(); 
		if(seatAlloc.getSegmentID().startsWith(flightSegStartString))
		{
			matchFound = true;
			String gatewayStr;
			String destinationStr;
			if(gatewayDestMap == null)
			{
				GatewayDestinationsResponse gatewayDestResp = gatewayDestinationsService.retrieveGatewayDestinations();
				gatewayDestMap = gatewayDestResp.getGatewayDestCodeAndNameMap();
			}
			if(gatewayDestMap != null)
			{
				gatewayStr = FlightConvertUtils.retrieveLocationName(flight.getGateway(), gatewayDestMap);
				destinationStr = FlightConvertUtils.retrieveLocationName(flight.getDestination(), gatewayDestMap);
			} else {
				gatewayStr = flight.getGateway();
				destinationStr = flight.getDestination();
			}
			if(isCancelBooking)
			{
				commentType = ABEConstants.REMOVE_SEAT_COMMENT;
			} else {
				commentType = getCommentType(isFreshBooking, seatAlloc);
			}
			if(StringUtils.hasText(commentType)) {
				comment = populateComment(itin, gatewayStr, destinationStr, seatAlloc, imApplicationInfo, commentType, isCancelBooking);
			}
			if(comment != null)
			{
				commentList.add(comment);
			}
		}
		return matchFound;
	}
	
	/**
	 * Method which populates comment type string either comment is for ADD/UPDATE/REMOVE seats
	 * @param isFreshBooking of type boolean
	 * @param seatAlloc of type SeatAllocations
	 * @return commentType of type String
	 */
	private static String getCommentType(boolean isFreshBooking, SeatAllocations seatAlloc)
	{
		String commentType = ABEConstants.BLANK;
		if(!isFreshBooking)
		{
			if(seatAlloc.getSeatNo() != null && seatAlloc.getOldSeatNo() != null)
			{
				if(StringUtils.hasText(seatAlloc.getSeatNo()))
				{
					if(!seatAlloc.getSeatNo().equalsIgnoreCase(seatAlloc.getOldSeatNo()))
					{
						if(StringUtils.hasText(seatAlloc.getOldSeatNo()))
						{
							commentType = ABEConstants.UPDATE_SEAT_COMMENT;
						} else {
							commentType = ABEConstants.ADD_SEAT_COMMENT;
						}
					} 
				} else {
					commentType = ABEConstants.REMOVE_SEAT_COMMENT;
				}
			} else if(seatAlloc.getOldSeatNo() == null && seatAlloc.getSeatNo() != null && StringUtils.hasText(seatAlloc.getSeatNo())) {
				commentType = ABEConstants.ADD_SEAT_COMMENT;
			}
		} else {
			commentType = ABEConstants.ADD_SEAT_COMMENT;
		}
		return commentType;
	}

	/**
	 * Method to populate comment for seat addition, modification or deletion
	 * @param gatewayStr of type String
	 * @param destinationStr of type String
	 * @param seatAlloc of type SeatAllocations
	 * @param bookingNo of type String
	 * @param imApplicationInfo of type IMApplicationInfo
	 * @param bookingHdr of type BookingHeader
	 * @param commentType of type String
	 * @return comment of type Comment
	 */
	private static Comment populateComment(Itinerary itin, String gatewayStr, String destinationStr, SeatAllocations seatAlloc,
			IMApplicationInfo imApplicationInfo, String commentType, boolean isCancelBooking)
	{
		Comment comment = null;
		if(StringUtils.hasText(commentType))
		{
			comment = new Comment();
			String bookingNumber =null;
			if(itin.getBookingHeader()!=null){
				bookingNumber = itin.getBookingHeader().getBookingNo();
			}
			if(StringUtils.hasText(bookingNumber)) {
				comment.setBookingNumber(bookingNumber);
			} else {
				bookingNumber = itin.getBookingNo();
				if(StringUtils.hasText(bookingNumber) && bookingNumber.length() <10) {
					String leadingZeros =ABEConstants.BLANK;
					for(int i=0; i<10-bookingNumber.length(); i++) {
						leadingZeros = leadingZeros.concat(ABEConstants.STRING_ZERO);
					}
					bookingNumber = leadingZeros.concat(bookingNumber);
				}
				comment.setBookingNumber(bookingNumber);
			}
			comment.setCommentType(CommentType.HISTORY);
			if(imApplicationInfo != null)
			{
				comment.setCreatedBy(imApplicationInfo.getCreatedBy());
			}
			if(itin.getBookingHeader() != null)
			{
				comment.setCallcenter(itin.getBookingHeader().getCallCenter());
			}
			comment.setCommentDetails(createCommentString(gatewayStr, destinationStr, seatAlloc, itin.getBookingNo(), commentType, itin.getGuests(), isCancelBooking));
		}
		return comment;
	}

	/**
	 * Method which creates comment string for ADD/UPDATE/Remove seats
	 * @param gatewayStr of type String
	 * @param destinationStr of type String
	 * @param seatAlloc of type SeatAllocations
	 * @param bookingNo of type String
	 * @param commentType of type String
	 * @return commentString of type String
	 */
	public static String createCommentString(String gatewayStr, String destinationStr, SeatAllocations seatAlloc, String bookingNo,
			String commentType, List<GuestInfo> guestInfoList, boolean isCancelBooking)
	{
		StringBuffer commentString = new StringBuffer();
		commentString.append(getPaxName(guestInfoList, seatAlloc.getPaxNo())+ABEConstants.BLANK_SPACE);
		if(ABEConstants.ADD_SEAT_COMMENT.equals(commentType)) {
			commentString
				.append(ABEConstants.SELECTED_SEAT)
				.append(ABEConstants.BLANK_SPACE);
		} else if(ABEConstants.UPDATE_SEAT_COMMENT.equals(commentType)) {
			commentString
				.append(ABEConstants.CHANGED)
				.append(ABEConstants.BLANK_SPACE);
		} else if(ABEConstants.REMOVE_SEAT_COMMENT.equals(commentType)) {
			commentString
				.append(ABEConstants.REMOVED)
				.append(ABEConstants.BLANK_SPACE);
		}
		if(ABEConstants.UPDATE_SEAT_COMMENT.equals(commentType)) {
			commentString
				.append(seatAlloc.getOldSeatNo())
				.append(ABEConstants.BLANK_SPACE);
			commentString.append(ABEConstants.TO+ABEConstants.BLANK_SPACE);
		}
		if(ABEConstants.REMOVE_SEAT_COMMENT.equals(commentType))
		{
			if(StringUtils.hasText(seatAlloc.getSeatNo())) {
				commentString.append(seatAlloc.getSeatNo())
							.append(ABEConstants.BLANK_SPACE);
			} else {
				commentString
					.append(seatAlloc.getOldSeatNo())
							.append(ABEConstants.BLANK_SPACE);
			}
		} else {
			commentString
				.append(seatAlloc.getSeatNo())
				.append(ABEConstants.BLANK_SPACE);
		}
		commentString
			.append(ABEConstants.FROM)
			.append(ABEConstants.BLANK_SPACE);
		commentString
			.append(gatewayStr)
			.append(ABEConstants.BLANK_SPACE);
		commentString
			.append(ABEConstants.TO)
			.append(ABEConstants.BLANK_SPACE)
			.append(destinationStr);
		return commentString.toString();
	}
	
	/**
	 * Method to get pax name from guest info list
	 * @param guestInfoList List<GuestInfo>
	 * @param paxNo String
	 * @return paxName of type String
	 */
	private static String getPaxName(List<GuestInfo> guestInfoList, String paxNo)
	{
		StringBuffer paxName = new StringBuffer();
		if(guestInfoList != null)
		{
			for (GuestInfo guestInfo : guestInfoList) {
				if(StringUtils.hasText(guestInfo.getGuestId()) && StringUtils.hasText(paxNo)
						&& Integer.parseInt(guestInfo.getGuestId()) == Integer.parseInt(paxNo))
				{
					paxName.append(guestInfo.getFirstName())
						.append(ABEConstants.BLANK_SPACE)
						.append(guestInfo.getLastName());
					break;
				}
			}
		}
		return paxName.toString();
	}

	/**
	 * This method is used to create SMAvailRequest from seatMapRequest Collection.	
	 * @param seatMapRequests
	 * @return
	 */
	/*public SMAvailRequest createSeatMapAvailRequest(Collection<SeatMapRequest> seatMapRequests)
	{
		SMAvailRequest smAvailRequest = new SMAvailRequest();
		List<SMSearchCriteria> smSearchCriteria = new ArrayList<SMSearchCriteria>();
		for(SeatMapRequest seatMapRequest : seatMapRequests)
		{
			smSearchCriteria.add(convertSeatMapCriteria(seatMapRequest));
		}
		if(smSearchCriteria.size() > 0)
		{
			smAvailRequest.setSmSearchCriteriaDTO(smSearchCriteria);
		}

		return smAvailRequest;
	}*/
	
	/**
	 * This method is used to create the SMSearchCriteria from seatMapRequest object.
	 * @param seatMapRequest
	 * @return
	 */
	public SMSearchCriteria convertSeatMapCriteria(String seatMapRequestJson)
	{
		Gson gson = new Gson();		
		
		SMSearchCriteria searchCriteria = new SMSearchCriteria();
		
		SeatMapRequest seatMapRequest = gson.fromJson(seatMapRequestJson, SeatMapRequest.class);
		searchCriteria.setAirlineCode(seatMapRequest.getCarrier());
		searchCriteria.setOrigin(seatMapRequest.getGatewayCode());
		searchCriteria.setDestination(seatMapRequest.getDestinationCode());
		searchCriteria.setDepartureDate(DateUtils.getDateInGivenFormat(seatMapRequest.getDate(), DATE_FORMAT));
        if(StringUtils.hasText(seatMapRequest.getRotation())){
		searchCriteria.setRotation(Integer.valueOf(seatMapRequest.getRotation()));
        }
		searchCriteria.setClassType(seatMapRequest.getCabinClass());//F=First, C=Coach, A=All
		if(seatMapRequest.getContractId() != null){
		 searchCriteria.setContractId(seatMapRequest.getContractId());
		}
		searchCriteria.setSegmentId(seatMapRequest.getSegmentId());
//		//searchCriteria.setClassType(seatMapRequest.getCabinClass());//F=First, C=Coach, A=All
		return searchCriteria;
	}
	
	/**
	 * Method to generate criteria for SeatMap Pricing Request.
	 * @param seatAllocationsList
	 * @param map
	 * @return SmAvailPricingRequest
	 */
	
	public  SmAvailPricingRequest generateSmPricingRequest(List<SeatAllocations> seatAllocationsList , Map<String, SMSearchCriteria> map)
	{
		SmAvailPricingRequest availPricingRequest = new SmAvailPricingRequest();
		List<SmAvailPricingRequestType> pricingRequestList = new ArrayList<SmAvailPricingRequestType>();
		SmAvailPricingRequestType availPricingRequestType = null;
		for(SMSearchCriteria criteria : map.values() )
		{
			availPricingRequestType = new SmAvailPricingRequestType();
			availPricingRequestType.setSearchCriteria(criteria);
			List<SeatInfo> seatInfos = new ArrayList<SeatInfo>();
			SeatInfo seatInfo = null;
			for(SeatAllocations seatAllocations : seatAllocationsList)
			{
				if(seatAllocations.isSeatSelected()&& StringUtils.hasText(seatAllocations.getSeatNo())
						&& criteria.getSegmentId().equalsIgnoreCase(seatAllocations.getSegmentID()))
				{
					if(criteria.getSmAvailResponseTime() == null)
					{
						criteria.setSmAvailResponseTime(DateUtils.getDateInGivenFormat(seatAllocations.getAvailResponseDateTime(), DATE_FORMAT));
					}					
					seatInfo = new SeatInfo();
					seatInfo.setSeatNumber(seatAllocations.getSeatNo());
					seatInfos.add(seatInfo);
				}
			}
			if(seatInfos.size() > 0)
			{
				availPricingRequestType.setSeatInfoList(seatInfos);
			}
			if(availPricingRequestType.getSeatInfoList() != null)
			{
				pricingRequestList.add(availPricingRequestType);
			}			
			
		}
		if(pricingRequestList.size() > 0)
		{
			availPricingRequest.setPricingRequestList(pricingRequestList);
		}
		
		
		return availPricingRequest; 
	}
	
	/**
	 * Method-to generate request for Seat Booking and Modify.
	 * @param seatAllocationsList
	 * @param map
	 * @return SMBookCancRequest
	 */
	
	public  SMBookCancRequest generateSmBookModifyRequest(List<SeatAllocations> seatAllocationsList , Map<String, SMSearchCriteria> map, boolean cancel)
	{
		SMBookCancRequest smBookCancRequest = new SMBookCancRequest();
		List<SMBookCancRequestType> bookingRequestList = new ArrayList<SMBookCancRequestType>();
		SMBookCancRequestType smBookCancRequestType = null;
		for(SMSearchCriteria criteria : map.values() )
		{
			smBookCancRequestType = new SMBookCancRequestType();
			smBookCancRequestType.setSearchCriteriaDTO(criteria);
			List<SeatInfo> cancellationList = new ArrayList<SeatInfo>();
			List<SeatInfo> bookingList = new ArrayList<SeatInfo>();
			List<SeatInfo> pricingOnlyList = new ArrayList<SeatInfo>();
			List<SeatInfo> tempCancellationList = new ArrayList<SeatInfo>();
			List<SeatInfo> tempBookingList = new ArrayList<SeatInfo>();
			SeatInfo seatInfo = null;
			for(SeatAllocations seatAllocations : seatAllocationsList)
			{
				
				if(seatAllocations.isSeatSelected()
						&& criteria.getSegmentId().equalsIgnoreCase(seatAllocations.getSegmentID()))
				{
					if(!StringUtils.hasText(smBookCancRequestType.getAircraftCode()))
					{
						smBookCancRequestType.setAircraftCode(seatAllocations.getAircraftCode());
					}
					if(StringUtils.hasText(seatAllocations.getSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getSeatNo());
						tempBookingList.add(seatInfo);
					}
					if(StringUtils.hasText(seatAllocations.getOldSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getOldSeatNo());
						tempCancellationList.add(seatInfo);
					}
							
					if(criteria.getSmAvailResponseTime() == null && StringUtils.hasText(seatAllocations.getAvailResponseDateTime()))
					{
						criteria.setSmAvailResponseTime(DateUtils.getDateInGivenFormat(seatAllocations.getAvailResponseDateTime(), DATE_FORMAT));
					}					
				}
			}
			if(cancel)
			{
				for(SeatInfo tempSeatInfo : tempCancellationList)
				{
					if(tempBookingList == null || !tempBookingList.contains(tempSeatInfo))
					{
						cancellationList.add(tempSeatInfo);
					}
					
				}
			}
			else
			{
				for(SeatInfo tempSeatInfo : tempBookingList)
				{
					if(tempCancellationList != null && tempCancellationList.contains(tempSeatInfo))
					{
						pricingOnlyList.add(tempSeatInfo);
					}
					else
					{
						bookingList.add(tempSeatInfo);
					}
				}
			}
			
			if(bookingList.size() > 0)
			{
				smBookCancRequestType.setBookingList(bookingList);
			}
			if(cancellationList.size() > 0)
			{
				smBookCancRequestType.setCancellationList(cancellationList);
			}
			if(pricingOnlyList.size() > 0)
			{
				smBookCancRequestType.setPricingOnlyList(pricingOnlyList);
			}
			if(smBookCancRequestType != null && (smBookCancRequestType.getBookingList() != null 
					|| smBookCancRequestType.getCancellationList() != null || smBookCancRequestType.getPricingOnlyList() != null))
			{
				bookingRequestList.add(smBookCancRequestType);
			}
		
			
		}
		if(bookingRequestList.size() > 0)
		{
			smBookCancRequest.setBookingRequestTypeDTOList(bookingRequestList);
		}
		
		
		return smBookCancRequest; 
	}
	
	
	
	/**
	 * Create Seat Booking request for SMS
	 * @param seatAllocationsList
	 * @param map
	 * @return
	 */
	public  SMBookCancRequest generateSmBookRequest(List<SeatAllocations> seatAllocationsList , Map<String, SMSearchCriteria> map)
	{
		SMBookCancRequest smBookCancRequest = new SMBookCancRequest();
		List<SMBookCancRequestType> bookingRequestList = new ArrayList<SMBookCancRequestType>();
		SMBookCancRequestType smBookCancRequestType = null;
		for(SMSearchCriteria criteria : map.values() )
		{
			smBookCancRequestType = new SMBookCancRequestType();
			smBookCancRequestType.setSearchCriteriaDTO(criteria);
			List<SeatInfo> bookingList = new ArrayList<SeatInfo>();
			SeatInfo seatInfo = null;
			for(SeatAllocations seatAllocations : seatAllocationsList)
			{
				if(seatAllocations.isSeatSelected()
						&& criteria.getSegmentId().equalsIgnoreCase(seatAllocations.getSegmentID()))
				{
					if(!StringUtils.hasText(smBookCancRequestType.getAircraftCode()))
					{
						smBookCancRequestType.setAircraftCode(seatAllocations.getAircraftCode());
					}
					if(StringUtils.hasText(seatAllocations.getSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getSeatNo());
						bookingList.add(seatInfo);
					}
					if(criteria.getSmAvailResponseTime() == null)
					{
						criteria.setSmAvailResponseTime(DateUtils.getDateInGivenFormat(seatAllocations.getAvailResponseDateTime(), DATE_FORMAT));
					}					
				}
			}
			if(bookingList.size() > 0)
			{
				smBookCancRequestType.setBookingList(bookingList);
			}
			if(smBookCancRequestType != null && (smBookCancRequestType.getBookingList() != null 
					|| smBookCancRequestType.getCancellationList() != null))
			{
				bookingRequestList.add(smBookCancRequestType);
			}
		
			
		}
		if(bookingRequestList.size() > 0)
		{
			smBookCancRequest.setBookingRequestTypeDTOList(bookingRequestList);
		}
		
		
		return smBookCancRequest; 
	}
	/**
	 * Create cancel seat request for SMS
	 * @param seatAllocationsList
	 * @param map
	 * @return
	 */
	public  SMBookCancRequest generateSmCancelRequest(List<SeatAllocations> seatAllocationsList , Map<String, SMSearchCriteria> map)
	{
		SMBookCancRequest smBookCancRequest = new SMBookCancRequest();
		List<SMBookCancRequestType> cancelRequestList = new ArrayList<SMBookCancRequestType>();
		SMBookCancRequestType smBookCancRequestType = null;
		for(SMSearchCriteria criteria : map.values() )
		{
			smBookCancRequestType = new SMBookCancRequestType();
			smBookCancRequestType.setSearchCriteriaDTO(criteria);
			List<SeatInfo> cancellationList = new ArrayList<SeatInfo>();
			SeatInfo seatInfo = null;
			for(SeatAllocations seatAllocations : seatAllocationsList)
			{
				if(seatAllocations.isSeatSelected()
						&& criteria.getSegmentId().equalsIgnoreCase(seatAllocations.getSegmentID()))
				{
					if(StringUtils.hasText(seatAllocations.getOldSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getOldSeatNo());
						cancellationList.add(seatInfo);
					}
							
					if(criteria.getSmAvailResponseTime() == null)
					{
						criteria.setSmAvailResponseTime(DateUtils.getDateInGivenFormat(seatAllocations.getAvailResponseDateTime(), DATE_FORMAT));
					}					
				}
			}
			if(cancellationList.size() > 0)
			{
				smBookCancRequestType.setCancellationList(cancellationList);
			}
			if(smBookCancRequestType != null && smBookCancRequestType.getCancellationList() != null)
			{
				cancelRequestList.add(smBookCancRequestType);
			}
		
			
		}
		if(cancelRequestList.size() > 0)
		{
			smBookCancRequest.setBookingRequestTypeDTOList(cancelRequestList);
		}
		
		
		return smBookCancRequest; 
	}
	
	/**
	 * Method to generate request for Cancel booked seat in case if any error occured in Itineary.
	 * @param seatAllocationsList
	 * @param map
	 * @return SMBookCancRequest
	 */
	
	public  SMBookCancRequest generateRollbackRequest(List<SeatAllocations> seatAllocationsList , Map<String, SMSearchCriteria> map)
	{
		SMBookCancRequest smBookCancRequest = new SMBookCancRequest();
		List<SMBookCancRequestType> bookingRequestList = new ArrayList<SMBookCancRequestType>();
		SMBookCancRequestType smBookCancRequestType = null;
		for(SMSearchCriteria criteria : map.values() )
		{
			smBookCancRequestType = new SMBookCancRequestType();
			smBookCancRequestType.setSearchCriteriaDTO(criteria);
			
			List<SeatInfo> bookingList = new ArrayList<SeatInfo>();
			List<SeatInfo> pricingOnlyList = new ArrayList<SeatInfo>();
			List<SeatInfo> tempCancellationList = new ArrayList<SeatInfo>();
			List<SeatInfo> tempBookingList = new ArrayList<SeatInfo>();
			SeatInfo seatInfo = null;
			for(SeatAllocations seatAllocations : seatAllocationsList)
			{
				
				if(seatAllocations.isSeatSelected()
						&& criteria.getSegmentId().equalsIgnoreCase(seatAllocations.getSegmentID()))
				{
					if(!StringUtils.hasText(smBookCancRequestType.getAircraftCode()))
					{
						smBookCancRequestType.setAircraftCode(seatAllocations.getAircraftCode());
					}
					if(StringUtils.hasText(seatAllocations.getSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getSeatNo());
						tempBookingList.add(seatInfo);
					}
					if(StringUtils.hasText(seatAllocations.getOldSeatNo()))
					{
						seatInfo = new SeatInfo();
						seatInfo.setSeatNumber(seatAllocations.getOldSeatNo());
						tempCancellationList.add(seatInfo);
					}
							
					if(criteria.getSmAvailResponseTime() == null && seatAllocations.getAvailResponseDateTime() != null)
					{
						criteria.setSmAvailResponseTime(DateUtils.getDateInGivenFormat(seatAllocations.getAvailResponseDateTime(), DATE_FORMAT));
					}					
				}
			}
			
			
				for(SeatInfo tempSeatInfo : tempBookingList)
				{
					if(tempCancellationList != null && tempCancellationList.contains(tempSeatInfo))
					{
						pricingOnlyList.add(tempSeatInfo);
					}
					else
					{
						bookingList.add(tempSeatInfo);
					}
				}
			
			
			if(bookingList.size() > 0)//add the booking list to cancel list for roll back
			{
				smBookCancRequestType.setCancellationList(bookingList);
			}
			
			if(smBookCancRequestType.getCancellationList() != null)
			{
				bookingRequestList.add(smBookCancRequestType);
			}
		
			
		}
		if(bookingRequestList.size() > 0)
		{
			smBookCancRequest.setBookingRequestTypeDTOList(bookingRequestList);
		}
		
		
		return smBookCancRequest; 
	}
	
	/**
	 * Method to generate search criteria for seat Map.
	 * @param itinerary
	 * @return Map<String, SMSearchCriteria>, key segmentId, value search criteria.
	 */
	public  Map<String, SMSearchCriteria> createSearchCriteriaMap(Itinerary itinerary,Itinerary oldItinerary)
	{
		Map<String, SMSearchCriteria> searchCriteriaMap = new HashMap<String, SMSearchCriteria>();	
		SMSearchCriteria searchCriteria = null;
		List<TripFlight> tripFlightList = getTripFlights(itinerary);
		
		if(tripFlightList != null)
		{
			if(oldItinerary != null )
			{
				tripFlightList.addAll( getTripFlights(oldItinerary));
			}
			String isGroupRequest="N";
			if(itinerary!=null && itinerary.getBookingHeader()!=null){
				isGroupRequest="ZGR".equalsIgnoreCase(itinerary.getBookingHeader().getBookingDocumentType())?"Y":"N";
			}
			for(TripFlight flight : tripFlightList)
			{
				if(flight.getOutboundFlight() != null && flight.getOutboundFlight().getFlightSegments() != null
						&& flight.getOutboundFlight().getFlightSegments().size() > 0)
				{
						//String flightSeg = getFlightSegArray(flight.getOutboundFlight().getFlightId(), flightSegment.getGateway()+flightSegment.getDestination());
						searchCriteria = convertSeatMapCriteria(FlightConvertUtils.populateSeatMapRequestJson( flight.getOutboundFlight(),isGroupRequest));
						searchCriteriaMap.put(searchCriteria.getSegmentId(), searchCriteria);
						searchCriteria.setGroupBlockedRequest(isGroupRequest);
					
				}
				if(flight.getInboundFlight() != null && flight.getInboundFlight().getFlightSegments() != null
						&& flight.getInboundFlight().getFlightSegments().size() > 0)
				{
						//String flightSeg = getFlightSegArray(flight.getInboundFlight().getFlightId(), flightSegment.getGateway()+flightSegment.getDestination());
						searchCriteria = convertSeatMapCriteria(FlightConvertUtils.populateSeatMapRequestJson(flight.getInboundFlight(),isGroupRequest));
						searchCriteriaMap.put(searchCriteria.getSegmentId(), searchCriteria);
						searchCriteria.setGroupBlockedRequest(isGroupRequest);
					
				}
			}			
		}
		
		return searchCriteriaMap;
	}
	
	/**
	 * Method to update the seat with price.
	 * @param seatAllocationsList
	 * @param smAvailPricingResponse
	 */
	
	public  void updateWithPricingResponse(List<SeatAllocations> seatAllocationsList, SMAvailPricingResponse smAvailPricingResponse)
	{
		SMSearchCriteria smSearchCriteria = null;
		SeatInfo seatInfo = null;
		if(smAvailPricingResponse != null && smAvailPricingResponse.getPricingResponseType() != null 
				&&  smAvailPricingResponse.getPricingResponseType().size() > 0)
		{
			for(SmAvailPricingResponseType smAvailPricingResponseType : smAvailPricingResponse.getPricingResponseType())
			{
				smSearchCriteria = smAvailPricingResponseType.getSmSearchCriteria();
				for(SeatAllocations seatAllocation : seatAllocationsList)
				{
					if(smSearchCriteria != null && seatAllocation.getSegmentID() != null 
							&& seatAllocation.getSegmentID().equalsIgnoreCase(smSearchCriteria.getSegmentId()))
					{
						seatInfo = extractMatchingSeatInfos(seatAllocation.getSeatNo(), smAvailPricingResponseType.getSeatInfoList());
						if(seatInfo != null)
						{
							seatAllocation.setSeatPrice(seatInfo.getSeatPrice());
							seatAllocation.setSeatCost(seatInfo.getSeatCost());
						}
					}
				}
				
			}
				
		}
	}
	
	/**
	 * Method to check the seat status from Booking Response and update seats(price and booking status) in Itinerary accordingly.
	 * @param seatAllocationsList
	 * @param bookCancResponse
	 * @return
	 */
	
	public  List<String> updateWithBookingResponse(List<SeatAllocations> seatAllocationsList, SMBookCancResponse bookCancResponse ,Itinerary oldItinerary)
	{
		SMSearchCriteria smSearchCriteria = null;
		SimpleDateFormat sdfFormat = new SimpleDateFormat(ABEConstants.SEAT_SELECTED_DATE_FORMAT);
		List<String> errorList = new ArrayList<String>();
		SeatInfo seatInfo = null;
		if(bookCancResponse != null && bookCancResponse.getBookingResponseTypeDTOList() != null 
				&&  bookCancResponse.getBookingResponseTypeDTOList().size() > 0)
		{
			for(SMBookCancResponseType smBookCancResponseType : bookCancResponse.getBookingResponseTypeDTOList())
			{
				smSearchCriteria = smBookCancResponseType.getSmSearchCriteriaDTO();
				Iterator<SeatAllocations> seatIterator = seatAllocationsList.iterator();
				while(seatIterator.hasNext())
				{
					SeatAllocations seatAllocation = seatIterator.next();
					if(smSearchCriteria != null && seatAllocation.getSegmentID() != null 
							&& seatAllocation.getSegmentID().equalsIgnoreCase(smSearchCriteria.getSegmentId()))
					{
						StringBuilder seatNumbersNotBooked = new StringBuilder();
						if(smBookCancResponseType.getErrorList() != null && smBookCancResponseType.getErrorList().size() > 0)
						{
							
							for(SeatAllocations tempSeat : seatAllocationsList)
							{
								if(seatNumbersNotBooked.length() > 0)
								{
									seatNumbersNotBooked.append(",");
								}
								seatNumbersNotBooked.append(tempSeat.getSeatNo());
							}
							removeErrorSeats(seatAllocationsList, smSearchCriteria.getSegmentId(),oldItinerary);
//							seatAllocationsList.clear();
							
						}
						else
						{
							boolean seatchanged = false;
							if(smBookCancResponseType.getPricingOnlyList() != null && smBookCancResponseType.getBookingList() != null)
							{
								smBookCancResponseType.getBookingList().addAll(smBookCancResponseType.getPricingOnlyList());
							}
							seatInfo = extractMatchingSeatInfos(seatAllocation.getSeatNo(),smBookCancResponseType.getBookingList());
							if(seatInfo != null)
							{
								if("HK".equalsIgnoreCase(seatInfo.getSeatStatus()) 
										|| "OC".equalsIgnoreCase(seatInfo.getSeatStatus()))
								{
									if(!seatAllocation.getSeatPrice().equals(seatInfo.getSeatPrice()))
									{
										errorList.add(ABEConstants.SEAT_PRICE_CHANGED);
									}
									seatAllocation.setSelectedDate(sdfFormat.format(smSearchCriteria.getDepartureDate()));
									seatAllocation.setSeatPrice(seatInfo.getSeatPrice());
									seatAllocation.setSeatCost(seatInfo.getSeatCost());
									if("F".equalsIgnoreCase(seatInfo.getCabinClass()))
									{
										seatAllocation.setCabinClass("First");
									}
									else
									{
										seatAllocation.setCabinClass("Coach");
									}
									
									if(seatInfo.getSeatProperties() != null && seatInfo.getSeatProperties().contains("PPP"))
									{
										seatAllocation.setSeatType(ABEConstants.PPP);//To be discussed
									}
									if(seatInfo.getSeatProperties() != null && seatInfo.getSeatProperties().contains("PRM"))
									{
										seatAllocation.setSeatType(ABEConstants.PRM);//To be discussed
									}
								}
								else
								{
									if(seatNumbersNotBooked.length() > 0)
									{
										seatNumbersNotBooked.append(",");
									}
									seatNumbersNotBooked.append(seatAllocation.getSeatNo());
									
									if(oldItinerary != null && oldItinerary.getSeatAllocationList() != null)
									{
										seatchanged = updateSeatAllocations(seatAllocation, seatAllocationsList);
										
									}
									if(!seatchanged)
									{
										seatIterator.remove();
									}
								}
								
							}
							else
							{
//								if(seatNumbersNotBooked.length() > 0)
//								{
//									seatNumbersNotBooked.append(",");
//								}
//								seatNumbersNotBooked.append(seatAllocation.getSeatNo());
//								if(oldItinerary != null && oldItinerary.getSeatAllocationList() != null)
//								{
//									seatchanged = updateSeatAllocations(seatAllocation, seatAllocationsList);
//									
//								}
//								if(!seatchanged)
//								{
//									seatIterator.remove();
//								}
							}
							
							
							/*//Cancel seat status
							if(StringUtils.hasText(seatAllocation.getOldSeatNo()) && !StringUtils.hasText(seatAllocation.getSeatNo()))
							{
								seatInfo = extractMatchingSeatInfos(seatAllocation.getOldSeatNo(),smBookCancResponseType.getCancellationList());
								if(seatInfo != null)
								{
									if("HK".equalsIgnoreCase(seatInfo.getSeatStatus()))
									{
										seatAllocationsList.remove(seatAllocation);
									}
									//TODO if required some other action to be taken
								}								
							}*/
								
						}
						if(seatNumbersNotBooked.length() > 0)
						{
							errorList.add("For flight "+smSearchCriteria.getOrigin()
									+" to"+smSearchCriteria.getDestination()+"Seats " +seatNumbersNotBooked+ " are not bookded");
						}
						
						
					}
				}
				
			}
				
		}
		return errorList;
	}
	
	/**
	 * 	Method to remove the seats in case of any error occured.
	 * @param seatAllocList
	 * @param segmentId
	 */
	
	private void removeErrorSeats(List<SeatAllocations> seatAllocList, String segmentId , Itinerary oldItinerary)
	{
		Iterator<SeatAllocations> seatIterator  = seatAllocList.iterator();
		boolean seatChanged = false;
		boolean oldSeatsPresent = false;
		if(oldItinerary != null && oldItinerary.getSeatAllocationList() != null)
		{
			oldSeatsPresent =true;
		}
		
			
		while (seatIterator.hasNext()) {
			SeatAllocations seatAllocation = seatIterator.next();
			if(seatAllocation.getSegmentID().equalsIgnoreCase(segmentId))
			{
				if(oldSeatsPresent)
				{
					seatChanged = updateSeatAllocations( seatAllocation, oldItinerary.getSeatAllocationList() );
					
				}
				
				if(!seatChanged)//in case old seat is not present for current user
				{
					seatIterator.remove();
				}
				
			}
		}
	}
	/**
	 * extract the matching seat allocation from the list based on pax id and segment id
	 * @param SeatNumber
	 * @param seatInfos
	 * @return
	 */
	public  boolean updateSeatAllocations(SeatAllocations currentSeat, List<SeatAllocations> seatAllocationsList)
	{
		for(SeatAllocations seat : seatAllocationsList)
		{
			if(currentSeat.getSegmentID().equalsIgnoreCase(seat.getSegmentID()) && currentSeat.getPaxNo().equalsIgnoreCase(seat.getPaxNo()))
			{
				/*try {
					//BeanUtils.copyProperties(currentSeat, seat);In case old seat need to bes
					return true;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					
				}*/
				currentSeat.setSeatNo(ABEConstants.BLANK);
			}
			
		}
		return false;
	}
	
	/**
	 * Method to match the seats form SeatInfo object during update the booking.
	 * @param SeatNumber
	 * @param seatInfos
	 * @return
	 */
	
	public  SeatInfo extractMatchingSeatInfos(String SeatNumber , List<SeatInfo> seatInfos)
	{
		if(seatInfos != null)
		{
			for(SeatInfo seatInfo : seatInfos)
			{
				if(seatInfo.getSeatNumber().equalsIgnoreCase(SeatNumber))
				{
					return seatInfo;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Method to remove Seat Allocation list which containing null or blank seat number.
	 * @param seatAllocationList
	 */
	
	public static ABEWarning setSeatChange(List<SeatAllocations> seatAllocationList, List<String> seatMaterialSegIds)
	{
		Iterator< SeatAllocations > it = seatAllocationList.iterator();
		ABEWarning warning = null;
		while(it.hasNext())
		{
			 SeatAllocations seatAllocations = it.next();
			 if(!StringUtils.hasText(seatAllocations.getSeatNo()) || !seatMaterialSegIds.contains(seatAllocations.getSegmentID().substring(0, 6)))
				{
				 it.remove();
				 if(warning == null)
				 {
					 warning = new ABEWarning();
					 warning.setErrorDescription(ABEConstants.SEAT_BOOKING_ERROR);
					 warning.setErrorCode("SEAT");
				 }
				 
				} else {
					seatAllocations.setSeatSelected(ABEConstants.TRUE);
				}
	      }
		return warning;
		
	}
	
	/**
	 * Remove seat selection from request if seats material dose not exist in SAP
	 * @param seatAllocationList
	 * @param seatMaterialSegIds
	 * @return
	 */
	public static ABEWarning removeNonSeatMaterialSeats(List<SeatAllocations> seatAllocationList, List<String> seatMaterialSegIds)
	{
		Iterator< SeatAllocations > it = seatAllocationList.iterator();
		ABEWarning warning = null;
		while(it.hasNext())
		{
			 SeatAllocations seatAllocations = it.next();
			 if(StringUtils.hasText(seatAllocations.getSeatNo()) && !StringUtils.hasText(seatAllocations.getOldSeatNo())
					 && seatAllocations.isSeatSelected()
					 && !seatMaterialSegIds.contains(seatAllocations.getSegmentID().substring(0, 6)))
				{
				 it.remove();
				 if(warning == null)
				 {
					 warning = new ABEWarning();
					 warning.setErrorDescription(ABEConstants.SEAT_BOOKING_ERROR);
					 warning.setErrorCode("SEAT");
				 }
				 
				}
	      }
		return warning;
		
	}

	/**
	 * 
	 * @param flightSegWithDollar
	 * @param matchingString
	 * @return
	 */
	public static String getFlightSegArray(String flightSegWithDollar, String matchingString)
	{
		String flightSeg = ABEConstants.BLANK;
		if(!StringUtils.hasText(flightSeg))
		{
			String[] flightSegArray = flightSegWithDollar.split(ABEConstants.FRONT_SLASH_DOLLAR);
			for (String string : flightSegArray) {
				if(string.contains(matchingString))
				{
					flightSeg = string;
					break;
				}
			}
			
		}
		return flightSeg;
	}
	/**
	 * Method to get the new list of seats during Modification of seats.
	 * @param fullList
	 * @return Map<String ,List<SeatAllocations>>
	 */
	
	public  Map<String ,List<SeatAllocations>> getNewSeatsList(List<SeatAllocations> fullList)
	{
		
		Map<String,List<SeatAllocations>> seatAllocationsMap = new HashMap<String, List<SeatAllocations>>();
		List<SeatAllocations> newSeats = new ArrayList<SeatAllocations>();
		List<SeatAllocations> oldSeats = new ArrayList<SeatAllocations>();
		seatAllocationsMap.put(ABEConstants.OLD_SEATS, oldSeats);
		seatAllocationsMap.put(ABEConstants.NEW_SEATS, newSeats);
		for(SeatAllocations seatAllocations : fullList)
		{
			if(seatAllocations.isSeatSelected())
			{
				newSeats.add(seatAllocations);
			}
			else
			{
				oldSeats.add(seatAllocations);
			}
		}
		
		if(seatAllocationsMap.size() > 0)
		{
			return seatAllocationsMap;
		}
		return null;
	}
	
	/*-------------------------------------------------------------------------*/
	// Varun Edited
	private boolean isSeatSwaped(SeatAllocations sa, List<SeatAllocations> oldSeatList, List<SeatAllocations> oldSeats){
		boolean isSwaped = false; 
		for(SeatAllocations oldSeatAllocations : oldSeatList){
			// Condition added for ABE 11-seats are not rejected when one persons seats are removed.
			if(oldSeatAllocations.getSeatNo()!=null && oldSeatAllocations.getSeatNo().length()>0 && oldSeatAllocations.getSeatNo().equals(sa.getSeatNo())
					&& oldSeatAllocations.getSegmentID().equalsIgnoreCase(sa.getSegmentID())){
				isSwaped = true;
				
				sa.setSeatCost(oldSeatAllocations.getSeatCost());
				if(oldSeatAllocations.getCabinClass()!=null && 
						oldSeatAllocations.getCabinClass().contains(ABEConstants.FIRST_CLASS)){
					sa.setCabinClass(ABEConstants.FIRST_CLASS);
				}
				else{
					sa.setCabinClass(ABEConstants.COACH_CLASS);
				}
				
				if(oldSeatAllocations.getSeatType() != null && 
						oldSeatAllocations.getSeatType().contains(ABEConstants.PPP)){
					sa.setSeatType(ABEConstants.PPP);
				}
				else if(oldSeatAllocations.getSeatType() != null && 
						oldSeatAllocations.getSeatType().contains(ABEConstants.PRM)){
					sa.setSeatType(ABEConstants.PRM);
				}
				else 
					sa.setSeatType("");
				
				oldSeats.add(sa);
				break;
			}
		}
		return isSwaped;
	}
	// Varun edited end
	
	//Method added by Sagar
	/**
	 * Method to get the new list of seats and old seats with their costs, types and cabin classes during Modification of seats.
	 * @param fullList
	 * @param oldList
	 * @return Map<String ,List<SeatAllocations>>
	 */
	
	public  Map<String ,List<SeatAllocations>> getNewSeatsListWithSeatCost(List<SeatAllocations> fullList, List<SeatAllocations> oldList)
	{
		
		Map<String,List<SeatAllocations>> seatAllocationsMap = new HashMap<String, List<SeatAllocations>>();
		List<SeatAllocations> newSeats = new ArrayList<SeatAllocations>();
		List<SeatAllocations> oldSeats = new ArrayList<SeatAllocations>();
		seatAllocationsMap.put(ABEConstants.OLD_SEATS, oldSeats);
		seatAllocationsMap.put(ABEConstants.NEW_SEATS, newSeats);
		for(SeatAllocations seatAllocations : fullList)
		{
			if(seatAllocations.isSeatSelected())
			{
				// Varun edited
				if(this.isSeatSwaped(seatAllocations, oldList, oldSeats)){
					continue;
				}
				// Varun edited end
				newSeats.add(seatAllocations);
			}
			else
			{
				if(oldList!=null && oldList.size()>0){
					for(SeatAllocations oldSeatAllocations : oldList)
					{
						if(oldSeatAllocations.getSeatNo().equals(seatAllocations.getSeatNo())
								&& oldSeatAllocations.getSegmentID().equalsIgnoreCase(seatAllocations.getSegmentID())){
							seatAllocations.setSeatCost(oldSeatAllocations.getSeatCost());
							if(oldSeatAllocations.getCabinClass()!=null && oldSeatAllocations.getCabinClass().contains(ABEConstants.FIRST_CLASS))
							{
								seatAllocations.setCabinClass(ABEConstants.FIRST_CLASS);
							}
							else
							{
								seatAllocations.setCabinClass(ABEConstants.COACH_CLASS);
							}
							
							if(oldSeatAllocations.getSeatType() != null && oldSeatAllocations.getSeatType().contains(ABEConstants.PPP))
							{
								seatAllocations.setSeatType(ABEConstants.PPP);
							}
							else if(oldSeatAllocations.getSeatType() != null && oldSeatAllocations.getSeatType().contains(ABEConstants.PRM))
							{
								seatAllocations.setSeatType(ABEConstants.PRM);
							}
							else 
								seatAllocations.setSeatType("");
							break;
						}
								
					}
				}
				oldSeats.add(seatAllocations);
			}
		}
		
		if(seatAllocationsMap.size() > 0)
		{
			
			return seatAllocationsMap;
		}
		return null;
	}
	
	
	/*-------------------------------------------------------------------------*/
	
	/**
	 * Method to get new Seat Info Map.
	 * @param fullList
	 * @return Map<String, SeatInfoList>
	 */
	public  Map<String ,List<SeatInfo>> getSeatInfoMap(List<SeatAllocations> fullList)
	{
		 Map<String ,List<SeatInfo>> seatInfoMap = new HashMap<String ,List<SeatInfo>>();
		 
		 return seatInfoMap;
	}
	
	/**
	 * Method to validate if Seat booking error occure during booking or seat services are not available
	 * @param warningList of type List<ABEWarning>
	 * @return true/false boolean type
	 */
	public static boolean isSeatWarningMessage(List<ABEWarning> warningList) {
		if(warningList != null)
		{
			for (ABEWarning abeWarning : warningList) {
				if(StringUtils.hasText(abeWarning.getErrorCode()) && "SEAT_SAP".equals(abeWarning.getErrorCode())) {
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Method to get Trip Flights from Itinerary.
	 * @param itinerary
	 * @return List<Trip Flights>
	 */
	
	public static List<TripFlight> getTripFlights(Itinerary itinerary)
	{
		List<TripFlight> tripFlightList = new ArrayList<TripFlight>();
		
		if(itinerary.getFlights() != null)
		{
			tripFlightList.addAll(itinerary.getFlights());
		}
		List<Package> packageList = itinerary.getPackages();
		if(packageList != null) {
			for (Package package1 : packageList) {
				if(package1.getSelectedFlight()!=null)
				tripFlightList.add(package1.getSelectedFlight());
			}
		}
		return tripFlightList;
	}
	
	/**
	 * Method to prepare seat allocation for cancellation of seats
	 * @param itinerary of type Itinerary
	 */
	public static void prepareForItineraryCancellation(Itinerary itinerary)
	{
		if(itinerary.getSeatAllocationList() != null)
		{
			for(SeatAllocations seatAllocations : itinerary.getSeatAllocationList())
			{
				seatAllocations.setOldSeatNo(seatAllocations.getSeatNo());
				seatAllocations.setSeatNo(ABEConstants.BLANK);
				seatAllocations.setSeatSelected(true);
			}
		}
	}

	/**
	 * Method to validate if Seat map service is available for the sector selected or not
	 * @param serviceResponse of type ServicesResponse
	 * @return true/false
	 */
	public static boolean isSeatMapServiceAvailable(ServicesResponse serviceResponse)
	{
		List<ServiceGroup> serviceGroupList = serviceResponse.getSeatServiceGroups();
		if(serviceGroupList != null) {
			for (ServiceGroup serviceGroup : serviceGroupList) {
				List<Service> servicesList = serviceGroup.getServices();
				if(servicesList != null)
				{
					for (Service service : servicesList) {
						if(StringUtils.hasText(service.getServiceCode())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Method to get seat service material segment Id's 
	 * @param serviceResponse of type ServicesResponse
	 * @return segmentIdList of type List<String>
	 */
	public static List<String> getSegmentForSeatServiceAvailability(ServicesResponse serviceResponse) {
		List<ServiceGroup> serviceGroupList = serviceResponse.getSeatServiceGroups();
		List<String> segmentIdList = new ArrayList<String>();
		if(serviceGroupList != null) {
			for (ServiceGroup serviceGroup : serviceGroupList) {
				List<Service> servicesList = serviceGroup.getServices();
				if(servicesList != null)
				{
					for (Service service : servicesList) {
						if(StringUtils.hasText(service.getServiceCode())) {
							segmentIdList.add(service.getServiceCode().substring(0, 6));
						}
					}
				}
			}
		}
		return segmentIdList;
	}
	
	/**
	 * Method to validate if the booking is Group Booking and guest names have been modified or not
	 * If group booking and all names not modified then no seatmap link will be displayed
	 * otherwise on the basis of seatmap availability link will be shown
	 * @param itin of type Itinerary
	 * @return true/false of type boolean
	 */
	public static boolean validateBookingToShowLink(Itinerary itin) {
		if(itin != null && itin.getBookingHeader() != null && StringUtils.hasText(itin.getBookingHeader().getBookingDocumentType())
				&& ABEConstants.GROUP_BOOKING_DOC_TYPE_CODE.equalsIgnoreCase(itin.getBookingHeader().getBookingDocumentType())) {
			List<GuestInfo> guestInfoList = itin.getGuests();
			if(guestInfoList != null) {
				for (GuestInfo guestInfo : guestInfoList) {
					if(StringUtils.hasText(guestInfo.getFirstName()) 
							&& StringUtils.hasText(guestInfo.getLastName()) 
							&& (guestInfo.getFirstName().contains(ABEConstants.GROUP_BOOKING_FIRST_NAME) || guestInfo.getLastName().contains(ABEConstants.GROUP_BOOKING_LAST_NAME))) {
						return ABEConstants.False;
					}
				}
			}
		}
		return ABEConstants.TRUE;
	}

	/**
	 * Method to check if seat information is modified or not (CP case)
	 * @param curSeatAllocList of type List<SeatAllocations>
	 * @param oldSeatAllocList of type List<SeatAllocations>
	 * @param availablePackage of type Package
	 * @return true/false of type boolean
	 */
	public static boolean isSeatInfoModify(List<SeatAllocations> curSeatAllocList, List<SeatAllocations> oldSeatAllocList, Package availablePackage) {
		Flight outFlight = availablePackage.getSelectedFlight().getOutboundFlight();
		Flight inFlight = availablePackage.getSelectedFlight().getInboundFlight();
		List<SeatAllocations> curMatchList = new ArrayList<SeatAllocations>();
		List<SeatAllocations> oldMatchList = new ArrayList<SeatAllocations>();
		boolean matchFound = ABEConstants.False;
		List<String> paxAlloc = new ArrayList<String>();
		populateGuestAllocationList(availablePackage.getSelectedFlight().getGuestAllocation(), paxAlloc);
		
		String flightIdForSeatMap = outFlight.getFlightIdForSeatMap();
		if(StringUtils.hasText(flightIdForSeatMap)) {
			//Outbound flight
			getSeatAllocationsList(flightIdForSeatMap, curSeatAllocList, curMatchList, paxAlloc);
			getSeatAllocationsList(flightIdForSeatMap, oldSeatAllocList, oldMatchList, paxAlloc);
			for (SeatAllocations oldSeatAllocations : oldMatchList) {
				matchFound = ABEConstants.False;
				for (SeatAllocations curSeatAllocations : curMatchList) {
					if(!StringUtils.hasText(curSeatAllocations.getSeatNo())) {
						return ABEConstants.TRUE;	
					}
					if(oldSeatAllocations.getSeatNo().equalsIgnoreCase(curSeatAllocations.getSeatNo())
							&& Integer.parseInt(oldSeatAllocations.getPaxNo()) == Integer.parseInt(curSeatAllocations.getPaxNo())) {
						matchFound = ABEConstants.TRUE;
					}
				}
				if(!matchFound) {
					return ABEConstants.TRUE;
				}
			}
			if(curMatchList.size() != oldMatchList.size()) {
				return ABEConstants.TRUE;
			}
			//Inbound flight
			if(inFlight != null) {
				curMatchList.clear();
				oldMatchList.clear();
				flightIdForSeatMap = inFlight.getFlightIdForSeatMap();
				getSeatAllocationsList(flightIdForSeatMap, curSeatAllocList, curMatchList, paxAlloc);
				getSeatAllocationsList(flightIdForSeatMap, oldSeatAllocList, oldMatchList, paxAlloc);
				for (SeatAllocations oldSeatAllocations : oldMatchList) {
					matchFound = ABEConstants.False;
					for (SeatAllocations curSeatAllocations : curMatchList) {
						if(!StringUtils.hasText(curSeatAllocations.getSeatNo())) {
							return ABEConstants.TRUE;	
						}
						if(oldSeatAllocations.getSeatNo().equalsIgnoreCase(curSeatAllocations.getSeatNo())
								&& Integer.parseInt(oldSeatAllocations.getPaxNo()) == Integer.parseInt(curSeatAllocations.getPaxNo())) {
							matchFound = ABEConstants.TRUE;
						}
					}
					if(!matchFound) {
						return ABEConstants.TRUE;
					}
				}
				if(curMatchList.size() != oldMatchList.size()) {
					return ABEConstants.TRUE;
				}
			}
		}
		
		return ABEConstants.False;
	}
	
	/**
	 * Method to get seat allocation list for the particular segment
	 * @param flightIdForSeatMap of type String
	 * @param seatAllocList of type List<SeatAllocations>
	 * @param seatAllocListMatch of type List<SeatAllocations>
	 */
	public static void getSeatAllocationsList(String flightIdForSeatMap, List<SeatAllocations> seatAllocList,
			List<SeatAllocations> seatAllocListMatch, List<String> paxAlloc) {
		if(seatAllocList != null) {
			for (SeatAllocations seatAllocations : seatAllocList) {
				if(seatAllocations.getSegmentID().equalsIgnoreCase(flightIdForSeatMap) && paxAlloc.contains(String.valueOf(Integer.parseInt(seatAllocations.getPaxNo())))) {
					seatAllocListMatch.add(seatAllocations);
				}
			}
		}
	}
	
	/**
	 * Method to check if hotel is modified for CP case
	 * @param availablePackage of type Package
	 * @return true/false of type boolean
	 */
	public static boolean isHotelModified(Package availablePackage) {
		Hotel hotel = availablePackage.getSelectedHotel();
		if(hotel != null) {
			List<RoomCategory> roomCatList = hotel.getRoomCategories();
			if(roomCatList != null) {
				for (RoomCategory roomCategory : roomCatList) {
					if(roomCategory.getOldPosnr() != null) {
						return ABEConstants.TRUE;
					}
				}
			}
		}
		return ABEConstants.False;
	}

	/**
	 * Method to check if seat is changed or not
	 * @param flightSegUnique of type FlightSegmentUniqueCriteria
	 * @param seatAllocList of type List<SeatAllocations>
	 * @param seatMaterialCode of type String
	 * @return of type String
	 */
	public static String isSeatsChanged(FlightSegmentUniqueCriteria flightSegUnique, List<SeatAllocations> seatAllocList, String seatMaterialCode) {
		String paxAllocation = flightSegUnique.getPaxAllocation();
		List<String> paxAllocList = new ArrayList<String>();
		List<SeatAllocations> curSeatAllocList = new ArrayList<SeatAllocations>();
		List<SeatAllocations> oldSeatAllocList = new ArrayList<SeatAllocations>();
		boolean matchFound = ABEConstants.False;
		if(StringUtils.hasText(paxAllocation)) {
			//Retrieve current selected seats
			populateGuestAllocationList(paxAllocation, paxAllocList);
		}
		getCurrentSeats(flightSegUnique, paxAllocList, flightSegUnique.getSeatAllocationList(), curSeatAllocList, seatMaterialCode, ABEConstants.TRUE);
		
		//get old selected seats in old itinerary
		getCurrentSeats(flightSegUnique, paxAllocList, seatAllocList, oldSeatAllocList, seatMaterialCode, ABEConstants.False);
		
		if(curSeatAllocList.size() == 0 && oldSeatAllocList.size() > 0) {
			return ABEConstants.SEAT_CANCEL;
		} else if (curSeatAllocList.size() > 0 && oldSeatAllocList.size() == 0) {
			return ABEConstants.SEAT_ADD;
		} else if ((curSeatAllocList.size() > oldSeatAllocList.size()) || (curSeatAllocList.size() < oldSeatAllocList.size())) {
			return ABEConstants.SEAT_MODIFY;
		}
		for (SeatAllocations seatAllocationsCur : curSeatAllocList) {
			matchFound = ABEConstants.False;
			for (SeatAllocations seatAllocationsOld : oldSeatAllocList) {
				if(StringUtils.hasText(seatAllocationsCur.getSeatNo()) && (Integer.parseInt(seatAllocationsCur.getPaxNo()) == Integer.parseInt(seatAllocationsOld.getPaxNo()) && (seatAllocationsCur.getSeatNo().equalsIgnoreCase(seatAllocationsOld.getSeatNo())))) {
					matchFound = ABEConstants.TRUE;
				}
			}
			if(!matchFound) {
				return ABEConstants.SEAT_MODIFY;
			}
		}
		return ABEConstants.SEAT_NO_ACTION;
	}
	
	/**
	 * Method to get seats information for particular segment 
	 * @param flightSegUnique of type FlightSegmentUniqueCriteria
	 * @param paxAllocList of type List<String>
	 * @param seatAllocList of type List<SeatAllocations>
	 * @param curSeatSelectedList of type List<SeatAllocations>
	 * @param seatMaterialCode of type String
	 * @param currentSeatAlloc of type boolean
	 */
	public static void getCurrentSeats(FlightSegmentUniqueCriteria flightSegUnique, List<String> paxAllocList,
			List<SeatAllocations> seatAllocList, List<SeatAllocations> curSeatSelectedList, String seatMaterialCode, boolean currentSeatAlloc) {
		String SegId = flightSegUnique.getSegIdConcat();
		String serviceMaterialCode = seatMaterialCode.substring(0, 6);
		if(seatAllocList != null) {
			for (SeatAllocations seatAllocations : seatAllocList) {
				if(seatAllocations.getSegmentID().contains(serviceMaterialCode) && SegId.contains(seatAllocations.getSegmentID()) &&
						paxAllocList.contains(String.valueOf(Integer.parseInt(seatAllocations.getPaxNo())))) {
					if(currentSeatAlloc) {
						if(StringUtils.hasText(seatAllocations.getSeatNo())) {
							curSeatSelectedList.add(seatAllocations);							
						}
					} else {
						curSeatSelectedList.add(seatAllocations);
					}
				}
			}
		}
	}
	
	/** Method to populate guest seat allocation list of type string 
	 * @param paxIdString of type String
	 * @param seatAllocList of type List<String>
	 */
	public static void populateGuestAllocationList(String paxIdString, List<String> seatAllocList) {
		String[] paxIdStringArray = paxIdString.split(ABEConstants.COMMA);
		for (String string : paxIdStringArray) {
			seatAllocList.add(String.valueOf(Integer.parseInt(string)));
		}
	}
}
