/***
 * 
 * Class used for fixing support Fix #3535943
 * 
 * 
 */

package com.kcdata.abe.business.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.core.task.AsyncTaskExecutor;

import com.kcdata.abe.business.request.FlightsRequest;
import com.kcdata.abe.business.request.PackagesRequest;
import com.kcdata.abe.business.request.PricingRequest;
import com.kcdata.abe.business.response.BookingSearchResponse;
import com.kcdata.abe.business.response.FlightsResponse;
import com.kcdata.abe.business.response.ItineraryPricingResponse;
import com.kcdata.abe.business.response.PackagesResponse;
import com.kcdata.abe.data.dao.threads.PricingThreadDao;
import com.kcdata.abe.data.dto.GroupedTripFlight;
import com.kcdata.abe.data.dto.GuestInfo;
import com.kcdata.abe.data.dto.Itinerary;
import com.kcdata.abe.data.dto.Occupancy;
import com.kcdata.abe.data.dto.Package;
import com.kcdata.abe.data.dto.Passenger;
import com.kcdata.abe.data.dto.RoomCategory;
import com.kcdata.abe.data.dto.TripFlight;
import com.kcdata.abe.data.factory.PricingDaoFactory;
import com.kcdata.abe.framework.errorhandling.exception.ABEBusinessError;
import com.kcdata.abe.framework.errorhandling.exception.ABESystemException;
import com.kcdata.abe.framework.logging.ABELogger;
import com.kcdata.abe.framework.response.ABEResponse;
import com.kcdata.abe.framework.service.ABEServiceBase;
import com.kcdata.abe.framework.util.ABEConstants;
import com.rits.cloning.Cloner;


public class PricingThreadServiceImpl extends ABEServiceBase 
	implements PricingThreadService{

	ABELogger logger = ABELogger.getLogger(PricingThreadServiceImpl.class);
	/**
	 * Task executor for executing the threads
	 */
	private AsyncTaskExecutor taskExecutor;


	private PricingDaoFactory pricingDaoFactory;
	
	private BookingSearchService bookingSearchService;
	
	public List<GroupedTripFlight> createItineraryForFlightOnlyPricingOnFirstInstance(
			List<GroupedTripFlight> groupedTripFlightList,
			FlightsResponse flightsResponse,FlightsRequest flightsRequest, Itinerary itin) {

		Map<String, PricingThreadDao> pricingThreadDaoMap = new TreeMap<String, PricingThreadDao>();
		Map<String, Future<ABEResponse>> futureMap = new TreeMap<String, Future<ABEResponse>>();
		Map<String, Itinerary> tripFlightRequestMap = new TreeMap<String, Itinerary>();
		int counter = 1 ;
		for(int index = 0; index < 10 && index < groupedTripFlightList.size() ; index++){
			GroupedTripFlight groupedTripFlight = groupedTripFlightList.get(index);
			List<TripFlight> tripFlightList = groupedTripFlight.getTripFlights();
			for(TripFlight tripFlight : tripFlightList){
					Itinerary itinerary = new Itinerary();
					if(flightsRequest.getBookingNo()!=null){
						BookingSearchResponse searchResponse = bookingSearchService.retrieveBooking(flightsRequest.getBookingNo());
						itinerary = searchResponse.getItinerary();
						itinerary = createItineraryFlightOnlyFirstInstance(tripFlight,itinerary);
					}
					else{
						itinerary = itin;
						itinerary = createItineraryFlightOnlyOtherInstance(tripFlight,itinerary);
					}
				PricingThreadDao pricingDao = (PricingThreadDao) pricingDaoFactory.createPricingThreadDao();
				pricingDao.setApplicationContext(this
						.getApplicationContextFactory().getApplicationContext());
				PricingRequest pricingRequest = new PricingRequest();
				Future<ABEResponse> pricingFuture = null;
				pricingRequest.setItinerary(itinerary);
				pricingDao.setAbeRequest(pricingRequest);
				tripFlightRequestMap.put("Req_#"+(counter), pricingRequest.getItinerary());
				pricingThreadDaoMap.put("PricingDao_#"+(counter), pricingDao);
				pricingFuture = taskExecutor.submit(pricingDao);
				futureMap.put("FuturePricing_#"+(counter),pricingFuture);
				itinerary = null;
				counter++;
			}
			
		}
		
		return updateTripFlightPackagePrice(groupedTripFlightList,futureMap,tripFlightRequestMap,counter);
	}
	public List<GroupedTripFlight> createItineraryForFlightOnlyPricingOnOtherInstance(List<GroupedTripFlight> groupedTripFlightList, Itinerary itinerary)
	{
		Map<String, PricingThreadDao> pricingThreadDaoMap = new TreeMap<String, PricingThreadDao>();
		Map<String, Future<ABEResponse>> futureMap = new TreeMap<String, Future<ABEResponse>>();
		Map<String, Itinerary> tripFlightRequestMap = new TreeMap<String, Itinerary>();
		int counter = 1 ;
		for(int index = 0; index < 10 && index < groupedTripFlightList.size() ; index++){
			GroupedTripFlight groupedTripFlight = groupedTripFlightList.get(index);
			List<TripFlight> tripFlightList = groupedTripFlight.getTripFlights();
			for(TripFlight tripFlight : tripFlightList){
				PricingThreadDao pricingDao = (PricingThreadDao) pricingDaoFactory.createPricingThreadDao();
				pricingDao.setApplicationContext(this
						.getApplicationContextFactory().getApplicationContext());
				PricingRequest pricingRequest = new PricingRequest();
				itinerary = createItineraryFlightOnlyOtherInstance(tripFlight,itinerary);
				Future<ABEResponse> pricingFuture = null;
				pricingRequest.setItinerary(itinerary);
				pricingDao.setAbeRequest(pricingRequest);
				tripFlightRequestMap.put("Req_#"+(counter), pricingRequest.getItinerary());
				pricingThreadDaoMap.put("PricingDao_#"+(counter), pricingDao);
				pricingFuture = taskExecutor.submit(pricingDao);
				futureMap.put("FuturePricing_#"+(counter),pricingFuture);
				counter++;
			}
			
		}
		
		return updateTripFlightPackagePrice(groupedTripFlightList,futureMap,tripFlightRequestMap,counter);
	
	}

	/**
	 * @return the taskExecutor
	 */
	public AsyncTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	/**
	 * @param taskExecutor the taskExecutor to set
	 */
	public void setTaskExecutor(AsyncTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}


	/**
	 * @return the pricingDaoFactory
	 */
	public PricingDaoFactory getPricingDaoFactory() {
		return pricingDaoFactory;
	}

	/**
	 * @param pricingDaoFactory the pricingDaoFactory to set
	 */
	public void setPricingDaoFactory(PricingDaoFactory pricingDaoFactory) {
		this.pricingDaoFactory = pricingDaoFactory;
	}
	
	public List<GroupedTripFlight> createItineraryForPricingOnOtherInstance(List<GroupedTripFlight> groupedTripFlightList, Itinerary itinerary) {
		if(itinerary != null){
			Map<String, PricingThreadDao> pricingThreadDaoMap = new TreeMap<String, PricingThreadDao>();
			Map<String, Future<ABEResponse>> futureMap = new TreeMap<String, Future<ABEResponse>>();
			Map<String, Itinerary> tripFlightRequestMap = new TreeMap<String, Itinerary>();
			int counter = 1 ;
			for(int index = 0; index < 10 && index < groupedTripFlightList.size(); index++){
				GroupedTripFlight groupedTripFlight = groupedTripFlightList.get(index);
				List<TripFlight> tripFlightList = groupedTripFlight.getTripFlights();
				for(TripFlight tripFlight : tripFlightList){
					PricingThreadDao pricingDao = (PricingThreadDao) pricingDaoFactory.createPricingThreadDao();
					pricingDao.setApplicationContext(this
							.getApplicationContextFactory().getApplicationContext());
					PricingRequest pricingRequest = new PricingRequest();
					itinerary = createItineraryOtherInstance(tripFlight,itinerary);
					Future<ABEResponse> pricingFuture = null;
					pricingRequest.setItinerary(itinerary);
					pricingDao.setAbeRequest(pricingRequest);
					tripFlightRequestMap.put("Req_#"+(counter), pricingRequest.getItinerary());
					pricingThreadDaoMap.put("PricingDao_#"+(counter), pricingDao);
					pricingFuture = taskExecutor.submit(pricingDao);
					futureMap.put("FuturePricing_#"+(counter),pricingFuture);
					counter++;
				}
				
			}
			return updateTripFlightPackagePrice(groupedTripFlightList,futureMap,tripFlightRequestMap,counter);
		}
		else{
		}
		
		return null;
	}
	
	
	
	public List<GroupedTripFlight> createItineraryForPricingOnFirstInstance(
			List<GroupedTripFlight> groupedTripFlightList, PackagesResponse packagesResponse, PackagesRequest packagesRequest) {
		Map<String, PricingThreadDao> pricingThreadDaoMap = new TreeMap<String, PricingThreadDao>();
		Map<String, Future<ABEResponse>> futureMap = new TreeMap<String, Future<ABEResponse>>();
		Map<String, Itinerary> tripFlightRequestMap = new TreeMap<String, Itinerary>();
		int counter = 1 ;
		for(int index = 0; index < 10 && index < groupedTripFlightList.size(); index++){
			GroupedTripFlight groupedTripFlight = groupedTripFlightList.get(index);
			List<TripFlight> tripFlightList = groupedTripFlight.getTripFlights();
			for(TripFlight tripFlight : tripFlightList){
				PricingThreadDao pricingDao = (PricingThreadDao) pricingDaoFactory.createPricingThreadDao();
				pricingDao.setApplicationContext(this
						.getApplicationContextFactory().getApplicationContext());
				PricingRequest pricingRequest = new PricingRequest();
				Itinerary itinerary = new Itinerary();
				itinerary = createItineraryFirstInstance(tripFlight,packagesResponse,packagesRequest,itinerary);
				Future<ABEResponse> pricingFuture = null;
				pricingRequest.setItinerary(itinerary);
				pricingDao.setAbeRequest(pricingRequest);
				tripFlightRequestMap.put("Req_#"+(counter), pricingRequest.getItinerary());
				pricingThreadDaoMap.put("PricingDao_#"+(counter), pricingDao);
				pricingFuture = taskExecutor.submit(pricingDao);
				futureMap.put("FuturePricing_#"+(counter),pricingFuture);
				counter++;
			}
			
		}
		
		return updateTripFlightPackagePrice(groupedTripFlightList,futureMap,tripFlightRequestMap,counter);
		
	}
	
	private  List<GroupedTripFlight> updateGroupedTripFlight(ItineraryPricingResponse itinResponse, List<GroupedTripFlight>groupedTripFlightList){

		TripFlight tripFlightFromItinResponse = null;
		if(itinResponse.getItinerary().getPackages()!=null && itinResponse.getItinerary().getPackages().size()>0)
			tripFlightFromItinResponse = itinResponse.getItinerary().getPackages().get(0).getSelectedFlight();
		else
			tripFlightFromItinResponse = itinResponse.getItinerary().getFlights().get(0);
		int counter = 0 ;
		for(GroupedTripFlight grpdTripFlight : groupedTripFlightList){
			if(tripFlightFromItinResponse.getFlightIdForInternalUse().
					equalsIgnoreCase(grpdTripFlight.getFlightId()))
				{	
					for(TripFlight flight : grpdTripFlight.getTripFlights())
					{
						if(tripFlightFromItinResponse.getFlightClassForInternalUse().
								equalsIgnoreCase(flight.getFlightClassForInternalUse()))
						{
							if(itinResponse.getBusinessErrors()!=null && itinResponse.getBusinessErrors().size()>0){
								counter++;
								
								/*---issue# 3621763(Rapid re-pricing) Start-----*/
									if(itinResponse.getItinerary().getBookingHeader()!=null && 
												("PIF").equalsIgnoreCase(itinResponse.getItinerary().getBookingHeader().getBookingStatus().toString()))
										{
											for(GuestInfo guest: itinResponse.getItinerary().getGuests())
											{
												if(("TKT").equalsIgnoreCase(guest.getStatus()))
												{
													if (null != itinResponse.getBusinessErrors().get(0).getErrorCode() &&
															itinResponse.getBusinessErrors().get(0).getErrorCode().equalsIgnoreCase(ABEConstants.RAPID_REPRICE_ERROR_CODE)){
														flight.setPackagePriceSet(true);
														break;
													}
												}
											}
										}
									
								/*---Issue# 3621763 End -----*/
									
								System.out.println("GTF Error Type is" + grpdTripFlight.getFlightTypeStr());
								System.out.println("GTF Error SIZE is" + grpdTripFlight.getTripFlights().size());
								System.out.println("GTF Error loc is" + counter);
								System.out.println("GTF Price is" + flight.getFlightClassForInternalUse());
								System.out.println("GTF Price is" + flight.getFlightIdForInternalUse());
								break;
							}
							else{
								if(itinResponse.getItinerary().getPackages()!=null && itinResponse.getItinerary().getPackages().size()>0){
									flight.setPackagePrice(itinResponse.getItinerary().getPackages().get(0).getPrice().getPackagePrice());
									flight.setPackagePriceSet(true);
								}
								else{
									flight.setFlightPriceAfterPricing(itinResponse.getItinerary().getFlights().get(0).getPrice().getOccpancyBasedPrice());
									flight.setPackagePriceSet(true);
								}
								counter++;
								System.out.println("GTF Price Type is" + grpdTripFlight.getFlightTypeStr());
								System.out.println("GTF Price SIZE is" + grpdTripFlight.getTripFlights().size());
								System.out.println("GTF Price loc is" + counter);
								System.out.println("GTF Price is" + flight.getPackagePrice());
								System.out.println("GTF Price is" + flight.getFlightPriceAfterPricing());
								System.out.println("GTF Price is" + flight.getFlightClassForInternalUse());
								System.out.println("GTF Price is" + flight.getFlightIdForInternalUse());
								break;
							}
						}
					}
					grpdTripFlight.setPackagePriced(true);
					break;
				}
		}
		
		return groupedTripFlightList;
	}
	
	private List<GroupedTripFlight> updateTripFlightPackagePrice(List<GroupedTripFlight>groupedTripFlightList,Map<String, Future<ABEResponse>> futureMap,Map<String, Itinerary> tripFlightRequestMap,int noOfFlights){
		
		for(int index = 0; index < noOfFlights-1; index++){
			try{
			ItineraryPricingResponse itinResponse = null;
			Future<ABEResponse> pricingFuture =(Future<ABEResponse>) futureMap.get("FuturePricing_#"+(index+1));
			itinResponse = (ItineraryPricingResponse)pricingFuture.get(30, TimeUnit.SECONDS);
			if(itinResponse !=null){
				groupedTripFlightList =  updateGroupedTripFlight(itinResponse,groupedTripFlightList);
			}
			}catch(RejectedExecutionException reexp){
				reexp.printStackTrace();
			}
			catch(Exception e){
				if(e.getCause() instanceof ABESystemException){
					ItineraryPricingResponse itinResponse = new ItineraryPricingResponse();
					Itinerary itinerary = null; 
					itinerary = tripFlightRequestMap.get("Req_#"+(index+1));
					itinResponse.setItinerary(itinerary);
					List <ABEBusinessError>errorList = new  ArrayList<ABEBusinessError>();
					errorList.add( new ABEBusinessError("PRICING_TIME_EROR",
							e.getMessage()));
					itinResponse.saveBusinessErrors(errorList);
					updateGroupedTripFlight(itinResponse,groupedTripFlightList);
				}
				if(e.getCause() instanceof TimeoutException){
					ItineraryPricingResponse itinResponse = new ItineraryPricingResponse();
					Itinerary itinerary = null; 
					itinerary = tripFlightRequestMap.get("Req_#"+(index+1));
					itinResponse.setItinerary(itinerary);
					List <ABEBusinessError>errorList = new  ArrayList<ABEBusinessError>();
					errorList.add( new ABEBusinessError("PRICING_TIMEOUT_EROR",
							e.getMessage()));
					itinResponse.saveBusinessErrors(errorList);
					updateGroupedTripFlight(itinResponse,groupedTripFlightList);
				}
				
				e.printStackTrace();
			}
		}
		return groupedTripFlightList;
	}
	
	private Itinerary createItineraryFirstInstance(TripFlight flight, PackagesResponse pResponse,
			PackagesRequest packagesRequest,Itinerary itin){
		//Setting new flight in package in Itinerary
		Cloner cloner = new Cloner();
		PackagesResponse packageResponse = cloner.deepClone(pResponse);
		//Set Hotel related fields in packageResponse
		// Setting Hotel NoChange flag
		//Null Check added Mantis 139:Error returned when selecting change departure or return flight
		if(packageResponse.getAvailablePackage().getSelectedHotel()!=null)
			packageResponse.getAvailablePackage().getSelectedHotel().setPackageHotelNoChange(true);
		//Setting posnr in oldposnr
		for(RoomCategory roomcat : packageResponse.getAvailablePackage().getSelectedHotel().getRoomCategories())
		{
			if(roomcat.getPosnr()!=null){
				roomcat.setOldPosnr(roomcat.getPosnr());
				roomcat.setPosnr(null);
			}
		}
		flight.setGuestAllocation(packageResponse.getAvailablePackage().getSelectedFlight().getGuestAllocation());
		//setting negotiatedFareCode in flight
		flight.setNegotiatedFareCode(packageResponse.getAvailablePackage().getSelectedHotel().getDisplayRoomCategory().getRatePlanCode());
		packageResponse.getAvailablePackage().setSelectedFlight(flight);
		//Setting package in Itinerary
		List<Package> availablePackageList = new ArrayList<Package>();
		availablePackageList.add(packageResponse.getAvailablePackage());
		itin.setPackages(availablePackageList);
		//Setting occupancy in itinerary
		List<GuestInfo> guestList = new ArrayList<GuestInfo>();
		Occupancy occupancy = packageResponse.getAvailablePackage().getSearchCriteria().getOccupancy();
		itin.setMaxOccupancy(occupancy);
		//Setting guests in itinerary
		List<Passenger> paxList = occupancy.getPassengers();
		for(Passenger pax : paxList){
			GuestInfo guest = new GuestInfo();
			guest.setAgeCode(pax.getAgeCode());
			guest.setGuestId(String.valueOf(pax.getPaxId()));
			guestList.add(guest);
		}
		itin.setGuests(guestList);
		//Setting search criteria in itinerary
		itin.setSearchCriteria(packageResponse.getAvailablePackage().getSearchCriteria());
		itin.setBookingNo(packagesRequest.getBookingNo());
		return itin;
	}
	
	
	
	private Itinerary createItineraryOtherInstance(TripFlight flight, Itinerary itin){
		//Setting new flight in package in Itinerary
		Cloner cloner = new Cloner();
		Itinerary itinerary = cloner.deepClone(itin);
		itinerary.getPackages().get(0).setSelectedFlight(flight);
		return itinerary;
	}
	
	private Itinerary createItineraryFlightOnlyFirstInstance(TripFlight flight,Itinerary itin){
		//Null Check added Mantis 139:Error returned when selecting change departure or return flight
		if(flight.getOutboundFlight()!=null)
			flight.getOutboundFlight().setOldPosnr(itin.getFlights().get(0).getOutboundFlight().getPosnr());
		if(flight.getInboundFlight()!=null)
			flight.getInboundFlight().setOldPosnr(itin.getFlights().get(0).getInboundFlight().getPosnr());
		flight.setGuestAllocation(itin.getFlights().get(0).getGuestAllocation());
		itin.getFlights().set(0,flight);
		return itin;
	}
	
	private Itinerary createItineraryFlightOnlyOtherInstance(TripFlight flight,Itinerary itin){
		Cloner cloner = new Cloner();
		Itinerary itinerary = cloner.deepClone(itin);
		if(itin.getBookingNo()!=null && !"".equals(itin.getBookingNo())){
			//Null Check added Mantis 139:Error returned when selecting change departure or return flight
			if(flight.getOutboundFlight()!=null)
				flight.getOutboundFlight().setOldPosnr(itin.getFlights().get(0).getOutboundFlight().getPosnr());
			if(flight.getInboundFlight()!=null)
				flight.getInboundFlight().setOldPosnr(itin.getFlights().get(0).getInboundFlight().getPosnr());
			flight.setGuestAllocation(itin.getFlights().get(0).getGuestAllocation());
		}
		itinerary.getFlights().set(0,flight);
		return itinerary;
	}
	
	
	/**
	 * @return the bookingSearchService
	 */
	public BookingSearchService getBookingSearchService() {
		return bookingSearchService;
	}
	/**
	 * @param bookingSearchService the bookingSearchService to set
	 */
	public void setBookingSearchService(BookingSearchService bookingSearchService) {
		this.bookingSearchService = bookingSearchService;
	}
}
